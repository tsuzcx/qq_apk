package com.tencent.rlottie;

import android.graphics.Bitmap;

class AXrLottieNative
{
  public static native void clearDir(String paramString, long paramLong, boolean paramBoolean);
  
  public static native void configureModelCacheSize(int paramInt);
  
  public static native long create(String paramString1, int paramInt1, int paramInt2, int[] paramArrayOfInt, boolean paramBoolean1, boolean paramBoolean2, String paramString2);
  
  public static native void createCache(long paramLong, int paramInt1, int paramInt2);
  
  public static native long createWithJson(String paramString1, String paramString2, int[] paramArrayOfInt);
  
  public static native void destroy(long paramLong);
  
  public static native long getDirSize(String paramString, boolean paramBoolean);
  
  public static native long getFileCount(String paramString, boolean paramBoolean);
  
  public static native int getFrame(long paramLong, int paramInt1, Bitmap paramBitmap, int paramInt2, int paramInt3, int paramInt4);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rlottie.AXrLottieNative
 * JD-Core Version:    0.7.0.1
 */