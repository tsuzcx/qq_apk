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
    if ((paramArrayOfSpeedInfo != null) && (paramArrayOfSpeedInfo.length != 0))
    {
      int j = paramArrayOfSpeedInfo.length;
      long l4 = 0L;
      long l3 = 0L;
      long l1 = l3;
      long l2 = l1;
      int i = 0;
      while (i < j)
      {
        SpeedFilter.SpeedInfo localSpeedInfo = paramArrayOfSpeedInfo[i];
        l3 += localSpeedInfo.speed;
        l1 += localSpeedInfo.exSpeed;
        l2 += localSpeedInfo.adSpeed;
        i += 1;
      }
      double d1;
      double d2;
      if (l3 > 0L)
      {
        d1 = l3;
        d2 = paramArrayOfSpeedInfo.length;
        Double.isNaN(d1);
        Double.isNaN(d2);
        l3 = (d1 / d2);
      }
      else
      {
        l3 = 0L;
      }
      if (l1 > 0L)
      {
        d1 = l1;
        d2 = paramArrayOfSpeedInfo.length;
        Double.isNaN(d1);
        Double.isNaN(d2);
        l1 = (d1 / d2);
      }
      else
      {
        l1 = 0L;
      }
      if (l2 > 0L)
      {
        d1 = l2;
        d2 = paramArrayOfSpeedInfo.length;
        Double.isNaN(d1);
        Double.isNaN(d2);
        l4 = (d1 / d2);
      }
      return new long[] { l3, l1, l4 };
    }
    return new long[] { 0L, 0L, 0L };
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
    try
    {
      long l = System.currentTimeMillis();
      Object localObject1 = this.mCacheLong.iterator();
      while (((Iterator)localObject1).hasNext()) {
        if (l - ((SpeedFilter.SpeedInfo)((Iterator)localObject1).next()).curTime > 8000L) {
          ((Iterator)localObject1).remove();
        }
      }
      localObject1 = this.mCacheShort.iterator();
      while (((Iterator)localObject1).hasNext()) {
        if (l - ((SpeedFilter.SpeedInfo)((Iterator)localObject1).next()).curTime > 3000L) {
          ((Iterator)localObject1).remove();
        }
      }
      localObject1 = new SpeedFilter.SpeedInfo(this, null);
      ((SpeedFilter.SpeedInfo)localObject1).curTime = l;
      ((SpeedFilter.SpeedInfo)localObject1).speed = paramLong1;
      ((SpeedFilter.SpeedInfo)localObject1).exSpeed = paramLong2;
      ((SpeedFilter.SpeedInfo)localObject1).adSpeed = paramLong3;
      this.mCacheLong.offerLast(localObject1);
      this.mCacheShort.offerLast(localObject1);
      localObject1 = new SpeedFilter.SpeedInfo[this.mCacheLong.size()];
      this.mCacheLong.toArray((Object[])localObject1);
      Object localObject3 = new SpeedFilter.SpeedInfo[this.mCacheShort.size()];
      this.mCacheShort.toArray((Object[])localObject3);
      localObject1 = calAvg((SpeedFilter.SpeedInfo[])localObject1);
      localObject3 = calAvg((SpeedFilter.SpeedInfo[])localObject3);
      paramLong1 = localObject1[0];
      paramLong2 = localObject3[0];
      if (paramLong1 <= paramLong2) {
        localObject1 = localObject3;
      }
      return localObject1;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.weiyun.uploader.module.SpeedFilter
 * JD-Core Version:    0.7.0.1
 */