package com.tencent.shadow.core.runtime;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import com.tencent.shadow.core.runtime.qcircle.container.PluginContainerActivity;

public class ShadowActivityLifecycleCallbacks$Wrapper
  implements Application.ActivityLifecycleCallbacks
{
  final ShadowActivityLifecycleCallbacks shadowActivityLifecycleCallbacks;
  final ShadowApplication shadowApplication;
  
  public ShadowActivityLifecycleCallbacks$Wrapper(ShadowActivityLifecycleCallbacks paramShadowActivityLifecycleCallbacks, ShadowApplication paramShadowApplication)
  {
    this.shadowActivityLifecycleCallbacks = paramShadowActivityLifecycleCallbacks;
    this.shadowApplication = paramShadowApplication;
  }
  
  private boolean checkOwnerActivity(PluginActivity paramPluginActivity)
  {
    return (paramPluginActivity != null) && (paramPluginActivity.mPluginApplication == this.shadowApplication);
  }
  
  private ShadowActivity getPluginActivity(Activity paramActivity)
  {
    if ((paramActivity instanceof PluginContainerActivity)) {
      return (ShadowActivity)((PluginContainerActivity)paramActivity).getPluginActivity();
    }
    return null;
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    paramActivity = getPluginActivity(paramActivity);
    if (checkOwnerActivity(paramActivity)) {
      this.shadowActivityLifecycleCallbacks.onActivityCreated(paramActivity, paramBundle);
    }
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    paramActivity = getPluginActivity(paramActivity);
    if (checkOwnerActivity(paramActivity)) {
      this.shadowActivityLifecycleCallbacks.onActivityDestroyed(paramActivity);
    }
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    paramActivity = getPluginActivity(paramActivity);
    if (checkOwnerActivity(paramActivity)) {
      this.shadowActivityLifecycleCallbacks.onActivityPaused(paramActivity);
    }
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    paramActivity = getPluginActivity(paramActivity);
    if (checkOwnerActivity(paramActivity)) {
      this.shadowActivityLifecycleCallbacks.onActivityResumed(paramActivity);
    }
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle)
  {
    paramActivity = getPluginActivity(paramActivity);
    if (checkOwnerActivity(paramActivity)) {
      this.shadowActivityLifecycleCallbacks.onActivitySaveInstanceState(paramActivity, paramBundle);
    }
  }
  
  public void onActivityStarted(Activity paramActivity)
  {
    paramActivity = getPluginActivity(paramActivity);
    if (checkOwnerActivity(paramActivity)) {
      this.shadowActivityLifecycleCallbacks.onActivityStarted(paramActivity);
    }
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    paramActivity = getPluginActivity(paramActivity);
    if (checkOwnerActivity(paramActivity)) {
      this.shadowActivityLifecycleCallbacks.onActivityStopped(paramActivity);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.shadow.core.runtime.ShadowActivityLifecycleCallbacks.Wrapper
 * JD-Core Version:    0.7.0.1
 */