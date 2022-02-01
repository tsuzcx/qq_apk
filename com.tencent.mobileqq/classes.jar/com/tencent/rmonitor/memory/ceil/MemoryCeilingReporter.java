package com.tencent.rmonitor.memory.ceil;

import android.os.Build;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import com.tencent.rmonitor.base.config.ConfigCenter;
import com.tencent.rmonitor.base.config.ConfigProxy;
import com.tencent.rmonitor.base.config.DefaultPluginConfig;
import com.tencent.rmonitor.base.config.data.RPluginConfig;
import com.tencent.rmonitor.base.meta.BaseInfo;
import com.tencent.rmonitor.base.meta.CustomMeta;
import com.tencent.rmonitor.base.meta.DumpResult;
import com.tencent.rmonitor.base.meta.IssueDetails;
import com.tencent.rmonitor.base.meta.UserMeta;
import com.tencent.rmonitor.base.plugin.listener.ICustomSetListener;
import com.tencent.rmonitor.base.plugin.listener.ListenerManager;
import com.tencent.rmonitor.base.plugin.listener.MonitorListenerMng;
import com.tencent.rmonitor.base.plugin.monitor.PluginController;
import com.tencent.rmonitor.base.reporter.ReporterMachine;
import com.tencent.rmonitor.base.reporter.data.ReportData;
import com.tencent.rmonitor.common.lifecycle.ActivityInfo;
import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.rmonitor.common.util.AppInfo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class MemoryCeilingReporter
{
  @NonNull
  private final HashMap<String, String> a = new HashMap();
  
  public ReportData a(long paramLong1, long paramLong2, String paramString)
  {
    if (!PluginController.b.b(109)) {
      return null;
    }
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("vcname", paramString);
      ((JSONObject)localObject).put("singleMemory", paramLong1);
      ((JSONObject)localObject).put("threshold", paramLong2);
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("processname", AppInfo.a(BaseInfo.app));
      localJSONObject.put("minidumpdata", localObject);
      localJSONObject.put("plugin", 109);
      if ((this.a != null) && (!this.a.isEmpty()))
      {
        localObject = this.a.keySet().iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          localJSONObject.put(str, this.a.get(str));
        }
      }
      localObject = (ICustomSetListener)ListenerManager.f.b();
      if ((paramLong1 != -1L) && (paramLong2 != -1L) && (localObject != null))
      {
        paramString = ((ICustomSetListener)localObject).onCustomFieldSet(new IssueDetails(128, paramString, null));
        localJSONObject.put("dimension1", paramString.getFirstCustomField());
        localJSONObject.put("dimension2", paramString.getSecondCustomField());
      }
      paramString = new ReportData(0, "MemoryCelling target", true, 1L, 1L, localJSONObject, true, true, BaseInfo.userMeta.uin);
      ReporterMachine.a.a(paramString, null, true);
      return paramString;
    }
    catch (JSONException paramString)
    {
      Logger.b.a("MemoryCeilReporter", paramString);
    }
    return null;
  }
  
  public void a()
  {
    a(-1L, -1L, "-1");
  }
  
  public void a(DumpResult paramDumpResult)
  {
    String str = ActivityInfo.a();
    if (!paramDumpResult.success)
    {
      Logger.b.e(new String[] { "MemoryCeilReporter", "dump other file failed!" });
      return;
    }
    try
    {
      Object localObject = ConfigProxy.INSTANCE.getConfig().b(108);
      long l = Runtime.getRuntime().maxMemory();
      l = ((DefaultPluginConfig)localObject).f.f * l / 100L;
      localObject = new JSONObject();
      ((JSONObject)localObject).put("fileObj", paramDumpResult.zipFilePath);
      ((JSONObject)localObject).put("stage", str);
      ((JSONObject)localObject).put("Activity", str);
      ((JSONObject)localObject).put("UIN", BaseInfo.userMeta.uin);
      ((JSONObject)localObject).put("Model", Build.MODEL);
      ((JSONObject)localObject).put("OS", Build.VERSION.RELEASE);
      ((JSONObject)localObject).put("Threshold", l);
      ((JSONObject)localObject).put("plugin", 108);
      paramDumpResult = new ReportData(0, "MemoryCelling single", true, 1L, 1L, (JSONObject)localObject, true, true, BaseInfo.userMeta.uin);
      ReporterMachine.a.a(paramDumpResult, null, true);
      return;
    }
    catch (JSONException paramDumpResult)
    {
      Logger.b.a("MemoryCeilReporter", paramDumpResult);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.memory.ceil.MemoryCeilingReporter
 * JD-Core Version:    0.7.0.1
 */