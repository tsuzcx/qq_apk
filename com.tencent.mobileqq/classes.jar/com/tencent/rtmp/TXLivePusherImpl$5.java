package com.tencent.rtmp;

import android.graphics.Bitmap;

class TXLivePusherImpl$5
  implements Runnable
{
  TXLivePusherImpl$5(TXLivePusherImpl paramTXLivePusherImpl, TXLivePusher.ITXSnapshotListener paramITXSnapshotListener, Bitmap paramBitmap) {}
  
  public void run()
  {
    TXLivePusher.ITXSnapshotListener localITXSnapshotListener = this.a;
    if (localITXSnapshotListener != null) {
      localITXSnapshotListener.onSnapshot(this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rtmp.TXLivePusherImpl.5
 * JD-Core Version:    0.7.0.1
 */