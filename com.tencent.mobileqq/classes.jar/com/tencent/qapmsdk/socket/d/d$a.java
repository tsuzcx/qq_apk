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
    Object localObject = (Field)this.b.get(paramString);
    if (localObject == null)
    {
      for (localObject = this.d; localObject != null; localObject = ((Class)localObject).getSuperclass()) {
        try
        {
          Field localField = ((Class)localObject).getDeclaredField(paramString);
          localField.setAccessible(true);
          this.b.put(paramString, localField);
          return localField;
        }
        catch (NoSuchFieldException localNoSuchFieldException)
        {
          label52:
          break label52;
        }
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("class: ");
      ((StringBuilder)localObject).append(this.d);
      ((StringBuilder)localObject).append(", field: ");
      ((StringBuilder)localObject).append(paramString);
      throw new NoSuchFieldException(((StringBuilder)localObject).toString());
    }
    else
    {
      return localObject;
    }
  }
  
  @NonNull
  public Method a(String paramString, Class<?>... paramVarArgs)
  {
    d.c localc = new d.c(paramString, paramVarArgs);
    Object localObject = (Method)this.a.get(localc);
    if (localObject == null)
    {
      for (localObject = this.d; localObject != null; localObject = ((Class)localObject).getSuperclass()) {
        try
        {
          Method localMethod = ((Class)localObject).getDeclaredMethod(paramString, paramVarArgs);
          localMethod.setAccessible(true);
          this.a.put(localc, localMethod);
          return localMethod;
        }
        catch (NoSuchMethodException localNoSuchMethodException)
        {
          label70:
          break label70;
        }
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("class: ");
      ((StringBuilder)localObject).append(this.d);
      ((StringBuilder)localObject).append(", method: ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", args: ");
      ((StringBuilder)localObject).append(Arrays.toString(paramVarArgs));
      throw new NoSuchMethodException(((StringBuilder)localObject).toString());
    }
    else
    {
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.d.d.a
 * JD-Core Version:    0.7.0.1
 */