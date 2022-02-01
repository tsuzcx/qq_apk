package com.tencent.rmonitor.memory.leakdetect;

import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.rmonitor.base.meta.InspectUUID;
import com.tencent.rmonitor.base.plugin.listener.IMemoryLeakListener;
import com.tencent.rmonitor.base.plugin.monitor.PluginController;
import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.rmonitor.common.util.RecyclablePool;
import java.lang.ref.WeakReference;
import java.util.UUID;

public class MemoryLeakInspector
{
  private static final RecyclablePool a = new RecyclablePool(InspectUUID.class, 20);
  private static long b = 0L;
  private final Handler c;
  private final IMemoryLeakListener d;
  private final MemoryLeakReporter e = new MemoryLeakReporter();
  
  public MemoryLeakInspector(Handler paramHandler, IMemoryLeakListener paramIMemoryLeakListener)
  {
    this.c = paramHandler;
    this.d = paramIMemoryLeakListener;
  }
  
  private void b(@NonNull Object paramObject, String paramString)
  {
    if (this.d.onFilter(paramObject)) {
      return;
    }
    paramObject = c(paramObject, paramString);
    if (paramObject != null)
    {
      paramObject = new MemoryLeakInspector.InspectorRunner(paramObject, 0, this.c, this.d, this.e);
      this.c.post(paramObject);
    }
  }
  
  @Nullable
  private InspectUUID c(@NonNull Object paramObject, String paramString)
  {
    try
    {
      InspectUUID localInspectUUID = (InspectUUID)a.a(InspectUUID.class);
      if (localInspectUUID == null) {
        return null;
      }
      localInspectUUID.weakObj = new WeakReference(paramObject);
      localInspectUUID.uuid = UUID.randomUUID().toString().toCharArray();
      localInspectUUID.digest = paramString;
      localInspectUUID.className = paramObject.getClass().getName();
      return localInspectUUID;
    }
    catch (Exception paramObject) {}
    return null;
  }
  
  private static void d()
  {
    long l = System.currentTimeMillis();
    if (l - b >= 5000L)
    {
      System.runFinalization();
      Runtime.getRuntime().gc();
      b = l;
    }
  }
  
  public void a()
  {
    this.c.removeCallbacksAndMessages(null);
  }
  
  public void a(@NonNull Object paramObject, String paramString)
  {
    if (this.d == null)
    {
      Logger.b.e(new String[] { "RMonitor_memory_LeakInspector", "Please init a listener first!" });
      return;
    }
    if (!PluginController.b.b(107)) {
      return;
    }
    if (!PluginController.b.d(107))
    {
      Logger.b.i(new String[] { "RMonitor_memory_LeakInspector", "leakSampleLost" });
      return;
    }
    b(paramObject, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.memory.leakdetect.MemoryLeakInspector
 * JD-Core Version:    0.7.0.1
 */