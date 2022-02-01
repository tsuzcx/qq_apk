package com.tencent.mtt.hippy.modules;

import com.tencent.mtt.supportui.utils.struct.Pools.SynchronizedPool;

class HippyModuleANRMonitor$MonitorMessage
{
  private static final Pools.SynchronizedPool<MonitorMessage> INSTANCE_POOL = new Pools.SynchronizedPool(20);
  private static final int POOL_SIZE = 20;
  public String param1;
  public String param2;
  public long startTime;
  
  private void init(String paramString1, String paramString2, long paramLong)
  {
    this.param1 = paramString1;
    this.param2 = paramString2;
    this.startTime = paramLong;
  }
  
  public static MonitorMessage obtain(String paramString1, String paramString2, long paramLong)
  {
    MonitorMessage localMonitorMessage2 = (MonitorMessage)INSTANCE_POOL.acquire();
    MonitorMessage localMonitorMessage1 = localMonitorMessage2;
    if (localMonitorMessage2 == null) {
      localMonitorMessage1 = new MonitorMessage();
    }
    localMonitorMessage1.init(paramString1, paramString2, paramLong);
    return localMonitorMessage1;
  }
  
  public void onDispose()
  {
    try
    {
      INSTANCE_POOL.release(this);
      return;
    }
    catch (Throwable localThrowable) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.hippy.modules.HippyModuleANRMonitor.MonitorMessage
 * JD-Core Version:    0.7.0.1
 */