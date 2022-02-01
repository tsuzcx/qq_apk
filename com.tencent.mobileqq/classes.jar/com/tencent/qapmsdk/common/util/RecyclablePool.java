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
      paramInt = 0;
      int i = this.capacity;
      if (paramInt < i)
      {
        try
        {
          recycle((RecyclablePool.Recyclable)paramClass.newInstance());
        }
        catch (Throwable localThrowable)
        {
          Logger.INSTANCE.exception("QAPM_common_RecyclablePool", localThrowable);
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
  public final RecyclablePool.Recyclable obtain(@NotNull Class<? extends RecyclablePool.Recyclable> paramClass)
  {
    Intrinsics.checkParameterIsNotNull(paramClass, "clz");
    RecyclablePool.Recyclable localRecyclable = (RecyclablePool.Recyclable)null;
    if (this.count > 0) {
      synchronized (this.head)
      {
        localRecyclable = this.head.getNext();
        if (localRecyclable != null)
        {
          if (localRecyclable.isInPool())
          {
            this.head.changeNext(localRecyclable.getNext(), false);
            localRecyclable.setInPool(false);
            this.count -= 1;
            int i = this.count;
            break label170;
          }
          throw ((Throwable)new RuntimeException("recyclable object is not in pool"));
        }
        throw ((Throwable)new RuntimeException("recyclable object is null"));
      }
    }
    ??? = Logger.INSTANCE;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("obtain ");
    localStringBuilder.append(this.count);
    ((Logger)???).d(new String[] { "QAPM_common_RecyclablePool", localStringBuilder.toString() });
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
      Logger.INSTANCE.exception("QAPM_common_RecyclablePool", paramClass);
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
        if (!paramRecyclable.isInPool())
        {
          if (this.count < this.capacity)
          {
            paramRecyclable.changeNext(this.head.getNext(), false);
            this.head.changeNext(paramRecyclable, false);
            paramRecyclable.setInPool(true);
            this.count += 1;
            int i = this.count;
          }
          paramRecyclable = Unit.INSTANCE;
          return;
        }
        throw ((Throwable)new RuntimeException("recyclableObject has in pool"));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.common.util.RecyclablePool
 * JD-Core Version:    0.7.0.1
 */