package com.tencent.mobileqq.richmedia.dc;

public class PhotoUtils
{
  public static int a(long paramLong1, long paramLong2)
  {
    if ((paramLong1 > 0L) && (paramLong2 > 0L))
    {
      long l = Math.max(paramLong1, paramLong2);
      if ((l > 500L) && (l <= 960L)) {
        return 3;
      }
      if ((l > 200L) && (l <= 500L)) {
        return 2;
      }
      if (l <= 200L) {
        return 1;
      }
      if (a(paramLong1, paramLong2)) {
        return 0;
      }
      return 4;
    }
    return -1;
  }
  
  public static boolean a(long paramLong1, long paramLong2)
  {
    return (paramLong1 >= paramLong2 * 3L) || (paramLong2 >= paramLong1 * 3L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.dc.PhotoUtils
 * JD-Core Version:    0.7.0.1
 */