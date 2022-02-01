package com.tencent.mtt.supportui.views.recyclerview;

import android.graphics.PointF;
import android.view.View;

public abstract class RecyclerViewBase$SmoothScroller
{
  RecyclerViewBase.LayoutManager mLayoutManager;
  boolean mPendingInitialRun;
  RecyclerViewBase mRecyclerView;
  final RecyclerViewBase.SmoothScroller.Action mRecyclingAction = new RecyclerViewBase.SmoothScroller.Action(0, 0);
  boolean mRunning;
  int mTargetPosition = -2147483648;
  View mTargetView;
  
  public View findViewByPosition(int paramInt)
  {
    return this.mRecyclerView.mLayout.findViewByPosition(paramInt);
  }
  
  public int getChildCount()
  {
    return this.mRecyclerView.getChildCount();
  }
  
  public int getChildPosition(View paramView)
  {
    return this.mRecyclerView.getChildPosition(paramView);
  }
  
  public RecyclerViewBase.LayoutManager getLayoutManager()
  {
    return this.mLayoutManager;
  }
  
  public int getTargetPosition()
  {
    return this.mTargetPosition;
  }
  
  public void instantScrollToPosition(int paramInt)
  {
    this.mRecyclerView.scrollToPosition(paramInt);
  }
  
  public boolean isPendingInitialRun()
  {
    return this.mPendingInitialRun;
  }
  
  public boolean isRunning()
  {
    return this.mRunning;
  }
  
  protected void normalize(PointF paramPointF)
  {
    double d = Math.sqrt(paramPointF.x * paramPointF.x + paramPointF.y * paramPointF.y);
    paramPointF.x = ((float)(paramPointF.x / d));
    paramPointF.y = ((float)(paramPointF.y / d));
  }
  
  void onAnimation(int paramInt1, int paramInt2)
  {
    if ((!this.mRunning) || (this.mTargetPosition == -2147483648)) {
      stop();
    }
    this.mPendingInitialRun = false;
    if (this.mTargetView != null)
    {
      if (getChildPosition(this.mTargetView) != this.mTargetPosition) {
        break label117;
      }
      onTargetFound(this.mTargetView, this.mRecyclerView.mState, this.mRecyclingAction);
      this.mRecyclingAction.runInNecessary(this.mRecyclerView);
      stop();
    }
    for (;;)
    {
      if (this.mRunning)
      {
        onSeekTargetStep(paramInt1, paramInt2, this.mRecyclerView.mState, this.mRecyclingAction);
        this.mRecyclingAction.runInNecessary(this.mRecyclerView);
      }
      return;
      label117:
      this.mTargetView = null;
    }
  }
  
  protected void onChildAttachedToWindow(View paramView)
  {
    if (getChildPosition(paramView) == getTargetPosition()) {
      this.mTargetView = paramView;
    }
  }
  
  protected abstract void onSeekTargetStep(int paramInt1, int paramInt2, RecyclerViewBase.State paramState, RecyclerViewBase.SmoothScroller.Action paramAction);
  
  protected abstract void onStart();
  
  protected abstract void onStop();
  
  protected abstract void onTargetFound(View paramView, RecyclerViewBase.State paramState, RecyclerViewBase.SmoothScroller.Action paramAction);
  
  public void setTargetPosition(int paramInt)
  {
    this.mTargetPosition = paramInt;
  }
  
  void start(RecyclerViewBase paramRecyclerViewBase, RecyclerViewBase.LayoutManager paramLayoutManager)
  {
    this.mRecyclerView = paramRecyclerViewBase;
    this.mLayoutManager = paramLayoutManager;
    if (this.mTargetPosition == -2147483648) {
      throw new IllegalArgumentException("Invalid target position");
    }
    this.mRecyclerView.mState.mTargetPosition = this.mTargetPosition;
    this.mRunning = true;
    this.mPendingInitialRun = true;
    this.mTargetView = findViewByPosition(getTargetPosition());
    onStart();
    this.mRecyclerView.mViewFlinger.postOnAnimation();
  }
  
  protected final void stop()
  {
    if (!this.mRunning) {
      return;
    }
    onStop();
    this.mRecyclerView.mState.mTargetPosition = -2147483648;
    this.mTargetView = null;
    this.mTargetPosition = -2147483648;
    this.mPendingInitialRun = false;
    this.mRunning = false;
    this.mLayoutManager.onSmoothScrollerStopped(this);
    this.mLayoutManager = null;
    this.mRecyclerView = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.SmoothScroller
 * JD-Core Version:    0.7.0.1
 */