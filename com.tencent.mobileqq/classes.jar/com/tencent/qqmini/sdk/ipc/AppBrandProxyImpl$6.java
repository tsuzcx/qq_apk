package com.tencent.qqmini.sdk.ipc;

import bgtv;
import com.tencent.qqmini.sdk.launcher.ipc.IAppMainService;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.log.QMLog;

public class AppBrandProxyImpl$6
  implements Runnable
{
  public AppBrandProxyImpl$6(bgtv parambgtv, MiniAppInfo paramMiniAppInfo) {}
  
  public void run()
  {
    try
    {
      bgtv.a(this.this$0).stopMiniApp(this.a);
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("minisdk-start_AppBrandProxy", "stopMiniApp exception.", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ipc.AppBrandProxyImpl.6
 * JD-Core Version:    0.7.0.1
 */