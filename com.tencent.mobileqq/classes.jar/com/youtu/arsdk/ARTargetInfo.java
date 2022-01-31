package com.youtu.arsdk;

public class ARTargetInfo
{
  public static final int STATE_LOST = 2;
  public static final int STATE_RECOGNIZED = 0;
  public static final int STATE_TRACKED = 1;
  public String markerDesc;
  public int markerIndex = -1;
  public float[] pose = new float[16];
  public int state = -1;
  
  public static ARTargetInfo[] allocateInitialized(int paramInt)
  {
    ARTargetInfo[] arrayOfARTargetInfo = new ARTargetInfo[paramInt];
    int i = 0;
    while (i < paramInt)
    {
      arrayOfARTargetInfo[i] = new ARTargetInfo();
      i += 1;
    }
    return arrayOfARTargetInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.youtu.arsdk.ARTargetInfo
 * JD-Core Version:    0.7.0.1
 */