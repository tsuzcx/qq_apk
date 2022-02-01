package com.tencent.rtmp;

import android.graphics.Bitmap;
import android.os.Handler;
import com.tencent.liteav.basic.opengl.p;

class TXLivePusherImpl$16
  implements p
{
  TXLivePusherImpl$16(TXLivePusherImpl paramTXLivePusherImpl, TXLivePusher.ITXSnapshotListener paramITXSnapshotListener) {}
  
  public void onTakePhotoComplete(Bitmap paramBitmap)
  {
    TXLivePusherImpl.a(this.b, this.a, paramBitmap);
    TXLivePusherImpl.a(this.b, false);
    TXLivePusherImpl.f(this.b).removeCallbacks(TXLivePusherImpl.h(this.b));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rtmp.TXLivePusherImpl.16
 * JD-Core Version:    0.7.0.1
 */