package com.tencent.mobileqq.pic;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Rect;

public final class JpegDecompressor
{
  private boolean idRgb = true;
  public int imageHeight = 0;
  public int imageWidth = 0;
  private int insample = 0;
  private long nativePtr;
  public int outHeight = 0;
  public int outWidth = 0;
  
  static
  {
    try
    {
      if (!JpegCompressor.soLoadStatus) {
        JpegCompressor.jpegcompressLoadSo();
      }
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      localUnsatisfiedLinkError.printStackTrace();
      JpegCompressor.soLoadStatus = false;
    }
  }
  
  public JpegDecompressor()
  {
    try
    {
      this.nativePtr = init();
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError) {}
  }
  
  private void computeOutWidthHeight()
  {
    computeOutWidthHeight(new Rect(0, 0, this.imageWidth, this.imageHeight));
  }
  
  private void computeOutWidthHeight(Rect paramRect)
  {
    int i = paramRect.right;
    int j = paramRect.left;
    int k = paramRect.bottom;
    int m = paramRect.top;
    if (this.insample <= 0) {
      this.insample = 1;
    }
    this.outWidth = ((i - j + this.insample - 1) / this.insample);
    this.outHeight = ((this.insample + (k - m) - 1) / this.insample);
  }
  
  /* Error */
  public static Bitmap decodeByteArray(byte[] paramArrayOfByte, JpegOptions paramJpegOptions)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_1
    //   3: astore_2
    //   4: aload_1
    //   5: ifnonnull +7 -> 12
    //   8: getstatic 80	com/tencent/mobileqq/pic/JpegOptions:DEFAULT	Lcom/tencent/mobileqq/pic/JpegOptions;
    //   11: astore_2
    //   12: new 2	com/tencent/mobileqq/pic/JpegDecompressor
    //   15: dup
    //   16: invokespecial 81	com/tencent/mobileqq/pic/JpegDecompressor:<init>	()V
    //   19: astore_1
    //   20: aload_2
    //   21: getfield 84	com/tencent/mobileqq/pic/JpegOptions:inJustDecodeBounds	Z
    //   24: ifeq +37 -> 61
    //   27: aload_1
    //   28: aload_0
    //   29: aload_2
    //   30: getfield 88	com/tencent/mobileqq/pic/JpegOptions:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   33: invokevirtual 92	com/tencent/mobileqq/pic/JpegDecompressor:computeOutSize	([BLandroid/graphics/Bitmap$Config;)I
    //   36: pop
    //   37: aload_2
    //   38: aload_1
    //   39: getfield 37	com/tencent/mobileqq/pic/JpegDecompressor:imageHeight	I
    //   42: putfield 93	com/tencent/mobileqq/pic/JpegOptions:outHeight	I
    //   45: aload_2
    //   46: aload_1
    //   47: getfield 35	com/tencent/mobileqq/pic/JpegDecompressor:imageWidth	I
    //   50: putfield 94	com/tencent/mobileqq/pic/JpegOptions:outWidth	I
    //   53: aload_3
    //   54: astore_0
    //   55: aload_1
    //   56: invokevirtual 97	com/tencent/mobileqq/pic/JpegDecompressor:close	()V
    //   59: aload_0
    //   60: areturn
    //   61: aload_1
    //   62: aload_0
    //   63: aload_2
    //   64: invokevirtual 100	com/tencent/mobileqq/pic/JpegDecompressor:createBitmap	([BLcom/tencent/mobileqq/pic/JpegOptions;)Landroid/graphics/Bitmap;
    //   67: astore_0
    //   68: goto -13 -> 55
    //   71: astore_0
    //   72: aload_1
    //   73: invokevirtual 97	com/tencent/mobileqq/pic/JpegDecompressor:close	()V
    //   76: aload_0
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	paramArrayOfByte	byte[]
    //   0	78	1	paramJpegOptions	JpegOptions
    //   3	61	2	localJpegOptions	JpegOptions
    //   1	53	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   20	53	71	finally
    //   61	68	71	finally
  }
  
  /* Error */
  public static Bitmap decodeFile(String paramString, JpegOptions paramJpegOptions)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_1
    //   3: astore_2
    //   4: aload_1
    //   5: ifnonnull +7 -> 12
    //   8: getstatic 80	com/tencent/mobileqq/pic/JpegOptions:DEFAULT	Lcom/tencent/mobileqq/pic/JpegOptions;
    //   11: astore_2
    //   12: new 2	com/tencent/mobileqq/pic/JpegDecompressor
    //   15: dup
    //   16: invokespecial 81	com/tencent/mobileqq/pic/JpegDecompressor:<init>	()V
    //   19: astore_1
    //   20: aload_2
    //   21: getfield 84	com/tencent/mobileqq/pic/JpegOptions:inJustDecodeBounds	Z
    //   24: ifeq +37 -> 61
    //   27: aload_1
    //   28: aload_0
    //   29: aload_2
    //   30: getfield 88	com/tencent/mobileqq/pic/JpegOptions:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   33: invokevirtual 105	com/tencent/mobileqq/pic/JpegDecompressor:computeOutSize	(Ljava/lang/String;Landroid/graphics/Bitmap$Config;)I
    //   36: pop
    //   37: aload_2
    //   38: aload_1
    //   39: getfield 37	com/tencent/mobileqq/pic/JpegDecompressor:imageHeight	I
    //   42: putfield 93	com/tencent/mobileqq/pic/JpegOptions:outHeight	I
    //   45: aload_2
    //   46: aload_1
    //   47: getfield 35	com/tencent/mobileqq/pic/JpegDecompressor:imageWidth	I
    //   50: putfield 94	com/tencent/mobileqq/pic/JpegOptions:outWidth	I
    //   53: aload_3
    //   54: astore_0
    //   55: aload_1
    //   56: invokevirtual 97	com/tencent/mobileqq/pic/JpegDecompressor:close	()V
    //   59: aload_0
    //   60: areturn
    //   61: aload_1
    //   62: aload_0
    //   63: aload_2
    //   64: invokevirtual 107	com/tencent/mobileqq/pic/JpegDecompressor:createBitmap	(Ljava/lang/String;Lcom/tencent/mobileqq/pic/JpegOptions;)Landroid/graphics/Bitmap;
    //   67: astore_0
    //   68: goto -13 -> 55
    //   71: astore_0
    //   72: aload_1
    //   73: invokevirtual 97	com/tencent/mobileqq/pic/JpegDecompressor:close	()V
    //   76: aload_0
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	paramString	String
    //   0	78	1	paramJpegOptions	JpegOptions
    //   3	61	2	localJpegOptions	JpegOptions
    //   1	53	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   20	53	71	finally
    //   61	68	71	finally
  }
  
  private native long decompress(long paramLong, byte[] paramArrayOfByte);
  
  private native long decompressBitmap(long paramLong, Bitmap paramBitmap);
  
  private native int decompressFileHeader(long paramLong, String paramString);
  
  private native int decompressHeader(long paramLong, byte[] paramArrayOfByte);
  
  private native void destroy(long paramLong);
  
  private int getPixelSize(Bitmap.Config paramConfig)
  {
    int i = 1;
    if (this.idRgb) {}
    for (int j = 3; paramConfig == null; j = 1) {
      return j;
    }
    if (Bitmap.Config.ARGB_8888 == paramConfig) {
      i = 4;
    }
    for (;;)
    {
      return i;
      if (Bitmap.Config.RGB_565 == paramConfig) {
        i = 2;
      } else if (Bitmap.Config.ALPHA_8 != paramConfig) {
        i = j;
      }
    }
  }
  
  private Bitmap getReuseBitmap(Bitmap.Config paramConfig, Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()) && (paramBitmap.getWidth() == this.outWidth) && (paramBitmap.getHeight() == this.outHeight) && (paramBitmap.getConfig() == paramConfig)) {
      return paramBitmap;
    }
    return Bitmap.createBitmap(this.outWidth, this.outHeight, paramConfig);
  }
  
  private native long init();
  
  private native void setParams(long paramLong, boolean paramBoolean1, int paramInt, boolean paramBoolean2);
  
  public void close()
  {
    try
    {
      if (this.nativePtr != 0L)
      {
        destroy(this.nativePtr);
        this.nativePtr = 0L;
      }
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError) {}
  }
  
  public int computeOutSize(String paramString, Bitmap.Config paramConfig)
  {
    if (!JpegCompressor.soLoadStatus) {
      JpegError.throwException(50);
    }
    try
    {
      i = decompressFileHeader(this.nativePtr, paramString);
      if (i != 0) {
        JpegError.throwException(i);
      }
      computeOutWidthHeight();
      return this.outWidth * this.outHeight * getPixelSize(paramConfig);
    }
    catch (UnsatisfiedLinkError paramString)
    {
      for (;;)
      {
        int i = 52;
      }
    }
  }
  
  public int computeOutSize(byte[] paramArrayOfByte, Bitmap.Config paramConfig)
  {
    if (!JpegCompressor.soLoadStatus) {
      JpegError.throwException(50);
    }
    try
    {
      i = decompressHeader(this.nativePtr, paramArrayOfByte);
      if (i != 0) {
        JpegError.throwException(i);
      }
      computeOutWidthHeight();
      return this.outWidth * this.outHeight * getPixelSize(paramConfig);
    }
    catch (UnsatisfiedLinkError paramArrayOfByte)
    {
      for (;;)
      {
        int i = 52;
      }
    }
  }
  
  public Bitmap createBitmap(String paramString, JpegOptions paramJpegOptions)
  {
    if (!JpegCompressor.soLoadStatus) {
      JpegError.throwException(50);
    }
    setParams(true, paramJpegOptions.inSampleSize, paramJpegOptions.inPreferQualityOverSpeed);
    computeOutSize(paramString, paramJpegOptions.inPreferredConfig);
    return getBitmap(paramJpegOptions.inPreferredConfig, paramJpegOptions.inBitmap);
  }
  
  public Bitmap createBitmap(byte[] paramArrayOfByte, JpegOptions paramJpegOptions)
  {
    if (!JpegCompressor.soLoadStatus) {
      JpegError.throwException(50);
    }
    setParams(true, paramJpegOptions.inSampleSize, paramJpegOptions.inPreferQualityOverSpeed);
    computeOutSize(paramArrayOfByte, paramJpegOptions.inPreferredConfig);
    return getBitmap(paramJpegOptions.inPreferredConfig, paramJpegOptions.inBitmap);
  }
  
  public int decompress(byte[] paramArrayOfByte)
  {
    if (!JpegCompressor.soLoadStatus) {
      JpegError.throwException(50);
    }
    int i = 0;
    try
    {
      long l = decompress(this.nativePtr, paramArrayOfByte);
      j = (int)(l & 0xFFFFFFFF);
      i = (int)(l >> 32 & 0xFFFFFFFF);
    }
    catch (UnsatisfiedLinkError paramArrayOfByte)
    {
      for (;;)
      {
        int j = 52;
      }
    }
    if (j != 0) {
      JpegError.throwException(j);
    }
    return i;
  }
  
  Bitmap getBitmap(Bitmap.Config paramConfig, Bitmap paramBitmap)
  {
    paramBitmap = getReuseBitmap(paramConfig, paramBitmap);
    try
    {
      long l = decompressBitmap(this.nativePtr, paramBitmap);
      i = (int)(l & 0xFFFFFFFF);
    }
    catch (UnsatisfiedLinkError paramConfig)
    {
      for (;;)
      {
        int i = 52;
      }
    }
    paramConfig = paramBitmap;
    if (i != 0)
    {
      paramBitmap.recycle();
      paramConfig = null;
      JpegError.throwException(i);
    }
    return paramConfig;
  }
  
  public void setParams(boolean paramBoolean)
  {
    try
    {
      setParams(this.nativePtr, paramBoolean, 0, false);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError) {}
  }
  
  public void setParams(boolean paramBoolean, int paramInt)
  {
    try
    {
      setParams(this.nativePtr, paramBoolean, paramInt, false);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError) {}
  }
  
  public void setParams(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    try
    {
      this.insample = paramInt;
      setParams(this.nativePtr, paramBoolean1, paramInt, paramBoolean2);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.pic.JpegDecompressor
 * JD-Core Version:    0.7.0.1
 */