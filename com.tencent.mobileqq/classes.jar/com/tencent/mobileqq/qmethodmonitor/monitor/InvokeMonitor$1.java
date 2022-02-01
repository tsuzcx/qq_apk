package com.tencent.mobileqq.qmethodmonitor.monitor;

import com.tencent.mobileqq.statistics.QQBeaconReport;
import java.util.Map;
import java.util.TreeMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

final class InvokeMonitor$1
  implements Runnable
{
  InvokeMonitor$1(String paramString1, int paramInt, String paramString2) {}
  
  public void run()
  {
    TreeMap localTreeMap = new TreeMap();
    localTreeMap.put("sub_key_stack_string", this.a);
    localTreeMap.put("sub_key_invoke_times", String.valueOf(this.b));
    localTreeMap.put("sub_key_api", this.c);
    Object localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (localObject != null) {
      localObject = ((AppRuntime)localObject).getCurrentUin();
    } else {
      localObject = "0";
    }
    QQBeaconReport.a((String)localObject, "privacy_bg_location_invoke", localTreeMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qmethodmonitor.monitor.InvokeMonitor.1
 * JD-Core Version:    0.7.0.1
 */