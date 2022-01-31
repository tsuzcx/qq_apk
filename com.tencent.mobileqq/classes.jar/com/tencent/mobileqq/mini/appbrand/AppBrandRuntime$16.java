package com.tencent.mobileqq.mini.appbrand;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCaptureImageListener;

class AppBrandRuntime$16
  implements TVK_IMediaPlayer.OnCaptureImageListener
{
  AppBrandRuntime$16(AppBrandRuntime paramAppBrandRuntime, ViewGroup paramViewGroup, BaseAppBrandRuntime.ShareScreenshotCallback paramShareScreenshotCallback, View paramView) {}
  
  public void onCaptureImageFailed(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2)
  {
    AppBrandRuntime.access$400(this.this$0, this.val$screenshotCallback, this.val$contentLayout);
  }
  
  public void onCaptureImageSucceed(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      QLog.d("AppBrandRuntime", 2, new Object[] { "onCaptureImageSucceed ", paramBitmap.getWidth() + "x" + paramBitmap.getHeight() });
      paramTVK_IMediaPlayer = AppBrandRuntime.access$300(this.this$0, this.val$contentLayout);
      if ((paramTVK_IMediaPlayer == null) || (paramTVK_IMediaPlayer.isRecycled())) {
        if (this.val$screenshotCallback != null) {
          this.val$screenshotCallback.onGetShareScreenshot(null);
        }
      }
      for (;;)
      {
        this.this$0.isGettingScreenShot = false;
        return;
        Canvas localCanvas = new Canvas(paramTVK_IMediaPlayer);
        ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.val$view.getLayoutParams();
        localCanvas.drawBitmap(paramBitmap, localMarginLayoutParams.leftMargin, localMarginLayoutParams.topMargin, null);
        ThreadManagerV2.executeOnFileThread(new AppBrandRuntime.16.1(this, paramTVK_IMediaPlayer));
      }
    }
    AppBrandRuntime.access$400(this.this$0, this.val$screenshotCallback, this.val$contentLayout);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.AppBrandRuntime.16
 * JD-Core Version:    0.7.0.1
 */