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
  static int MONITOR_ID = 0;
  static final int MONITOR_ID_NAN = 0;
  HippyEngineContext mContext;
  HippyEngineMonitorAdapter mEngineMonitorAdapter;
  ConcurrentHashMap<Integer, HippyModuleANRMonitor.MonitorMessage> mMonitorMessages;
  boolean mNeedReportBridgeANR = false;
  
  public HippyModuleANRMonitor(HippyEngineContext paramHippyEngineContext)
  {
    this.mContext = paramHippyEngineContext;
    if (this.mContext != null)
    {
      this.mEngineMonitorAdapter = this.mContext.getGlobalConfigs().getEngineMonitorAdapter();
      this.mNeedReportBridgeANR = this.mEngineMonitorAdapter.needReportBridgeANR();
      if (this.mNeedReportBridgeANR) {
        this.mMonitorMessages = new ConcurrentHashMap();
      }
    }
  }
  
  public void checkMonitor()
  {
    if (this.mMonitorMessages == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.mMonitorMessages.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        HippyModuleANRMonitor.MonitorMessage localMonitorMessage = (HippyModuleANRMonitor.MonitorMessage)localEntry.getValue();
        if ((localMonitorMessage != null) && (SystemClock.elapsedRealtime() - localMonitorMessage.startTime > 100L))
        {
          if (this.mEngineMonitorAdapter != null) {
            this.mEngineMonitorAdapter.reportBridgeANR(localMonitorMessage.param1 + " | " + localMonitorMessage.param2);
          }
          this.mMonitorMessages.remove(localEntry.getKey());
          localMonitorMessage.onDispose();
        }
      }
    }
  }
  
  public void endMonitor(int paramInt)
  {
    if (!this.mNeedReportBridgeANR) {}
    HippyModuleANRMonitor.MonitorMessage localMonitorMessage;
    do
    {
      return;
      localMonitorMessage = (HippyModuleANRMonitor.MonitorMessage)this.mMonitorMessages.get(Integer.valueOf(paramInt));
    } while (localMonitorMessage == null);
    if ((SystemClock.elapsedRealtime() - localMonitorMessage.startTime > 100L) && (this.mEngineMonitorAdapter != null)) {
      this.mEngineMonitorAdapter.reportBridgeANR(localMonitorMessage.param1 + " | " + localMonitorMessage.param2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.hippy.modules.HippyModuleANRMonitor
 * JD-Core Version:    0.7.0.1
 */