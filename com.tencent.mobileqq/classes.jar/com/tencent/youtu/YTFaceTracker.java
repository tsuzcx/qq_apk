package com.tencent.youtu;

import android.content.res.AssetManager;

public class YTFaceTracker
{
  private long nativePtr;
  
  public YTFaceTracker(AssetManager paramAssetManager, String paramString1, String paramString2)
  {
    int i = NativeConstructor(paramAssetManager, paramString1, paramString2);
    if (i != 0) {
      throw new IllegalAccessError("error model dirpath and config filaneme: " + i);
    }
  }
  
  public YTFaceTracker(String paramString1, String paramString2)
  {
    int i = NativeConstructor(paramString1, paramString2);
    if (i != 0) {
      throw new IllegalAccessError("error model dirpath and config filaneme: " + i);
    }
  }
  
  private native int NativeConstructor(AssetManager paramAssetManager, String paramString1, String paramString2);
  
  private native int NativeConstructor(String paramString1, String paramString2);
  
  private native void NativeDestructor();
  
  public static native String getVersion();
  
  public void destroy()
  {
    NativeDestructor();
  }
  
  protected void finalize()
  {
    NativeDestructor();
  }
  
  public native YTFaceTracker.Param getParam();
  
  public native void reset();
  
  public native void setParam(YTFaceTracker.Param paramParam);
  
  public native YTFaceTracker.TrackedFace[] track(int paramInt1, byte[] paramArrayOfByte1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, byte[] paramArrayOfByte2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.youtu.YTFaceTracker
 * JD-Core Version:    0.7.0.1
 */