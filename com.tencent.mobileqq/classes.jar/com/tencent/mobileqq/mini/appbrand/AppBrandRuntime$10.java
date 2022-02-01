package com.tencent.mobileqq.mini.appbrand;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.Window;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.appbrand.utils.ScreenShotUtil;
import com.tencent.mobileqq.mini.report.MiniReportManager;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;

class AppBrandRuntime$10
  implements Runnable
{
  AppBrandRuntime$10(AppBrandRuntime paramAppBrandRuntime) {}
  
  public void run()
  {
    try
    {
      if (this.this$0.activity != null)
      {
        Bitmap localBitmap = ScreenShotUtil.captureView(this.this$0.activity.getWindow().getDecorView());
        String str;
        if (ScreenShotUtil.checkIfWhiteScreen(localBitmap))
        {
          str = ScreenShotUtil.bitmapTobase64(localBitmap, QzoneConfig.getInstance().getConfig("qqminiapp", "mini_app_white_screen_shot_max_width", 500), QzoneConfig.getInstance().getConfig("qqminiapp", "mini_app_white_screen_shot_max_height", 500));
          if (str.length() >= 5120) {
            break label164;
          }
          QLog.i("AppBrandRuntime", 1, "--- report white_screen appid:" + this.this$0.apkgInfo.appId + " img:" + str);
        }
        for (;;)
        {
          MiniReportManager.reportEventType(this.this$0.apkgInfo.appConfig, 150, MiniReportManager.getAppType(this.this$0.apkgInfo.appConfig), "dom_ready", "", "", "");
          if (localBitmap == null) {
            break;
          }
          localBitmap.recycle();
          return;
          label164:
          QLog.i("AppBrandRuntime", 1, "--- report white_screen appid:" + this.this$0.apkgInfo.appId + " base64 length:" + str.length());
        }
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("AppBrandRuntime", 1, "---check white screen failed", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.AppBrandRuntime.10
 * JD-Core Version:    0.7.0.1
 */