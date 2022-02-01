package com.tencent.tfd.sdk.wxa;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Dorado
{
  public static Map<Integer, Long> yd = new HashMap();
  
  public static String O()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = yd.keySet().iterator();
    while (localIterator.hasNext())
    {
      int i = ((Integer)localIterator.next()).intValue();
      localStringBuilder.append(",");
      localStringBuilder.append(i);
      localStringBuilder.append("_");
      localStringBuilder.append(yd.get(Integer.valueOf(i)));
    }
    return localStringBuilder.toString();
  }
  
  public static void a(int paramInt, long paramLong)
  {
    yd.put(Integer.valueOf(paramInt), Long.valueOf(paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tfd.sdk.wxa.Dorado
 * JD-Core Version:    0.7.0.1
 */