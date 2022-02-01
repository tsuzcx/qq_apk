package com.tencent.mobileqq.intervideo.huayang;

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
  public static Map<String, MonitorConfig> a = new HashMap();
  public int b;
  public int c;
  public int d;
  public int e;
  public int f;
  public int g;
  public int h;
  public int i;
  
  public static void a(Context paramContext, String paramString)
  {
    if (a.get(paramString) != null) {
      return;
    }
    paramContext = paramContext.getApplicationContext().getSharedPreferences("pre_huayang_plugin_new_start_mode", 4);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("pre_monitor");
    localStringBuilder.append(paramString);
    paramContext = paramContext.getString(localStringBuilder.toString(), null);
    if (paramContext != null) {
      a(paramString, paramContext);
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    if (a.get(paramString1) == null)
    {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      paramContext = paramContext.getApplicationContext().getSharedPreferences("pre_huayang_plugin_new_start_mode", 4).edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("pre_monitor");
      localStringBuilder.append(paramString1);
      paramContext.putString(localStringBuilder.toString(), paramString2).commit();
      a(paramString1, paramString2);
    }
  }
  
  private static void a(String paramString1, String paramString2)
  {
    try
    {
      Object localObject = new JSONObject(paramString2);
      paramString2 = new MonitorConfig();
      paramString2.b = ((JSONObject)localObject).optInt("startupId");
      paramString2.c = ((JSONObject)localObject).optInt("downloadSucId");
      paramString2.d = ((JSONObject)localObject).optInt("downloadFailId");
      paramString2.e = ((JSONObject)localObject).optInt("loadSucId");
      paramString2.f = ((JSONObject)localObject).optInt("loadFailId");
      paramString2.g = ((JSONObject)localObject).optInt("startSucId");
      paramString2.h = ((JSONObject)localObject).optInt("firstUserId");
      paramString2.i = ((JSONObject)localObject).optInt("exitId");
      a.put(paramString1, paramString2);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString1);
        ((StringBuilder)localObject).append(paramString2);
        QLog.d("MonitorConfig", 2, ((StringBuilder)localObject).toString());
        return;
      }
    }
    catch (Throwable paramString1)
    {
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder();
        paramString2.append("pareMonitorConfig exception :");
        paramString2.append(paramString1);
        QLog.d("MonitorConfig", 2, paramString2.toString());
      }
    }
  }
  
  public static void b(Context paramContext, String paramString)
  {
    if (a.get(paramString) != null)
    {
      Monitor.b(String.valueOf(((MonitorConfig)a.get(paramString)).b));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MonitorConfig", 2, "没有找到匹配的monitor离线配置文件，重新拉取一次");
    }
    Monitor.b("3235982");
    new Handler(Looper.getMainLooper()).postDelayed(new MonitorConfig.1(paramContext, paramString), 1500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.huayang.MonitorConfig
 * JD-Core Version:    0.7.0.1
 */