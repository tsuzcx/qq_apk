package com.tencent.mobileqq.startup.step;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.monitor.backgroundcpu.BatteryStats;

class LoadDex$4
  implements Runnable
{
  LoadDex$4(LoadDex paramLoadDex) {}
  
  public void run()
  {
    try
    {
      QQAppInterface.getBatteryStats().a();
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LoadDex", 2, "", localThrowable);
      }
    }
    Step.AmStepFactory.b(29, this.this$0.mDirector, null).step();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.LoadDex.4
 * JD-Core Version:    0.7.0.1
 */