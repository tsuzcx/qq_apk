package com.tencent.rmonitor.memory.leakdetect.watcher.activity;

import android.os.Build.VERSION;
import com.tencent.rmonitor.common.lifecycle.IActivityStateCallback;
import com.tencent.rmonitor.common.lifecycle.LifecycleCallback;
import com.tencent.rmonitor.memory.leakdetect.MemoryLeakInspector;

public class ActivityWatcher
  extends BaseActivityWatcher
{
  private final IActivityStateCallback b = new ActivityWatcher.1(this);
  
  public ActivityWatcher(MemoryLeakInspector paramMemoryLeakInspector)
  {
    super(paramMemoryLeakInspector);
  }
  
  public boolean a()
  {
    LifecycleCallback.a(this.b);
    return true;
  }
  
  public void b()
  {
    LifecycleCallback.b(this.b);
  }
  
  public boolean c()
  {
    return Build.VERSION.SDK_INT >= 14;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.memory.leakdetect.watcher.activity.ActivityWatcher
 * JD-Core Version:    0.7.0.1
 */