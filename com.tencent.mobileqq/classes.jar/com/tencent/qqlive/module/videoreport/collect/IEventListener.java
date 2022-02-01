package com.tencent.qqlive.module.videoreport.collect;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.inject.fragment.FragmentCompat;

public abstract interface IEventListener
{
  public abstract void onActivityConfigurationChanged(Activity paramActivity, Configuration paramConfiguration);
  
  public abstract void onActivityCreate(Activity paramActivity);
  
  public abstract void onActivityDestroyed(Activity paramActivity);
  
  public abstract void onActivityPause(Activity paramActivity);
  
  public abstract void onActivityResume(Activity paramActivity);
  
  public abstract void onActivityStarted(Activity paramActivity);
  
  public abstract void onActivityStopped(Activity paramActivity);
  
  public abstract void onChildViewAdded(View paramView1, View paramView2);
  
  public abstract void onChildViewRemoved(View paramView1, View paramView2);
  
  public abstract void onDialogClick(DialogInterface paramDialogInterface, int paramInt);
  
  public abstract void onDialogHide(Activity paramActivity, Dialog paramDialog);
  
  public abstract void onDialogShow(Activity paramActivity, Dialog paramDialog);
  
  public abstract void onDispatchTouchEvent(Object paramObject, Window paramWindow, MotionEvent paramMotionEvent, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void onEditorAction(TextView paramTextView, int paramInt1, KeyEvent paramKeyEvent, int paramInt2);
  
  public abstract void onFragmentDestroyView(FragmentCompat paramFragmentCompat);
  
  public abstract void onFragmentPause(FragmentCompat paramFragmentCompat);
  
  public abstract void onFragmentResume(FragmentCompat paramFragmentCompat);
  
  public abstract void onListScrollStateChanged(AbsListView paramAbsListView, int paramInt);
  
  public abstract void onRecyclerViewScrollPosition(RecyclerView paramRecyclerView);
  
  public abstract void onSetRecyclerViewAdapter(RecyclerView paramRecyclerView);
  
  public abstract void onSetViewPagerAdapter(ViewPager paramViewPager);
  
  public abstract void onViewClick(View paramView);
  
  public abstract void onViewReused(ViewGroup paramViewGroup, View paramView, long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.collect.IEventListener
 * JD-Core Version:    0.7.0.1
 */