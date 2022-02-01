package com.tencent.mobileqq.kandian.biz.ugc.publishvideotask;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import android.support.annotation.VisibleForTesting;

@VisibleForTesting
class RIJUgcVideoPublishManager$RIJUgcVideoPublishManagerActivityLifecycleCallbacks
  implements Application.ActivityLifecycleCallbacks
{
  private int b = 0;
  private int c = 0;
  private boolean d = false;
  
  RIJUgcVideoPublishManager$RIJUgcVideoPublishManagerActivityLifecycleCallbacks(RIJUgcVideoPublishManager paramRIJUgcVideoPublishManager) {}
  
  public void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public boolean a()
  {
    return this.b == 0;
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity) {}
  
  public void onActivityPaused(Activity paramActivity)
  {
    int i = this.c;
    if (i == 1)
    {
      this.c = (i - 1);
      return;
    }
    this.b += 1;
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    this.c += 1;
    if (this.d) {
      RIJUgcVideoPublishManager.h(this.a);
    }
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity)
  {
    this.b += 1;
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    this.b -= 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.publishvideotask.RIJUgcVideoPublishManager.RIJUgcVideoPublishManagerActivityLifecycleCallbacks
 * JD-Core Version:    0.7.0.1
 */