package com.tencent.mobileqq.login.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks;

public class AddAccountBaseUI$AddAccountLifeCycle
  implements BaseActivityLifecycleCallbacks
{
  protected AddAccountBaseUI$AddAccountLifeCycle(AddAccountBaseUI paramAddAccountBaseUI) {}
  
  public void doOnActivityCreate(Activity paramActivity, Bundle paramBundle) {}
  
  public void doOnActivityDestroyed(Activity paramActivity)
  {
    this.a.h();
  }
  
  public void doOnActivityOnStart(Activity paramActivity) {}
  
  public void doOnActivityPause(Activity paramActivity) {}
  
  public void doOnActivityPostCreated(Activity paramActivity, Bundle paramBundle)
  {
    this.a.b(paramBundle);
  }
  
  public void doOnActivityPostPaused(Activity paramActivity) {}
  
  public void doOnActivityPostResumed(Activity paramActivity)
  {
    this.a.g();
  }
  
  public void doOnActivityPreCreated(Activity paramActivity, Bundle paramBundle)
  {
    this.a.a(paramBundle);
  }
  
  public void doOnActivityPrePaused(Activity paramActivity) {}
  
  public void doOnActivityPreResumed(Activity paramActivity) {}
  
  public void doOnActivityResume(Activity paramActivity) {}
  
  public void doOnActivityStopped(Activity paramActivity) {}
  
  public void doOnNewIntent(Activity paramActivity, Intent paramIntent) {}
  
  public void doOnWindowFocusChanged(Activity paramActivity, boolean paramBoolean) {}
  
  public void onAccountChanged(Activity paramActivity) {}
  
  public void onMultiWindowModeChanged(Activity paramActivity, boolean paramBoolean) {}
  
  public void onPostThemeChanged(Activity paramActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.login.ui.AddAccountBaseUI.AddAccountLifeCycle
 * JD-Core Version:    0.7.0.1
 */