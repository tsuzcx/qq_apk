package com.tencent.qqmini.miniapp.plugin;

import android.graphics.Bitmap;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.TXLivePushListenerReflect.ITXSnapshotListener;

class LivePusherEmbeddedWidgetClient$5
  implements TXLivePushListenerReflect.ITXSnapshotListener
{
  LivePusherEmbeddedWidgetClient$5(LivePusherEmbeddedWidgetClient paramLivePusherEmbeddedWidgetClient, String paramString, int paramInt) {}
  
  public void onSnapshot(Bitmap paramBitmap)
  {
    ThreadManager.executeOnDiskIOThreadPool(new LivePusherEmbeddedWidgetClient.5.1(this, paramBitmap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.LivePusherEmbeddedWidgetClient.5
 * JD-Core Version:    0.7.0.1
 */