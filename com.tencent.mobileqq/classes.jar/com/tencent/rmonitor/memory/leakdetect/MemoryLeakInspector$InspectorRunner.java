package com.tencent.rmonitor.memory.leakdetect;

import android.os.Handler;
import com.tencent.rmonitor.base.config.data.MemoryLeakPluginConfig;
import com.tencent.rmonitor.base.meta.DumpResult;
import com.tencent.rmonitor.base.meta.InspectUUID;
import com.tencent.rmonitor.base.plugin.listener.IMemoryLeakListener;
import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.rmonitor.common.util.RecyclablePool;
import com.tencent.rmonitor.memory.MemoryConfigHelper;
import com.tencent.rmonitor.memory.MemoryDumpHelper;
import java.lang.ref.WeakReference;

public class MemoryLeakInspector$InspectorRunner
  implements Runnable
{
  private int a = 0;
  private final InspectUUID b;
  private final Handler c;
  private final IMemoryLeakListener d;
  private final MemoryLeakReporter e;
  
  public MemoryLeakInspector$InspectorRunner(InspectUUID paramInspectUUID, int paramInt, Handler paramHandler, IMemoryLeakListener paramIMemoryLeakListener, MemoryLeakReporter paramMemoryLeakReporter)
  {
    this.a = paramInt;
    this.b = paramInspectUUID;
    this.c = paramHandler;
    this.d = paramIMemoryLeakListener;
    this.e = paramMemoryLeakReporter;
  }
  
  public void run()
  {
    Object localObject1 = this.b;
    if (localObject1 == null)
    {
      Logger.b.w(new String[] { "RMonitor_memory_LeakInspector", "uuid is null" });
      return;
    }
    String str = ((InspectUUID)localObject1).toString();
    try
    {
      Logger.b.d(new String[] { "RMonitor_memory_LeakInspector", "Inspecting ", str, " Time=", String.valueOf(System.currentTimeMillis()), " count=", String.valueOf(this.a) });
      localObject1 = MemoryConfigHelper.d();
      if ((this.b.weakObj != null) && (this.b.weakObj.get() != null))
      {
        int i = this.a + 1;
        this.a = i;
        if (i < ((MemoryLeakPluginConfig)localObject1).d())
        {
          MemoryLeakInspector.b();
          this.d.onCheckingLeaked((this.a - 1) * 5000 / 1000, str);
          this.c.postDelayed(this, 5000L);
          return;
        }
        if (!this.d.onLeaked(this.b))
        {
          if (((MemoryLeakPluginConfig)localObject1).e()) {
            return;
          }
          MemoryLeakInspector.c().a(this.b);
          return;
        }
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(str);
        ((StringBuilder)localObject2).append("_leak");
        localObject2 = MemoryDumpHelper.a(str, ((StringBuilder)localObject2).toString(), ((MemoryLeakPluginConfig)localObject1).c(), true, this.d);
        if (((DumpResult)localObject2).success)
        {
          localObject1 = "";
          if (this.b.uuid != null) {
            localObject1 = new String(this.b.uuid);
          }
          this.e.a(this.b.className, (String)localObject1, ((DumpResult)localObject2).zipFilePath);
        }
      }
      else
      {
        Logger.b.d(new String[] { "RMonitor_memory_LeakInspector", "inspect ", str, " finished no leak" });
        MemoryLeakInspector.c().a(this.b);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      Logger.b.e(new String[] { "RMonitor_memory_LeakInspector", "error, ", str, " Time=", String.valueOf(System.currentTimeMillis()), " count=", String.valueOf(this.a), " Throwable: ", Logger.b.a(localThrowable) });
      MemoryLeakInspector.c().a(this.b);
    }
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.memory.leakdetect.MemoryLeakInspector.InspectorRunner
 * JD-Core Version:    0.7.0.1
 */