package com.tencent.oskplayer.util;

public abstract interface Predicate<T>
{
  public abstract boolean evaluate(T paramT);
  
  public abstract boolean evaluate(byte[] paramArrayOfByte);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.oskplayer.util.Predicate
 * JD-Core Version:    0.7.0.1
 */