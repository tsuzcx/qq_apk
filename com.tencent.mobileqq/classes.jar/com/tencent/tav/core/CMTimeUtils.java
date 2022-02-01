package com.tencent.tav.core;

import com.tencent.tav.coremedia.CMTime;

public class CMTimeUtils
{
  public static long CMTimeConvertToUs(CMTime paramCMTime)
  {
    return (paramCMTime.getTimeSeconds() * 1000.0F * 1000.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tav.core.CMTimeUtils
 * JD-Core Version:    0.7.0.1
 */