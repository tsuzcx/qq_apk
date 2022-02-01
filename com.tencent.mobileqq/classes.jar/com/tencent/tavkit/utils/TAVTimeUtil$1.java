package com.tencent.tavkit.utils;

import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import java.util.Comparator;

final class TAVTimeUtil$1
  implements Comparator<CMTimeRange>
{
  public int compare(CMTimeRange paramCMTimeRange1, CMTimeRange paramCMTimeRange2)
  {
    paramCMTimeRange1 = paramCMTimeRange1.getStart();
    paramCMTimeRange2 = paramCMTimeRange2.getStart();
    if (paramCMTimeRange1.equalsTo(paramCMTimeRange2)) {
      return 0;
    }
    if (paramCMTimeRange1.smallThan(paramCMTimeRange2)) {
      return -1;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavkit.utils.TAVTimeUtil.1
 * JD-Core Version:    0.7.0.1
 */