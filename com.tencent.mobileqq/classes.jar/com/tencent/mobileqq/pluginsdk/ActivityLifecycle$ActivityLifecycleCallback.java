package com.tencent.mobileqq.pluginsdk;

import android.app.Activity;
import android.content.Intent;

public abstract interface ActivityLifecycle$ActivityLifecycleCallback
{
  public abstract void onNewIntent(Activity paramActivity, Intent paramIntent);
  
  public abstract void onPause(Activity paramActivity);
  
  public abstract void onResume(Activity paramActivity);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.ActivityLifecycle.ActivityLifecycleCallback
 * JD-Core Version:    0.7.0.1
 */