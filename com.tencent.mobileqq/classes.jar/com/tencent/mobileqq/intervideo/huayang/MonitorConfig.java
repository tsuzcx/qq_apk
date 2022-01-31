package com.tencent.mobileqq.intervideo.huayang;

import aecx;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class MonitorConfig
{
  public static Map a;
  public int a;
  public int b;
  public int c;
  public int d;
  public int e;
  public int f;
  public int g;
  public int h;
  
  static
  {
    jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  public static void a(Context paramContext, String paramString)
  {
    if (jdField_a_of_type_JavaUtilMap.get(paramString) != null) {}
    do
    {
      return;
      paramContext = paramContext.getApplicationContext().getSharedPreferences("pre_huayang_plugin_new_start_mode", 4).getString("pre_monitor" + paramString, null);
    } while (paramContext == null);
    a(paramString, paramContext);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    if ((jdField_a_of_type_JavaUtilMap.get(paramString1) != null) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    paramContext.getApplicationContext().getSharedPreferences("pre_huayang_plugin_new_start_mode", 4).edit().putString("pre_monitor" + paramString1, paramString2).commit();
    a(paramString1, paramString2);
  }
  
  private static void a(String paramString1, String paramString2)
  {
    try
    {
      paramString2 = new JSONObject(paramString2);
      MonitorConfig localMonitorConfig = new MonitorConfig();
      localMonitorConfig.jdField_a_of_type_Int = paramString2.optInt("startupId");
      localMonitorConfig.b = paramString2.optInt("downloadSucId");
      localMonitorConfig.c = paramString2.optInt("downloadFailId");
      localMonitorConfig.d = paramString2.optInt("loadSucId");
      localMonitorConfig.e = paramString2.optInt("loadFailId");
      localMonitorConfig.f = paramString2.optInt("startSucId");
      localMonitorConfig.g = paramString2.optInt("firstUserId");
      localMonitorConfig.h = paramString2.optInt("exitId");
      jdField_a_of_type_JavaUtilMap.put(paramString1, localMonitorConfig);
      if (QLog.isColorLevel()) {
        QLog.d("MonitorConfig", 2, paramString1 + localMonitorConfig);
      }
      return;
    }
    catch (Throwable paramString1)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("MonitorConfig", 2, "pareMonitorConfig exception :" + paramString1);
    }
  }
  
  public static void b(Context paramContext, String paramString)
  {
    if (jdField_a_of_type_JavaUtilMap.get(paramString) != null)
    {
      Monitor.b(String.valueOf(((MonitorConfig)jdField_a_of_type_JavaUtilMap.get(paramString)).jdField_a_of_type_Int));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MonitorConfig", 2, "没有找到匹配的monitor离线配置文件，重新拉取一次");
    }
    Monitor.b("3235982");
    new Handler(Looper.getMainLooper()).postDelayed(new aecx(paramContext, paramString), 1500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.huayang.MonitorConfig
 * JD-Core Version:    0.7.0.1
 */