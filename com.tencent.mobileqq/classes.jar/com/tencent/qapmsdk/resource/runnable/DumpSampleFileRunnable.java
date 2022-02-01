package com.tencent.qapmsdk.resource.runnable;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qapmsdk.base.config.DefaultPluginConfig;
import com.tencent.qapmsdk.base.config.PluginCombination;
import com.tencent.qapmsdk.base.meta.BaseInfo;
import com.tencent.qapmsdk.base.meta.UserMeta;
import com.tencent.qapmsdk.base.reporter.ReporterMachine;
import com.tencent.qapmsdk.base.reporter.uploaddata.data.ResultObject;
import com.tencent.qapmsdk.common.json.JsonDispose;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.common.util.AppInfo;
import com.tencent.qapmsdk.common.util.FileUtil;
import com.tencent.qapmsdk.resource.ResourceMonitor;
import com.tencent.qapmsdk.resource.meta.PerfItem;
import com.tencent.qapmsdk.resource.meta.TagItem;
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
  private static final String FILE_TEMPLATE_NAME = "APM_Resource_" + BaseInfo.userMeta.appId + "_";
  private static final int MIN_RESOURCE_ITEM = 10;
  private static final int MIN_TEMPERATURE = -100;
  private static final String TAG = "QAPM_resource_DumpSampleFileRunnable";
  private static final int TIME_TOLERANCE = 5000;
  private static volatile Iterator<File> fileIterator;
  @Nullable
  private static volatile DumpSampleFileRunnable instance = null;
  private boolean canReport = false;
  @NonNull
  private SimpleDateFormat dateFormat = null;
  private long lastDumpFileTime = 0L;
  @Nullable
  private String processName;
  
  static
  {
    fileIterator = null;
  }
  
  private DumpSampleFileRunnable()
  {
    if (BaseInfo.app != null)
    {
      this.processName = AppInfo.obtainProcessName(BaseInfo.app);
      return;
    }
    this.processName = "default";
  }
  
  private JSONArray assembleImmediateDate(Vector<PerfItem> paramVector)
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
          JSONObject localJSONObject1 = new JSONObject();
          localJSONObject1.put("event_time", localPerfItem.eventTime);
          localJSONObject1.put("process_name", this.processName);
          localJSONObject1.put("stage", localPerfItem.stage);
          localJSONObject1.put("sub_stage", "");
          localJSONObject1.put("extra_info", localPerfItem.extraInfo);
          JSONObject localJSONObject2;
          if ((9223372036854775807L != localPerfItem.cpuJiffies) || (9223372036854775807L != localPerfItem.cpuSysJiffies) || (9223372036854775807L != localPerfItem.thread) || (!Double.isNaN(localPerfItem.cpuRate)) || (!Double.isNaN(localPerfItem.sysCpuRate)))
          {
            localJSONObject2 = new JSONObject();
            if (9223372036854775807L != localPerfItem.cpuJiffies) {
              localJSONObject2.put("app_jiffies", localPerfItem.cpuJiffies);
            }
            if (9223372036854775807L != localPerfItem.cpuSysJiffies) {
              localJSONObject2.put("sys_jiffies", localPerfItem.cpuSysJiffies);
            }
            if (9223372036854775807L != localPerfItem.thread) {
              localJSONObject2.put("thread_num", localPerfItem.thread);
            }
            if (!Double.isNaN(localPerfItem.cpuRate)) {
              localJSONObject2.put("cpu_rate", localPerfItem.cpuRate);
            }
            if (!Double.isNaN(localPerfItem.sysCpuRate)) {
              localJSONObject2.put("sys_cpu_rate", localPerfItem.sysCpuRate);
            }
            localJSONObject1.put("cpu", localJSONObject2);
          }
          if ((9223372036854775807L != localPerfItem.memory) || (9223372036854775807L != localPerfItem.gc))
          {
            localJSONObject2 = new JSONObject();
            if (9223372036854775807L != localPerfItem.memory) {
              localJSONObject2.put("mem_used", localPerfItem.memory);
            }
            localJSONObject1.put("memory", localJSONObject2);
          }
          if ((9223372036854775807L != localPerfItem.ioCount) || (9223372036854775807L != localPerfItem.ioBytes))
          {
            localJSONObject2 = new JSONObject();
            if (9223372036854775807L != localPerfItem.ioCount) {
              localJSONObject2.put("io_cnt", localPerfItem.ioCount);
            }
            if (9223372036854775807L != localPerfItem.ioBytes) {
              localJSONObject2.put("io_sz", localPerfItem.ioBytes);
            }
            localJSONObject1.put("io", localJSONObject2);
          }
          if ((9223372036854775807L != localPerfItem.netFlowPackets) || (9223372036854775807L != localPerfItem.netFlowReceiverBytes) || (9223372036854775807L != localPerfItem.netFlowSendBytes))
          {
            localJSONObject2 = new JSONObject();
            if (9223372036854775807L != localPerfItem.netFlowPackets) {
              localJSONObject2.put("net_packets", localPerfItem.netFlowPackets);
            }
            if (9223372036854775807L != localPerfItem.netFlowReceiverBytes) {
              localJSONObject2.put("net_recv", localPerfItem.netFlowReceiverBytes);
            }
            if (9223372036854775807L != localPerfItem.netFlowSendBytes) {
              localJSONObject2.put("net_send", localPerfItem.netFlowSendBytes);
            }
            localJSONObject1.put("network", localJSONObject2);
          }
          if ((!Double.isNaN(localPerfItem.temperature)) && (localPerfItem.temperature > -100.0D))
          {
            localJSONObject2 = new JSONObject();
            localJSONObject2.put("temperature", localPerfItem.temperature);
            localJSONObject1.put("extra", localJSONObject2);
          }
          localJSONArray.put(localJSONObject1);
        }
      }
      return localJSONArray;
    }
    catch (Exception paramVector)
    {
      Logger.INSTANCE.exception("QAPM_resource_DumpSampleFileRunnable", paramVector);
    }
  }
  
  private JSONArray assembleManualDate(Vector<TagItem> paramVector)
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
          JSONObject localJSONObject1 = new JSONObject();
          localJSONObject1.put("event_time", localTagItem.eventTime);
          localJSONObject1.put("tag_id", localTagItem.tagId);
          if (!Double.isNaN(localTagItem.duringTime)) {
            localJSONObject1.put("during_time", localTagItem.duringTime);
          }
          localJSONObject1.put("type", localTagItem.type);
          localJSONObject1.put("stage", localTagItem.stage);
          localJSONObject1.put("sub_stage", localTagItem.subStage);
          localJSONObject1.put("extra_info", localTagItem.extraInfo);
          localJSONObject1.put("process_name", this.processName);
          if (localTagItem.isSlow)
          {
            i = 1;
            localJSONObject1.put("is_slow", i);
            if (localTagItem.type == 1)
            {
              JSONObject localJSONObject2;
              if ((9223372036854775807L != localTagItem.ioCount) || (9223372036854775807L != localTagItem.ioBytes))
              {
                localJSONObject2 = new JSONObject();
                if (9223372036854775807L != localTagItem.ioCount) {
                  localJSONObject2.put("io_cnt", localTagItem.ioCount);
                }
                if (9223372036854775807L != localTagItem.ioBytes) {
                  localJSONObject2.put("io_sz", localTagItem.ioBytes);
                }
                localJSONObject1.put("io", localJSONObject2);
              }
              if ((9223372036854775807L != localTagItem.netFlowPackets) || (9223372036854775807L != localTagItem.netFlowRecvBytes) || (9223372036854775807L != localTagItem.netFlowSendBytes))
              {
                localJSONObject2 = new JSONObject();
                if (9223372036854775807L != localTagItem.netFlowPackets) {
                  localJSONObject2.put("net_packets", localTagItem.netFlowPackets);
                }
                if (9223372036854775807L != localTagItem.netFlowRecvBytes) {
                  localJSONObject2.put("net_recv", localTagItem.netFlowRecvBytes);
                }
                if (9223372036854775807L != localTagItem.netFlowSendBytes) {
                  localJSONObject2.put("net_send", localTagItem.netFlowSendBytes);
                }
                localJSONObject1.put("network", localJSONObject2);
              }
            }
            localJSONArray.put(localJSONObject1);
          }
        }
        else
        {
          return localJSONArray;
        }
      }
      catch (Exception paramVector)
      {
        Logger.INSTANCE.exception("QAPM_resource_DumpSampleFileRunnable", paramVector);
      }
      int i = 0;
    }
  }
  
  private void flushFile(String paramString, @NonNull JSONObject paramJSONObject)
  {
    try
    {
      FileUtil.writeFile(FileUtil.getRootPath() + "/" + paramString, paramJSONObject.toString(), false);
      return;
    }
    catch (OutOfMemoryError paramString)
    {
      Logger.INSTANCE.exception("QAPM_resource_DumpSampleFileRunnable", paramString);
    }
  }
  
  @Nullable
  public static DumpSampleFileRunnable getInstance()
  {
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new DumpSampleFileRunnable();
      }
      return instance;
    }
    finally {}
  }
  
  private void reportDumpFile()
  {
    ArrayList localArrayList = FileUtil.getFiles(FileUtil.getRootPath(), FILE_TEMPLATE_NAME + ".*");
    if ((localArrayList == null) || (localArrayList.size() == 0))
    {
      this.canReport = false;
      return;
    }
    Collections.sort(localArrayList, new DumpSampleFileRunnable.1(this));
    if (fileIterator == null)
    {
      if (localArrayList.size() > 10)
      {
        Iterator localIterator = localArrayList.subList(10, localArrayList.size()).iterator();
        while (localIterator.hasNext()) {
          ((File)localIterator.next()).delete();
        }
      }
      fileIterator = localArrayList.iterator();
      reportDumpFile(localArrayList.iterator(), 3);
    }
    this.canReport = false;
  }
  
  private void reportDumpFile(Iterator<File> paramIterator, int paramInt)
  {
    if (paramInt <= 0)
    {
      fileIterator = null;
      return;
    }
    if (paramIterator.hasNext())
    {
      File localFile = (File)paramIterator.next();
      try
      {
        ResultObject localResultObject = new ResultObject(0, "Resource target", true, 1L, 1L, new JSONObject(FileUtil.readOutputFromFile(localFile.getAbsolutePath())), true, false, BaseInfo.userMeta.uin);
        ReporterMachine.INSTANCE.addResultObj(localResultObject, new DumpSampleFileRunnable.2(this, paramIterator, paramInt));
        return;
      }
      catch (Exception localException)
      {
        Logger.INSTANCE.exception("QAPM_resource_DumpSampleFileRunnable", "remainReportCount: " + paramInt, localException);
        reportDumpFile(paramIterator, paramInt);
        return;
      }
      finally
      {
        localFile.delete();
      }
    }
    fileIterator = null;
  }
  
  public void run()
  {
    long l = System.currentTimeMillis();
    if (l - this.lastDumpFileTime < 5000L) {}
    while ((ResourceMonitor.manualTagItems.size() < 10) && (ResourceMonitor.immediatePerfItems.size() < 10)) {
      return;
    }
    if (this.dateFormat == null) {
      this.dateFormat = new SimpleDateFormat("yyyyMMddhhmmss", Locale.CHINA);
    }
    this.lastDumpFileTime = l;
    Object localObject = FILE_TEMPLATE_NAME + this.dateFormat.format(new Date());
    Vector localVector1 = (Vector)ResourceMonitor.immediatePerfItems.clone();
    Vector localVector2 = (Vector)ResourceMonitor.manualTagItems.clone();
    ResourceMonitor.immediatePerfItems.clear();
    ResourceMonitor.manualTagItems.clear();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject = JsonDispose.copyJson(BaseInfo.pubJson, localJSONObject);
      localJSONObject.put("plugin", PluginCombination.resourcePlugin.plugin);
      localJSONObject.put("zone", "default");
      localJSONObject.put("immediates", assembleImmediateDate(localVector1));
      localJSONObject.put("manu_tags", assembleManualDate(localVector2));
      if (this.canReport)
      {
        localObject = new ResultObject(0, "Resource target", true, 1L, 1L, localJSONObject, true, false, BaseInfo.userMeta.uin);
        ReporterMachine.INSTANCE.addResultObj((ResultObject)localObject);
        reportDumpFile();
        return;
      }
    }
    catch (Exception localException)
    {
      Logger.INSTANCE.exception("QAPM_resource_DumpSampleFileRunnable", localException);
      return;
    }
    flushFile(localException, localJSONObject);
  }
  
  public void setCanReport(boolean paramBoolean)
  {
    this.canReport = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.resource.runnable.DumpSampleFileRunnable
 * JD-Core Version:    0.7.0.1
 */