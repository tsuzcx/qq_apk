package com.tencent.mtt.hippy.utils;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mtt.hippy.adapter.monitor.HippyEngineMonitorEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TimeMonitor
{
  HippyEngineMonitorEvent mCurrentEvent;
  boolean mEnable;
  List<HippyEngineMonitorEvent> mEvents;
  long mStartTime;
  int mTotalTime;
  
  public TimeMonitor(boolean paramBoolean)
  {
    this.mEnable = paramBoolean;
  }
  
  public void begine()
  {
    if (!this.mEnable) {
      return;
    }
    this.mStartTime = SystemClock.elapsedRealtime();
    this.mCurrentEvent = null;
    if (this.mEvents == null) {
      this.mEvents = Collections.synchronizedList(new ArrayList());
    }
    this.mEvents.clear();
    this.mTotalTime = 0;
  }
  
  public void end()
  {
    if (!this.mEnable) {
      return;
    }
    if (this.mCurrentEvent != null)
    {
      this.mCurrentEvent.endTime = System.currentTimeMillis();
      this.mEvents.add(this.mCurrentEvent);
    }
    this.mTotalTime = ((int)(SystemClock.elapsedRealtime() - this.mStartTime));
    LogUtils.d("hippy", "hippy endEvent: " + this.mCurrentEvent.eventName);
  }
  
  public List<HippyEngineMonitorEvent> getEvents()
  {
    return this.mEvents;
  }
  
  public int getTotalTime()
  {
    return this.mTotalTime;
  }
  
  public void startEvent(String paramString)
  {
    if (!this.mEnable) {}
    do
    {
      return;
      if (this.mCurrentEvent != null)
      {
        this.mCurrentEvent.endTime = System.currentTimeMillis();
        this.mEvents.add(this.mCurrentEvent);
        LogUtils.d("hippy", "hippy endEvent: " + this.mCurrentEvent.eventName);
      }
    } while (TextUtils.isEmpty(paramString));
    this.mCurrentEvent = new HippyEngineMonitorEvent();
    this.mCurrentEvent.eventName = paramString;
    this.mCurrentEvent.startTime = System.currentTimeMillis();
    LogUtils.d("hippy", "hippy startEvent: " + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.utils.TimeMonitor
 * JD-Core Version:    0.7.0.1
 */