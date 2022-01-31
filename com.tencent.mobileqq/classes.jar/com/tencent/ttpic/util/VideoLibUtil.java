package com.tencent.ttpic.util;

import com.tencent.filter.BaseFilter;

public class VideoLibUtil
{
  public static int getFaceDetectLibVersion()
  {
    return nativeGetFaceDetectLibVersion();
  }
  
  public static int getFilterLibVersion()
  {
    return BaseFilter.getVersionCode();
  }
  
  private static native int nativeGetFaceDetectLibVersion();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.util.VideoLibUtil
 * JD-Core Version:    0.7.0.1
 */