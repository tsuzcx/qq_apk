package com.tencent.rmonitor.memory.leakdetect;

import com.tencent.rmonitor.base.meta.BaseInfo;
import com.tencent.rmonitor.base.meta.UserMeta;
import com.tencent.rmonitor.base.reporter.ReporterMachine;
import com.tencent.rmonitor.base.reporter.data.ReportData;
import com.tencent.rmonitor.common.util.AppInfo;
import org.json.JSONObject;

public class MemoryLeakReporter
{
  public ReportData a(String paramString1, String paramString2, String paramString3)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("processname", AppInfo.a(BaseInfo.app));
    localJSONObject.put("event_time", System.currentTimeMillis());
    localJSONObject.put("stage", paramString1);
    localJSONObject.put("uuid", paramString2);
    localJSONObject.put("fileObj", paramString3);
    localJSONObject.put("plugin", 107);
    paramString1 = new ReportData(0, "MemoryLeak single", true, 1L, 1L, localJSONObject, true, true, BaseInfo.userMeta.uin);
    ReporterMachine.a.a(paramString1, null, false);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.memory.leakdetect.MemoryLeakReporter
 * JD-Core Version:    0.7.0.1
 */