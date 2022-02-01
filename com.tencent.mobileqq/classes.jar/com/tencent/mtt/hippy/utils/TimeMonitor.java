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
  final boolean mEnable;
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
    HippyEngineMonitorEvent localHippyEngineMonitorEvent = this.mCurrentEvent;
    if (localHippyEngineMonitorEvent != null)
    {
      localHippyEngineMonitorEvent.endTime = System.currentTimeMillis();
      this.mEvents.add(this.mCurrentEvent);
    }
    this.mTotalTime = ((int)(SystemClock.elapsedRealtime() - this.mStartTime));
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
    if (!this.mEnable) {
      return;
    }
    Object localObject = this.mCurrentEvent;
    if (localObject != null)
    {
      ((HippyEngineMonitorEvent)localObject).endTime = System.currentTimeMillis();
      this.mEvents.add(this.mCurrentEvent);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("hippy endEvent: ");
      ((StringBuilder)localObject).append(this.mCurrentEvent.eventName);
      LogUtils.d("hippy", ((StringBuilder)localObject).toString());
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.mCurrentEvent = new HippyEngineMonitorEvent();
    localObject = this.mCurrentEvent;
    ((HippyEngineMonitorEvent)localObject).eventName = paramString;
    ((HippyEngineMonitorEvent)localObject).startTime = System.currentTimeMillis();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("hippy startEvent: ");
    ((StringBuilder)localObject).append(paramString);
    LogUtils.d("hippy", ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.utils.TimeMonitor
 * JD-Core Version:    0.7.0.1
 */