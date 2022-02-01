package com.tencent.mobileqq.qshadow.utils;

import android.text.TextUtils;

public class PluginIdUtil
{
  public static String convertQPluginId2QShadowId(String paramString)
  {
    int i = paramString.indexOf(".apk");
    if (i < 0) {
      return paramString;
    }
    return paramString.substring(0, i);
  }
  
  public static String convertQShadowId2QPluginId(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getGroupId(paramString));
    localStringBuilder.append(".apk");
    return localStringBuilder.toString();
  }
  
  public static String getGroupId(String paramString)
  {
    int i = paramString.indexOf("-");
    if (i < 0) {
      return paramString;
    }
    return paramString.substring(0, i);
  }
  
  public static boolean isQPluginId(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.contains(".apk"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qshadow.utils.PluginIdUtil
 * JD-Core Version:    0.7.0.1
 */