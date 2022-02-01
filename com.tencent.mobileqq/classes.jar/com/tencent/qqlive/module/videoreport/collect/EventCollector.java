package com.tencent.qqlive.module.videoreport.collect;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.collect.notifier.ActivityConfigurationChangedNotifier;
import com.tencent.qqlive.module.videoreport.collect.notifier.DispatchTouchEventNotifier;
import com.tencent.qqlive.module.videoreport.collect.notifier.ListScrollNotifier;
import com.tencent.qqlive.module.videoreport.collect.notifier.RecyclerViewScrollPositionNotifier;
import com.tencent.qqlive.module.videoreport.collect.notifier.RecyclerViewSetAdapterNotifier;
import com.tencent.qqlive.module.videoreport.collect.notifier.ViewClickNotifier;
import com.tencent.qqlive.module.videoreport.collect.notifier.ViewPagerSetAdapterNotifier;
import com.tencent.qqlive.module.videoreport.collect.notifier.ViewReuseNotifier;
import com.tencent.qqlive.module.videoreport.inject.fragment.FragmentCompat;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.page.DialogListUtil;
import com.tencent.qqlive.module.videoreport.utils.ReusablePool;
import com.tencent.qqlive.module.videoreport.utils.UIUtils;
import java.lang.reflect.Field;
import java.util.List;

