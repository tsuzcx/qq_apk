package com.tencent.qqmini.miniapp.core;

import android.graphics.Bitmap;
import com.tencent.qqmini.sdk.launcher.core.utils.ICaptureImageCallback;

class AppBrandRuntime$4$1
  implements Runnable
{
  AppBrandRuntime$4$1(AppBrandRuntime.4 param4, Bitmap paramBitmap) {}
  
  public void run()
  {
    if (this.this$1.val$callback != null)
    {
      this.this$1.val$callback.onResult(this.val$bitmap);
      this.this$1.this$0.isGettingScreenShot = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.AppBrandRuntime.4.1
 * JD-Core Version:    0.7.0.1
 */