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
    if (this.uuid == null) {
      Logger.INSTANCE.w(new String[] { "QAPM_memory_LeakInspector", "uuid is null" });
    }
    String str;
    DumpResult localDumpResult;
    do
    {
      do
      {
        return;
        str = this.uuid.toString();
        try
        {
          Logger.INSTANCE.d(new String[] { "QAPM_memory_LeakInspector", "Inspecting ", str, " Time=", String.valueOf(System.currentTimeMillis()), " count=", String.valueOf(this.retryCount) });
          if (this.uuid.weakObj.get() == null) {
            break label326;
          }
          int i = this.retryCount + 1;
          this.retryCount = i;
          if (i < LeakInspector.access$000())
          {
            LeakInspector.access$100();
            LeakInspector.access$200(this.this$0).onCheckingLeaked((this.retryCount - 1) * 5000 / 1000, str);
            LeakInspector.access$300(this.this$0).postDelayed(this, 5000L);
            return;
          }
        }
        catch (Throwable localThrowable)
        {
          Logger.INSTANCE.e(new String[] { "QAPM_memory_LeakInspector", "error, ", str, " Time=", String.valueOf(System.currentTimeMillis()), " count=", String.valueOf(this.retryCount), " Throwable: ", Logger.INSTANCE.getThrowableMessage(localThrowable) });
          LeakInspector.access$500().recycle(this.uuid);
          return;
        }
        if (LeakInspector.access$200(this.this$0).onLeaked(this.uuid)) {
          break;
        }
      } while (LeakInspector.access$400());
      LeakInspector.access$500().recycle(this.uuid);
      return;
      localDumpResult = LeakInspector.dumpMemory(str, LeakInspector.access$600(), LeakInspector.access$200(this.this$0));
    } while (!localDumpResult.success);
    LeakInspector.report(this.uuid.className, localDumpResult.zipFilePath);
    return;
    label326:
    Logger.INSTANCE.d(new String[] { "QAPM_memory_LeakInspector", "inspect ", str, " finished no leak" });
    LeakInspector.access$500().recycle(this.uuid);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qapmsdk.memory.leakdetect.LeakInspector.InspectorRunner
 * JD-Core Version:    0.7.0.1
 */