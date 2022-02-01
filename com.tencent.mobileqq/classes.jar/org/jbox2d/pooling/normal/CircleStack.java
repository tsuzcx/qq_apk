package org.jbox2d.pooling.normal;

import org.jbox2d.pooling.IOrderedStack;

public abstract class CircleStack<E>
  implements IOrderedStack<E>
{
  private final Object[] container;
  private int index;
  private final Object[] pool;
  private final int size;
  
  public CircleStack(int paramInt1, int paramInt2)
  {
    this.size = paramInt1;
    this.pool = new Object[paramInt1];
    int i = 0;
    while (i < paramInt1)
    {
      this.pool[i] = newInstance();
      i += 1;
    }
    this.index = 0;
    this.container = new Object[paramInt2];
  }
  
  protected abstract E newInstance();
  
  public final E pop()
  {
    this.index += 1;
    if (this.index >= this.size) {
      this.index = 0;
    }
    return this.pool[this.index];
  }
  
  public final E[] pop(int paramInt)
  {
    int i = this.index;
    int j = this.size;
    if (i + paramInt < j)
    {
      System.arraycopy(this.pool, i, this.container, 0, paramInt);
      this.index += paramInt;
    }
    else
    {
      j = i + paramInt - j;
      Object[] arrayOfObject1 = this.pool;
      Object[] arrayOfObject2 = this.container;
      paramInt -= j;
      System.arraycopy(arrayOfObject1, i, arrayOfObject2, 0, paramInt);
      System.arraycopy(this.pool, 0, this.container, paramInt, j);
      this.index = j;
    }
    return (Object[])this.container;
  }
  
  public void push(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.pooling.normal.CircleStack
 * JD-Core Version:    0.7.0.1
 */