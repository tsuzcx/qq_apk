package com.tencent.qqmini.proxyimpl;

import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.proxy.LogProxy;

@ProxyService(proxy=LogProxy.class)
public class LogProxyImpl
  extends LogProxy
{
  public void log(int paramInt, String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (paramInt != 2)
    {
      if (paramInt != 4)
      {
        if (paramInt != 5)
        {
          if (paramThrowable == null)
          {
            QLog.i(paramString1, 1, paramString2);
            return;
          }
          QLog.i(paramString1, 1, paramString2, paramThrowable);
          return;
        }
        if (paramThrowable == null)
        {
          QLog.e(paramString1, 1, paramString2);
          return;
        }
        QLog.e(paramString1, 1, paramString2, paramThrowable);
        return;
      }
      if (paramThrowable == null)
      {
        QLog.w(paramString1, 1, paramString2);
        return;
      }
      QLog.w(paramString1, 1, paramString2, paramThrowable);
      return;
    }
    if (paramThrowable == null)
    {
      QLog.d(paramString1, 1, paramString2);
      return;
    }
    QLog.d(paramString1, 1, paramString2, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.LogProxyImpl
 * JD-Core Version:    0.7.0.1
 */