package com.tencent.mobileqq.imcore.proxy.business;

import com.tencent.mobileqq.imcore.proxy.msg.QQTextProxy;

public class ColorNickManagerProxy
{
  private static ColorNickManagerProxy.Proxy a;
  
  public static CharSequence a(String paramString1, String paramString2)
  {
    ColorNickManagerProxy.Proxy localProxy = a;
    if (localProxy != null) {
      return localProxy.a(paramString1, paramString2);
    }
    return QQTextProxy.a(paramString1, 3, 16);
  }
  
  public static void a(ColorNickManagerProxy.Proxy paramProxy)
  {
    a = paramProxy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.imcore.proxy.business.ColorNickManagerProxy
 * JD-Core Version:    0.7.0.1
 */