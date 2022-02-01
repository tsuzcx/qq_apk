package com.tencent.qqmini.sdk.runtime;

import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

class AppStateManager$4
  implements Runnable
{
  AppStateManager$4(AppStateManager paramAppStateManager) {}
  
  public void run()
  {
    if ((AppStateManager.access$400()) || (this.this$0.hasFirstDomReadied)) {}
    BaseRuntime localBaseRuntime;
    do
    {
      return;
      localBaseRuntime = AppStateManager.access$000(this.this$0).getRuntime();
    } while ((localBaseRuntime == null) || (localBaseRuntime.getAttachedActivity() == null));
    QMLog.e("minisdk-start_RuntimeState", "js error! start X5 guide.");
    try
    {
      AppStateManager.access$402(true);
      ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).startDownloadX5(localBaseRuntime);
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("minisdk-start_RuntimeState", "start X5 guide exception.", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.AppStateManager.4
 * JD-Core Version:    0.7.0.1
 */