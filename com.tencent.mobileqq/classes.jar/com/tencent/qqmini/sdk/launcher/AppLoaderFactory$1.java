package com.tencent.qqmini.sdk.launcher;

import com.tencent.qqmini.sdk.launcher.core.proxy.LogProxy;
import com.tencent.qqmini.sdk.launcher.log.Log;

class AppLoaderFactory$1
  implements Log
{
  AppLoaderFactory$1(AppLoaderFactory paramAppLoaderFactory, LogProxy paramLogProxy) {}
  
  public void d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    this.val$logProxyImpl.log(2, paramString1, paramString2, paramThrowable);
  }
  
  public void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    this.val$logProxyImpl.log(5, paramString1, paramString2, paramThrowable);
  }
  
  public int getLogLevel()
  {
    return 1;
  }
  
  public void i(String paramString1, String paramString2, Throwable paramThrowable)
  {
    this.val$logProxyImpl.log(3, paramString1, paramString2, paramThrowable);
  }
  
  public void w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    this.val$logProxyImpl.log(4, paramString1, paramString2, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.AppLoaderFactory.1
 * JD-Core Version:    0.7.0.1
 */