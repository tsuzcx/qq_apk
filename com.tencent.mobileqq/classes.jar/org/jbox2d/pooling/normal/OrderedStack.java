package org.jbox2d.pooling.normal;

public abstract class OrderedStack<E>
{
  private final Object[] container;
  private int index;
  private final Object[] pool;
  private final int size;
  
  public OrderedStack(int paramInt1, int paramInt2)
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
    Object[] arrayOfObject = this.pool;
    int i = this.index;
    this.index = (i + 1);
    return arrayOfObject[i];
  }
  
  public final E[] pop(int paramInt)
  {
    System.arraycopy(this.pool, this.index, this.container, 0, paramInt);
    this.index += paramInt;
    return (Object[])this.container;
  }
  
  public final void push(int paramInt)
  {
    this.index -= paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.pooling.normal.OrderedStack
 * JD-Core Version:    0.7.0.1
 */