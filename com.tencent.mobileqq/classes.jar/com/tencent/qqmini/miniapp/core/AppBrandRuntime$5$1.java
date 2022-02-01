package com.tencent.qqmini.miniapp.core;

import android.graphics.Bitmap;
import com.tencent.qqmini.sdk.launcher.core.utils.ICaptureImageCallback;

class AppBrandRuntime$5$1
  implements Runnable
{
  AppBrandRuntime$5$1(AppBrandRuntime.5 param5, Bitmap paramBitmap) {}
  
  public void run()
  {
    if (this.b.val$callback != null) {
      this.b.val$callback.onResult(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.AppBrandRuntime.5.1
 * JD-Core Version:    0.7.0.1
 */