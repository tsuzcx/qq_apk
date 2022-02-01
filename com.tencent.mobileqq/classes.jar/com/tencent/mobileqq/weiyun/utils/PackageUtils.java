package com.tencent.mobileqq.weiyun.utils;

import com.tencent.mobileqq.transfile.TransFileUtil;

public class PackageUtils
{
  private static int a;
  private static int b;
  private static int c;
  private static int d;
  
  public static int a()
  {
    e();
    return a;
  }
  
  public static int b()
  {
    e();
    return b;
  }
  
  public static int c()
  {
    e();
    return c;
  }
  
  public static int d()
  {
    e();
    return d;
  }
  
  private static void e()
  {
    String[] arrayOfString;
    if (c == 0)
    {
      arrayOfString = TransFileUtil.getVersionCode().split("\\.");
      if (arrayOfString.length < 4) {
        return;
      }
    }
    try
    {
      a = Integer.valueOf(arrayOfString[0]).intValue();
      b = Integer.valueOf(arrayOfString[1]).intValue();
      d = Integer.valueOf(arrayOfString[2]).intValue();
      c = Integer.valueOf(arrayOfString[3]).intValue();
      return;
    }
    catch (NumberFormatException localNumberFormatException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.weiyun.utils.PackageUtils
 * JD-Core Version:    0.7.0.1
 */