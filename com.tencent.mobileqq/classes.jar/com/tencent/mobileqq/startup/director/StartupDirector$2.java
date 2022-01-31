package com.tencent.mobileqq.startup.director;

import abws;
import amdr;
import aznp;
import azpf;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.startup.step.Step;

public class StartupDirector$2
  implements Runnable
{
  public StartupDirector$2(aznp paramaznp) {}
  
  public void run()
  {
    ThreadManager.initDPC();
    amdr.a().a();
    if (aznp.d != 0)
    {
      abws.a().a(aznp.d);
      aznp.d = 0;
    }
    azpf.b(29, this.this$0, null).step();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.director.StartupDirector.2
 * JD-Core Version:    0.7.0.1
 */