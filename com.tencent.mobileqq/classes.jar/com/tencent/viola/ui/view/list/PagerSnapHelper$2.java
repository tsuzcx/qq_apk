package com.tencent.viola.ui.view.list;

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
  
  public float calculateSpeedPerPixel(DisplayMetrics paramDisplayMetrics)
  {
    return PagerSnapHelper.access$2200(this.this$0) / paramDisplayMetrics.densityDpi;
  }
  
  public int calculateTimeForDeceleration(int paramInt)
  {
    return super.calculateTimeForDeceleration(paramInt);
  }
  
  public int calculateTimeForScrolling(int paramInt)
  {
    return super.calculateTimeForScrolling(paramInt);
  }
  
  public PointF computeScrollVectorForPosition(int paramInt)
  {
    return this.val$layoutManager.computeScrollVectorForPosition(paramInt);
  }
  
  public void onTargetFound(View paramView, RecyclerView.State paramState, RecyclerView.SmoothScroller.Action paramAction)
  {
    paramView = PagerSnapHelper.access$1900(this.this$0, this.val$layoutManager, paramView);
    int i = paramView[0];
    int j = paramView[1];
    int k = calculateTimeForDeceleration(Math.max(Math.abs(i), Math.abs(j)));
    if (k > 0)
    {
      paramAction.update(i, j, k, this.mDecelerateInterpolator);
      return;
    }
    PagerSnapHelper.TouchEventProcessor.access$2100(PagerSnapHelper.access$2000(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.viola.ui.view.list.PagerSnapHelper.2
 * JD-Core Version:    0.7.0.1
 */