package com.tencent.youtufacetrack;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;

public class YoutuFaceTracker
{
  private static long handle;
  private static YoutuFaceTracker instance;
  private long nativePtr;
  
  public YoutuFaceTracker()
  {
    NativeConstructor();
  }
  
  public static native boolean GlobalInit(String paramString);
  
  public static native boolean GlobalRelease();
  
  private native void NativeConstructor();
  
  private native void NativeDestructor();
  
  public static long getHandle()
  {
    return handle;
  }
  
  public static YoutuFaceTracker getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new YoutuFaceTracker();
      }
      YoutuFaceTracker localYoutuFaceTracker = instance;
      return localYoutuFaceTracker;
    }
    finally {}
  }
  
  public static native boolean nativeInit();
  
  public native YoutuFaceTracker.FaceStatus[] DoDetectionProcessBitmap(Bitmap paramBitmap);
  
  public native YoutuFaceTracker.FaceStatus[] DoDetectionProcessYUV(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public native YoutuFaceTracker.FaceStatus3d[] DoDetectionProcessYUVPoses(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public native Bitmap convertYUV2Bitmap(byte[] paramArrayOfByte, int paramInt1, int paramInt2, Bitmap.Config paramConfig);
  
  public void destroy()
  {
    NativeDestructor();
  }
  
  protected void finalize()
  {
    NativeDestructor();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.youtufacetrack.YoutuFaceTracker
 * JD-Core Version:    0.7.0.1
 */