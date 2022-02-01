package com.tencent.mobileqq.imcore.proxy.msg;

public class MsgProxyUtilsProxy
{
  private static MsgProxyUtilsProxy.Proxy proxy;
  
  public static boolean isSaveConversation(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    MsgProxyUtilsProxy.Proxy localProxy = proxy;
    if (localProxy != null) {
      return localProxy.isSaveConversation(paramString1, paramString2, paramInt1, paramInt2);
    }
    return true;
  }
  
  public static void registerProxy(MsgProxyUtilsProxy.Proxy paramProxy)
  {
    proxy = paramProxy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.imcore.proxy.msg.MsgProxyUtilsProxy
 * JD-Core Version:    0.7.0.1
 */