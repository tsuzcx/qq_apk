package com.tencent.qqmini.sdk.runtime;

import com.tencent.qqmini.sdk.launcher.log.QMLog;

class AppRuntimeLoaderManager$1
  extends AppRuntimeEventCenter.RuntimeStateObserver
{
  AppRuntimeLoaderManager$1(AppRuntimeLoaderManager paramAppRuntimeLoaderManager) {}
  
  public void onStateChange(AppRuntimeEventCenter.MiniAppStateMessage paramMiniAppStateMessage)
  {
    if (paramMiniAppStateMessage != null)
    {
      if (paramMiniAppStateMessage.appRuntimeLoader == null) {
        return;
      }
      ??? = new StringBuilder();
      ((StringBuilder)???).append("OnRuntimeEvent message:");
      ((StringBuilder)???).append(paramMiniAppStateMessage);
      QMLog.i("minisdk-start_AppRuntimeLoaderManager", ((StringBuilder)???).toString());
      AppRuntimeLoaderManager.access$000(this.this$0, paramMiniAppStateMessage);
      try
      {
        synchronized (this.this$0)
        {
          if (paramMiniAppStateMessage.appRuntimeLoader == AppRuntimeLoaderManager.access$100(this.this$0))
          {
            if ((AppRuntimeLoaderManager.access$100(this.this$0).getStatus() == 4) || (AppRuntimeLoaderManager.access$100(this.this$0).getStatus() == 5))
            {
              AppRuntimeLoaderManager.access$102(this.this$0, null);
              this.this$0.preloadRuntime(AppRuntimeLoaderManager.access$200(this.this$0));
            }
          }
          else if ((paramMiniAppStateMessage.appRuntimeLoader == AppRuntimeLoaderManager.access$300(this.this$0)) && ((AppRuntimeLoaderManager.access$300(this.this$0).getStatus() == 5) || (paramMiniAppStateMessage.what == 4)))
          {
            AppRuntimeLoaderManager.access$302(this.this$0, null);
            this.this$0.preloadRuntime(AppRuntimeLoaderManager.access$200(this.this$0));
          }
        }
      }
      catch (Throwable paramMiniAppStateMessage)
      {
        QMLog.e("minisdk-start_AppRuntimeLoaderManager", "", paramMiniAppStateMessage);
        return;
      }
      throw paramMiniAppStateMessage;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.AppRuntimeLoaderManager.1
 * JD-Core Version:    0.7.0.1
 */