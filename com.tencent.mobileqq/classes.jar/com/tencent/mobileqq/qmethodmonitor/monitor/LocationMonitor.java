package com.tencent.mobileqq.qmethodmonitor.monitor;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.PendingIntent;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Looper;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.app.Foreground;
import mqq.app.MobileQQ;

public class LocationMonitor
{
  public static final String TAG = "LocationMonitor";
  public static final int THRESHOLD = 30;
  public static final int TIMEOUT = 10000;
  
  @SuppressLint({"MissingPermission"})
  public static Location getLastKnownLocation(LocationManager paramLocationManager, String paramString)
  {
    QLog.d("LocationMonitor", 1, "[getLastKnownLocation] invoke");
    InvokeMonitor.onMethodInvoke("LocationMonitor.getLastKnownLocation", "getLastKnownLocation", "");
    processBackgroundRequestLocation("LocationMonitor.getLastKnownLocation", "getLastKnownLocation", "");
    return paramLocationManager.getLastKnownLocation(paramString);
  }
  
  private static boolean isAppOnForeground()
  {
    if (Foreground.getActivityCount() > 0) {
      return true;
    }
    Object localObject = (ActivityManager)MobileQQ.getMobileQQ().getBaseContext().getSystemService("activity");
    String str = MobileQQ.getMobileQQ().getBaseContext().getPackageName();
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
  
  private static void processBackgroundRequestLocation(String paramString1, String paramString2, String paramString3)
  {
    if (isAppOnForeground()) {
      return;
    }
    QLog.d("LocationMonitor", 1, new Object[] { "[backgroundRequestLocation] ", paramString1, paramString2, paramString3 });
    InvokeMonitor.reportNotAllowedInvoke(paramString1, paramString2, paramString3);
  }
  
  @SuppressLint({"MissingPermission"})
  public static void requestLocationUpdates(LocationManager paramLocationManager, long paramLong, float paramFloat, Criteria paramCriteria, PendingIntent paramPendingIntent)
  {
    QLog.d("LocationMonitor", 1, "[requestLocationUpdates] (LFCP) invoke");
    InvokeMonitor.onMethodInvoke("LocationMonitor.requestLocationUpdates(LFCP)", "requestLocationUpdates(LFCP)", "");
    paramLocationManager.requestLocationUpdates(paramLong, paramFloat, paramCriteria, paramPendingIntent);
    processBackgroundRequestLocation("LocationMonitor.requestLocationUpdates(LFCP)", "requestLocationUpdates(LFCP)", "");
  }
  
  @SuppressLint({"MissingPermission"})
  public static void requestLocationUpdates(LocationManager paramLocationManager, long paramLong, float paramFloat, Criteria paramCriteria, LocationListener paramLocationListener, Looper paramLooper)
  {
    QLog.d("LocationMonitor", 1, "[requestLocationUpdates] (LFCLL) invoke");
    InvokeMonitor.onMethodInvoke("LocationMonitor.requestLocationUpdates(LFCLL)", "requestLocationUpdates(LFCLL)", "");
    paramLocationManager.requestLocationUpdates(paramLong, paramFloat, paramCriteria, paramLocationListener, paramLooper);
    processBackgroundRequestLocation("LocationMonitor.requestLocationUpdates(LFCLL)", "requestLocationUpdates(LFCLL)", "");
  }
  
  @SuppressLint({"MissingPermission"})
  public static void requestLocationUpdates(LocationManager paramLocationManager, String paramString, long paramLong, float paramFloat, PendingIntent paramPendingIntent)
  {
    QLog.d("LocationMonitor", 1, "[requestLocationUpdates] (SLFP) invoke");
    InvokeMonitor.onMethodInvoke("LocationMonitor.requestLocationUpdates(SLFP)", "requestLocationUpdates(SLFP)", "");
    paramLocationManager.requestLocationUpdates(paramString, paramLong, paramFloat, paramPendingIntent);
    processBackgroundRequestLocation("LocationMonitor.requestLocationUpdates(SLFP)", "requestLocationUpdates(SLFP)", "");
  }
  
  @SuppressLint({"MissingPermission"})
  public static void requestLocationUpdates(LocationManager paramLocationManager, String paramString, long paramLong, float paramFloat, LocationListener paramLocationListener)
  {
    QLog.d("LocationMonitor", 1, "[requestLocationUpdates] (SLFL) invoke");
    InvokeMonitor.onMethodInvoke("LocationMonitor.requestLocationUpdates(SLFL)", "requestLocationUpdates(SLFL)", "");
    paramLocationManager.requestLocationUpdates(paramString, paramLong, paramFloat, paramLocationListener);
    processBackgroundRequestLocation("LocationMonitor.requestLocationUpdates(SLFL)", "requestLocationUpdates(SLFL)", "");
  }
  
  @SuppressLint({"MissingPermission"})
  public static void requestLocationUpdates(LocationManager paramLocationManager, String paramString, long paramLong, float paramFloat, LocationListener paramLocationListener, Looper paramLooper)
  {
    QLog.d("LocationMonitor", 1, "[requestLocationUpdates] (SLFLL) invoke");
    InvokeMonitor.onMethodInvoke("LocationMonitor.requestLocationUpdates(SLFLL)", "requestLocationUpdates(SLFLL)", "");
    paramLocationManager.requestLocationUpdates(paramString, paramLong, paramFloat, paramLocationListener, paramLooper);
    processBackgroundRequestLocation("LocationMonitor.requestLocationUpdates(SLFLL)", "requestLocationUpdates(SLFLL)", "");
  }
  
  @SuppressLint({"MissingPermission"})
  public void requestSingleUpdate(LocationManager paramLocationManager, Criteria paramCriteria, PendingIntent paramPendingIntent)
  {
    QLog.d("LocationMonitor", 1, "[requestSingleUpdate] (LCP) invoke");
    InvokeMonitor.onMethodInvoke("LocationMonitor.requestSingleUpdate(LCP)", "requestSingleUpdate(LCP)", "");
    paramLocationManager.requestSingleUpdate(paramCriteria, paramPendingIntent);
    processBackgroundRequestLocation("LocationMonitor.requestSingleUpdate(LCP)", "requestSingleUpdate(LCP)", "");
  }
  
  @SuppressLint({"MissingPermission"})
  public void requestSingleUpdate(LocationManager paramLocationManager, Criteria paramCriteria, LocationListener paramLocationListener, Looper paramLooper)
  {
    QLog.d("LocationMonitor", 1, "[requestSingleUpdate] (LCLL) invoke");
    InvokeMonitor.onMethodInvoke("LocationMonitor.requestSingleUpdate(LCLL)", "requestSingleUpdate(LCLL)", "");
    paramLocationManager.requestSingleUpdate(paramCriteria, paramLocationListener, paramLooper);
    processBackgroundRequestLocation("LocationMonitor.requestSingleUpdate(LCLL)", "requestSingleUpdate(LCLL)", "");
  }
  
  @SuppressLint({"MissingPermission"})
  public void requestSingleUpdate(LocationManager paramLocationManager, String paramString, PendingIntent paramPendingIntent)
  {
    QLog.d("LocationMonitor", 1, "[requestSingleUpdate] (LSP) invoke");
    InvokeMonitor.onMethodInvoke("LocationMonitor.requestSingleUpdate(LSP)", "requestSingleUpdate(LSP)", "");
    paramLocationManager.requestSingleUpdate(paramString, paramPendingIntent);
    processBackgroundRequestLocation("LocationMonitor.requestSingleUpdate(LSP)", "requestSingleUpdate(LSP)", "");
  }
  
  @SuppressLint({"MissingPermission"})
  public void requestSingleUpdate(LocationManager paramLocationManager, String paramString, LocationListener paramLocationListener, Looper paramLooper)
  {
    QLog.d("LocationMonitor", 1, "[requestSingleUpdate] (LSLL) invoke");
    InvokeMonitor.onMethodInvoke("LocationMonitor.requestSingleUpdate(LSLL)", "requestSingleUpdate(LSLL)", "");
    paramLocationManager.requestSingleUpdate(paramString, paramLocationListener, paramLooper);
    processBackgroundRequestLocation("LocationMonitor.requestSingleUpdate(LSLL)", "requestSingleUpdate(LSLL)", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qmethodmonitor.monitor.LocationMonitor
 * JD-Core Version:    0.7.0.1
 */