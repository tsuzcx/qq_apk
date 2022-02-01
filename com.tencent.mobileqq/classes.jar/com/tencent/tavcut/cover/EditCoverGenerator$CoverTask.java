package com.tencent.tavcut.cover;

import android.support.annotation.NonNull;
import com.tencent.tav.coremedia.CMTime;
import java.util.concurrent.ConcurrentHashMap;

class EditCoverGenerator$CoverTask
  implements Comparable<CoverTask>
{
  private boolean generating;
  private int index;
  private long requestTimeMs;
  private CMTime startTime;
  
  EditCoverGenerator$CoverTask(EditCoverGenerator paramEditCoverGenerator, long paramLong, CMTime paramCMTime, int paramInt)
  {
    this.requestTimeMs = paramLong;
    this.startTime = paramCMTime;
    this.index = paramInt;
    EditCoverGenerator.access$300(paramEditCoverGenerator).put(Integer.valueOf(this.index), this);
  }
  
  public int compareTo(@NonNull CoverTask paramCoverTask)
  {
    return (int)(this.requestTimeMs - paramCoverTask.requestTimeMs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavcut.cover.EditCoverGenerator.CoverTask
 * JD-Core Version:    0.7.0.1
 */