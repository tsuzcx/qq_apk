package com.tencent.rtmp;

import android.graphics.Bitmap;
import android.os.Handler;
import com.tencent.liteav.basic.c.o;

class b$9
  implements o
{
  b$9(b paramb, TXLivePusher.ITXSnapshotListener paramITXSnapshotListener) {}
  
  public void onTakePhotoComplete(Bitmap paramBitmap)
  {
    b.a(this.b, this.a, paramBitmap);
    b.a(this.b, false);
    b.c(this.b).removeCallbacks(b.e(this.b));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.rtmp.b.9
 * JD-Core Version:    0.7.0.1
 */