package com.tencent.qqlive.module.videoreport.collect;

import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import java.util.Set;

class EventNotifyManager$2
  implements Runnable
{
  EventNotifyManager$2(EventNotifyManager paramEventNotifyManager) {}
  
  public void run()
  {
    if (VideoReportInner.getInstance().isDebugMode())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("mClearImmediateNotifierRunnable.run: mImmediateNotifySet = ");
      ((StringBuilder)???).append(EventNotifyManager.access$100(this.this$0));
      Log.i("EventNotifyManager", ((StringBuilder)???).toString());
    }
    synchronized (EventNotifyManager.access$200(this.this$0))
    {
      EventNotifyManager.access$100(this.this$0).clear();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.collect.EventNotifyManager.2
 * JD-Core Version:    0.7.0.1
 */