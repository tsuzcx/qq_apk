package com.tencent.mobileqq.qcircle.api.helper;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

final class HostUIHelper$1
  implements Application.ActivityLifecycleCallbacks
{
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    if (HostUIHelper.access$000(paramActivity))
    {
      HostUIHelper.access$102(new WeakReference(paramActivity));
      paramBundle = HostUIHelper.access$200().iterator();
      while (paramBundle.hasNext()) {
        ((HostUIHelper.HostEnvironmentLifeCycle)paramBundle.next()).onEnvironmentCreated(paramActivity);
      }
      HostUIHelper.access$300(paramActivity);
      paramBundle = new StringBuilder();
      paramBundle.append("onActivityCreated:");
      paramBundle.append(paramActivity.hashCode());
      QLog.d("HostUIHelper", 1, paramBundle.toString());
    }
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    if (HostUIHelper.access$000(paramActivity))
    {
      Object localObject = HostUIHelper.access$200().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((HostUIHelper.HostEnvironmentLifeCycle)((Iterator)localObject).next()).onEnvironmentDestroy(paramActivity);
      }
      if ((HostUIHelper.access$100() != null) && (HostUIHelper.access$100().get() != null) && (paramActivity.hashCode() == ((Context)HostUIHelper.access$100().get()).hashCode())) {
        HostUIHelper.access$500();
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onActivityDestroyed:");
      ((StringBuilder)localObject).append(paramActivity.hashCode());
      QLog.d("HostUIHelper", 1, ((StringBuilder)localObject).toString());
    }
    if ((HostUIHelper.isContextShadowActivity(paramActivity)) && (HostUIHelper.access$400() != null) && (HostUIHelper.access$400().get() == paramActivity)) {
      HostUIHelper.access$402(null);
    }
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    if (HostUIHelper.access$000(paramActivity))
    {
      Object localObject = HostUIHelper.access$200().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((HostUIHelper.HostEnvironmentLifeCycle)((Iterator)localObject).next()).onEnvironmentPause(paramActivity);
      }
      if ((paramActivity.getIntent() != null) && (paramActivity.getIntent().getBooleanExtra("key_is_auto_close_host", false))) {
        HostUIHelper.closeHostEnvironment();
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onActivityPaused:");
      ((StringBuilder)localObject).append(paramActivity.hashCode());
      QLog.d("HostUIHelper", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    if (HostUIHelper.access$000(paramActivity))
    {
      Object localObject = HostUIHelper.access$200().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((HostUIHelper.HostEnvironmentLifeCycle)((Iterator)localObject).next()).onEnvironmentResume(paramActivity);
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onActivityResumed:");
      ((StringBuilder)localObject).append(paramActivity.hashCode());
      QLog.d("HostUIHelper", 1, ((StringBuilder)localObject).toString());
    }
    if (HostUIHelper.isContextShadowActivity(paramActivity)) {
      HostUIHelper.access$402(new WeakReference(paramActivity));
    }
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity)
  {
    if (HostUIHelper.access$000(paramActivity))
    {
      Object localObject = HostUIHelper.access$200().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((HostUIHelper.HostEnvironmentLifeCycle)((Iterator)localObject).next()).onEnvironmentStarted(paramActivity);
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onActivityStarted:");
      ((StringBuilder)localObject).append(paramActivity.hashCode());
      QLog.d("HostUIHelper", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    if (HostUIHelper.access$000(paramActivity))
    {
      Object localObject = HostUIHelper.access$200().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((HostUIHelper.HostEnvironmentLifeCycle)((Iterator)localObject).next()).onEnvironmentStop(paramActivity);
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onActivityStopped:");
      ((StringBuilder)localObject).append(paramActivity.hashCode());
      QLog.d("HostUIHelper", 1, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.helper.HostUIHelper.1
 * JD-Core Version:    0.7.0.1
 */