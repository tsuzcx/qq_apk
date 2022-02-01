package com.tencent.mobileqq.imcore.proxy;

import com.tencent.mobileqq.text.AbsQQText;

public class RecentRoute$QQTextProxy
{
  private static RecentRoute.QQTextProxy.Proxy proxy;
  
  public static AbsQQText generalQQText(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    if (proxy != null) {
      return proxy.generalQQText(paramCharSequence, paramInt1, paramInt2);
    }
    return null;
  }
  
  public static void registerProxy(RecentRoute.QQTextProxy.Proxy paramProxy)
  {
    proxy = paramProxy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.imcore.proxy.RecentRoute.QQTextProxy
 * JD-Core Version:    0.7.0.1
 */