package com.tencent.mobileqq.qqgift.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qphone.base.util.QLog;

public class QQGiftSpUtil
{
  public static String a(Context paramContext, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getString ");
      localStringBuilder.append(paramString);
      QLog.i("QQGiftSpUtil", 2, localStringBuilder.toString());
    }
    if (paramContext != null) {
      return paramContext.getSharedPreferences("qq_gift_sp", 4).getString(paramString, "");
    }
    return "";
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("saveString ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("_");
      localStringBuilder.append(paramString2);
      QLog.i("QQGiftSpUtil", 2, localStringBuilder.toString());
    }
    paramContext = paramContext.getSharedPreferences("qq_gift_sp", 4).edit();
    paramContext.putString(paramString1, paramString2);
    paramContext.apply();
  }
  
  public static void b(Context paramContext, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("remove ");
      localStringBuilder.append(paramString);
      QLog.i("QQGiftSpUtil", 2, localStringBuilder.toString());
    }
    if (paramContext != null)
    {
      paramContext = paramContext.getSharedPreferences("qq_gift_sp", 4).edit();
      paramContext.remove(paramString);
      paramContext.apply();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.utils.QQGiftSpUtil
 * JD-Core Version:    0.7.0.1
 */