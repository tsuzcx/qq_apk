package com.tencent.mobileqq.config;

import com.tencent.mobileqq.app.AppConstants;

public class QQMapConstants
{
  public static String a = "com.tencent.map.WelcomeActivity";
  public static String b = "com.google.android.maps.MapsActivity";
  public static String c = "com.tencent.map";
  public static String d = "com.autonavi.minimap";
  public static String e = "com.google.android.apps.maps";
  public static String f = "com.baidu.BaiduMap";
  public static String g;
  public static String h = "QQMAP_DEFAULT";
  public static String i = "Location";
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_FILE_SAVE_TMP_PATH);
    localStringBuilder.append("tencentmap.apk");
    g = localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.QQMapConstants
 * JD-Core Version:    0.7.0.1
 */