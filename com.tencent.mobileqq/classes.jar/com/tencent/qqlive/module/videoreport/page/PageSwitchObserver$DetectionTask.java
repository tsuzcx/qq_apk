package com.tencent.qqlive.module.videoreport.page;

import android.app.Activity;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.utils.DelayedIdleHandler.DelayedRunnable;
import java.lang.ref.WeakReference;

class PageSwitchObserver$DetectionTask
  extends DelayedIdleHandler.DelayedRunnable
{
  private WeakReference<Activity> mActivityRef = new WeakReference(null);
  
  private PageSwitchObserver$DetectionTask(PageSwitchObserver paramPageSwitchObserver) {}
  
  Activity getActivity()
  {
    if (this.mActivityRef != null) {
      return (Activity)this.mActivityRef.get();
    }
    return null;
  }
  
  public void run(int paramInt)
  {
    if (this.mActivityRef != null) {}
    for (Activity localActivity = (Activity)this.mActivityRef.get();; localActivity = null)
    {
      if (VideoReportInner.getInstance().isDebugMode())
      {
        Log.d("PageSwitchObserver", "PendingTask.run: -------------------------------------------------------------------");
        Log.d("PageSwitchObserver", "PendingTask.run: activity = " + localActivity + ", mIsAppForeground = " + PageSwitchObserver.access$400(this.this$0));
      }
      if ((PageSwitchObserver.access$400(this.this$0)) && (localActivity != null) && (!localActivity.isFinishing())) {
        break;
      }
      return;
    }
    PageSwitchObserver.access$500(this.this$0, localActivity, paramInt);
    this.mActivityRef = null;
  }
  
  void setActivity(Activity paramActivity)
  {
    this.mActivityRef = new WeakReference(paramActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.page.PageSwitchObserver.DetectionTask
 * JD-Core Version:    0.7.0.1
 */