package com.tencent.upload.e.b;

import android.util.SparseArray;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class a
{
  private static SparseArray<Class> a = new SparseArray();
  private static SparseArray<Method> b = new SparseArray();
  private static SparseArray<Constructor> c = new SparseArray();
  private static SparseArray<Field> d = new SparseArray();
  private final Object e;
  private final boolean f;
  
  private a(Object paramObject)
  {
    this.e = paramObject;
    this.f = false;
  }
  
  public static a a(Object paramObject)
  {
    return new a(paramObject);
  }
  
  public static <T extends AccessibleObject> T a(T paramT)
  {
    T ?;
    if (paramT == null) {
      ? = null;
    }
    do
    {
      Member localMember;
      do
      {
        return ?;
        if (!(paramT instanceof Member)) {
          break;
        }
        localMember = (Member)paramT;
        if (!Modifier.isPublic(localMember.getModifiers())) {
          break;
        }
        ? = paramT;
      } while (Modifier.isPublic(localMember.getDeclaringClass().getModifiers()));
      ? = paramT;
    } while (paramT.isAccessible());
    paramT.setAccessible(true);
    return paramT;
  }
  
  private static Object b(Object paramObject)
  {
    Object localObject = paramObject;
    if ((paramObject instanceof a)) {
      localObject = ((a)paramObject).a();
    }
    return localObject;
  }
  
  private Field c(String paramString)
    throws b
  {
    Class localClass = b();
    try
    {
      i = localClass.hashCode();
      i = paramString.hashCode() + i;
      if (d.get(i) != null) {
        return (Field)d.get(i);
      }
      localField2 = localClass.getField(paramString);
      localField1 = localField2;
      if (localField2 != null)
      {
        d.put(i, localField2);
        return localField2;
      }
    }
    catch (NoSuchFieldException localNoSuchFieldException2)
    {
      for (;;)
      {
        try
        {
          int i = localClass.hashCode();
          i = paramString.hashCode() + i;
          if (d.get(i) != null) {
            return (Field)d.get(i);
          }
          Field localField2 = (Field)a(localClass.getDeclaredField(paramString));
          Field localField1 = localField2;
          if (localField2 == null) {
            break;
          }
          d.put(i, localField2);
          return localField2;
        }
        catch (NoSuchFieldException localNoSuchFieldException1)
        {
          localClass = localClass.getSuperclass();
          if (localClass == null) {
            throw new b(localNoSuchFieldException2);
          }
        }
      }
      return localNoSuchFieldException1;
    }
  }
  
  public a a(String paramString, Object paramObject)
    throws b
  {
    try
    {
      c(paramString).set(this.e, b(paramObject));
      return this;
    }
    catch (Exception paramString)
    {
      throw new b(paramString);
    }
  }
  
  public <T> T a()
  {
    return this.e;
  }
  
  public <T> T a(String paramString)
    throws b
  {
    return b(paramString).a();
  }
  
  public a b(String paramString)
    throws b
  {
    try
    {
      paramString = a(c(paramString).get(this.e));
      return paramString;
    }
    catch (Exception paramString)
    {
      throw new b(paramString);
    }
  }
  
  public Class<?> b()
  {
    if (this.f) {
      return (Class)this.e;
    }
    return this.e.getClass();
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof a)) {
      return this.e.equals(((a)paramObject).a());
    }
    return false;
  }
  
  public int hashCode()
  {
    return this.e.hashCode();
  }
  
  public String toString()
  {
    return this.e.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.upload.e.b.a
 * JD-Core Version:    0.7.0.1
 */