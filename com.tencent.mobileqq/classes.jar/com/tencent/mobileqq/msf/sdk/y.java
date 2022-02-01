package com.tencent.mobileqq.msf.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.ServiceState;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.auth.b;
import com.tencent.mobileqq.msf.core.c.j;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;
import java.util.HashMap;

public class y
{
  public static final int a = 29;
  private static final String b = "MSF.C.NetworkType5GWrapper";
  private static final String c = "evt_five_g_network_type";
  private static final String d = "evt_read_phone_state_per";
  private static final String e = "user_uin";
  private static final String f = "has_read_phone_per";
  private static final String g = "is_five_g";
  private static final long h = 86400000L;
  private static final String i = "sp_network";
  private static final String j = "last_report_5g_network_type";
  private static final String k = "last_report_read_phone_state_per_time";
  private static long l = b("last_report_5g_network_type");
  private static long m = b("last_report_read_phone_state_per_time");
  
  public static int a(int paramInt)
  {
    try
    {
      int n = b(paramInt);
      return n;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("MSF.C.NetworkType5GWrapper", 1, "getNetworkTypeWhenSDKVerAboveQ throw e", localThrowable);
    }
    return paramInt;
  }
  
  private static ServiceState a()
  {
    TelephonyManager localTelephonyManager = (TelephonyManager)BaseApplication.getContext().getSystemService("phone");
    if ((Build.VERSION.SDK_INT >= 26) && (localTelephonyManager != null) && (b())) {
      try
      {
        int n = g.a(g.a(localTelephonyManager));
        if (n < 0) {
          return localTelephonyManager.getServiceState();
        }
        Object localObject = TelephonyManager.class.getDeclaredMethod("getServiceStateForSubscriber", new Class[] { Integer.TYPE });
        ((Method)localObject).setAccessible(true);
        localObject = (ServiceState)((Method)localObject).invoke(localTelephonyManager, new Object[] { Integer.valueOf(n) });
        return localObject;
      }
      catch (Exception localException)
      {
        QLog.e("MSF.C.NetworkType5GWrapper", 1, "getServiceState throw e", localException);
        return localTelephonyManager.getServiceState();
      }
    }
    if ((Build.VERSION.SDK_INT >= 23) && (QLog.isColorLevel())) {
      QLog.d("MSF.C.NetworkType5GWrapper", 2, "sdkVersion = " + Build.VERSION.SDK_INT + ", per = " + b());
    }
    return null;
  }
  
  private static void a(j paramj, int paramInt, String paramString)
  {
    long l1 = System.currentTimeMillis();
    if (l1 - m <= 86400000L) {
      return;
    }
    m = l1;
    a("last_report_read_phone_state_per_time", l1);
    boolean bool = b();
    HashMap localHashMap = new HashMap();
    localHashMap.put("user_uin", paramString);
    localHashMap.put("has_read_phone_per", String.valueOf(bool));
    if (paramInt == 20) {}
    for (bool = true;; bool = false)
    {
      localHashMap.put("is_five_g", String.valueOf(bool));
      paramj.a("evt_read_phone_state_per", true, 0L, 0L, localHashMap, false, false);
      return;
    }
  }
  
  private static void a(String paramString, long paramLong)
  {
    BaseApplication.getContext().getSharedPreferences("sp_network", 0).edit().putLong(paramString, paramLong).apply();
  }
  
