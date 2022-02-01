package com.tencent.mobileqq.imcore.proxy.msg;

import com.tencent.mobileqq.text.AbsQQText;

public class QQTextProxy
{
  private static QQTextProxy.Proxy a;
  
  public static AbsQQText a(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    QQTextProxy.Proxy localProxy = a;
    if (localProxy != null) {
      return localProxy.a(paramCharSequence, paramInt1, paramInt2);
    }
    return null;
  }
  
  public static void a(QQTextProxy.Proxy paramProxy)
  {
    a = paramProxy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.imcore.proxy.msg.QQTextProxy
 * JD-Core Version:    0.7.0.1
 */