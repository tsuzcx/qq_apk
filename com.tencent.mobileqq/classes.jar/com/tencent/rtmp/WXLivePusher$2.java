package com.tencent.rtmp;

import android.graphics.Bitmap;
import com.tencent.trtc.TRTCCloudListener.TRTCSnapshotListener;

class WXLivePusher$2
  implements TRTCCloudListener.TRTCSnapshotListener
{
  WXLivePusher$2(WXLivePusher paramWXLivePusher, TXLivePusher.ITXSnapshotListener paramITXSnapshotListener) {}
  
  public void onSnapshotComplete(Bitmap paramBitmap)
  {
    TXLivePusher.ITXSnapshotListener localITXSnapshotListener = this.val$listener;
    if (localITXSnapshotListener != null) {
      localITXSnapshotListener.onSnapshot(paramBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.rtmp.WXLivePusher.2
 * JD-Core Version:    0.7.0.1
 */