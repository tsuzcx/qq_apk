package com.tencent.mobileqq.imcore.proxy;

public class IMCoreProxyRoute$MsgProxyUtils
{
  private static IMCoreProxyRoute.MsgProxyUtils.Proxy MsgProxyUtilsProxy;
  
  public static boolean isSaveConversation(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (MsgProxyUtilsProxy != null) {
      return MsgProxyUtilsProxy.isSaveConversation(paramString1, paramString2, paramInt1, paramInt2);
    }
    return true;
  }
  
  public static void registerProxy(IMCoreProxyRoute.MsgProxyUtils.Proxy paramProxy)
  {
    MsgProxyUtilsProxy = paramProxy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.imcore.proxy.IMCoreProxyRoute.MsgProxyUtils
 * JD-Core Version:    0.7.0.1
 */