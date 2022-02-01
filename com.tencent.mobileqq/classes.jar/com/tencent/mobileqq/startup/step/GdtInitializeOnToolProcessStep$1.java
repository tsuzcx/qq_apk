package com.tencent.mobileqq.startup.step;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.ipc.GdtIPCManager;

class GdtInitializeOnToolProcessStep$1
  implements Runnable
{
  GdtInitializeOnToolProcessStep$1(GdtInitializeOnToolProcessStep paramGdtInitializeOnToolProcessStep) {}
  
  public void run()
  {
    try
    {
      long l = System.currentTimeMillis();
      GdtIPCManager.a().a(BaseApplicationImpl.getContext());
      GdtInitializeOnToolProcessStep.a("GdtInitializeOnToolProcessStep", "ipc register durationMillis:" + (System.currentTimeMillis() - l), null);
      return;
    }
    catch (Throwable localThrowable)
    {
      GdtInitializeOnToolProcessStep.a("GdtInitializeOnToolProcessStep", "doStep", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.GdtInitializeOnToolProcessStep.1
 * JD-Core Version:    0.7.0.1
 */