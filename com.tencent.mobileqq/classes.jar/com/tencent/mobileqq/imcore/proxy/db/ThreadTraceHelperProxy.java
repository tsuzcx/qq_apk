package com.tencent.mobileqq.imcore.proxy.db;

public class ThreadTraceHelperProxy
{
  private static ThreadTraceHelperProxy.Proxy proxy;
  
  public static void addWaitingTransThread(long paramLong, String paramString)
  {
    ThreadTraceHelperProxy.Proxy localProxy = proxy;
    if (localProxy != null) {
      localProxy.addWaitingTransThread(paramLong, paramString);
    }
  }
  
  public static void registerProxy(ThreadTraceHelperProxy.Proxy paramProxy)
  {
    proxy = paramProxy;
  }
  
  public static void removeWaitingTransThread(long paramLong)
  {
    ThreadTraceHelperProxy.Proxy localProxy = proxy;
    if (localProxy != null) {
      localProxy.removeWaitingTransThread(paramLong);
    }
  }
  
  public static void setCurrentTransThread(long paramLong, String paramString)
  {
    ThreadTraceHelperProxy.Proxy localProxy = proxy;
    if (localProxy != null) {
      localProxy.setCurrentTransThread(paramLong, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.imcore.proxy.db.ThreadTraceHelperProxy
 * JD-Core Version:    0.7.0.1
 */