package com.tencent.youtu.ytposedetect;

public abstract interface YTPoseDetectInterface$PoseDetectOnFrame
{
  public static final int DETECT_AUTH_FAILED = 1;
  public static final int DETECT_NOT_CALL_START = 3;
  public static final int DETECT_NOT_INIT_MODEL = 2;
  public static final int DETECT_SUCCESS = 0;
  
  public abstract void onCanReflect();
  
  public abstract void onFailed(int paramInt, String paramString1, String paramString2);
  
  public abstract void onRecordingDone(byte[][] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public abstract void onSuccess(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.youtu.ytposedetect.YTPoseDetectInterface.PoseDetectOnFrame
 * JD-Core Version:    0.7.0.1
 */