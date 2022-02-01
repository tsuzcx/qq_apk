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
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Date;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class QQCrashControlManager
{
  static SimpleDateFormat a = new SimpleDateFormat("MM.dd HH:mm:ss.SSS");
  private static QQCrashControlManager g;
  boolean b = false;
  boolean c = true;
  int d = 1;
  int e = 86400;
  int f = 5;
  
  public static QQCrashControlManager b()
  {
    if (g == null) {
      try
      {
        if (g == null) {
          g = new QQCrashControlManager();
        }
      }
      finally {}
    }
    return g;
  }
  
  public static void f()
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
  
  private boolean g()
  {
    int i;
    if (Build.VERSION.SDK_INT == 27) {
      i = 1;
    } else {
      i = 0;
    }
    return (i != 0) && (Build.MODEL.contains("OPPO R11"));
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
    return this.b;
  }
  
  void b(String paramString)
  {
    if (!this.c)
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
      localStringBuilder = QQCrashReportManager.m;
      localStringBuilder.append("updatePreloadCrashData process=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",startTime=");
      localStringBuilder.append(a.format(new Date(l1)));
      localStringBuilder.append(",currenttime=");
      localStringBuilder.append(a.format(new Date(l2)));
      localStringBuilder.append(",crashCount=");
      localStringBuilder.append(i);
      localStringBuilder.append(",allowPreload=");
      localStringBuilder.append(bool);
      localStringBuilder.append(",mCurUin=");
      localStringBuilder.append(QQCrashReportManager.a);
      localStringBuilder.append("\n");
      if ((l1 > 0L) && (l2 > l1) && (i >= 0) && (l2 - l1 <= this.e * 1000))
      {
        i += 1;
      }
      else
      {
        i = 1;
        l1 = l2;
      }
      bool = true;
      if (i > this.f) {
        bool = false;
      }
      QQCrashReportManager.a();
      paramString = QQCrashReportManager.m;
      paramString.append("updatePreloadCrashData update allowPreload=");
      paramString.append(bool);
      paramString.append("\n");
      ((SharedPreferences)localObject).edit().putLong("starttime", l1).putInt("crashcount", i).putBoolean("allowpreload", bool).putInt("controlwindow", this.e).commit();
    }
  }
  
  public void c()
  {
    this.c = true;
    this.d = 1;
    this.e = 86400;
    this.f = 5;
  }
  
  void d()
  {
    String str = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValueWithoutAccountManager(DPCNames.crash_control.name(), null);
    if (!TextUtils.isEmpty(str)) {}
    try
    {
      localObject = new JSONObject(str);
      this.c = ((JSONObject)localObject).getBoolean("control_switch");
      this.d = ((JSONObject)localObject).getInt("control_level");
      this.e = ((JSONObject)localObject).getInt("control_window");
      this.f = ((JSONObject)localObject).getInt("control_freq");
    }
    catch (Throwable localThrowable)
    {
      Object localObject;
      label85:
      break label85;
    }
    c();
    QLog.d("QQCrashControlManager", 1, "initCrashControl parse json throws an exception, so reset.");
    QQCrashReportManager.a();
    localObject = QQCrashReportManager.m;
    ((StringBuilder)localObject).append("initCrashControl");
    ((StringBuilder)localObject).append(",controlJson=");
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append(",switch=");
    ((StringBuilder)localObject).append(this.c);
    ((StringBuilder)localObject).append(",level=");
    ((StringBuilder)localObject).append(this.d);
    ((StringBuilder)localObject).append(",window=");
    ((StringBuilder)localObject).append(this.e);
    ((StringBuilder)localObject).append(",Freq=");
    ((StringBuilder)localObject).append(this.f);
    QQCrashReportManager.a();
    QQCrashReportManager.m.append("\n");
  }
  
  void e()
  {
    if (!this.c)
    {
      QLog.d("QQCrashControlManager", 1, "updateLocalCrashData crash control is off..");
      return;
    }
    Object localObject = MobileQQ.sMobileQQ.startComponentInfo;
    if ((this.d == 2) && ((TextUtils.isEmpty((CharSequence)localObject)) || (!((String)localObject).contains("QQBroadcastReceiver"))))
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
      StringBuilder localStringBuilder = QQCrashReportManager.m;
      localStringBuilder.append("updateLocalCrashData startTime=");
      localStringBuilder.append(a.format(new Date(l1)));
      localStringBuilder.append(",currenttime=");
      localStringBuilder.append(a.format(new Date(l2)));
      localStringBuilder.append(",crashCount=");
      localStringBuilder.append(i);
      localStringBuilder.append(",mCurUin=");
      localStringBuilder.append(QQCrashReportManager.a);
      localStringBuilder.append("\n");
      if ((l1 > 0L) && (l2 > l1) && (i >= 0) && (l2 - l1 <= this.e * 1000))
      {
        int k = i + 1;
        i = j;
        if (QQCrashReportManager.k != null)
        {
          i = j;
          if (QQCrashReportManager.k.contains("natmem")) {
            i = j + 1;
          }
        }
        j = k;
      }
      else
      {
        i = j;
        if (QQCrashReportManager.k != null)
        {
          i = j;
          if (QQCrashReportManager.k.contains("natmem")) {
            i = 1;
          }
        }
        j = 1;
        l1 = l2;
      }
      if (j > this.f)
      {
        this.b = true;
        if (g()) {
          ((SharedPreferences)localObject).edit().putBoolean("crashFrequentLast", true).commit();
        }
      }
      QQCrashReportManager.a();
      localStringBuilder = QQCrashReportManager.m;
      localStringBuilder.append("updateLocalCrashData shouldStopMsf=");
      localStringBuilder.append(this.b);
      localStringBuilder.append("\n");
      ((SharedPreferences)localObject).edit().putLong("starttime", l1).putInt("crashcount", j).putInt("natmem_crashcount", i).putBoolean("shouldStopMsf", this.b).commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqperf.monitor.crash.QQCrashControlManager
 * JD-Core Version:    0.7.0.1
 */