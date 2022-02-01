package com.tencent.mobileqq.search.mostused;

public class MostUseConstants
{
  public static final int[] a = { 1, 2, 3, 4 };
  public static final int[] b = { 6 };
  public static final int[] c = { 7 };
  
  public static int a(int paramInt)
  {
    int[] arrayOfInt = a;
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      if (arrayOfInt[i] == paramInt) {
        return 1;
      }
      i += 1;
    }
    arrayOfInt = b;
    j = arrayOfInt.length;
    i = 0;
    while (i < j)
    {
      if (arrayOfInt[i] == paramInt) {
        return 2;
      }
      i += 1;
    }
    arrayOfInt = c;
    j = arrayOfInt.length;
    i = 0;
    while (i < j)
    {
      if (arrayOfInt[i] == paramInt) {
        return 3;
      }
      i += 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.mostused.MostUseConstants
 * JD-Core Version:    0.7.0.1
 */