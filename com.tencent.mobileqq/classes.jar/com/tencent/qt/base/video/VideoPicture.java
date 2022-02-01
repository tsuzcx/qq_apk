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
    int i;
    if (paramConfig.equals(Bitmap.Config.RGB_565)) {
      i = j;
    }
    for (;;)
    {
      this.pixels = new byte[i * (paramInt1 * paramInt2)];
      this.picture = ByteBuffer.wrap(this.pixels, 0, this.pixels.length);
      this.got = 0;
      return;
      i = j;
      if (!paramConfig.equals(Bitmap.Config.ARGB_4444))
      {
        i = j;
        if (paramConfig.equals(Bitmap.Config.ARGB_8888)) {
          i = 4;
        }
      }
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qt.base.video.VideoPicture
 * JD-Core Version:    0.7.0.1
 */