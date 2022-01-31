package com.tencent.youtufacetrack;

import com.tencent.ttpic.facedetect.FaceStatus;

public class YoutuFaceTrack
{
  private static long handle;
  private static YoutuFaceTrack instance = null;
  private long nativePtr;
  
  static
  {
    handle = 0L;
    System.loadLibrary("facetrackwrap");
    nativeInit();
  }
  
  public YoutuFaceTrack()
  {
    NativeConstructor();
  }
  
  private native void NativeConstructor();
  
  private native void NativeDestructor();
  
  public static long getHandle()
  {
    return handle;
  }
  
  public static YoutuFaceTrack getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new YoutuFaceTrack();
      }
      YoutuFaceTrack localYoutuFaceTrack = instance;
      return localYoutuFaceTrack;
    }
    finally {}
  }
  
  private static native boolean nativeInit();
  
  public native FaceStatus[] DoDetectionProcessRGBA(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public native FaceStatus[] DoDetectionProcessYUV(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public native boolean Init(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
  
  public void destroy()
  {
    NativeDestructor();
  }
  
  protected void finalize()
    throws Throwable
  {
    NativeDestructor();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.youtufacetrack.YoutuFaceTrack
 * JD-Core Version:    0.7.0.1
 */