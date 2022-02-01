package com.tencent.youtu.sdkkitframework.framework;

import android.os.Process;
import com.tencent.youtu.sdkkitframework.common.YtLogger;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.Lock;

class YtFSM$1
  implements Runnable
{
  YtFSM$1(YtFSM paramYtFSM, int paramInt, long paramLong) {}
  
  public void run()
  {
    Process.setThreadPriority(this.val$threadPriority);
    while (YtFSM.access$100(this.this$0))
    {
      try
      {
        YtFSM.access$200(this.this$0).lock();
        if (YtFSM.access$300(this.this$0))
        {
          String str = null;
          Object localObject1 = null;
          if (YtFSM.access$400(this.this$0) == YtFSM.YtFSMUpdateStrategy.CacheStrategy)
          {
            localObject1 = (YtFSM.YtFSMUpdateData)YtFSM.access$500(this.this$0).poll();
          }
          else
          {
            if (YtFSM.access$400(this.this$0) == YtFSM.YtFSMUpdateStrategy.NoCacheStrategy)
            {
              str = YtFSM.access$600();
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("no cache str size:");
              localStringBuilder.append(YtFSM.access$500(this.this$0).size());
              YtLogger.i(str, localStringBuilder.toString());
              while (YtFSM.access$500(this.this$0).size() > 0) {
                localObject1 = (YtFSM.YtFSMUpdateData)YtFSM.access$500(this.this$0).poll();
              }
            }
            localObject1 = YtFSM.access$600();
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("unknown strategy ");
            localStringBuilder.append(YtFSM.access$400(this.this$0));
            YtLogger.e((String)localObject1, localStringBuilder.toString());
            localObject1 = str;
          }
          if (localObject1 != null)
          {
            YtFSM.access$702(this.this$0, (YtFSM.YtFSMUpdateData)localObject1);
            if (YtFSM.access$800(this.this$0) != null) {
              YtFSM.access$800(this.this$0).update(YtFSM.access$700(this.this$0).imageData, YtFSM.access$700(this.this$0).imageWidth, YtFSM.access$700(this.this$0).imageHeight, YtFSM.access$700(this.this$0).imageType, YtFSM.access$700(this.this$0).timeStamp);
            }
          }
        }
      }
      finally
      {
        label303:
        YtFSM.access$200(this.this$0).unlock();
      }
      try
      {
        Thread.sleep(10L);
      }
      catch (InterruptedException localInterruptedException)
      {
        break label303;
      }
      YtLogger.e(YtFSM.access$600(), "sleep failed");
      if ((YtFSM.access$800(this.this$0) != null) && (YtFSM.access$800(this.this$0).getStateSimpleName().contains("ReqResult"))) {
        YtFSM.access$902(this.this$0, false);
      }
      if ((YtFSM.access$900(this.this$0)) && (YtFSM.access$1000(this.this$0) > 0L) && (this.val$updateTimeoutMs > 0L) && (System.currentTimeMillis() > YtFSM.access$1000(this.this$0) + this.val$updateTimeoutMs))
      {
        YtFSM.getInstance().sendFSMEvent(new YtFSM.1.1(this));
        YtFSM.getInstance().transitNow(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.IDLE_STATE));
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.framework.YtFSM.1
 * JD-Core Version:    0.7.0.1
 */