package com.tencent.mobileqq.startup.director;

import aabg;
import akhm;
import axnx;
import axpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.startup.step.Step;

public class StartupDirector$2
  implements Runnable
{
  public StartupDirector$2(axnx paramaxnx) {}
  
  public void run()
  {
    ThreadManager.initDPC();
    akhm.a().a();
    if (axnx.d != 0)
    {
      aabg.a().a(axnx.d);
      axnx.d = 0;
    }
    axpl.b(29, this.this$0, null).step();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.director.StartupDirector.2
 * JD-Core Version:    0.7.0.1
 */