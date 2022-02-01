package com.tencent.ttpic.util;

import com.tencent.filter.BaseFilter;

public class VideoLibUtil
{
  public static float[] estimateRigidTransform(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3)
  {
    return nativeRigidTransform(paramArrayOfFloat1, paramArrayOfFloat2, paramArrayOfFloat3);
  }
  
  public static int getFaceDetectLibVersion()
  {
    return nativeGetFaceDetectLibVersion();
  }
  
  public static int getFilterLibVersion()
  {
    return BaseFilter.getVersionCode();
  }
  
  private static native int nativeGetFaceDetectLibVersion();
  
  private static native float[] nativeRigidTransform(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.util.VideoLibUtil
 * JD-Core Version:    0.7.0.1
 */