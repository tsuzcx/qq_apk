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
    if (instance == null) {}
    synchronized (lock)
    {
      if (instance == null) {
        instance = new AppBrandCmdProxy();
      }
      return instance;
    }
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
  
  /* Error */
  public void setAppBrandProxy(AppBrandProxy paramAppBrandProxy)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 27	com/tencent/qqmini/sdk/ipc/AppBrandCmdProxy:mAppBrandProxy	Lcom/tencent/qqmini/sdk/ipc/AppBrandProxy;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: aload_1
    //   16: putfield 27	com/tencent/qqmini/sdk/ipc/AppBrandCmdProxy:mAppBrandProxy	Lcom/tencent/qqmini/sdk/ipc/AppBrandProxy;
    //   19: goto -8 -> 11
    //   22: astore_1
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_1
    //   26: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	27	0	this	AppBrandCmdProxy
    //   0	27	1	paramAppBrandProxy	AppBrandProxy
    //   6	2	2	localAppBrandProxy	AppBrandProxy
    // Exception table:
    //   from	to	target	type
    //   2	7	22	finally
    //   14	19	22	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ipc.AppBrandCmdProxy
 * JD-Core Version:    0.7.0.1
 */