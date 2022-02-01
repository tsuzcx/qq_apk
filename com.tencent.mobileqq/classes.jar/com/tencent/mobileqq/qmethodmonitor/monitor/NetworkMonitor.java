package com.tencent.mobileqq.qmethodmonitor.monitor;

import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.tencent.qphone.base.util.QLog;
import java.net.NetworkInterface;
import java.util.Enumeration;

public class NetworkMonitor
{
  public static final String TAG = "NetworkMonitor";
  public static final int THRESHOLD = 30;
  public static final int TIMEOUT = 10000;
  
  public static WifiInfo getConnectionInfo(WifiManager paramWifiManager)
  {
    QLog.d("NetworkMonitor", 1, "[getConnectionInfo] invoke");
    InvokeMonitor.onMethodInvoke("NetworkMonitor.getConnectionInfo", "getConnectionInfo", "");
    return paramWifiManager.getConnectionInfo();
  }
  
  public static Enumeration<NetworkInterface> getNetworkInterfaces()
  {
    QLog.d("NetworkMonitor", 1, "[getNetworkInterfaces] invoke");
    InvokeMonitor.onMethodInvoke("NetworkMonitor.getNetworkInterfaces", "getNetworkInterfaces", "");
    return NetworkInterface.getNetworkInterfaces();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qmethodmonitor.monitor.NetworkMonitor
 * JD-Core Version:    0.7.0.1
 */