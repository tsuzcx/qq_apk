package com.tencent.mtt.hippy.adapter.monitor;

public class HippyEngineMonitorEvent
{
  public static String ENGINE_LOAD_EVENT_INIT_BRIDGE;
  public static String ENGINE_LOAD_EVENT_INIT_INSTANCE = "initInstance";
  public static String ENGINE_LOAD_EVENT_LOAD_COMMONJS;
  public static String ENGINE_LOAD_EVENT_NOTIFY_ENGINE_INITED;
  public static String MODULE_LOAD_EVENT_CREATE_VIEW = "createView";
  public static String MODULE_LOAD_EVENT_LOAD_BUNDLE;
  public static String MODULE_LOAD_EVENT_RUN_BUNDLE;
  public static String MODULE_LOAD_EVENT_WAIT_ENGINE;
  public static String MODULE_LOAD_EVENT_WAIT_LOAD_BUNDLE;
  public long endTime;
  public String eventName;
  public long startTime;
  
  static
  {
    ENGINE_LOAD_EVENT_INIT_BRIDGE = "initBridge";
    ENGINE_LOAD_EVENT_LOAD_COMMONJS = "loadCommonJS";
    ENGINE_LOAD_EVENT_NOTIFY_ENGINE_INITED = "notifyEngineInited";
    MODULE_LOAD_EVENT_WAIT_ENGINE = "waitEngine";
    MODULE_LOAD_EVENT_WAIT_LOAD_BUNDLE = "waitLoadBundle";
    MODULE_LOAD_EVENT_LOAD_BUNDLE = "loadBundle";
    MODULE_LOAD_EVENT_RUN_BUNDLE = "runBundle";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.hippy.adapter.monitor.HippyEngineMonitorEvent
 * JD-Core Version:    0.7.0.1
 */