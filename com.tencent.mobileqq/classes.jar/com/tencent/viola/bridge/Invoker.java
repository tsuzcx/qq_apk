package com.tencent.viola.bridge;

import java.lang.reflect.Type;

public abstract interface Invoker
{
  public abstract Type[] getParameterTypes();
  
  public abstract Object invoke(Object paramObject, Object... paramVarArgs);
  
  public abstract boolean isRunOnUIThread();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.bridge.Invoker
 * JD-Core Version:    0.7.0.1
 */