package com.tencent.qqmini.sdk.ipc;

import android.os.Bundle;
import com.tencent.qqmini.sdk.launcher.ipc.MiniCmdCallback;

public class AppBrandCmdProxy
{
  private static volatile AppBrandCmdProxy instance;
  private static byte[] lock = new byte[0];
  private AppBrandProxy mAppBrandProxy;
  
  public static AppBrandCmdProxy g()
  {
    if (instance == null) {
      synchronized (lock)
      {
        if (instance == null) {
          instance = new AppBrandCmdProxy();
        }
      }
    }
    return instance;
  }
  
  public void sendCmd(String paramString, Bundle paramBundle, MiniCmdCallback paramMiniCmdCallback)
  {
    try
    {
      if (this.mAppBrandProxy != null) {
        this.mAppBrandProxy.sendCmd(paramString, paramBundle, paramMiniCmdCallback);
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void setAppBrandProxy(AppBrandProxy paramAppBrandProxy)
  {
    try
    {
      AppBrandProxy localAppBrandProxy = this.mAppBrandProxy;
      if (localAppBrandProxy != null) {
        return;
      }
      this.mAppBrandProxy = paramAppBrandProxy;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ipc.AppBrandCmdProxy
 * JD-Core Version:    0.7.0.1
 */