package com.tencent.robolectric;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

final class ReflectionHelpers$4
  implements InvocationHandler
{
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    return paramMethod.getDefaultValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.robolectric.ReflectionHelpers.4
 * JD-Core Version:    0.7.0.1
 */