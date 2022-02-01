package com.tencent.mtt.hippy.adapter.monitor;

public class HippyEngineMonitorEvent
{
  public static final String ENGINE_LOAD_EVENT_INIT_BRIDGE = "initBridge";
  public static final String ENGINE_LOAD_EVENT_INIT_INSTANCE = "initInstance";
  public static final String ENGINE_LOAD_EVENT_LOAD_COMMONJS = "loadCommonJS";
  public static final String ENGINE_LOAD_EVENT_NOTIFY_ENGINE_INITED = "notifyEngineInited";
  public static final String MODULE_LOAD_EVENT_CREATE_VIEW = "createView";
  public static final String MODULE_LOAD_EVENT_LOAD_BUNDLE = "loadBundle";
  public static final String MODULE_LOAD_EVENT_RUN_BUNDLE = "runBundle";
  public static final String MODULE_LOAD_EVENT_WAIT_ENGINE = "waitEngine";
  public static final String MODULE_LOAD_EVENT_WAIT_LOAD_BUNDLE = "waitLoadBundle";
  public long endTime;
  public String eventName;
  public long startTime;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.adapter.monitor.HippyEngineMonitorEvent
 * JD-Core Version:    0.7.0.1
 */