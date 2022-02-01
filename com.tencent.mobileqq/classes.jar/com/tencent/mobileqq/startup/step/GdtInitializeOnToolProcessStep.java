package com.tencent.mobileqq.startup.step;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.api.interstitial.IGdtInterstitialAPI;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

final class GdtInitializeOnToolProcessStep
  extends Step
{
  static void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.i(paramString1, 2, paramString2, paramThrowable);
    }
  }
  
  protected boolean doStep()
  {
    try
    {
      a("GdtInitializeOnToolProcessStep", "doStep", null);
      long l = System.currentTimeMillis();
      ThreadManager.excute(new GdtInitializeOnToolProcessStep.1(this), 16, null, true);
      ((IGdtInterstitialAPI)QRoute.api(IGdtInterstitialAPI.class)).preDownloadAfterToolProcessStartup(BaseApplicationImpl.getContext());
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doStep durationMillis:");
      localStringBuilder.append(System.currentTimeMillis() - l);
      a("GdtInitializeOnToolProcessStep", localStringBuilder.toString(), null);
      return true;
    }
    catch (Throwable localThrowable)
    {
      a("GdtInitializeOnToolProcessStep", "doStep", localThrowable);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.GdtInitializeOnToolProcessStep
 * JD-Core Version:    0.7.0.1
 */