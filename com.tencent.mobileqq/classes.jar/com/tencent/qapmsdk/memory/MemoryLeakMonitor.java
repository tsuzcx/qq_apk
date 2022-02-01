package com.tencent.qapmsdk.memory;

import android.os.Handler;
import com.tencent.qapmsdk.base.listener.ListenerManager;
import com.tencent.qapmsdk.base.monitorplugin.QAPMMonitorPlugin;
import com.tencent.qapmsdk.common.thread.ThreadManager;
import com.tencent.qapmsdk.memory.leakdetect.ActivityWatcher;
import com.tencent.qapmsdk.memory.leakdetect.FragmentWatcher;
import com.tencent.qapmsdk.memory.leakdetect.LeakInspector;

public class MemoryLeakMonitor
  extends QAPMMonitorPlugin
{
  public static boolean enableFragmentInspect = true;
  
  public void start()
  {
    if (ListenerManager.inspectorListener != null) {
      LeakInspector.initInspector(new Handler(ThreadManager.getMonitorThreadLooper()), ListenerManager.inspectorListener);
    }
    for (;;)
    {
      LeakInspector.enableAutoDump(true);
      ActivityWatcher.startActivityInspect();
      if (enableFragmentInspect) {
        FragmentWatcher.startFragmentInspect();
      }
      return;
      LeakInspector.initInspector(new Handler(ThreadManager.getMonitorThreadLooper()), new MemoryLeakMonitor.1(this));
    }
  }
  
  public void stop() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.memory.MemoryLeakMonitor
 * JD-Core Version:    0.7.0.1
 */