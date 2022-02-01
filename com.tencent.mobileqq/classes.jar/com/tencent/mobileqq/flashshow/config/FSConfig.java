package com.tencent.mobileqq.flashshow.config;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.biz.richframework.delegate.impl.RFApplication;
import com.tencent.mobileqq.flashshow.utils.FSHardCodeUtil;
import com.tencent.mobileqq.flashshow.utils.FSTransUtils;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import qqcircle.QQCircleFeedBase.StBusiInfoData;

public class FSConfig
{
  public static SharedPreferences a()
  {
    String str = FSTransUtils.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(FSSpKey.a);
    localStringBuilder.append(str);
    str = localStringBuilder.toString();
    return RFApplication.getApplication().getSharedPreferences(str, 0);
  }
  
  public static Integer a(String paramString1, String paramString2, Integer paramInteger)
  {
    return QCircleConfigHelper.a(paramString1, paramString2, paramInteger);
  }
  
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    return QCircleConfigHelper.a(paramString1, paramString2, paramString3);
  }
  
  public static void a(int paramInt)
  {
    Object localObject = a();
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(FSSpKey.c);
      localStringBuilder.append("_");
      localStringBuilder.append(FSTransUtils.a());
      ((SharedPreferences.Editor)localObject).putInt(localStringBuilder.toString(), paramInt).apply();
    }
  }
  
  public static void a(String paramString)
  {
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putString(FSSpKey.d, paramString).apply();
    }
  }
  
  public static void a(byte[] paramArrayOfByte)
  {
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences != null)
    {
      paramArrayOfByte = new String(Base64.encode(paramArrayOfByte, 0));
      localSharedPreferences.edit().putString(FSSpKey.b, paramArrayOfByte).apply();
    }
  }
  
  public static int b()
  {
    return a("qqflash", "flashshow_jump_show_tab", Integer.valueOf(41)).intValue();
  }
  
  public static QQCircleFeedBase.StBusiInfoData c()
  {
    Object localObject = a();
    if (localObject != null) {}
    try
    {
      localObject = ((SharedPreferences)localObject).getString(FSSpKey.b, "");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = Base64.decode(((String)localObject).getBytes(), 0);
        QQCircleFeedBase.StBusiInfoData localStBusiInfoData = new QQCircleFeedBase.StBusiInfoData();
        localStBusiInfoData.mergeFrom((byte[])localObject);
        QLog.d("FSConfig", 2, "getBusiInfoData() success!");
        return localStBusiInfoData;
      }
      return null;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public static long d()
  {
    return a("qqflash", "flashshow_report_interval", Integer.valueOf(10)).intValue();
  }
  
  public static int e()
  {
    return a("qqflash", "flashshow_report_buffer_length", Integer.valueOf(10)).intValue();
  }
  
  public static long f()
  {
    return a("qqflash", "flash_show_quality_report_interval", Integer.valueOf(60)).intValue();
  }
  
  public static int g()
  {
    return a("qqflash", "flash_show_quality_buffer_length", Integer.valueOf(5)).intValue();
  }
  
  public static String h()
  {
    return a("qqflash", "qqflash_error_hint_no_concerns", FSHardCodeUtil.a(2131889710));
  }
  
  public static String i()
  {
    return a("qqflash", "qqflash_error_hint_no_comment", FSHardCodeUtil.a(2131889709));
  }
  
  public static String j()
  {
    return a("qqflash", "qqflash_error_hint_no_product", FSHardCodeUtil.a(2131889712));
  }
  
  public static String k()
  {
    return a("qqflash", "qqflash_error_hint_no_praised", FSHardCodeUtil.a(2131889711));
  }
  
  public static String l()
  {
    return a("qqflash", "qqflash_error_hint_no_message", FSHardCodeUtil.a(2131889730));
  }
  
  public static String m()
  {
    return a("qqflash", "qqflash_error_hint_no_rcmd", FSHardCodeUtil.a(2131889713));
  }
  
  public static String n()
  {
    return a("qqflash", "qqflash_error_hint_server_exception", FSHardCodeUtil.a(2131889713));
  }
  
  public static int o()
  {
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(FSSpKey.c);
      localStringBuilder.append("_");
      localStringBuilder.append(FSTransUtils.a());
      return localSharedPreferences.getInt(localStringBuilder.toString(), 0);
    }
    return 0;
  }
  
  public static String p()
  {
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences != null) {
      return localSharedPreferences.getString(FSSpKey.d, "");
    }
    return "";
  }
  
  public static boolean q()
  {
    return a("qqflash", "qqflash_publish_entrance_enable", Integer.valueOf(1)).intValue() == 1;
  }
  
  public static boolean r()
  {
    return a("qqflash", "qqflash_prefetch_feed_enable", Integer.valueOf(1)).intValue() == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.config.FSConfig
 * JD-Core Version:    0.7.0.1
 */