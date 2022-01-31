package com.tencent.mobileqq.dinifly;

import android.support.annotation.Nullable;
import java.util.Arrays;

public final class LottieResult<V>
{
  @Nullable
  private final Throwable exception;
  @Nullable
  private final V value;
  
  public LottieResult(V paramV)
  {
    this.value = paramV;
    this.exception = null;
  }
  
  public LottieResult(Throwable paramThrowable)
  {
    this.exception = paramThrowable;
    this.value = null;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof LottieResult)) {
        return false;
      }
      paramObject = (LottieResult)paramObject;
    } while ((getValue() != null) && (getValue().equals(paramObject.getValue())));
    if ((getException() != null) && (paramObject.getException() != null)) {
      return getException().toString().equals(getException().toString());
    }
    return false;
  }
  
  @Nullable
  public Throwable getException()
  {
    return this.exception;
  }
  
  @Nullable
  public V getValue()
  {
    return this.value;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new Object[] { getValue(), getException() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.LottieResult
 * JD-Core Version:    0.7.0.1
 */