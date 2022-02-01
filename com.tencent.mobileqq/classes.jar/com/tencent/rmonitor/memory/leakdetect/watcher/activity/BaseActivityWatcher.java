package com.tencent.rmonitor.memory.leakdetect.watcher.activity;

import android.app.Activity;
import android.support.annotation.NonNull;
import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.rmonitor.memory.leakdetect.ActivityLeakSolution;
import com.tencent.rmonitor.memory.leakdetect.MemoryLeakInspector;
import com.tencent.rmonitor.memory.leakdetect.watcher.BaseObjectWatcher;

abstract class BaseActivityWatcher
  extends BaseObjectWatcher
{
  public BaseActivityWatcher(MemoryLeakInspector paramMemoryLeakInspector)
  {
    super(paramMemoryLeakInspector);
  }
  
  protected void a(@NonNull Activity paramActivity)
  {
    ActivityLeakSolution.fixInputMethodManagerLeak(paramActivity);
    ActivityLeakSolution.fixAudioManagerLeak(paramActivity);
    try
    {
      this.a.a(paramActivity, "");
      return;
    }
    catch (Exception paramActivity)
    {
      Logger.b.a("RMonitor_memory_BaseActivityWatcher", paramActivity);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.memory.leakdetect.watcher.activity.BaseActivityWatcher
 * JD-Core Version:    0.7.0.1
 */