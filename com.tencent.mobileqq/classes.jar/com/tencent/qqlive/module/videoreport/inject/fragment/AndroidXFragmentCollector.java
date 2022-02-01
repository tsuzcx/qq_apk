package com.tencent.qqlive.module.videoreport.inject.fragment;

import android.view.View;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.page.ViewContainerBinder;
import com.tencent.qqlive.module.videoreport.utils.UIUtils;

public class AndroidXFragmentCollector
{
  private static final String TAG = "AndroidXFragmentCollect";
  
  public static FragmentCompat fragmentToFragmentCompat(Fragment paramFragment)
  {
    FragmentCompat localFragmentCompat = new FragmentCompat();
    localFragmentCompat.setActivity(paramFragment.getActivity());
    localFragmentCompat.setView(paramFragment.getView());
    return localFragmentCompat;
  }
  
  public static void onAndroidXFragmentViewCreated(Fragment paramFragment, View paramView)
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
      Log.i("AndroidXFragmentCollect", localStringBuilder.toString());
    }
    ViewContainerBinder.getInstance().bind(paramView, paramFragment);
  }
  
  public static void onDestroyView(Fragment paramFragment)
  {
    if (VideoReportInner.getInstance().isDebugMode())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDestroyView: fragment = ");
      localStringBuilder.append(paramFragment.getClass().getName());
      Log.i("AndroidXFragmentCollect", localStringBuilder.toString());
    }
    if ((paramFragment instanceof DialogFragment)) {
      return;
    }
    EventCollector.getInstance().onFragmentDestroyView(fragmentToFragmentCompat(paramFragment));
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
      Log.i("AndroidXFragmentCollect", localStringBuilder.toString());
    }
    if ((paramFragment instanceof DialogFragment)) {
      return;
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
      Log.i("AndroidXFragmentCollect", localStringBuilder.toString());
    }
    if ((paramFragment instanceof DialogFragment)) {
      return;
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
      Log.i("AndroidXFragmentCollect", localStringBuilder.toString());
    }
    if ((paramFragment instanceof DialogFragment)) {
      return;
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
      Log.i("AndroidXFragmentCollect", localStringBuilder.toString());
    }
    if ((paramFragment instanceof DialogFragment)) {
      return;
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
 * Qualified Name:     com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector
 * JD-Core Version:    0.7.0.1
 */