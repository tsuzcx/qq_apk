package com.tencent.tkd.topicsdk.imagecompress.encodedecode;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class GifBitmapProvider
  implements GifDecoder.BitmapProvider
{
  private final BitmapPool a;
  @Nullable
  private final ArrayPool b;
  
  public GifBitmapProvider(BitmapPool paramBitmapPool)
  {
    this(paramBitmapPool, null);
  }
  
  public GifBitmapProvider(BitmapPool paramBitmapPool, @Nullable ArrayPool paramArrayPool)
  {
    this.a = paramBitmapPool;
    this.b = paramArrayPool;
  }
  
  @NotNull
  public Bitmap a(int paramInt1, int paramInt2, @NotNull Bitmap.Config paramConfig)
  {
    return this.a.a(paramInt1, paramInt2, paramConfig);
  }
  
  public void a(@NotNull Bitmap paramBitmap)
  {
    this.a.a(paramBitmap);
  }
  
  @NotNull
  public byte[] a(int paramInt)
  {
    ArrayPool localArrayPool = this.b;
    if (localArrayPool == null) {
      return new byte[paramInt];
    }
    return (byte[])localArrayPool.a(paramInt, [B.class);
  }
  
  @NotNull
  public int[] b(int paramInt)
  {
    ArrayPool localArrayPool = this.b;
    if (localArrayPool == null) {
      return new int[paramInt];
    }
    return (int[])localArrayPool.a(paramInt, [I.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.imagecompress.encodedecode.GifBitmapProvider
 * JD-Core Version:    0.7.0.1
 */