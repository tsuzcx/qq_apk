package com.tencent.mobileqq.perf.rmonitor.config;

import com.tencent.mobileqq.perf.rmonitor.natmem.QQRMonitorNatMemCfgItem;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class QQRMonitorConfig
{
  public boolean a;
  public QQRMonitorNatMemCfgItem b;
  
  public static QQRMonitorConfig a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    QQRMonitorConfig localQQRMonitorConfig = new QQRMonitorConfig();
    QLog.d("QQRMonitorConfig", 2, new Object[] { "[config] parse: invoked. ", " cfgJson: ", paramJSONObject.toString() });
    try
    {
      localQQRMonitorConfig.a = paramJSONObject.getBoolean("mainSwitch");
      localQQRMonitorConfig.b = QQRMonitorNatMemCfgItem.a(paramJSONObject.getJSONObject("nativeMemConfig"));
      return localQQRMonitorConfig;
    }
    catch (Throwable paramJSONObject)
    {
      QLog.e("QQRMonitorConfig", 1, paramJSONObject, new Object[0]);
    }
    return localQQRMonitorConfig;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.perf.rmonitor.config.QQRMonitorConfig
 * JD-Core Version:    0.7.0.1
 */