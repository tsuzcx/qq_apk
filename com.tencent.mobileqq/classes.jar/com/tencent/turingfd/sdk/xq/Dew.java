package com.tencent.turingfd.sdk.xq;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Dew
{
  public static Map<Integer, Long> fi = new HashMap();
  
  public static String L()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = fi.keySet().iterator();
    while (localIterator.hasNext())
    {
      int i = ((Integer)localIterator.next()).intValue();
      localStringBuilder.append(",");
      localStringBuilder.append(i);
      localStringBuilder.append("_");
      localStringBuilder.append(fi.get(Integer.valueOf(i)));
    }
    return localStringBuilder.toString();
  }
  
  public static void b(int paramInt, long paramLong)
  {
    fi.put(Integer.valueOf(paramInt), Long.valueOf(paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Dew
 * JD-Core Version:    0.7.0.1
 */