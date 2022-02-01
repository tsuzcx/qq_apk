package com.tencent.weiyun.uploader.module;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public final class SpeedFilter
{
  private static final long AVERAGE_SPEED_TIME_UNIT_LONG = 8000L;
  private static final long AVERAGE_SPEED_TIME_UNIT_SHORT = 3000L;
  private final Deque<SpeedFilter.SpeedInfo> mCacheLong = new LinkedList();
  private final Deque<SpeedFilter.SpeedInfo> mCacheShort = new LinkedList();
  
  private long[] calAvg(SpeedFilter.SpeedInfo[] paramArrayOfSpeedInfo)
  {
    if ((paramArrayOfSpeedInfo == null) || (paramArrayOfSpeedInfo.length == 0)) {
      return new long[] { 0L, 0L, 0L };
    }
    long l2 = 0L;
    long l3 = 0L;
    long l1 = 0L;
    int j = paramArrayOfSpeedInfo.length;
    int i = 0;
    while (i < j)
    {
      SpeedFilter.SpeedInfo localSpeedInfo = paramArrayOfSpeedInfo[i];
      l2 += localSpeedInfo.speed;
      l3 += localSpeedInfo.exSpeed;
      l1 += localSpeedInfo.adSpeed;
      i += 1;
    }
    if (l2 > 0L)
    {
      l2 = (l2 / paramArrayOfSpeedInfo.length);
      if (l3 <= 0L) {
        break label162;
      }
      l3 = (l3 / paramArrayOfSpeedInfo.length);
      label120:
      if (l1 <= 0L) {
        break label168;
      }
    }
    label162:
    label168:
    for (l1 = (l1 / paramArrayOfSpeedInfo.length);; l1 = 0L)
    {
      return new long[] { l2, l3, l1 };
      l2 = 0L;
      break;
      l3 = 0L;
      break label120;
    }
  }
  
  public void clearSpeed()
  {
    try
    {
      this.mCacheLong.clear();
      this.mCacheShort.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public long[] updateSpeed(long paramLong1, long paramLong2, long paramLong3)
  {
    long l;
    try
    {
      l = System.currentTimeMillis();
      Iterator localIterator = this.mCacheLong.iterator();
      while (localIterator.hasNext()) {
        if (l - ((SpeedFilter.SpeedInfo)localIterator.next()).curTime > 8000L) {
          localIterator.remove();
        }
      }
      localObject2 = this.mCacheShort.iterator();
    }
    finally {}
    while (((Iterator)localObject2).hasNext()) {
      if (l - ((SpeedFilter.SpeedInfo)((Iterator)localObject2).next()).curTime > 3000L) {
        ((Iterator)localObject2).remove();
      }
    }
    Object localObject2 = new SpeedFilter.SpeedInfo(this, null);
    ((SpeedFilter.SpeedInfo)localObject2).curTime = l;
    ((SpeedFilter.SpeedInfo)localObject2).speed = paramLong1;
    ((SpeedFilter.SpeedInfo)localObject2).exSpeed = paramLong2;
    ((SpeedFilter.SpeedInfo)localObject2).adSpeed = paramLong3;
    this.mCacheLong.offerLast(localObject2);
    this.mCacheShort.offerLast(localObject2);
    localObject2 = new SpeedFilter.SpeedInfo[this.mCacheLong.size()];
    this.mCacheLong.toArray((Object[])localObject2);
    Object localObject3 = new SpeedFilter.SpeedInfo[this.mCacheShort.size()];
    this.mCacheShort.toArray((Object[])localObject3);
    localObject2 = calAvg((SpeedFilter.SpeedInfo[])localObject2);
    localObject3 = calAvg((SpeedFilter.SpeedInfo[])localObject3);
    paramLong1 = localObject2[0];
    paramLong2 = localObject3[0];
    if (paramLong1 > paramLong2) {}
    for (;;)
    {
      return localObject2;
      localObject2 = localObject3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.weiyun.uploader.module.SpeedFilter
 * JD-Core Version:    0.7.0.1
 */