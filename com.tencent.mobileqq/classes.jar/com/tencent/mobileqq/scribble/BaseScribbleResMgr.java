package com.tencent.mobileqq.scribble;

import com.tencent.mobileqq.app.AppConstants;

public class BaseScribbleResMgr
{
  public static final Long a;
  public static final String a;
  public static final String b;
  public static final String c;
  public static final String d;
  public static final String e;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SCRIBBLE_FILE_DIR);
    localStringBuilder.append("Config/");
    jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SCRIBBLE_FILE_DIR);
    localStringBuilder.append("Config/paint/");
    b = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SCRIBBLE_FILE_DIR);
    localStringBuilder.append("Config/gif/");
    c = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SCRIBBLE_FILE_DIR);
    localStringBuilder.append("Config/line_icon/");
    d = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SCRIBBLE_FILE_DIR);
    localStringBuilder.append("Config/gif_icon/");
    e = localStringBuilder.toString();
    jdField_a_of_type_JavaLangLong = Long.valueOf(30000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.scribble.BaseScribbleResMgr
 * JD-Core Version:    0.7.0.1
 */