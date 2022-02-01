package com.tencent.qqlive.module.videoreport.inject.fragment;

import android.app.Fragment;
import android.view.View;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.page.ViewContainerBinder;
import com.tencent.qqlive.module.videoreport.utils.UIUtils;

public class FragmentCollector
{
  private static final String TAG = "FragmentCollector";
  
  public static FragmentCompat fragmentToFragmentCompat(Fragment paramFragment)
  {
    FragmentCompat localFragmentCompat = new FragmentCompat();
    localFragmentCompat.setActivity(paramFragment.getActivity());
    localFragmentCompat.setView(paramFragment.getView());
    return localFragmentCompat;
  }
  
  public static void onDestroyView(Fragment paramFragment)
  {
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.i("FragmentCollector", "onDestroyView: fragment = " + paramFragment.getClass().getName());
    }
    EventCollector.getInstance().onFragmentDestroyView(fragmentToFragmentCompat(paramFragment));
  }
  
  public static void onFragmentViewCreated(Fragment paramFragment, View paramView)
  {
    if (!VideoReportInner.getInstance().isDataCollectEnable()) {
      return;
    }
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.i("FragmentCollector", "onFragmentViewCreated: fragment = " + paramFragment.getClass().getName() + ", view = " + UIUtils.getViewInfo(paramView));
    }
    ViewContainerBinder.getInstance().bind(paramView, paramFragment);
  }
  
  public static void onHiddenChanged(Fragment paramFragment, boolean paramBoolean)
  {
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.i("FragmentCollector", "onHiddenChanged: fragment = " + paramFragment.getClass().getName() + ", hidden = " + paramBoolean);
    }
    if (paramBoolean)
    {
      EventCollector.getInstance().onFragmentPaused(fragmentToFragmentCompat(paramFragment));
      return;
    }
    EventCollector.getInstance().onFragmentResumed(fragmentToFragmentCompat(paramFragment));
  }
  
  public static void onPause(Fragment paramFragment)
  {
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.i("FragmentCollector", "onPause: fragment = " + paramFragment.getClass().getName());
    }
    EventCollector.getInstance().onFragmentPaused(fragmentToFragmentCompat(paramFragment));
  }
  
  public static void onResume(Fragment paramFragment)
  {
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.i("FragmentCollector", "onResume: fragment = " + paramFragment.getClass().getName());
    }
    EventCollector.getInstance().onFragmentResumed(fragmentToFragmentCompat(paramFragment));
  }
  
  public static void setUserVisibleHint(Fragment paramFragment, boolean paramBoolean)
  {
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.i("FragmentCollector", "setUserVisibleHint: fragment = " + paramFragment.getClass().getName() + ", isVisible = " + paramBoolean);
    }
    if (paramBoolean)
    {
      EventCollector.getInstance().onFragmentResumed(fragmentToFragmentCompat(paramFragment));
      return;
    }
    EventCollector.getInstance().onFragmentPaused(fragmentToFragmentCompat(paramFragment));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.inject.fragment.FragmentCollector
 * JD-Core Version:    0.7.0.1
 */