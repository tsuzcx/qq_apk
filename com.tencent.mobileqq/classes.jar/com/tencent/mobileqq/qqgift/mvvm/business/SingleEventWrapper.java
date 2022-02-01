package com.tencent.mobileqq.qqgift.mvvm.business;

import androidx.annotation.Nullable;

public class SingleEventWrapper<T>
{
  private final T a;
  private boolean b = false;
  
  public SingleEventWrapper(T paramT)
  {
    if (paramT != null)
    {
      this.a = paramT;
      return;
    }
    throw new IllegalArgumentException("null values in Event are not allowed.");
  }
  
  @Nullable
  public T a()
  {
    if (this.b) {
      return null;
    }
    this.b = true;
    return this.a;
  }
  
  public T b()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.mvvm.business.SingleEventWrapper
 * JD-Core Version:    0.7.0.1
 */