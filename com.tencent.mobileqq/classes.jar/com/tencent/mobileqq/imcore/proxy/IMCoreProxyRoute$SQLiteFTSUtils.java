package com.tencent.mobileqq.imcore.proxy;

public class IMCoreProxyRoute$SQLiteFTSUtils
{
  private static IMCoreProxyRoute.SQLiteFTSUtils.Proxy SQLiteFTSUtilsProxy;
  
  public static int getFTSNotifyFlag()
  {
    if (SQLiteFTSUtilsProxy != null) {
      return SQLiteFTSUtilsProxy.getFTSNotifyFlag();
    }
    return 0;
  }
  
  public static void registerProxy(IMCoreProxyRoute.SQLiteFTSUtils.Proxy paramProxy)
  {
    SQLiteFTSUtilsProxy = paramProxy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.imcore.proxy.IMCoreProxyRoute.SQLiteFTSUtils
 * JD-Core Version:    0.7.0.1
 */