package com.tencent.mtt.supportui.utils.struct;

import com.tencent.mtt.hippy.utils.LogUtils;

public class Pools$SimplePool<T>
  implements Pools.Pool<T>
{
  private final Object[] a;
  private int b;
  
  public Pools$SimplePool(int paramInt)
  {
    if (paramInt > 0)
    {
      this.a = new Object[paramInt];
      return;
    }
    throw new IllegalArgumentException("The max pool size must be > 0");
  }
  
  private boolean a(T paramT)
  {
    int i = 0;
    while (i < this.b)
    {
      if (this.a[i] == paramT) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public T acquire()
  {
    int i = this.b;
    if (i > 0)
    {
      int j = i - 1;
      Object[] arrayOfObject = this.a;
      Object localObject = arrayOfObject[j];
      arrayOfObject[j] = null;
      this.b = (i - 1);
      return localObject;
    }
    return null;
  }
  
  public boolean release(T paramT)
  {
    if (a(paramT))
    {
      LogUtils.e("Pools", "Already in the pool!");
      return false;
    }
    int i = this.b;
    if (i >= 0)
    {
      Object[] arrayOfObject = this.a;
      if (i < arrayOfObject.length)
      {
        arrayOfObject[i] = paramT;
        this.b = (i + 1);
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.supportui.utils.struct.Pools.SimplePool
 * JD-Core Version:    0.7.0.1
 */