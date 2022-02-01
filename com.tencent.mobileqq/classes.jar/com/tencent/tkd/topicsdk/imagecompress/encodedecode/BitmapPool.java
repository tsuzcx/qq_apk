package com.tencent.tkd.topicsdk.imagecompress.encodedecode;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import org.jetbrains.annotations.NotNull;

public abstract interface BitmapPool
{
  @NotNull
  public abstract Bitmap a(int paramInt1, int paramInt2, Bitmap.Config paramConfig);
  
  public abstract void a(Bitmap paramBitmap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.imagecompress.encodedecode.BitmapPool
 * JD-Core Version:    0.7.0.1
 */