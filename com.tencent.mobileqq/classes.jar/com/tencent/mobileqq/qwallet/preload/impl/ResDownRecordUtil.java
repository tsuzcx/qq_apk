package com.tencent.mobileqq.qwallet.preload.impl;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import mqq.app.MobileQQ;

public class ResDownRecordUtil
{
  private static SharedPreferences a(int paramInt)
  {
    if (MobileQQ.sMobileQQ != null)
    {
      if (paramInt == 1) {
        return MobileQQ.sMobileQQ.getSharedPreferences("qwallet_res_down_record_utilinner", 4);
      }
      return MobileQQ.sMobileQQ.getSharedPreferences("qwallet_res_down_record_util", 4);
    }
    return null;
  }
  
  public static void a(String paramString, int paramInt)
  {
    Object localObject = a(paramInt);
    if ((localObject != null) && (!TextUtils.isEmpty(paramString)))
    {
      localObject = ((SharedPreferences)localObject).edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("url_down_scene");
      localStringBuilder.append(paramString);
      ((SharedPreferences.Editor)localObject).remove(localStringBuilder.toString()).apply();
    }
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2)
  {
    Object localObject = a(paramInt2);
    if ((localObject != null) && (!TextUtils.isEmpty(paramString)))
    {
      localObject = ((SharedPreferences)localObject).edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("url_down_scene");
      localStringBuilder.append(paramString);
      ((SharedPreferences.Editor)localObject).putInt(localStringBuilder.toString(), paramInt1).apply();
    }
  }
  
  public static int b(String paramString, int paramInt1, int paramInt2)
  {
    SharedPreferences localSharedPreferences = a(paramInt2);
    if ((localSharedPreferences != null) && (!TextUtils.isEmpty(paramString)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("url_down_scene");
      localStringBuilder.append(paramString);
      return localSharedPreferences.getInt(localStringBuilder.toString(), paramInt1);
    }
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.preload.impl.ResDownRecordUtil
 * JD-Core Version:    0.7.0.1
 */