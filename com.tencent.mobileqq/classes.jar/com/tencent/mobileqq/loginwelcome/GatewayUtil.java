package com.tencent.mobileqq.loginwelcome;

import android.content.Context;
import android.os.Build.VERSION;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import mqq.app.AppRuntime;

public class GatewayUtil
{
  private static int a(Context paramContext)
  {
    if (paramContext == null) {
      return -1;
    }
    if (!a(paramContext)) {
      return 0;
    }
    if (Build.VERSION.SDK_INT >= 26) {
      return c(paramContext);
    }
    if (Build.VERSION.SDK_INT >= 22) {
      return b(paramContext);
    }
    return d(paramContext);
  }
  
  public static void a(Context paramContext, AppRuntime paramAppRuntime)
  {
    if (paramContext == null) {
      QLog.e("GatewayReportUtil", 1, "reportLoginSimCardNum but context is null");
    }
    for (;;)
    {
      return;
      int i = a(paramContext);
      QLog.d("GatewayReportUtil", 1, new Object[] { "sim card num is ", Integer.valueOf(i) });
      paramContext = null;
      if (i == 0) {
        paramContext = "0X800B0A9";
      }
      while (paramContext != null)
      {
        ReportController.a(paramAppRuntime, "dc00898", "", "", paramContext, paramContext, 0, 0, "", "", "", "");
        return;
        if (i == 1) {
          paramContext = "0X800B0AB";
        } else if (i == 2) {
          paramContext = "0X800B0A1";
        }
      }
    }
  }
  
  public static void a(Context paramContext, AppRuntime paramAppRuntime, int paramInt, String paramString)
  {
    if (paramContext == null) {
      QLog.e("GatewayReportUtil", 1, "reportSimCardNum but context is null");
    }
    for (;;)
    {
      return;
      int i = a(paramContext);
      QLog.d("GatewayReportUtil", 1, new Object[] { "sim card num is ", Integer.valueOf(i) });
      paramContext = null;
      if (i == 0) {
        paramContext = "0X800B0AA";
      }
      while (paramContext != null)
      {
        ReportController.a(paramAppRuntime, "dc00898", "", paramString, paramContext, paramContext, paramInt, 0, "", "", "", "");
        return;
        if (i == 1) {
          paramContext = "0X800B0AC";
        } else if (i == 2) {
          paramContext = "0X800B0A3";
        }
      }
    }
  }
  
  private static boolean a(Context paramContext)
  {
    boolean bool;
    switch (((TelephonyManager)paramContext.getSystemService("phone")).getSimState())
    {
    default: 
      bool = true;
    }
    for (;;)
    {
      QLog.d("GatewayReportUtil", 1, new Object[] { "hasSimCard result : ", Boolean.valueOf(bool) });
      return bool;
      bool = false;
      continue;
      bool = false;
    }
  }
  
  @RequiresApi(api=22)
  private static int b(Context paramContext)
  {
    try
    {
      SubscriptionManager localSubscriptionManager = (SubscriptionManager)paramContext.getSystemService("telephony_subscription_service");
      if (ActivityCompat.checkSelfPermission(paramContext, "android.permission.READ_PHONE_STATE") != 0)
      {
        QLog.e("GatewayReportUtil", 1, "getSimCardNumV22 no permission");
        return -1;
      }
      int i = localSubscriptionManager.getActiveSubscriptionInfoCount();
      return i;
    }
    catch (Exception paramContext)
    {
      QLog.e("GatewayReportUtil", 1, new Object[] { "getSimCardNumV22 error : ", paramContext.getMessage() });
    }
    return -1;
  }
  
  @RequiresApi(api=26)
  private static int c(Context paramContext)
  {
    try
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      int j = 0;
      int k;
      for (int i = 0;; i = k)
      {
        k = i;
        if (j >= 2) {
          break;
        }
        int m = paramContext.getSimState(j);
        k = i;
        if (m == 5) {
          k = i + 1;
        }
        j += 1;
      }
      return k;
    }
    catch (Exception paramContext)
    {
      k = -1;
      QLog.d("GatewayReportUtil", 1, new Object[] { "getSimCardNumV26 error : ", paramContext.getMessage() });
    }
  }
  
  private static int d(Context paramContext)
  {
    for (;;)
    {
      try
      {
        paramContext = (TelephonyManager)paramContext.getSystemService("phone");
        i = paramContext.getSimState();
        if (i == 5)
        {
          i = 1;
          int j;
          return i;
        }
      }
      catch (NoSuchMethodException paramContext)
      {
        try
        {
          j = ((Integer)TelephonyManager.class.getMethod("getSimState", new Class[] { Integer.TYPE }).invoke(paramContext, new Object[] { Integer.valueOf(1) })).intValue();
          if (j != 5) {
            break label234;
          }
          return 2;
        }
        catch (InvocationTargetException paramContext)
        {
          continue;
        }
        catch (IllegalAccessException paramContext)
        {
          continue;
        }
        catch (NoSuchMethodException paramContext)
        {
          continue;
        }
        paramContext = paramContext;
        i = 0;
        QLog.e("GatewayReportUtil", 1, new Object[] { "getSimCardNumV21 NoSuchMethodException, count : ", Integer.valueOf(i), " error msg : ", paramContext.getMessage() });
        return i;
      }
      catch (IllegalAccessException paramContext)
      {
        i = 0;
        QLog.e("GatewayReportUtil", 1, new Object[] { "getSimCardNumV21 IllegalAccessException, count : ", Integer.valueOf(i), " error msg : ", paramContext.getMessage() });
        return i;
      }
      catch (InvocationTargetException paramContext)
      {
        i = 0;
        QLog.e("GatewayReportUtil", 1, new Object[] { "getSimCardNumV21 InvocationTargetException, count : ", Integer.valueOf(i), " error msg : ", paramContext.getMessage() });
        return i;
      }
      catch (Exception paramContext)
      {
        QLog.e("GatewayReportUtil", 1, new Object[] { "getSimCardNumV21 other exception, count : ", Integer.valueOf(-1), " error msg : ", paramContext.getMessage() });
        return -1;
      }
      label234:
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.loginwelcome.GatewayUtil
 * JD-Core Version:    0.7.0.1
 */