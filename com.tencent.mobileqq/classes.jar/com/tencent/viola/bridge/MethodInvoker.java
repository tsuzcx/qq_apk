package com.tencent.viola.bridge;

import java.lang.reflect.Method;
import java.lang.reflect.Type;

public class MethodInvoker
  implements Invoker
{
  final Method mMethod;
  Type[] mParam;
  final boolean mRunOnUIThread;
  
  public MethodInvoker(Method paramMethod)
  {
    this(paramMethod, false);
  }
  
  public MethodInvoker(Method paramMethod, boolean paramBoolean)
  {
    this.mMethod = paramMethod;
    this.mParam = this.mMethod.getGenericParameterTypes();
    this.mRunOnUIThread = paramBoolean;
  }
  
  public Type[] getParameterTypes()
  {
    if (this.mParam == null) {
      this.mParam = this.mMethod.getGenericParameterTypes();
    }
    return this.mParam;
  }
  
  public Object invoke(Object paramObject, Object... paramVarArgs)
  {
    return this.mMethod.invoke(paramObject, paramVarArgs);
  }
  
  public boolean isRunOnUIThread()
  {
    return this.mRunOnUIThread;
  }
  
  public String toString()
  {
    return this.mMethod.getName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.viola.bridge.MethodInvoker
 * JD-Core Version:    0.7.0.1
 */