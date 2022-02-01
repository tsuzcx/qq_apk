package com.tencent.mobileqq.kandian.biz.pts.view.polymeric;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import com.tencent.mobileqq.kandian.biz.pts.view.polymeric.helper.ProteusPagerSnapHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class RvPolymericContainer$4
  implements Application.ActivityLifecycleCallbacks
{
  RvPolymericContainer$4(RvPolymericContainer paramRvPolymericContainer, Activity paramActivity) {}
  
  private void a(Activity paramActivity, boolean paramBoolean)
  {
    if (paramActivity != this.a) {
      return;
    }
    paramActivity = new StringBuilder();
    paramActivity.append("visibility changed, visible :  ");
    paramActivity.append(paramBoolean);
    QLog.d("RvPolymericContainer", 1, paramActivity.toString());
    if (paramBoolean)
    {
      RvPolymericContainer.e(this.b);
      return;
    }
    if (RvPolymericContainer.d(this.b) != null) {
      RvPolymericContainer.d(this.b).b();
    }
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    if ((paramActivity == this.a) && (BaseApplication.getContext() != null)) {
      BaseApplication.getContext().unregisterActivityLifecycleCallbacks(this);
    }
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    a(paramActivity, false);
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    a(paramActivity, true);
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity)
  {
    a(paramActivity, true);
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    a(paramActivity, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.polymeric.RvPolymericContainer.4
 * JD-Core Version:    0.7.0.1
 */