package com.tencent.mtt.hippy.adapter.monitor;

import com.tencent.mtt.hippy.HippyRootView;
import java.util.List;

public class DefaultEngineMonitorAdapter
  implements HippyEngineMonitorAdapter
{
  public boolean needReportBridgeANR()
  {
    return false;
  }
  
  public void reportBridgeANR(String paramString) {}
  
  public void reportClickEvent(Object paramObject, boolean paramBoolean) {}
  
  public void reportDoCallNatives(String paramString1, String paramString2) {}
  
  public void reportEngineLoadResult(int paramInt1, int paramInt2, List<HippyEngineMonitorEvent> paramList, Throwable paramThrowable) {}
  
  public void reportEngineLoadStart() {}
  
  public void reportGestureEventCallStack(String paramString1, String paramString2) {}
  
  public void reportModuleLoadComplete(HippyRootView paramHippyRootView, int paramInt, List<HippyEngineMonitorEvent> paramList) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.adapter.monitor.DefaultEngineMonitorAdapter
 * JD-Core Version:    0.7.0.1
 */