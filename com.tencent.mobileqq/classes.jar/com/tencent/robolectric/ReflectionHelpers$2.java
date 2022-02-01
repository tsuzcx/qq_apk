package com.tencent.robolectric;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

final class ReflectionHelpers$2
  implements InvocationHandler
{
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    if (ReflectionHelpers.a().containsKey(paramMethod.getReturnType().getName())) {
      return ReflectionHelpers.a().get(paramMethod.getReturnType().getName());
    }
    if (paramMethod.getReturnType().isInterface()) {
      return ReflectionHelpers.a(paramMethod.getReturnType());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.robolectric.ReflectionHelpers.2
 * JD-Core Version:    0.7.0.1
 */