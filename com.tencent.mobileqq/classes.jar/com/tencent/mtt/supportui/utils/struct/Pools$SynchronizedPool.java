package com.tencent.mtt.supportui.utils.struct;

public class Pools$SynchronizedPool<T>
  extends Pools.SimplePool<T>
{
  private final Object a = new Object();
  
  public Pools$SynchronizedPool(int paramInt)
  {
    super(paramInt);
  }
  
  public T acquire()
  {
    synchronized (this.a)
    {
      Object localObject2 = super.acquire();
      return localObject2;
    }
  }
  
  public boolean release(T paramT)
  {
    synchronized (this.a)
    {
      boolean bool = super.release(paramT);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.supportui.utils.struct.Pools.SynchronizedPool
 * JD-Core Version:    0.7.0.1
 */