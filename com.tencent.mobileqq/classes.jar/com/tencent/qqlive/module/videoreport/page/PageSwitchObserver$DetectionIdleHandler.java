package com.tencent.qqlive.module.videoreport.page;

import android.app.Activity;
import android.os.MessageQueue.IdleHandler;
import android.support.annotation.NonNull;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.task.ThreadUtils;
import com.tencent.qqlive.module.videoreport.utils.ActivityCompat;
import java.lang.ref.WeakReference;
import java.util.Set;

class PageSwitchObserver$DetectionIdleHandler
  implements MessageQueue.IdleHandler
{
  private WeakReference<Activity> mActivityRef = new WeakReference(null);
  
  private PageSwitchObserver$DetectionIdleHandler(PageSwitchObserver paramPageSwitchObserver) {}
  
  private boolean isDetectable(@NonNull Activity paramActivity)
  {
    if (!PageSwitchObserver.access$200(this.this$0)) {}
    while ((!PageSwitchObserver.access$500(this.this$0).contains(paramActivity)) && (!ActivityCompat.isResumed(paramActivity))) {
      return false;
    }
    return true;
  }
  
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
      if ((localActivity != null) && (isDetectable(localActivity))) {
        break;
      }
      if (VideoReportInner.getInstance().isDebugMode()) {
        Log.d("PageSwitchObserver", "PendingTask.run: activity undetectable");
      }
      return false;
    }
    ThreadUtils.runOnUiThread(new PageSwitchObserver.DetectionIdleHandler.1(this, localActivity));
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