package com.tencent.rtmp;

import android.graphics.Bitmap;

class a$5
  implements Runnable
{
  a$5(a parama, TXLivePlayer.ITXSnapshotListener paramITXSnapshotListener, Bitmap paramBitmap) {}
  
  public void run()
  {
    TXLivePlayer.ITXSnapshotListener localITXSnapshotListener = this.a;
    if (localITXSnapshotListener != null) {
      localITXSnapshotListener.onSnapshot(this.b);
    }
    a.a(this.c, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.rtmp.a.5
 * JD-Core Version:    0.7.0.1
 */