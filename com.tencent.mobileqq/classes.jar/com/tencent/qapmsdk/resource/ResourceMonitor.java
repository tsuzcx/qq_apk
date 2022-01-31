package com.tencent.qapmsdk.resource;

import android.app.Application;
import android.os.Handler;
import android.os.Process;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qapmsdk.base.config.DefaultPluginConfig;
import com.tencent.qapmsdk.base.config.DefaultPluginConfig.ResourcePlugin.ResourceType;
import com.tencent.qapmsdk.base.config.PluginCombination;
import com.tencent.qapmsdk.base.config.RuntimeConfig;
import com.tencent.qapmsdk.base.config.SDKConfig;
import com.tencent.qapmsdk.base.listener.IMonitorListener;
import com.tencent.qapmsdk.base.listener.ListenerManager;
import com.tencent.qapmsdk.base.meta.BaseInfo;
import com.tencent.qapmsdk.base.meta.SceneMeta;
import com.tencent.qapmsdk.base.monitorplugin.PluginController;
import com.tencent.qapmsdk.base.monitorplugin.QAPMMonitorPlugin;
import com.tencent.qapmsdk.common.activty.LifecycleCallback;
import com.tencent.qapmsdk.common.device.DeviceMemory;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.common.resource.TemperatureCollector;
import com.tencent.qapmsdk.common.thread.ThreadManager;
import com.tencent.qapmsdk.resource.meta.NetFlow;
import com.tencent.qapmsdk.resource.meta.PerfItem;
import com.tencent.qapmsdk.resource.meta.StatInfo;
import com.tencent.qapmsdk.resource.meta.TagItem;
import com.tencent.qapmsdk.resource.reflect.ReflectIoModule;
import com.tencent.qapmsdk.resource.reflect.ReflectTraceModule;
import com.tencent.qapmsdk.resource.runnable.DumpSampleFileRunnable;
import com.tencent.qapmsdk.resource.runnable.MonitorRunnable;
import java.util.ArrayList;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

