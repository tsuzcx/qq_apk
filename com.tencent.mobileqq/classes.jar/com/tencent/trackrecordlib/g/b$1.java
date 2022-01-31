package com.tencent.trackrecordlib.g;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import android.view.Window;
import com.tencent.trackrecordlib.a.a;
import com.tencent.trackrecordlib.core.a.a;
import com.tencent.trackrecordlib.core.c;

final class b$1
  implements Application.ActivityLifecycleCallbacks
{
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    a.f().a(paramActivity, paramBundle);
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    a.f().c(paramActivity);
    if (paramActivity.getClass().getName().equals(b.a())) {
      c.a().e();
    }
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    a.f().e(paramActivity);
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    a.f().d(paramActivity);
    if ((b.e() != null) && (b.b().equals(b.a()))) {
      b.e().a(paramActivity.getWindow().getDecorView());
    }
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle)
  {
    a.f().b(paramActivity, paramBundle);
  }
  
  public void onActivityStarted(Activity paramActivity)
  {
    a.f().f(paramActivity);
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    a.f().g(paramActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.trackrecordlib.g.b.1
 * JD-Core Version:    0.7.0.1
 */