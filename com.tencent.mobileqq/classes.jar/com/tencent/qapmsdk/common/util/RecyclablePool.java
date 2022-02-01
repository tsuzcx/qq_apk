package com.tencent.qapmsdk.common.util;

import com.tencent.qapmsdk.common.logger.Logger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/util/RecyclablePool;", "", "clz", "Ljava/lang/Class;", "Lcom/tencent/qapmsdk/common/util/RecyclablePool$Recyclable;", "cap", "", "(Ljava/lang/Class;I)V", "capacity", "count", "head", "obtain", "recycle", "", "recyclableObject", "Companion", "Recyclable", "common_release"}, k=1, mv={1, 1, 15})
public final class RecyclablePool
{
  public static final RecyclablePool.Companion Companion = new RecyclablePool.Companion(null);
  @NotNull
  public static final String TAG = "QAPM_common_RecyclablePool";
  private volatile int capacity;
  private volatile int count;
  private final RecyclablePool.Recyclable head = new RecyclablePool.Recyclable();
  
  public RecyclablePool(@NotNull Class<? extends RecyclablePool.Recyclable> paramClass, int paramInt)
  {
    synchronized (this.head)
    {
      this.capacity = paramInt;
      this.head.setInPool(true);
      int i = this.capacity;
      paramInt = 0;
      for (;;)
      {
        if (paramInt < i) {
          try
          {
            recycle((RecyclablePool.Recyclable)paramClass.newInstance());
            paramInt += 1;
          }
          catch (Throwable localThrowable)
          {
            for (;;)
            {
              Logger.INSTANCE.exception("QAPM_common_RecyclablePool", localThrowable);
            }
          }
        }
      }
    }
    paramClass = Unit.INSTANCE;
  }
  
  @Nullable
  public final RecyclablePool.Recyclable obtain(@NotNull Class<? extends RecyclablePool.Recyclable> paramClass)
  {
    Intrinsics.checkParameterIsNotNull(paramClass, "clz");
    RecyclablePool.Recyclable localRecyclable1 = (RecyclablePool.Recyclable)null;
    if (this.count > 0)
    {
      synchronized (this.head)
      {
        localRecyclable1 = this.head.getNext();
        if (localRecyclable1 == null) {
          break label106;
        }
        if (!localRecyclable1.isInPool()) {
          throw ((Throwable)new RuntimeException("recyclable object is not in pool"));
        }
      }
      this.head.changeNext(localRecyclable1.getNext(), false);
      localRecyclable1.setInPool(false);
      this.count -= 1;
      int i = this.count;
      if (localRecyclable1 == null) {
        break label162;
      }
    }
    for (;;)
    {
      return localRecyclable1;
      label106:
      throw ((Throwable)new RuntimeException("recyclable object is null"));
      Logger.INSTANCE.d(new String[] { "QAPM_common_RecyclablePool", "obtain " + this.count });
      break;
      try
      {
        label162:
        localRecyclable1 = (RecyclablePool.Recyclable)paramClass.newInstance();
      }
      catch (Throwable paramClass)
      {
        Logger.INSTANCE.exception("QAPM_common_RecyclablePool", paramClass);
      }
    }
    return null;
  }
  
  public final void recycle(@Nullable RecyclablePool.Recyclable paramRecyclable)
  {
    if (paramRecyclable != null)
    {
      paramRecyclable.reset();
      synchronized (this.head)
      {
        if (paramRecyclable.isInPool()) {
          throw ((Throwable)new RuntimeException("recyclableObject has in pool"));
        }
      }
      if (this.count < this.capacity)
      {
        paramRecyclable.changeNext(this.head.getNext(), false);
        this.head.changeNext(paramRecyclable, false);
        paramRecyclable.setInPool(true);
        this.count += 1;
        int i = this.count;
      }
      paramRecyclable = Unit.INSTANCE;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.common.util.RecyclablePool
 * JD-Core Version:    0.7.0.1
 */