package com.tencent.mobileqq.startup.director;

import bcad;
import com.tencent.mobileqq.startup.step.DtSdkInitStep;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.lazy.LazyInitObserver;

public class StartupDirector$1
  implements Runnable
{
  public StartupDirector$1(bcad parambcad) {}
  
  public void run()
  {
    if (DtSdkInitStep.a())
    {
      LazyInitObserver.getInstance().markToProceed();
      QLog.d("AutoMonitor", 1, "onEndStep, markToProceed");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.director.StartupDirector.1
 * JD-Core Version:    0.7.0.1
 */