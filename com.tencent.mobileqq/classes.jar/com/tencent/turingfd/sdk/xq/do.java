package com.tencent.turingfd.sdk.xq;

import java.util.HashMap;

public class do
{
  public static String a(String paramString, int paramInt)
  {
    return paramString + paramInt;
  }
  
  public static StringBuilder a(String paramString)
  {
    return new StringBuilder().append(paramString);
  }
  
  public static void a(StringBuilder paramStringBuilder, int paramInt, HashMap paramHashMap, Object paramObject)
  {
    paramHashMap.put(paramObject, paramInt);
  }
  
  public static void a(HashMap paramHashMap, Object paramObject1, Object paramObject2, long paramLong, int paramInt)
  {
    paramHashMap.put(paramObject1, paramObject2);
    Betelnut.a(paramInt, System.currentTimeMillis() - paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.do
 * JD-Core Version:    0.7.0.1
 */