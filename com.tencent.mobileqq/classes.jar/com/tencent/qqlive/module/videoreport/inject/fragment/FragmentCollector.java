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
    if (VideoReportInner.getInstance().isDebugMode())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDestroyView: fragment = ");
      localStringBuilder.append(paramFragment.getClass().getName());
      Log.i("FragmentCollector", localStringBuilder.toString());
    }
    EventCollector.getInstance().onFragmentDestroyView(fragmentToFragmentCompat(paramFragment));
  }
  
  public static void onFragmentViewCreated(Fragment paramFragment, View paramView)
  {
    if (!VideoReportInner.getInstance().isDataCollectEnable()) {
      return;
    }
    if (VideoReportInner.getInstance().isDebugMode())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onFragmentViewCreated: fragment = ");
      localStringBuilder.append(paramFragment.getClass().getName());
      localStringBuilder.append(", view = ");
      localStringBuilder.append(UIUtils.getViewInfo(paramView));
      Log.i("FragmentCollector", localStringBuilder.toString());
    }
    ViewContainerBinder.getInstance().bind(paramView, paramFragment);
  }
  
  public static void onHiddenChanged(Fragment paramFragment, boolean paramBoolean)
  {
    if (VideoReportInner.getInstance().isDebugMode())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onHiddenChanged: fragment = ");
      localStringBuilder.append(paramFragment.getClass().getName());
      localStringBuilder.append(", hidden = ");
      localStringBuilder.append(paramBoolean);
      Log.i("FragmentCollector", localStringBuilder.toString());
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
    if (VideoReportInner.getInstance().isDebugMode())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPause: fragment = ");
      localStringBuilder.append(paramFragment.getClass().getName());
      Log.i("FragmentCollector", localStringBuilder.toString());
    }
    EventCollector.getInstance().onFragmentPaused(fragmentToFragmentCompat(paramFragment));
  }
  
  public static void onResume(Fragment paramFragment)
  {
    if (VideoReportInner.getInstance().isDebugMode())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onResume: fragment = ");
      localStringBuilder.append(paramFragment.getClass().getName());
      Log.i("FragmentCollector", localStringBuilder.toString());
    }
    EventCollector.getInstance().onFragmentResumed(fragmentToFragmentCompat(paramFragment));
  }
  
  public static void setUserVisibleHint(Fragment paramFragment, boolean paramBoolean)
  {
    if (VideoReportInner.getInstance().isDebugMode())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setUserVisibleHint: fragment = ");
      localStringBuilder.append(paramFragment.getClass().getName());
      localStringBuilder.append(", isVisible = ");
      localStringBuilder.append(paramBoolean);
      Log.i("FragmentCollector", localStringBuilder.toString());
    }
    if (paramBoolean)
    {
      EventCollector.getInstance().onFragmentResumed(fragmentToFragmentCompat(paramFragment));
      return;
    }
    EventCollector.getInstance().onFragmentPaused(fragmentToFragmentCompat(paramFragment));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.inject.fragment.FragmentCollector
 * JD-Core Version:    0.7.0.1
 */