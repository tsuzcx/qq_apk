package com.tencent.mobileqq.startup.director;

import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mm.hardcoder.HardCoderManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.startup.step.Step;
import com.tencent.mobileqq.startup.step.Step.AmStepFactory;
import com.tencent.qqperf.opt.threadpriority.ThreadOptimizer;

class StartupDirector$3
  implements Runnable
{
  StartupDirector$3(StartupDirector paramStartupDirector) {}
  
  public void run()
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 0);
    int i = BaseApplicationImpl.sProcessId;
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    ThreadManager.initDPC(localSharedPreferences, bool);
    ThreadOptimizer.a().a();
    if (StartupDirector.c != 0)
    {
      HardCoderManager.a().a(StartupDirector.c);
      StartupDirector.c = 0;
    }
    Step.AmStepFactory.b(29, this.this$0, null).step();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.startup.director.StartupDirector.3
 * JD-Core Version:    0.7.0.1
 */