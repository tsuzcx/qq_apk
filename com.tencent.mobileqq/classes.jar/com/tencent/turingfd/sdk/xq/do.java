package com.tencent.turingfd.sdk.xq;

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
  
  public static String a(StringBuilder paramStringBuilder, String paramString1, String paramString2)
  {
    paramStringBuilder.append(paramString1);
    paramStringBuilder.append(paramString2);
    return paramStringBuilder.toString();
  }
  
  public static void a(HashMap paramHashMap, Object paramObject1, Object paramObject2, long paramLong, int paramInt)
  {
    paramHashMap.put(paramObject1, paramObject2);
    Dew.b(paramInt, System.currentTimeMillis() - paramLong);
  }
  
  public static StringBuilder b(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    return localStringBuilder;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.do
 * JD-Core Version:    0.7.0.1
 */