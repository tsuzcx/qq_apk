package com.tencent.mobileqq.text.processor;

public abstract interface ISpanCallback
{
  public abstract <T> T[] acquireSpans(int paramInt1, int paramInt2, Class<T> paramClass);
  
  public abstract void addSpan(Object paramObject, int paramInt1, int paramInt2, int paramInt3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.text.processor.ISpanCallback
 * JD-Core Version:    0.7.0.1
 */