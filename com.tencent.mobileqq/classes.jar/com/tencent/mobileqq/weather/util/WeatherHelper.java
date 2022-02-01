package com.tencent.mobileqq.weather.util;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;

public class WeatherHelper
{
  public static boolean a(Context paramContext)
  {
    return (paramContext != null) && (ContextCompat.checkSelfPermission(paramContext, "android.permission.ACCESS_FINE_LOCATION") == 0);
  }
  
  public static boolean a(String paramString)
  {
    return ("2658655094".equals(paramString)) || ("3142131160".equals(paramString));
  }
  
  public static boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return paramString.startsWith("https://weather.mp.qq.com/pages/aio");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.weather.util.WeatherHelper
 * JD-Core Version:    0.7.0.1
 */