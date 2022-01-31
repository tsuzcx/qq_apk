package com.tencent.mobileqq.utils;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;

public abstract class BusinessCommonConfig$ConfigHandler
{
  public abstract int a();
  
  public int a(SharedPreferences paramSharedPreferences, String paramString1, String paramString2)
  {
    int i = 0;
    if (!TextUtils.isEmpty(paramSharedPreferences.getString(paramString1, null))) {
      i = paramSharedPreferences.getInt(paramString2, 0);
    }
    return i;
  }
  
  public abstract Class a();
  
  public String a()
  {
    return BusinessCommonConfig.a;
  }
  
  public abstract void a(QQAppInterface paramQQAppInterface, String paramString, BusinessCommonConfig.ConfigInfo paramConfigInfo);
  
  public abstract void a(String paramString, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.utils.BusinessCommonConfig.ConfigHandler
 * JD-Core Version:    0.7.0.1
 */