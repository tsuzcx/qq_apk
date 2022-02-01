package com.tencent.tavkit.utils;

import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import java.util.Comparator;

final class TAVTimeUtil$1
  implements Comparator<CMTimeRange>
{
  public int compare(CMTimeRange paramCMTimeRange1, CMTimeRange paramCMTimeRange2)
  {
    if (paramCMTimeRange1.getStart().smallThan(paramCMTimeRange2.getStart())) {
      return -1;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavkit.utils.TAVTimeUtil.1
 * JD-Core Version:    0.7.0.1
 */