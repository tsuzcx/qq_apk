package com.tencent.mobileqq.perf.rmonitor.natmem;

import com.tencent.mobileqq.perf.rmonitor.config.QQRMonitorCfgBaseItem;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class QQRMonitorNatMemCfgItem
  extends QQRMonitorCfgBaseItem
{
  public boolean c;
  public int d;
  public int e;
  public long f;
  
  public static QQRMonitorNatMemCfgItem a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    QLog.d("QQRMonitorNatMemCfgItem", 2, new Object[] { "[config] parse: invoked. ", " natMemJson: ", paramJSONObject.toString() });
    try
    {
      Object localObject = new QQRMonitorNatMemCfgItem();
      try
      {
        ((QQRMonitorNatMemCfgItem)localObject).a = paramJSONObject.getBoolean("pluginSwitch");
        ((QQRMonitorNatMemCfgItem)localObject).b = paramJSONObject.getDouble("eventSampleRatio");
        ((QQRMonitorNatMemCfgItem)localObject).c = paramJSONObject.getBoolean("enableSysHookEnable");
        ((QQRMonitorNatMemCfgItem)localObject).d = paramJSONObject.getInt("sysMinSize");
        ((QQRMonitorNatMemCfgItem)localObject).e = paramJSONObject.getInt("appMinSize");
        ((QQRMonitorNatMemCfgItem)localObject).f = paramJSONObject.getLong("maxPhysicalPss");
        return localObject;
      }
      catch (Throwable localThrowable2)
      {
        paramJSONObject = (JSONObject)localObject;
        localObject = localThrowable2;
      }
      QLog.e("QQRMonitorNatMemCfgItem", 1, localThrowable1, new Object[0]);
    }
    catch (Throwable localThrowable1)
    {
      paramJSONObject = null;
    }
    return paramJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.perf.rmonitor.natmem.QQRMonitorNatMemCfgItem
 * JD-Core Version:    0.7.0.1
 */