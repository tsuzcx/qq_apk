package com.tencent.qapmsdk.memory.leakdetect;

import android.os.Handler;
import com.tencent.qapmsdk.base.listener.IInspectorListener;
import com.tencent.qapmsdk.base.meta.DumpResult;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.common.util.InspectUUID;
import com.tencent.qapmsdk.common.util.RecyclablePool;
import java.lang.ref.WeakReference;

class LeakInspector$InspectorRunner
  implements Runnable
{
  private int retryCount = 0;
  private InspectUUID uuid;
  
  LeakInspector$InspectorRunner(LeakInspector paramLeakInspector, InspectUUID paramInspectUUID, int paramInt)
  {
    this.retryCount = paramInt;
    this.uuid = paramInspectUUID;
  }
  
  public void run()
  {
    Object localObject = this.uuid;
    if (localObject == null)
    {
      Logger.INSTANCE.w(new String[] { "QAPM_memory_LeakInspector", "uuid is null" });
      return;
    }
    localObject = ((InspectUUID)localObject).toString();
    try
    {
      Logger.INSTANCE.d(new String[] { "QAPM_memory_LeakInspector", "Inspecting ", localObject, " Time=", String.valueOf(System.currentTimeMillis()), " count=", String.valueOf(this.retryCount) });
      if (this.uuid.weakObj.get() != null)
      {
        int i = this.retryCount + 1;
        this.retryCount = i;
        if (i < LeakInspector.access$000())
        {
          LeakInspector.access$100();
          LeakInspector.access$200(this.this$0).onCheckingLeaked((this.retryCount - 1) * 5000 / 1000, (String)localObject);
          LeakInspector.access$300(this.this$0).postDelayed(this, 5000L);
          return;
        }
        if (!LeakInspector.access$200(this.this$0).onLeaked(this.uuid))
        {
          if (LeakInspector.access$400()) {
            return;
          }
          LeakInspector.access$500().recycle(this.uuid);
          return;
        }
        DumpResult localDumpResult = LeakInspector.dumpMemory((String)localObject, LeakInspector.access$600(), LeakInspector.access$200(this.this$0));
        if (localDumpResult.success) {
          LeakInspector.report(this.uuid.className, localDumpResult.zipFilePath);
        }
      }
      else
      {
        Logger.INSTANCE.d(new String[] { "QAPM_memory_LeakInspector", "inspect ", localObject, " finished no leak" });
        LeakInspector.access$500().recycle(this.uuid);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      Logger.INSTANCE.e(new String[] { "QAPM_memory_LeakInspector", "error, ", localObject, " Time=", String.valueOf(System.currentTimeMillis()), " count=", String.valueOf(this.retryCount), " Throwable: ", Logger.INSTANCE.getThrowableMessage(localThrowable) });
      LeakInspector.access$500().recycle(this.uuid);
    }
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.memory.leakdetect.LeakInspector.InspectorRunner
 * JD-Core Version:    0.7.0.1
 */