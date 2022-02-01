package com.tencent.tavsticker.utils;

import com.tencent.tav.coremedia.CMTimeRange;

public class TimeRangeUtil
{
  public static boolean isInTimeRange(CMTimeRange paramCMTimeRange, long paramLong)
  {
    if ((isValidTimeRange(paramCMTimeRange)) && (paramLong >= 0L))
    {
      paramLong *= 1000L;
      if ((paramLong >= paramCMTimeRange.getStartUs()) && (paramLong <= paramCMTimeRange.getEndUs())) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean isValidTimeRange(CMTimeRange paramCMTimeRange)
  {
    if (paramCMTimeRange == null) {
      return false;
    }
    return paramCMTimeRange.isLegal();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavsticker.utils.TimeRangeUtil
 * JD-Core Version:    0.7.0.1
 */