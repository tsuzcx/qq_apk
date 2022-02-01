package com.tencent.mobileqq.mini.appbrand;

import android.graphics.Bitmap;

class AppBrandRuntime$20
  implements Runnable
{
  AppBrandRuntime$20(AppBrandRuntime paramAppBrandRuntime, BaseAppBrandRuntime.ShareScreenshotCallback paramShareScreenshotCallback, Bitmap paramBitmap) {}
  
  public void run()
  {
    if (this.val$screenshotCallback != null) {
      this.val$screenshotCallback.onGetShareScreenshot(this.this$0.cutAndSaveShareScreenshot(this.val$cachingBitmap));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.AppBrandRuntime.20
 * JD-Core Version:    0.7.0.1
 */