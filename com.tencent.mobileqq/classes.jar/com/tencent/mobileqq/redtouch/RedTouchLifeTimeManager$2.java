package com.tencent.mobileqq.redtouch;

import android.app.Activity;
import android.content.ComponentName;
import android.os.Bundle;
import android.text.TextUtils;
import mqq.app.QActivityLifecycleCallbacks;

class RedTouchLifeTimeManager$2
  implements QActivityLifecycleCallbacks
{
  RedTouchLifeTimeManager$2(RedTouchLifeTimeManager paramRedTouchLifeTimeManager) {}
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity) {}
  
  public void onActivityPaused(Activity paramActivity) {}
  
  public void onActivityResumed(Activity paramActivity)
  {
    if (paramActivity.getComponentName() != null)
    {
      RedTouchLifeTimeManager.a(this.a, paramActivity.getComponentName().getClassName());
      if ((!TextUtils.isEmpty(RedTouchLifeTimeManager.a(this.a))) && (RedTouchLifeTimeManager.a(this.a).equals(RedTouchLifeTimeManager.b(this.a)))) {
        RedTouchLifeTimeManager.a(this.a);
      }
    }
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity) {}
  
  public void onActivityStopped(Activity paramActivity) {}
  
  public void onProcessBackground() {}
  
  public void onProcessForeground() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.redtouch.RedTouchLifeTimeManager.2
 * JD-Core Version:    0.7.0.1
 */