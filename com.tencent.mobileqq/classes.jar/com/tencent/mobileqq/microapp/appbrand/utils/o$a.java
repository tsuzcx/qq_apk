package com.tencent.mobileqq.microapp.appbrand.utils;

public final class o$a
{
  private static final Integer[] a = new Integer[3968];
  
  static
  {
    int i = 128;
    while (i < 4096)
    {
      a[(i - 128)] = new Integer(i);
      i += 1;
    }
  }
  
  public static Integer a(int paramInt)
  {
    int i = paramInt;
    if (paramInt >= 128)
    {
      i = paramInt;
      if (paramInt < 4096) {
        i = a[(paramInt - 128)].intValue();
      }
    }
    return Integer.valueOf(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.utils.o.a
 * JD-Core Version:    0.7.0.1
 */