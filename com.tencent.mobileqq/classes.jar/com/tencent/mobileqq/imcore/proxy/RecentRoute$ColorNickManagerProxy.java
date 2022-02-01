package com.tencent.mobileqq.imcore.proxy;

public class RecentRoute$ColorNickManagerProxy
{
  private static RecentRoute.ColorNickManagerProxy.Proxy proxy;
  
  public static void registerProxy(RecentRoute.ColorNickManagerProxy.Proxy paramProxy)
  {
    proxy = paramProxy;
  }
  
  public static CharSequence transformMessageWithAtTroopMember(String paramString1, String paramString2)
  {
    if (proxy != null) {
      return proxy.transformMessageWithAtTroopMember(paramString1, paramString2);
    }
    return RecentRoute.QQTextProxy.generalQQText(paramString1, 3, 16);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.imcore.proxy.RecentRoute.ColorNickManagerProxy
 * JD-Core Version:    0.7.0.1
 */