package com.tencent.qqmini.sdk.log;

import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.LogProxy;
import com.tencent.qqmini.sdk.launcher.log.Log;

@MiniKeep
public class LogImpl
  implements Log
{
  private LogProxy logProxy = (LogProxy)ProxyManager.get(LogProxy.class);
  
  public void d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    LogProxy localLogProxy = this.logProxy;
    if (localLogProxy != null) {
      localLogProxy.log(2, paramString1, paramString2, paramThrowable);
    }
  }
  
  public void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    LogProxy localLogProxy = this.logProxy;
    if (localLogProxy != null) {
      localLogProxy.log(5, paramString1, paramString2, paramThrowable);
    }
  }
  
  public int getLogLevel()
  {
    return 1;
  }
  
  public void i(String paramString1, String paramString2, Throwable paramThrowable)
  {
    LogProxy localLogProxy = this.logProxy;
    if (localLogProxy != null) {
      localLogProxy.log(3, paramString1, paramString2, paramThrowable);
    }
  }
  
  public void w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    LogProxy localLogProxy = this.logProxy;
    if (localLogProxy != null) {
      localLogProxy.log(4, paramString1, paramString2, paramThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.log.LogImpl
 * JD-Core Version:    0.7.0.1
 */