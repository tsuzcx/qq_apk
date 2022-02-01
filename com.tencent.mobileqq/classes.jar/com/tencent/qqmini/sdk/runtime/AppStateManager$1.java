package com.tencent.qqmini.sdk.runtime;

import android.app.Activity;
import android.view.Window;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.utils.ScreenShotUtil;

class AppStateManager$1
  implements Runnable
{
  AppStateManager$1(AppStateManager paramAppStateManager, MiniAppInfo paramMiniAppInfo) {}
  
  public void run()
  {
    try
    {
      Activity localActivity = AppStateManager.access$000(this.this$0).getRuntime().getAttachedActivity();
      if (localActivity != null)
      {
        localActivity.getWindow().getDecorView();
        ScreenShotUtil.setRuntime(AppStateManager.access$000(this.this$0).getRuntime());
        AppStateManager.access$000(this.this$0).getRuntime().captureImage(new AppStateManager.1.1(this));
        return;
      }
    }
    catch (Exception localException)
    {
      QMLog.e("minisdk-start_RuntimeState", "---getScreenshot failed", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.AppStateManager.1
 * JD-Core Version:    0.7.0.1
 */