package com.tencent.mobileqq.util;

import com.tencent.common.app.BaseApplicationImpl;

public class AppUtil
{
  public static boolean a()
  {
    return "com.tencent.mobileqq".equals(b());
  }
  
  public static String b()
  {
    return BaseApplicationImpl.getApplication().getQQProcessName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.util.AppUtil
 * JD-Core Version:    0.7.0.1
 */