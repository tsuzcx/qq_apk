package com.tencent.qqperf.monitor.battery;

import android.app.PendingIntent;
import android.location.Criteria;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Looper;
import com.tencent.mobileqq.javahooksdk.JavaHookBridge;
import com.tencent.qapmsdk.qqbattery.QQBatteryMonitor;
import com.tencent.qapmsdk.qqbattery.monitor.HookMethodCallback;
import com.tencent.qphone.base.util.QLog;

class GPS
  extends HookItem
{
  public HookMethodCallback a()
  {
    return QQBatteryMonitor.getInstance().getGpsHook();
  }
  
  public void a()
  {
    try
    {
      JavaHookBridge.findAndHookMethod(LocationManager.class, "requestLocationUpdates", new Object[] { String.class, Long.TYPE, Float.TYPE, LocationListener.class, this });
      JavaHookBridge.findAndHookMethod(LocationManager.class, "requestLocationUpdates", new Object[] { String.class, Long.TYPE, Float.TYPE, LocationListener.class, Looper.class, this });
      JavaHookBridge.findAndHookMethod(LocationManager.class, "requestLocationUpdates", new Object[] { String.class, Long.TYPE, Float.TYPE, PendingIntent.class, this });
      JavaHookBridge.findAndHookMethod(LocationManager.class, "requestLocationUpdates", new Object[] { Long.TYPE, Float.TYPE, Criteria.class, LocationListener.class, Looper.class, this });
      JavaHookBridge.findAndHookMethod(LocationManager.class, "requestLocationUpdates", new Object[] { Long.TYPE, Float.TYPE, Criteria.class, PendingIntent.class, this });
      JavaHookBridge.findAndHookMethod(LocationManager.class, "requestSingleUpdate", new Object[] { String.class, PendingIntent.class, this });
      JavaHookBridge.findAndHookMethod(LocationManager.class, "requestSingleUpdate", new Object[] { String.class, LocationListener.class, Looper.class, this });
      JavaHookBridge.findAndHookMethod(LocationManager.class, "requestSingleUpdate", new Object[] { Criteria.class, LocationListener.class, Looper.class, this });
      JavaHookBridge.findAndHookMethod(LocationManager.class, "requestSingleUpdate", new Object[] { Criteria.class, PendingIntent.class, this });
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("MagnifierSDK.QAPM.QAPMBatteryWrapper", 2, "", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqperf.monitor.battery.GPS
 * JD-Core Version:    0.7.0.1
 */