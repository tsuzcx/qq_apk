package com.tencent.mobileqq.richstatus.comment.utils;

import java.lang.reflect.Array;
import mqq.util.WeakReference;

public final class SimpleWeakObjectPool<T>
{
  private WeakReference<T>[] a;
  private int b = -1;
  
  public SimpleWeakObjectPool()
  {
    this(16);
  }
  
  public SimpleWeakObjectPool(int paramInt)
  {
    this.a = ((WeakReference[])Array.newInstance(WeakReference.class, paramInt));
  }
  
  public T a()
  {
    try
    {
      if ((this.b != -1) && (this.b <= this.a.length))
      {
        Object localObject1 = this.a[this.b].get();
        this.a[this.b] = null;
        this.b -= 1;
        return localObject1;
      }
      return null;
    }
    finally {}
  }
  
  public boolean a(T paramT)
  {
    try
    {
      if (this.b != -1)
      {
        int i = this.b;
        int j = this.a.length;
        if (i >= j - 1) {
          return false;
        }
      }
      this.b += 1;
      this.a[this.b] = new WeakReference(paramT);
      return true;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.comment.utils.SimpleWeakObjectPool
 * JD-Core Version:    0.7.0.1
 */