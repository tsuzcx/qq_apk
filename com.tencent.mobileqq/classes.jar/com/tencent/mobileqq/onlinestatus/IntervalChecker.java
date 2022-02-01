package com.tencent.mobileqq.onlinestatus;

import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/onlinestatus/IntervalChecker;", "", "()V", "statusIdTimePairMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mobileqq/onlinestatus/TimePair;", "Lkotlin/collections/HashMap;", "destroy", "", "expired", "", "statusId", "getInterval", "", "setInterval", "interval", "updateTime", "time", "qqonlinestatus-impl_release"}, k=1, mv={1, 1, 16})
public class IntervalChecker
{
  private final HashMap<Integer, TimePair> a = new HashMap();
  
  public final void a()
  {
    this.a.clear();
  }
  
  public final void a(int paramInt, long paramLong)
  {
    TimePair localTimePair = (TimePair)this.a.get(Integer.valueOf(paramInt));
    StringBuilder localStringBuilder;
    if (localTimePair == null)
    {
      localTimePair = new TimePair(0L, paramLong);
      ((Map)this.a).put(Integer.valueOf(paramInt), localTimePair);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("newTimePair: ");
        localStringBuilder.append(localTimePair);
        QLog.d("IntervalChecker", 2, new Object[] { "updateTime: called. ", localStringBuilder.toString() });
      }
    }
    else
    {
      localTimePair.b(paramLong);
      ((Map)this.a).put(Integer.valueOf(paramInt), localTimePair);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("timePair: ");
        localStringBuilder.append(localTimePair);
        QLog.d("IntervalChecker", 2, new Object[] { "updateTime: called. ", localStringBuilder.toString() });
      }
    }
  }
  
  public final boolean a(int paramInt)
  {
    Object localObject = (TimePair)this.a.get(Integer.valueOf(paramInt));
    if (localObject == null)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("statusId: ");
        ((StringBuilder)localObject).append(paramInt);
        QLog.d("IntervalChecker", 2, new Object[] { "expired: called. not stored （如果未存储时间间隔，默认放行，不过期） ", ((StringBuilder)localObject).toString() });
      }
      return true;
    }
    if (((TimePair)localObject).a() <= 0L)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("statusId: ");
        ((StringBuilder)localObject).append(paramInt);
        QLog.d("IntervalChecker", 2, new Object[] { "expired: called. interval not set.（如果未存储时间间隔，默认放行，不过期） ", ((StringBuilder)localObject).toString() });
      }
      return true;
    }
    boolean bool;
    if (NetConnInfoCenter.getServerTime() - ((TimePair)localObject).b() > ((TimePair)localObject).a()) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("expired: ");
      localStringBuilder.append(bool);
      localStringBuilder.append("  statusId: ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("  timePair: ");
      localStringBuilder.append(localObject);
      QLog.d("IntervalChecker", 2, new Object[] { "expired: called. ", localStringBuilder.toString() });
    }
    return bool;
  }
  
  public final long b(int paramInt)
  {
    TimePair localTimePair = (TimePair)this.a.get(Integer.valueOf(paramInt));
    if (localTimePair == null) {
      return 0L;
    }
    return localTimePair.a();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.IntervalChecker
 * JD-Core Version:    0.7.0.1
 */