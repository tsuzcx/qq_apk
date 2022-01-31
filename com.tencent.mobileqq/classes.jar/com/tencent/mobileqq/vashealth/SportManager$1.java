package com.tencent.mobileqq.vashealth;

import android.content.Context;
import android.hardware.SensorManager;
import bbuw;
import com.tencent.common.app.BaseApplicationImpl;

public class SportManager$1
  implements Runnable
{
  public SportManager$1(bbuw parambbuw) {}
  
  public void run()
  {
    if (bbuw.a == null) {
      bbuw.a = (SensorManager)BaseApplicationImpl.getApplication().getApplicationContext().getSystemService("sensor");
    }
    bbuw.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.SportManager.1
 * JD-Core Version:    0.7.0.1
 */