package com.tencent.youtu.rapidnet.library;

import android.graphics.Bitmap;

public class TNNSegHuman
{
  private long nativePtr;
  
  public native int deinit();
  
  public native int forward2(int paramInt1, int paramInt2);
  
  public native Bitmap forwardWithAngle(Bitmap paramBitmap, int paramInt);
  
  public native Bitmap forwardWithBox(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public long getNativePtr()
  {
    return this.nativePtr;
  }
  
  public native int init(String paramString1, String paramString2, String paramString3);
  
  public native void setIntervalFrames(int paramInt);
  
  public native void setMode(int paramInt);
  
  public void setNativePtr(long paramLong)
  {
    this.nativePtr = paramLong;
  }
  
  public native void setSegGaussianBlurMode(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.youtu.rapidnet.library.TNNSegHuman
 * JD-Core Version:    0.7.0.1
 */