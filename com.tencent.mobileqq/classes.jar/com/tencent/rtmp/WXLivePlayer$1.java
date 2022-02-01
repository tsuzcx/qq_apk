package com.tencent.rtmp;

import android.graphics.Bitmap;
import com.tencent.trtc.TRTCCloudListener.TRTCSnapshotListener;

class WXLivePlayer$1
  implements TRTCCloudListener.TRTCSnapshotListener
{
  WXLivePlayer$1(WXLivePlayer paramWXLivePlayer, TXLivePlayer.ITXSnapshotListener paramITXSnapshotListener) {}
  
  public void onSnapshotComplete(Bitmap paramBitmap)
  {
    TXLivePlayer.ITXSnapshotListener localITXSnapshotListener = this.val$listener;
    if (localITXSnapshotListener != null) {
      localITXSnapshotListener.onSnapshot(paramBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rtmp.WXLivePlayer.1
 * JD-Core Version:    0.7.0.1
 */