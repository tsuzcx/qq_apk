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
    if (i < this.mTriggerTimes.length) {
      if (paramLong < this.mTriggerTimes[i]) {
        paramLong = this.mTriggerTimes[i];
      }
    }
    for (;;)
    {
      if (paramLong > 0L) {}
      for (;;)
      {
        return paramLong;
        i += 1;
        break;
        paramLong = 0L;
      }
    }
  }
  
  private void initArrBySortSelect(long[] paramArrayOfLong)
  {
    int i = 0;
    if ((paramArrayOfLong == null) || (paramArrayOfLong.length == 0)) {}
    for (;;)
    {
      return;
      this.mTriggerTimes = new long[paramArrayOfLong.length];
      System.arraycopy(paramArrayOfLong, 0, this.mTriggerTimes, 0, paramArrayOfLong.length);
      while (i < this.mTriggerTimes.length - 1)
      {
        int j = i + 1;
        while (j < this.mTriggerTimes.length)
        {
          if (this.mTriggerTimes[j] < this.mTriggerTimes[i])
          {
            long l = this.mTriggerTimes[i];
            this.mTriggerTimes[i] = this.mTriggerTimes[j];
            this.mTriggerTimes[j] = l;
          }
          j += 1;
        }
        i += 1;
      }
    }
  }
  
  private long updateTriggerTime(long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2)
  {
    long l1;
    long l2;
    if (paramBoolean2)
    {
      l1 = this.DELAY_TIME;
      if ((paramLong2 >= 0L) && (paramLong1 >= 0L)) {
        break label44;
      }
      l2 = getMatchTriggerTime(-1L) + l1;
    }
    label44:
    do
    {
      do
      {
        return l2;
        l1 = 0L;
        break;
        l2 = paramLong2;
      } while (paramBoolean1);
      l2 = paramLong2;
    } while (paramLong1 < this.mPlayDuration + paramLong2);
    return getMatchTriggerTime(paramLong2 - l1) + l1;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.trigger.TriggerTimeUpdater
 * JD-Core Version:    0.7.0.1
 */