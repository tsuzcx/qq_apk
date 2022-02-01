package com.tencent.rmonitor.memory.leakdetect.watcher.activity;

import android.app.Activity;
import android.app.Instrumentation;
import android.support.annotation.NonNull;

class ActivityIceWatcher$MonitorInstrumentation
  extends Instrumentation
{
  private ActivityIceWatcher$MonitorInstrumentation(ActivityIceWatcher paramActivityIceWatcher) {}
  
  public void callActivityOnDestroy(@NonNull Activity paramActivity)
  {
    ActivityIceWatcher.d().callActivityOnDestroy(paramActivity);
    this.a.a(paramActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.memory.leakdetect.watcher.activity.ActivityIceWatcher.MonitorInstrumentation
 * JD-Core Version:    0.7.0.1
 */