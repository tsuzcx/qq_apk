package com.tencent.tkd.comment.util.io;

public abstract interface Pool<V>
{
  public abstract V get(int paramInt);
  
  public abstract void release(V paramV);
  
  public abstract void trim(TrimLevel paramTrimLevel);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tkd.comment.util.io.Pool
 * JD-Core Version:    0.7.0.1
 */