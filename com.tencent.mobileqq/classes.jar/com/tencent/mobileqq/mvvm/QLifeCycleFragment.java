package com.tencent.mobileqq.mvvm;

import android.os.Bundle;
import android.support.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelStore;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXFragment;

public class QLifeCycleFragment
  extends ReportAndroidXFragment
  implements LifeCycleAndViewModelStoreOwner
{
  private LifeCycleDispatcher a = new LifeCycleDispatcher();
  
  public static LifeCycleAndViewModelStoreOwner a(FragmentActivity paramFragmentActivity)
  {
    Object localObject = paramFragmentActivity.getSupportFragmentManager().findFragmentByTag("fragment_tag_life_cycle_QFragment");
    if ((localObject instanceof QLifeCycleFragment)) {
      return (QLifeCycleFragment)localObject;
    }
    paramFragmentActivity = paramFragmentActivity.getSupportFragmentManager().beginTransaction();
    if (localObject != null) {
      paramFragmentActivity.remove((Fragment)localObject);
    }
    localObject = new QLifeCycleFragment();
    paramFragmentActivity.add((Fragment)localObject, "fragment_tag_life_cycle_QFragment");
    paramFragmentActivity.commitAllowingStateLoss();
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
      QLog.d("QLifeCycleFragment", 2, paramBundle.toString());
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
      QLog.d("QLifeCycleFragment", 2, localStringBuilder.toString());
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
      QLog.d("QLifeCycleFragment", 2, localStringBuilder.toString());
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
      QLog.d("QLifeCycleFragment", 2, localStringBuilder.toString());
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
      QLog.d("QLifeCycleFragment", 2, localStringBuilder.toString());
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
      QLog.d("QLifeCycleFragment", 2, localStringBuilder.toString());
    }
    this.a.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.mvvm.QLifeCycleFragment
 * JD-Core Version:    0.7.0.1
 */