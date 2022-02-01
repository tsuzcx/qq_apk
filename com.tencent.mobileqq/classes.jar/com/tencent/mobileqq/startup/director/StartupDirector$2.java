package com.tencent.mobileqq.startup.director;

import admw;
import aoim;
import bdho;
import bdjy;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.startup.step.Step;

public class StartupDirector$2
  implements Runnable
{
  public StartupDirector$2(bdho parambdho) {}
  
  public void run()
  {
    ThreadManager.initDPC();
    aoim.a().a(DeviceProfileManager.a());
    if (bdho.d != 0)
    {
      admw.a().a(bdho.d);
      bdho.d = 0;
    }
    bdjy.b(30, this.this$0, null).step();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.director.StartupDirector.2
 * JD-Core Version:    0.7.0.1
 */