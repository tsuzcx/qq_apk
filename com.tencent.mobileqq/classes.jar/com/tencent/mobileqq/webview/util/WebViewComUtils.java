package com.tencent.mobileqq.webview.util;

import java.util.HashSet;

public class WebViewComUtils
{
  public static long a;
  public static final HashSet<String> a;
  
  static
  {
    jdField_a_of_type_JavaUtilHashSet = new HashSet();
    jdField_a_of_type_JavaUtilHashSet.add("Meizu_M040");
    jdField_a_of_type_JavaUtilHashSet.add("YuLong_Coolpad8720Q");
    jdField_a_of_type_JavaUtilHashSet.add("YuLong_Coolpad 7269");
    jdField_a_of_type_JavaUtilHashSet.add("samsung_SM-G9006W");
  }
  
  public static boolean a(long paramLong)
  {
    long l = System.currentTimeMillis();
    if (l - jdField_a_of_type_Long > paramLong)
    {
      jdField_a_of_type_Long = l;
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.util.WebViewComUtils
 * JD-Core Version:    0.7.0.1
 */