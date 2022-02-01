package com.tencent.mobileqq.imcore.proxy;

public class IMCoreProxyRoute$ExceptionTracker
{
  private static IMCoreProxyRoute.ExceptionTracker.Proxy ExceptionTrackerProxy;
  
  public static void registerProxy(IMCoreProxyRoute.ExceptionTracker.Proxy paramProxy)
  {
    ExceptionTrackerProxy = paramProxy;
  }
  
  public static void trackException(String paramString1, String paramString2)
  {
    if (ExceptionTrackerProxy != null) {
      ExceptionTrackerProxy.trackException(paramString1, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.imcore.proxy.IMCoreProxyRoute.ExceptionTracker
 * JD-Core Version:    0.7.0.1
 */