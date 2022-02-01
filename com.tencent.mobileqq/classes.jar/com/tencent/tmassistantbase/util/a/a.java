package com.tencent.tmassistantbase.util.a;

import android.text.TextUtils;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public abstract class a
  implements j
{
  protected Object a;
  protected Object b;
  protected HashMap<String, c> c;
  
  public static int a(Object[] paramArrayOfObject, Class<?> paramClass)
  {
    if (!a(paramArrayOfObject))
    {
      int k = paramArrayOfObject.length;
      int i = 0;
      int j = -1;
      while (i < k)
      {
        Object localObject = paramArrayOfObject[i];
        j += 1;
        if ((localObject != null) && (paramClass == localObject.getClass())) {
          return j;
        }
        i += 1;
      }
    }
    return -1;
  }
  
  public static void a(Class paramClass, HashSet<Class<?>> paramHashSet)
  {
    Class[] arrayOfClass = paramClass.getInterfaces();
    if (arrayOfClass.length != 0) {
      paramHashSet.addAll(Arrays.asList(arrayOfClass));
    }
    if (paramClass.getSuperclass() != Object.class) {
      a(paramClass.getSuperclass(), paramHashSet);
    }
  }
  
  public static <T> boolean a(T[] paramArrayOfT)
  {
    return (paramArrayOfT == null) || (paramArrayOfT.length == 0);
  }
  
  public c a(String paramString)
  {
    HashMap localHashMap = this.c;
    if (localHashMap != null) {
      return (c)localHashMap.get(paramString);
    }
    return null;
  }
  
  public Object a(Object paramObject)
  {
    HashSet localHashSet = new HashSet();
    a(paramObject.getClass(), localHashSet);
    paramObject = new Class[localHashSet.size()];
    localHashSet.toArray(paramObject);
    return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), paramObject, new b(this));
  }
  
  public String a()
  {
    return null;
  }
  
  public void a(c paramc)
  {
    if (this.c == null) {
      this.c = new HashMap();
    }
    if (paramc != null)
    {
      if (TextUtils.isEmpty(paramc.a())) {
        return;
      }
      this.c.put(paramc.a(), paramc);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tmassistantbase.util.a.a
 * JD-Core Version:    0.7.0.1
 */