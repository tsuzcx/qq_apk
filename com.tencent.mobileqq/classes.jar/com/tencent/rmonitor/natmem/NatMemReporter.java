package com.tencent.rmonitor.natmem;

import android.util.Pair;
import com.tencent.rmonitor.base.config.data.NatMemPluginConfig;
import com.tencent.rmonitor.base.meta.BaseInfo;
import com.tencent.rmonitor.base.meta.UserMeta;
import com.tencent.rmonitor.base.plugin.monitor.PluginController;
import com.tencent.rmonitor.base.reporter.ReporterMachine;
import com.tencent.rmonitor.base.reporter.data.ReportData;
import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.rmonitor.common.util.AppInfo;
import com.tencent.rmonitor.memory.MemoryUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class NatMemReporter
{
  static void a(int paramInt)
  {
    if (!PluginController.b.b(154)) {
      return;
    }
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("event", "native_ceil");
      ((JSONObject)localObject).put("process_name", AppInfo.a(BaseInfo.app));
      ((JSONObject)localObject).put("plugin", 154);
      if (paramInt == 1) {
        ((JSONObject)localObject).put("memory_type", "vmsize");
      } else if (paramInt == 2) {
        ((JSONObject)localObject).put("memory_type", "physical");
      }
      localObject = new ReportData(0, "NatMemoryCelling", true, 1L, 1L, (JSONObject)localObject, true, false, BaseInfo.userMeta.uin);
      ReporterMachine.a.b((ReportData)localObject, new NatMemReporter.2());
      return;
    }
    catch (JSONException localJSONException)
    {
      Logger.b.a("NatMem", localJSONException);
    }
  }
  
  static void a(String paramString1, String paramString2, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramString1 != null) && (new File(paramString1).exists())) {
      localArrayList.add(paramString1);
    }
    if ((paramString2 != null) && (new File(paramString2).exists())) {
      localArrayList.add(paramString2);
    }
    paramString1 = MemoryUtils.a(localArrayList, "NatMem");
    if (!((Boolean)paramString1.first).booleanValue())
    {
      Logger.b.e(new String[] { "NatMem", "dump zip file failed!" });
      return;
    }
    try
    {
      paramString2 = new JSONObject();
      paramString2.put("fileObj", paramString1.second);
      paramString2.put("plugin", 154);
      paramString2.put("event", "native_ceil_detail");
      paramString2.put("process_name", AppInfo.a(BaseInfo.app));
      if (paramInt == 1) {
        paramString2.put("memory_type", "vmsize");
      } else if (paramInt == 2) {
        paramString2.put("memory_type", "physical");
      }
      paramString2.put("max_physical_pss", NatMemMonitor.getInstance().e().l());
      paramString2.put("max_vitural_vss", NatMemMonitor.getInstance().e().m());
      paramString2.put("sys_min_size", NatMemMonitor.getInstance().e().e());
      paramString2.put("enable_sys_hook", NatMemMonitor.getInstance().e().j());
      paramString2.put("sys_sample_factor", NatMemMonitor.getInstance().e().c());
      paramString2.put("app_min_size", NatMemMonitor.getInstance().e().f());
      paramString1 = new ReportData(0, "NatMemoryFile", true, 1L, 1L, paramString2, false, false, BaseInfo.userMeta.uin);
      ReporterMachine.a.b(paramString1, new NatMemReporter.1());
      return;
    }
    catch (JSONException paramString1)
    {
      Logger.b.a("NatMem", paramString1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.natmem.NatMemReporter
 * JD-Core Version:    0.7.0.1
 */