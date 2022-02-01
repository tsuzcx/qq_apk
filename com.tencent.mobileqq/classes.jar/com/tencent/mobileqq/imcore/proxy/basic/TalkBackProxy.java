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
    if (a != null) {
      return a.a();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.imcore.proxy.basic.TalkBackProxy
 * JD-Core Version:    0.7.0.1
 */