package com.tencent.mobileqq.utils;

public class NumberUtils
{
  public static long a(String paramString)
  {
    return a(paramString, -1L);
  }
  
  public static long a(String paramString, long paramLong)
  {
    try
    {
      long l = Long.parseLong(paramString);
      return l;
    }
    catch (NumberFormatException paramString) {}
    return paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.NumberUtils
 * JD-Core Version:    0.7.0.1
 */