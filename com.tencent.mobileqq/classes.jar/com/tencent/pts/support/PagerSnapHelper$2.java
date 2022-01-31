package com.tencent.pts.support;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView.SmoothScroller.Action;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;

class PagerSnapHelper$2
  extends LinearSmoothScroller
{
  PagerSnapHelper$2(PagerSnapHelper paramPagerSnapHelper, Context paramContext, LinearLayoutManager paramLinearLayoutManager)
  {
    super(paramContext);
  }
  
  public int calculateTimeForDeceleration(int paramInt)
  {
    return Math.min(300, super.calculateTimeForDeceleration(paramInt));
  }
  
  public PointF computeScrollVectorForPosition(int paramInt)
  {
    return this.val$layoutManager.computeScrollVectorForPosition(paramInt);
  }
  
  public void onTargetFound(View paramView, RecyclerView.State paramState, RecyclerView.SmoothScroller.Action paramAction)
  {
    paramView = PagerSnapHelper.access$1400(this.this$0, this.val$layoutManager, paramView);
    int i = paramView[0];
    int j = paramView[1];
    int k = calculateTimeForDeceleration(Math.max(Math.abs(i), Math.abs(j)));
    if (k > 0)
    {
      paramAction.update(i, j, k, this.mDecelerateInterpolator);
      return;
    }
    PagerSnapHelper.TouchEventProcessor.access$1600(PagerSnapHelper.access$1500(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.pts.support.PagerSnapHelper.2
 * JD-Core Version:    0.7.0.1
 */