package com.tencent.mobileqq.imcore.proxy.basic;

public class TalkBackProxy
{
  private static TalkBackProxy.Proxy a;
  
  public static void a(TalkBackProxy.Proxy paramProxy)
  {
    a = paramProxy;
  }
  
  public static boolean a()
  {
    TalkBackProxy.Proxy localProxy = a;
    if (localProxy != null) {
      return localProxy.a();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.imcore.proxy.basic.TalkBackProxy
 * JD-Core Version:    0.7.0.1
 */