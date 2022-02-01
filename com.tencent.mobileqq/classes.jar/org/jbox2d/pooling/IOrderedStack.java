package org.jbox2d.pooling;

public abstract interface IOrderedStack<E>
{
  public abstract E pop();
  
  public abstract E[] pop(int paramInt);
  
  public abstract void push(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.pooling.IOrderedStack
 * JD-Core Version:    0.7.0.1
 */