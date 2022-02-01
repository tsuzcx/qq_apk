package com.tencent.mobileqq.onlinestatus;

import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/onlinestatus/IntervalChecker;", "", "()V", "statusIdTimePairMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mobileqq/onlinestatus/TimePair;", "Lkotlin/collections/HashMap;", "destroy", "", "expired", "", "statusId", "getInterval", "", "setInterval", "interval", "updateTime", "time", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class IntervalChecker
{
  private final HashMap<Integer, TimePair> a = new HashMap();
  
  public final long a(int paramInt)
  {
    TimePair localTimePair = (TimePair)this.a.get(Integer.valueOf(paramInt));
    if (localTimePair == null) {
      return 0L;
    }
    return localTimePair.a();
  }
  
  public final void a()
  {
    this.a.clear();
  }
  
  public final void a(int paramInt, long paramLong)
  {
    TimePair localTimePair = (TimePair)this.a.get(Integer.valueOf(paramInt));
    if (localTimePair == null)
    {
      localTimePair = new TimePair(0L, paramLong);
      ((Map)this.a).put(Integer.valueOf(paramInt), localTimePair);
      if (QLog.isColorLevel()) {
        QLog.d("IntervalChecker", 2, new Object[] { "updateTime: called. ", "newTimePair: " + localTimePair });
      }
    }
    do
    {
      return;
      localTimePair.b(paramLong);
      ((Map)this.a).put(Integer.valueOf(paramInt), localTimePair);
    } while (!QLog.isColorLevel());
    QLog.d("IntervalChecker", 2, new Object[] { "updateTime: called. ", "timePair: " + localTimePair });
  }
  
  public final boolean a(int paramInt)
  {
    TimePair localTimePair = (TimePair)this.a.get(Integer.valueOf(paramInt));
    if (localTimePair == null) {
      if (QLog.isColorLevel()) {
        QLog.d("IntervalChecker", 2, new Object[] { "expired: called. not stored （如果未存储时间间隔，默认放行，不过期） ", "statusId: " + paramInt });
      }
    }
    do
    {
      return true;
      if (localTimePair.a() > 0L) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("IntervalChecker", 2, new Object[] { "expired: called. interval not set.（如果未存储时间间隔，默认放行，不过期） ", "statusId: " + paramInt });
    return true;
    if (NetConnInfoCenter.getServerTime() - localTimePair.b() > localTimePair.a()) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("IntervalChecker", 2, new Object[] { "expired: called. ", "expired: " + bool + "  statusId: " + paramInt + "  timePair: " + localTimePair });
      }
      return bool;
    }
  }
  
  public final void b(int paramInt, long paramLong)
  {
    TimePair localTimePair = (TimePair)this.a.get(Integer.valueOf(paramInt));
    if (localTimePair == null)
    {
      localTimePair = new TimePair(paramLong, 0L);
      ((Map)this.a).put(Integer.valueOf(paramInt), localTimePair);
      return;
    }
    localTimePair.a(paramLong);
    ((Map)this.a).put(Integer.valueOf(paramInt), localTimePair);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.IntervalChecker
 * JD-Core Version:    0.7.0.1
 */