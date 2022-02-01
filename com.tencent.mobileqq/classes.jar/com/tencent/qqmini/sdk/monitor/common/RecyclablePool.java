package com.tencent.qqmini.sdk.monitor.common;

public class RecyclablePool
{
  private static final boolean DEBUG = false;
  volatile int mCapacity = 0;
  volatile int mCount = 0;
  private RecyclablePool.Recyclable mHead = new RecyclablePool.Recyclable();
  
  public RecyclablePool(Class<? extends RecyclablePool.Recyclable> paramClass, int paramInt)
  {
    for (;;)
    {
      int i;
      synchronized (this.mHead)
      {
        this.mCapacity = paramInt;
        this.mHead.inPool = true;
        i = 0;
        if (i >= paramInt) {}
      }
      try
      {
        RecyclablePool.Recyclable localRecyclable2 = (RecyclablePool.Recyclable)paramClass.newInstance();
        localRecyclable2.inPool = true;
        localRecyclable2.changeNext(this.mHead.getNext(), false);
        this.mHead.changeNext(localRecyclable2, false);
        this.mCount += 1;
        label102:
        i += 1;
        continue;
        return;
        paramClass = finally;
        throw paramClass;
      }
      catch (Throwable localThrowable)
      {
        break label102;
      }
    }
  }
  
  public RecyclablePool.Recyclable obtain(Class<? extends RecyclablePool.Recyclable> paramClass)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    RecyclablePool.Recyclable localRecyclable;
    if (this.mCount > 0)
    {
      localRecyclable = this.mHead;
      localObject1 = localObject2;
      try
      {
        if (this.mCount <= 0) {
          break label101;
        }
        localObject1 = this.mHead.getNext();
        if (localObject1 == null) {
          throw new RuntimeException("WTF");
        }
      }
      finally {}
      if (!((RecyclablePool.Recyclable)localObject1).inPool) {
        throw new RuntimeException("WTF");
      }
      this.mHead.changeNext(RecyclablePool.Recyclable.access$000((RecyclablePool.Recyclable)localObject1), false);
      ((RecyclablePool.Recyclable)localObject1).inPool = false;
      this.mCount -= 1;
    }
    label101:
    if (localObject1 == null) {
      try
      {
        paramClass = (RecyclablePool.Recyclable)paramClass.newInstance();
        return paramClass;
      }
      catch (Throwable paramClass)
      {
        return localObject1;
      }
    }
    return localObject1;
  }
  
  public void recycle(RecyclablePool.Recyclable paramRecyclable)
  {
    paramRecyclable.recycle();
    if (this.mCount < this.mCapacity)
    {
      synchronized (this.mHead)
      {
        if (paramRecyclable.inPool) {
          throw new RuntimeException("WTF");
        }
      }
      if (this.mCount < this.mCapacity)
      {
        paramRecyclable.changeNext(this.mHead.getNext(), false);
        this.mHead.changeNext(paramRecyclable, false);
        paramRecyclable.inPool = true;
        this.mCount += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.monitor.common.RecyclablePool
 * JD-Core Version:    0.7.0.1
 */