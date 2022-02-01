package com.tencent.qqmini.miniapp.core;

import com.tencent.qqmini.sdk.launcher.core.action.GetScreenshot.Callback;
import com.tencent.qqmini.sdk.launcher.core.proxy.MapProxy.MapSnapshotCallback;

class AppBrandRuntime$3
  implements MapProxy.MapSnapshotCallback
{
  AppBrandRuntime$3(AppBrandRuntime paramAppBrandRuntime, GetScreenshot.Callback paramCallback) {}
  
  public void onSnapshotReady(String paramString)
  {
    if (this.val$callback != null)
    {
      this.val$callback.onGetScreenshot(paramString);
      this.this$0.isGettingScreenShot = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.AppBrandRuntime.3
 * JD-Core Version:    0.7.0.1
 */