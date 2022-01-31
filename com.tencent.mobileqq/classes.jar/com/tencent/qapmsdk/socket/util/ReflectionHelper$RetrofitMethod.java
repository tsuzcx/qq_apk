package com.tencent.qapmsdk.socket.util;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReflectionHelper$RetrofitMethod
{
  List<Object> argList;
  private Method method;
  private Object methodInstance;
  
  ReflectionHelper$RetrofitMethod(Object paramObject, Method paramMethod)
  {
    this.methodInstance = paramObject;
    this.method = paramMethod;
  }
  
  public RetrofitMethod args(Object... paramVarArgs)
  {
    if (this.argList == null) {
      this.argList = new ArrayList();
    }
    Collections.addAll(this.argList, paramVarArgs);
    return this;
  }
  
  public Object invoke()
  {
    Method localMethod = this.method;
    Object localObject = this.methodInstance;
    if (this.argList != null) {}
    for (Object[] arrayOfObject = this.argList.toArray(new Object[this.argList.size()]);; arrayOfObject = null) {
      return localMethod.invoke(localObject, arrayOfObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.util.ReflectionHelper.RetrofitMethod
 * JD-Core Version:    0.7.0.1
 */