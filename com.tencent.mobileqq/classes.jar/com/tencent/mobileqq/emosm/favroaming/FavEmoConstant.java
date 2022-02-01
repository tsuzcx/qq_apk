package com.tencent.mobileqq.emosm.favroaming;

import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.qphone.base.util.QLog;

public class FavEmoConstant
{
  public static int a = 300;
  public static int b = 300;
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return AppConstants.SDCARD_IMG_FAVORITE + b(paramString);
  }
  
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3))) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder("https://p.qpic.cn/");
    localStringBuilder.append(paramString2).append("/").append(paramString3).append("/").append(paramString1).append("/0");
    return localStringBuilder.toString();
  }
  
  public static String b(String paramString)
  {
    String str = paramString;
    if (paramString.length() > 4)
    {
      str = paramString.substring(4);
      if (QLog.isDevelopLevel()) {
        QLog.d("FavEmoConstant", 4, paramString + " -> " + str);
      }
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.favroaming.FavEmoConstant
 * JD-Core Version:    0.7.0.1
 */