package com.tencent.mobileqq.mini.appbrand;

import android.graphics.Bitmap;

class AppBrandRuntime$17$1
  implements Runnable
{
  AppBrandRuntime$17$1(AppBrandRuntime.17 param17, Bitmap paramBitmap) {}
  
  public void run()
  {
    if (this.this$1.val$screenshotCallback != null) {
      this.this$1.val$screenshotCallback.onGetShareScreenshot(this.this$1.this$0.cutAndSaveShareScreenshot(this.val$rootBitmap));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.AppBrandRuntime.17.1
 * JD-Core Version:    0.7.0.1
 */