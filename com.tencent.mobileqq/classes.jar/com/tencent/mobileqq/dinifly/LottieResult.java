package com.tencent.mobileqq.dinifly;

import androidx.annotation.Nullable;
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
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof LottieResult)) {
      return false;
    }
    paramObject = (LottieResult)paramObject;
    if ((getValue() != null) && (getValue().equals(paramObject.getValue()))) {
      return true;
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.LottieResult
 * JD-Core Version:    0.7.0.1
 */