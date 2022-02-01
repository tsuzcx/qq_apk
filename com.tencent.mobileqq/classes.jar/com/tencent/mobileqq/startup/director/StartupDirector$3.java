package com.tencent.mobileqq.startup.director;

import aczy;
import aoem;
import bdgy;
import bdjn;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.startup.step.Step;

public class StartupDirector$3
  implements Runnable
{
  public StartupDirector$3(bdgy parambdgy) {}
  
  public void run()
  {
    ThreadManager.initDPC();
    aoem.a().a(DeviceProfileManager.a());
    if (bdgy.d != 0)
    {
      aczy.a().a(bdgy.d);
      bdgy.d = 0;
    }
    bdjn.b(30, this.this$0, null).step();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.director.StartupDirector.3
 * JD-Core Version:    0.7.0.1
 */