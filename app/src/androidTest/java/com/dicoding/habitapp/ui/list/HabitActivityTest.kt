package com.dicoding.habitapp.ui.list

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.dicoding.habitapp.ui.add.AddHabitActivity
import com.dicoding.habitapp.R
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

//TODO 16 : Write UI test to validate when user tap Add Habit (+), the AddHabitActivity displayed
@RunWith(AndroidJUnit4::class)
class HabitActivityTest {

    @Before
    fun setup() {
        ActivityScenario.launch(HabitListActivity::class.java)
        Intents.init()
    }
    @After
    fun destroy(){
        Intents.release()
    }
    @Test
    fun homeActivityTest() {
        val button = Espresso.onView(
            withId(R.id.fab)
        )
        Espresso.onView(withId(R.id.fab)).perform(ViewActions.click())
        Intents.intended(hasComponent(AddHabitActivity::class.java.name))
    }
}