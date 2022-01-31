package com.tencent.youtu.rapidnet.library;

import android.graphics.Bitmap;
import com.tencent.ttpic.util.SoInfo;

public class RapidnetLib
{
  private long nativePtr;
  
  @SoInfo(libName="rapidnet_wrapper")
  public native int deinit();
  
  @SoInfo(libName="rapidnet_wrapper")
  public native Bitmap forward(Bitmap paramBitmap);
  
  @SoInfo(libName="rapidnet_wrapper")
  public native int forward2(int paramInt1, int paramInt2);
  
  @SoInfo(libName="rapidnet_wrapper")
  public native Bitmap forwardWithAngle(Bitmap paramBitmap, int paramInt);
  
  public long getNativePtr()
  {
    return this.nativePtr;
  }
  
  @SoInfo(libName="rapidnet_wrapper")
  public native int init(String paramString1, String paramString2);
  
  @SoInfo(libName="rapidnet_wrapper")
  public native int init(String paramString1, String paramString2, int paramInt);
  
  public void setNativePtr(long paramLong)
  {
    this.nativePtr = paramLong;
  }
  
  @SoInfo(libName="rapidnet_wrapper")
  public native void setSegGaussianBlurMode(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.youtu.rapidnet.library.RapidnetLib
 * JD-Core Version:    0.7.0.1
 */