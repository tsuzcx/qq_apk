package com.tencent.mobileqq.shortvideo.util;

public abstract interface CameraInterFace
{
  public static final int CAMERA_BACK = 2;
  public static final int CAMERA_FRONT = 1;
  public static final int CAMERA_UNKNOWN = -1;
  
  public abstract int getCameraID();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.CameraInterFace
 * JD-Core Version:    0.7.0.1
 */