package com.tencent.mobileqq.webview.util;

import java.util.HashSet;

public class WebViewComUtils
{
  public static long a;
  public static final HashSet<String> b = new HashSet();
  
  static
  {
    b.add("Meizu_M040");
    b.add("YuLong_Coolpad8720Q");
    b.add("YuLong_Coolpad 7269");
    b.add("samsung_SM-G9006W");
  }
  
  public static boolean a(long paramLong)
  {
    long l = System.currentTimeMillis();
    if (l - a > paramLong)
    {
      a = l;
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.util.WebViewComUtils
 * JD-Core Version:    0.7.0.1
 */