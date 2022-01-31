package com.tracking.sdk;

public class TrackerManager
{
  public static final int ASMS = 1;
  public static final int CMT = 0;
  public static final int TYPE_GRAY = 3;
  public static final int TYPE_I420 = 4;
  public static final int TYPE_NV21 = 0;
  public static final int TYPE_RGB = 1;
  public static final int TYPE_RGBA = 2;
  
  private TrackerManager()
  {
    init();
  }
  
  public static TrackerManager newInstance()
  {
    return TrackerManager.ObjTrackHolder.instance;
  }
  
  public void init() {}
  
  public native boolean openTrack(byte[] paramArrayOfByte, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt3, int paramInt4, float paramFloat5);
  
  public native float[] processTrackFrame(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3);
  
  public native void release();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tracking.sdk.TrackerManager
 * JD-Core Version:    0.7.0.1
 */