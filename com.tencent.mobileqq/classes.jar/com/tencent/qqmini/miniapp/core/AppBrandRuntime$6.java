package com.tencent.qqmini.miniapp.core;

import android.graphics.Bitmap;
import com.tencent.qqmini.sdk.launcher.core.utils.ICaptureImageCallback;

class AppBrandRuntime$6
  implements Runnable
{
  AppBrandRuntime$6(AppBrandRuntime paramAppBrandRuntime, ICaptureImageCallback paramICaptureImageCallback, Bitmap paramBitmap) {}
  
  public void run()
  {
    ICaptureImageCallback localICaptureImageCallback = this.a;
    if (localICaptureImageCallback != null) {
      localICaptureImageCallback.onResult(this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.AppBrandRuntime.6
 * JD-Core Version:    0.7.0.1
 */