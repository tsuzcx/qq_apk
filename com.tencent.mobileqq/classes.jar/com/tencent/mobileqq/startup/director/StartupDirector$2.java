package com.tencent.mobileqq.startup.director;

import aabk;
import akhn;
import axnv;
import axpj;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.startup.step.Step;

public class StartupDirector$2
  implements Runnable
{
  public StartupDirector$2(axnv paramaxnv) {}
  
  public void run()
  {
    ThreadManager.initDPC();
    akhn.a().a();
    if (axnv.d != 0)
    {
      aabk.a().a(axnv.d);
      axnv.d = 0;
    }
    axpj.b(29, this.this$0, null).step();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.director.StartupDirector.2
 * JD-Core Version:    0.7.0.1
 */