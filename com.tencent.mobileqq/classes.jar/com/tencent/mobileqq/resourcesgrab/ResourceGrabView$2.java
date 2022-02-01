package com.tencent.mobileqq.resourcesgrab;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

class ResourceGrabView$2
  implements Application.ActivityLifecycleCallbacks
{
  ResourceGrabView$2(ResourceGrabView paramResourceGrabView) {}
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("onActivityCreated activity: ");
      paramBundle.append(paramActivity);
      QLog.d("ResourceGrabView", 2, paramBundle.toString());
    }
    ResourceGrabView.a(this.a, new WeakReference(paramActivity));
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onActivityDestroyed activity: ");
      localStringBuilder.append(paramActivity);
      QLog.d("ResourceGrabView", 2, localStringBuilder.toString());
    }
    if ((paramActivity instanceof BaseActivity))
    {
      paramActivity = ((BaseActivity)paramActivity).getSupportFragmentManager().findFragmentByTag("ResourceGrabFragment");
      if ((paramActivity instanceof ResourceGrabFragment)) {
        ((ResourceGrabFragment)paramActivity).c();
      }
    }
    ResourceGrabView.a(this.a, null);
  }
  
  public void onActivityPaused(Activity paramActivity) {}
  
  public void onActivityResumed(Activity paramActivity)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onActivityResumed activity: ");
      localStringBuilder.append(paramActivity);
      QLog.d("ResourceGrabView", 2, localStringBuilder.toString());
    }
    ResourceGrabView.a(this.a, new WeakReference(paramActivity));
    paramActivity = this.a;
    paramActivity.a(ResourceGrabView.a(paramActivity));
    ResourceGrabView.a(this.a);
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity) {}
  
  public void onActivityStopped(Activity paramActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.resourcesgrab.ResourceGrabView.2
 * JD-Core Version:    0.7.0.1
 */