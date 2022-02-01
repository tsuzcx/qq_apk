package com.tencent.mobileqq.imcore.proxy;

import android.support.annotation.NonNull;

public class IMCoreProxyRoute$CaughtExceptionReport
{
  private static IMCoreProxyRoute.CaughtExceptionReport.Proxy CaughtExceptionReportProxy;
  
  public static void e(@NonNull Throwable paramThrowable, @NonNull String paramString)
  {
    if (CaughtExceptionReportProxy != null) {
      CaughtExceptionReportProxy.e(paramThrowable, paramString);
    }
  }
  
  public static void registerProxy(IMCoreProxyRoute.CaughtExceptionReport.Proxy paramProxy)
  {
    CaughtExceptionReportProxy = paramProxy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.imcore.proxy.IMCoreProxyRoute.CaughtExceptionReport
 * JD-Core Version:    0.7.0.1
 */