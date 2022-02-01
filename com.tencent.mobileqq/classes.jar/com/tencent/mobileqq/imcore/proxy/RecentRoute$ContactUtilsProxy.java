package com.tencent.mobileqq.imcore.proxy;

public class RecentRoute$ContactUtilsProxy
{
  private static RecentRoute.ContactUtilsProxy.Proxy proxy;
  
  public static String getBuddyName(IMCoreAppRuntime paramIMCoreAppRuntime, String paramString, boolean paramBoolean)
  {
    String str = paramString;
    if (proxy != null) {
      str = proxy.getBuddyName(paramIMCoreAppRuntime, paramString, paramBoolean);
    }
    return str;
  }
  
  public static String getTroopName(IMCoreAppRuntime paramIMCoreAppRuntime, String paramString, boolean paramBoolean)
  {
    String str = paramString;
    if (proxy != null) {
      str = proxy.getTroopName(paramIMCoreAppRuntime, paramString, paramBoolean);
    }
    return str;
  }
  
  public static void registerProxy(RecentRoute.ContactUtilsProxy.Proxy paramProxy)
  {
    proxy = paramProxy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.imcore.proxy.RecentRoute.ContactUtilsProxy
 * JD-Core Version:    0.7.0.1
 */