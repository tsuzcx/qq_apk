package com.tencent.mobileqq.utils;

public class HttpDownloadUtil$TimeoutParam
{
  public static int a = 40000;
  public static int b = 30000;
  public static int c = 20000;
  public static int d = 20000;
  public static int e = 15000;
  public static int f = 10000;
  public static int g;
  
  public static int a(int paramInt)
  {
    if (paramInt != 1) {
      if (paramInt != 3)
      {
        if ((paramInt != 4) && (paramInt != 5)) {
          return a;
        }
      }
      else {
        return b;
      }
    }
    return c;
  }
  
  public static int b(int paramInt)
  {
    int i;
    if (paramInt != 1) {
      if (paramInt != 3)
      {
        if ((paramInt == 4) || (paramInt == 5)) {
          break label43;
        }
        i = d;
        paramInt = g;
      }
    }
    for (;;)
    {
      return i + paramInt;
      i = e;
      paramInt = g;
      continue;
      label43:
      i = f;
      paramInt = g;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.HttpDownloadUtil.TimeoutParam
 * JD-Core Version:    0.7.0.1
 */