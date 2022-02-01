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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ipc register durationMillis:");
      localStringBuilder.append(System.currentTimeMillis() - l);
      GdtInitializeOnToolProcessStep.a("GdtInitializeOnToolProcessStep", localStringBuilder.toString(), null);
      return;
    }
    catch (Throwable localThrowable)
    {
      GdtInitializeOnToolProcessStep.a("GdtInitializeOnToolProcessStep", "doStep", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.GdtInitializeOnToolProcessStep.1
 * JD-Core Version:    0.7.0.1
 */