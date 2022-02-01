package com.tencent.mobileqq.javahook;

import android.content.Context;
import android.content.ContextWrapper;
import android.location.LocationManager;
import android.os.IBinder;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import avyg;
import avyh;
import bdjw;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;

public class BGLocateMonitor
{
  private static final String[] LOCATION_MANAGER_METHOD_LIST = { "getLastLocation", "requestLocationUpdates" };
  private static final String TAG = "BGLocateMonitor";
  private static final String[] TELEPHONY_MANAGER_METHOD_LIST = { "getCellLocation", "getAllCellInfo", "getNeighboringCellInfo" };
  
  public static void checkTencentLocateReport(int paramInt)
  {
    if (!isAppOnForeground())
    {
      RuntimeException localRuntimeException = new RuntimeException("BGLocate# SOSOInterface#startLocation perCheckCode = " + paramInt);
      QLog.d("BGLocateMonitor", 1, "SOSOInterface#startLocation in background, perCheckCode = " + paramInt, localRuntimeException);
      bdjw.a(localRuntimeException);
    }
  }
  
  private static void clearLocationManagerCache(Context paramContext)
  {
    Context localContext = null;
    QLog.d("BGLocateMonitor", 1, "clearLocationManagerCache");
    if (paramContext == null)
    {
      QLog.e("BGLocateMonitor", 1, "context == null");
      return;
    }
    if ((paramContext instanceof ContextWrapper)) {
      localContext = ((ContextWrapper)paramContext).getBaseContext();
    }
    for (;;)
    {
      int i;
      try
      {
        paramContext = Class.forName("android.app.ContextImpl").getDeclaredField("mServiceCache");
        paramContext.setAccessible(true);
        paramContext = (Object[])paramContext.get(localContext);
        if (paramContext == null) {
          break;
        }
        QLog.d("BGLocateMonitor", 1, "serviceCache: " + paramContext.length);
        i = 0;
        j = -1;
        if (i < paramContext.length)
        {
          localContext = paramContext[i];
          k = j;
          if (localContext == null) {
            break label218;
          }
          QLog.d("BGLocateMonitor", 1, "serviceType: " + localContext.getClass().getName() + " i: " + i);
          if (!(localContext instanceof LocationManager))
          {
            k = j;
            if (!(localContext instanceof TelephonyManager)) {
              break label218;
            }
          }
        }
        else
        {
          if (j == -1) {
            break;
          }
          paramContext[j] = null;
          QLog.d("BGLocateMonitor", 1, "real clear locationManager cache");
          return;
        }
      }
      catch (Throwable paramContext)
      {
        paramContext.printStackTrace();
        QLog.d("BGLocateMonitor", 1, "clearLocationManagerCache", paramContext);
        return;
      }
      int k = i;
      label218:
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
      localObject3 = new avyg((IBinder)localObject3);
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
      localObject3 = new avyh((IBinder)localObject3);
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
    return GesturePWDUtils.isAppOnForeground(BaseApplicationImpl.sApplication.getBaseContext());
  }
  
  private static boolean needReport(String paramString, String[] paramArrayOfString)
  {
    boolean bool2 = true;
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    boolean bool3 = isAppOnForeground();
    int j = paramArrayOfString.length;
    int i = 0;
    if (i < j) {
      if (!paramArrayOfString[i].equals(paramString)) {}
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      if (bool1)
      {
        QLog.d("BGLocateMonitor", 1, "needReport, " + paramString + ", isMonitorMethod: " + bool1 + ", isAppOnForeground: " + bool3, new RuntimeException("BGLocateMonitor MonitorMethod"));
        label99:
        if ((!bool1) || (bool3)) {
          break label171;
        }
      }
      label171:
      for (bool1 = bool2;; bool1 = false)
      {
        return bool1;
        i += 1;
        break;
        QLog.d("BGLocateMonitor", 1, "needReport, " + paramString + ", isMonitorMethod: " + bool1 + ", isAppOnForeground: " + bool3);
        break label99;
      }
    }
  }
  
  private static void report(String paramString)
  {
    RuntimeException localRuntimeException = new RuntimeException("BGLocate Report");
    QLog.e("BGLocateMonitor", 1, String.format("call LocationManager#%s locate in background!", new Object[] { paramString }), localRuntimeException);
    bdjw.a(localRuntimeException);
  }
  
  public static void start()
  {
    QLog.d("BGLocateMonitor", 1, "start background location monitor..");
    hookLocationManager();
    hookTelephonyManager();
    clearLocationManagerCache(BaseApplicationImpl.sApplication);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.javahook.BGLocateMonitor
 * JD-Core Version:    0.7.0.1
 */