package com.tencent.mobileqq.statistics;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.support.v4.app.Fragment.IFragmentLifecycleCallback;
import android.support.v4.app.QFragment.IFragmentLifecycleCallback;

public abstract interface IPageLifecycleCallback
  extends Application.ActivityLifecycleCallbacks, Fragment.IFragmentLifecycleCallback, QFragment.IFragmentLifecycleCallback
{
  public abstract void a(String paramString, Activity paramActivity, boolean paramBoolean, Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.IPageLifecycleCallback
 * JD-Core Version:    0.7.0.1
 */