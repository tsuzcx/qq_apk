package com.tencent.mobileqq.structmsg.view;

import android.graphics.Bitmap;
import com.tencent.image.DownloadParams;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.utils.ImageUtil;

class StructMsgItemVideo$CornerDecoder
  extends URLDrawableDecodeHandler
{
  private int A = 0;
  private int B = 0;
  private int C = 0;
  
  public StructMsgItemVideo$CornerDecoder(StructMsgItemVideo paramStructMsgItemVideo, int paramInt1, int paramInt2, int paramInt3)
  {
    this.A = paramInt1;
    this.B = paramInt2;
    this.C = paramInt3;
  }
  
  public Bitmap run(DownloadParams paramDownloadParams, Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return null;
    }
    int j = this.C;
    int k = paramBitmap.getWidth();
    if (paramBitmap.getHeight() != 0) {
      i = paramBitmap.getHeight();
    } else {
      i = this.C;
    }
    int i = j * k / i;
    return ImageUtil.b(paramBitmap, this.A, i, this.C);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemVideo.CornerDecoder
 * JD-Core Version:    0.7.0.1
 */