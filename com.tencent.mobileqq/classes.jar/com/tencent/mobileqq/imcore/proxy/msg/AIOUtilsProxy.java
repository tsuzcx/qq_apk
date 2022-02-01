package com.tencent.mobileqq.imcore.proxy.msg;

public class AIOUtilsProxy
{
  private static AIOUtilsProxy.Proxy proxy;
  
  public static boolean getLogcatDBOperation()
  {
    if (proxy != null) {
      return proxy.getLogcatDBOperation();
    }
    return false;
  }
  
  public static void registerProxy(AIOUtilsProxy.Proxy paramProxy)
  {
    proxy = paramProxy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.imcore.proxy.msg.AIOUtilsProxy
 * JD-Core Version:    0.7.0.1
 */