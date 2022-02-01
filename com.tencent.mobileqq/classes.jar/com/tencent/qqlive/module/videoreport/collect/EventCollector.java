package com.tencent.qqlive.module.videoreport.collect;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.collect.notifier.ActivityConfigurationChangedNotifier;
import com.tencent.qqlive.module.videoreport.collect.notifier.DispatchTouchEventNotifier;
import com.tencent.qqlive.module.videoreport.collect.notifier.IEventNotifier;
import com.tencent.qqlive.module.videoreport.collect.notifier.KeyBoardEditorActionNotifier;
import com.tencent.qqlive.module.videoreport.collect.notifier.ListScrollNotifier;
import com.tencent.qqlive.module.videoreport.collect.notifier.RecyclerViewScrollPositionNotifier;
import com.tencent.qqlive.module.videoreport.collect.notifier.ViewClickNotifier;
import com.tencent.qqlive.module.videoreport.collect.notifier.ViewReuseNotifier;
import com.tencent.qqlive.module.videoreport.inject.fragment.FragmentCompat;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.lazy.LazyInitObserver;
import com.tencent.qqlive.module.videoreport.page.DialogListUtil;
import com.tencent.qqlive.module.videoreport.task.ThreadUtils;
import com.tencent.qqlive.module.videoreport.utils.BaseUtils;
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
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      label21:
      Field localField;
      break label21;
    }
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.e("EventCollector", "find no mRecyclerView field");
    }
    localField = this.mLayoutManagerRecyclerViewField;
    if (localField != null) {
      localField.setAccessible(true);
    }
    try
    {
      paramLayoutManager = (RecyclerView)this.mLayoutManagerRecyclerViewField.get(paramLayoutManager);
      return paramLayoutManager;
    }
    catch (IllegalAccessException|IllegalArgumentException paramLayoutManager)
    {
      label65:
      break label65;
    }
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.e("EventCollector", "find no mRecyclerView field");
    }
    return null;
  }
  
  private ViewGroup getViewHolderOwnerView(RecyclerView.ViewHolder paramViewHolder)
  {
    if (this.mOwnerRecyclerViewField == null) {}
    try
    {
      this.mOwnerRecyclerViewField = RecyclerView.ViewHolder.class.getDeclaredField("mOwnerRecyclerView");
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      label21:
      Field localField;
      break label21;
    }
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.e("EventCollector", "find no mOwnerRecyclerView field");
    }
    localField = this.mOwnerRecyclerViewField;
    if (localField != null) {
      localField.setAccessible(true);
    }
    try
    {
      paramViewHolder = (ViewGroup)this.mOwnerRecyclerViewField.get(paramViewHolder);
      return paramViewHolder;
    }
    catch (IllegalAccessException|IllegalArgumentException paramViewHolder)
    {
      label65:
      break label65;
    }
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.e("EventCollector", "find no mOwnerRecyclerView field");
    }
    return null;
  }
  
  private void notifyDispatchTouchEvent(Object paramObject, Window paramWindow, MotionEvent paramMotionEvent, boolean paramBoolean1, boolean paramBoolean2)
  {
    DispatchTouchEventNotifier localDispatchTouchEventNotifier = (DispatchTouchEventNotifier)ReusablePool.obtain(10);
    localDispatchTouchEventNotifier.init(paramObject, paramWindow, paramMotionEvent, paramBoolean1, paramBoolean2);
    paramWindow = new StringBuilder();
    paramWindow.append(paramObject.hashCode());
    paramWindow.append("_");
    paramWindow.append(paramMotionEvent.getAction());
    paramWindow.append("_");
    paramWindow.append(paramBoolean2);
    paramObject = paramWindow.toString();
    this.mNotifyManager.addEventNotifierImmediately(paramObject, localDispatchTouchEventNotifier);
  }
  
  private void onRecyclerViewItemReuse(RecyclerView.ViewHolder paramViewHolder, long paramLong)
  {
    if (!VideoReportInner.getInstance().isDataCollectEnable()) {
      return;
    }
    if (!LazyInitObserver.getInstance().mayProceedOnMain(null)) {
      return;
    }
    ViewReuseNotifier localViewReuseNotifier = (ViewReuseNotifier)ReusablePool.obtain(5);
    localViewReuseNotifier.init(getViewHolderOwnerView(paramViewHolder), paramViewHolder.itemView, paramLong);
    this.mNotifyManager.addEventNotifier(paramViewHolder.itemView, localViewReuseNotifier);
  }
  
  private void onRecyclerViewScroll(RecyclerView.LayoutManager paramLayoutManager)
  {
    if (!VideoReportInner.getInstance().isDataCollectEnable()) {
      return;
    }
    paramLayoutManager = getRecyclerView(paramLayoutManager);
    if (paramLayoutManager != null)
    {
      RecyclerViewScrollPositionNotifier localRecyclerViewScrollPositionNotifier = (RecyclerViewScrollPositionNotifier)ReusablePool.obtain(7);
      localRecyclerViewScrollPositionNotifier.init(paramLayoutManager);
      this.mNotifyManager.addEventNotifier(paramLayoutManager, localRecyclerViewScrollPositionNotifier);
    }
  }
  
  public void onActivityConfigurationChanged(Activity paramActivity, Configuration paramConfiguration)
  {
    if (VideoReportInner.getInstance().isDebugMode())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onActivityConfigurationChanged: activity=");
      ((StringBuilder)localObject).append(paramActivity.getClass().getName());
      Log.i("EventCollector", ((StringBuilder)localObject).toString());
    }
    if (!VideoReportInner.getInstance().isDataCollectEnable()) {
      return;
    }
    Object localObject = (ActivityConfigurationChangedNotifier)ReusablePool.obtain(9);
    ((ActivityConfigurationChangedNotifier)localObject).init(paramActivity, paramConfiguration);
    this.mNotifyManager.addEventNotifier(paramActivity, (IEventNotifier)localObject);
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    if (VideoReportInner.getInstance().isDebugMode())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("onActivityCreated: activity=");
      paramBundle.append(paramActivity.getClass().getName());
      Log.d("EventCollector", paramBundle.toString());
    }
    Log.d("LazyInitSequence", "act created");
    this.mNotifyManager.onActivityCreate(paramActivity);
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    if (VideoReportInner.getInstance().isDebugMode())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onActivityDestroyed: activity=");
      localStringBuilder.append(paramActivity.getClass().getName());
      Log.i("EventCollector", localStringBuilder.toString());
    }
    this.mNotifyManager.onActivityDestroyed(paramActivity);
  }
  
  public void onActivityDispatchTouchEvent(Activity paramActivity, MotionEvent paramMotionEvent, boolean paramBoolean1, boolean paramBoolean2)
  {
    notifyDispatchTouchEvent(paramActivity, paramActivity.getWindow(), paramMotionEvent, paramBoolean1, paramBoolean2);
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    if (VideoReportInner.getInstance().isDebugMode())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onActivityPause: activity = ");
      localStringBuilder.append(paramActivity.getClass().getName());
      Log.i("EventCollector", localStringBuilder.toString());
    }
    if (!VideoReportInner.getInstance().isDataCollectEnable()) {
      return;
    }
    this.mNotifyManager.onActivityPaused(paramActivity);
  }
  
  public void onActivityPostCreated(@NonNull Activity paramActivity, @Nullable Bundle paramBundle)
  {
    if (VideoReportInner.getInstance().isDebugMode())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("onActivityPostCreated: activity=");
      paramBundle.append(paramActivity.getClass().getName());
      Log.d("EventCollector", paramBundle.toString());
    }
  }
  
  public void onActivityPostDestroyed(@NonNull Activity paramActivity)
  {
    if (VideoReportInner.getInstance().isDebugMode())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onActivityPostDestroyed: activity=");
      localStringBuilder.append(paramActivity.getClass().getName());
      Log.d("EventCollector", localStringBuilder.toString());
    }
  }
  
  public void onActivityPostPaused(@NonNull Activity paramActivity)
  {
    if (VideoReportInner.getInstance().isDebugMode())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onActivityPostPaused: activity=");
      localStringBuilder.append(paramActivity.getClass().getName());
      Log.d("EventCollector", localStringBuilder.toString());
    }
  }
  
  public void onActivityPostResumed(@NonNull Activity paramActivity)
  {
    if (VideoReportInner.getInstance().isDebugMode())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onActivityPostResumed: activity=");
      localStringBuilder.append(paramActivity.getClass().getName());
      Log.d("EventCollector", localStringBuilder.toString());
    }
  }
  
  public void onActivityPostSaveInstanceState(@NonNull Activity paramActivity, @NonNull Bundle paramBundle)
  {
    if (VideoReportInner.getInstance().isDebugMode())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("onActivityPostSaveInstanceState: activity=");
      paramBundle.append(paramActivity.getClass().getName());
      Log.d("EventCollector", paramBundle.toString());
    }
  }
  
  public void onActivityPostStarted(@NonNull Activity paramActivity)
  {
    if (VideoReportInner.getInstance().isDebugMode())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onActivityPostStarted: activity=");
      localStringBuilder.append(paramActivity.getClass().getName());
      Log.d("EventCollector", localStringBuilder.toString());
    }
  }
  
  public void onActivityPostStopped(@NonNull Activity paramActivity)
  {
    if (VideoReportInner.getInstance().isDebugMode())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onActivityPostStopped: activity=");
      localStringBuilder.append(paramActivity.getClass().getName());
      Log.d("EventCollector", localStringBuilder.toString());
    }
  }
  
  public void onActivityPreCreated(@NonNull Activity paramActivity, @Nullable Bundle paramBundle)
  {
    if (VideoReportInner.getInstance().isDebugMode())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("onActivityPreCreated: activity=");
      paramBundle.append(paramActivity.getClass().getName());
      Log.d("EventCollector", paramBundle.toString());
    }
  }
  
  public void onActivityPreDestroyed(@NonNull Activity paramActivity)
  {
    if (VideoReportInner.getInstance().isDebugMode())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onActivityPreDestroyed: activity=");
      localStringBuilder.append(paramActivity.getClass().getName());
      Log.d("EventCollector", localStringBuilder.toString());
    }
  }
  
  public void onActivityPrePaused(@NonNull Activity paramActivity)
  {
    if (VideoReportInner.getInstance().isDebugMode())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onActivityPrePaused: activity=");
      localStringBuilder.append(paramActivity.getClass().getName());
      Log.d("EventCollector", localStringBuilder.toString());
    }
  }
  
  public void onActivityPreResumed(@NonNull Activity paramActivity)
  {
    if (VideoReportInner.getInstance().isDebugMode())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onActivityPreResumed: activity=");
      localStringBuilder.append(paramActivity.getClass().getName());
      Log.d("EventCollector", localStringBuilder.toString());
    }
  }
  
  public void onActivityPreSaveInstanceState(@NonNull Activity paramActivity, @NonNull Bundle paramBundle)
  {
    if (VideoReportInner.getInstance().isDebugMode())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("onActivityPreSaveInstanceState: activity=");
      paramBundle.append(paramActivity.getClass().getName());
      Log.d("EventCollector", paramBundle.toString());
    }
  }
  
  public void onActivityPreStarted(@NonNull Activity paramActivity)
  {
    if (VideoReportInner.getInstance().isDebugMode())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onActivityPreStarted: activity=");
      localStringBuilder.append(paramActivity.getClass().getName());
      Log.d("EventCollector", localStringBuilder.toString());
    }
  }
  
  public void onActivityPreStopped(@NonNull Activity paramActivity)
  {
    if (VideoReportInner.getInstance().isDebugMode())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onActivityPreStopped: activity=");
      localStringBuilder.append(paramActivity.getClass().getName());
      Log.d("EventCollector", localStringBuilder.toString());
    }
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    if (VideoReportInner.getInstance().isDebugMode())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onActivityResumed: activity = ");
      localStringBuilder.append(paramActivity.getClass().getName());
      Log.i("EventCollector", localStringBuilder.toString());
    }
    Log.d("LazyInitSequence", "act resumed");
    if (!VideoReportInner.getInstance().isDataCollectEnable()) {
      return;
    }
    this.mNotifyManager.onActivityResumed(paramActivity);
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle)
  {
    if (VideoReportInner.getInstance().isDebugMode())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("onActivitySaveInstanceState: activity=");
      paramBundle.append(paramActivity.getClass().getName());
      Log.d("EventCollector", paramBundle.toString());
    }
  }
  
  public void onActivityStarted(Activity paramActivity)
  {
    if (VideoReportInner.getInstance().isDebugMode())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onActivityStarted: activity = ");
      localStringBuilder.append(paramActivity.getClass().getName());
      Log.i("EventCollector", localStringBuilder.toString());
    }
    Log.d("LazyInitSequence", "act started");
    this.mNotifyManager.onActivityStarted(paramActivity);
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    if (VideoReportInner.getInstance().isDebugMode())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onActivityStopped: activity=");
      localStringBuilder.append(paramActivity.getClass().getName());
      Log.i("EventCollector", localStringBuilder.toString());
    }
    this.mNotifyManager.onActivityStopped(paramActivity);
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (VideoReportInner.getInstance().isDebugMode())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onCheckedChanged, view = ");
      ((StringBuilder)localObject).append(UIUtils.getViewInfo(paramCompoundButton));
      ((StringBuilder)localObject).append(", isChecked = ");
      ((StringBuilder)localObject).append(paramBoolean);
      Log.i("EventCollector", ((StringBuilder)localObject).toString());
    }
    if (!VideoReportInner.getInstance().isDataCollectEnable()) {
      return;
    }
    Object localObject = (ViewClickNotifier)ReusablePool.obtain(3);
    ((ViewClickNotifier)localObject).init(paramCompoundButton);
    this.mNotifyManager.addEventNotifier(paramCompoundButton, (IEventNotifier)localObject);
  }
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    if (VideoReportInner.getInstance().isDebugMode())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onCheckedChanged, view = ");
      ((StringBuilder)localObject).append(UIUtils.getViewInfo(paramRadioGroup));
      ((StringBuilder)localObject).append(", checkedId = ");
      ((StringBuilder)localObject).append(paramInt);
      Log.i("EventCollector", ((StringBuilder)localObject).toString());
    }
    if (!VideoReportInner.getInstance().isDataCollectEnable()) {
      return;
    }
    Object localObject = (ViewClickNotifier)ReusablePool.obtain(3);
    ((ViewClickNotifier)localObject).init(paramRadioGroup);
    this.mNotifyManager.addEventNotifier(paramRadioGroup, (IEventNotifier)localObject);
  }
  
  public void onChildViewAdded(View paramView1, View paramView2)
  {
    if (VideoReportInner.getInstance().isDebugMode())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onChildViewAdded, view = ");
      localStringBuilder.append(UIUtils.getViewInfo(paramView2));
      Log.i("EventCollector", localStringBuilder.toString());
    }
    if (!VideoReportInner.getInstance().isDataCollectEnable()) {
      return;
    }
    if ((paramView1 instanceof AbsListView)) {
      this.mNotifyManager.onChildViewAdded(paramView1, paramView2);
    }
  }
  
  public void onChildViewRemoved(View paramView1, View paramView2)
  {
    if (VideoReportInner.getInstance().isDebugMode())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onChildViewAdded, view = ");
      localStringBuilder.append(UIUtils.getViewInfo(paramView2));
      Log.i("EventCollector", localStringBuilder.toString());
    }
    if (!VideoReportInner.getInstance().isDataCollectEnable()) {
      return;
    }
    if ((paramView1 instanceof AbsListView)) {
      this.mNotifyManager.onChildViewRemoved(paramView1, paramView2);
    }
  }
  
  public void onDialogClicked(DialogInterface paramDialogInterface, int paramInt)
  {
    if (VideoReportInner.getInstance().isDebugMode())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDialogClicked, dialog = ");
      localStringBuilder.append(BaseUtils.getClassSimpleName(paramDialogInterface));
      localStringBuilder.append(", which = ");
      localStringBuilder.append(paramInt);
      Log.i("EventCollector", localStringBuilder.toString());
    }
    if (!VideoReportInner.getInstance().isDataCollectEnable()) {}
  }
  
  public void onDialogDispatchTouchEvent(Dialog paramDialog, MotionEvent paramMotionEvent, boolean paramBoolean1, boolean paramBoolean2)
  {
    notifyDispatchTouchEvent(paramDialog, paramDialog.getWindow(), paramMotionEvent, paramBoolean1, paramBoolean2);
  }
  
  public void onDialogFocusChanged(Dialog paramDialog, boolean paramBoolean)
  {
    Activity localActivity = DialogListUtil.getDialogActivity(paramDialog);
    if (VideoReportInner.getInstance().isDebugMode())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDialogFocusChanged: dialog = ");
      localStringBuilder.append(paramDialog.getClass().getName());
      localStringBuilder.append(", hasFocus = ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(", activity = ");
      localStringBuilder.append(UIUtils.getActivityInfo(localActivity));
      Log.i("EventCollector", localStringBuilder.toString());
    }
    if (!VideoReportInner.getInstance().isDataCollectEnable()) {
      return;
    }
    if (localActivity == null) {
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
    if (VideoReportInner.getInstance().isDebugMode())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDialogStop: dialog = ");
      localStringBuilder.append(paramDialog.getClass().getName());
      localStringBuilder.append(", activity = ");
      localStringBuilder.append(UIUtils.getActivityInfo(localActivity));
      Log.i("EventCollector", localStringBuilder.toString());
    }
    if (!VideoReportInner.getInstance().isDataCollectEnable()) {
      return;
    }
    DialogListUtil.onDialogStop(paramDialog);
    this.mNotifyManager.onDialogHide(localActivity, paramDialog);
  }
  
  public void onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (VideoReportInner.getInstance().isDebugMode())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onEditorAction, v = ");
      ((StringBuilder)localObject).append(UIUtils.getViewInfo(paramTextView));
      ((StringBuilder)localObject).append(" actionId = ");
      ((StringBuilder)localObject).append(paramInt);
      Log.i("EventCollector", ((StringBuilder)localObject).toString());
    }
    if (!VideoReportInner.getInstance().isDataCollectEnable()) {
      return;
    }
    Object localObject = (KeyBoardEditorActionNotifier)ReusablePool.obtain(11);
    ((KeyBoardEditorActionNotifier)localObject).init(paramTextView, paramInt, paramKeyEvent, 1);
    this.mNotifyManager.addEventNotifier(paramTextView, (IEventNotifier)localObject);
  }
  
  public void onFragmentDestroyView(FragmentCompat paramFragmentCompat)
  {
    if (VideoReportInner.getInstance().isDebugMode())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onFragmentDestroyView: fragment = ");
      localStringBuilder.append(paramFragmentCompat.getClass().getName());
      localStringBuilder.append(paramFragmentCompat.hashCode());
      Log.i("EventCollector", localStringBuilder.toString());
    }
    if (!VideoReportInner.getInstance().isDataCollectEnable()) {
      return;
    }
    this.mNotifyManager.onFragmentDestroyView(paramFragmentCompat);
  }
  
  public void onFragmentPaused(FragmentCompat paramFragmentCompat)
  {
    if (VideoReportInner.getInstance().isDebugMode())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onFragmentPaused: fragment = ");
      localStringBuilder.append(paramFragmentCompat.getClass().getName());
      localStringBuilder.append(paramFragmentCompat.hashCode());
      Log.i("EventCollector", localStringBuilder.toString());
    }
    if (!VideoReportInner.getInstance().isDataCollectEnable()) {
      return;
    }
    this.mNotifyManager.onFragmentPaused(paramFragmentCompat);
  }
  
  public void onFragmentResumed(FragmentCompat paramFragmentCompat)
  {
    if (VideoReportInner.getInstance().isDebugMode())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onFragmentResumed: fragment = ");
      localStringBuilder.append(paramFragmentCompat.getClass().getName());
      localStringBuilder.append(paramFragmentCompat.hashCode());
      Log.i("EventCollector", localStringBuilder.toString());
    }
    if (!VideoReportInner.getInstance().isDataCollectEnable()) {
      return;
    }
    this.mNotifyManager.onFragmentResumed(paramFragmentCompat);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (VideoReportInner.getInstance().isDebugMode())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onItemClick, parent = ");
      localStringBuilder.append(BaseUtils.getClassSimpleName(paramAdapterView));
      localStringBuilder.append(", view = ");
      localStringBuilder.append(UIUtils.getViewInfo(paramView));
      localStringBuilder.append(", position = ");
      localStringBuilder.append(paramInt);
      Log.i("EventCollector", localStringBuilder.toString());
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
    Object localObject;
    if (VideoReportInner.getInstance().isDebugMode())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onListGetView, parent = ");
      ((StringBuilder)localObject).append(UIUtils.getViewInfo(paramViewGroup));
      ((StringBuilder)localObject).append(", convertView = ");
      ((StringBuilder)localObject).append(UIUtils.getViewInfo(paramView));
      ((StringBuilder)localObject).append(", position = ");
      ((StringBuilder)localObject).append(paramInt);
      Log.i("EventCollector", ((StringBuilder)localObject).toString());
    }
    if (!VideoReportInner.getInstance().isDataCollectEnable()) {
      return;
    }
    if (paramView != null)
    {
      if (!LazyInitObserver.getInstance().mayProceedOnMain(null)) {
        return;
      }
      localObject = (ViewReuseNotifier)ReusablePool.obtain(5);
      ((ViewReuseNotifier)localObject).init(paramViewGroup, paramView, paramLong);
      this.mNotifyManager.addEventNotifier(paramView, (IEventNotifier)localObject);
    }
  }
  
  public void onListScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (VideoReportInner.getInstance().isDebugMode())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onListScrollStateChanged, view = ");
      ((StringBuilder)localObject).append(UIUtils.getViewInfo(paramAbsListView));
      ((StringBuilder)localObject).append(", scrollState = ");
      ((StringBuilder)localObject).append(paramInt);
      Log.i("EventCollector", ((StringBuilder)localObject).toString());
    }
    if (!VideoReportInner.getInstance().isDataCollectEnable()) {
      return;
    }
    Object localObject = (ListScrollNotifier)ReusablePool.obtain(1);
    ((ListScrollNotifier)localObject).init(paramAbsListView, paramInt);
    this.mNotifyManager.addEventNotifier(paramAbsListView, (IEventNotifier)localObject);
  }
  
  public void onRecyclerBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt, long paramLong)
  {
    if (VideoReportInner.getInstance().isDebugMode())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onRecyclerBindViewHolder, holder = ");
      localStringBuilder.append(BaseUtils.getClassSimpleName(paramViewHolder));
      localStringBuilder.append(", position = ");
      localStringBuilder.append(paramInt);
      Log.i("EventCollector", localStringBuilder.toString());
    }
    onRecyclerViewItemReuse(paramViewHolder, paramLong);
  }
  
  public void onRecyclerBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt, List<Object> paramList, long paramLong)
  {
    if (VideoReportInner.getInstance().isDebugMode())
    {
      paramList = new StringBuilder();
      paramList.append("onRecyclerBindViewHolder2, holder = ");
      paramList.append(BaseUtils.getClassSimpleName(paramViewHolder));
      paramList.append(", position = ");
      paramList.append(paramInt);
      Log.i("EventCollector", paramList.toString());
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
    if (VideoReportInner.getInstance().isDebugMode())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSetRecyclerViewAdapter, recyclerView = ");
      localStringBuilder.append(UIUtils.getViewInfo(paramRecyclerView));
      Log.i("EventCollector", localStringBuilder.toString());
    }
    if (!VideoReportInner.getInstance().isDataCollectEnable()) {
      return;
    }
    ThreadUtils.runOnUiThread(new EventCollector.1(this, paramRecyclerView));
  }
  
  public void onSetViewPagerAdapter(ViewPager paramViewPager)
  {
    if (VideoReportInner.getInstance().isDebugMode())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSetViewPagerAdapter, viewPager = ");
      localStringBuilder.append(UIUtils.getViewInfo(paramViewPager));
      Log.i("EventCollector", localStringBuilder.toString());
    }
    if (!VideoReportInner.getInstance().isDataCollectEnable()) {
      return;
    }
    ThreadUtils.runOnUiThread(new EventCollector.2(this, paramViewPager));
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    if (VideoReportInner.getInstance().isDebugMode())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onStopTrackingTouch, view = ");
      ((StringBuilder)localObject).append(UIUtils.getViewInfo(paramSeekBar));
      Log.i("EventCollector", ((StringBuilder)localObject).toString());
    }
    if (!VideoReportInner.getInstance().isDataCollectEnable()) {
      return;
    }
    Object localObject = (ViewClickNotifier)ReusablePool.obtain(3);
    ((ViewClickNotifier)localObject).init(paramSeekBar);
    this.mNotifyManager.addEventNotifier(paramSeekBar, (IEventNotifier)localObject);
  }
  
  public void onViewClicked(View paramView)
  {
    if (VideoReportInner.getInstance().isDebugMode())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onViewClicked, view = ");
      ((StringBuilder)localObject).append(UIUtils.getViewInfo(paramView));
      Log.i("EventCollector", ((StringBuilder)localObject).toString());
    }
    if (!VideoReportInner.getInstance().isDataCollectEnable()) {
      return;
    }
    Object localObject = (ViewClickNotifier)ReusablePool.obtain(3);
    ((ViewClickNotifier)localObject).init(paramView);
    this.mNotifyManager.addEventNotifier(paramView, (IEventNotifier)localObject);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.collect.EventCollector
 * JD-Core Version:    0.7.0.1
 */