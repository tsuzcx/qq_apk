package com.tencent.qqlive.module.videoreport.utils;

import android.os.MessageQueue.IdleHandler;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.task.ThreadUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class DelayedIdleHandler$IdleHandler
  implements MessageQueue.IdleHandler
{
  private DelayedIdleHandler$IdleHandler(DelayedIdleHandler paramDelayedIdleHandler) {}
  
  public boolean queueIdle()
  {
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.d("DelayedIdleHandler", "onIdle");
    }
    Object localObject1 = new ArrayList(DelayedIdleHandler.access$300(this.this$0).entrySet());
    DelayedIdleHandler.access$300(this.this$0).clear();
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
      DelayedIdleHandler.DelayedRunnable localDelayedRunnable = (DelayedIdleHandler.DelayedRunnable)((Map.Entry)localObject2).getKey();
      ThreadUtils.removeOnUiThread((Runnable)((Map.Entry)localObject2).getValue());
      if (VideoReportInner.getInstance().isDebugMode())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("run by idle, task = ");
        ((StringBuilder)localObject2).append(localDelayedRunnable);
        Log.d("DelayedIdleHandler", ((StringBuilder)localObject2).toString());
      }
      localDelayedRunnable.run(0);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.utils.DelayedIdleHandler.IdleHandler
 * JD-Core Version:    0.7.0.1
 */