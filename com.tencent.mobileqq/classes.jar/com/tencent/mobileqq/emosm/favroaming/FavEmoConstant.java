package com.tencent.mobileqq.emosm.favroaming;

import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;

public class FavEmoConstant
{
  public static int a = 144;
  public static int b = 300;
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return AppConstants.aU + paramString;
  }
  
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3))) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder("http://p.qpic.cn/");
    localStringBuilder.append(paramString2).append("/").append(paramString3).append("/").append(paramString1).append("/0");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.favroaming.FavEmoConstant
 * JD-Core Version:    0.7.0.1
 */