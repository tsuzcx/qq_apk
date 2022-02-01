package com.tencent.mobileqq.guild.audio.frame;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManager;

class FloatWindowPermissionHandler$1
  implements Application.ActivityLifecycleCallbacks
{
  FloatWindowPermissionHandler$1(FloatWindowPermissionHandler paramFloatWindowPermissionHandler) {}
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity) {}
  
  public void onActivityPaused(Activity paramActivity) {}
  
  public void onActivityResumed(Activity paramActivity)
  {
    ThreadManager.getUIHandlerV2().post(new FloatWindowPermissionHandler.1.1(this));
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity) {}
  
  public void onActivityStopped(Activity paramActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.frame.FloatWindowPermissionHandler.1
 * JD-Core Version:    0.7.0.1
 */