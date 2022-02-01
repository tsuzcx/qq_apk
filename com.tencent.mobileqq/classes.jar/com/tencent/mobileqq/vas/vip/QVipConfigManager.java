package com.tencent.mobileqq.vas.vip;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class QVipConfigManager
{
  public static int a(@NonNull AppRuntime paramAppRuntime, @NonNull String paramString, int paramInt)
  {
    SharedPreferences localSharedPreferences = paramAppRuntime.getApp().getSharedPreferences("qq_vip_configs", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramAppRuntime.getCurrentAccountUin());
    paramAppRuntime = localStringBuilder.toString();
    paramInt = localSharedPreferences.getInt(paramAppRuntime, paramInt);
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("get sp key:");
      paramString.append(paramAppRuntime);
      paramString.append(" value=");
      paramString.append(paramInt);
      QLog.d("QVip.ConfigManager", 1, paramString.toString());
    }
    return paramInt;
  }
  
  public static long a(@NonNull AppRuntime paramAppRuntime, @NonNull String paramString, long paramLong)
  {
    SharedPreferences localSharedPreferences = paramAppRuntime.getApp().getSharedPreferences("qq_vip_configs", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramAppRuntime.getCurrentAccountUin());
    paramAppRuntime = localStringBuilder.toString();
    paramLong = localSharedPreferences.getLong(paramAppRuntime, paramLong);
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("get sp key:");
      paramString.append(paramAppRuntime);
      paramString.append(" value=");
      paramString.append(paramLong);
      QLog.d("QVip.ConfigManager", 1, paramString.toString());
    }
    return paramLong;
  }
  
  public static String a(@NonNull AppRuntime paramAppRuntime, @NonNull String paramString1, String paramString2)
  {
    SharedPreferences localSharedPreferences = paramAppRuntime.getApp().getSharedPreferences("qq_vip_configs", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramAppRuntime.getCurrentAccountUin());
    paramAppRuntime = localStringBuilder.toString();
    paramString1 = localSharedPreferences.getString(paramAppRuntime, paramString2);
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("get sp key:");
      paramString2.append(paramAppRuntime);
      paramString2.append(" value=");
      paramString2.append(paramString1);
      QLog.d("QVip.ConfigManager", 1, paramString2.toString());
    }
    return paramString1;
  }
  
  public static boolean a(@NonNull AppRuntime paramAppRuntime, @NonNull String paramString, boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = paramAppRuntime.getApp().getSharedPreferences("qq_vip_configs", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramAppRuntime.getCurrentAccountUin());
    paramAppRuntime = localStringBuilder.toString();
    paramBoolean = localSharedPreferences.getBoolean(paramAppRuntime, paramBoolean);
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("get sp key:");
      paramString.append(paramAppRuntime);
      paramString.append(" value=");
      paramString.append(paramBoolean);
      QLog.d("QVip.ConfigManager", 1, paramString.toString());
    }
    return paramBoolean;
  }
  
  public static boolean b(@NonNull AppRuntime paramAppRuntime, @NonNull String paramString, int paramInt)
  {
    SharedPreferences localSharedPreferences = paramAppRuntime.getApp().getSharedPreferences("qq_vip_configs", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramAppRuntime.getCurrentAccountUin());
    paramAppRuntime = localStringBuilder.toString();
    boolean bool = localSharedPreferences.edit().putInt(paramAppRuntime, paramInt).commit();
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("set sp key:");
      paramString.append(paramAppRuntime);
      paramString.append(" value=");
      paramString.append(bool);
      QLog.d("QVip.ConfigManager", 1, paramString.toString());
    }
    return bool;
  }
  
  public static boolean b(@NonNull AppRuntime paramAppRuntime, @NonNull String paramString, long paramLong)
  {
    SharedPreferences localSharedPreferences = paramAppRuntime.getApp().getSharedPreferences("qq_vip_configs", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramAppRuntime.getCurrentAccountUin());
    paramAppRuntime = localStringBuilder.toString();
    boolean bool = localSharedPreferences.edit().putLong(paramAppRuntime, paramLong).commit();
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("set sp key:");
      paramString.append(paramAppRuntime);
      paramString.append(" value=");
      paramString.append(bool);
      QLog.d("QVip.ConfigManager", 1, paramString.toString());
    }
    return bool;
  }
  
  public static boolean b(@NonNull AppRuntime paramAppRuntime, @NonNull String paramString1, String paramString2)
  {
    SharedPreferences localSharedPreferences = paramAppRuntime.getApp().getSharedPreferences("qq_vip_configs", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramAppRuntime.getCurrentAccountUin());
    paramAppRuntime = localStringBuilder.toString();
    boolean bool = localSharedPreferences.edit().putString(paramAppRuntime, paramString2).commit();
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("set sp key:");
      paramString1.append(paramAppRuntime);
      paramString1.append(" value=");
      paramString1.append(paramString2);
      QLog.d("QVip.ConfigManager", 1, paramString1.toString());
    }
    return bool;
  }
  
  public static boolean b(@NonNull AppRuntime paramAppRuntime, @NonNull String paramString, boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = paramAppRuntime.getApp().getSharedPreferences("qq_vip_configs", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramAppRuntime.getCurrentAccountUin());
    paramAppRuntime = localStringBuilder.toString();
    paramBoolean = localSharedPreferences.edit().putBoolean(paramAppRuntime, paramBoolean).commit();
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("set sp key:");
      paramString.append(paramAppRuntime);
      paramString.append(" value=");
      paramString.append(paramBoolean);
      QLog.d("QVip.ConfigManager", 1, paramString.toString());
    }
    return paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.vip.QVipConfigManager
 * JD-Core Version:    0.7.0.1
 */