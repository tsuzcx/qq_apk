package com.tencent.qqmini.sdk.core.log;

import betb;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;

public class LogImpl
  implements betb
{
  private MiniAppProxy miniAppProxy = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
  
  public void d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (this.miniAppProxy != null) {
      this.miniAppProxy.log(2, paramString1, paramString2, paramThrowable);
    }
  }
  
  public void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (this.miniAppProxy != null) {
      this.miniAppProxy.log(5, paramString1, paramString2, paramThrowable);
    }
  }
  
  public int getLogLevel()
  {
    return 1;
  }
  
  public void i(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (this.miniAppProxy != null) {
      this.miniAppProxy.log(3, paramString1, paramString2, paramThrowable);
    }
  }
  
  public void w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (this.miniAppProxy != null) {
      this.miniAppProxy.log(4, paramString1, paramString2, paramThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.log.LogImpl
 * JD-Core Version:    0.7.0.1
 */