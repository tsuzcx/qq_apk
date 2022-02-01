package com.tencent.mobileqq.vashealth;

import android.content.Context;
import android.hardware.SensorManager;
import com.tencent.common.app.BaseApplicationImpl;

class SportManager$1
  implements Runnable
{
  SportManager$1(SportManager paramSportManager) {}
  
  public void run()
  {
    if (SportManager.a == null) {
      SportManager.a = (SensorManager)BaseApplicationImpl.getApplication().getApplicationContext().getSystemService("sensor");
    }
    SportManager.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.SportManager.1
 * JD-Core Version:    0.7.0.1
 */