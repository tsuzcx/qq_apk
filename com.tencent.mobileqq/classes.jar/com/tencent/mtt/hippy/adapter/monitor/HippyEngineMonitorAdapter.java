package com.tencent.mtt.hippy.adapter.monitor;

import com.tencent.mtt.hippy.HippyRootView;
import java.util.List;

public abstract interface HippyEngineMonitorAdapter
{
  public static final int ENGINE_LOAD_RESULE_TIMEOUT = 2;
  public static final int ENGINE_LOAD_RESULT_ERROR = 1;
  public static final int ENGINE_LOAD_RESULT_SUCCESS = 0;
  
  public abstract boolean needReportBridgeANR();
  
  public abstract void reportBridgeANR(String paramString);
  
  public abstract void reportClickEvent(Object paramObject, boolean paramBoolean);
  
  public abstract void reportDoCallNatives(String paramString1, String paramString2);
  
  public abstract void reportEngineLoadResult(int paramInt1, int paramInt2, List<HippyEngineMonitorEvent> paramList, Throwable paramThrowable);
  
  public abstract void reportEngineLoadStart();
  
  public abstract void reportGestureEventCallStack(String paramString1, String paramString2);
  
  public abstract void reportModuleLoadComplete(HippyRootView paramHippyRootView, int paramInt, List<HippyEngineMonitorEvent> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.adapter.monitor.HippyEngineMonitorAdapter
 * JD-Core Version:    0.7.0.1
 */