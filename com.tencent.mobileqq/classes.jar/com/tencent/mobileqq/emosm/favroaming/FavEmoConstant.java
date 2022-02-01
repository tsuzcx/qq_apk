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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_IMG_FAVORITE);
    localStringBuilder.append(b(paramString));
    return localStringBuilder.toString();
  }
  
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3)))
    {
      StringBuilder localStringBuilder = new StringBuilder("https://p.qpic.cn/");
      localStringBuilder.append(paramString2);
      localStringBuilder.append("/");
      localStringBuilder.append(paramString3);
      localStringBuilder.append("/");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("/0");
      return localStringBuilder.toString();
    }
    return null;
  }
  
  public static String b(String paramString)
  {
    if (paramString.length() > 4)
    {
      String str = paramString.substring(4);
      if (QLog.isDevelopLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append(" -> ");
        localStringBuilder.append(str);
        QLog.d("FavEmoConstant", 4, localStringBuilder.toString());
      }
      return str;
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.favroaming.FavEmoConstant
 * JD-Core Version:    0.7.0.1
 */