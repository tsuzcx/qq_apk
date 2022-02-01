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
    WeakReference localWeakReference = this.mActivityRef;
    if (localWeakReference != null) {
      return (Activity)localWeakReference.get();
    }
    return null;
  }
  
  public void run(int paramInt)
  {
    Object localObject = this.mActivityRef;
    if (localObject != null) {
      localObject = (Activity)((WeakReference)localObject).get();
    } else {
      localObject = null;
    }
    if (VideoReportInner.getInstance().isDebugMode())
    {
      Log.d("PageSwitchObserver", "PendingTask.run: -------------------------------------------------------------------");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("PendingTask.run: activity = ");
      localStringBuilder.append(localObject);
      localStringBuilder.append(", mIsAppForeground = ");
      localStringBuilder.append(PageSwitchObserver.access$400(this.this$0));
      Log.d("PageSwitchObserver", localStringBuilder.toString());
    }
    if ((PageSwitchObserver.access$400(this.this$0)) && (localObject != null))
    {
      if (((Activity)localObject).isFinishing()) {
        return;
      }
      PageSwitchObserver.access$500(this.this$0, (Activity)localObject, paramInt);
      this.mActivityRef = null;
    }
  }
  
  void setActivity(Activity paramActivity)
  {
    this.mActivityRef = new WeakReference(paramActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.page.PageSwitchObserver.DetectionTask
 * JD-Core Version:    0.7.0.1
 */