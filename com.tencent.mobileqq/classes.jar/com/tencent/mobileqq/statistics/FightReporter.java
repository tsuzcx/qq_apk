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
    if (Build.VERSION.SDK_INT > 28) {}
    for (;;)
    {
      return;
      if (!c)
      {
        if (!PreferenceManager.getDefaultGlobalPreference(BaseApplicationImpl.getContext()).getBoolean("saveIDA", false)) {
          d();
        }
        c = true;
      }
      if (b) {
        continue;
      }
      Object localObject = AIOConfigManager.a;
      if ((localObject == null) || (((AIOConfigData)localObject).f != 1)) {
        continue;
      }
      b = true;
      localObject = PreferenceManager.getDefaultGlobalPreference(BaseApplicationImpl.getContext());
      if (((SharedPreferences)localObject).getBoolean("FightReporter_deviceid", false)) {
        continue;
      }
      ((SharedPreferences)localObject).edit().putBoolean("FightReporter_deviceid", true).apply();
      String str2 = QQDeviceInfo.getIMEI("0");
      try
      {
        localObject = Settings.Secure.getString(BaseApplicationImpl.getContext().getContentResolver(), "android_id");
        HashMap localHashMap = new HashMap();
        localHashMap.put("imei", str2);
        localHashMap.put("androidID", localObject);
        String str3 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
        StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(str3, "FightReporter_deviceid", true, 0L, 0L, localHashMap, null);
        if (!QLog.isDevelopLevel()) {
          continue;
        }
        QLog.d("FightReporter_", 2, "rYU.i.A.report real...IMEI = " + str2 + ",androidID = " + (String)localObject);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          String str1 = "";
        }
      }
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
        }
      }
      return;
    }
    catch (Throwable paramMessageRecord)
    {
      QLog.d("FightReporter_", 1, paramMessageRecord, new Object[0]);
    }
  }
  
  public static void a(AbsStructMsg paramAbsStructMsg)
  {
    AIOConfigData localAIOConfigData1;
    do
    {
      try
      {
        int i = paramAbsStructMsg.mMsgServiceID;
        if ((i < 0) || (i > 6)) {
          break;
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
        return;
      }
      if (localAIOConfigData1.a == 0) {
        break;
      }
      a("FightReporter_structMsgServiceID", paramAbsStructMsg.getXml());
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
    if (d) {}
    do
    {
      return;
      d = true;
      localObject = PreferenceManager.getDefaultGlobalPreference(BaseApplicationImpl.getContext());
    } while (((SharedPreferences)localObject).getBoolean("FightReporter_cpu_abi", false));
    ((SharedPreferences)localObject).edit().putBoolean("FightReporter_cpu_abi", true).apply();
    HashMap localHashMap = new HashMap();
    if (Build.VERSION.SDK_INT >= 21) {}
    for (Object localObject = Build.SUPPORTED_ABIS[0];; localObject = Build.CPU_ABI)
    {
      localHashMap.put("cpu_abi", localObject);
      localHashMap.put("sdk", Build.VERSION.SDK_INT + "");
      String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(str, "FightReporter_cpu_abi", true, 0L, 0L, localHashMap, null);
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.d("FightReporter_", 2, "rYU.i.A.report real...cpu abi = " + (String)localObject + ",sdk = " + Build.VERSION.SDK_INT);
      return;
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
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultGlobalPreference(BaseApplicationImpl.getContext());
    String str3 = SecurityUtile.encode("d_iemi");
    String str2 = SecurityUtile.encode("d_idandroid");
    SharedPreferences.Editor localEditor = localSharedPreferences.edit();
    String str4 = QQDeviceInfo.getIMEI("0");
    Object localObject = "";
    try
    {
      str1 = Settings.Secure.getString(BaseApplicationImpl.getContext().getContentResolver(), "android_id");
      localObject = str1;
    }
    catch (Exception localException)
    {
      String str1;
      label52:
      break label52;
    }
    str1 = SecurityUtile.encode(str4);
    localObject = SecurityUtile.encode((String)localObject);
    localEditor.putString(str3, str1);
    localEditor.putString(str2, (String)localObject);
    localEditor.putBoolean("saveIDA", true);
    localEditor.apply();
    if (QLog.isDevelopLevel())
    {
      localObject = localSharedPreferences.getString(str3, "");
      str1 = localSharedPreferences.getString(str2, "");
      QLog.d("FightReporter_", 4, "has save suc,spIMStr = " + (String)localObject + ", imei = " + SecurityUtile.encode((String)localObject) + ",androidid = " + SecurityUtile.encode(str1));
    }
  }
  
  public static void e() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.FightReporter
 * JD-Core Version:    0.7.0.1
 */