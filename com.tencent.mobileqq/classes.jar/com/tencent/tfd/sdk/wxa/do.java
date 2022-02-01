package com.tencent.tfd.sdk.wxa;

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
    Dorado.a(paramInt, System.currentTimeMillis() - paramLong);
  }
  
  public static StringBuilder b(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    return localStringBuilder;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tfd.sdk.wxa.do
 * JD-Core Version:    0.7.0.1
 */