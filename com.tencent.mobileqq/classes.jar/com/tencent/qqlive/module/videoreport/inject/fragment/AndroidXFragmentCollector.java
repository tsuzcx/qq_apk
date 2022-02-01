package com.tencent.qqlive.module.videoreport.inject.fragment;

import android.view.View;
import androidx.fragment.app.DialogFragment;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.page.ViewContainerBinder;
import com.tencent.qqlive.module.videoreport.utils.UIUtils;
import d;

public class AndroidXFragmentCollector
{
  private static final String TAG = "AndroidXFragmentCollect";
  
  public static FragmentCompat fragmentToFragmentCompat(d paramd)
  {
    FragmentCompat localFragmentCompat = new FragmentCompat();
    localFragmentCompat.setActivity(paramd.getActivity());
    localFragmentCompat.setView(paramd.getView());
    return localFragmentCompat;
  }
  
  public static void onAndroidXFragmentViewCreated(d paramd, View paramView)
  {
    if (!VideoReportInner.getInstance().isDataCollectEnable()) {
      return;
    }
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.i("AndroidXFragmentCollect", "onFragmentViewCreated: fragment = " + paramd.getClass().getName() + ", view = " + UIUtils.getViewInfo(paramView));
    }
    ViewContainerBinder.getInstance().bind(paramView, paramd);
  }
  
  public static void onDestroyView(d paramd)
  {
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.i("AndroidXFragmentCollect", "onDestroyView: fragment = " + paramd.getClass().getName());
    }
    if ((paramd instanceof DialogFragment)) {
      return;
    }
    EventCollector.getInstance().onFragmentDestroyView(fragmentToFragmentCompat(paramd));
  }
  
  public static void onHiddenChanged(d paramd, boolean paramBoolean)
  {
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.i("AndroidXFragmentCollect", "onHiddenChanged: fragment = " + paramd.getClass().getName() + ", hidden = " + paramBoolean);
    }
    if ((paramd instanceof DialogFragment)) {
      return;
    }
    if (paramBoolean)
    {
      EventCollector.getInstance().onFragmentPaused(fragmentToFragmentCompat(paramd));
      return;
    }
    EventCollector.getInstance().onFragmentResumed(fragmentToFragmentCompat(paramd));
  }
  
  public static void onPause(d paramd)
  {
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.i("AndroidXFragmentCollect", "onPause: fragment = " + paramd.getClass().getName());
    }
    if ((paramd instanceof DialogFragment)) {
      return;
    }
    EventCollector.getInstance().onFragmentPaused(fragmentToFragmentCompat(paramd));
  }
  
  public static void onResume(d paramd)
  {
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.i("AndroidXFragmentCollect", "onResume: fragment = " + paramd.getClass().getName());
    }
    if ((paramd instanceof DialogFragment)) {
      return;
    }
    EventCollector.getInstance().onFragmentResumed(fragmentToFragmentCompat(paramd));
  }
  
  public static void setUserVisibleHint(d paramd, boolean paramBoolean)
  {
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.i("AndroidXFragmentCollect", "setUserVisibleHint: fragment = " + paramd.getClass().getName() + ", isVisible = " + paramBoolean);
    }
    if ((paramd instanceof DialogFragment)) {
      return;
    }
    if (paramBoolean)
    {
      EventCollector.getInstance().onFragmentResumed(fragmentToFragmentCompat(paramd));
      return;
    }
    EventCollector.getInstance().onFragmentPaused(fragmentToFragmentCompat(paramd));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector
 * JD-Core Version:    0.7.0.1
 */