public class EventCollector
  implements Application.ActivityLifecycleCallbacks
{
  private static final String TAG = "EventCollector";
  private Field mLayoutManagerRecyclerViewField;
  private EventNotifyManager mNotifyManager = new EventNotifyManager();
  private Field mOwnerRecyclerViewField;
  
  public static EventCollector getInstance()
  {
    return EventCollector.InstanceHolder.access$100();
  }
  
  private RecyclerView getRecyclerView(RecyclerView.LayoutManager paramLayoutManager)
  {
    if (this.mLayoutManagerRecyclerViewField == null) {}
    try
    {
      this.mLayoutManagerRecyclerViewField = RecyclerView.LayoutManager.class.getDeclaredField("mRecyclerView");
      if (this.mLayoutManagerRecyclerViewField != null) {
        this.mLayoutManagerRecyclerViewField.setAccessible(true);
      }
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      for (;;)
      {
        try
        {
          paramLayoutManager = (RecyclerView)this.mLayoutManagerRecyclerViewField.get(paramLayoutManager);
          return paramLayoutManager;
        }
        catch (IllegalAccessException paramLayoutManager)
        {
          if (!VideoReportInner.getInstance().isDebugMode()) {
            continue;
          }
          Log.e("EventCollector", "find no mRecyclerView field");
          return null;
        }
        catch (IllegalArgumentException paramLayoutManager)
        {
          continue;
        }
        localNoSuchFieldException = localNoSuchFieldException;
        if (VideoReportInner.getInstance().isDebugMode()) {
          Log.e("EventCollector", "find no mRecyclerView field");
        }
      }
    }
  }
  
  private ViewGroup getViewHolderOwnerView(RecyclerView.ViewHolder paramViewHolder)
  {
    if (this.mOwnerRecyclerViewField == null) {}
    try
    {
      this.mOwnerRecyclerViewField = RecyclerView.ViewHolder.class.getDeclaredField("mOwnerRecyclerView");
      if (this.mOwnerRecyclerViewField != null) {
        this.mOwnerRecyclerViewField.setAccessible(true);
      }
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      for (;;)
      {
        try
        {
          paramViewHolder = (ViewGroup)this.mOwnerRecyclerViewField.get(paramViewHolder);
          return paramViewHolder;
        }
        catch (IllegalAccessException paramViewHolder)
        {
          if (!VideoReportInner.getInstance().isDebugMode()) {
            continue;
          }
          Log.e("EventCollector", "find no mOwnerRecyclerView field");
          return null;
        }
        catch (IllegalArgumentException paramViewHolder)
        {
          continue;
        }
        localNoSuchFieldException = localNoSuchFieldException;
        if (VideoReportInner.getInstance().isDebugMode()) {
          Log.e("EventCollector", "find no mOwnerRecyclerView field");
        }
      }
    }
  }
  
  private void notifyDispatchTouchEvent(Object paramObject, Window paramWindow, MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    DispatchTouchEventNotifier localDispatchTouchEventNotifier = (DispatchTouchEventNotifier)ReusablePool.obtain(10);
    localDispatchTouchEventNotifier.init(paramObject, paramWindow, paramMotionEvent, paramBoolean);
    paramObject = paramObject.hashCode() + "_" + paramMotionEvent.getAction();
    this.mNotifyManager.addEventNotifierImmediately(paramObject, localDispatchTouchEventNotifier);
  }
  
  private void onRecyclerViewItemReuse(RecyclerView.ViewHolder paramViewHolder, long paramLong)
  {
    if (!VideoReportInner.getInstance().isDataCollectEnable()) {
      return;
    }
    ViewReuseNotifier localViewReuseNotifier = (ViewReuseNotifier)ReusablePool.obtain(5);
    localViewReuseNotifier.init(getViewHolderOwnerView(paramViewHolder), paramViewHolder.itemView, paramLong);
    this.mNotifyManager.addEventNotifier(paramViewHolder.itemView, localViewReuseNotifier);
  }
  
  private void onRecyclerViewScroll(RecyclerView.LayoutManager paramLayoutManager)
  {
    if (!VideoReportInner.getInstance().isDataCollectEnable()) {}
    do
    {
      return;
      paramLayoutManager = getRecyclerView(paramLayoutManager);
    } while (paramLayoutManager == null);
    RecyclerViewScrollPositionNotifier localRecyclerViewScrollPositionNotifier = (RecyclerViewScrollPositionNotifier)ReusablePool.obtain(7);
    localRecyclerViewScrollPositionNotifier.init(paramLayoutManager);
    this.mNotifyManager.addEventNotifier(paramLayoutManager, localRecyclerViewScrollPositionNotifier);
  }
  
  public void onActivityConfigurationChanged(Activity paramActivity, Configuration paramConfiguration)
  {
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.i("EventCollector", "onActivityConfigurationChanged: activity=" + paramActivity.getClass().getName());
    }
    if (!VideoReportInner.getInstance().isDataCollectEnable()) {
      return;
    }
    ActivityConfigurationChangedNotifier localActivityConfigurationChangedNotifier = (ActivityConfigurationChangedNotifier)ReusablePool.obtain(9);
    localActivityConfigurationChangedNotifier.init(paramActivity, paramConfiguration);
    this.mNotifyManager.addEventNotifier(paramActivity, localActivityConfigurationChangedNotifier);
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.d("EventCollector", "onActivityCreated: activity=" + paramActivity.getClass().getName());
    }
    this.mNotifyManager.onActivityCreate(paramActivity);
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.i("EventCollector", "onActivityDestroyed: activity=" + paramActivity.getClass().getName());
    }
    this.mNotifyManager.onActivityDestroyed(paramActivity);
  }
  
  public void onActivityDispatchTouchEvent(Activity paramActivity, MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    notifyDispatchTouchEvent(paramActivity, paramActivity.getWindow(), paramMotionEvent, paramBoolean);
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.i("EventCollector", "onActivityPause: activity = " + paramActivity.getClass().getName());
    }
    if (!VideoReportInner.getInstance().isDataCollectEnable()) {
      return;
    }
    this.mNotifyManager.onActivityPaused(paramActivity);
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.i("EventCollector", "onActivityResumed: activity = " + paramActivity.getClass().getName());
    }
    if (!VideoReportInner.getInstance().isDataCollectEnable()) {
      return;
    }
    this.mNotifyManager.onActivityResumed(paramActivity);
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity)
  {
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.i("EventCollector", "onActivityStarted: activity = " + paramActivity.getClass().getName());
    }
    this.mNotifyManager.onActivityStarted(paramActivity);
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.i("EventCollector", "onActivityStopped: activity=" + paramActivity.getClass().getName());
    }
    this.mNotifyManager.onActivityStopped(paramActivity);
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.i("EventCollector", "onCheckedChanged, view = " + UIUtils.getViewInfo(paramCompoundButton) + ", isChecked = " + paramBoolean);
    }
    if (!VideoReportInner.getInstance().isDataCollectEnable()) {
      return;
    }
    ViewClickNotifier localViewClickNotifier = (ViewClickNotifier)ReusablePool.obtain(3);
    localViewClickNotifier.init(paramCompoundButton);
    this.mNotifyManager.addEventNotifier(paramCompoundButton, localViewClickNotifier);
  }
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.i("EventCollector", "onCheckedChanged, view = " + UIUtils.getViewInfo(paramRadioGroup) + ", checkedId = " + paramInt);
    }
    if (!VideoReportInner.getInstance().isDataCollectEnable()) {
      return;
    }
    ViewClickNotifier localViewClickNotifier = (ViewClickNotifier)ReusablePool.obtain(3);
    localViewClickNotifier.init(paramRadioGroup);
    this.mNotifyManager.addEventNotifier(paramRadioGroup, localViewClickNotifier);
  }
  
  public void onDialogClicked(DialogInterface paramDialogInterface, int paramInt)
  {
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.i("EventCollector", "onDialogClicked, dialog = " + paramDialogInterface.getClass().getSimpleName() + ", which = " + paramInt);
    }
    if (!VideoReportInner.getInstance().isDataCollectEnable()) {}
  }
  
  public void onDialogDispatchTouchEvent(Dialog paramDialog, MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    notifyDispatchTouchEvent(paramDialog, paramDialog.getWindow(), paramMotionEvent, paramBoolean);
  }
  
  public void onDialogFocusChanged(Dialog paramDialog, boolean paramBoolean)
  {
    Activity localActivity = DialogListUtil.getDialogActivity(paramDialog);
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.i("EventCollector", "onDialogFocusChanged: dialog = " + paramDialog.getClass().getName() + ", hasFocus = " + paramBoolean + ", activity = " + UIUtils.getActivityInfo(localActivity));
    }
    if (!VideoReportInner.getInstance().isDataCollectEnable()) {}
    while (localActivity == null) {
      return;
    }
    if (paramBoolean)
    {
      DialogListUtil.onDialogResume(paramDialog);
      this.mNotifyManager.onDialogShow(localActivity, paramDialog);
      return;
    }
    this.mNotifyManager.onDialogHide(localActivity, paramDialog);
  }
  
  public void onDialogStop(Dialog paramDialog)
  {
    Activity localActivity = DialogListUtil.getDialogActivity(paramDialog);
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.i("EventCollector", "onDialogStop: dialog = " + paramDialog.getClass().getName() + ", activity = " + UIUtils.getActivityInfo(localActivity));
    }
    if (!VideoReportInner.getInstance().isDataCollectEnable()) {
      return;
    }
    DialogListUtil.onDialogStop(paramDialog);
    this.mNotifyManager.onDialogHide(localActivity, paramDialog);
  }
  
  public void onFragmentDestroyView(FragmentCompat paramFragmentCompat)
  {
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.i("EventCollector", "onFragmentDestroyView: fragment = " + paramFragmentCompat.getClass().getName() + paramFragmentCompat.hashCode());
    }
    if (!VideoReportInner.getInstance().isDataCollectEnable()) {
      return;
    }
    this.mNotifyManager.onFragmentDestroyView(paramFragmentCompat);
  }
  
  public void onFragmentPaused(FragmentCompat paramFragmentCompat)
  {
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.i("EventCollector", "onFragmentPaused: fragment = " + paramFragmentCompat.getClass().getName() + paramFragmentCompat.hashCode());
    }
    if (!VideoReportInner.getInstance().isDataCollectEnable()) {
      return;
    }
    this.mNotifyManager.onFragmentPaused(paramFragmentCompat);
  }
  
  public void onFragmentResumed(FragmentCompat paramFragmentCompat)
  {
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.i("EventCollector", "onFragmentResumed: fragment = " + paramFragmentCompat.getClass().getName() + paramFragmentCompat.hashCode());
    }
    if (!VideoReportInner.getInstance().isDataCollectEnable()) {
      return;
    }
    this.mNotifyManager.onFragmentResumed(paramFragmentCompat);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.i("EventCollector", "onItemClick, parent = " + paramAdapterView.getClass().getSimpleName() + ", view = " + UIUtils.getViewInfo(paramView) + ", position = " + paramInt);
    }
    if (!VideoReportInner.getInstance().isDataCollectEnable()) {
      return;
    }
    paramAdapterView = (ViewClickNotifier)ReusablePool.obtain(3);
    paramAdapterView.init(paramView);
    this.mNotifyManager.addEventNotifier(paramView, paramAdapterView);
  }
  
  public void onListGetView(int paramInt, View paramView, ViewGroup paramViewGroup, long paramLong)
  {
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.i("EventCollector", "onListGetView, parent = " + UIUtils.getViewInfo(paramViewGroup) + ", convertView = " + UIUtils.getViewInfo(paramView) + ", position = " + paramInt);
    }
    if (!VideoReportInner.getInstance().isDataCollectEnable()) {}
    while (paramView == null) {
      return;
    }
    ViewReuseNotifier localViewReuseNotifier = (ViewReuseNotifier)ReusablePool.obtain(5);
    localViewReuseNotifier.init(paramViewGroup, paramView, paramLong);
    this.mNotifyManager.addEventNotifier(paramView, localViewReuseNotifier);
  }
  
  public void onListScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.i("EventCollector", "onListScrollStateChanged, view = " + UIUtils.getViewInfo(paramAbsListView) + ", scrollState = " + paramInt);
    }
    if (!VideoReportInner.getInstance().isDataCollectEnable()) {
      return;
    }
    ListScrollNotifier localListScrollNotifier = (ListScrollNotifier)ReusablePool.obtain(1);
    localListScrollNotifier.init(paramAbsListView, paramInt);
    this.mNotifyManager.addEventNotifier(paramAbsListView, localListScrollNotifier);
  }
  
  public void onRecyclerBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt, long paramLong)
  {
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.i("EventCollector", "onRecyclerBindViewHolder, holder = " + paramViewHolder.getClass().getSimpleName() + ", position = " + paramInt);
    }
    onRecyclerViewItemReuse(paramViewHolder, paramLong);
  }
  
  public void onRecyclerBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt, List<Object> paramList, long paramLong)
  {
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.i("EventCollector", "onRecyclerBindViewHolder2, holder = " + paramViewHolder.getClass().getSimpleName() + ", position = " + paramInt);
    }
    onRecyclerViewItemReuse(paramViewHolder, paramLong);
  }
  
  public void onRecyclerViewScrollToPosition(RecyclerView.LayoutManager paramLayoutManager)
  {
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.i("EventCollector", "onRecyclerViewScrollToPosition");
    }
    onRecyclerViewScroll(paramLayoutManager);
  }
  
  public void onRecyclerViewScrollToPositionWithOffset(RecyclerView.LayoutManager paramLayoutManager)
  {
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.i("EventCollector", "onRecyclerViewScrollToPositionWithOffset");
    }
    onRecyclerViewScroll(paramLayoutManager);
  }
  
  public void onSetRecyclerViewAdapter(RecyclerView paramRecyclerView)
  {
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.i("EventCollector", "onSetRecyclerViewAdapter, recyclerView = " + UIUtils.getViewInfo(paramRecyclerView));
    }
    if (!VideoReportInner.getInstance().isDataCollectEnable()) {
      return;
    }
    RecyclerViewSetAdapterNotifier localRecyclerViewSetAdapterNotifier = (RecyclerViewSetAdapterNotifier)ReusablePool.obtain(2);
    localRecyclerViewSetAdapterNotifier.init(paramRecyclerView);
    this.mNotifyManager.addEventNotifier(paramRecyclerView, localRecyclerViewSetAdapterNotifier);
  }
  
  public void onSetViewPagerAdapter(ViewPager paramViewPager)
  {
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.i("EventCollector", "onSetViewPagerAdapter, viewPager = " + UIUtils.getViewInfo(paramViewPager));
    }
    if (!VideoReportInner.getInstance().isDataCollectEnable()) {
      return;
    }
    ViewPagerSetAdapterNotifier localViewPagerSetAdapterNotifier = (ViewPagerSetAdapterNotifier)ReusablePool.obtain(4);
    localViewPagerSetAdapterNotifier.init(paramViewPager);
    this.mNotifyManager.addEventNotifier(paramViewPager, localViewPagerSetAdapterNotifier);
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.i("EventCollector", "onStopTrackingTouch, view = " + UIUtils.getViewInfo(paramSeekBar));
    }
    if (!VideoReportInner.getInstance().isDataCollectEnable()) {
      return;
    }
    ViewClickNotifier localViewClickNotifier = (ViewClickNotifier)ReusablePool.obtain(3);
    localViewClickNotifier.init(paramSeekBar);
    this.mNotifyManager.addEventNotifier(paramSeekBar, localViewClickNotifier);
  }
  
  public void onViewClicked(View paramView)
  {
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.i("EventCollector", "onViewClicked, view = " + UIUtils.getViewInfo(paramView));
    }
    if (!VideoReportInner.getInstance().isDataCollectEnable()) {
      return;
    }
    ViewClickNotifier localViewClickNotifier = (ViewClickNotifier)ReusablePool.obtain(3);
    localViewClickNotifier.init(paramView);
    this.mNotifyManager.addEventNotifier(paramView, localViewClickNotifier);
  }
  
  public void registerEventListener(IEventListener paramIEventListener)
  {
    this.mNotifyManager.registerEventListener(paramIEventListener);
  }
  
  public void unregisterEventListener(IEventListener paramIEventListener)
  {
    this.mNotifyManager.unregisterEventListener(paramIEventListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.collect.EventCollector
 * JD-Core Version:    0.7.0.1
 */