package com.tencent.qphone.base.util.log;

public class RecyclablePool
{
  private static final boolean DEBUG = false;
  volatile int mCapacity = 0;
  volatile int mCount = 0;
  private RecyclablePool.Recyclable mHead = new RecyclablePool.Recyclable();
  
  public RecyclablePool(Class<? extends RecyclablePool.Recyclable> paramClass, int paramInt)
  {
    int i;
    RecyclablePool.Recyclable localRecyclable2;
    synchronized (this.mHead)
    {
      this.mCapacity = paramInt;
      this.mHead.inPool = true;
      i = 0;
      if (i >= paramInt) {}
    }
  }
  
  public RecyclablePool.Recyclable obtain(Class<? extends RecyclablePool.Recyclable> paramClass)
  {
    int i = this.mCount;
    Object localObject1 = null;
    Object localObject2 = null;
    if (i > 0)
    {
      RecyclablePool.Recyclable localRecyclable = this.mHead;
      localObject1 = localObject2;
      try
      {
        if (this.mCount > 0)
        {
          localObject1 = this.mHead.getNext();
          if (localObject1 != null)
          {
            if (((RecyclablePool.Recyclable)localObject1).inPool)
            {
              this.mHead.changeNext(RecyclablePool.Recyclable.access$000((RecyclablePool.Recyclable)localObject1), false);
              ((RecyclablePool.Recyclable)localObject1).inPool = false;
              this.mCount -= 1;
            }
            else
            {
              throw new RuntimeException("WTF");
            }
          }
          else {
            throw new RuntimeException("WTF");
          }
        }
      }
      finally {}
    }
    if (localObject1 == null) {}
    try
    {
      paramClass = (RecyclablePool.Recyclable)paramClass.newInstance();
      return paramClass;
    }
    catch (Throwable paramClass)
    {
      label128:
      break label128;
    }
    return localObject1;
  }
  
  public void recycle(RecyclablePool.Recyclable paramRecyclable)
  {
    paramRecyclable.recycle();
    if (this.mCount < this.mCapacity) {
      synchronized (this.mHead)
      {
        if (!paramRecyclable.inPool)
        {
          if (this.mCount < this.mCapacity)
          {
            paramRecyclable.changeNext(this.mHead.getNext(), false);
            this.mHead.changeNext(paramRecyclable, false);
            paramRecyclable.inPool = true;
            this.mCount += 1;
          }
          return;
        }
        throw new RuntimeException("WTF");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qphone.base.util.log.RecyclablePool
 * JD-Core Version:    0.7.0.1
 */