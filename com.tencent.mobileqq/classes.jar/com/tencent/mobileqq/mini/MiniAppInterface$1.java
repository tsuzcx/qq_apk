package com.tencent.mobileqq.mini;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class MiniAppInterface$1
  implements Application.ActivityLifecycleCallbacks
{
  MiniAppInterface$1(MiniAppInterface paramMiniAppInterface) {}
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity) {}
  
  public void onActivityPaused(Activity paramActivity)
  {
    QLog.e("mini_ActivityLifecycle", 1, "onActivityPaused " + paramActivity.getClass().getSimpleName());
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    if (MiniAppInterface.access$000(this.this$0).contains(paramActivity)) {}
    do
    {
      return;
      MiniAppInterface.access$000(this.this$0).add(paramActivity);
    } while (MiniAppInterface.access$000(this.this$0).size() != 1);
    this.this$0.onEnterForeground();
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity) {}
  
  public void onActivityStopped(Activity paramActivity)
  {
    MiniAppInterface.access$000(this.this$0).remove(paramActivity);
    if (MiniAppInterface.access$000(this.this$0).size() == 0) {
      this.this$0.onEnterBackground();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.MiniAppInterface.1
 * JD-Core Version:    0.7.0.1
 */