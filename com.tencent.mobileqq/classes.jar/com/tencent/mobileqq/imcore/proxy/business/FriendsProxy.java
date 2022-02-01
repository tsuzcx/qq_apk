package com.tencent.mobileqq.imcore.proxy.business;

public class FriendsProxy
{
  private static FriendsProxy.Proxy a;
  
  public static void a(FriendsProxy.Proxy paramProxy)
  {
    a = paramProxy;
  }
  
  public static boolean a(String paramString)
  {
    FriendsProxy.Proxy localProxy = a;
    if (localProxy == null) {
      return false;
    }
    return localProxy.a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.imcore.proxy.business.FriendsProxy
 * JD-Core Version:    0.7.0.1
 */