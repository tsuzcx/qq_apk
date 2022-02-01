package com.tencent.qqmini.miniapp.core;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnCaptureImageListener;
import com.tencent.qqmini.sdk.launcher.core.utils.ICaptureImageCallback;
import com.tencent.qqmini.sdk.utils.SaveCaptureImageUitl;

class AppBrandRuntime$5
  implements AbsVideoPlayer.OnCaptureImageListener
{
  AppBrandRuntime$5(AppBrandRuntime paramAppBrandRuntime, ViewGroup paramViewGroup, ICaptureImageCallback paramICaptureImageCallback, View paramView) {}
  
  public void onCaptureImageFailed()
  {
    AppBrandRuntime.access$100(this.this$0, this.val$callback, this.val$contentLayout);
    this.this$0.isGettingScreenShot = false;
  }
  
  public void onCaptureImageSucceed(Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      Bitmap localBitmap = SaveCaptureImageUitl.buildBitmapFromView(this.val$contentLayout);
      if ((localBitmap != null) && (!localBitmap.isRecycled()))
      {
        Canvas localCanvas = new Canvas(localBitmap);
        ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.val$nativeVideoView.getLayoutParams();
        localCanvas.drawBitmap(paramBitmap, localMarginLayoutParams.leftMargin, localMarginLayoutParams.topMargin, null);
        ThreadManager.executeOnDiskIOThreadPool(new AppBrandRuntime.5.1(this, localBitmap));
      }
      else
      {
        paramBitmap = this.val$callback;
        if (paramBitmap != null) {
          paramBitmap.onResult(null);
        }
      }
      this.this$0.isGettingScreenShot = false;
    }
    else
    {
      AppBrandRuntime.access$100(this.this$0, this.val$callback, this.val$contentLayout);
    }
    this.this$0.isGettingScreenShot = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.AppBrandRuntime.5
 * JD-Core Version:    0.7.0.1
 */