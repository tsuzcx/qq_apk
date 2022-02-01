package com.tencent.mobileqq.scribble;

import com.tencent.mobileqq.app.AppConstants;

public class BaseScribbleResMgr
{
  public static final String a;
  public static final String b;
  public static final String c;
  public static final String d;
  public static final String e;
  public static final Long f = Long.valueOf(30000L);
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SCRIBBLE_FILE_DIR);
    localStringBuilder.append("Config/");
    a = localStringBuilder.toString();
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.scribble.BaseScribbleResMgr
 * JD-Core Version:    0.7.0.1
 */