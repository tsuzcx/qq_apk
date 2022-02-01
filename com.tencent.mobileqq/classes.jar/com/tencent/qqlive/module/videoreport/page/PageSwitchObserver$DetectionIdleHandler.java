package com.tencent.qqlive.module.videoreport.page;

import android.app.Activity;
import android.os.MessageQueue.IdleHandler;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import java.lang.ref.WeakReference;

class PageSwitchObserver$DetectionIdleHandler
  implements MessageQueue.IdleHandler
{
  private WeakReference<Activity> mActivityRef = new WeakReference(null);
  
  private PageSwitchObserver$DetectionIdleHandler(PageSwitchObserver paramPageSwitchObserver) {}
  
  Activity getActivity()
  {
    if (this.mActivityRef != null) {
      return (Activity)this.mActivityRef.get();
    }
    return null;
  }
  
  public boolean queueIdle()
  {
    if (this.mActivityRef != null) {}
    for (Activity localActivity = (Activity)this.mActivityRef.get();; localActivity = null)
    {
      if (VideoReportInner.getInstance().isDebugMode())
      {
        Log.d("PageSwitchObserver", "PendingTask.run: -------------------------------------------------------------------");
        Log.d("PageSwitchObserver", "PendingTask.run: activity = " + localActivity + ", mIsAppForeground = " + PageSwitchObserver.access$200(this.this$0));
      }
      if ((PageSwitchObserver.access$200(this.this$0)) && (localActivity != null) && (!localActivity.isFinishing())) {
        break;
      }
      return false;
    }
    PageSwitchObserver.access$300(this.this$0, localActivity);
    this.mActivityRef = null;
    return false;
  }
  
  void setActivity(Activity paramActivity)
  {
    this.mActivityRef = new WeakReference(paramActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.page.PageSwitchObserver.DetectionIdleHandler
 * JD-Core Version:    0.7.0.1
 */