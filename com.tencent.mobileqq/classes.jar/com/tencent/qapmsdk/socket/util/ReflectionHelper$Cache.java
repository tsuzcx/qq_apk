package com.tencent.qapmsdk.socket.util;

import android.support.annotation.NonNull;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ReflectionHelper$Cache
{
  private Class<?> clz;
  private Map<ReflectionHelper.ConstructorKey, Constructor<?>> constructorMap = new ConcurrentHashMap();
  private Map<String, Field> fieldMap = new ConcurrentHashMap();
  private Map<ReflectionHelper.MethodKey, Method> methodMap = new ConcurrentHashMap();
  
  ReflectionHelper$Cache(Class<?> paramClass)
  {
    this.clz = paramClass;
  }
  
  public Constructor<?> constructor(Class<?>... paramVarArgs)
  {
    ReflectionHelper.ConstructorKey localConstructorKey = new ReflectionHelper.ConstructorKey(paramVarArgs);
    Constructor localConstructor2 = (Constructor)this.constructorMap.get(localConstructorKey);
    Constructor localConstructor1 = localConstructor2;
    if (localConstructor2 == null)
    {
      localConstructor1 = this.clz.getDeclaredConstructor(paramVarArgs);
      localConstructor1.setAccessible(true);
      this.constructorMap.put(localConstructorKey, localConstructor1);
    }
    return localConstructor1;
  }
  
  public Field field(String paramString)
  {
    Field localField = (Field)this.fieldMap.get(paramString);
    Object localObject = localField;
    if (localField == null) {
      localObject = this.clz;
    }
    while (localObject != null) {
      try
      {
        localField = ((Class)localObject).getDeclaredField(paramString);
        localObject = localField;
        ((Field)localObject).setAccessible(true);
        this.fieldMap.put(paramString, localObject);
        return localObject;
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        localObject = ((Class)localObject).getSuperclass();
      }
    }
    throw new NoSuchFieldException("class: " + this.clz + ", field: " + paramString);
  }
  
  @NonNull
  public Method method(String paramString, Class<?>... paramVarArgs)
  {
    ReflectionHelper.MethodKey localMethodKey = new ReflectionHelper.MethodKey(paramString, paramVarArgs);
    Method localMethod = (Method)this.methodMap.get(localMethodKey);
    Object localObject = localMethod;
    if (localMethod == null) {
      localObject = this.clz;
    }
    while (localObject != null) {
      try
      {
        localMethod = ((Class)localObject).getDeclaredMethod(paramString, paramVarArgs);
        localObject = localMethod;
        ((Method)localObject).setAccessible(true);
        this.methodMap.put(localMethodKey, localObject);
        return localObject;
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        localObject = ((Class)localObject).getSuperclass();
      }
    }
    throw new NoSuchMethodException("class: " + this.clz + ", method: " + paramString + ", args: " + Arrays.toString(paramVarArgs));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.util.ReflectionHelper.Cache
 * JD-Core Version:    0.7.0.1
 */