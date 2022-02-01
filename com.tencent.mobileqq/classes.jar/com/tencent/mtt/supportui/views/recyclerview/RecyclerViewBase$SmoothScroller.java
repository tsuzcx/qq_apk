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
    double d1 = Math.sqrt(paramPointF.x * paramPointF.x + paramPointF.y * paramPointF.y);
    double d2 = paramPointF.x;
    Double.isNaN(d2);
    paramPointF.x = ((float)(d2 / d1));
    d2 = paramPointF.y;
    Double.isNaN(d2);
    paramPointF.y = ((float)(d2 / d1));
  }
  
  void onAnimation(int paramInt1, int paramInt2)
  {
    if ((!this.mRunning) || (this.mTargetPosition == -2147483648)) {
      stop();
    }
    this.mPendingInitialRun = false;
    View localView = this.mTargetView;
    if (localView != null) {
      if (getChildPosition(localView) == this.mTargetPosition)
      {
        onTargetFound(this.mTargetView, this.mRecyclerView.mState, this.mRecyclingAction);
        this.mRecyclingAction.runInNecessary(this.mRecyclerView);
        stop();
      }
      else
      {
        this.mTargetView = null;
      }
    }
    if (this.mRunning)
    {
      onSeekTargetStep(paramInt1, paramInt2, this.mRecyclerView.mState, this.mRecyclingAction);
      this.mRecyclingAction.runInNecessary(this.mRecyclerView);
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
    if (this.mTargetPosition != -2147483648)
    {
      this.mRecyclerView.mState.mTargetPosition = this.mTargetPosition;
      this.mRunning = true;
      this.mPendingInitialRun = true;
      this.mTargetView = findViewByPosition(getTargetPosition());
      onStart();
      this.mRecyclerView.mViewFlinger.postOnAnimation();
      return;
    }
    throw new IllegalArgumentException("Invalid target position");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.SmoothScroller
 * JD-Core Version:    0.7.0.1
 */