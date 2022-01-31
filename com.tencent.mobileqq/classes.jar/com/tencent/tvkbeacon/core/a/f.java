package com.tencent.tvkbeacon.core.a;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import com.tencent.tvkbeacon.core.c.c;
import com.tencent.tvkbeacon.upload.UploadStrategy;

public final class f
  implements Application.ActivityLifecycleCallbacks
{
  private static int a = 0;
  private static boolean b = true;
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityDestroyed(Activity paramActivity) {}
  
  public final void onActivityPaused(Activity paramActivity) {}
  
  public final void onActivityResumed(Activity paramActivity) {}
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityStarted(Activity paramActivity)
  {
    int i = a + 1;
    a = i;
    if (i == 1)
    {
      if (b) {
        break label43;
      }
      c.b("[lifecycle] App in the Foreground! ", new Object[0]);
      if (UploadStrategy.IS_STOP_BACKGROUND_TASK) {
        b.d().c();
      }
    }
    return;
    label43:
    b = false;
    c.b("[lifecycle] Is App First Launch! ", new Object[0]);
  }
  
  public final void onActivityStopped(Activity paramActivity)
  {
    int i = a - 1;
    a = i;
    if (i == 0)
    {
      c.b("[lifecycle] App in the Background! ", new Object[0]);
      if (UploadStrategy.IS_STOP_BACKGROUND_TASK) {
        b.d().b();
      }
      com.tencent.tvkbeacon.i.b.a(paramActivity).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tvkbeacon.core.a.f
 * JD-Core Version:    0.7.0.1
 */