package com.tencent.mobileqq.text.processor;

import com.tencent.mobileqq.text.GrabParams;

public abstract interface ISpanProcessor
{
  public abstract void doGrab(GrabParams paramGrabParams, ISpanCallback paramISpanCallback);
  
  public abstract int doPlain(Object paramObject, int paramInt1, int paramInt2, int paramInt3, StringBuffer paramStringBuffer);
  
  public abstract boolean matchGrab(int paramInt);
  
  public abstract boolean matchPlain(Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.text.processor.ISpanProcessor
 * JD-Core Version:    0.7.0.1
 */