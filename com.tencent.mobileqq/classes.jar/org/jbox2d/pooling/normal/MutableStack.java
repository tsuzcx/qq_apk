package org.jbox2d.pooling.normal;

import org.jbox2d.pooling.IDynamicStack;

public abstract class MutableStack<E>
  implements IDynamicStack<E>
{
  private int index = 0;
  private int size;
  private Object[] stack = null;
  
  public MutableStack(int paramInt)
  {
    extendStack(paramInt);
  }
  
  private void extendStack(int paramInt)
  {
    Object[] arrayOfObject1 = new Object[paramInt];
    Object[] arrayOfObject2 = this.stack;
    int i = 0;
    paramInt = i;
    if (arrayOfObject2 != null)
    {
      System.arraycopy(arrayOfObject2, 0, arrayOfObject1, 0, this.size);
      paramInt = i;
    }
    while (paramInt < arrayOfObject1.length)
    {
      arrayOfObject1[paramInt] = newInstance();
      paramInt += 1;
    }
    this.stack = arrayOfObject1;
    this.size = arrayOfObject1.length;
  }
  
  protected abstract E newInstance();
  
  public final E pop()
  {
    int i = this.index;
    int j = this.size;
    if (i >= j) {
      extendStack(j * 2);
    }
    Object[] arrayOfObject = this.stack;
    i = this.index;
    this.index = (i + 1);
    return arrayOfObject[i];
  }
  
  public final void push(E paramE)
  {
    Object[] arrayOfObject = this.stack;
    int i = this.index - 1;
    this.index = i;
    arrayOfObject[i] = paramE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.pooling.normal.MutableStack
 * JD-Core Version:    0.7.0.1
 */