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
    boolean bool = true;
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 0);
    if (BaseApplicationImpl.sProcessId == 1) {}
    for (;;)
    {
      ThreadManager.initDPC(localSharedPreferences, bool);
      ThreadOptimizer.a().a();
      if (StartupDirector.c != 0)
      {
        HardCoderManager.a().a(StartupDirector.c);
        StartupDirector.c = 0;
      }
      Step.AmStepFactory.b(29, this.this$0, null).step();
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.director.StartupDirector.3
 * JD-Core Version:    0.7.0.1
 */