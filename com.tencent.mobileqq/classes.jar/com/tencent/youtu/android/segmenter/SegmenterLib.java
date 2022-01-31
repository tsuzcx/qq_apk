package com.tencent.youtu.android.segmenter;

import android.graphics.Bitmap;
import android.util.Log;

public class SegmenterLib
{
  private static boolean sLoadOpenclSuccess = false;
  private long nativePtr;
  
  public SegmenterLib(String paramString1, String paramString2)
  {
    boolean bool = initWithProto(paramString1, paramString2);
    Log.e("SegmenterLib", "initWithProto status:" + bool);
  }
  
  private native boolean getGPUSupportOpenCL();
  
  private native boolean initWithProto(String paramString1, String paramString2);
  
  public static void setSegmentSoStatus(boolean paramBoolean)
  {
    sLoadOpenclSuccess = paramBoolean;
    Log.d("SegmenterLib", "setSegmentSoStatus:" + paramBoolean);
  }
  
  public native void clearSegmentBuffer();
  
  public native int compileKernel();
  
  public native int copyBufferToTexture(int paramInt1, int paramInt2, int paramInt3);
  
  public native int copyTextureToBuffer(int paramInt1, int paramInt2, int paramInt3);
  
  public native void destroy();
  
  public long getNativePtr()
  {
    return this.nativePtr;
  }
  
  public boolean isGPUSupportOpenCL()
  {
    if (sLoadOpenclSuccess) {
      return getGPUSupportOpenCL();
    }
    return false;
  }
  
  public native Bitmap segment(Bitmap paramBitmap);
  
  public native void segmentOnBit(Bitmap paramBitmap1, Bitmap paramBitmap2, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public native void segmentOnBitmap(Bitmap paramBitmap1, Bitmap paramBitmap2, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public native int segmentOnTexture(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, int paramInt5, int paramInt6);
  
  public native int segmentOnTextureV2(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public void setNativePtr(long paramLong)
  {
    this.nativePtr = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.youtu.android.segmenter.SegmenterLib
 * JD-Core Version:    0.7.0.1
 */