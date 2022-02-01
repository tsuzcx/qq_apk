package com.tencent.mobileqq.statistics;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.utils.preference.PreferenceManager;
import com.tencent.mobileqq.activity.aio.AIOConfigData;
import com.tencent.mobileqq.activity.aio.AIOConfigManager;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.monitor.crash.catchedexception.CaughtExceptionReport;
import com.tencent.util.QQDeviceInfo;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class FightReporter
{
  public static boolean a = false;
  public static boolean b = false;
  public static boolean c = false;
  private static boolean d;
  
  public static void a()
  {
    if (Build.VERSION.SDK_INT > 28) {
      return;
    }
    if (!c)
    {
      if (!PreferenceManager.getDefaultGlobalPreference(BaseApplicationImpl.getContext()).getBoolean("saveIDA", false)) {
        d();
      }
      c = true;
    }
    if (b) {
      return;
    }
    Object localObject1 = AIOConfigManager.a;
    String str1;
    if ((localObject1 != null) && (((AIOConfigData)localObject1).f == 1))
    {
      b = true;
      localObject1 = PreferenceManager.getDefaultGlobalPreference(BaseApplicationImpl.getContext());
      if (((SharedPreferences)localObject1).getBoolean("FightReporter_deviceid", false)) {
        return;
      }
      ((SharedPreferences)localObject1).edit().putBoolean("FightReporter_deviceid", true).apply();
      str1 = QQDeviceInfo.getIMEI("0");
    }
    try
    {
      localObject1 = Settings.Secure.getString(BaseApplicationImpl.getContext().getContentResolver(), "android_id");
    }
    catch (Exception localException)
    {
      label126:
      Object localObject2;
      String str2;
      break label126;
    }
    localObject1 = "";
    localObject2 = new HashMap();
    ((HashMap)localObject2).put("imei", str1);
    ((HashMap)localObject2).put("androidID", localObject1);
    str2 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(str2, "FightReporter_deviceid", true, 0L, 0L, (HashMap)localObject2, null);
    if (QLog.isDevelopLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("rYU.i.A.report real...IMEI = ");
      ((StringBuilder)localObject2).append(str1);
      ((StringBuilder)localObject2).append(",androidID = ");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("FightReporter_", 2, ((StringBuilder)localObject2).toString());
    }
  }
  
  public static void a(MessageRecord paramMessageRecord)
  {
    try
    {
      if (paramMessageRecord.msgtype == -2011)
      {
        paramMessageRecord = (MessageForStructing)paramMessageRecord;
        if (paramMessageRecord.structingMsg != null)
        {
          int i = paramMessageRecord.structingMsg.mMsgServiceID;
          a(paramMessageRecord.structingMsg);
          return;
        }
      }
    }
    catch (Throwable paramMessageRecord)
    {
      QLog.d("FightReporter_", 1, paramMessageRecord, new Object[0]);
    }
  }
  
  public static void a(AbsStructMsg paramAbsStructMsg)
  {
    AIOConfigData localAIOConfigData1;
    label89:
    do
    {
      try
      {
        int i = paramAbsStructMsg.mMsgServiceID;
        if ((i < 0) || (i > 6)) {
          break label89;
        }
        AIOConfigData localAIOConfigData2 = AIOConfigManager.a;
        localAIOConfigData1 = localAIOConfigData2;
        if (!a) {
          continue;
        }
        localAIOConfigData1 = localAIOConfigData2;
        if (localAIOConfigData2 != null) {
          continue;
        }
        localAIOConfigData1 = new AIOConfigData();
        localAIOConfigData1.a = 1;
        localAIOConfigData1.b = 1;
        localAIOConfigData1.c = 5;
      }
      catch (Throwable paramAbsStructMsg)
      {
        QLog.d("FightReporter_", 1, paramAbsStructMsg, new Object[0]);
      }
      if (localAIOConfigData1.a == 0) {
        return;
      }
      a("FightReporter_structMsgServiceID", paramAbsStructMsg.getXml());
      return;
      return;
    } while (localAIOConfigData1 != null);
  }
  
  public static void a(String paramString)
  {
    CaughtExceptionReport.a(new Throwable(paramString));
  }
  
  public static void a(String paramString1, String paramString2)
  {
    CaughtExceptionReport.a(new Throwable(paramString1), paramString2);
  }
  
  public static void b()
  {
    if (d) {
      return;
    }
    d = true;
    Object localObject1 = PreferenceManager.getDefaultGlobalPreference(BaseApplicationImpl.getContext());
    if (((SharedPreferences)localObject1).getBoolean("FightReporter_cpu_abi", false)) {
      return;
    }
    ((SharedPreferences)localObject1).edit().putBoolean("FightReporter_cpu_abi", true).apply();
    Object localObject2 = new HashMap();
    if (Build.VERSION.SDK_INT >= 21) {
      localObject1 = Build.SUPPORTED_ABIS[0];
    } else {
      localObject1 = Build.CPU_ABI;
    }
    ((HashMap)localObject2).put("cpu_abi", localObject1);
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(Build.VERSION.SDK_INT);
    ((StringBuilder)localObject3).append("");
    ((HashMap)localObject2).put("sdk", ((StringBuilder)localObject3).toString());
    localObject3 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance((String)localObject3, "FightReporter_cpu_abi", true, 0L, 0L, (HashMap)localObject2, null);
    if (QLog.isDevelopLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("rYU.i.A.report real...cpu abi = ");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(",sdk = ");
      ((StringBuilder)localObject2).append(Build.VERSION.SDK_INT);
      QLog.d("FightReporter_", 2, ((StringBuilder)localObject2).toString());
    }
  }
  
  public static void c()
  {
    AIOConfigData localAIOConfigData = AIOConfigManager.a;
    if ((localAIOConfigData != null) && (localAIOConfigData.e == 1)) {
      a("FightReporter_openthirdappnullinfo");
    }
  }
  
  public static void d()
  {
    Object localObject1 = PreferenceManager.getDefaultGlobalPreference(BaseApplicationImpl.getContext());
    String str2 = SecurityUtile.encode("d_iemi");
    Object localObject2 = SecurityUtile.encode("d_idandroid");
    SharedPreferences.Editor localEditor = ((SharedPreferences)localObject1).edit();
    String str3 = QQDeviceInfo.getIMEI("0");
    try
    {
      str1 = Settings.Secure.getString(BaseApplicationImpl.getContext().getContentResolver(), "android_id");
    }
    catch (Exception localException)
    {
      String str1;
      label49:
      break label49;
    }
    str1 = "";
    str3 = SecurityUtile.encode(str3);
    str1 = SecurityUtile.encode(str1);
    localEditor.putString(str2, str3);
    localEditor.putString((String)localObject2, str1);
    localEditor.putBoolean("saveIDA", true);
    localEditor.apply();
    if (QLog.isDevelopLevel())
    {
      str1 = ((SharedPreferences)localObject1).getString(str2, "");
      localObject1 = ((SharedPreferences)localObject1).getString((String)localObject2, "");
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("has save suc,spIMStr = ");
      ((StringBuilder)localObject2).append(str1);
      ((StringBuilder)localObject2).append(", imei = ");
      ((StringBuilder)localObject2).append(SecurityUtile.encode(str1));
      ((StringBuilder)localObject2).append(",androidid = ");
      ((StringBuilder)localObject2).append(SecurityUtile.encode((String)localObject1));
      QLog.d("FightReporter_", 4, ((StringBuilder)localObject2).toString());
    }
  }
  
  public static void e() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.FightReporter
 * JD-Core Version:    0.7.0.1
 */