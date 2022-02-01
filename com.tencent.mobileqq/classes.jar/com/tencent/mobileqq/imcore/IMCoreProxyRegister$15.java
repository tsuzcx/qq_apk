package com.tencent.mobileqq.imcore;

import com.tencent.mobileqq.imcore.proxy.msg.QQTextProxy.Proxy;
import com.tencent.mobileqq.text.AbsQQText;
import com.tencent.mobileqq.text.QQText;

final class IMCoreProxyRegister$15
  implements QQTextProxy.Proxy
{
  public AbsQQText a(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    return new QQText(paramCharSequence, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.imcore.IMCoreProxyRegister.15
 * JD-Core Version:    0.7.0.1
 */