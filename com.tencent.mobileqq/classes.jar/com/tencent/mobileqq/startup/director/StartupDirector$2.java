package com.tencent.mobileqq.startup.director;

import ajtd;
import awoa;
import awpm;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.startup.step.Step;
import zrr;

public class StartupDirector$2
  implements Runnable
{
  public StartupDirector$2(awoa paramawoa) {}
  
  public void run()
  {
    ThreadManager.initDPC();
    ajtd.a().a();
    if (awoa.d != 0)
    {
      zrr.a().a(awoa.d);
      awoa.d = 0;
    }
    awpm.b(29, this.this$0, null).step();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.director.StartupDirector.2
 * JD-Core Version:    0.7.0.1
 */