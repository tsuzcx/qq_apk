package com.tencent.mobileqq.scribble;

import com.tencent.mobileqq.app.AppConstants;

public class ScribbleMsgConstants
{
  public static int a = 0;
  public static int b = 1;
  public static int c = 2;
  public static int d = 1;
  public static int e = 2;
  public static int f = 3;
  public static int g = 4;
  public static int h = 5;
  public static int i = 6;
  public static int j = 7;
  
  public static String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SCRIBBLE_FILE_DIR);
    localStringBuilder.append("ScribbleCache/");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.scribble.ScribbleMsgConstants
 * JD-Core Version:    0.7.0.1
 */