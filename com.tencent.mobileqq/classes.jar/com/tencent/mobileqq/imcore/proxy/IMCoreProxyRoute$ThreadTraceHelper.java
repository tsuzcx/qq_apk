package com.tencent.mobileqq.imcore.proxy;

public class IMCoreProxyRoute$ThreadTraceHelper
{
  private static IMCoreProxyRoute.ThreadTraceHelper.Proxy threadTraceProxy;
  
  public static void addWaitingTransThread(long paramLong, String paramString)
  {
    if (threadTraceProxy != null) {
      threadTraceProxy.addWaitingTransThread(paramLong, paramString);
    }
  }
  
  public static void registerProxy(IMCoreProxyRoute.ThreadTraceHelper.Proxy paramProxy)
  {
    threadTraceProxy = paramProxy;
  }
  
  public static void removeWaitingTransThread(long paramLong)
  {
    if (threadTraceProxy != null) {
      threadTraceProxy.removeWaitingTransThread(paramLong);
    }
  }
  
  public static void setCurrentTransThread(long paramLong, String paramString)
  {
    if (threadTraceProxy != null) {
      threadTraceProxy.setCurrentTransThread(paramLong, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.imcore.proxy.IMCoreProxyRoute.ThreadTraceHelper
 * JD-Core Version:    0.7.0.1
 */