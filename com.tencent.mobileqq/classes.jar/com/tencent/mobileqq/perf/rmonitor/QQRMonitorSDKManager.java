package com.tencent.mobileqq.perf.rmonitor;

import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.cooperation.ApkUtils;
import com.tencent.mobileqq.perf.rmonitor.config.QQRMonitorCfgUpdater;
import com.tencent.mobileqq.perf.rmonitor.config.QQRMonitorConfig;
import com.tencent.mobileqq.perf.rmonitor.config.QQRMonitorConfigBean;
import com.tencent.mobileqq.perf.rmonitor.natmem.QQRMonitorNatMemCfgItem;
import com.tencent.mobileqq.perf.rmonitor.natmem.QQRMonitorNatMemListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.RMonitor;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;

public class QQRMonitorSDKManager
{
  public static QQRMonitorConfig a;
  public static long b = 0L;
  private static String c = "edf7897a-900035564";
  private static String d = "https://rmonitor.qq.com";
  private static AtomicBoolean e = new AtomicBoolean(false);
  
  public static void a()
  {
    QQRMonitorConfigBean localQQRMonitorConfigBean = (QQRMonitorConfigBean)QConfigManager.b().b(768);
    if (localQQRMonitorConfigBean == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQRMonitorSDKManager", 2, "loadConfig, cfgBean is null ! ");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQRMonitorSDKManager", 2, "loadConfig,  set official cfg. ");
    }
    a = localQQRMonitorConfigBean.a;
  }
  
  public static void a(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setUin ");
    localStringBuilder.append(paramLong);
    QLog.i("QQRMonitorSDKManager", 1, localStringBuilder.toString());
    b = paramLong;
    RMonitor.setProperty(102, String.valueOf(paramLong));
  }
  
  private static void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQRMonitorSDKManager", 2, "configRMonitor.");
    }
    int i = RMonitor.f;
    if (QLog.isColorLevel()) {
      i = RMonitor.g;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("8.8.17.");
    ((StringBuilder)localObject).append(ApkUtils.a(MobileQQ.getContext()));
    localObject = ((StringBuilder)localObject).toString();
    RMonitor.setProperty(107, MobileQQ.getContext());
    RMonitor.setProperty(101, c);
    RMonitor.setProperty(103, (String)localObject);
    RMonitor.setProperty(104, Integer.valueOf(i));
    if (b > 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQRMonitorSDKManager", 2, "configRMonitor, uin > 0");
      }
      RMonitor.setProperty(102, String.valueOf(b));
    }
    RMonitor.setProperty(105, d);
  }
  
  private static void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQRMonitorSDKManager", 2, "setConfigUpdater.");
    }
    RMonitor.addProperty(200, new QQRMonitorCfgUpdater());
  }
  
  private static void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQRMonitorSDKManager", 2, "setPluginListeners.");
    }
    RMonitor.addProperty(209, new QQRMonitorNatMemListener());
  }
  
  private static void j()
  {
    QQRMonitorConfig localQQRMonitorConfig = a;
    if ((localQQRMonitorConfig != null) && (localQQRMonitorConfig.b != null) && (a.b.a))
    {
      QLog.i("QQRMonitorSDKManager", 1, "startRMonitors, start RMonitor.MODE_NAT_MEM");
      RMonitor.startMonitors(2097152);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.perf.rmonitor.QQRMonitorSDKManager
 * JD-Core Version:    0.7.0.1
 */