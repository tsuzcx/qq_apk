package com.tencent.mobileqq.mini.appbrand;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.SnapshotReadyCallback;

class AppBrandRuntime$18
  implements TencentMap.SnapshotReadyCallback
{
  AppBrandRuntime$18(AppBrandRuntime paramAppBrandRuntime, ViewGroup paramViewGroup, BaseAppBrandRuntime.ShareScreenshotCallback paramShareScreenshotCallback, View paramView) {}
  
  public void onSnapshotReady(Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      QLog.d("AppBrandRuntime", 2, new Object[] { "onCaptureImageSucceed ", paramBitmap.getWidth() + "x" + paramBitmap.getHeight() });
      Bitmap localBitmap = AppBrandRuntime.access$300(this.this$0, this.val$contentLayout);
      if ((localBitmap == null) || (localBitmap.isRecycled())) {
        if (this.val$screenshotCallback != null) {
          this.val$screenshotCallback.onGetShareScreenshot(null);
        }
      }
      for (;;)
      {
        this.this$0.isGettingScreenShot = false;
        return;
        Canvas localCanvas = new Canvas(localBitmap);
        ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.val$mapView.getLayoutParams();
        localCanvas.drawBitmap(paramBitmap, localMarginLayoutParams.leftMargin, localMarginLayoutParams.topMargin, null);
        ThreadManagerV2.executeOnFileThread(new AppBrandRuntime.18.1(this, localBitmap));
      }
    }
    AppBrandRuntime.access$400(this.this$0, this.val$screenshotCallback, this.val$contentLayout);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.AppBrandRuntime.18
 * JD-Core Version:    0.7.0.1
 */