public class ResourceMonitor
  extends QAPMMonitorPlugin
{
  private static final String TAG = "QAPM_resource_PerfCollector";
  private static final double TIME_TOLERANCE = 5.0D;
  private static final double TIME_UNIT = 1000.0D;
  private static volatile String gExtraInfo = "";
  private static volatile String gStage;
  private static volatile boolean hasInit;
  @NonNull
  public static Vector<PerfItem> immediatePerfItems;
  @Nullable
  private static volatile PerfItem lastPerfItem = null;
  @NonNull
  public static Vector<TagItem> manualTagItems;
  private static long memPageSize;
  @Nullable
  private static volatile ResourceMonitor perfCollector = null;
  private static int pid = ;
  private DataCollector dataCollector = new DataCollector();
  private ReflectIoModule ioModule = new ReflectIoModule();
  private ConcurrentHashMap<String, TagItem> tagInfoCache = new ConcurrentHashMap();
  private ReflectTraceModule traceModule = new ReflectTraceModule();
  
  static
  {
    memPageSize = DeviceMemory.getScPageSize(0L);
    immediatePerfItems = new Vector(900);
    manualTagItems = new Vector(100);
    hasInit = false;
    gStage = "";
  }
  
  @Nullable
  public static ResourceMonitor getInstance()
  {
    if (perfCollector == null) {}
    try
    {
      if (perfCollector == null) {
        perfCollector = new ResourceMonitor();
      }
      return perfCollector;
    }
    finally {}
  }
  
  private void initializeItem(@NonNull PerfItem paramPerfItem)
  {
    lastPerfItem = new PerfItem();
    lastPerfItem.eventTime = paramPerfItem.eventTime;
    lastPerfItem.cpuJiffies = paramPerfItem.cpuJiffies;
    lastPerfItem.cpuSysJiffies = paramPerfItem.cpuSysJiffies;
    lastPerfItem.cpuSysUsedJiffies = paramPerfItem.cpuSysUsedJiffies;
    lastPerfItem.ioCount = 0L;
    lastPerfItem.ioBytes = 0L;
    paramPerfItem.cpuRate = 0.0D;
    paramPerfItem.sysCpuRate = 0.0D;
    paramPerfItem.netFlowPackets = 0L;
    paramPerfItem.netFlowReceiverBytes = 0L;
    paramPerfItem.netFlowSendBytes = 0L;
    paramPerfItem.ioCount = 0L;
    paramPerfItem.ioBytes = 0L;
  }
  
  private void registerForeBack()
  {
    LifecycleCallback.INSTANCE.register(new ResourceMonitor.1(this));
  }
  
  private void tidyCpuItem(@NonNull PerfItem paramPerfItem)
  {
    double d2 = 0.0D;
    double d1;
    if (lastPerfItem != null)
    {
      if ((lastPerfItem.cpuJiffies == 9223372036854775807L) || (lastPerfItem.cpuSysJiffies == 9223372036854775807L) || (lastPerfItem.cpuSysUsedJiffies == 9223372036854775807L)) {
        break label205;
      }
      long l1 = paramPerfItem.cpuJiffies;
      long l2 = lastPerfItem.cpuJiffies;
      long l3 = paramPerfItem.cpuSysJiffies - lastPerfItem.cpuSysJiffies;
      long l4 = paramPerfItem.cpuSysUsedJiffies;
      long l5 = lastPerfItem.cpuSysUsedJiffies;
      if (l3 > 0L)
      {
        paramPerfItem.cpuRate = ((l1 - l2) * 1.0D / l3);
        paramPerfItem.sysCpuRate = ((l4 - l5) * 1.0D / l3);
      }
      if (paramPerfItem.cpuRate <= 0.0D) {
        break label200;
      }
      d1 = paramPerfItem.cpuRate;
      paramPerfItem.cpuRate = d1;
      d1 = d2;
      if (paramPerfItem.sysCpuRate > 0.0D) {
        d1 = paramPerfItem.sysCpuRate;
      }
      paramPerfItem.sysCpuRate = d1;
    }
    for (;;)
    {
      lastPerfItem.cpuJiffies = paramPerfItem.cpuJiffies;
      lastPerfItem.cpuSysJiffies = paramPerfItem.cpuSysJiffies;
      lastPerfItem.cpuSysUsedJiffies = paramPerfItem.cpuSysUsedJiffies;
      return;
      label200:
      d1 = 0.0D;
      break;
      label205:
      ArrayList localArrayList = this.dataCollector.collectAppCpuByTop(pid);
      paramPerfItem.sysCpuRate = ((Double)localArrayList.get(0)).doubleValue();
      paramPerfItem.cpuRate = ((Double)localArrayList.get(1)).doubleValue();
    }
  }
  
  private void tidyIoItem(@NonNull PerfItem paramPerfItem)
  {
    long l2 = 0L;
    long[] arrayOfLong;
    if (lastPerfItem != null)
    {
      arrayOfLong = this.ioModule.getIoStatusProxy();
      if ((arrayOfLong != null) && (arrayOfLong.length == 2))
      {
        paramPerfItem.ioCount = (arrayOfLong[0] - lastPerfItem.ioCount);
        paramPerfItem.ioBytes = (arrayOfLong[1] - lastPerfItem.ioBytes);
        if (paramPerfItem.ioCount <= 0L) {
          break label122;
        }
      }
    }
    label122:
    for (long l1 = paramPerfItem.ioCount;; l1 = 0L)
    {
      paramPerfItem.ioCount = l1;
      l1 = l2;
      if (paramPerfItem.ioBytes > 0L) {
        l1 = paramPerfItem.ioBytes;
      }
      paramPerfItem.ioBytes = l1;
      lastPerfItem.ioCount = arrayOfLong[0];
      lastPerfItem.ioBytes = arrayOfLong[1];
      return;
    }
  }
  
  private void tidyNetFlowItem(@NonNull PerfItem paramPerfItem)
  {
    long l2 = 0L;
    NetFlow localNetFlow;
    if (lastPerfItem != null)
    {
      localNetFlow = this.dataCollector.collectorNetFollow();
      if ((9223372036854775807L != lastPerfItem.netFlowReceiverBytes) && (9223372036854775807L != lastPerfItem.netFlowSendBytes)) {
        break label106;
      }
      paramPerfItem.netFlowReceiverBytes = 0L;
      paramPerfItem.netFlowSendBytes = 0L;
      if ((9223372036854775807L != localNetFlow.rxPackets) && (9223372036854775807L != localNetFlow.txPackets)) {
        break label189;
      }
    }
    for (paramPerfItem.netFlowPackets = 0L;; lastPerfItem.netFlowPackets = (localNetFlow.rxPackets + localNetFlow.txPackets))
    {
      lastPerfItem.netFlowReceiverBytes = localNetFlow.rxBytes;
      lastPerfItem.netFlowSendBytes = localNetFlow.txBytes;
      return;
      label106:
      paramPerfItem.netFlowReceiverBytes = (localNetFlow.rxBytes - lastPerfItem.netFlowReceiverBytes);
      paramPerfItem.netFlowSendBytes = (localNetFlow.txBytes - lastPerfItem.netFlowSendBytes);
      if (paramPerfItem.netFlowReceiverBytes > 0L)
      {
        l1 = paramPerfItem.netFlowReceiverBytes;
        label152:
        paramPerfItem.netFlowReceiverBytes = l1;
        if (paramPerfItem.netFlowSendBytes <= 0L) {
          break label184;
        }
      }
      label184:
      for (long l1 = paramPerfItem.netFlowSendBytes;; l1 = 0L)
      {
        paramPerfItem.netFlowSendBytes = l1;
        break;
        l1 = 0L;
        break label152;
      }
      label189:
      paramPerfItem.netFlowPackets = (localNetFlow.rxPackets + localNetFlow.txPackets - lastPerfItem.netFlowPackets);
      l1 = l2;
      if (paramPerfItem.netFlowPackets > 0L) {
        l1 = paramPerfItem.netFlowPackets;
      }
      paramPerfItem.netFlowPackets = l1;
    }
  }
  
  private void tidyStartTagItem(@NonNull TagItem paramTagItem)
  {
    Object localObject = this.dataCollector.collectorNetFollow();
    paramTagItem.netFlowRecvBytes = ((NetFlow)localObject).rxBytes;
    paramTagItem.netFlowSendBytes = ((NetFlow)localObject).txBytes;
    if ((9223372036854775807L == ((NetFlow)localObject).rxPackets) || (9223372036854775807L == ((NetFlow)localObject).txPackets)) {}
    long l;
    for (paramTagItem.netFlowPackets = 9223372036854775807L;; paramTagItem.netFlowPackets = (((NetFlow)localObject).txPackets + l))
    {
      localObject = this.ioModule.getIoStatusProxy();
      if ((localObject != null) && (localObject.length == 2))
      {
        paramTagItem.ioCount = localObject[0];
        paramTagItem.ioBytes = localObject[1];
      }
      return;
      l = ((NetFlow)localObject).rxPackets;
    }
  }
  
  private void tidyStatInfo(@NonNull PerfItem paramPerfItem)
  {
    long l2 = 9223372036854775807L;
    StatInfo localStatInfo = this.dataCollector.collectStatInfo();
    if (localStatInfo.cpuJiffies > 0L)
    {
      l1 = localStatInfo.cpuJiffies;
      paramPerfItem.cpuJiffies = l1;
      if (localStatInfo.cpuSysJiffies <= 0L) {
        break label144;
      }
      l1 = localStatInfo.cpuSysJiffies;
      label51:
      paramPerfItem.cpuSysJiffies = l1;
      if (localStatInfo.cpuSysUsedJiffies <= 0L) {
        break label151;
      }
    }
    label144:
    label151:
    for (long l1 = localStatInfo.cpuSysUsedJiffies;; l1 = 9223372036854775807L)
    {
      paramPerfItem.cpuSysUsedJiffies = l1;
      l1 = l2;
      if (memPageSize != 0L)
      {
        l1 = l2;
        if (localStatInfo.memory != 9223372036854775807L)
        {
          l1 = localStatInfo.memory;
          l1 = memPageSize * l1;
        }
      }
      paramPerfItem.memory = l1;
      paramPerfItem.thread = localStatInfo.threadNum;
      paramPerfItem.temperature = TemperatureCollector.getTemperature();
      return;
      l1 = 9223372036854775807L;
      break;
      l1 = 9223372036854775807L;
      break label51;
    }
  }
  
  private void tidyStopTagItem(@NonNull TagItem paramTagItem1, @NonNull TagItem paramTagItem2)
  {
    paramTagItem2.eventTime = (System.currentTimeMillis() / 1000.0D);
    paramTagItem2.duringTime = ((paramTagItem2.eventTime - paramTagItem1.eventTime) * 1000.0D);
    Object localObject;
    if ((paramTagItem1.netFlowSendBytes != 9223372036854775807L) && (paramTagItem1.netFlowRecvBytes != 9223372036854775807L))
    {
      localObject = this.dataCollector.collectorNetFollow();
      if ((9223372036854775807L != ((NetFlow)localObject).rxBytes) && (9223372036854775807L != ((NetFlow)localObject).txPackets))
      {
        paramTagItem2.netFlowRecvBytes = (((NetFlow)localObject).rxBytes - paramTagItem1.netFlowRecvBytes);
        paramTagItem2.netFlowSendBytes = (((NetFlow)localObject).txBytes - paramTagItem1.netFlowSendBytes);
      }
      if ((9223372036854775807L != ((NetFlow)localObject).rxPackets) && (9223372036854775807L != ((NetFlow)localObject).txPackets)) {
        break label191;
      }
    }
    label191:
    long l;
    for (paramTagItem2.netFlowPackets = 9223372036854775807L;; paramTagItem2.netFlowPackets = (((NetFlow)localObject).txPackets + l - paramTagItem1.netFlowPackets))
    {
      localObject = this.ioModule.getIoStatusProxy();
      if ((localObject != null) && (localObject.length == 2))
      {
        paramTagItem2.ioCount = (localObject[0] - paramTagItem1.ioCount);
        paramTagItem2.ioBytes = (localObject[1] - paramTagItem1.ioBytes);
      }
      return;
      l = ((NetFlow)localObject).rxPackets;
    }
  }
  
  public boolean isPublicMode()
  {
    return RuntimeConfig.resouceMonitorPublicMode;
  }
  
  @NonNull
  public PerfItem samplePerfValue(@NonNull PerfItem paramPerfItem)
  {
    paramPerfItem.stage = gStage;
    paramPerfItem.extraInfo = gExtraInfo;
    paramPerfItem.eventTime = (System.currentTimeMillis() / 1000.0D);
    tidyStatInfo(paramPerfItem);
    if ((lastPerfItem != null) && (paramPerfItem.eventTime - lastPerfItem.eventTime < 5.0D))
    {
      lastPerfItem.eventTime = paramPerfItem.eventTime;
      tidyCpuItem(paramPerfItem);
      if (!isPublicMode())
      {
        tidyNetFlowItem(paramPerfItem);
        tidyIoItem(paramPerfItem);
      }
      return paramPerfItem;
    }
    initializeItem(paramPerfItem);
    return paramPerfItem;
  }
  
  public void start()
  {
    if (!hasInit)
    {
      if (BaseInfo.app != null) {
        BaseInfo.app.registerReceiver(new TemperatureCollector(), TemperatureCollector.getFilter());
      }
      registerForeBack();
      hasInit = true;
    }
    if ((RuntimeConfig.globalMonitorCount == 0) && ((SDKConfig.RES_TYPE & DefaultPluginConfig.ResourcePlugin.ResourceType.OPEN_RESOURCE.getValue()) > 0)) {
      try
      {
        if (RuntimeConfig.globalMonitorCount == 0)
        {
          Logger.INSTANCE.i(new String[] { "QAPM_resource_PerfCollector", "SAMPLE: start global monitor to collect resource" });
          new Handler(ThreadManager.getMonitorThreadLooper()).post(MonitorRunnable.getInstance(true));
        }
        RuntimeConfig.globalMonitorCount += 1;
        return;
      }
      finally {}
    }
  }
  
  public void start(String paramString1, String paramString2)
  {
    long l = System.currentTimeMillis();
    if ((TextUtils.isEmpty(paramString1)) || ((!PluginController.INSTANCE.canCollect(PluginCombination.resourcePlugin.plugin)) && (!"QAPM_APPLAUNCH".equals(paramString1)))) {}
    String str;
    do
    {
      return;
      if ("QAPM_APPLAUNCH".equals(paramString1))
      {
        this.traceModule.pushProxy(paramString1, paramString2, l);
        return;
      }
      str = paramString1 + paramString2;
    } while ((TagItem)this.tagInfoCache.get(str) != null);
    TagItem localTagItem = new TagItem();
    localTagItem.eventTime = (l / 1000.0D);
    localTagItem.stage = paramString1;
    localTagItem.extraInfo = paramString2;
    localTagItem.tagId = l;
    localTagItem.type = 0;
    if (!isPublicMode()) {
      tidyStartTagItem(localTagItem);
    }
    for (;;)
    {
      gStage = paramString1;
      gExtraInfo = paramString2;
      this.tagInfoCache.put(str, localTagItem);
      manualTagItems.add(localTagItem);
      return;
      PerfItem localPerfItem = MonitorRunnable.getInstance(true).forceSampleOnce();
      localTagItem.sceneMeta.cpu = localPerfItem.cpuRate;
      localTagItem.sceneMeta.memory = localPerfItem.memory;
      start();
    }
  }
  
  public void stop()
  {
    if (RuntimeConfig.globalMonitorCount > 0) {
      try
      {
        if (RuntimeConfig.globalMonitorCount > 0)
        {
          if (RuntimeConfig.globalMonitorCount == 1)
          {
            Logger.INSTANCE.i(new String[] { "QAPM_resource_PerfCollector", "SAMPLE: stop global monitor to collect resource" });
            new Handler(ThreadManager.getMonitorThreadLooper()).removeCallbacks(MonitorRunnable.getInstance(false));
            immediatePerfItems.clear();
          }
          RuntimeConfig.globalMonitorCount -= 1;
        }
        return;
      }
      finally {}
    }
  }
  
  public void stop(String paramString1, String paramString2)
  {
    if (gStage.equals(paramString1))
    {
      gStage = "";
      if (gExtraInfo.equals(paramString2)) {
        gExtraInfo = "";
      }
    }
    if ((TextUtils.isEmpty(paramString1)) || ((!PluginController.INSTANCE.canCollect(PluginCombination.resourcePlugin.plugin)) && (!"QAPM_APPLAUNCH".equals(paramString1)))) {}
    String str;
    TagItem localTagItem1;
    do
    {
      return;
      if ("QAPM_APPLAUNCH".equals(paramString1))
      {
        this.traceModule.popProxy();
        return;
      }
      str = paramString1 + paramString2;
      localTagItem1 = (TagItem)this.tagInfoCache.get(str);
    } while (localTagItem1 == null);
    TagItem localTagItem2 = new TagItem();
    localTagItem2.stage = paramString1;
    localTagItem2.extraInfo = paramString2;
    localTagItem2.tagId = localTagItem1.tagId;
    localTagItem2.type = 1;
    if (!isPublicMode()) {
      tidyStopTagItem(localTagItem1, localTagItem2);
    }
    for (;;)
    {
      manualTagItems.add(localTagItem2);
      this.tagInfoCache.remove(str);
      if (manualTagItems.size() <= 100) {
        break;
      }
      new Handler(ThreadManager.getMonitorThreadLooper()).post(DumpSampleFileRunnable.getInstance());
      return;
      paramString1 = MonitorRunnable.getInstance(true).forceSampleOnce();
      localTagItem1.sceneMeta.cpu = Math.max(localTagItem1.sceneMeta.cpu, paramString1.cpuRate);
      localTagItem1.sceneMeta.memory = Math.max(localTagItem1.sceneMeta.memory, paramString1.memory);
      localTagItem1.sceneMeta.duration = (System.currentTimeMillis() - localTagItem1.tagId);
      localTagItem1.sceneMeta.stage = localTagItem1.stage;
      if (ListenerManager.monitorListener != null) {
        ListenerManager.monitorListener.onMetaGet(localTagItem1.sceneMeta);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.resource.ResourceMonitor
 * JD-Core Version:    0.7.0.1
 */