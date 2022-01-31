package com.tencent.qqmini.sdk.ipc;

import bgpo;
import com.tencent.qqmini.sdk.launcher.ipc.IAppMainService;
import com.tencent.qqmini.sdk.log.QMLog;

public class AppBrandProxyImpl$7
  implements Runnable
{
  public AppBrandProxyImpl$7(bgpo parambgpo) {}
  
  public void run()
  {
    try
    {
      bgpo.a(this.this$0).stopAllMiniApp();
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("minisdk-start_AppBrandProxy", "stopMiniApp exception.", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ipc.AppBrandProxyImpl.7
 * JD-Core Version:    0.7.0.1
 */