package com.tencent.mobileqq.search.base.util;

import java.util.HashMap;
import java.util.Map;

public class SearchStatisticsConstants
{
  private static String a = "";
  private static int b;
  private static Map<Integer, Integer> c = new HashMap();
  
  public static int a(int paramInt)
  {
    Integer localInteger = (Integer)c.get(Integer.valueOf(paramInt));
    if (localInteger == null) {
      return 0;
    }
    return localInteger.intValue();
  }
  
  public static String a()
  {
    return a;
  }
  
  public static void b()
  {
    try
    {
      a = "";
      b = 0;
      c.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      break;
    }
    try
    {
      b += 1;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(a);
      localStringBuilder.append(paramInt);
      localStringBuilder.append("|");
      a = localStringBuilder.toString();
      c.put(Integer.valueOf(paramInt), Integer.valueOf(b));
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.base.util.SearchStatisticsConstants
 * JD-Core Version:    0.7.0.1
 */