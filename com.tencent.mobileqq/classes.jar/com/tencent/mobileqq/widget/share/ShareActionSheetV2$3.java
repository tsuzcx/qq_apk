package com.tencent.mobileqq.widget.share;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;

class ShareActionSheetV2$3
  implements Application.ActivityLifecycleCallbacks
{
  ShareActionSheetV2$3(ShareActionSheetV2 paramShareActionSheetV2) {}
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    if (paramActivity == this.a.a)
    {
      ShareActionSheetV2.b(this.a);
      ShareActionSheetV2.c(this.a);
    }
  }
  
  public void onActivityPaused(Activity paramActivity) {}
  
  public void onActivityResumed(Activity paramActivity) {}
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity) {}
  
  public void onActivityStopped(Activity paramActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.share.ShareActionSheetV2.3
 * JD-Core Version:    0.7.0.1
 */