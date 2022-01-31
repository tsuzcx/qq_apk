package com.tencent.mobileqq.vashealth;

import android.content.Context;
import android.hardware.SensorManager;
import bduj;
import com.tencent.common.app.BaseApplicationImpl;

public class SportManager$1
  implements Runnable
{
  public SportManager$1(bduj parambduj) {}
  
  public void run()
  {
    if (bduj.a == null) {
      bduj.a = (SensorManager)BaseApplicationImpl.getApplication().getApplicationContext().getSystemService("sensor");
    }
    bduj.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.SportManager.1
 * JD-Core Version:    0.7.0.1
 */