package com.tencent.youtu;

import android.content.res.AssetManager;

public class YTFaceTracker
{
  private long nativePtr;
  
  public YTFaceTracker(AssetManager paramAssetManager, String paramString1, String paramString2)
  {
    int i = NativeConstructor(paramAssetManager, paramString1, paramString2);
    if (i == 0) {
      return;
    }
    paramAssetManager = new StringBuilder();
    paramAssetManager.append("error model dirpath and config filaneme: ");
    paramAssetManager.append(i);
    throw new IllegalAccessError(paramAssetManager.toString());
  }
  
  public YTFaceTracker(String paramString1, String paramString2)
  {
    int i = NativeConstructor(paramString1, paramString2);
    if (i == 0) {
      return;
    }
    paramString1 = new StringBuilder();
    paramString1.append("error model dirpath and config filaneme: ");
    paramString1.append(i);
    throw new IllegalAccessError(paramString1.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.youtu.YTFaceTracker
 * JD-Core Version:    0.7.0.1
 */