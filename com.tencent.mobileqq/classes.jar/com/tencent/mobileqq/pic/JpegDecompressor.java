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
      if (!JpegCompressor.soLoadStatus)
      {
        JpegCompressor.jpegcompressLoadSo();
        return;
      }
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
    int n = this.insample;
    this.outWidth = ((i - j + n - 1) / n);
    this.outHeight = ((k - m + n - 1) / n);
  }
  
  public static Bitmap decodeByteArray(byte[] paramArrayOfByte, JpegOptions paramJpegOptions)
  {
    JpegOptions localJpegOptions = paramJpegOptions;
    if (paramJpegOptions == null) {
      localJpegOptions = JpegOptions.DEFAULT;
    }
    paramJpegOptions = new JpegDecompressor();
    try
    {
      if (localJpegOptions.inJustDecodeBounds)
      {
        paramJpegOptions.computeOutSize(paramArrayOfByte, localJpegOptions.inPreferredConfig);
        localJpegOptions.outHeight = paramJpegOptions.imageHeight;
        localJpegOptions.outWidth = paramJpegOptions.imageWidth;
        paramArrayOfByte = null;
      }
      else
      {
        paramArrayOfByte = paramJpegOptions.createBitmap(paramArrayOfByte, localJpegOptions);
      }
      return paramArrayOfByte;
    }
    finally
    {
      paramJpegOptions.close();
    }
  }
  
  public static Bitmap decodeFile(String paramString, JpegOptions paramJpegOptions)
  {
    JpegOptions localJpegOptions = paramJpegOptions;
    if (paramJpegOptions == null) {
      localJpegOptions = JpegOptions.DEFAULT;
    }
    paramJpegOptions = new JpegDecompressor();
    try
    {
      if (localJpegOptions.inJustDecodeBounds)
      {
        paramJpegOptions.computeOutSize(paramString, localJpegOptions.inPreferredConfig);
        localJpegOptions.outHeight = paramJpegOptions.imageHeight;
        localJpegOptions.outWidth = paramJpegOptions.imageWidth;
        paramString = null;
      }
      else
      {
        paramString = paramJpegOptions.createBitmap(paramString, localJpegOptions);
      }
      return paramString;
    }
    finally
    {
      paramJpegOptions.close();
    }
  }
  
  private native long decompress(long paramLong, byte[] paramArrayOfByte);
  
  private native long decompressBitmap(long paramLong, Bitmap paramBitmap);
  
  private native int decompressFileHeader(long paramLong, String paramString);
  
  private native int decompressHeader(long paramLong, byte[] paramArrayOfByte);
  
  private native void destroy(long paramLong);
  
  private int getPixelSize(Bitmap.Config paramConfig)
  {
    int i;
    if (this.idRgb) {
      i = 3;
    } else {
      i = 1;
    }
    if (paramConfig == null) {
      return i;
    }
    if (Bitmap.Config.ARGB_8888 == paramConfig) {
      return 4;
    }
    if (Bitmap.Config.RGB_565 == paramConfig) {
      return 2;
    }
    if (Bitmap.Config.ALPHA_8 == paramConfig) {
      return 1;
    }
    return i;
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
    }
    catch (UnsatisfiedLinkError paramString)
    {
      int i;
      label24:
      break label24;
    }
    i = 52;
    if (i != 0) {
      JpegError.throwException(i);
    }
    computeOutWidthHeight();
    return this.outWidth * this.outHeight * getPixelSize(paramConfig);
  }
  
  public int computeOutSize(byte[] paramArrayOfByte, Bitmap.Config paramConfig)
  {
    if (!JpegCompressor.soLoadStatus) {
      JpegError.throwException(50);
    }
    try
    {
      i = decompressHeader(this.nativePtr, paramArrayOfByte);
    }
    catch (UnsatisfiedLinkError paramArrayOfByte)
    {
      int i;
      label24:
      break label24;
    }
    i = 52;
    if (i != 0) {
      JpegError.throwException(i);
    }
    computeOutWidthHeight();
    return this.outWidth * this.outHeight * getPixelSize(paramConfig);
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
      int j;
      label46:
      break label46;
    }
    j = 52;
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
      int i;
      label29:
      break label29;
    }
    i = 52;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pic.JpegDecompressor
 * JD-Core Version:    0.7.0.1
 */