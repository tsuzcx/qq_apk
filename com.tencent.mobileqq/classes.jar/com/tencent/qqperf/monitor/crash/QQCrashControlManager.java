package com.tencent.qqperf.monitor.crash;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.natmem.NatMemAPI;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Date;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class QQCrashControlManager
{
  private static QQCrashControlManager jdField_a_of_type_ComTencentQqperfMonitorCrashQQCrashControlManager;
  static SimpleDateFormat jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("MM.dd HH:mm:ss.SSS");
  int jdField_a_of_type_Int = 1;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = 86400;
  boolean jdField_b_of_type_Boolean = true;
  int c = 5;
  
  public static QQCrashControlManager a()
  {
    if (jdField_a_of_type_ComTencentQqperfMonitorCrashQQCrashControlManager == null) {
      try
      {
        if (jdField_a_of_type_ComTencentQqperfMonitorCrashQQCrashControlManager == null) {
          jdField_a_of_type_ComTencentQqperfMonitorCrashQQCrashControlManager = new QQCrashControlManager();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentQqperfMonitorCrashQQCrashControlManager;
  }
  
  private boolean b()
  {
    int i;
    if (Build.VERSION.SDK_INT == 27) {
      i = 1;
    } else {
      i = 0;
    }
    return (i != 0) && (Build.MODEL.contains("OPPO R11"));
  }
  
  public static void d()
  {
    if (MobileQQ.processName.equals("com.tencent.mobileqq")) {
      try
      {
        SharedPreferences localSharedPreferences = MobileQQ.getContext().getSharedPreferences("not_restart_control_file", 4);
        boolean bool = localSharedPreferences.getBoolean("allowAutoRestart", true);
        int i = localSharedPreferences.getInt("key_not_restart_delay_mill", 100);
        if (!bool)
        {
          ThreadManager.getSubThreadHandler().postDelayed(new QQCrashControlManager.2(localSharedPreferences), i);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("QQCrashControlManager", 1, "checkAutoRestart error", localThrowable);
      }
    }
  }
  
  public void a()
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 1;
    this.jdField_b_of_type_Int = 86400;
    this.c = 5;
  }
  
  public void a(String paramString)
  {
    ThreadManager.getSubThreadHandler().postDelayed(new QQCrashControlManager.1(this, paramString), 3000L);
  }
  
  void a(String paramString1, String paramString2)
  {
    long l1;
    int k;
    int j;
    boolean bool3;
    boolean bool1;
    boolean bool2;
    int i;
    long l2;
    try
    {
      localSharedPreferences = MobileQQ.sMobileQQ.getSharedPreferences("not_restart_control_file", 4);
      if ((localSharedPreferences == null) || (paramString1 == null) || (paramString2 == null)) {
        break label283;
      }
      l1 = localSharedPreferences.getLong("starttime", 0L);
      k = localSharedPreferences.getInt("crashcount", 0);
      j = localSharedPreferences.getInt("key_not_restart_max_crash", 2147483647);
      bool3 = localSharedPreferences.getBoolean("key_not_restart_enable", false);
      String str1 = localSharedPreferences.getString("key_not_restart_crash_type", "notValid");
      String str2 = localSharedPreferences.getString("key_not_restart_crash_stack", "notValid");
      if (paramString1.isEmpty()) {
        bool1 = false;
      } else {
        bool1 = paramString1.equalsIgnoreCase(str1);
      }
      if (paramString2.isEmpty()) {
        bool2 = false;
      } else {
        bool2 = paramString2.contains(str2);
      }
    }
    catch (Throwable paramString1)
    {
      SharedPreferences localSharedPreferences;
      QLog.e("QQCrashControlManager", 1, "updateNotRestartData error", paramString1);
    }
    if (i != 0)
    {
      l2 = System.currentTimeMillis();
      if ((l1 <= 0L) || (l2 <= l1) || (k < 0)) {
        break label317;
      }
      if (l2 - l1 <= 86400000L) {
        break label309;
      }
      break label317;
    }
    for (;;)
    {
      paramString1 = new StringBuilder();
      paramString1.append("crashCount = ");
      paramString1.append(i);
      paramString1.append(",allowAutoRestart = ");
      paramString1.append(bool1);
      QLog.e("QQCrashControlManager", 1, paramString1.toString());
      localSharedPreferences.edit().putLong("starttime", l1).putInt("crashcount", i).putBoolean("allowAutoRestart", bool1).commit();
      return;
      label283:
      return;
      if ((bool3) && (bool1) && (bool2))
      {
        i = 1;
        break;
      }
      i = 0;
      break;
      label309:
      i = k + 1;
      break label323;
      label317:
      i = 1;
      l1 = l2;
      label323:
      if (i > j) {
        bool1 = false;
      } else {
        bool1 = true;
      }
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  void b()
  {
    String str = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValueWithoutAccountManager(DPCNames.crash_control.name(), null);
    if (!TextUtils.isEmpty(str)) {}
    try
    {
      localObject = new JSONObject(str);
      this.jdField_b_of_type_Boolean = ((JSONObject)localObject).getBoolean("control_switch");
      this.jdField_a_of_type_Int = ((JSONObject)localObject).getInt("control_level");
      this.jdField_b_of_type_Int = ((JSONObject)localObject).getInt("control_window");
      this.c = ((JSONObject)localObject).getInt("control_freq");
    }
    catch (Throwable localThrowable)
    {
      Object localObject;
      label84:
      break label84;
    }
    a();
    QLog.d("QQCrashControlManager", 1, "initCrashControl parse json throws an exception, so reset.");
    QQCrashReportManager.a();
    localObject = QQCrashReportManager.jdField_a_of_type_JavaLangStringBuilder;
    ((StringBuilder)localObject).append("initCrashControl");
    ((StringBuilder)localObject).append(",controlJson=");
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append(",switch=");
    ((StringBuilder)localObject).append(this.jdField_b_of_type_Boolean);
    ((StringBuilder)localObject).append(",level=");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
    ((StringBuilder)localObject).append(",window=");
    ((StringBuilder)localObject).append(this.jdField_b_of_type_Int);
    ((StringBuilder)localObject).append(",Freq=");
    ((StringBuilder)localObject).append(this.c);
    QQCrashReportManager.a();
    QQCrashReportManager.jdField_a_of_type_JavaLangStringBuilder.append("\n");
  }
  
  void b(String paramString)
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      QLog.d("QQCrashControlManager", 1, "updatePreloadCrashData crash control is off..");
      return;
    }
    Object localObject = MobileQQ.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CrashControl_");
    localStringBuilder.append(paramString);
    localObject = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 4);
    if (localObject != null)
    {
      long l1 = ((SharedPreferences)localObject).getLong("starttime", 0L);
      int i = ((SharedPreferences)localObject).getInt("crashcount", 0);
      boolean bool = ((SharedPreferences)localObject).getBoolean("allowpreload", true);
      long l2 = System.currentTimeMillis();
      QQCrashReportManager.a();
      localStringBuilder = QQCrashReportManager.jdField_a_of_type_JavaLangStringBuilder;
      localStringBuilder.append("updatePreloadCrashData process=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",startTime=");
      localStringBuilder.append(jdField_a_of_type_JavaTextSimpleDateFormat.format(new Date(l1)));
      localStringBuilder.append(",currenttime=");
      localStringBuilder.append(jdField_a_of_type_JavaTextSimpleDateFormat.format(new Date(l2)));
      localStringBuilder.append(",crashCount=");
      localStringBuilder.append(i);
      localStringBuilder.append(",allowPreload=");
      localStringBuilder.append(bool);
      localStringBuilder.append(",mCurUin=");
      localStringBuilder.append(QQCrashReportManager.jdField_a_of_type_JavaLangString);
      localStringBuilder.append("\n");
      if ((l1 > 0L) && (l2 > l1) && (i >= 0) && (l2 - l1 <= this.jdField_b_of_type_Int * 1000))
      {
        i += 1;
      }
      else
      {
        i = 1;
        l1 = l2;
      }
      bool = true;
      if (i > this.c) {
        bool = false;
      }
      QQCrashReportManager.a();
      paramString = QQCrashReportManager.jdField_a_of_type_JavaLangStringBuilder;
      paramString.append("updatePreloadCrashData update allowPreload=");
      paramString.append(bool);
      paramString.append("\n");
      ((SharedPreferences)localObject).edit().putLong("starttime", l1).putInt("crashcount", i).putBoolean("allowpreload", bool).putInt("controlwindow", this.jdField_b_of_type_Int).commit();
    }
  }
  
  void c()
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      QLog.d("QQCrashControlManager", 1, "updateLocalCrashData crash control is off..");
      return;
    }
    Object localObject = MobileQQ.sMobileQQ.startComponentInfo;
    if ((this.jdField_a_of_type_Int == 2) && ((TextUtils.isEmpty((CharSequence)localObject)) || (!((String)localObject).contains("QQBroadcastReceiver"))))
    {
      QLog.d("QQCrashControlManager", 1, "updateLocalCrashData controllevel is 2 but not QQBroadcastReceiver start QQ.");
      return;
    }
    localObject = MobileQQ.sMobileQQ.getSharedPreferences("crashcontrol", 0);
    if (localObject != null)
    {
      long l1 = ((SharedPreferences)localObject).getLong("starttime", 0L);
      int i = ((SharedPreferences)localObject).getInt("crashcount", 0);
      int j = ((SharedPreferences)localObject).getInt("natmem_crashcount", 0);
      long l2 = System.currentTimeMillis();
      QQCrashReportManager.a();
      StringBuilder localStringBuilder = QQCrashReportManager.jdField_a_of_type_JavaLangStringBuilder;
      localStringBuilder.append("updateLocalCrashData startTime=");
      localStringBuilder.append(jdField_a_of_type_JavaTextSimpleDateFormat.format(new Date(l1)));
      localStringBuilder.append(",currenttime=");
      localStringBuilder.append(jdField_a_of_type_JavaTextSimpleDateFormat.format(new Date(l2)));
      localStringBuilder.append(",crashCount=");
      localStringBuilder.append(i);
      localStringBuilder.append(",mCurUin=");
      localStringBuilder.append(QQCrashReportManager.jdField_a_of_type_JavaLangString);
      localStringBuilder.append("\n");
      if ((l1 > 0L) && (l2 > l1) && (i >= 0) && (l2 - l1 <= this.jdField_b_of_type_Int * 1000))
      {
        int k = i + 1;
        i = j;
        if (QQCrashReportManager.d != null)
        {
          i = j;
          if (QQCrashReportManager.d.contains("natmem")) {
            i = j + 1;
          }
        }
        j = k;
      }
      else
      {
        i = j;
        if (QQCrashReportManager.d != null)
        {
          i = j;
          if (QQCrashReportManager.d.contains("natmem")) {
            i = 1;
          }
        }
        j = 1;
        l1 = l2;
      }
      if (j > this.c)
      {
        this.jdField_a_of_type_Boolean = true;
        if (b()) {
          ((SharedPreferences)localObject).edit().putBoolean("crashFrequentLast", true).commit();
        }
      }
      if (i > this.c)
      {
        NatMemAPI.b();
        QLog.d("QQCrashControlManager", 1, "disable natmemmonitor in QQ");
      }
      QQCrashReportManager.a();
      localStringBuilder = QQCrashReportManager.jdField_a_of_type_JavaLangStringBuilder;
      localStringBuilder.append("updateLocalCrashData shouldStopMsf=");
      localStringBuilder.append(this.jdField_a_of_type_Boolean);
      localStringBuilder.append("\n");
      ((SharedPreferences)localObject).edit().putLong("starttime", l1).putInt("crashcount", j).putInt("natmem_crashcount", i).putBoolean("shouldStopMsf", this.jdField_a_of_type_Boolean).commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqperf.monitor.crash.QQCrashControlManager
 * JD-Core Version:    0.7.0.1
 */