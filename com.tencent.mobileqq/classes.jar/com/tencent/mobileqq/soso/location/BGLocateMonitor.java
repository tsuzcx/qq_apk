package com.tencent.mobileqq.soso.location;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.ContextWrapper;
import android.location.LocationManager;
import android.os.IBinder;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.mobileqq.imcore.proxy.basic.CaughtExceptionReportProxy;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.Foreground;
import mqq.app.MobileQQ;

public class BGLocateMonitor
{
  private static final String[] LOCATION_MANAGER_METHOD_LIST = { "getLastLocation", "requestLocationUpdates" };
  private static final String TAG = "BGLocateMonitor";
  private static final String[] TELEPHONY_MANAGER_METHOD_LIST = { "getCellLocation", "getAllCellInfo", "getNeighboringCellInfo", "getServiceStateForSubscriber", "requestNetworkScan", "requestCellInfoUpdate", "getAvailableNetworks", "getServiceState" };
  
  public static void checkTencentLocateReport(int paramInt)
  {
    if (!isAppOnForeground())
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("BGLocate# SOSOInterface#startLocation perCheckCode = ");
      ((StringBuilder)localObject).append(paramInt);
      localObject = new RuntimeException(((StringBuilder)localObject).toString());
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SOSOInterface#startLocation in background, perCheckCode = ");
      localStringBuilder.append(paramInt);
      QLog.d("BGLocateMonitor", 1, localStringBuilder.toString(), (Throwable)localObject);
    }
  }
  
  private static void clearLocationManagerCache(Context paramContext)
  {
    QLog.d("BGLocateMonitor", 1, "clearLocationManagerCache");
    if (paramContext == null)
    {
      QLog.e("BGLocateMonitor", 1, "context == null");
      return;
    }
    if ((paramContext instanceof ContextWrapper)) {
      paramContext = ((ContextWrapper)paramContext).getBaseContext();
    } else {
      paramContext = null;
    }
    for (;;)
    {
      int i;
      try
      {
        Object localObject = Class.forName("android.app.ContextImpl").getDeclaredField("mServiceCache");
        ((Field)localObject).setAccessible(true);
        paramContext = (Object[])((Field)localObject).get(paramContext);
        if (paramContext != null)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("serviceCache: ");
          ((StringBuilder)localObject).append(paramContext.length);
          QLog.d("BGLocateMonitor", 1, ((StringBuilder)localObject).toString());
          i = 0;
          j = -1;
          if (i < paramContext.length)
          {
            localObject = paramContext[i];
            k = j;
            if (localObject == null) {
              break label247;
            }
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("serviceType: ");
            localStringBuilder.append(localObject.getClass().getName());
            localStringBuilder.append(" i: ");
            localStringBuilder.append(i);
            QLog.d("BGLocateMonitor", 1, localStringBuilder.toString());
            if ((localObject instanceof LocationManager)) {
              break label245;
            }
            k = j;
            if (!(localObject instanceof TelephonyManager)) {
              break label247;
            }
            break label245;
          }
          if (j != -1)
          {
            paramContext[j] = null;
            QLog.d("BGLocateMonitor", 1, "real clear locationManager cache");
            return;
          }
        }
      }
      catch (Throwable paramContext)
      {
        paramContext.printStackTrace();
        QLog.d("BGLocateMonitor", 1, "clearLocationManagerCache", paramContext);
      }
      return;
      label245:
      int k = i;
      label247:
      i += 1;
      int j = k;
    }
  }
  
  private static void hookLocationManager()
  {
    try
    {
      Object localObject1 = Class.forName("android.os.ServiceManager");
      Object localObject3 = (IBinder)((Class)localObject1).getDeclaredMethod("getService", new Class[] { String.class }).invoke(null, new Object[] { "location" });
      Object localObject2 = ((Class)localObject1).getClassLoader();
      localObject3 = new BGLocateMonitor.LocationBinderProxy((IBinder)localObject3);
      localObject2 = (IBinder)Proxy.newProxyInstance((ClassLoader)localObject2, new Class[] { IBinder.class }, (InvocationHandler)localObject3);
      localObject1 = ((Class)localObject1).getDeclaredField("sCache");
      ((Field)localObject1).setAccessible(true);
      ((Map)((Field)localObject1).get(null)).put("location", localObject2);
      return;
    }
    catch (Exception localException)
    {
      QLog.d("BGLocateMonitor", 1, "monitorSystemLocation", localException);
    }
  }
  
  private static void hookTelephonyManager()
  {
    try
    {
      Object localObject1 = Class.forName("android.os.ServiceManager");
      Object localObject3 = (IBinder)((Class)localObject1).getDeclaredMethod("getService", new Class[] { String.class }).invoke(null, new Object[] { "phone" });
      Object localObject2 = ((Class)localObject1).getClassLoader();
      localObject3 = new BGLocateMonitor.TelephonyBinderProxy((IBinder)localObject3);
      localObject2 = (IBinder)Proxy.newProxyInstance((ClassLoader)localObject2, new Class[] { IBinder.class }, (InvocationHandler)localObject3);
      localObject1 = ((Class)localObject1).getDeclaredField("sCache");
      ((Field)localObject1).setAccessible(true);
      ((Map)((Field)localObject1).get(null)).put("phone", localObject2);
      return;
    }
    catch (Exception localException)
    {
      QLog.d("BGLocateMonitor", 1, "monitorSystemLocation", localException);
    }
  }
  
  private static boolean isAppOnForeground()
  {
    if (Foreground.getActivityCount() > 0) {
      return true;
    }
    Object localObject = (ActivityManager)MobileQQ.sMobileQQ.getBaseContext().getSystemService("activity");
    String str = MobileQQ.sMobileQQ.getBaseContext().getPackageName();
    localObject = ((ActivityManager)localObject).getRunningAppProcesses();
    if (localObject == null) {
      return false;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
      if ((localRunningAppProcessInfo != null) && (localRunningAppProcessInfo.importance == 100) && (localRunningAppProcessInfo.processName.startsWith(str))) {
        return true;
      }
    }
    return false;
  }
  
  private static boolean needReport(String paramString, String[] paramArrayOfString)
  {
    boolean bool1 = TextUtils.isEmpty(paramString);
    boolean bool3 = false;
    if (bool1) {
      return false;
    }
    boolean bool4 = isAppOnForeground();
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (paramArrayOfString[i].equals(paramString))
      {
        bool1 = true;
        break label57;
      }
      i += 1;
    }
    bool1 = false;
    label57:
    if (bool1)
    {
      paramArrayOfString = new StringBuilder();
      paramArrayOfString.append("needReport, ");
      paramArrayOfString.append(paramString);
      paramArrayOfString.append(", isMonitorMethod: ");
      paramArrayOfString.append(bool1);
      paramArrayOfString.append(", isAppOnForeground: ");
      paramArrayOfString.append(bool4);
      QLog.d("BGLocateMonitor", 1, paramArrayOfString.toString(), new RuntimeException("BGLocateMonitor MonitorMethod"));
    }
    else
    {
      paramArrayOfString = new StringBuilder();
      paramArrayOfString.append("needReport, ");
      paramArrayOfString.append(paramString);
      paramArrayOfString.append(", isMonitorMethod: ");
      paramArrayOfString.append(bool1);
      paramArrayOfString.append(", isAppOnForeground: ");
      paramArrayOfString.append(bool4);
      QLog.d("BGLocateMonitor", 1, paramArrayOfString.toString());
    }
    boolean bool2 = bool3;
    if (bool1)
    {
      bool2 = bool3;
      if (!bool4) {
        bool2 = true;
      }
    }
    return bool2;
  }
  
  private static void report(String paramString)
  {
    RuntimeException localRuntimeException = new RuntimeException("BGLocate Report");
    QLog.e("BGLocateMonitor", 1, String.format("call LocationManager#%s locate in background!", new Object[] { paramString }), localRuntimeException);
    CaughtExceptionReportProxy.e(localRuntimeException, "BGLocate Report");
  }
  
  public static void start()
  {
    QLog.d("BGLocateMonitor", 1, "start background location monitor..");
    hookLocationManager();
    hookTelephonyManager();
    clearLocationManagerCache(MobileQQ.sMobileQQ.getApplicationContext());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.soso.location.BGLocateMonitor
 * JD-Core Version:    0.7.0.1
 */