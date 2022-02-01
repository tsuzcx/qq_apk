package com.tencent.mtt.hippy.adapter.monitor;

public class HippyEngineMonitorEvent
{
  public static String ENGINE_LOAD_EVENT_INIT_BRIDGE = "initBridge";
  public static String ENGINE_LOAD_EVENT_INIT_INSTANCE = "initInstance";
  public static String ENGINE_LOAD_EVENT_LOAD_COMMONJS = "loadCommonJS";
  public static String ENGINE_LOAD_EVENT_NOTIFY_ENGINE_INITED = "notifyEngineInited";
  public static String MODULE_LOAD_EVENT_CREATE_VIEW = "createView";
  public static String MODULE_LOAD_EVENT_LOAD_BUNDLE = "loadBundle";
  public static String MODULE_LOAD_EVENT_RUN_BUNDLE = "runBundle";
  public static String MODULE_LOAD_EVENT_WAIT_ENGINE = "waitEngine";
  public static String MODULE_LOAD_EVENT_WAIT_LOAD_BUNDLE = "waitLoadBundle";
  public long endTime;
  public String eventName;
  public long startTime;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.adapter.monitor.HippyEngineMonitorEvent
 * JD-Core Version:    0.7.0.1
 */