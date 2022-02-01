package com.tencent.qapmsdk.resource;

import android.app.Application;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.Process;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qapmsdk.base.config.DefaultPluginConfig;
import com.tencent.qapmsdk.base.config.PluginCombination;
import com.tencent.qapmsdk.base.config.RuntimeConfig;
import com.tencent.qapmsdk.base.listener.IBaseListener;
import com.tencent.qapmsdk.base.listener.IResourceListener;
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
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

public class ResourceMonitor
  extends QAPMMonitorPlugin
  implements Handler.Callback
{
  private static final int MSG_END_SCENE = 2;
  private static final int MSG_START_SCENE = 1;
  private static final String TAG = "QAPM_resource_PerfCollector";
  private static final double TIME_TOLERANCE = 5.0D;
  private static final double TIME_UNIT = 1000.0D;
  private static volatile String currentExtraInfo;
  private static volatile String currentStage;
  private static volatile boolean hasInit;
  @NonNull
  public static Vector<PerfItem> immediatePerfItems = new Vector(900);
  private static volatile PerfItem lastPerfItem;
  @NonNull
  public static Vector<TagItem> manualTagItems = new Vector(100);
  private static long memPageSize = DeviceMemory.getScPageSize(0L);
  @Nullable
  private static volatile ResourceMonitor perfCollector;
  private static int pid;
  private DataCollector dataCollector = new DataCollector();
  private Handler innerHandler = new Handler(ThreadManager.getMonitorThreadLooper(), this);
  private ReflectIoModule ioModule = new ReflectIoModule();
  private ConcurrentHashMap<String, TagItem> tagInfoCache = new ConcurrentHashMap();
  private ReflectTraceModule traceModule = new ReflectTraceModule();
  
  static
  {
    lastPerfItem = null;
    perfCollector = null;
    hasInit = false;
    currentStage = "";
    currentExtraInfo = "";
    pid = Process.myPid();
  }
  
  private void endSceneInMonitorThread(Message paramMessage)
  {
    paramMessage = (TagItem)paramMessage.obj;
    TagItem localTagItem = paramMessage.matchTagItem;
    tidyStopTagItem(localTagItem, paramMessage);
    if (RunTimeEnv.isPublishMode())
    {
      MonitorRunnable.getInstance().collectPerfItemRightNow();
      IResourceListener localIResourceListener = ListenerManager.resourceListener;
      if (localIResourceListener != null)
      {
        SceneMeta localSceneMeta = localTagItem.sceneMeta;
        localSceneMeta.duration = (((paramMessage.eventTime - localTagItem.eventTime) * 1000.0D));
        localSceneMeta.stage = localTagItem.stage;
        localIResourceListener.onEndScene(localSceneMeta);
      }
    }
    manualTagItems.add(paramMessage);
    this.tagInfoCache.remove(paramMessage.tagKey);
    if (manualTagItems.size() > 100) {
      DumpSampleFileRunnable.getInstance().run();
    }
    if (currentStage.equals(paramMessage.stage))
    {
      currentStage = "";
      if (currentExtraInfo.equals(paramMessage.extraInfo)) {
        currentExtraInfo = "";
      }
    }
  }
  
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
  
  private void startSceneInMonitorThread(Message paramMessage)
  {
    paramMessage = (TagItem)paramMessage.obj;
    currentStage = paramMessage.stage;
    currentExtraInfo = paramMessage.extraInfo;
    if (!RunTimeEnv.isPublishMode()) {
      tidyStartTagItem(paramMessage);
    }
    this.tagInfoCache.put(paramMessage.tagKey, paramMessage);
    manualTagItems.add(paramMessage);
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
      localNetFlow = this.dataCollector.collectorNetFollow(true);
      if ((9223372036854775807L != lastPerfItem.netFlowReceiverBytes) && (9223372036854775807L != lastPerfItem.netFlowSendBytes)) {
        break label107;
      }
      paramPerfItem.netFlowReceiverBytes = 0L;
      paramPerfItem.netFlowSendBytes = 0L;
      if ((9223372036854775807L != localNetFlow.rxPackets) && (9223372036854775807L != localNetFlow.txPackets)) {
        break label190;
      }
    }
    for (paramPerfItem.netFlowPackets = 0L;; lastPerfItem.netFlowPackets = (localNetFlow.rxPackets + localNetFlow.txPackets))
    {
      lastPerfItem.netFlowReceiverBytes = localNetFlow.rxBytes;
      lastPerfItem.netFlowSendBytes = localNetFlow.txBytes;
      return;
      label107:
      paramPerfItem.netFlowReceiverBytes = (localNetFlow.rxBytes - lastPerfItem.netFlowReceiverBytes);
      paramPerfItem.netFlowSendBytes = (localNetFlow.txBytes - lastPerfItem.netFlowSendBytes);
      if (paramPerfItem.netFlowReceiverBytes > 0L)
      {
        l1 = paramPerfItem.netFlowReceiverBytes;
        label153:
        paramPerfItem.netFlowReceiverBytes = l1;
        if (paramPerfItem.netFlowSendBytes <= 0L) {
          break label185;
        }
      }
      label185:
      for (long l1 = paramPerfItem.netFlowSendBytes;; l1 = 0L)
      {
        paramPerfItem.netFlowSendBytes = l1;
        break;
        l1 = 0L;
        break label153;
      }
      label190:
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
    Object localObject = this.dataCollector.collectorNetFollow(false);
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
      localObject = this.dataCollector.collectorNetFollow(false);
      if ((9223372036854775807L != ((NetFlow)localObject).rxBytes) && (9223372036854775807L != ((NetFlow)localObject).txPackets))
      {
        paramTagItem2.netFlowRecvBytes = (((NetFlow)localObject).rxBytes - paramTagItem1.netFlowRecvBytes);
        paramTagItem2.netFlowSendBytes = (((NetFlow)localObject).txBytes - paramTagItem1.netFlowSendBytes);
      }
      if ((9223372036854775807L != ((NetFlow)localObject).rxPackets) && (9223372036854775807L != ((NetFlow)localObject).txPackets)) {
        break label192;
      }
    }
    label192:
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
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      startSceneInMonitorThread(paramMessage);
      continue;
      endSceneInMonitorThread(paramMessage);
    }
  }
  
  @NonNull
  public PerfItem samplePerfValue(@NonNull PerfItem paramPerfItem)
  {
    paramPerfItem.stage = currentStage;
    paramPerfItem.extraInfo = currentExtraInfo;
    paramPerfItem.eventTime = (System.currentTimeMillis() / 1000.0D);
    tidyStatInfo(paramPerfItem);
    if ((lastPerfItem != null) && (paramPerfItem.eventTime - lastPerfItem.eventTime < 5.0D))
    {
      lastPerfItem.eventTime = paramPerfItem.eventTime;
      tidyCpuItem(paramPerfItem);
      if (!RunTimeEnv.isPublishMode())
      {
        tidyNetFlowItem(paramPerfItem);
        tidyIoItem(paramPerfItem);
      }
    }
    while (RunTimeEnv.isTagMode())
    {
      Iterator localIterator = this.tagInfoCache.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        localObject = (TagItem)this.tagInfoCache.get(localObject);
        if (localObject != null)
        {
          ((TagItem)localObject).sceneMeta.cpu = Math.max(((TagItem)localObject).sceneMeta.cpu, paramPerfItem.cpuRate);
          ((TagItem)localObject).sceneMeta.memory = Math.max(((TagItem)localObject).sceneMeta.memory, paramPerfItem.memory);
        }
      }
      initializeItem(paramPerfItem);
    }
    return paramPerfItem;
  }
  
  public void setListener(@NonNull IBaseListener paramIBaseListener)
  {
    try
    {
      ListenerManager.resourceListener = (IResourceListener)paramIBaseListener;
      return;
    }
    catch (Exception paramIBaseListener)
    {
      Logger.INSTANCE.exception("QAPM_resource_PerfCollector", paramIBaseListener);
    }
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
    if ((RuntimeConfig.globalMonitorCount == 0) && (RunTimeEnv.isResourceMode())) {
      try
      {
        if (RuntimeConfig.globalMonitorCount == 0)
        {
          Logger.INSTANCE.i(new String[] { "QAPM_resource_PerfCollector", "SAMPLE: start global monitor to collect resource" });
          MonitorRunnable.getInstance().start();
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
    if ((TextUtils.isEmpty(paramString1)) || ((!PluginController.INSTANCE.canCollect(PluginCombination.resourcePlugin.plugin)) && (!"QAPM_APPLAUNCH".equals(paramString1)))) {
      return;
    }
    if ("QAPM_APPLAUNCH".equals(paramString1))
    {
      this.traceModule.pushProxy(paramString1, paramString2, l);
      return;
    }
    String str = paramString1 + paramString2;
    TagItem localTagItem = new TagItem();
    localTagItem.tagKey = str;
    localTagItem.eventTime = (l / 1000.0D);
    localTagItem.stage = paramString1;
    localTagItem.extraInfo = paramString2;
    localTagItem.tagId = l;
    localTagItem.type = 0;
    Message.obtain(this.innerHandler, 1, localTagItem).sendToTarget();
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
            MonitorRunnable.getInstance().stop();
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
    if ((TextUtils.isEmpty(paramString1)) && (!"QAPM_APPLAUNCH".equals(paramString1))) {}
    String str;
    TagItem localTagItem1;
    do
    {
      return;
      if (("QAPM_APPLAUNCH".equals(paramString1)) && ("QAPM_APPLAUNCH_END".equals(paramString2)))
      {
        this.traceModule.endProxy();
        return;
      }
      if ("QAPM_APPLAUNCH".equals(paramString1))
      {
        this.traceModule.popProxy();
        return;
      }
      str = paramString1 + paramString2;
      localTagItem1 = (TagItem)this.tagInfoCache.get(str);
    } while (localTagItem1 == null);
    TagItem localTagItem2 = new TagItem();
    localTagItem2.matchTagItem = localTagItem1;
    localTagItem2.tagKey = str;
    localTagItem2.stage = paramString1;
    localTagItem2.extraInfo = paramString2;
    localTagItem2.tagId = localTagItem1.tagId;
    localTagItem2.type = 1;
    Message.obtain(this.innerHandler, 2, localTagItem2).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.resource.ResourceMonitor
 * JD-Core Version:    0.7.0.1
 */