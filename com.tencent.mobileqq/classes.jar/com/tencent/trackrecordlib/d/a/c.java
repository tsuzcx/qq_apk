package com.tencent.trackrecordlib.d.a;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import java.util.HashMap;
import java.util.Map;

public class c
{
  public static String a(@Nullable b paramb)
  {
    if (paramb == null) {
      return null;
    }
    return paramb.a;
  }
  
  public static void a(@NonNull b paramb, String paramString)
  {
    paramb.a = paramString;
  }
  
  public static void a(@NonNull b paramb, String paramString, Object paramObject)
  {
    if (paramb.e == null) {
      paramb.e = new ArrayMap(1);
    }
    paramb.e.put(paramString, paramObject);
  }
  
  public static void a(@NonNull b paramb, Map<String, ?> paramMap)
  {
    paramb.b = paramMap;
  }
  
  public static Map<String, ?> b(@Nullable b paramb)
  {
    if (paramb == null) {
      return null;
    }
    return paramb.b;
  }
  
  public static void b(@NonNull b paramb, String paramString)
  {
    if (paramb.e != null) {
      paramb.e.remove(paramString);
    }
  }
  
  public static void b(@NonNull b paramb, String paramString, Object paramObject)
  {
    if (paramb.f == null) {
      paramb.f = new HashMap(1);
    }
    paramb.f.put(paramString, paramObject);
  }
  
  public static void b(@NonNull b paramb, Map<String, ?> paramMap)
  {
    paramb.d = paramMap;
  }
  
  public static Map<String, ?> c(@Nullable b paramb)
  {
    if (paramb == null) {
      return null;
    }
    return paramb.e;
  }
  
  public static void c(@NonNull b paramb, String paramString)
  {
    paramb.c = paramString;
  }
  
  @Nullable
  public static Object d(@NonNull b paramb, String paramString)
  {
    if (paramb.f == null) {
      return null;
    }
    return paramb.f.get(paramString);
  }
  
  public static String d(@Nullable b paramb)
  {
    if (paramb == null) {
      return null;
    }
    return paramb.c;
  }
  
  public static Map<String, ?> e(@Nullable b paramb)
  {
    if (paramb == null) {
      return null;
    }
    return paramb.d;
  }
  
  public static void e(@NonNull b paramb, String paramString)
  {
    if (paramb.f != null) {
      paramb.f.remove(paramString);
    }
  }
  
  public static b f(b paramb)
  {
    b localb = new b();
    localb.a = paramb.a;
    localb.b = paramb.b;
    localb.c = paramb.c;
    localb.d = paramb.d;
    localb.f = paramb.f;
    return localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trackrecordlib.d.a.c
 * JD-Core Version:    0.7.0.1
 */