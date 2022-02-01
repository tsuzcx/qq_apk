package com.tencent.rmonitor.memory.leakdetect.watcher.activity;

import android.app.Activity;
import android.support.annotation.NonNull;
import com.tencent.rmonitor.common.lifecycle.SimpleActivityStateCallback;

class ActivityWatcher$1
  extends SimpleActivityStateCallback
{
  ActivityWatcher$1(ActivityWatcher paramActivityWatcher) {}
  
  public void b(@NonNull Activity paramActivity)
  {
    this.a.a(paramActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.memory.leakdetect.watcher.activity.ActivityWatcher.1
 * JD-Core Version:    0.7.0.1
 */