package com.tencent.richmedia.videocompress;

import android.os.Build.VERSION;

public class VideoConverterConfig
{
  public boolean accurateSeek;
  public long beginTime = -1L;
  public int bitrateMode = -1;
  public int destHeight;
  public int destQmax;
  public int destWidth;
  public long endTime = -1L;
  public int iFrameInterval = 1;
  public boolean isMute;
  public boolean isNeedCompress = true;
  public int level;
  public String output;
  public int profile;
  public String rotate;
  public float scaleRate;
  public boolean setProfileLevel;
  @Deprecated
  public boolean setRotation = shouldSetRotation();
  public long srcBitrate;
  public long srcFrameRate;
  public int srcHeight;
  public int srcWidth;
  public int videoBitRate;
  public int videoFrameRate;
  
  private static boolean shouldSetRotation()
  {
    boolean bool = false;
    if ((Build.VERSION.SDK_INT >= 18) && (Build.VERSION.SDK_INT <= 19)) {
      bool = true;
    }
    while (Build.VERSION.SDK_INT <= 19) {
      return bool;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.richmedia.videocompress.VideoConverterConfig
 * JD-Core Version:    0.7.0.1
 */