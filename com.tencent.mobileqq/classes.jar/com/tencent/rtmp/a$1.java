package com.tencent.rtmp;

import android.graphics.Bitmap;
import com.tencent.liteav.basic.opengl.p;

class a$1
  implements p
{
  a$1(a parama, TXLivePlayer.ITXSnapshotListener paramITXSnapshotListener) {}
  
  public void onTakePhotoComplete(Bitmap paramBitmap)
  {
    a.a(this.b, this.a, paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rtmp.a.1
 * JD-Core Version:    0.7.0.1
 */