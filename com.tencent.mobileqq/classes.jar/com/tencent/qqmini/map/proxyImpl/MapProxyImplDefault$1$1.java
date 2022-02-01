package com.tencent.qqmini.map.proxyImpl;

import android.graphics.Bitmap;
import com.tencent.qqmini.sdk.launcher.core.proxy.MapProxy.MapSnapshotCallback;

class MapProxyImplDefault$1$1
  implements Runnable
{
  MapProxyImplDefault$1$1(MapProxyImplDefault.1 param1, Bitmap paramBitmap) {}
  
  public void run()
  {
    if (this.this$1.val$callback != null) {
      this.this$1.val$callback.onSnapshotReady(this.val$rootBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.map.proxyImpl.MapProxyImplDefault.1.1
 * JD-Core Version:    0.7.0.1
 */