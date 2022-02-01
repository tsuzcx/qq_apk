package com.tencent.mobileqq.mvvm.api.impl;

import android.app.Activity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.mvvm.LifeCycleAndViewModelStoreOwner;
import com.tencent.mobileqq.mvvm.LifeCycleFragment;
import com.tencent.mobileqq.mvvm.api.ILifeCycleFragmentInjectApi;

public class LifeCycleFragmentInjectApiImpl
  implements ILifeCycleFragmentInjectApi
{
  public LifeCycleAndViewModelStoreOwner checkAndAddLifeCycleFragment(Activity paramActivity)
  {
    if ((paramActivity instanceof QBaseActivity)) {
      return LifeCycleFragment.a((QBaseActivity)paramActivity);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.mvvm.api.impl.LifeCycleFragmentInjectApiImpl
 * JD-Core Version:    0.7.0.1
 */