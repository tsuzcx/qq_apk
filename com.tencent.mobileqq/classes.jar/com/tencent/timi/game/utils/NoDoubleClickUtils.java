package com.tencent.timi.game.utils;

import java.util.HashMap;

public class NoDoubleClickUtils
{
  private static HashMap<String, Long> a = new HashMap();
  
  public static boolean a()
  {
    try
    {
      boolean bool = a("default");
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static boolean a(String paramString)
  {
    for (;;)
    {
      long l2;
      try
      {
        l2 = System.currentTimeMillis();
        if (!a.containsKey(paramString)) {
          break label58;
        }
        l1 = ((Long)a.get(paramString)).longValue();
      }
      finally {}
      a.put(paramString, Long.valueOf(l2));
      boolean bool;
      return bool;
      label58:
      long l1 = 0L;
      l1 = l2 - l1;
      if ((l1 >= 0L) && (l1 <= 500L)) {
        bool = true;
      } else {
        bool = false;
      }
    }
  }
  
  public static boolean a(String paramString, long paramLong)
  {
    long l2 = System.currentTimeMillis();
    if (a.containsKey(paramString)) {
      l1 = ((Long)a.get(paramString)).longValue();
    } else {
      l1 = 0L;
    }
    long l1 = l2 - l1;
    boolean bool;
    if ((l1 >= 0L) && (l1 <= paramLong)) {
      bool = true;
    } else {
      bool = false;
    }
    a.put(paramString, Long.valueOf(l2));
    return bool;
  }
  
  public static boolean b(String paramString, long paramLong)
  {
    long l2 = System.currentTimeMillis();
    if (a.containsKey(paramString)) {
      l1 = ((Long)a.get(paramString)).longValue();
    } else {
      l1 = 0L;
    }
    long l1 = l2 - l1;
    boolean bool;
    if ((l1 >= 0L) && (l1 <= paramLong)) {
      bool = true;
    } else {
      bool = false;
    }
    if (!bool) {
      a.put(paramString, Long.valueOf(l2));
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.utils.NoDoubleClickUtils
 * JD-Core Version:    0.7.0.1
 */