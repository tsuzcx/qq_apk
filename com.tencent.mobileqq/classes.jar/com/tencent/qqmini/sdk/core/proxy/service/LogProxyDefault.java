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
    switch (paramInt)
    {
    default: 
      if (paramThrowable == null)
      {
        Log.v(paramString1, paramString2);
        return;
      }
      break;
    case 2: 
      if (paramThrowable == null)
      {
        Log.d(paramString1, paramString2);
        return;
      }
      Log.d(paramString1, paramString2, paramThrowable);
      return;
    case 3: 
      if (paramThrowable == null)
      {
        Log.i(paramString1, paramString2);
        return;
      }
      Log.i(paramString1, paramString2, paramThrowable);
      return;
    case 4: 
      if (paramThrowable == null)
      {
        Log.w(paramString1, paramString2);
        return;
      }
      Log.w(paramString1, paramString2, paramThrowable);
      return;
    case 5: 
      if (paramThrowable == null)
      {
        Log.e(paramString1, paramString2);
        return;
      }
      Log.e(paramString1, paramString2, paramThrowable);
      return;
    }
    Log.v(paramString1, paramString2, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.service.LogProxyDefault
 * JD-Core Version:    0.7.0.1
 */