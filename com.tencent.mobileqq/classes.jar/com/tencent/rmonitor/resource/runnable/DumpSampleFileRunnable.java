package com.tencent.rmonitor.resource.runnable;

import android.support.annotation.NonNull;
import com.tencent.rmonitor.base.meta.BaseInfo;
import com.tencent.rmonitor.base.meta.UserMeta;
import com.tencent.rmonitor.base.plugin.monitor.PluginController;
import com.tencent.rmonitor.base.reporter.ReporterMachine;
import com.tencent.rmonitor.base.reporter.data.ReportData;
import com.tencent.rmonitor.common.json.JsonDispose;
import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.rmonitor.common.util.AppInfo;
import com.tencent.rmonitor.common.util.FileUtil;
import com.tencent.rmonitor.resource.ResourceMonitor;
import com.tencent.rmonitor.resource.collector.IPerfItemCollector;
import com.tencent.rmonitor.resource.collector.ITagItemCollector;
import com.tencent.rmonitor.resource.meta.PerfItem;
import com.tencent.rmonitor.resource.meta.TagItem;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONObject;

public class DumpSampleFileRunnable
  implements Runnable
{
  private static volatile DumpSampleFileRunnable a;
  private static final String b;
  private final String c;
  private SimpleDateFormat d = null;
  private long e = 0L;
  private boolean f = false;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("APM_Resource_");
    localStringBuilder.append(BaseInfo.userMeta.appId);
    localStringBuilder.append("_");
    b = localStringBuilder.toString();
  }
  
  private DumpSampleFileRunnable()
  {
    if (BaseInfo.app != null)
    {
      this.c = AppInfo.a(BaseInfo.app);
      return;
    }
    this.c = "default";
  }
  
  public static DumpSampleFileRunnable a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new DumpSampleFileRunnable();
        }
      }
      finally {}
    }
    return a;
  }
  
  private void a(PerfItem paramPerfItem, JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = new JSONObject();
    if ((!Double.isNaN(paramPerfItem.temperature)) && (paramPerfItem.temperature > -100.0D)) {
      localJSONObject.put("temperature", paramPerfItem.temperature);
    }
    if (9223372036854775807L != paramPerfItem.fps) {
      localJSONObject.put("fps", paramPerfItem.fps);
    }
    if (localJSONObject.length() > 0) {
      paramJSONObject.put("extra", localJSONObject);
    }
  }
  
  private void a(TagItem paramTagItem, JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = new JSONObject();
    if (9223372036854775807L != paramTagItem.ioCount) {
      localJSONObject.put("io_cnt", paramTagItem.ioCount);
    }
    if (9223372036854775807L != paramTagItem.ioBytes) {
      localJSONObject.put("io_sz", paramTagItem.ioBytes);
    }
    if (localJSONObject.length() > 0) {
      paramJSONObject.put("io", localJSONObject);
    }
    localJSONObject = new JSONObject();
    if (9223372036854775807L != paramTagItem.netFlowPackets) {
      localJSONObject.put("net_packets", paramTagItem.netFlowPackets);
    }
    if (9223372036854775807L != paramTagItem.netFlowReceiveBytes) {
      localJSONObject.put("net_recv", paramTagItem.netFlowReceiveBytes);
    }
    if (9223372036854775807L != paramTagItem.netFlowSendBytes) {
      localJSONObject.put("net_send", paramTagItem.netFlowSendBytes);
    }
    if (localJSONObject.length() > 0) {
      paramJSONObject.put("network", localJSONObject);
    }
    if (9223372036854775807L != paramTagItem.fps) {
      paramJSONObject.put("fps", new JSONObject().put("fps", paramTagItem.fps));
    }
  }
  
  private void a(String paramString, @NonNull JSONObject paramJSONObject)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(FileUtil.e());
      localStringBuilder.append("/");
      localStringBuilder.append(paramString);
      FileUtil.a(localStringBuilder.toString(), paramJSONObject.toString(), false);
      return;
    }
    catch (Throwable paramString)
    {
      Logger.b.a("RMonitor_resource_DumpSampleFileRunnable", paramString);
      return;
    }
    catch (OutOfMemoryError paramString)
    {
      Logger.b.a("RMonitor_resource_DumpSampleFileRunnable", paramString);
    }
  }
  
  private JSONArray b(Vector<TagItem> paramVector)
  {
    JSONArray localJSONArray = new JSONArray();
    for (;;)
    {
      try
      {
        paramVector = paramVector.iterator();
        if (paramVector.hasNext())
        {
          TagItem localTagItem = (TagItem)paramVector.next();
          if ((Double.isNaN(localTagItem.eventTime)) || (localTagItem.tagId == 9223372036854775807L)) {
            continue;
          }
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("event_time", localTagItem.eventTime);
          localJSONObject.put("tag_id", localTagItem.tagId);
          if (!Double.isNaN(localTagItem.duringTime)) {
            localJSONObject.put("during_time", localTagItem.duringTime);
          }
          localJSONObject.put("type", localTagItem.type);
          localJSONObject.put("stage", localTagItem.stage);
          localJSONObject.put("sub_stage", localTagItem.subStage);
          localJSONObject.put("extra_info", localTagItem.extraInfo);
          localJSONObject.put("process_name", this.c);
          if (localTagItem.isSlow)
          {
            i = 1;
            localJSONObject.put("is_slow", i);
            if (localTagItem.type == 1) {
              a(localTagItem, localJSONObject);
            }
            localJSONArray.put(localJSONObject);
          }
        }
        else
        {
          return localJSONArray;
        }
      }
      catch (Exception paramVector)
      {
        Logger.b.a("RMonitor_resource_DumpSampleFileRunnable", paramVector);
      }
      int i = 0;
    }
  }
  
  private void b()
  {
    Object localObject1 = FileUtil.e();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(b);
    ((StringBuilder)localObject2).append(".*");
    localObject1 = FileUtil.a((String)localObject1, ((StringBuilder)localObject2).toString());
    if ((localObject1 != null) && (((ArrayList)localObject1).size() != 0))
    {
      Collections.sort((List)localObject1, new DumpSampleFileRunnable.1(this));
      if (((ArrayList)localObject1).size() > 10)
      {
        localObject2 = ((ArrayList)localObject1).subList(10, ((ArrayList)localObject1).size()).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          File localFile = (File)((Iterator)localObject2).next();
          if (!localFile.delete())
          {
            Logger localLogger = Logger.b;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("reportDumpFile, del file: ");
            localStringBuilder.append(localFile.getAbsolutePath());
            localStringBuilder.append(" fail");
            localLogger.e(new String[] { "RMonitor_resource_DumpSampleFileRunnable", localStringBuilder.toString() });
          }
        }
      }
      new ReportDumpFileTask(((ArrayList)localObject1).subList(0, Math.min(((ArrayList)localObject1).size(), 3))).b();
      this.f = false;
      return;
    }
    this.f = false;
  }
  
  private void b(PerfItem paramPerfItem, JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = new JSONObject();
    if (9223372036854775807L != paramPerfItem.netFlowPackets) {
      localJSONObject.put("net_packets", paramPerfItem.netFlowPackets);
    }
    if (9223372036854775807L != paramPerfItem.netFlowReceiverBytes) {
      localJSONObject.put("net_recv", paramPerfItem.netFlowReceiverBytes);
    }
    if (9223372036854775807L != paramPerfItem.netFlowSendBytes) {
      localJSONObject.put("net_send", paramPerfItem.netFlowSendBytes);
    }
    if (localJSONObject.length() > 0) {
      paramJSONObject.put("network", localJSONObject);
    }
  }
  
  private void c(PerfItem paramPerfItem, JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = new JSONObject();
    if (9223372036854775807L != paramPerfItem.ioCount) {
      localJSONObject.put("io_cnt", paramPerfItem.ioCount);
    }
    if (9223372036854775807L != paramPerfItem.ioBytes) {
      localJSONObject.put("io_sz", paramPerfItem.ioBytes);
    }
    if (localJSONObject.length() > 0) {
      paramJSONObject.put("io", localJSONObject);
    }
  }
  
  private void d(PerfItem paramPerfItem, JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = new JSONObject();
    if (9223372036854775807L != paramPerfItem.memory) {
      localJSONObject.put("mem_used", paramPerfItem.memory);
    }
    if (9223372036854775807L != paramPerfItem.gcCount) {
      localJSONObject.put("gc_cnt", paramPerfItem.gcCount);
    }
    if (localJSONObject.length() > 0) {
      paramJSONObject.put("memory", localJSONObject);
    }
  }
  
  private void e(PerfItem paramPerfItem, JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = new JSONObject();
    if (9223372036854775807L != paramPerfItem.cpuJiffies) {
      localJSONObject.put("app_jiffies", paramPerfItem.cpuJiffies);
    }
    if (9223372036854775807L != paramPerfItem.cpuSysJiffies) {
      localJSONObject.put("sys_jiffies", paramPerfItem.cpuSysJiffies);
    }
    if (9223372036854775807L != paramPerfItem.thread) {
      localJSONObject.put("thread_num", paramPerfItem.thread);
    }
    if (!Double.isNaN(paramPerfItem.cpuRate)) {
      localJSONObject.put("cpu_rate", paramPerfItem.cpuRate);
    }
    if (!Double.isNaN(paramPerfItem.sysCpuRate)) {
      localJSONObject.put("sys_cpu_rate", paramPerfItem.sysCpuRate);
    }
    if (localJSONObject.length() > 0) {
      paramJSONObject.put("cpu", localJSONObject);
    }
  }
  
  public JSONArray a(Vector<PerfItem> paramVector)
  {
    localJSONArray = new JSONArray();
    try
    {
      paramVector = paramVector.iterator();
      while (paramVector.hasNext())
      {
        PerfItem localPerfItem = (PerfItem)paramVector.next();
        if (!Double.isNaN(localPerfItem.eventTime))
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("event_time", localPerfItem.eventTime);
          localJSONObject.put("process_name", this.c);
          localJSONObject.put("stage", localPerfItem.stage);
          localJSONObject.put("sub_stage", "");
          localJSONObject.put("extra_info", localPerfItem.extraInfo);
          e(localPerfItem, localJSONObject);
          d(localPerfItem, localJSONObject);
          c(localPerfItem, localJSONObject);
          b(localPerfItem, localJSONObject);
          a(localPerfItem, localJSONObject);
          localJSONArray.put(localJSONObject);
        }
      }
      return localJSONArray;
    }
    catch (Exception paramVector)
    {
      Logger.b.a("RMonitor_resource_DumpSampleFileRunnable", paramVector);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public void run()
  {
    long l = System.currentTimeMillis();
    if (l - this.e < 5000L) {
      return;
    }
    Object localObject2 = ResourceMonitor.getInstance().b();
    Object localObject1 = ResourceMonitor.getInstance().c();
    if ((((ITagItemCollector)localObject2).c() < 10) && (((IPerfItemCollector)localObject1).e() < 10)) {
      return;
    }
    this.e = l;
    try
    {
      localObject1 = a(((IPerfItemCollector)localObject1).f());
      localObject2 = b(((ITagItemCollector)localObject2).d());
      JSONObject localJSONObject = new JSONObject();
      localJSONObject = JsonDispose.a(BaseInfo.pubJson, localJSONObject);
      localJSONObject.put("plugin", 138);
      localJSONObject.put("zone", "default");
      localJSONObject.put("immediates", localObject1);
      localJSONObject.put("manu_tags", localObject2);
      if ((this.f) && (PluginController.b.d(138)))
      {
        localObject1 = new ReportData(0, "Resource target", true, 1L, 1L, localJSONObject, true, false, BaseInfo.userMeta.uin);
        ReporterMachine.a.a((ReportData)localObject1);
        b();
        return;
      }
      if (this.d == null) {
        this.d = new SimpleDateFormat("yyyyMMddhhmmss", Locale.CHINA);
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(b);
      ((StringBuilder)localObject1).append(this.d.format(new Date()));
      a(((StringBuilder)localObject1).toString(), localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      Logger.b.a("RMonitor_resource_DumpSampleFileRunnable", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.resource.runnable.DumpSampleFileRunnable
 * JD-Core Version:    0.7.0.1
 */