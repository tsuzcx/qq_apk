package com.tencent.mobileqq.startup.step;

import ajya;
import axok;
import bcql;
import com.tencent.common.app.BaseApplicationImpl;

public class InitMagnifierSDKData$LeakListener$1
  implements Runnable
{
  public InitMagnifierSDKData$LeakListener$1(axok paramaxok, String paramString) {}
  
  public void run()
  {
    bcql.a(BaseApplicationImpl.sApplication, this.a + ajya.a(2131705793), 2000).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.InitMagnifierSDKData.LeakListener.1
 * JD-Core Version:    0.7.0.1
 */