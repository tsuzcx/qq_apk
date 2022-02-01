package com.tencent.mobileqq.imcore.proxy;

public class IMCoreProxyRoute$TalkBack
{
  private static IMCoreProxyRoute.TalkBack.Proxy talkBackProxy;
  
  public static boolean getTalkBackStatus()
  {
    if (talkBackProxy != null) {
      return talkBackProxy.getTalkBackStatus();
    }
    return false;
  }
  
  public static void registerProxy(IMCoreProxyRoute.TalkBack.Proxy paramProxy)
  {
    talkBackProxy = paramProxy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.imcore.proxy.IMCoreProxyRoute.TalkBack
 * JD-Core Version:    0.7.0.1
 */