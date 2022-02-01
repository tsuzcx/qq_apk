package com.tencent.qapmsdk.socket.d;

import android.support.annotation.NonNull;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class d$a
{
  private Map<d.c, Method> a = new ConcurrentHashMap();
  private Map<String, Field> b = new ConcurrentHashMap();
  private Map<d.b, Constructor<?>> c = new ConcurrentHashMap();
  private Class<?> d;
  
  d$a(Class<?> paramClass)
  {
    this.d = paramClass;
  }
  
  public Constructor<?> a(Class<?>... paramVarArgs)
  {
    d.b localb = new d.b(paramVarArgs);
    Constructor localConstructor2 = (Constructor)this.c.get(localb);
    Constructor localConstructor1 = localConstructor2;
    if (localConstructor2 == null)
    {
      localConstructor1 = this.d.getDeclaredConstructor(paramVarArgs);
      localConstructor1.setAccessible(true);
      this.c.put(localb, localConstructor1);
    }
    return localConstructor1;
  }
  
  public Field a(String paramString)
  {
    Field localField = (Field)this.b.get(paramString);
    Object localObject = localField;
    if (localField == null) {
      localObject = this.d;
    }
    while (localObject != null) {
      try
      {
        localField = ((Class)localObject).getDeclaredField(paramString);
        localObject = localField;
        ((Field)localObject).setAccessible(true);
        this.b.put(paramString, localObject);
        return localObject;
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        localObject = ((Class)localObject).getSuperclass();
      }
    }
    throw new NoSuchFieldException("class: " + this.d + ", field: " + paramString);
  }
  
  @NonNull
  public Method a(String paramString, Class<?>... paramVarArgs)
  {
    d.c localc = new d.c(paramString, paramVarArgs);
    Method localMethod = (Method)this.a.get(localc);
    Object localObject = localMethod;
    if (localMethod == null) {
      localObject = this.d;
    }
    while (localObject != null) {
      try
      {
        localMethod = ((Class)localObject).getDeclaredMethod(paramString, paramVarArgs);
        localObject = localMethod;
        ((Method)localObject).setAccessible(true);
        this.a.put(localc, localObject);
        return localObject;
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        localObject = ((Class)localObject).getSuperclass();
      }
    }
    throw new NoSuchMethodException("class: " + this.d + ", method: " + paramString + ", args: " + Arrays.toString(paramVarArgs));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.d.d.a
 * JD-Core Version:    0.7.0.1
 */