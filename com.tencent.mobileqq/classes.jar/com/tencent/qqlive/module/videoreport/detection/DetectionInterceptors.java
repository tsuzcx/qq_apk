package com.tencent.qqlive.module.videoreport.detection;

import android.app.Activity;
import com.tencent.qqlive.module.videoreport.utils.BaseUtils;
import com.tencent.qqlive.module.videoreport.utils.IDetectionInterceptor;

public class DetectionInterceptors
{
  private static final IDetectionInterceptor DEFAULT_INTERCEPTOR = new DetectionInterceptors.1();
  private static volatile IDetectionInterceptor sDetectionInterceptor = DEFAULT_INTERCEPTOR;
  
  public static boolean ignoreAppEvent(Activity paramActivity)
  {
    return sDetectionInterceptor.ignoreAppEvent(paramActivity);
  }
  
  public static void setDetectionInterceptor(IDetectionInterceptor paramIDetectionInterceptor)
  {
    sDetectionInterceptor = (IDetectionInterceptor)BaseUtils.nullAs(paramIDetectionInterceptor, DEFAULT_INTERCEPTOR);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.detection.DetectionInterceptors
 * JD-Core Version:    0.7.0.1
 */