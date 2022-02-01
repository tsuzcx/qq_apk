package com.tencent.qcircle.cooperation.config;

import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.biz.richframework.delegate.IConfigDelegate;
import com.tencent.biz.richframework.delegate.impl.RFApplication;
import com.tencent.biz.richframework.delegate.impl.RFLog;

public class QCircleConfigHelper
{
  private static IConfigDelegate a;
  
  public static int a()
  {
    return a().getConfigValue("qqcircle", "qqcircle_report_buffer_length", Integer.valueOf(10)).intValue();
  }
  
  public static long a()
  {
    return a().getConfigValue("qqcircle", "qqcircle_report_interval", Integer.valueOf(10)).intValue();
  }
  
  private static IConfigDelegate a()
  {
    if (a == null) {
      try
      {
        Class localClass = RFApplication.getDelegateImpl(IConfigDelegate.class);
        if (localClass != null) {
          a = (IConfigDelegate)localClass.newInstance();
        }
      }
      catch (InstantiationException localInstantiationException)
      {
        localInstantiationException.printStackTrace();
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        localIllegalAccessException.printStackTrace();
      }
    }
    return a;
  }
  
  public static Boolean a(String paramString1, String paramString2, Boolean paramBoolean)
  {
    return a().getConfigValue(paramString1, paramString2, paramBoolean);
  }
  
  public static Integer a(String paramString1, String paramString2, Integer paramInteger)
  {
    return a().getConfigValue(paramString1, paramString2, paramInteger);
  }
  
  public static String a()
  {
    SharedPreferences localSharedPreferences = QCircleSpUtil.a(true, true);
    if (localSharedPreferences != null) {
      return localSharedPreferences.getString("qcircle_need_client_report_success_rate_cmd", "");
    }
    return "";
  }
  
  public static String a(String paramString1, String paramString2)
  {
    return a(paramString1, paramString2, "");
  }
  
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    return a().getConfigValue(paramString1, paramString2, paramString3);
  }
  
  public static boolean a()
  {
    Object localObject = a();
    boolean bool = false;
    int i = ((IConfigDelegate)localObject).getConfigValue("qqcircle", "qqcircle_use_asset", Integer.valueOf(0)).intValue();
    if (RFLog.isColorLevel())
    {
      int j = RFLog.USR;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isUseAssetPlugin always:");
      ((StringBuilder)localObject).append(i);
      RFLog.e("QCircleConfigHelper", j, ((StringBuilder)localObject).toString());
    }
    if (i == 1) {
      bool = true;
    }
    return bool;
  }
  
  public static int b()
  {
    return a().getConfigValue("qqcircle", "quality_quality_report_buffer_length", Integer.valueOf(5)).intValue();
  }
  
  public static long b()
  {
    return a().getConfigValue("qqcircle", "qqcircle_quality_report_interval", Integer.valueOf(60)).intValue();
  }
  
  public static boolean b()
  {
    IConfigDelegate localIConfigDelegate = a();
    boolean bool = false;
    if (localIConfigDelegate.getConfigValue("qqcircle", "qqcircle_is_alpha_user", Integer.valueOf(0)).intValue() == 1) {
      bool = true;
    }
    return bool;
  }
  
  public static int c()
  {
    int i = a().getConfigValue("qqcircle", "qqcricle_max_crash_count", Integer.valueOf(2)).intValue();
    if (RFLog.isColorLevel())
    {
      int j = RFLog.USR;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SECONDARY_QQCIRCLE_DISABLE_PLUGIN:");
      localStringBuilder.append(i);
      RFLog.e("QCircleConfigHelper", j, localStringBuilder.toString());
    }
    return i;
  }
  
  public static long c()
  {
    return a().getConfigValue("qqcircle", "qqcircle_getplugininfo_time", Integer.valueOf(300000)).intValue();
  }
  
  public static boolean c()
  {
    return a().getConfigValue("qqcircle", "qqcircle_quality_sample_switch", Integer.valueOf(1)).intValue() == 1;
  }
  
  public static int d()
  {
    Object localObject = a().getConfigValue("qqcircle", "secondary_key_get_devices_for_maxduration", "");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((String)localObject).split(",");
      int i = 0;
      while (i < localObject.length)
      {
        if (Build.MODEL.toLowerCase().equals(localObject[i].toLowerCase())) {
          return 60000;
        }
        i += 1;
      }
    }
    return a().getConfigValue("qqcircle", "secondary_key_get_max_video_duration", Integer.valueOf(180000)).intValue();
  }
  
  public static boolean d()
  {
    IConfigDelegate localIConfigDelegate = a();
    boolean bool = false;
    if (localIConfigDelegate.getConfigValue("qqcircle", "qqcircle_report_outbox_switch", Integer.valueOf(0)).intValue() == 0) {
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qcircle.cooperation.config.QCircleConfigHelper
 * JD-Core Version:    0.7.0.1
 */