package com.tencent.mobileqq.imcore.proxy.basic;

import android.support.annotation.NonNull;

public class CaughtExceptionReportProxy
{
  private static CaughtExceptionReportProxy.Proxy proxy;
  
  public static void e(@NonNull Throwable paramThrowable, @NonNull String paramString)
  {
    CaughtExceptionReportProxy.Proxy localProxy = proxy;
    if (localProxy != null) {
      localProxy.e(paramThrowable, paramString);
    }
  }
  
  public static void registerProxy(CaughtExceptionReportProxy.Proxy paramProxy)
  {
    proxy = paramProxy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.imcore.proxy.basic.CaughtExceptionReportProxy
 * JD-Core Version:    0.7.0.1
 */