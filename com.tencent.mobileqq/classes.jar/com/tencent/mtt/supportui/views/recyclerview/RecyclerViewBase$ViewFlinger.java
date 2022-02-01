package com.tencent.mtt.supportui.views.recyclerview;

import android.view.animation.Interpolator;
import com.tencent.mtt.supportui.utils.ViewCompatTool;
import java.util.ArrayList;

public class RecyclerViewBase$ViewFlinger
  implements Runnable
{
  boolean mCareSpringBackMaxDistance = false;
  boolean mEatRunOnAnimationRequest = false;
  Interpolator mInterpolator = RecyclerViewBase.sQuinticInterpolator;
  int mLastFlingX;
  int mLastFlingY;
  boolean mReSchedulePostAnimationCallback = false;
  public RecyclerViewBase.OnScrollFinishListener mScrollFinishListener;
  Scroller mScroller;
  public int mTargetPosition = 2147483647;
  
  public RecyclerViewBase$ViewFlinger(RecyclerViewBase paramRecyclerViewBase)
  {
    this.mScroller = new Scroller(paramRecyclerViewBase.getContext());
  }
  
  private void reportFinishState()
  {
    if (this.mScrollFinishListener != null)
    {
      if (this.this$0.checkShouldCallScrollFinish(this.mScroller, this.mTargetPosition)) {
        this.mScrollFinishListener.onScrollFinished();
      }
      this.mScrollFinishListener = null;
      this.mTargetPosition = 2147483647;
    }
  }
  
  int computeScrollDuration(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = Math.abs(paramInt1);
    int k = Math.abs(paramInt2);
    int i;
    if (j > k) {
      i = 1;
    } else {
      i = 0;
    }
    paramInt3 = (int)Math.sqrt(paramInt3 * paramInt3 + paramInt4 * paramInt4);
    paramInt2 = (int)Math.sqrt(paramInt1 * paramInt1 + paramInt2 * paramInt2);
    if (i != 0) {
      paramInt1 = this.this$0.getWidth();
    } else {
      paramInt1 = this.this$0.getHeight();
    }
    paramInt4 = paramInt1 / 2;
    if (paramInt1 != 0) {
      f1 = Math.min(1.0F, paramInt2 * 1.0F / paramInt1);
    } else {
      f1 = 1.0F;
    }
    float f2 = paramInt4;
    float f1 = distanceInfluenceForSnapDuration(f1);
    if (paramInt3 > 0)
    {
      paramInt1 = Math.round(Math.abs((f2 + f1 * f2) / paramInt3) * 1000.0F) * 4;
    }
    else
    {
      if (i != 0) {
        paramInt2 = j;
      } else {
        paramInt2 = k;
      }
      f1 = paramInt2;
      if (paramInt1 != 0) {
        paramInt1 = (int)((f1 / paramInt1 + 1.0F) * 300.0F);
      } else {
        paramInt1 = 300;
      }
    }
    return Math.min(paramInt1, 2000);
  }
  
  void disableRunOnAnimationRequests()
  {
    this.mReSchedulePostAnimationCallback = false;
    this.mEatRunOnAnimationRequest = true;
  }
  
  float distanceInfluenceForSnapDuration(float paramFloat)
  {
    double d = paramFloat - 0.5F;
    Double.isNaN(d);
    return (float)Math.sin((float)(d * 0.47123891676382D));
  }
  
  void enableRunOnAnimationRequests()
  {
    this.mEatRunOnAnimationRequest = false;
    if (this.mReSchedulePostAnimationCallback) {
      postOnAnimation();
    }
  }
  
  public void fling(int paramInt1, int paramInt2)
  {
    this.mCareSpringBackMaxDistance = true;
    this.this$0.setScrollState(2);
    this.mLastFlingY = 0;
    this.mLastFlingX = 0;
    this.mScroller.fling(0, 0, paramInt1, paramInt2, -2147483648, 2147483647, -2147483648, 2147483647);
    postOnAnimation();
  }
  
  public Scroller getScroller()
  {
    return this.mScroller;
  }
  
  public void postOnAnimation()
  {
    if (this.mEatRunOnAnimationRequest)
    {
      this.mReSchedulePostAnimationCallback = true;
      return;
    }
    ViewCompatTool.postOnAnimation(this.this$0, this);
  }
  
  public void run()
  {
    this.this$0.consumePendingUpdateOperations();
    Scroller localScroller = this.mScroller;
    RecyclerViewBase.SmoothScroller localSmoothScroller = this.this$0.mLayout.mSmoothScroller;
    if (localScroller.computeScrollOffset())
    {
      int n = localScroller.getCurrX();
      int i1 = localScroller.getCurrY();
      int k = n - this.mLastFlingX;
      int j = i1 - this.mLastFlingY;
      this.mLastFlingX = n;
      this.mLastFlingY = i1;
      int m = k;
      int i = j;
      if (this.this$0.mAdapter != null)
      {
        this.this$0.eatRequestLayout();
        if (k != 0)
        {
          k = this.this$0.computeDxDy(k, 0, this.mCareSpringBackMaxDistance, localScroller, false)[0];
          m = this.this$0.mLayout.scrollHorizontallyBy(k, this.this$0.mRecycler, this.this$0.mState);
          i = k;
          k -= m;
        }
        else
        {
          i = k;
          k = 0;
        }
        if (j != 0)
        {
          j = this.this$0.computeDxDy(0, j, this.mCareSpringBackMaxDistance, localScroller, false)[1];
          m = j - this.this$0.mLayout.scrollVerticallyBy(j, this.this$0.mRecycler, this.this$0.mState);
        }
        else
        {
          m = 0;
        }
        if ((localSmoothScroller != null) && (!localSmoothScroller.isPendingInitialRun()) && (localSmoothScroller.isRunning())) {
          localSmoothScroller.onAnimation(i - k, j - m);
        }
        this.this$0.resumeRequestLayout(false);
        m = i;
        i = j;
      }
      if (!this.this$0.mItemDecorations.isEmpty()) {
        this.this$0.invalidate();
      }
      this.this$0.checkRefreshHeadOnFlingRun();
      if ((this.this$0.mScrollListener != null) && ((n != 0) || (i1 != 0))) {
        this.this$0.mScrollListener.onScrolled(m, i);
      }
      this.this$0.invalidate();
    }
    if ((localSmoothScroller != null) && (localSmoothScroller.isPendingInitialRun())) {
      localSmoothScroller.onAnimation(0, 0);
    }
    if (localScroller.isFinished())
    {
      reportFinishState();
      this.this$0.handleRefreshHeadOnFlingRunEnd();
      this.this$0.setScrollState(0);
      this.this$0.releaseGlows(this.mScroller.isFling() ^ true, false);
      this.this$0.resetStopAtTitle();
      return;
    }
    postOnAnimation();
  }
  
  public void smoothScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    smoothScrollBy(paramInt1, paramInt2, computeScrollDuration(paramInt1, paramInt2, paramInt3, paramInt4), paramBoolean);
  }
  
  public void smoothScrollBy(int paramInt1, int paramInt2, int paramInt3, Interpolator paramInterpolator, boolean paramBoolean)
  {
    if (this.mInterpolator != paramInterpolator)
    {
      this.mInterpolator = paramInterpolator;
      this.mScroller = new Scroller(this.this$0.getContext());
    }
    this.mCareSpringBackMaxDistance = paramBoolean;
    this.this$0.setScrollState(2);
    this.mLastFlingY = 0;
    this.mLastFlingX = 0;
    this.mScroller.startScroll(0, 0, paramInt1, paramInt2, paramInt3);
    postOnAnimation();
  }
  
  public void smoothScrollBy(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    smoothScrollBy(paramInt1, paramInt2, paramInt3, RecyclerViewBase.sQuinticInterpolator, paramBoolean);
  }
  
  public void smoothScrollBy(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    smoothScrollBy(paramInt1, paramInt2, 0, 0, paramBoolean);
  }
  
  public void stop()
  {
    this.mScroller.abortAnimation();
    reportFinishState();
    this.this$0.removeCallbacks(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.ViewFlinger
 * JD-Core Version:    0.7.0.1
 */