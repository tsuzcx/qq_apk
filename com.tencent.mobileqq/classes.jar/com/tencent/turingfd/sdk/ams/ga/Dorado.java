package com.tencent.turingfd.sdk.ams.ga;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Dorado
{
  public static Map<Integer, Long> Md = new HashMap();
  
  public static String R()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = Md.keySet().iterator();
    while (localIterator.hasNext())
    {
      int i = ((Integer)localIterator.next()).intValue();
      localStringBuilder.append(",");
      localStringBuilder.append(i);
      localStringBuilder.append("_");
      localStringBuilder.append(Md.get(Integer.valueOf(i)));
    }
    return localStringBuilder.toString();
  }
  
  public static void b(int paramInt, long paramLong)
  {
    Md.put(Integer.valueOf(paramInt), Long.valueOf(paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.ams.ga.Dorado
 * JD-Core Version:    0.7.0.1
 */