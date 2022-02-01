package com.tencent.qqmini.sdk.launcher.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

class Reflect$1
  implements InvocationHandler
{
  Reflect$1(Reflect paramReflect, boolean paramBoolean) {}
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    paramObject = paramMethod.getName();
    try
    {
      paramMethod = Reflect.on(Reflect.access$000(this.this$0)).call(paramObject, paramArrayOfObject).get();
      return paramMethod;
    }
    catch (ReflectException paramMethod)
    {
      if (this.val$isMap)
      {
        Map localMap = (Map)Reflect.access$000(this.this$0);
        int i;
        if (paramArrayOfObject == null) {
          i = 0;
        } else {
          i = paramArrayOfObject.length;
        }
        if ((i == 0) && (paramObject.startsWith("get"))) {
          return localMap.get(Reflect.access$100(paramObject.substring(3)));
        }
        if ((i == 0) && (paramObject.startsWith("is"))) {
          return localMap.get(Reflect.access$100(paramObject.substring(2)));
        }
        if ((i == 1) && (paramObject.startsWith("set")))
        {
          localMap.put(Reflect.access$100(paramObject.substring(3)), paramArrayOfObject[0]);
          return null;
        }
      }
      throw paramMethod;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.dynamic.Reflect.1
 * JD-Core Version:    0.7.0.1
 */