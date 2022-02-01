package com.tencent.mobileqq.filemanager.tem.util;

import java.util.HashMap;
import java.util.TimeZone;

public class FileManagerUtil
{
  private static HashMap<String, Integer> a = null;
  
  private static long a(long paramLong, TimeZone paramTimeZone)
  {
    return (paramTimeZone.getOffset(paramLong) + paramLong) / 86400000L;
  }
  
  public static boolean a(long paramLong1, long paramLong2, TimeZone paramTimeZone)
  {
    long l = paramLong1 - paramLong2;
    return (l < 86400000L) && (l > -86400000L) && (a(paramLong1, paramTimeZone) == a(paramLong2, paramTimeZone));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.tem.util.FileManagerUtil
 * JD-Core Version:    0.7.0.1
 */