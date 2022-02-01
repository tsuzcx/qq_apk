package com.tencent.tavkit.utils;

import android.support.annotation.Nullable;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;

public class TAVTimeUtil
{
  public static float factorForTime(CMTime paramCMTime, CMTimeRange paramCMTimeRange)
  {
    if (paramCMTimeRange == null) {
      return 0.0F;
    }
    return paramCMTime.sub(paramCMTimeRange.getStart()).getTimeSeconds() / paramCMTimeRange.getDuration().getTimeSeconds();
  }
  
  @Nullable
  public static CMTimeRange getIntersection(CMTimeRange paramCMTimeRange1, CMTimeRange paramCMTimeRange2)
  {
    if (paramCMTimeRange1 != null)
    {
      if (paramCMTimeRange2 == null) {
        return null;
      }
      CMTimeRange localCMTimeRange2 = paramCMTimeRange1;
      CMTimeRange localCMTimeRange1 = paramCMTimeRange2;
      if (paramCMTimeRange1.getStart().bigThan(paramCMTimeRange2.getStart()))
      {
        localCMTimeRange1 = paramCMTimeRange1;
        localCMTimeRange2 = paramCMTimeRange2;
      }
      if (localCMTimeRange2.getEnd().smallThan(localCMTimeRange1.getStart())) {
        return null;
      }
      if (localCMTimeRange2.getStart().bigThan(localCMTimeRange1.getStart())) {
        paramCMTimeRange1 = localCMTimeRange2.getStart();
      } else {
        paramCMTimeRange1 = localCMTimeRange1.getStart();
      }
      if (localCMTimeRange2.getEnd().smallThan(localCMTimeRange1.getEnd())) {
        paramCMTimeRange2 = localCMTimeRange2.getEnd();
      } else {
        paramCMTimeRange2 = localCMTimeRange1.getEnd();
      }
      return new CMTimeRange(paramCMTimeRange1, paramCMTimeRange2.sub(paramCMTimeRange1));
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavkit.utils.TAVTimeUtil
 * JD-Core Version:    0.7.0.1
 */