package com.tencent.ttpic.trigger;

public class TriggerTimeUpdater
{
  private final long DELAY_TIME;
  private long mPlayDuration;
  private long[] mTriggerTimes;
  
  public TriggerTimeUpdater(long[] paramArrayOfLong, long paramLong1, long paramLong2)
  {
    this.DELAY_TIME = paramLong1;
    if (paramArrayOfLong == null) {
      return;
    }
    this.mPlayDuration = paramLong2;
    initArrBySortSelect(paramArrayOfLong);
  }
  
  private long getMatchTriggerTime(long paramLong)
  {
    if (this.mTriggerTimes == null) {
      return paramLong;
    }
    int i = 0;
    long l;
    for (;;)
    {
      long[] arrayOfLong = this.mTriggerTimes;
      l = paramLong;
      if (i >= arrayOfLong.length) {
        break;
      }
      if (paramLong < arrayOfLong[i])
      {
        l = arrayOfLong[i];
        break;
      }
      i += 1;
    }
    if (l > 0L) {
      return l;
    }
    return 0L;
  }
  
  private void initArrBySortSelect(long[] paramArrayOfLong)
  {
    if (paramArrayOfLong != null)
    {
      if (paramArrayOfLong.length == 0) {
        return;
      }
      this.mTriggerTimes = new long[paramArrayOfLong.length];
      long[] arrayOfLong = this.mTriggerTimes;
      int j = paramArrayOfLong.length;
      int i = 0;
      System.arraycopy(paramArrayOfLong, 0, arrayOfLong, 0, j);
      while (i < this.mTriggerTimes.length - 1)
      {
        j = i + 1;
        int k = j;
        for (;;)
        {
          paramArrayOfLong = this.mTriggerTimes;
          if (k >= paramArrayOfLong.length) {
            break;
          }
          if (paramArrayOfLong[k] < paramArrayOfLong[i])
          {
            long l = paramArrayOfLong[i];
            paramArrayOfLong[i] = paramArrayOfLong[k];
            paramArrayOfLong[k] = l;
          }
          k += 1;
        }
        i = j;
      }
    }
  }
  
  private long updateTriggerTime(long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2)
  {
    long l;
    if (paramBoolean2) {
      l = this.DELAY_TIME;
    } else {
      l = 0L;
    }
    if ((paramLong2 >= 0L) && (paramLong1 >= 0L)) {
      if (!paramBoolean1) {
        if (paramLong1 < this.mPlayDuration + paramLong2) {
          return paramLong2;
        }
      }
    }
    for (paramLong1 = getMatchTriggerTime(paramLong2 - l);; paramLong1 = getMatchTriggerTime(-1L))
    {
      return paramLong1 + l;
      return paramLong2;
    }
  }
  
  public long updateCurTriggerTime(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    return updateTriggerTime(paramLong1, paramLong2, paramBoolean, false);
  }
  
  public long updateCurTriggerTimeAddDelayTime(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    return updateTriggerTime(paramLong1, paramLong2, paramBoolean, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.trigger.TriggerTimeUpdater
 * JD-Core Version:    0.7.0.1
 */