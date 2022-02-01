package com.tencent.oskplayer.proxy;

public class ContentFormat
{
  public static final int VIDEO_HLS = 1;
  public static final int VIDEO_LIVE = 4;
  public static final int VIDEO_MP4 = 8;
  
  public static boolean isHLSLive(String paramString)
  {
    return (VideoManager.getInstance().probeContentFlag(paramString) & 0x5) != 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.oskplayer.proxy.ContentFormat
 * JD-Core Version:    0.7.0.1
 */