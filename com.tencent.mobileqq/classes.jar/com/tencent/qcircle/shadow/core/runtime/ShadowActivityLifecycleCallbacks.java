package com.tencent.qcircle.shadow.core.runtime;

import android.os.Bundle;

public abstract interface ShadowActivityLifecycleCallbacks
{
  public abstract void onActivityCreated(ShadowActivity paramShadowActivity, Bundle paramBundle);
  
  public abstract void onActivityDestroyed(ShadowActivity paramShadowActivity);
  
  public abstract void onActivityPaused(ShadowActivity paramShadowActivity);
  
  public abstract void onActivityResumed(ShadowActivity paramShadowActivity);
  
  public abstract void onActivitySaveInstanceState(ShadowActivity paramShadowActivity, Bundle paramBundle);
  
  public abstract void onActivityStarted(ShadowActivity paramShadowActivity);
  
  public abstract void onActivityStopped(ShadowActivity paramShadowActivity);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.shadow.core.runtime.ShadowActivityLifecycleCallbacks
 * JD-Core Version:    0.7.0.1
 */