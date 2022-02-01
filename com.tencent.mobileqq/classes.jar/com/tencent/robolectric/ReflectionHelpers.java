package com.tencent.robolectric;

import java.lang.reflect.Proxy;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ReflectionHelpers
{
  private static final Map<String, Object> a;
  
  static
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("boolean", Boolean.FALSE);
    localHashMap.put("int", Integer.valueOf(0));
    localHashMap.put("long", Long.valueOf(0L));
    localHashMap.put("float", Float.valueOf(0.0F));
    localHashMap.put("double", Double.valueOf(0.0D));
    localHashMap.put("short", Short.valueOf((short)0));
    localHashMap.put("byte", Byte.valueOf((byte)0));
    a = Collections.unmodifiableMap(localHashMap);
  }
  
  public static <T> T a(Class<T> paramClass)
  {
    ClassLoader localClassLoader = paramClass.getClassLoader();
    ReflectionHelpers.2 local2 = new ReflectionHelpers.2();
    return Proxy.newProxyInstance(localClassLoader, new Class[] { paramClass }, local2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.robolectric.ReflectionHelpers
 * JD-Core Version:    0.7.0.1
 */