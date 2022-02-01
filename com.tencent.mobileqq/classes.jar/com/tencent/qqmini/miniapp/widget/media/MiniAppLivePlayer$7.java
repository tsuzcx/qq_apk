package com.tencent.qqmini.miniapp.widget.media;

import android.graphics.Bitmap;
import com.tencent.qqmini.miniapp.widget.media.live.TXLivePlayerJSAdapter.ISnapshotOuterListener;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;

class MiniAppLivePlayer$7
  implements TXLivePlayerJSAdapter.ISnapshotOuterListener
{
  MiniAppLivePlayer$7(MiniAppLivePlayer paramMiniAppLivePlayer, String paramString, RequestEvent paramRequestEvent) {}
  
  public void onSnapshot(Bitmap paramBitmap)
  {
    ThreadManager.executeOnDiskIOThreadPool(new MiniAppLivePlayer.7.1(this, paramBitmap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.media.MiniAppLivePlayer.7
 * JD-Core Version:    0.7.0.1
 */