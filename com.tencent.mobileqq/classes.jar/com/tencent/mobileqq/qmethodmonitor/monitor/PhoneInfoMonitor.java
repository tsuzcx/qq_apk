package com.tencent.mobileqq.qmethodmonitor.monitor;

import android.telephony.CellInfo;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class PhoneInfoMonitor
{
  public static final String TAG = "PhoneInfoMonitor";
  public static final int THRESHOLD = 20;
  public static final int TIMEOUT = 10000;
  
  public static List<CellInfo> getAllCellInfo(TelephonyManager paramTelephonyManager)
  {
    QLog.d("PhoneInfoMonitor", 1, "[getAllCellInfo] invoke");
    InvokeMonitor.onMethodInvoke("PhoneInfoMonitor.getAllCellInfo", "getAllCellInfo", "");
    return paramTelephonyManager.getAllCellInfo();
  }
  
  public static CellLocation getCellLocation(TelephonyManager paramTelephonyManager)
  {
    QLog.d("PhoneInfoMonitor", 1, "[getCellLocation] invoke");
    InvokeMonitor.onMethodInvoke("PhoneInfoMonitor.getCellLocation", "getCellLocation", "");
    return paramTelephonyManager.getCellLocation();
  }
  
  public static String getDeviceId(TelephonyManager paramTelephonyManager)
  {
    QLog.d("PhoneInfoMonitor", 1, "[getDeviceId] () invoke");
    InvokeMonitor.onMethodInvoke("PhoneInfoMonitor.getDeviceId", "getDeviceId", "");
    return paramTelephonyManager.getDeviceId();
  }
  
  public static String getDeviceId(TelephonyManager paramTelephonyManager, int paramInt)
  {
    QLog.d("PhoneInfoMonitor", 1, "[getDeviceId] (I) invoke");
    InvokeMonitor.onMethodInvoke("PhoneInfoMonitor.getDeviceId", "getDeviceId", "");
    return paramTelephonyManager.getDeviceId(paramInt);
  }
  
  public static String getImei(TelephonyManager paramTelephonyManager)
  {
    QLog.d("PhoneInfoMonitor", 1, "[getImei] () invoke");
    InvokeMonitor.onMethodInvoke("PhoneInfoMonitor.getImei", "getImei", "");
    return paramTelephonyManager.getImei();
  }
  
  public static String getImei(TelephonyManager paramTelephonyManager, int paramInt)
  {
    QLog.d("PhoneInfoMonitor", 1, "[getImei] (I) invoke");
    InvokeMonitor.onMethodInvoke("PhoneInfoMonitor.getImei", "getImei", "");
    return paramTelephonyManager.getImei(paramInt);
  }
  
  public static String getLine1Number(TelephonyManager paramTelephonyManager)
  {
    QLog.d("PhoneInfoMonitor", 1, "[getLine1Number] invoke");
    InvokeMonitor.onMethodInvoke("PhoneInfoMonitor.getLine1Number", "getLine1Number", "");
    return paramTelephonyManager.getLine1Number();
  }
  
  public static String getSimSerialNumber(TelephonyManager paramTelephonyManager)
  {
    QLog.d("PhoneInfoMonitor", 1, "[getSimSerialNumber] invoke");
    InvokeMonitor.onMethodInvoke("PhoneInfoMonitor.getSimSerialNumber", "getSimSerialNumber", "");
    return paramTelephonyManager.getSimSerialNumber();
  }
  
  public static String getSubscriberId(TelephonyManager paramTelephonyManager)
  {
    QLog.d("PhoneInfoMonitor", 1, "[getSubscriberId] invoke");
    InvokeMonitor.onMethodInvoke("PhoneInfoMonitor.getSubscriberId", "getSubscriberId", "");
    return paramTelephonyManager.getSubscriberId();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qmethodmonitor.monitor.PhoneInfoMonitor
 * JD-Core Version:    0.7.0.1
 */