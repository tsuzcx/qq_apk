package com.tencent.qqmini.miniapp.core;

import android.graphics.Bitmap;
import android.view.ViewGroup;
import com.tencent.qqmini.miniapp.core.page.PageWebview.WebviewShotCallback;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.core.utils.ICaptureImageCallback;

class AppBrandRuntime$4
  implements PageWebview.WebviewShotCallback
{
  AppBrandRuntime$4(AppBrandRuntime paramAppBrandRuntime, ICaptureImageCallback paramICaptureImageCallback, ViewGroup paramViewGroup) {}
  
  public void onShotReady(Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      ThreadManager.executeOnDiskIOThreadPool(new AppBrandRuntime.4.1(this, paramBitmap));
      return;
    }
    paramBitmap = this.val$callback;
    if (paramBitmap != null)
    {
      AppBrandRuntime.access$100(this.this$0, paramBitmap, this.val$contentLayout);
      this.this$0.isGettingScreenShot = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.AppBrandRuntime.4
 * JD-Core Version:    0.7.0.1
 */