  private static boolean a(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramString)) {
      if (!paramString.contains("nrState=NOT_RESTRICTED"))
      {
        bool1 = bool2;
        if (!paramString.contains("nrState=CONNECTED")) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private static int b(int paramInt)
  {
    int n;
    if (Build.VERSION.SDK_INT < 29) {
      n = paramInt;
    }
    for (;;)
    {
      try
      {
        d(n);
        return n;
      }
      catch (Throwable localThrowable)
      {
        ServiceState localServiceState;
        QLog.e("MSF.C.NetworkType5GWrapper", 1, "reportIfNeed throw t, per = " + b(), localThrowable);
        return n;
      }
      if (paramInt == 20)
      {
        n = paramInt;
        if (QLog.isColorLevel())
        {
          QLog.d("MSF.C.NetworkType5GWrapper", 2, "network type is correct, val = " + paramInt);
          n = paramInt;
        }
      }
      else if (paramInt != 13)
      {
        n = paramInt;
        if (QLog.isColorLevel())
        {
          QLog.d("MSF.C.NetworkType5GWrapper", 2, "networkType != LTE");
          n = paramInt;
        }
      }
      else if (Build.MANUFACTURER.equalsIgnoreCase("huawei"))
      {
        paramInt = c(paramInt);
        n = paramInt;
        if (QLog.isColorLevel())
        {
          QLog.d("MSF.C.NetworkType5GWrapper", 2, "getHwNetworkType = " + paramInt);
          n = paramInt;
        }
      }
      else
      {
        localServiceState = a();
        if ((localServiceState != null) && (a(localServiceState.toString())))
        {
          if (QLog.isColorLevel())
          {
            QLog.d("MSF.C.NetworkType5GWrapper", 2, "getNetworkTypeWhenSDKVerAboveQ, res is nr last");
            n = 20;
          }
        }
        else
        {
          n = paramInt;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("MSF.C.NetworkType5GWrapper", 2, "go end");
          n = paramInt;
          continue;
        }
        n = 20;
      }
    }
  }
  
  private static long b(String paramString)
  {
    return BaseApplication.getContext().getSharedPreferences("sp_network", 0).getLong(paramString, 0L);
  }
  
  private static void b(j paramj, int paramInt, String paramString)
  {
    long l1 = System.currentTimeMillis();
    if ((paramInt != 20) || (l1 - l <= 86400000L)) {
      return;
    }
    l = l1;
    a("last_report_5g_network_type", l1);
    HashMap localHashMap = new HashMap();
    localHashMap.put("user_uin", paramString);
    paramj.a("evt_five_g_network_type", true, 0L, 0L, localHashMap, false, false);
  }
  
  private static boolean b()
  {
    return (Build.VERSION.SDK_INT < 23) || (BaseApplication.getContext().checkSelfPermission("android.permission.READ_PHONE_STATE") == 0);
  }
  
  private static int c(int paramInt)
  {
    boolean bool = false;
    Object localObject1 = a();
    if ((Build.VERSION.SDK_INT >= 26) && (localObject1 != null) && (b())) {}
    do
    {
      do
      {
        try
        {
          localObject2 = ServiceState.class.getMethod("getHwNetworkType", new Class[0]);
          ((Method)localObject2).setAccessible(true);
          localObject1 = (Integer)((Method)localObject2).invoke(localObject1, new Object[0]);
          n = paramInt;
          if (localObject1 != null)
          {
            int i1 = ((Integer)localObject1).intValue();
            n = paramInt;
            if (i1 == 20) {
              n = 20;
            }
          }
          return n;
        }
        catch (Exception localException)
        {
          QLog.e("MSF.C.NetworkType5GWrapper", 1, "getHwNetworkType throw ex", localException);
          return paramInt;
        }
        n = paramInt;
      } while (Build.VERSION.SDK_INT < 23);
      int n = paramInt;
    } while (!QLog.isColorLevel());
    Object localObject2 = new StringBuilder().append("sdkVersion = ").append(Build.VERSION.SDK_INT).append(", ss != null = ");
    if (localException != null) {
      bool = true;
    }
    QLog.d("MSF.C.NetworkType5GWrapper", 2, bool + ", per = " + b());
    return paramInt;
  }
  
  private static void d(int paramInt)
  {
    if (Build.VERSION.SDK_INT < 29) {
      return;
    }
    if ((MsfCore.sCore == null) || (MsfCore.sCore.statReporter == null) || (MsfCore.sCore.getAccountCenter() == null))
    {
      QLog.d("MSF.C.NetworkType5GWrapper", 1, "some param are still null, per = " + b());
      return;
    }
    j localj = MsfCore.sCore.statReporter;
    String str = MsfCore.sCore.getAccountCenter().i();
    a(localj, paramInt, str);
    b(localj, paramInt, str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.y
 * JD-Core Version:    0.7.0.1
 */