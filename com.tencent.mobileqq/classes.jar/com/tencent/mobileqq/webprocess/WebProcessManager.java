package com.tencent.mobileqq.webprocess;

import ajxl;
import ajxm;
import ajxn;
import ajxo;
import ajxp;
import ajxq;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import com.tencent.biz.common.util.Util;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BabyQObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SecMsgUtil;
import com.tencent.mobileqq.utils.SharedPreferencesHandler;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.webview.sonic.SonicPreloader;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.manager.Manager;

public class WebProcessManager
  implements Manager
{
  private static int jdField_a_of_type_Int = -1;
  public static HashMap a;
  public static final ConcurrentHashMap a;
  protected static boolean b;
  protected long a;
  protected BroadcastReceiver a;
  private final BabyQObserver jdField_a_of_type_ComTencentMobileqqAppBabyQObserver = new ajxo(this);
  protected QQAppInterface a;
  protected boolean a;
  private final BroadcastReceiver b;
  private boolean c;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public WebProcessManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new ajxm(this);
    this.jdField_b_of_type_AndroidContentBroadcastReceiver = new ajxn(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    a();
    c();
    this.jdField_a_of_type_Long = (DeviceInfoUtil.e() / 1048576L);
  }
  
  public static long a(String paramString)
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("health_dns_profile", SecMsgUtil.a()).getLong(paramString, -1L);
  }
  
  public static long a(String paramString1, String paramString2)
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("business_click_profile", SecMsgUtil.a()).getLong(paramString1 + "_" + paramString2, -1L);
  }
  
  private static Long a(String paramString)
  {
    return Long.valueOf(BaseApplicationImpl.getApplication().getSharedPreferences("dns_profile", 0).getLong(paramString, 0L));
  }
  
  public static void a(String paramString, long paramLong)
  {
    int i = SecMsgUtil.a();
    BaseApplicationImpl.getApplication().getSharedPreferences("health_dns_profile", i).edit().putLong(paramString, paramLong).commit();
  }
  
  public static void a(String paramString1, String paramString2)
  {
    BaseApplicationImpl.getApplication().getSharedPreferences("business_click_profile", SecMsgUtil.a()).edit().putLong(paramString1 + "_" + paramString2, System.currentTimeMillis()).commit();
  }
  
  public static void a(List paramList, String paramString)
  {
    if (!b(paramString)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("WebProcessManager", 2, "begin to parse dns,isNeedPreparseDns = " + jdField_a_of_type_Int);
    }
    e(paramString, System.currentTimeMillis());
    ThreadManager.post(new ajxp(paramList), 5, null, true);
  }
  
  public static void a(boolean paramBoolean)
  {
    BaseApplicationImpl.getApplication().getSharedPreferences("web_process_preload_file", 4).edit().putBoolean("key_preload", paramBoolean).commit();
  }
  
  public static boolean a()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("web_process_preload_file", 4).getBoolean("key_preload", false);
  }
  
  public static long b(String paramString)
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("vip_dns_profile", SecMsgUtil.a()).getLong(paramString, -1L);
  }
  
  public static void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebProcessManager", 2, "preloadWebProcess");
    }
    try
    {
      localObject = BaseApplicationImpl.getApplication().getSharedPreferences("CrashControl_com.tencent.mobileqq:web", 4);
      if ((localObject != null) && (!((SharedPreferences)localObject).getBoolean("allowpreload", true)))
      {
        long l1 = ((SharedPreferences)localObject).getLong("starttime", 0L);
        int i = ((SharedPreferences)localObject).getInt("controlwindow", 86400);
        long l2 = System.currentTimeMillis();
        if ((l1 <= 0L) || (i <= 0) || (l2 <= l1) || (l2 - l1 <= i * 1000)) {
          break label185;
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
    ((Intent)localObject).putExtra("com.tencent.mobileqq.webprocess.start_time", System.currentTimeMillis());
    BaseApplicationImpl.getContext().sendBroadcast((Intent)localObject, "com.tencent.msg.permission.pushnotify");
    if (QLog.isColorLevel()) {
      QLog.d("WebProcessManager", 2, "Send preload web process broadcast...");
    }
    return;
    label185:
    QLog.d("WebProcessManager", 1, "preloadWebProcess is not allowed as crash frequently.");
    b(false);
    StatisticCollector.a(BaseApplicationImpl.getContext()).a(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "actNoPreloadWeb", true, 0L, 0L, null, "");
  }
  
  public static void b(String paramString, long paramLong)
  {
    BaseApplicationImpl.getApplication().getSharedPreferences("vip_dns_profile", SecMsgUtil.a()).edit().putLong(paramString, paramLong).commit();
  }
  
  public static void b(boolean paramBoolean)
  {
    BaseApplicationImpl.getApplication().getSharedPreferences("web_process_preload_file", 4).edit().putBoolean("key_preload_web_process", paramBoolean).commit();
  }
  
  public static boolean b()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("web_process_preload_file", 4).getBoolean("key_preload_web_process", false);
  }
  
  public static boolean b(String paramString)
  {
    if (jdField_a_of_type_Int == 0) {}
    long l;
    do
    {
      return false;
      l = a(paramString).longValue();
    } while ((l != 0L) && (System.currentTimeMillis() - l <= 600000L));
    return true;
  }
  
  public static long c(String paramString)
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("vip_gamecenter_profile", SecMsgUtil.a()).getLong(paramString, -1L);
  }
  
  public static void c(String paramString, long paramLong)
  {
    BaseApplicationImpl.getApplication().getSharedPreferences("vip_gamecenter_profile", SecMsgUtil.a()).edit().putLong(paramString, paramLong).commit();
  }
  
  public static void c(boolean paramBoolean)
  {
    jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public static boolean c()
  {
    Util.a("Web_Module_Check_Is_Exit");
    boolean bool = QIPCServerHelper.getInstance().isModuleRunning("modular_web");
    Util.b("Web_Module_Check_Is_Exit");
    if (QLog.isColorLevel()) {
      QLog.d("WebProcessManager", 2, "Web module is exist: " + bool);
    }
    return bool;
  }
  
  private static void e(String paramString, long paramLong)
  {
    BaseApplicationImpl.getApplication().getSharedPreferences("dns_profile", 0).edit().putLong(paramString, paramLong).commit();
  }
  
  private static void f(String paramString, long paramLong)
  {
    int i = 0;
    try
    {
      int j = NetworkUtil.a(BaseApplicationImpl.getApplication());
      i = j;
    }
    catch (Exception localException)
    {
      label13:
      String str;
      break label13;
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
        StatisticCollector.a(BaseApplicationImpl.getContext()).a(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "dns_parse_time", true, paramLong, 1L, localHashMap, "", false);
        VasWebviewUtil.reportVasStatus("dns_parse_time", "", paramString, 0, 0, (int)paramLong, 0, str, "");
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
      QLog.i("WebProcessManager", 2, "report dns parse time error=" + paramString.toString());
      return;
    }
  }
  
  public static void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebProcessManager", 2, "stop web core service");
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.mobileqq.webprocess.stop_web_core_service");
    BaseApplicationImpl.getContext().sendBroadcast(localIntent, "com.tencent.msg.permission.pushnotify");
  }
  
  public static void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebProcessManager", 2, "releaseHalfToolProcess, send release tool process broadcast!");
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.mobileqq.webprocess.release_tool_process");
    BaseApplicationImpl.getContext().sendBroadcast(localIntent, "com.tencent.msg.permission.pushnotify");
  }
  
  public void a()
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    jdField_a_of_type_JavaUtilHashMap.clear();
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("web_process_preload_file", 4);
    Object localObject = SharedPreferencesHandler.a(localSharedPreferences, "key_web_plugin_list" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), null);
    if ((localObject != null) && (!((Set)localObject).isEmpty()))
    {
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        jdField_a_of_type_JavaUtilHashMap.put(str, str);
      }
    }
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put("key_preload_strategy", Integer.valueOf(localSharedPreferences.getInt("key_preload_strategy" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 1)));
    localObject = jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
    if (localSharedPreferences.getBoolean("key_preload_flag" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false)) {}
    for (int i = 1;; i = 0)
    {
      ((ConcurrentHashMap)localObject).put("key_preload_flag", Integer.valueOf(i));
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put("key_red_ram", Integer.valueOf(localSharedPreferences.getInt("key_red_ram" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 512)));
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put("key_click_ram", Integer.valueOf(localSharedPreferences.getInt("key_click_ram" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 1024)));
      return;
    }
  }
  
  public void a(int paramInt)
  {
    a(paramInt, null);
  }
  
  public void a(int paramInt, WebProcessManager.WebProcessStartListener paramWebProcessStartListener)
  {
    ThreadManager.post(new ajxq(paramInt, paramWebProcessStartListener), 5, null, false);
  }
  
  public boolean a(String paramString)
  {
    boolean bool1;
    if (jdField_a_of_type_JavaUtilHashMap.isEmpty())
    {
      Object localObject = SharedPreferencesHandler.a(BaseApplicationImpl.getApplication().getSharedPreferences("web_process_preload_file", 4), "key_web_plugin_list" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), null);
      boolean bool2 = false;
      bool1 = bool2;
      if (localObject == null) {
        break label137;
      }
      bool1 = bool2;
      if (((Set)localObject).isEmpty()) {
        break label137;
      }
      localObject = ((Set)localObject).iterator();
      bool1 = false;
      if (!((Iterator)localObject).hasNext()) {
        return bool1;
      }
      String str = (String)((Iterator)localObject).next();
      jdField_a_of_type_JavaUtilHashMap.put(str, str);
      if (!str.equals(paramString)) {
        break label139;
      }
      bool1 = true;
    }
    label137:
    label139:
    for (;;)
    {
      break;
      bool1 = jdField_a_of_type_JavaUtilHashMap.containsKey(paramString);
      return bool1;
    }
    return bool1;
  }
  
  public boolean a(ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() < 1)) {}
    do
    {
      do
      {
        return false;
      } while (!SonicPreloader.a());
      if (c())
      {
        Intent localIntent = new Intent(BaseApplicationImpl.getApplication(), WebProcessReceiver.class);
        localIntent.setAction("action_preload_sonic_session");
        localIntent.putParcelableArrayListExtra("com.tencent.mobileqq.webprocess.sonic_preload_data", paramArrayList);
        try
        {
          BaseApplicationImpl.getApplication().sendBroadcast(localIntent, "com.tencent.msg.permission.pushnotify");
          return true;
        }
        catch (Exception paramArrayList)
        {
          QLog.e("WebProcessManager", 2, "preloadSonicSession, sendBroadcast exception, e = ", paramArrayList);
          return false;
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("WebProcessManager", 2, "preloadSonicSession, web process not exists");
    return false;
  }
  
  public void b()
  {
    if ((jdField_b_of_type_Boolean) && (d())) {
      e();
    }
  }
  
  protected void c()
  {
    if ((this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) && (!this.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_Boolean = true;
    }
    try
    {
      localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.tencent.mobileqq.webprocess.restart_web_process");
      localIntentFilter.addAction("com.tencent.mobileqq.webprocess.report");
      BaseApplicationImpl.getContext().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      if (!this.c) {
        this.c = true;
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          IntentFilter localIntentFilter = new IntentFilter();
          localIntentFilter.addAction("com.tencent.mobileqq.babyq.add");
          BaseApplicationImpl.getContext().registerReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppBabyQObserver);
          return;
        }
        catch (Exception localException2) {}
        localException1 = localException1;
        localException1.printStackTrace();
      }
    }
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) && (this.jdField_a_of_type_Boolean)) {}
    try
    {
      this.jdField_a_of_type_Boolean = false;
      BaseApplicationImpl.getContext().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      if (!this.c) {}
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          this.c = false;
          BaseApplicationImpl.getContext().unregisterReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppBabyQObserver);
          return;
        }
        catch (Exception localException2) {}
        localException1 = localException1;
        localException1.printStackTrace();
      }
    }
  }
  
  public boolean d()
  {
    Integer localInteger = (Integer)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get("key_preload_strategy");
    if ((localInteger != null) && (localInteger.intValue() == 2))
    {
      localInteger = (Integer)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get("key_preload_flag");
      if ((localInteger != null) && (localInteger.intValue() == 1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("WebProcessManager", 2, "is need prload, totalMemSize = " + this.jdField_a_of_type_Long + "M");
        }
        localInteger = (Integer)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get("key_red_ram");
        if ((localInteger != null) && (this.jdField_a_of_type_Long > localInteger.intValue())) {
          return true;
        }
      }
      else
      {
        return false;
      }
    }
    else
    {
      return f();
    }
    return false;
  }
  
  public void e()
  {
    a(-1);
  }
  
  public boolean e()
  {
    Integer[] arrayOfInteger = WebAccelerateHelper.getInstance().getWebViewFeatureParams();
    if ((arrayOfInteger != null) && (arrayOfInteger[9].intValue() != 0))
    {
      if (QLog.isColorLevel()) {
        QLog.i("WebProcessManager", 2, "now enable preload tool process for public account!");
      }
      return true;
    }
    QLog.e("WebProcessManager", 1, "can not preload tool process for public account!");
    return false;
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebProcessManager", 2, "restartWebProcess");
    }
    new Handler().postDelayed(new ajxl(this), 800L);
  }
  
  protected boolean f()
  {
    return true;
  }
  
  public void i()
  {
    if (a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebProcessManager", 2, "isPreloadSucess");
      }
      ReportController.b(null, "P_CliOper", "Vip", "", "0X8004874", "0X8004874", 0, 1, 0, "", "", "", "");
    }
    for (;;)
    {
      a(false);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("WebProcessManager", 2, "isPreloadFail");
      }
      ReportController.b(null, "P_CliOper", "Vip", "", "0X8004875", "0X8004875", 0, 1, 0, "", "", "", "");
    }
  }
  
  public void onDestroy()
  {
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.webprocess.WebProcessManager
 * JD-Core Version:    0.7.0.1
 */