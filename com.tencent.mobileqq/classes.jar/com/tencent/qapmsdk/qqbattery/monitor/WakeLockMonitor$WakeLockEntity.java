package com.tencent.qapmsdk.qqbattery.monitor;

import android.os.PowerManager.WakeLock;
import android.os.SystemClock;
import android.util.Pair;
import com.tencent.qapmsdk.qqbattery.HighFrequencyDetector;
import com.tencent.qapmsdk.qqbattery.HighFrequencyDetector.Action;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class WakeLockMonitor$WakeLockEntity
{
  private Map<String, Integer> callStackMap = new HashMap();
  public String createStack;
  private HighFrequencyDetector detector1;
  private HighFrequencyDetector detector2;
  private long firstAcquireTimeStamp = 0L;
  private long holdTime = 0L;
  public int levelAndFlags;
  public String tag;
  public String uuid;
  
  public WakeLockMonitor$WakeLockEntity(WakeLockMonitor paramWakeLockMonitor)
  {
    this.detector1 = new HighFrequencyDetector(WakeLockMonitor.access$100(paramWakeLockMonitor), WakeLockMonitor.access$200(paramWakeLockMonitor));
    this.detector2 = new HighFrequencyDetector(WakeLockMonitor.access$300(paramWakeLockMonitor), WakeLockMonitor.access$400(paramWakeLockMonitor));
  }
  
  public void destroy()
  {
    this.detector1.trimCache();
    this.detector2.trimCache();
  }
  
  public Pair<Boolean, Integer> getCallStackIndex(String paramString)
  {
    synchronized (this.callStackMap)
    {
      if (this.callStackMap.containsKey(paramString))
      {
        paramString = new Pair(Boolean.valueOf(false), this.callStackMap.get(paramString));
        return paramString;
      }
      int i = this.callStackMap.size();
      this.callStackMap.put(paramString, Integer.valueOf(i));
      paramString = new Pair(Boolean.valueOf(true), Integer.valueOf(i));
      return paramString;
    }
  }
  
  public long getHoldTime()
  {
    if (isHeld()) {
      return SystemClock.uptimeMillis() - this.firstAcquireTimeStamp;
    }
    return this.holdTime;
  }
  
  public boolean isHeld()
  {
    return this.firstAcquireTimeStamp != 0L;
  }
  
  public Pair<Boolean, List<HighFrequencyDetector.Action>> onAcquire(PowerManager.WakeLock paramWakeLock, String paramString, long paramLong)
  {
    boolean bool;
    if (!paramWakeLock.isHeld())
    {
      bool = true;
      this.firstAcquireTimeStamp = SystemClock.uptimeMillis();
    }
    else
    {
      bool = false;
    }
    this.detector1.onAction(paramString);
    return new Pair(Boolean.valueOf(bool), this.detector2.onAction(paramString));
  }
  
  public Pair<Boolean, Long> onRelease(PowerManager.WakeLock paramWakeLock, int paramInt)
  {
    boolean bool = paramWakeLock.isHeld();
    long l = 0L;
    if ((!bool) && (this.firstAcquireTimeStamp != 0L))
    {
      bool = true;
      l = SystemClock.uptimeMillis() - this.firstAcquireTimeStamp;
      this.firstAcquireTimeStamp = 0L;
      this.holdTime = l;
    }
    else
    {
      bool = false;
    }
    return new Pair(Boolean.valueOf(bool), Long.valueOf(l));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.qqbattery.monitor.WakeLockMonitor.WakeLockEntity
 * JD-Core Version:    0.7.0.1
 */