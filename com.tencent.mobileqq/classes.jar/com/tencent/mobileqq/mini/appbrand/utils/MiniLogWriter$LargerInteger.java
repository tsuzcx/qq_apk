package com.tencent.mobileqq.mini.appbrand.utils;

public class MiniLogWriter$LargerInteger
{
  private static final Integer[] LARGER_VALUES = new Integer[3968];
  private static final int MAX = 4096;
  
  static
  {
    int i = 128;
    while (i < 4096)
    {
      LARGER_VALUES[(i - 128)] = new Integer(i);
      i += 1;
    }
  }
  
  public static Integer valueOf(int paramInt)
  {
    int i = paramInt;
    if (paramInt >= 128)
    {
      i = paramInt;
      if (paramInt < 4096) {
        i = LARGER_VALUES[(paramInt - 128)].intValue();
      }
    }
    return Integer.valueOf(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.utils.MiniLogWriter.LargerInteger
 * JD-Core Version:    0.7.0.1
 */