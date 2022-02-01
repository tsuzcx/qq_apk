package com.tencent.qqmini.miniapp.plugin;

import android.graphics.Bitmap;
import com.tencent.qqmini.miniapp.widget.media.live.TXLivePlayerJSAdapter.ISnapshotOuterListener;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;

class LivePlayerEmbeddedWidgetClient$3
  implements TXLivePlayerJSAdapter.ISnapshotOuterListener
{
  LivePlayerEmbeddedWidgetClient$3(LivePlayerEmbeddedWidgetClient paramLivePlayerEmbeddedWidgetClient, String paramString, int paramInt) {}
  
  public void onSnapshot(Bitmap paramBitmap)
  {
    ThreadManager.executeOnDiskIOThreadPool(new LivePlayerEmbeddedWidgetClient.3.1(this, paramBitmap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.LivePlayerEmbeddedWidgetClient.3
 * JD-Core Version:    0.7.0.1
 */