package com.tencent.youtu.sdkkitframework.framework;

import android.os.Process;
import com.tencent.youtu.sdkkitframework.common.YtLogger;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.Lock;

class YtFSM$1
  implements Runnable
{
  YtFSM$1(YtFSM paramYtFSM, int paramInt) {}
  
  public void run()
  {
    Process.setThreadPriority(this.val$threadPriority);
    while (YtFSM.access$100(this.this$0)) {
      try
      {
        YtFSM.access$200(this.this$0).lock();
        if (YtFSM.access$300(this.this$0))
        {
          YtFSM.YtFSMUpdateData localYtFSMUpdateData = (YtFSM.YtFSMUpdateData)YtFSM.access$400(this.this$0).poll();
          if (localYtFSMUpdateData != null)
          {
            YtFSM.access$502(this.this$0, localYtFSMUpdateData);
            if (YtFSM.access$600(this.this$0) != null) {
              YtFSM.access$600(this.this$0).update(YtFSM.access$500(this.this$0).imageData, YtFSM.access$500(this.this$0).imageWidth, YtFSM.access$500(this.this$0).imageHeight, YtFSM.access$500(this.this$0).imageType, YtFSM.access$500(this.this$0).timeStamp);
            }
          }
        }
        YtFSM.access$200(this.this$0).unlock();
        try
        {
          Thread.sleep(10L);
        }
        catch (InterruptedException localInterruptedException)
        {
          YtLogger.e(YtFSM.access$700(), "sleep failed");
        }
      }
      finally
      {
        YtFSM.access$200(this.this$0).unlock();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.framework.YtFSM.1
 * JD-Core Version:    0.7.0.1
 */