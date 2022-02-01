package com.tencent.robolectric;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

final class ReflectionHelpers$1
  implements InvocationHandler
{
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    return ReflectionHelpers.a().get(paramMethod.getReturnType().getName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.robolectric.ReflectionHelpers.1
 * JD-Core Version:    0.7.0.1
 */