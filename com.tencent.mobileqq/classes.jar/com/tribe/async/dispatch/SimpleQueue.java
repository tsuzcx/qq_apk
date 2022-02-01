package com.tribe.async.dispatch;

public abstract interface SimpleQueue<ITEM>
{
  public abstract void dump();
  
  public abstract void enqueue(ITEM paramITEM);
  
  public abstract ITEM poll();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tribe.async.dispatch.SimpleQueue
 * JD-Core Version:    0.7.0.1
 */