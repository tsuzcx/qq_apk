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
  private static final String FILE_TEMPLATE_NAME;
  private static final int MIN_RESOURCE_ITEM = 10;
  private static final int MIN_TEMPERATURE = -100;
  private static final String TAG = "QAPM_resource_DumpSampleFileRunnable";
  private static final int TIME_TOLERANCE = 5000;
  private static volatile Iterator<File> fileIterator;
  @Nullable
  private static volatile DumpSampleFileRunnable instance;
  private boolean canReport = false;
  @NonNull
  private SimpleDateFormat dateFormat = null;
  private long lastDumpFileTime = 0L;
  @Nullable
  private String processName;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("APM_Resource_");
    localStringBuilder.append(BaseInfo.userMeta.appId);
    localStringBuilder.append("_");
    FILE_TEMPLATE_NAME = localStringBuilder.toString();
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(FileUtil.getRootPath());
      localStringBuilder.append("/");
      localStringBuilder.append(paramString);
      FileUtil.writeFile(localStringBuilder.toString(), paramJSONObject.toString(), false);
      return;
    }
    catch (OutOfMemoryError paramString)
    {
      Logger.INSTANCE.exception("QAPM_resource_DumpSampleFileRunnable", paramString);
    }
  }
  
  public static DumpSampleFileRunnable getInstance()
  {
    if (instance == null) {
      try
      {
        if (instance == null) {
          instance = new DumpSampleFileRunnable();
        }
      }
      finally {}
    }
    return instance;
  }
  
  private void reportDumpFile()
  {
    Object localObject1 = FileUtil.getRootPath();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(FILE_TEMPLATE_NAME);
    ((StringBuilder)localObject2).append(".*");
    localObject1 = FileUtil.getFiles((String)localObject1, ((StringBuilder)localObject2).toString());
    if ((localObject1 != null) && (((ArrayList)localObject1).size() != 0))
    {
      Collections.sort((List)localObject1, new DumpSampleFileRunnable.1(this));
      if (fileIterator == null)
      {
        if (((ArrayList)localObject1).size() > 10)
        {
          localObject2 = ((ArrayList)localObject1).subList(10, ((ArrayList)localObject1).size()).iterator();
          while (((Iterator)localObject2).hasNext()) {
            ((File)((Iterator)localObject2).next()).delete();
          }
        }
        fileIterator = ((ArrayList)localObject1).iterator();
        reportDumpFile(((ArrayList)localObject1).iterator(), 3);
      }
      this.canReport = false;
      return;
    }
    this.canReport = false;
  }
  
  /* Error */
  private void reportDumpFile(Iterator<File> paramIterator, int paramInt)
  {
    // Byte code:
    //   0: iload_2
    //   1: ifgt +8 -> 9
    //   4: aconst_null
    //   5: putstatic 338	com/tencent/qapmsdk/resource/runnable/DumpSampleFileRunnable:fileIterator	Ljava/util/Iterator;
    //   8: return
    //   9: aload_1
    //   10: invokeinterface 114 1 0
    //   15: ifeq +150 -> 165
    //   18: aload_1
    //   19: invokeinterface 118 1 0
    //   24: checkcast 347	java/io/File
    //   27: astore 4
    //   29: new 353	com/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject
    //   32: dup
    //   33: iconst_0
    //   34: ldc_w 355
    //   37: iconst_1
    //   38: lconst_1
    //   39: lconst_1
    //   40: new 132	org/json/JSONObject
    //   43: dup
    //   44: aload 4
    //   46: invokevirtual 358	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   49: invokestatic 362	com/tencent/qapmsdk/common/util/FileUtil:readOutputFromFile	(Ljava/lang/String;)Ljava/lang/String;
    //   52: invokespecial 365	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   55: iconst_1
    //   56: iconst_0
    //   57: getstatic 51	com/tencent/qapmsdk/base/meta/BaseInfo:userMeta	Lcom/tencent/qapmsdk/base/meta/UserMeta;
    //   60: getfield 368	com/tencent/qapmsdk/base/meta/UserMeta:uin	Ljava/lang/String;
    //   63: invokespecial 371	com/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject:<init>	(ILjava/lang/String;ZJJLorg/json/JSONObject;ZZLjava/lang/String;)V
    //   66: astore_3
    //   67: getstatic 376	com/tencent/qapmsdk/base/reporter/ReporterMachine:INSTANCE	Lcom/tencent/qapmsdk/base/reporter/ReporterMachine;
    //   70: astore 5
    //   72: aload 5
    //   74: aload_3
    //   75: new 378	com/tencent/qapmsdk/resource/runnable/DumpSampleFileRunnable$2
    //   78: dup
    //   79: aload_0
    //   80: aload_1
    //   81: iload_2
    //   82: invokespecial 380	com/tencent/qapmsdk/resource/runnable/DumpSampleFileRunnable$2:<init>	(Lcom/tencent/qapmsdk/resource/runnable/DumpSampleFileRunnable;Ljava/util/Iterator;I)V
    //   85: invokevirtual 384	com/tencent/qapmsdk/base/reporter/ReporterMachine:addResultObj	(Lcom/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject;Lcom/tencent/qapmsdk/common/reporter/IReporter$ReportResultCallback;)V
    //   88: goto +61 -> 149
    //   91: astore_3
    //   92: goto +8 -> 100
    //   95: astore_1
    //   96: goto +61 -> 157
    //   99: astore_3
    //   100: getstatic 244	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   103: astore 5
    //   105: new 36	java/lang/StringBuilder
    //   108: dup
    //   109: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   112: astore 6
    //   114: aload 6
    //   116: ldc_w 386
    //   119: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: pop
    //   123: aload 6
    //   125: iload_2
    //   126: invokevirtual 59	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   129: pop
    //   130: aload 5
    //   132: ldc 16
    //   134: aload 6
    //   136: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   139: aload_3
    //   140: invokevirtual 389	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   143: aload_0
    //   144: aload_1
    //   145: iload_2
    //   146: invokespecial 95	com/tencent/qapmsdk/resource/runnable/DumpSampleFileRunnable:reportDumpFile	(Ljava/util/Iterator;I)V
    //   149: aload 4
    //   151: invokevirtual 350	java/io/File:delete	()Z
    //   154: pop
    //   155: return
    //   156: astore_1
    //   157: aload 4
    //   159: invokevirtual 350	java/io/File:delete	()Z
    //   162: pop
    //   163: aload_1
    //   164: athrow
    //   165: aconst_null
    //   166: putstatic 338	com/tencent/qapmsdk/resource/runnable/DumpSampleFileRunnable:fileIterator	Ljava/util/Iterator;
    //   169: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	170	0	this	DumpSampleFileRunnable
    //   0	170	1	paramIterator	Iterator<File>
    //   0	170	2	paramInt	int
    //   66	9	3	localResultObject	ResultObject
    //   91	1	3	localException1	Exception
    //   99	41	3	localException2	Exception
    //   27	131	4	localFile	File
    //   70	61	5	localObject	Object
    //   112	23	6	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   72	88	91	java/lang/Exception
    //   29	72	95	finally
    //   29	72	99	java/lang/Exception
    //   72	88	156	finally
    //   100	149	156	finally
  }
  
  public void run()
  {
    long l = System.currentTimeMillis();
    if (l - this.lastDumpFileTime < 5000L) {
      return;
    }
    if ((ResourceMonitor.manualTagItems.size() < 10) && (ResourceMonitor.immediatePerfItems.size() < 10)) {
      return;
    }
    if (this.dateFormat == null) {
      this.dateFormat = new SimpleDateFormat("yyyyMMddhhmmss", Locale.CHINA);
    }
    this.lastDumpFileTime = l;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(FILE_TEMPLATE_NAME);
    ((StringBuilder)localObject).append(this.dateFormat.format(new Date()));
    localObject = ((StringBuilder)localObject).toString();
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
      flushFile((String)localObject, localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      Logger.INSTANCE.exception("QAPM_resource_DumpSampleFileRunnable", localException);
    }
  }
  
  public void setCanReport(boolean paramBoolean)
  {
    this.canReport = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.resource.runnable.DumpSampleFileRunnable
 * JD-Core Version:    0.7.0.1
 */