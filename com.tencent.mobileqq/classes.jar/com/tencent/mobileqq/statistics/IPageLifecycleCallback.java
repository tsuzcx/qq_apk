package com.tencent.mobileqq.statistics;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import com.tencent.mobileqq.app.QBaseFragment.IFragmentLifecycleCallback;

public abstract interface IPageLifecycleCallback
  extends Application.ActivityLifecycleCallbacks, QBaseFragment.IFragmentLifecycleCallback
{
  public abstract void a(String paramString, Activity paramActivity, boolean paramBoolean, Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.IPageLifecycleCallback
 * JD-Core Version:    0.7.0.1
 */