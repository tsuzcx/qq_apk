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
    if (paramBitmap != null)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onCaptureImageSucceed ");
      ((StringBuilder)localObject).append(paramBitmap.getWidth());
      ((StringBuilder)localObject).append("x");
      ((StringBuilder)localObject).append(paramBitmap.getHeight());
      QMLog.d("MapProxyImplDefault", ((StringBuilder)localObject).toString());
      localObject = SaveCaptureImageUitl.buildBitmapFromView(this.val$contentLayout);
      if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
      {
        Canvas localCanvas = new Canvas((Bitmap)localObject);
        ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.val$view.getLayoutParams();
        localCanvas.drawBitmap(paramBitmap, localMarginLayoutParams.leftMargin, localMarginLayoutParams.topMargin, null);
        ThreadManager.executeOnDiskIOThreadPool(new MapProxyImplDefault.1.1(this, (Bitmap)localObject));
        return;
      }
      paramBitmap = this.val$callback;
      if (paramBitmap != null) {
        paramBitmap.onSnapshotReady(null);
      }
    }
    else
    {
      paramBitmap = SaveCaptureImageUitl.buildBitmapFromView(this.val$contentLayout);
      if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
      {
        ThreadManager.executeOnDiskIOThreadPool(new MapProxyImplDefault.1.2(this, paramBitmap));
        return;
      }
      paramBitmap = this.val$callback;
      if (paramBitmap != null) {
        paramBitmap.onSnapshotReady(null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.map.proxyImpl.MapProxyImplDefault.1
 * JD-Core Version:    0.7.0.1
 */