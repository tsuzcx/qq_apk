package com.tencent.mobileqq.startup.director;

import addy;
import anwa;
import bcow;
import bcrg;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.startup.step.Step;

public class StartupDirector$2
  implements Runnable
{
  public StartupDirector$2(bcow parambcow) {}
  
  public void run()
  {
    ThreadManager.initDPC();
    anwa.a().a(DeviceProfileManager.a());
    if (bcow.d != 0)
    {
      addy.a().a(bcow.d);
      bcow.d = 0;
    }
    bcrg.b(30, this.this$0, null).step();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.director.StartupDirector.2
 * JD-Core Version:    0.7.0.1
 */