package com.tencent.youtu.rapidnet.library;

import android.graphics.Bitmap;

public class TNNGesture
{
  public static String[] gestureType = { "HEART", "PAPER", "SCISSOR", "FIST", "ONE", "LOVE", "LIKE", "OK", "ROCK", "SIX", "EIGHT", "LIFT", "OTHERS", "UNKNOWN", "THREE", "FOUR" };
  private long nativePtr;
  
  private native void setFaceBox(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);
  
  public native int gestureAllDeinit();
  
  public native int gestureAllInit(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10);
  
  public native int gestureClassifyDeinit();
  
  public native Bitmap gestureClassifyForward(Bitmap paramBitmap);
  
  public native int gestureClassifyInit(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6);
  
  public native int gestureClassifyResult(Bitmap paramBitmap);
  
  public native float[] gestureClassifyResultWithBox(Bitmap paramBitmap, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);
  
  public native int gestureClassifySetPrevNumOfFrame(int paramInt);
  
  public native int gestureDetectDeinit();
  
  public native Bitmap gestureDetectForward(Bitmap paramBitmap);
  
  public native float[] gestureDetectGetBox(Bitmap paramBitmap);
  
  public native int gestureDetectInit(String paramString1, String paramString2);
  
  public native float[] gestureKeyPointsAndClassifyResult(Bitmap paramBitmap);
  
  public native float[] gestureKeypointResult(Bitmap paramBitmap, int paramInt);
  
  public native float[] gestureKeypointResultWithBox(Bitmap paramBitmap, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt);
  
  public native int gestureKeypointsDeinit();
  
  public native Bitmap gestureKeypointsForward(Bitmap paramBitmap);
  
  public native int gestureKeypointsInit(String paramString1, String paramString2, String paramString3, String paramString4);
  
  public native void gestureSetKeypointsPreFrame(int paramInt);
  
  public long getNativePtr()
  {
    return this.nativePtr;
  }
  
  public void setNativePtr(long paramLong)
  {
    this.nativePtr = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.youtu.rapidnet.library.TNNGesture
 * JD-Core Version:    0.7.0.1
 */