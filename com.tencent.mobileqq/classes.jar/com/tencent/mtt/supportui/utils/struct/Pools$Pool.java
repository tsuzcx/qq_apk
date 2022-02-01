package com.tencent.mtt.supportui.utils.struct;

public abstract interface Pools$Pool<T>
{
  public abstract T acquire();
  
  public abstract boolean release(T paramT);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.supportui.utils.struct.Pools.Pool
 * JD-Core Version:    0.7.0.1
 */