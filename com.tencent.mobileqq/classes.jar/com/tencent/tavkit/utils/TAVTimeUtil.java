package com.tencent.tavkit.utils;

import android.support.annotation.Nullable;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
  
  public static List<CMTimeRange> mixTimeRangesWithMinTimeRange(CMTimeRange paramCMTimeRange1, CMTimeRange paramCMTimeRange2, CMTimeRange paramCMTimeRange3)
  {
    if (paramCMTimeRange3.containsTimeRange(paramCMTimeRange1))
    {
      paramCMTimeRange1 = new ArrayList();
      localObject = paramCMTimeRange2.getStart().sub(paramCMTimeRange3.getStart());
      if (((CMTime)localObject).getTimeSeconds() > 0.0F) {
        paramCMTimeRange1.add(new CMTimeRange(paramCMTimeRange3.getStart(), (CMTime)localObject));
      }
      paramCMTimeRange1.add(paramCMTimeRange2);
      paramCMTimeRange3 = paramCMTimeRange3.getEnd().sub(paramCMTimeRange2.getEnd());
      if (paramCMTimeRange3.getTimeSeconds() > 0.0F) {
        paramCMTimeRange1.add(new CMTimeRange(paramCMTimeRange2.getEnd(), paramCMTimeRange3));
      }
      return paramCMTimeRange1;
    }
    if (paramCMTimeRange1.equals(paramCMTimeRange3))
    {
      paramCMTimeRange1 = new ArrayList();
      paramCMTimeRange1.add(paramCMTimeRange2);
      return paramCMTimeRange1;
    }
    Object localObject = new ArrayList();
    CMTime localCMTime = paramCMTimeRange1.getDuration().sub(paramCMTimeRange2.getDuration());
    paramCMTimeRange1 = new CMTimeRange(paramCMTimeRange1.getStart(), localCMTime);
    if (paramCMTimeRange1.getDuration().getTimeSeconds() > 0.0F) {
      ((List)localObject).add(paramCMTimeRange1);
    }
    ((List)localObject).add(paramCMTimeRange2);
    paramCMTimeRange1 = paramCMTimeRange3.getEnd().sub(paramCMTimeRange2.getEnd());
    paramCMTimeRange1 = new CMTimeRange(paramCMTimeRange2.getEnd(), paramCMTimeRange1);
    if (paramCMTimeRange1.getDuration().getTimeSeconds() > 0.0F) {
      ((List)localObject).add(paramCMTimeRange1);
    }
    return localObject;
  }
  
  public static List<CMTimeRange> sliceTimeRangesForTimeRange1(CMTimeRange paramCMTimeRange1, CMTimeRange paramCMTimeRange2)
  {
    Object localObject = getIntersection(paramCMTimeRange1, paramCMTimeRange2);
    if (((CMTimeRange)localObject).getDuration().getTimeSeconds() > 0.0F)
    {
      if ((!paramCMTimeRange2.containsTimeRange(paramCMTimeRange1)) && ((paramCMTimeRange1.getStart().getTimeSeconds() >= paramCMTimeRange2.getStart().getTimeSeconds()) || (paramCMTimeRange1.getEnd().getTimeSeconds() >= paramCMTimeRange2.getEnd().getTimeSeconds()))) {
        paramCMTimeRange1 = mixTimeRangesWithMinTimeRange(paramCMTimeRange2, (CMTimeRange)localObject, paramCMTimeRange1);
      } else {
        paramCMTimeRange1 = mixTimeRangesWithMinTimeRange(paramCMTimeRange1, (CMTimeRange)localObject, paramCMTimeRange2);
      }
    }
    else
    {
      localObject = new ArrayList();
      ((List)localObject).add(paramCMTimeRange1);
      ((List)localObject).add(paramCMTimeRange2);
      paramCMTimeRange1 = (CMTimeRange)localObject;
    }
    Collections.sort(paramCMTimeRange1, new TAVTimeUtil.1());
    return paramCMTimeRange1;
  }
  
  public static List<CMTimeRange> timeRange(CMTimeRange paramCMTimeRange1, CMTimeRange paramCMTimeRange2)
  {
    CMTimeRange localCMTimeRange1 = getIntersection(paramCMTimeRange1, paramCMTimeRange2);
    if ((localCMTimeRange1 != null) && (localCMTimeRange1.getDuration().getTimeSeconds() > 0.0F))
    {
      paramCMTimeRange2 = new ArrayList();
      CMTimeRange localCMTimeRange2 = new CMTimeRange(paramCMTimeRange1.getStart(), localCMTimeRange1.getStart().sub(paramCMTimeRange1.getStart()));
      if (localCMTimeRange2.getDuration().getTimeSeconds() > 0.0F) {
        paramCMTimeRange2.add(localCMTimeRange2);
      }
      paramCMTimeRange1 = new CMTimeRange(localCMTimeRange1.getEnd(), paramCMTimeRange1.getEnd().sub(localCMTimeRange1.getEnd()));
      if (paramCMTimeRange1.getDuration().getTimeSeconds() > 0.0F) {
        paramCMTimeRange2.add(paramCMTimeRange1);
      }
      return paramCMTimeRange2;
    }
    paramCMTimeRange2 = new ArrayList();
    paramCMTimeRange2.add(paramCMTimeRange1);
    return paramCMTimeRange2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavkit.utils.TAVTimeUtil
 * JD-Core Version:    0.7.0.1
 */