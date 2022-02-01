package com.tencent.mtt.hippy.modules;

import android.os.SystemClock;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.HippyGlobalConfigs;
import com.tencent.mtt.hippy.adapter.monitor.HippyEngineMonitorAdapter;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class HippyModuleANRMonitor
{
  static final int ANR_TIME = 100;
  static int MONITOR_ID;
  static final int MONITOR_ID_NAN = 0;
  final HippyEngineContext mContext;
  HippyEngineMonitorAdapter mEngineMonitorAdapter;
  ConcurrentHashMap<Integer, HippyModuleANRMonitor.MonitorMessage> mMonitorMessages;
  boolean mNeedReportBridgeANR = false;
  
  public HippyModuleANRMonitor(HippyEngineContext paramHippyEngineContext)
  {
    this.mContext = paramHippyEngineContext;
    paramHippyEngineContext = this.mContext;
    if (paramHippyEngineContext != null)
    {
      this.mEngineMonitorAdapter = paramHippyEngineContext.getGlobalConfigs().getEngineMonitorAdapter();
      this.mNeedReportBridgeANR = this.mEngineMonitorAdapter.needReportBridgeANR();
      if (this.mNeedReportBridgeANR) {
        this.mMonitorMessages = new ConcurrentHashMap();
      }
    }
  }
  
  public void checkMonitor()
  {
    Object localObject = this.mMonitorMessages;
    if (localObject == null) {
      return;
    }
    localObject = ((ConcurrentHashMap)localObject).entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      HippyModuleANRMonitor.MonitorMessage localMonitorMessage = (HippyModuleANRMonitor.MonitorMessage)localEntry.getValue();
      if ((localMonitorMessage != null) && (SystemClock.elapsedRealtime() - localMonitorMessage.startTime > 100L))
      {
        HippyEngineMonitorAdapter localHippyEngineMonitorAdapter = this.mEngineMonitorAdapter;
        if (localHippyEngineMonitorAdapter != null)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(localMonitorMessage.param1);
          localStringBuilder.append(" | ");
          localStringBuilder.append(localMonitorMessage.param2);
          localHippyEngineMonitorAdapter.reportBridgeANR(localStringBuilder.toString());
        }
        this.mMonitorMessages.remove(localEntry.getKey());
        localMonitorMessage.onDispose();
      }
    }
  }
  
  public void endMonitor(int paramInt)
  {
    if (!this.mNeedReportBridgeANR) {
      return;
    }
    HippyModuleANRMonitor.MonitorMessage localMonitorMessage = (HippyModuleANRMonitor.MonitorMessage)this.mMonitorMessages.get(Integer.valueOf(paramInt));
    if (localMonitorMessage == null) {
      return;
    }
    if (SystemClock.elapsedRealtime() - localMonitorMessage.startTime > 100L)
    {
      HippyEngineMonitorAdapter localHippyEngineMonitorAdapter = this.mEngineMonitorAdapter;
      if (localHippyEngineMonitorAdapter != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(localMonitorMessage.param1);
        localStringBuilder.append(" | ");
        localStringBuilder.append(localMonitorMessage.param2);
        localHippyEngineMonitorAdapter.reportBridgeANR(localStringBuilder.toString());
      }
    }
    this.mMonitorMessages.remove(Integer.valueOf(paramInt));
    localMonitorMessage.onDispose();
  }
  
  public int startMonitor(String paramString1, String paramString2)
  {
    if (!this.mNeedReportBridgeANR) {
      return 0;
    }
    paramString1 = HippyModuleANRMonitor.MonitorMessage.obtain(paramString1, paramString2, SystemClock.elapsedRealtime());
    int j = MONITOR_ID + 1;
    MONITOR_ID = j;
    int i = j;
    if (j == 0)
    {
      i = MONITOR_ID + 1;
      MONITOR_ID = i;
    }
    this.mMonitorMessages.put(Integer.valueOf(i), paramString1);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.modules.HippyModuleANRMonitor
 * JD-Core Version:    0.7.0.1
 */