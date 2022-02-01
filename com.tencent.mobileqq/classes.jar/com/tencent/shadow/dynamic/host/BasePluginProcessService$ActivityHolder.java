package com.tencent.shadow.dynamic.host;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BasePluginProcessService$ActivityHolder
  implements Application.ActivityLifecycleCallbacks
{
  private List<Activity> mActivities = new LinkedList();
  
  void finishAll()
  {
    Iterator localIterator = this.mActivities.iterator();
    while (localIterator.hasNext()) {
      ((Activity)localIterator.next()).finish();
    }
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    this.mActivities.add(paramActivity);
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    this.mActivities.remove(paramActivity);
  }
  
  public void onActivityPaused(Activity paramActivity) {}
  
  public void onActivityResumed(Activity paramActivity) {}
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity) {}
  
  public void onActivityStopped(Activity paramActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.shadow.dynamic.host.BasePluginProcessService.ActivityHolder
 * JD-Core Version:    0.7.0.1
 */