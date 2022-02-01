package com.tencent.mobileqq.vashealth;

import android.content.Context;
import android.hardware.SensorManager;
import bhwz;
import com.tencent.common.app.BaseApplicationImpl;

public class SportManager$1
  implements Runnable
{
  public SportManager$1(bhwz parambhwz) {}
  
  public void run()
  {
    if (bhwz.a == null) {
      bhwz.a = (SensorManager)BaseApplicationImpl.getApplication().getApplicationContext().getSystemService("sensor");
    }
    bhwz.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.SportManager.1
 * JD-Core Version:    0.7.0.1
 */