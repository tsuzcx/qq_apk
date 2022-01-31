package com.tencent.trackrecordlib.d.a;

import android.support.annotation.Nullable;
import java.util.Map;

public class e
{
  private static b a(Object paramObject, boolean paramBoolean)
  {
    b localb2 = a.a(paramObject);
    b localb1 = localb2;
    if (localb2 == null)
    {
      localb1 = localb2;
      if (paramBoolean)
      {
        localb1 = new b();
        a.a(paramObject, localb1);
      }
    }
    return localb1;
  }
  
  public static String a(Object paramObject)
  {
    return c.a(a(paramObject, false));
  }
  
  public static void a(Object paramObject, String paramString)
  {
    c.a(a(paramObject, true), paramString);
  }
  
  public static void a(Object paramObject1, String paramString, Object paramObject2)
  {
    c.a(a(paramObject1, true), paramString, paramObject2);
  }
  
  public static void a(Object paramObject, Map<String, ?> paramMap)
  {
    c.a(a(paramObject, true), paramMap);
  }
  
  public static Map<String, ?> b(Object paramObject)
  {
    return c.b(a(paramObject, false));
  }
  
  public static void b(Object paramObject, String paramString)
  {
    c.b(a(paramObject, false), paramString);
  }
  
  public static void b(Object paramObject1, String paramString, Object paramObject2)
  {
    c.b(a(paramObject1, true), paramString, paramObject2);
  }
  
  public static void b(Object paramObject, Map<String, ?> paramMap)
  {
    c.b(a(paramObject, true), paramMap);
  }
  
  public static String c(Object paramObject)
  {
    return c.d(a(paramObject, false));
  }
  
  public static void c(Object paramObject, String paramString)
  {
    c.c(a(paramObject, true), paramString);
  }
  
  @Nullable
  public static Object d(Object paramObject, String paramString)
  {
    return c.d(a(paramObject, true), paramString);
  }
  
  public static Map<String, ?> d(Object paramObject)
  {
    return c.e(a(paramObject, false));
  }
  
  public static void e(Object paramObject, String paramString)
  {
    c.e(a(paramObject, true), paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.trackrecordlib.d.a.e
 * JD-Core Version:    0.7.0.1
 */