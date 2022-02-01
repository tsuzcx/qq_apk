package com.tencent.mobileqq.vashealth.api.impl;

import android.content.Context;
import android.hardware.SensorManager;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

class SportManagerImpl$1
  implements Runnable
{
  SportManagerImpl$1(SportManagerImpl paramSportManagerImpl) {}
  
  public void run()
  {
    if (SportManagerImpl.sSensorManager == null) {
      SportManagerImpl.sSensorManager = (SensorManager)this.this$0.mApp.getApplication().getApplicationContext().getSystemService("sensor");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.api.impl.SportManagerImpl.1
 * JD-Core Version:    0.7.0.1
 */