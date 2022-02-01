package com.tencent.mobileqq.qqgamepub.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qphone.base.util.QLog;

public class SharePreferenceUtils
{
  public static long a(Context paramContext, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getLong ");
      localStringBuilder.append(paramString);
      QLog.i("QQGamePub_SharePreferenceUtils", 2, localStringBuilder.toString());
    }
    if (paramContext != null) {
      return paramContext.getSharedPreferences("qq_game_sharepreference", 4).getLong(paramString, 0L);
    }
    return 0L;
  }
  
  public static void a(Context paramContext, String paramString, long paramLong)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("saveLong ");
      localStringBuilder.append(paramString);
      localStringBuilder.append("_");
      localStringBuilder.append(paramLong);
      QLog.i("QQGamePub_SharePreferenceUtils", 2, localStringBuilder.toString());
    }
    paramContext = paramContext.getSharedPreferences("qq_game_sharepreference", 4).edit();
    paramContext.putLong(paramString, paramLong);
    paramContext.apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.utils.SharePreferenceUtils
 * JD-Core Version:    0.7.0.1
 */