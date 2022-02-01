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
    int i = isNeedPreparseDns;
    boolean bool = false;
    if (i == 0) {
      return false;
    }
    long l = getDnsPreParseTimeMills(paramString).longValue();
    if ((l == 0L) || (System.currentTimeMillis() - l > 600000L)) {
      bool = true;
    }
    return bool;
  }
  
  private static void reportTimeUsed(String paramString, long paramLong)
  {
    try
    {
      i = NetworkUtil.getSystemNetwork(null);
    }
    catch (Exception localException)
    {
      int i;
      label8:
      Object localObject;
      break label8;
    }
    i = 0;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4) {
            localObject = "";
          } else {
            localObject = "4G";
          }
        }
        else {
          localObject = "3G";
        }
      }
      else {
        localObject = "2G";
      }
    }
    else {
      localObject = "wifi";
    }
    try
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("net_state", localObject);
      localHashMap.put("current_url", paramString);
      localHashMap.put("time_used", String.valueOf(paramLong));
      paramString = MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount();
      StatisticCollector.getInstance(MobileQQ.getContext()).collectPerformance(paramString, "dns_parse_time", true, paramLong, 1L, localHashMap, "", false);
      return;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("report dns parse time error=");
        ((StringBuilder)localObject).append(paramString.toString());
        QLog.i("WebProcessStartServiceImpl", 2, ((StringBuilder)localObject).toString());
      }
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
    SharedPreferences localSharedPreferences = MobileQQ.getContext().getSharedPreferences("web_process_preload_file", 4);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_business_click_time");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString2);
    return localSharedPreferences.getLong(localStringBuilder.toString(), -1L);
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Web module is exist: ");
      localStringBuilder.append(bool);
      QLog.d("WebProcessStartServiceImpl", 2, localStringBuilder.toString());
    }
    return bool;
  }
  
  public void preParseDns(List<String> paramList, String paramString)
  {
    if (!isDnsParseTime(paramString)) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("begin to parse dns,isNeedPreparseDns = ");
      localStringBuilder.append(isNeedPreparseDns);
      QLog.d("WebProcessStartServiceImpl", 2, localStringBuilder.toString());
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
      Object localObject = MobileQQ.getContext().getSharedPreferences("CrashControl_com.tencent.mobileqq:web", 4);
      if ((localObject != null) && (!((SharedPreferences)localObject).getBoolean("allowpreload", true)))
      {
        long l1 = ((SharedPreferences)localObject).getLong("starttime", 0L);
        int i = ((SharedPreferences)localObject).getInt("controlwindow", 86400);
        long l2 = System.currentTimeMillis();
        if ((l1 > 0L) && (i > 0) && (l2 > l1) && (l2 - l1 > i * 1000))
        {
          ((SharedPreferences)localObject).edit().putBoolean("allowpreload", true).commit();
        }
        else
        {
          QLog.d("WebProcessStartServiceImpl", 1, "preloadWebProcess is not allowed as crash frequently.");
          setPreloadWebProcess(false);
          localObject = MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount();
          StatisticCollector.getInstance(MobileQQ.getContext()).collectPerformance((String)localObject, "actNoPreloadWeb", true, 0L, 0L, null, "");
          return;
        }
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      Intent localIntent = new Intent();
      localIntent.putExtra("from", paramInt);
      localIntent.setAction("com.tencent.mobileqq.webprocess.preload_web_process");
      localIntent.setPackage(MobileQQ.getContext().getPackageName());
      localIntent.putExtra("com.tencent.mobileqq.webprocess.start_time", System.currentTimeMillis());
      MobileQQ.getContext().sendBroadcast(localIntent, "com.tencent.msg.permission.pushnotify");
      if (QLog.isColorLevel()) {
        QLog.d("WebProcessStartServiceImpl", 2, "Send preload web process broadcast...");
      }
    }
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
    SharedPreferences.Editor localEditor = MobileQQ.getContext().getSharedPreferences("web_process_preload_file", 4).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_business_click_time");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString2);
    localEditor.putLong(localStringBuilder.toString(), System.currentTimeMillis()).apply();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.api.impl.WebProcessPreloadImpl
 * JD-Core Version:    0.7.0.1
 */