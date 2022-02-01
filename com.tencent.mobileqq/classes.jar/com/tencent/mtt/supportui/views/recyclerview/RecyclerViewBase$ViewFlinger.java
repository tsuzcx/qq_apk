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
    if (j > k)
    {
      i = 1;
      paramInt3 = (int)Math.sqrt(paramInt3 * paramInt3 + paramInt4 * paramInt4);
      paramInt1 = (int)Math.sqrt(paramInt1 * paramInt1 + paramInt2 * paramInt2);
      if (i == 0) {
        break label144;
      }
      paramInt2 = this.this$0.getWidth();
      label63:
      paramInt4 = paramInt2 / 2;
      if (paramInt2 == 0) {
        break label196;
      }
    }
    label144:
    label196:
    for (float f1 = Math.min(1.0F, paramInt1 * 1.0F / paramInt2);; f1 = 1.0F)
    {
      float f2 = paramInt4;
      float f3 = paramInt4;
      f1 = distanceInfluenceForSnapDuration(f1);
      if (paramInt3 > 0)
      {
        paramInt1 = Math.round(1000.0F * Math.abs((f1 * f3 + f2) / paramInt3)) * 4;
        return Math.min(paramInt1, 2000);
        i = 0;
        break;
        paramInt2 = this.this$0.getHeight();
        break label63;
      }
      if (i != 0) {}
      for (paramInt1 = j;; paramInt1 = k)
      {
        f1 = paramInt1;
        paramInt1 = 300;
        if (paramInt2 == 0) {
          break;
        }
        paramInt1 = (int)((f1 / paramInt2 + 1.0F) * 300.0F);
        break;
      }
    }
  }
  
  void disableRunOnAnimationRequests()
  {
    this.mReSchedulePostAnimationCallback = false;
    this.mEatRunOnAnimationRequest = true;
  }
  
  float distanceInfluenceForSnapDuration(float paramFloat)
  {
    return (float)Math.sin((float)((paramFloat - 0.5F) * 0.47123891676382D));
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
    Object localObject = this.mScroller;
    RecyclerViewBase.SmoothScroller localSmoothScroller = this.this$0.mLayout.mSmoothScroller;
    int n;
    int i1;
    int i;
    int j;
    int m;
    if (((Scroller)localObject).computeScrollOffset())
    {
      n = ((Scroller)localObject).getCurrX();
      i1 = ((Scroller)localObject).getCurrY();
      i = n - this.mLastFlingX;
      j = i1 - this.mLastFlingY;
      this.mLastFlingX = n;
      this.mLastFlingY = i1;
      m = i;
      k = j;
      if (this.this$0.mAdapter != null)
      {
        this.this$0.eatRequestLayout();
        if (i == 0) {
          break label414;
        }
        i = this.this$0.computeDxDy(i, 0, this.mCareSpringBackMaxDistance, localObject, false)[0];
      }
    }
    label414:
    for (int k = i - this.this$0.mLayout.scrollHorizontallyBy(i, this.this$0.mRecycler, this.this$0.mState);; k = 0)
    {
      if (j != 0) {
        j = this.this$0.computeDxDy(0, j, this.mCareSpringBackMaxDistance, localObject, false)[1];
      }
      for (m = j - this.this$0.mLayout.scrollVerticallyBy(j, this.this$0.mRecycler, this.this$0.mState);; m = 0)
      {
        if ((localSmoothScroller != null) && (!localSmoothScroller.isPendingInitialRun()) && (localSmoothScroller.isRunning())) {
          localSmoothScroller.onAnimation(i - k, j - m);
        }
        this.this$0.resumeRequestLayout(false);
        k = j;
        m = i;
        if (!this.this$0.mItemDecorations.isEmpty()) {
          this.this$0.invalidate();
        }
        this.this$0.checkRefreshHeadOnFlingRun();
        if ((this.this$0.mScrollListener != null) && ((n != 0) || (i1 != 0))) {
          this.this$0.mScrollListener.onScrolled(m, k);
        }
        this.this$0.invalidate();
        if ((localSmoothScroller != null) && (localSmoothScroller.isPendingInitialRun())) {
          localSmoothScroller.onAnimation(0, 0);
        }
        if (((Scroller)localObject).isFinished())
        {
          reportFinishState();
          this.this$0.handleRefreshHeadOnFlingRunEnd();
          this.this$0.setScrollState(0);
          localObject = this.this$0;
          if (!this.mScroller.isFling()) {}
          for (boolean bool = true;; bool = false)
          {
            ((RecyclerViewBase)localObject).releaseGlows(bool, false);
            this.this$0.resetStopAtTitle();
            return;
          }
        }
        postOnAnimation();
        return;
      }
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.ViewFlinger
 * JD-Core Version:    0.7.0.1
 */