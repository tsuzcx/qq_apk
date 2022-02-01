package com.tencent.mobileqq.qwallet.hb.grap.draw.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.scribble.ScribbleMsgConstants;

public class DrawRedbagMsgUtils
{
  public static int a;
  public static final String a;
  public static int b = 2;
  public static int c = 3;
  public static int d = 4;
  public static int e = 5;
  
  static
  {
    jdField_a_of_type_JavaLangString = ScribbleMsgConstants.a();
    jdField_a_of_type_Int = 1;
  }
  
  private static String c(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(jdField_a_of_type_JavaLangString);
      localStringBuilder.append(paramString);
      return localStringBuilder.toString();
    }
    return "";
  }
  
  private static String d(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(jdField_a_of_type_JavaLangString);
      localStringBuilder.append(paramString);
      localStringBuilder.append("_data");
      return localStringBuilder.toString();
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.draw.impl.DrawRedbagMsgUtils
 * JD-Core Version:    0.7.0.1
 */