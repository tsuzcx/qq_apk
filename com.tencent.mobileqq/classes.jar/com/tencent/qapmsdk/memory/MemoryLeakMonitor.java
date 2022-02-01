package com.tencent.qapmsdk.memory;

import android.os.Handler;
import android.support.annotation.NonNull;
import com.tencent.qapmsdk.base.listener.IBaseListener;
import com.tencent.qapmsdk.base.listener.IInspectorListener;
import com.tencent.qapmsdk.base.listener.ListenerManager;
import com.tencent.qapmsdk.base.monitorplugin.QAPMMonitorPlugin;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.common.thread.ThreadManager;
import com.tencent.qapmsdk.memory.leakdetect.ActivityWatcher;
import com.tencent.qapmsdk.memory.leakdetect.FragmentWatcher;
import com.tencent.qapmsdk.memory.leakdetect.LeakInspector;
import com.tencent.qapmsdk.memory.memorydump.HeapDumperFactory;

public class MemoryLeakMonitor
  extends QAPMMonitorPlugin
{
  private static final String TAG = "QAPM_memory_MemoryLeakMonitor";
  public static boolean enableFragmentInspect = true;
  
  public void setListener(@NonNull IBaseListener paramIBaseListener)
  {
    try
    {
      ListenerManager.inspectorListener = (IInspectorListener)paramIBaseListener;
      return;
    }
    catch (Exception paramIBaseListener)
    {
      Logger.INSTANCE.exception("QAPM_memory_MemoryLeakMonitor", paramIBaseListener);
    }
  }
  
  public void start()
  {
    if (ListenerManager.inspectorListener != null) {
      LeakInspector.initInspector(new Handler(ThreadManager.getMonitorThreadLooper()), ListenerManager.inspectorListener);
    }
    for (;;)
    {
      LeakInspector.enableAutoDump(true);
      LeakInspector.setDumper(HeapDumperFactory.produce());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qapmsdk.memory.MemoryLeakMonitor
 * JD-Core Version:    0.7.0.1
 */