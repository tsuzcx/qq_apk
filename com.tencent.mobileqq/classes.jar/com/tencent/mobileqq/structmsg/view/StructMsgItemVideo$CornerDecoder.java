package com.tencent.mobileqq.structmsg.view;

import android.graphics.Bitmap;
import com.tencent.image.DownloadParams;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.utils.ImageUtil;

class StructMsgItemVideo$CornerDecoder
  extends URLDrawableDecodeHandler
{
  private int jdField_a_of_type_Int = 0;
  private int b = 0;
  private int c = 0;
  
  public StructMsgItemVideo$CornerDecoder(StructMsgItemVideo paramStructMsgItemVideo, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
  }
  
  public Bitmap run(DownloadParams paramDownloadParams, Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return null;
    }
    int j = this.c;
    int k = paramBitmap.getWidth();
    if (paramBitmap.getHeight() != 0) {}
    for (int i = paramBitmap.getHeight();; i = this.c)
    {
      i = k * j / i;
      return ImageUtil.b(paramBitmap, this.jdField_a_of_type_Int, i, this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemVideo.CornerDecoder
 * JD-Core Version:    0.7.0.1
 */