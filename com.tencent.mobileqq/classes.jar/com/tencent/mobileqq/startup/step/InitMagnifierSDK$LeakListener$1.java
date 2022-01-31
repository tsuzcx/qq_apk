package com.tencent.mobileqq.startup.step;

import ajya;
import axoj;
import bcql;
import com.tencent.common.app.BaseApplicationImpl;

public class InitMagnifierSDK$LeakListener$1
  implements Runnable
{
  public InitMagnifierSDK$LeakListener$1(axoj paramaxoj, String paramString) {}
  
  public void run()
  {
    bcql.a(BaseApplicationImpl.sApplication, this.a + ajya.a(2131705795), 2000).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.InitMagnifierSDK.LeakListener.1
 * JD-Core Version:    0.7.0.1
 */