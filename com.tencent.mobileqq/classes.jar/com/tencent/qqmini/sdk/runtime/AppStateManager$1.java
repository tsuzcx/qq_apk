package com.tencent.qqmini.sdk.runtime;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.Window;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.qqmini.sdk.utils.ScreenShotUtil;

class AppStateManager$1
  implements Runnable
{
  AppStateManager$1(AppStateManager paramAppStateManager, MiniAppInfo paramMiniAppInfo) {}
  
  public void run()
  {
    try
    {
      Object localObject = AppStateManager.access$000(this.this$0).getRuntime().getAttachedActivity();
      if (localObject != null)
      {
        localObject = ScreenShotUtil.captureView(((Activity)localObject).getWindow().getDecorView());
        String str;
        if (ScreenShotUtil.CheckIfWhiteScreen((Bitmap)localObject))
        {
          str = ScreenShotUtil.bitmapTobase64((Bitmap)localObject, WnsConfig.getConfig("qqminiapp", "mini_app_white_screen_shot_max_width", 500), WnsConfig.getConfig("qqminiapp", "mini_app_white_screen_shot_max_height", 500));
          if (str.length() >= 5120) {
            break label149;
          }
          QMLog.i("minisdk-start_RuntimeState", "--- report white_screen appid:" + this.val$miniAppInfo.appId + " img:" + str);
        }
        for (;;)
        {
          MiniReportManager.reportEventType(this.val$miniAppInfo, 150, MiniReportManager.getAppType(this.val$miniAppInfo), "dom_ready", String.valueOf(str.length()), "", "");
          if (localObject == null) {
            break;
          }
          ((Bitmap)localObject).recycle();
          return;
          label149:
          QMLog.i("minisdk-start_RuntimeState", "--- report white_screen appid:" + this.val$miniAppInfo.appId + " base64 length:" + str.length());
        }
      }
      return;
    }
    catch (Exception localException)
    {
      QMLog.e("minisdk-start_RuntimeState", "---check white screen failed", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.AppStateManager.1
 * JD-Core Version:    0.7.0.1
 */