package com.tencent.qqmini.map.proxyImpl;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.MapProxy.MapSnapshotCallback;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.utils.SaveCaptureImageUitl;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.SnapshotReadyCallback;

class MapProxyImplDefault$1
  implements TencentMap.SnapshotReadyCallback
{
  MapProxyImplDefault$1(MapProxyImplDefault paramMapProxyImplDefault, ViewGroup paramViewGroup, MapProxy.MapSnapshotCallback paramMapSnapshotCallback, View paramView) {}
  
  public void onSnapshotReady(Bitmap paramBitmap)
  {
    Bitmap localBitmap;
    if (paramBitmap != null)
    {
      QMLog.d("MapProxyImplDefault", "onCaptureImageSucceed " + paramBitmap.getWidth() + "x" + paramBitmap.getHeight());
      localBitmap = SaveCaptureImageUitl.buildBitmapFromView(this.val$contentLayout);
      if ((localBitmap == null) || (localBitmap.isRecycled())) {
        if (this.val$callback != null) {
          this.val$callback.onSnapshotReady(null);
        }
      }
    }
    do
    {
      return;
      Canvas localCanvas = new Canvas(localBitmap);
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.val$view.getLayoutParams();
      localCanvas.drawBitmap(paramBitmap, localMarginLayoutParams.leftMargin, localMarginLayoutParams.topMargin, null);
      ThreadManager.executeOnDiskIOThreadPool(new MapProxyImplDefault.1.1(this, localBitmap));
      return;
      paramBitmap = SaveCaptureImageUitl.buildBitmapFromView(this.val$contentLayout);
      if ((paramBitmap != null) && (!paramBitmap.isRecycled())) {
        break;
      }
    } while (this.val$callback == null);
    this.val$callback.onSnapshotReady(null);
    return;
    ThreadManager.executeOnDiskIOThreadPool(new MapProxyImplDefault.1.2(this, paramBitmap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.map.proxyImpl.MapProxyImplDefault.1
 * JD-Core Version:    0.7.0.1
 */