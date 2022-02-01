package com.tencent.pts.core;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import com.tencent.pts.utils.PTSLog;

class PTSComposer$1
  implements Application.ActivityLifecycleCallbacks
{
  PTSComposer$1(PTSComposer paramPTSComposer, Application paramApplication) {}
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    PTSLog.i("PTSComposer", "[onActivityDestroyed]");
    PTSAppInstance localPTSAppInstance = PTSComposer.access$000(this.this$0);
    if ((localPTSAppInstance != null) && (localPTSAppInstance.getContext() == paramActivity))
    {
      this.this$0.destroy();
      if (this.val$application != null)
      {
        this.val$application.unregisterActivityLifecycleCallbacks(PTSComposer.access$100(this.this$0));
        PTSLog.i("PTSComposer", "[unregisterActivityLifecycleCallbacks] finished, appInstance = " + localPTSAppInstance);
      }
    }
  }
  
  public void onActivityPaused(Activity paramActivity) {}
  
  public void onActivityResumed(Activity paramActivity) {}
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity) {}
  
  public void onActivityStopped(Activity paramActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pts.core.PTSComposer.1
 * JD-Core Version:    0.7.0.1
 */