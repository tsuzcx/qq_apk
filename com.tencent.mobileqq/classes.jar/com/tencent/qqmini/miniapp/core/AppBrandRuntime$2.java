package com.tencent.qqmini.miniapp.core;

import android.graphics.Bitmap;
import com.tencent.qqmini.sdk.launcher.core.action.GetScreenshot.Callback;
import com.tencent.qqmini.sdk.launcher.core.utils.ICaptureImageCallback;
import com.tencent.qqmini.sdk.utils.SaveCaptureImageUitl;

class AppBrandRuntime$2
  implements ICaptureImageCallback
{
  AppBrandRuntime$2(AppBrandRuntime paramAppBrandRuntime, GetScreenshot.Callback paramCallback) {}
  
  public void onResult(Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      this.val$callback.onGetScreenshot(SaveCaptureImageUitl.cutAndSaveShareScreenshot(this.this$0, paramBitmap));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.AppBrandRuntime.2
 * JD-Core Version:    0.7.0.1
 */