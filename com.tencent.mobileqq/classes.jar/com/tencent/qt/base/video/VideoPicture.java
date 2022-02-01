package com.tencent.qt.base.video;

import android.graphics.Bitmap.Config;
import java.nio.ByteBuffer;

public class VideoPicture
{
  public int got;
  public ByteBuffer picture;
  public Bitmap.Config pixelFormat;
  public byte[] pixels;
  public int realheight;
  public int realwidth;
  
  public VideoPicture(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    this.pixelFormat = paramConfig;
    boolean bool = paramConfig.equals(Bitmap.Config.RGB_565);
    int i = 2;
    if ((!bool) && (!paramConfig.equals(Bitmap.Config.ARGB_4444)) && (paramConfig.equals(Bitmap.Config.ARGB_8888))) {
      i = 4;
    }
    this.pixels = new byte[paramInt1 * paramInt2 * i];
    paramConfig = this.pixels;
    this.picture = ByteBuffer.wrap(paramConfig, 0, paramConfig.length);
    this.got = 0;
  }
  
  public void clear()
  {
    if (this.got == 1)
    {
      this.got = 0;
      if (this.picture.remaining() == 0) {
        this.picture.rewind();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qt.base.video.VideoPicture
 * JD-Core Version:    0.7.0.1
 */