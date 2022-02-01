package com.tencent.qcircle.tavcut.timeline;

import android.support.annotation.NonNull;
import java.util.concurrent.ConcurrentHashMap;

public class TimelineCoverGenerator$CoverTask
  implements Comparable<CoverTask>
{
  private boolean generating;
  private int index;
  private long requestTimeMs;
  private long startTimeMs;
  
  public TimelineCoverGenerator$CoverTask(TimelineCoverGenerator paramTimelineCoverGenerator, long paramLong, int paramInt)
  {
    this.requestTimeMs = paramLong;
    this.startTimeMs = (paramInt * paramTimelineCoverGenerator.mItemDurationMs);
    this.index = paramInt;
    if (paramTimelineCoverGenerator.mCoverTaskMap != null) {
      paramTimelineCoverGenerator.mCoverTaskMap.put(Long.valueOf(this.startTimeMs), this);
    }
  }
  
  public int compareTo(@NonNull CoverTask paramCoverTask)
  {
    if (this.requestTimeMs > paramCoverTask.requestTimeMs) {
      return -1;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.tavcut.timeline.TimelineCoverGenerator.CoverTask
 * JD-Core Version:    0.7.0.1
 */