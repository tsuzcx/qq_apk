package com.tencent.turingfd.sdk.ams.ga;

import java.util.HashMap;

public class do
{
  public static String a(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(paramInt);
    return localStringBuilder.toString();
  }
  
  public static void a(StringBuilder paramStringBuilder, int paramInt, HashMap paramHashMap, Object paramObject)
  {
    paramStringBuilder.append(paramInt);
    paramHashMap.put(paramObject, paramStringBuilder.toString());
  }
  
  public static void a(HashMap paramHashMap, Object paramObject1, Object paramObject2, long paramLong, int paramInt)
  {
    paramHashMap.put(paramObject1, paramObject2);
    Dorado.b(paramInt, System.currentTimeMillis() - paramLong);
  }
  
  public static StringBuilder b(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    return localStringBuilder;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.ams.ga.do
 * JD-Core Version:    0.7.0.1
 */