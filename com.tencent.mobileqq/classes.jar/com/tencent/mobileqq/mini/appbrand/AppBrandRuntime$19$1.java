package com.tencent.mobileqq.mini.appbrand;

import android.graphics.Bitmap;

class AppBrandRuntime$19$1
  implements Runnable
{
  AppBrandRuntime$19$1(AppBrandRuntime.19 param19, Bitmap paramBitmap) {}
  
  public void run()
  {
    if (this.this$1.val$screenshotCallback != null) {
      this.this$1.val$screenshotCallback.onGetShareScreenshot(this.this$1.this$0.cutAndSaveShareScreenshot(this.val$bitmap));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.AppBrandRuntime.19.1
 * JD-Core Version:    0.7.0.1
 */