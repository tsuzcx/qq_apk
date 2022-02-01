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
    Object localObject = new ArrayList(DelayedIdleHandler.access$300(this.this$0).entrySet());
    DelayedIdleHandler.access$300(this.this$0).clear();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      DelayedIdleHandler.DelayedRunnable localDelayedRunnable = (DelayedIdleHandler.DelayedRunnable)localEntry.getKey();
      ThreadUtils.removeOnUiThread((Runnable)localEntry.getValue());
      if (VideoReportInner.getInstance().isDebugMode()) {
        Log.d("DelayedIdleHandler", "run by idle, task = " + localDelayedRunnable);
      }
      localDelayedRunnable.run(0);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.utils.DelayedIdleHandler.IdleHandler
 * JD-Core Version:    0.7.0.1
 */