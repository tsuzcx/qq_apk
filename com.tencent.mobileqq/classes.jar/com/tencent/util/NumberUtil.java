package com.tencent.util;

public class NumberUtil
{
  public static int a(String paramString)
  {
    return a(paramString, 0);
  }
  
  public static int a(String paramString, int paramInt)
  {
    try
    {
      int i = Integer.valueOf(paramString).intValue();
      return i;
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
    }
    return paramInt;
  }
  
  public static long a(String paramString)
  {
    return a(paramString, 0L);
  }
  
  public static long a(String paramString, long paramLong)
  {
    try
    {
      long l = Long.valueOf(paramString).longValue();
      return l;
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
    }
    return paramLong;
  }
  
  public static String a(int[][] paramArrayOfInt)
  {
    StringBuilder localStringBuilder = new StringBuilder("[");
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0) && (paramArrayOfInt[0].length > 0))
    {
      int k = paramArrayOfInt.length;
      int i = 0;
      while (i < k)
      {
        int[] arrayOfInt = paramArrayOfInt[i];
        localStringBuilder.append("[");
        int j = 0;
        while (j < arrayOfInt.length - 1)
        {
          localStringBuilder.append(arrayOfInt[j]);
          localStringBuilder.append(", ");
          j += 1;
        }
        localStringBuilder.append(arrayOfInt[j]);
        localStringBuilder.append("] ");
        i += 1;
      }
    }
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.util.NumberUtil
 * JD-Core Version:    0.7.0.1
 */