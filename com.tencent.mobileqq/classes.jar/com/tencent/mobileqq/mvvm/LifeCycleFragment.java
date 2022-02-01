package com.tencent.mobileqq.mvvm;

import android.os.Bundle;
import android.support.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelStore;
import com.tencent.mobileqq.app.BaseFragment;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.qphone.base.util.QLog;

public class LifeCycleFragment
  extends BaseFragment
  implements LifeCycleAndViewModelStoreOwner
{
  private LifeCycleDispatcher a = new LifeCycleDispatcher();
  
  public static LifeCycleAndViewModelStoreOwner a(QBaseActivity paramQBaseActivity)
  {
    Object localObject = paramQBaseActivity.getSupportFragmentManager().findFragmentByTag("fragment_tag_life_cycle_Fragment");
    if ((localObject instanceof LifeCycleFragment)) {
      return (LifeCycleFragment)localObject;
    }
    paramQBaseActivity = paramQBaseActivity.getSupportFragmentManager().beginTransaction();
    if (localObject != null) {
      paramQBaseActivity.remove((Fragment)localObject);
    }
    localObject = new LifeCycleFragment();
    paramQBaseActivity.add((Fragment)localObject, "fragment_tag_life_cycle_Fragment");
    paramQBaseActivity.commitAllowingStateLoss();
    return localObject;
  }
  
  @NonNull
  public Lifecycle getLifecycle()
  {
    return this.a.getLifecycle();
  }
  
  @NonNull
  public ViewModelStore getViewModelStore()
  {
    return this.a.getViewModelStore();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("onCreate() ");
      paramBundle.append(getClass().getSimpleName());
      paramBundle.append(" ");
      paramBundle.append(hashCode());
      QLog.d("LifeCycleFragment", 2, paramBundle.toString());
    }
    this.a.a();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDestroy() ");
      localStringBuilder.append(getClass().getSimpleName());
      localStringBuilder.append(" ");
      localStringBuilder.append(hashCode());
      QLog.d("LifeCycleFragment", 2, localStringBuilder.toString());
    }
    this.a.f();
  }
  
  public void onPause()
  {
    super.onPause();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPause() ");
      localStringBuilder.append(getClass().getSimpleName());
      localStringBuilder.append(" ");
      localStringBuilder.append(hashCode());
      QLog.d("LifeCycleFragment", 2, localStringBuilder.toString());
    }
    this.a.d();
  }
  
  public void onResume()
  {
    super.onResume();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onResume() ");
      localStringBuilder.append(getClass().getSimpleName());
      localStringBuilder.append(" ");
      localStringBuilder.append(hashCode());
      QLog.d("LifeCycleFragment", 2, localStringBuilder.toString());
    }
    this.a.c();
  }
  
  public void onStart()
  {
    super.onStart();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onStart() ");
      localStringBuilder.append(getClass().getSimpleName());
      localStringBuilder.append(" ");
      localStringBuilder.append(hashCode());
      QLog.d("LifeCycleFragment", 2, localStringBuilder.toString());
    }
    this.a.b();
  }
  
  public void onStop()
  {
    super.onStop();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onStop() ");
      localStringBuilder.append(getClass().getSimpleName());
      localStringBuilder.append(" ");
      localStringBuilder.append(hashCode());
      QLog.d("LifeCycleFragment", 2, localStringBuilder.toString());
    }
    this.a.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mvvm.LifeCycleFragment
 * JD-Core Version:    0.7.0.1
 */