package com.tencent.qqmini.sdk.core.proxy.service;

import android.util.Log;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.proxy.LogProxy;

@ProxyService(proxy=LogProxy.class)
public class LogProxyDefault
  extends LogProxy
{
  public void log(int paramInt, String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (paramInt != 2)
    {
      if (paramInt != 3)
      {
        if (paramInt != 4)
        {
          if (paramInt != 5)
          {
            if (paramThrowable == null)
            {
              Log.v(paramString1, paramString2);
              return;
            }
            Log.v(paramString1, paramString2, paramThrowable);
            return;
          }
          if (paramThrowable == null)
          {
            Log.e(paramString1, paramString2);
            return;
          }
          Log.e(paramString1, paramString2, paramThrowable);
          return;
        }
        if (paramThrowable == null)
        {
          Log.w(paramString1, paramString2);
          return;
        }
        Log.w(paramString1, paramString2, paramThrowable);
        return;
      }
      if (paramThrowable == null)
      {
        Log.i(paramString1, paramString2);
        return;
      }
      Log.i(paramString1, paramString2, paramThrowable);
      return;
    }
    if (paramThrowable == null)
    {
      Log.d(paramString1, paramString2);
      return;
    }
    Log.d(paramString1, paramString2, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.service.LogProxyDefault
 * JD-Core Version:    0.7.0.1
 */