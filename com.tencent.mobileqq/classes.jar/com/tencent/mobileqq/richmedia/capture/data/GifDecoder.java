package com.tencent.mobileqq.richmedia.capture.data;

import android.graphics.Bitmap;

public abstract interface GifDecoder
{
  public abstract Bitmap getNextGifFrame(long paramLong);
  
  public abstract void init();
  
  public abstract void release();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.data.GifDecoder
 * JD-Core Version:    0.7.0.1
 */