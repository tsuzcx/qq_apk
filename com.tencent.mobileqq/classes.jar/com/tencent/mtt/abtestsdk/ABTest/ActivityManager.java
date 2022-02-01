package com.tencent.mtt.abtestsdk.ABTest;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import com.tencent.mtt.abtestsdk.utils.ABTestLog;
import java.util.Stack;

public class ActivityManager
  implements Application.ActivityLifecycleCallbacks
{
  private static final String TAG = "ActivityManager";
  private static volatile ActivityManager activityManager;
  private Stack<Activity> activities = new Stack();
  
  public static ActivityManager getInstance()
  {
    if (activityManager == null) {}
    try
    {
      if (activityManager == null) {
        activityManager = new ActivityManager();
      }
      return activityManager;
    }
    finally {}
  }
  
  public void addActivity(Activity paramActivity)
  {
    this.activities.add(paramActivity);
  }
  
  public void finishActivity()
  {
    finishActivity((Activity)this.activities.lastElement());
  }
  
  public void finishActivity(Activity paramActivity)
  {
    if (paramActivity != null)
    {
      removeActivity(paramActivity);
      paramActivity.finish();
    }
  }
  
  public Stack<Activity> getActivityStack()
  {
    return this.activities;
  }
  
  public Activity getCurrentActivity()
  {
    ABTestLog.info("activity size = " + this.activities.size(), new Object[0]);
    if (this.activities.size() != 0) {
      return (Activity)this.activities.lastElement();
    }
    return null;
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    addActivity(paramActivity);
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    removeActivity(paramActivity);
    if (this.activities.size() == 0) {
      ABTestManager.getInstance().saveConfigInfo();
    }
  }
  
  public void onActivityPaused(Activity paramActivity) {}
  
  public void onActivityResumed(Activity paramActivity) {}
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity) {}
  
  public void onActivityStopped(Activity paramActivity) {}
  
  public void removeActivity(Activity paramActivity)
  {
    if (paramActivity != null) {
      this.activities.remove(paramActivity);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.abtestsdk.ABTest.ActivityManager
 * JD-Core Version:    0.7.0.1
 */