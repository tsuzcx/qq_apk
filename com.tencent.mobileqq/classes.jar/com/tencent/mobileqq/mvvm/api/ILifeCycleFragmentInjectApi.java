package com.tencent.mobileqq.mvvm.api;

import android.app.Activity;
import com.tencent.mobileqq.mvvm.LifeCycleAndViewModelStoreOwner;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface ILifeCycleFragmentInjectApi
  extends QRouteApi
{
  public abstract LifeCycleAndViewModelStoreOwner checkAndAddLifeCycleFragment(Activity paramActivity);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.mvvm.api.ILifeCycleFragmentInjectApi
 * JD-Core Version:    0.7.0.1
 */