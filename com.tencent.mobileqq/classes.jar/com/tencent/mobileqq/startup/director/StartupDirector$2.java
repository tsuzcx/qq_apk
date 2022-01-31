package com.tencent.mobileqq.startup.director;

import absd;
import alzc;
import azjg;
import azkw;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.startup.step.Step;

public class StartupDirector$2
  implements Runnable
{
  public StartupDirector$2(azjg paramazjg) {}
  
  public void run()
  {
    ThreadManager.initDPC();
    alzc.a().a();
    if (azjg.d != 0)
    {
      absd.a().a(azjg.d);
      azjg.d = 0;
    }
    azkw.b(29, this.this$0, null).step();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.director.StartupDirector.2
 * JD-Core Version:    0.7.0.1
 */