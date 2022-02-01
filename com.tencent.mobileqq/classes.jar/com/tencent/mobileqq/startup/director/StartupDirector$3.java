package com.tencent.mobileqq.startup.director;

import acjp;
import anbx;
import bcad;
import bccs;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.startup.step.Step;

public class StartupDirector$3
  implements Runnable
{
  public StartupDirector$3(bcad parambcad) {}
  
  public void run()
  {
    ThreadManager.initDPC();
    anbx.a().a(DeviceProfileManager.a());
    if (bcad.d != 0)
    {
      acjp.a().a(bcad.d);
      bcad.d = 0;
    }
    bccs.b(30, this.this$0, null).step();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.director.StartupDirector.3
 * JD-Core Version:    0.7.0.1
 */