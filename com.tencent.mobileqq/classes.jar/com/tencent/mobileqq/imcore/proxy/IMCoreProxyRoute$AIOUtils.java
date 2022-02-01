package com.tencent.mobileqq.imcore.proxy;

public class IMCoreProxyRoute$AIOUtils
{
  private static IMCoreProxyRoute.AIOUtils.Proxy AIOUtilsProxy;
  
  public static boolean getLogcatDBOperation()
  {
    if (AIOUtilsProxy != null) {
      return AIOUtilsProxy.getLogcatDBOperation();
    }
    return false;
  }
  
  public static void registerProxy(IMCoreProxyRoute.AIOUtils.Proxy paramProxy)
  {
    AIOUtilsProxy = paramProxy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.imcore.proxy.IMCoreProxyRoute.AIOUtils
 * JD-Core Version:    0.7.0.1
 */