package com.tencent.widget.pull2refresh;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView.SmoothScroller.Action;
import android.support.v7.widget.RecyclerView.State;
import android.util.DisplayMetrics;
import android.view.View;

class PagerSnapHelper$2
  extends LinearSmoothScroller
{
  PagerSnapHelper$2(PagerSnapHelper paramPagerSnapHelper, Context paramContext, LinearLayoutManager paramLinearLayoutManager)
  {
    super(paramContext);
  }
  
  protected float calculateSpeedPerPixel(DisplayMetrics paramDisplayMetrics)
  {
    return PagerSnapHelper.m(this.b) / paramDisplayMetrics.densityDpi;
  }
  
  protected int calculateTimeForDeceleration(int paramInt)
  {
    return super.calculateTimeForDeceleration(paramInt);
  }
  
  protected int calculateTimeForScrolling(int paramInt)
  {
    return super.calculateTimeForScrolling(paramInt);
  }
  
  public PointF computeScrollVectorForPosition(int paramInt)
  {
    return this.a.computeScrollVectorForPosition(paramInt);
  }
  
  protected void onTargetFound(View paramView, RecyclerView.State paramState, RecyclerView.SmoothScroller.Action paramAction)
  {
    paramView = PagerSnapHelper.a(this.b, this.a, paramView);
    int i = paramView[0];
    int j = paramView[1];
    int k = calculateTimeForDeceleration(Math.max(Math.abs(i), Math.abs(j)));
    if (k > 0)
    {
      paramAction.update(i, j, k, this.mDecelerateInterpolator);
      return;
    }
    PagerSnapHelper.TouchEventProcessor.a(PagerSnapHelper.l(this.b));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.pull2refresh.PagerSnapHelper.2
 * JD-Core Version:    0.7.0.1
 */