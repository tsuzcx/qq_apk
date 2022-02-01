package com.tencent.rmonitor.common.util;

import com.tencent.rmonitor.common.logger.Logger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/common/util/RecyclablePool;", "", "clz", "Ljava/lang/Class;", "Lcom/tencent/rmonitor/common/util/RecyclablePool$Recyclable;", "cap", "", "(Ljava/lang/Class;I)V", "capacity", "count", "head", "obtain", "recycle", "", "recyclableObject", "Companion", "Recyclable", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public final class RecyclablePool
{
  public static final RecyclablePool.Companion a = new RecyclablePool.Companion(null);
  private final RecyclablePool.Recyclable b = new RecyclablePool.Recyclable();
  private volatile int c;
  private volatile int d;
  
  public RecyclablePool(@NotNull Class<? extends RecyclablePool.Recyclable> paramClass, int paramInt)
  {
    synchronized (this.b)
    {
      this.d = paramInt;
      this.b.setInPool(true);
      paramInt = 0;
      int i = this.d;
      if (paramInt < i)
      {
        try
        {
          a((RecyclablePool.Recyclable)paramClass.newInstance());
        }
        catch (Throwable localThrowable)
        {
          Logger.b.a("RMonitor_common_RecyclablePool", localThrowable);
        }
      }
      else
      {
        paramClass = Unit.INSTANCE;
        return;
      }
    }
  }
  
  @Nullable
  public final RecyclablePool.Recyclable a(@NotNull Class<? extends RecyclablePool.Recyclable> paramClass)
  {
    Intrinsics.checkParameterIsNotNull(paramClass, "clz");
    RecyclablePool.Recyclable localRecyclable = (RecyclablePool.Recyclable)null;
    if (this.c > 0) {
      synchronized (this.b)
      {
        localRecyclable = this.b.getNext();
        if (localRecyclable != null)
        {
          if (localRecyclable.isInPool())
          {
            this.b.changeNext(localRecyclable.getNext(), false);
            localRecyclable.setInPool(false);
            this.c -= 1;
            int i = this.c;
            break label170;
          }
          throw ((Throwable)new RuntimeException("recyclable object is not in pool"));
        }
        throw ((Throwable)new RuntimeException("recyclable object is null"));
      }
    }
    ??? = Logger.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("obtain ");
    localStringBuilder.append(this.c);
    ((Logger)???).d(new String[] { "RMonitor_common_RecyclablePool", localStringBuilder.toString() });
    label170:
    if (localRecyclable != null) {
      return localRecyclable;
    }
    try
    {
      paramClass = (RecyclablePool.Recyclable)paramClass.newInstance();
      return paramClass;
    }
    catch (Throwable paramClass)
    {
      Logger.b.a("RMonitor_common_RecyclablePool", paramClass);
    }
    return null;
  }
  
  public final void a(@Nullable RecyclablePool.Recyclable paramRecyclable)
  {
    if (paramRecyclable != null)
    {
      paramRecyclable.reset();
      synchronized (this.b)
      {
        if (!paramRecyclable.isInPool())
        {
          if (this.c < this.d)
          {
            paramRecyclable.changeNext(this.b.getNext(), false);
            this.b.changeNext(paramRecyclable, false);
            paramRecyclable.setInPool(true);
            this.c += 1;
            int i = this.c;
          }
          paramRecyclable = Unit.INSTANCE;
          return;
        }
        throw ((Throwable)new RuntimeException("recyclableObject has in pool"));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.common.util.RecyclablePool
 * JD-Core Version:    0.7.0.1
 */