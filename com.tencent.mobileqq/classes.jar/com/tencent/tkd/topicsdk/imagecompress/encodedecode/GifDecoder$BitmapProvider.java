package com.tencent.tkd.topicsdk.imagecompress.encodedecode;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import org.jetbrains.annotations.NotNull;

public abstract interface GifDecoder$BitmapProvider
{
  @NotNull
  public abstract Bitmap a(int paramInt1, int paramInt2, @NotNull Bitmap.Config paramConfig);
  
  public abstract void a(@NotNull Bitmap paramBitmap);
  
  @NotNull
  public abstract byte[] a(int paramInt);
  
  @NotNull
  public abstract int[] a(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.imagecompress.encodedecode.GifDecoder.BitmapProvider
 * JD-Core Version:    0.7.0.1
 */