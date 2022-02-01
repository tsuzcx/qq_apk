package com.tencent.rmonitor.memory.leakdetect;

import android.os.Handler;
import com.tencent.rmonitor.base.plugin.listener.IMemoryLeakListener;
import com.tencent.rmonitor.base.plugin.listener.ListenerManager;
import com.tencent.rmonitor.base.plugin.listener.MonitorListenerMng;
import com.tencent.rmonitor.base.plugin.monitor.QAPMMonitorPlugin;
import com.tencent.rmonitor.common.thread.ThreadManager;
import com.tencent.rmonitor.memory.leakdetect.watcher.AppWatcher;

public class MemoryLeakMonitor
  extends QAPMMonitorPlugin
{
  private MemoryLeakInspector a;
  private AppWatcher b;
  
  private AppWatcher a(MemoryLeakInspector paramMemoryLeakInspector)
  {
    return new AppWatcher(paramMemoryLeakInspector);
  }
  
  public static MemoryLeakMonitor getInstance()
  {
    return MemoryLeakMonitor.Holder.a();
  }
  
  public void start()
  {
    try
    {
      if (this.a == null)
      {
        Handler localHandler = new Handler(ThreadManager.e());
        IMemoryLeakListener localIMemoryLeakListener = (IMemoryLeakListener)ListenerManager.a.b();
        Object localObject1 = localIMemoryLeakListener;
        if (localIMemoryLeakListener == null) {
          localObject1 = new EmptyMemoryLeakListener();
        }
        this.a = new MemoryLeakInspector(localHandler, (IMemoryLeakListener)localObject1);
        this.b = a(this.a);
      }
      this.b.a();
      return;
    }
    finally {}
  }
  
  public void stop()
  {
    Object localObject = this.a;
    if (localObject != null) {
      ((MemoryLeakInspector)localObject).a();
    }
    localObject = this.b;
    if (localObject != null) {
      ((AppWatcher)localObject).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.memory.leakdetect.MemoryLeakMonitor
 * JD-Core Version:    0.7.0.1
 */