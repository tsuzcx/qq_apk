package com.tencent.tkd.topicsdk.imagecompress.encodedecode;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class GifBitmapProvider
  implements GifDecoder.BitmapProvider
{
  @Nullable
  private final ArrayPool jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeArrayPool;
  private final BitmapPool jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeBitmapPool;
  
  public GifBitmapProvider(BitmapPool paramBitmapPool)
  {
    this(paramBitmapPool, null);
  }
  
  public GifBitmapProvider(BitmapPool paramBitmapPool, @Nullable ArrayPool paramArrayPool)
  {
    this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeBitmapPool = paramBitmapPool;
    this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeArrayPool = paramArrayPool;
  }
  
  @NotNull
  public Bitmap a(int paramInt1, int paramInt2, @NotNull Bitmap.Config paramConfig)
  {
    return this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeBitmapPool.a(paramInt1, paramInt2, paramConfig);
  }
  
  public void a(@NotNull Bitmap paramBitmap)
  {
    this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeBitmapPool.a(paramBitmap);
  }
  
  @NotNull
  public byte[] a(int paramInt)
  {
    ArrayPool localArrayPool = this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeArrayPool;
    if (localArrayPool == null) {
      return new byte[paramInt];
    }
    return (byte[])localArrayPool.a(paramInt, [B.class);
  }
  
  @NotNull
  public int[] a(int paramInt)
  {
    ArrayPool localArrayPool = this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeArrayPool;
    if (localArrayPool == null) {
      return new int[paramInt];
    }
    return (int[])localArrayPool.a(paramInt, [I.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.imagecompress.encodedecode.GifBitmapProvider
 * JD-Core Version:    0.7.0.1
 */