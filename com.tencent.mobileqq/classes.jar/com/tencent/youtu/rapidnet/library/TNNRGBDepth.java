package com.tencent.youtu.rapidnet.library;

import android.graphics.Bitmap;

public class TNNRGBDepth
{
  private long nativePtr;
  
  public native int deinit();
  
  public native Bitmap forward(Bitmap paramBitmap);
  
  public native int forward2(int paramInt1, int paramInt2);
  
  public native Bitmap forwardWithAngle(Bitmap paramBitmap, int paramInt);
  
  public long getNativePtr()
  {
    return this.nativePtr;
  }
  
  public native int init(String paramString1, String paramString2, String paramString3);
  
  public native void setMode(int paramInt);
  
  public void setNativePtr(long paramLong)
  {
    this.nativePtr = paramLong;
  }
  
  public native void setSegGaussianBlurMode(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.youtu.rapidnet.library.TNNRGBDepth
 * JD-Core Version:    0.7.0.1
 */