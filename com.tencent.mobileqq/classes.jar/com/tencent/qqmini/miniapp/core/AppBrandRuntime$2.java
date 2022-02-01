package com.tencent.qqmini.miniapp.core;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.core.action.GetScreenshot.Callback;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnCaptureImageListener;
import com.tencent.qqmini.sdk.utils.SaveCaptureImageUitl;

class AppBrandRuntime$2
  implements AbsVideoPlayer.OnCaptureImageListener
{
  AppBrandRuntime$2(AppBrandRuntime paramAppBrandRuntime, ViewGroup paramViewGroup, GetScreenshot.Callback paramCallback, View paramView) {}
  
  public void onCaptureImageFailed(AbsVideoPlayer paramAbsVideoPlayer)
  {
    AppBrandRuntime.access$100(this.this$0, this.val$callback, this.val$contentLayout);
    this.this$0.isGettingScreenShot = false;
  }
  
  public void onCaptureImageSucceed(AbsVideoPlayer paramAbsVideoPlayer, Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      paramAbsVideoPlayer = SaveCaptureImageUitl.buildBitmapFromView(this.val$contentLayout);
      if ((paramAbsVideoPlayer == null) || (paramAbsVideoPlayer.isRecycled()))
      {
        if (this.val$callback != null) {
          this.val$callback.onGetScreenshot(null);
        }
        this.this$0.isGettingScreenShot = false;
      }
    }
    for (;;)
    {
      this.this$0.isGettingScreenShot = false;
      return;
      Canvas localCanvas = new Canvas(paramAbsVideoPlayer);
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.val$nativeVideoView.getLayoutParams();
      localCanvas.drawBitmap(paramBitmap, localMarginLayoutParams.leftMargin, localMarginLayoutParams.topMargin, null);
      ThreadManager.executeOnDiskIOThreadPool(new AppBrandRuntime.2.1(this, paramAbsVideoPlayer));
      break;
      AppBrandRuntime.access$100(this.this$0, this.val$callback, this.val$contentLayout);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.AppBrandRuntime.2
 * JD-Core Version:    0.7.0.1
 */