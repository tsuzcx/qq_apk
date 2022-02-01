package com.tencent.rtmp;

import android.graphics.Bitmap;

class b$2
  implements Runnable
{
  b$2(b paramb, TXLivePusher.ITXSnapshotListener paramITXSnapshotListener, Bitmap paramBitmap) {}
  
  public void run()
  {
    TXLivePusher.ITXSnapshotListener localITXSnapshotListener = this.a;
    if (localITXSnapshotListener != null) {
      localITXSnapshotListener.onSnapshot(this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.rtmp.b.2
 * JD-Core Version:    0.7.0.1
 */