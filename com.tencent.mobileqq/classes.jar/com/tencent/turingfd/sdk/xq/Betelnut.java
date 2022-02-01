package com.tencent.turingfd.sdk.xq;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Betelnut
{
  public static Map<Integer, Long> mh = new HashMap();
  
  public static void a(int paramInt, long paramLong)
  {
    mh.put(Integer.valueOf(paramInt), Long.valueOf(paramLong));
  }
  
  public static String y()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = mh.keySet().iterator();
    while (localIterator.hasNext())
    {
      int i = ((Integer)localIterator.next()).intValue();
      localStringBuilder.append(",");
      localStringBuilder.append(i);
      localStringBuilder.append("_");
      localStringBuilder.append(mh.get(Integer.valueOf(i)));
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Betelnut
 * JD-Core Version:    0.7.0.1
 */