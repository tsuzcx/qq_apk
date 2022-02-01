package com.tencent.rtmp;

import android.graphics.Bitmap;
import com.tencent.trtc.TRTCCloudListener.TRTCSnapshotListener;

class WXLivePlayer$2
  implements TRTCCloudListener.TRTCSnapshotListener
{
  WXLivePlayer$2(WXLivePlayer paramWXLivePlayer, TXLivePlayer.ITXSnapshotListener paramITXSnapshotListener) {}
  
  public void onSnapshotComplete(Bitmap paramBitmap)
  {
    TXLivePlayer.ITXSnapshotListener localITXSnapshotListener = this.val$listener;
    if (localITXSnapshotListener != null) {
      localITXSnapshotListener.onSnapshot(paramBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.rtmp.WXLivePlayer.2
 * JD-Core Version:    0.7.0.1
 */