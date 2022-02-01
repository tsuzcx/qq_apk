package com.tencent.qqmini.miniapp.core;

import android.graphics.Bitmap;
import com.tencent.qqmini.sdk.launcher.core.proxy.MapProxy.MapSnapshotCallback;
import com.tencent.qqmini.sdk.launcher.core.utils.ICaptureImageCallback;

class AppBrandRuntime$3
  implements MapProxy.MapSnapshotCallback
{
  AppBrandRuntime$3(AppBrandRuntime paramAppBrandRuntime, ICaptureImageCallback paramICaptureImageCallback) {}
  
  public void onSnapshotReady(Bitmap paramBitmap)
  {
    ICaptureImageCallback localICaptureImageCallback = this.val$callback;
    if (localICaptureImageCallback != null)
    {
      localICaptureImageCallback.onResult(paramBitmap);
      this.this$0.isGettingScreenShot = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.AppBrandRuntime.3
 * JD-Core Version:    0.7.0.1
 */