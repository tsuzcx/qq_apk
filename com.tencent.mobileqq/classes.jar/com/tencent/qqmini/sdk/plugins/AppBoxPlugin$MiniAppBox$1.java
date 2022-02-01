package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.AbsBoxAdView;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

class AppBoxPlugin$MiniAppBox$1
  implements Runnable
{
  AppBoxPlugin$MiniAppBox$1(AppBoxPlugin.MiniAppBox paramMiniAppBox, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    try
    {
      AppBoxPlugin.MiniAppBox.access$000(this.this$1).show();
      AppBoxPlugin.MiniAppBox.access$100(this.this$1, true, "operateAppBox", this.val$compId, 0, this.val$callbackId);
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("SDK_MiniAppBox", "adBox show Exception:", localThrowable);
      AppBoxPlugin.MiniAppBox.access$100(this.this$1, false, "operateAppBox", this.val$compId, 1003, this.val$callbackId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.AppBoxPlugin.MiniAppBox.1
 * JD-Core Version:    0.7.0.1
 */