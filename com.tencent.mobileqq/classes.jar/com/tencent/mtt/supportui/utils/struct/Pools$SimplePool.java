package com.tencent.mtt.supportui.utils.struct;

public class Pools$SimplePool<T>
  implements Pools.Pool<T>
{
  private final Object[] a;
  private int b;
  
  public Pools$SimplePool(int paramInt)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException("The max pool size must be > 0");
    }
    this.a = new Object[paramInt];
  }
  
  private boolean a(T paramT)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.b)
      {
        if (this.a[i] == paramT) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public T acquire()
  {
    if (this.b > 0)
    {
      int i = this.b - 1;
      Object localObject = this.a[i];
      this.a[i] = null;
      this.b -= 1;
      return localObject;
    }
    return null;
  }
  
  public boolean release(T paramT)
  {
    if (a(paramT)) {
      throw new IllegalStateException("Already in the pool!");
    }
    if ((this.b >= 0) && (this.b < this.a.length))
    {
      this.a[this.b] = paramT;
      this.b += 1;
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.supportui.utils.struct.Pools.SimplePool
 * JD-Core Version:    0.7.0.1
 */