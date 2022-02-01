package com.tencent.mobileqq.webview.api.impl;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.biz.common.util.Util;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.webview.api.IWebProcessPreload;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class WebProcessPreloadImpl
  implements IWebProcessPreload
{
  private static final String DNS_PROFILE = "dns_profile";
  private static final String TAG = "WebProcessStartServiceImpl";
  private static int isNeedPreparseDns = -1;
  private static final ConcurrentHashMap<String, Integer> webProcessBuffer = new ConcurrentHashMap();
  
  private Long getDnsPreParseTimeMills(String paramString)
  {
    return Long.valueOf(MobileQQ.getContext().getSharedPreferences("dns_profile", 0).getLong(paramString, 0L));
  }
  
  private boolean isDnsParseTime(String paramString)
  {
    if (isNeedPreparseDns == 0) {}
    long l;
    do
    {
      return false;
      l = getDnsPreParseTimeMills(paramString).longValue();
    } while ((l != 0L) && (System.currentTimeMillis() - l <= 600000L));
    return true;
  }
  
  private static void reportTimeUsed(String paramString, long paramLong)
  {
    int i = 0;
    try
    {
      int j = NetworkUtil.a(null);
      i = j;
    }
    catch (Exception localException)
    {
      label11:
      String str;
      break label11;
    }
    switch (i)
    {
    default: 
      str = "";
    }
    try
    {
      for (;;)
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("net_state", str);
        localHashMap.put("current_url", paramString);
        localHashMap.put("time_used", String.valueOf(paramLong));
        paramString = MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount();
        StatisticCollector.getInstance(MobileQQ.getContext()).collectPerformance(paramString, "dns_parse_time", true, paramLong, 1L, localHashMap, "", false);
        return;
        str = "2G";
        continue;
        str = "3G";
        continue;
        str = "4G";
        continue;
        str = "wifi";
      }
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("WebProcessStartServiceImpl", 2, "report dns parse time error=" + paramString.toString());
      return;
    }
  }
  
  private void setDnsPreParseTimeMills(String paramString, long paramLong)
  {
    MobileQQ.getContext().getSharedPreferences("dns_profile", 0).edit().putLong(paramString, paramLong).commit();
  }
  
  public static void setPreloadSuccess(boolean paramBoolean)
  {
    MobileQQ.getContext().getSharedPreferences("web_process_preload_file", 4).edit().putBoolean("key_preload", paramBoolean).commit();
  }
  
  public long getBusinessClickTimeMills(String paramString1, String paramString2)
  {
    return MobileQQ.getContext().getSharedPreferences("web_process_preload_file", 4).getLong("key_business_click_time" + paramString1 + "_" + paramString2, -1L);
  }
  
  public boolean isPreloadWebProcess()
  {
    return MobileQQ.getContext().getSharedPreferences("web_process_preload_file", 4).getBoolean("key_preload_web_process", false);
  }
  
  public boolean isWebProcessExist()
  {
    Util.a("Web_Module_Check_Is_Exit");
    boolean bool = QIPCServerHelper.getInstance().isModuleRunning("modular_web");
    Util.b("Web_Module_Check_Is_Exit");
    if (QLog.isColorLevel()) {
      QLog.d("WebProcessStartServiceImpl", 2, "Web module is exist: " + bool);
    }
    return bool;
  }
  
  public void preParseDns(List<String> paramList, String paramString)
  {
    if (!isDnsParseTime(paramString)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("WebProcessStartServiceImpl", 2, "begin to parse dns,isNeedPreparseDns = " + isNeedPreparseDns);
    }
    setDnsPreParseTimeMills(paramString, System.currentTimeMillis());
    ThreadManager.post(new WebProcessPreloadImpl.1(this, paramList), 5, null, true);
  }
  
  public void preloadWebProcess(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebProcessStartServiceImpl", 2, "preloadWebProcess");
    }
    try
    {
      setPreloadSuccess(false);
      localObject = MobileQQ.getContext().getSharedPreferences("CrashControl_com.tencent.mobileqq:web", 4);
      if ((localObject != null) && (!((SharedPreferences)localObject).getBoolean("allowpreload", true)))
      {
        long l1 = ((SharedPreferences)localObject).getLong("starttime", 0L);
        int i = ((SharedPreferences)localObject).getInt("controlwindow", 86400);
        long l2 = System.currentTimeMillis();
        if ((l1 <= 0L) || (i <= 0) || (l2 <= l1) || (l2 - l1 <= i * 1000)) {
          break label213;
        }
        ((SharedPreferences)localObject).edit().putBoolean("allowpreload", true).commit();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject;
        localException.printStackTrace();
      }
    }
    localObject = new Intent();
    ((Intent)localObject).putExtra("from", paramInt);
    ((Intent)localObject).setAction("com.tencent.mobileqq.webprocess.preload_web_process");
    ((Intent)localObject).setPackage(MobileQQ.getContext().getPackageName());
    ((Intent)localObject).putExtra("com.tencent.mobileqq.webprocess.start_time", System.currentTimeMillis());
    MobileQQ.getContext().sendBroadcast((Intent)localObject, "com.tencent.msg.permission.pushnotify");
    if (QLog.isColorLevel()) {
      QLog.d("WebProcessStartServiceImpl", 2, "Send preload web process broadcast...");
    }
    return;
    label213:
    QLog.d("WebProcessStartServiceImpl", 1, "preloadWebProcess is not allowed as crash frequently.");
    setPreloadWebProcess(false);
    localObject = MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount();
    StatisticCollector.getInstance(MobileQQ.getContext()).collectPerformance((String)localObject, "actNoPreloadWeb", true, 0L, 0L, null, "");
  }
  
  public void releaseLightWebProcess()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebProcessStartServiceImpl", 2, "releaseHalfToolProcess, send release tool process broadcast!");
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.mobileqq.webprocess.release_tool_process");
    localIntent.setPackage(MobileQQ.getContext().getPackageName());
    MobileQQ.getContext().sendBroadcast(localIntent, "com.tencent.msg.permission.pushnotify");
  }
  
  public void setBusinessClickTimeMills(String paramString1, String paramString2)
  {
    MobileQQ.getContext().getSharedPreferences("web_process_preload_file", 4).edit().putLong("key_business_click_time" + paramString1 + "_" + paramString2, System.currentTimeMillis()).apply();
  }
  
  public void setPreloadWebProcess(boolean paramBoolean)
  {
    MobileQQ.getContext().getSharedPreferences("web_process_preload_file", 4).edit().putBoolean("key_preload_web_process", paramBoolean).commit();
  }
  
  public void stopWebCoreService()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebProcessStartServiceImpl", 2, "stop web core service");
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.mobileqq.webprocess.stop_web_core_service");
    localIntent.setPackage(MobileQQ.getContext().getPackageName());
    MobileQQ.getContext().sendBroadcast(localIntent, "com.tencent.msg.permission.pushnotify");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.webview.api.impl.WebProcessPreloadImpl
 * JD-Core Version:    0.7.0.1
 */