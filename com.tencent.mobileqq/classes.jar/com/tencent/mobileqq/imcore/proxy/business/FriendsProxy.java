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
    if (a == null) {
      return false;
    }
    return a.a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.imcore.proxy.business.FriendsProxy
 * JD-Core Version:    0.7.0.1
 */