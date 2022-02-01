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
import com.tencent.mobileqq.msf.core.d.j;
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
    Object localObject1 = (TelephonyManager)BaseApplication.getContext().getSystemService("phone");
    if ((Build.VERSION.SDK_INT >= 26) && (localObject1 != null) && (b())) {
      try
      {
        int n = g.a(g.a((TelephonyManager)localObject1));
        if (n < 0) {
          return ((TelephonyManager)localObject1).getServiceState();
        }
        Object localObject2 = TelephonyManager.class.getDeclaredMethod("getServiceStateForSubscriber", new Class[] { Integer.TYPE });
        ((Method)localObject2).setAccessible(true);
        localObject2 = (ServiceState)((Method)localObject2).invoke(localObject1, new Object[] { Integer.valueOf(n) });
        return localObject2;
      }
      catch (Exception localException)
      {
        QLog.e("MSF.C.NetworkType5GWrapper", 1, "getServiceState throw e", localException);
        return ((TelephonyManager)localObject1).getServiceState();
      }
    }
    if ((Build.VERSION.SDK_INT >= 23) && (QLog.isColorLevel()))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("sdkVersion = ");
      ((StringBuilder)localObject1).append(Build.VERSION.SDK_INT);
      ((StringBuilder)localObject1).append(", per = ");
      ((StringBuilder)localObject1).append(b());
      QLog.d("MSF.C.NetworkType5GWrapper", 2, ((StringBuilder)localObject1).toString());
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
    if (paramInt == 20) {
      bool = true;
    } else {
      bool = false;
    }
    localHashMap.put("is_five_g", String.valueOf(bool));
    paramj.a("evt_read_phone_state_per", true, 0L, 0L, localHashMap, false, false);
  }
  
  private static void a(String paramString, long paramLong)
  {
    BaseApplication.getContext().getSharedPreferences("sp_network", 0).edit().putLong(paramString, paramLong).apply();
  }
  
  private static boolean a(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && ((paramString.contains("nrState=NOT_RESTRICTED")) || (paramString.contains("nrState=CONNECTED")));
  }
  
  private static int b(int paramInt)
  {
    int n;
    if (Build.VERSION.SDK_INT < 29)
    {
      n = paramInt;
    }
    else
    {
      Object localObject;
      if (paramInt == 20)
      {
        n = paramInt;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("network type is correct, val = ");
          ((StringBuilder)localObject).append(paramInt);
          QLog.d("MSF.C.NetworkType5GWrapper", 2, ((StringBuilder)localObject).toString());
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
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("getHwNetworkType = ");
          ((StringBuilder)localObject).append(paramInt);
          QLog.d("MSF.C.NetworkType5GWrapper", 2, ((StringBuilder)localObject).toString());
          n = paramInt;
        }
      }
      else
      {
        localObject = a();
        if ((localObject != null) && (a(((ServiceState)localObject).toString())))
        {
          if (QLog.isColorLevel()) {
            QLog.d("MSF.C.NetworkType5GWrapper", 2, "getNetworkTypeWhenSDKVerAboveQ, res is nr last");
          }
          n = 20;
        }
        else
        {
          n = paramInt;
          if (QLog.isColorLevel())
          {
            QLog.d("MSF.C.NetworkType5GWrapper", 2, "go end");
            n = paramInt;
          }
        }
      }
    }
    try
    {
      d(n);
      return n;
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reportIfNeed throw t, per = ");
      localStringBuilder.append(b());
      QLog.e("MSF.C.NetworkType5GWrapper", 1, localStringBuilder.toString(), localThrowable);
    }
    return n;
  }
  
  private static long b(String paramString)
  {
    return BaseApplication.getContext().getSharedPreferences("sp_network", 0).getLong(paramString, 0L);
  }
  
  private static void b(j paramj, int paramInt, String paramString)
  {
    long l1 = System.currentTimeMillis();
    if (paramInt == 20)
    {
      if (l1 - l <= 86400000L) {
        return;
      }
      l = l1;
      a("last_report_5g_network_type", l1);
      HashMap localHashMap = new HashMap();
      localHashMap.put("user_uin", paramString);
      paramj.a("evt_five_g_network_type", true, 0L, 0L, localHashMap, false, false);
    }
  }
  
  private static boolean b()
  {
    int n = Build.VERSION.SDK_INT;
    boolean bool = true;
    if (n >= 23)
    {
      if (BaseApplication.getContext().checkSelfPermission("android.permission.READ_PHONE_STATE") == 0) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  private static int c(int paramInt)
  {
    Object localObject1 = a();
    int n = Build.VERSION.SDK_INT;
    boolean bool = true;
    Object localObject2;
    if ((n >= 26) && (localObject1 != null) && (b()))
    {
      try
      {
        localObject2 = ServiceState.class.getMethod("getHwNetworkType", new Class[0]);
        ((Method)localObject2).setAccessible(true);
        localObject1 = (Integer)((Method)localObject2).invoke(localObject1, new Object[0]);
        if (localObject1 == null) {
          return paramInt;
        }
        n = ((Integer)localObject1).intValue();
        if (n != 20) {
          return paramInt;
        }
        return 20;
      }
      catch (Exception localException)
      {
        QLog.e("MSF.C.NetworkType5GWrapper", 1, "getHwNetworkType throw ex", localException);
        return paramInt;
      }
    }
    else if ((Build.VERSION.SDK_INT >= 23) && (QLog.isColorLevel()))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("sdkVersion = ");
      ((StringBuilder)localObject2).append(Build.VERSION.SDK_INT);
      ((StringBuilder)localObject2).append(", ss != null = ");
      if (localException == null) {
        bool = false;
      }
      ((StringBuilder)localObject2).append(bool);
      ((StringBuilder)localObject2).append(", per = ");
      ((StringBuilder)localObject2).append(b());
      QLog.d("MSF.C.NetworkType5GWrapper", 2, ((StringBuilder)localObject2).toString());
    }
    return paramInt;
  }
  
  private static void d(int paramInt)
  {
    if (Build.VERSION.SDK_INT < 29) {
      return;
    }
    if ((MsfCore.sCore != null) && (MsfCore.sCore.statReporter != null) && (MsfCore.sCore.getAccountCenter() != null))
    {
      localObject = MsfCore.sCore.statReporter;
      String str = MsfCore.sCore.getAccountCenter().i();
      a((j)localObject, paramInt, str);
      b((j)localObject, paramInt, str);
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("some param are still null, per = ");
    ((StringBuilder)localObject).append(b());
    QLog.d("MSF.C.NetworkType5GWrapper", 1, ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.y
 * JD-Core Version:    0.7.0.1
 */