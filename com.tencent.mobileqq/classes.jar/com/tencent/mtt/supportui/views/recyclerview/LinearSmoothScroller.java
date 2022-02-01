package com.tencent.mtt.supportui.views.recyclerview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

public abstract class LinearSmoothScroller
  extends RecyclerViewBase.SmoothScroller
{
  private static final boolean DEBUG = false;
  private static final float MILLISECONDS_PER_INCH = 25.0F;
  public static final int SNAP_TO_ANY = 0;
  public static final int SNAP_TO_END = 1;
  public static final int SNAP_TO_START = -1;
  private static final String TAG = "LinearSmoothScroller";
  private static final float TARGET_SEEK_EXTRA_SCROLL_RATIO = 1.2F;
  private static final int TARGET_SEEK_SCROLL_DISTANCE_PX = 10000;
  private final float MILLISECONDS_PER_PX = calculateSpeedPerPixel(paramContext.getResources().getDisplayMetrics());
  protected final DecelerateInterpolator mDecelerateInterpolator = new DecelerateInterpolator();
  protected int mInterimTargetDx = 0;
  protected int mInterimTargetDy = 0;
  protected final LinearInterpolator mLinearInterpolator = new LinearInterpolator();
  protected PointF mTargetVector;
  
  public LinearSmoothScroller(Context paramContext) {}
  
  private int clampApplyScroll(int paramInt1, int paramInt2)
  {
    paramInt2 = paramInt1 - paramInt2;
    if (paramInt1 * paramInt2 <= 0) {
      return 0;
    }
    return paramInt2;
  }
  
  public int calculateDtToFit(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (paramInt5 != -1)
    {
      if (paramInt5 != 0)
      {
        if (paramInt5 == 1) {
          return paramInt4 - paramInt2;
        }
        throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
      }
      paramInt1 = paramInt3 - paramInt1;
      if (paramInt1 > 0) {
        return paramInt1;
      }
      paramInt1 = paramInt4 - paramInt2;
      if (paramInt1 < 0) {
        return paramInt1;
      }
      return 0;
    }
    return paramInt3 - paramInt1;
  }
  
  public int calculateDxToMakeVisible(View paramView, int paramInt)
  {
    RecyclerViewBase.LayoutManager localLayoutManager = getLayoutManager();
    if (!localLayoutManager.canScrollHorizontally()) {
      return 0;
    }
    RecyclerViewBase.LayoutParams localLayoutParams = (RecyclerViewBase.LayoutParams)paramView.getLayoutParams();
    return calculateDtToFit(localLayoutManager.getDecoratedLeft(paramView) - localLayoutParams.leftMargin, localLayoutManager.getDecoratedRight(paramView) + localLayoutParams.rightMargin, localLayoutManager.getPaddingLeft(), localLayoutManager.getWidth() - localLayoutManager.getPaddingRight(), paramInt);
  }
  
  public int calculateDyToMakeVisible(View paramView, int paramInt)
  {
    RecyclerViewBase.LayoutManager localLayoutManager = getLayoutManager();
    if (!localLayoutManager.canScrollVertically()) {
      return 0;
    }
    RecyclerViewBase.LayoutParams localLayoutParams = (RecyclerViewBase.LayoutParams)paramView.getLayoutParams();
    return calculateDtToFit(localLayoutManager.getDecoratedTop(paramView) - localLayoutParams.topMargin, localLayoutManager.getDecoratedBottom(paramView) + localLayoutParams.bottomMargin, localLayoutManager.getPaddingTop(), localLayoutManager.getHeight() - localLayoutManager.getPaddingBottom(), paramInt);
  }
  
  protected float calculateSpeedPerPixel(DisplayMetrics paramDisplayMetrics)
  {
    return 25.0F / paramDisplayMetrics.densityDpi;
  }
  
  protected int calculateTimeForDeceleration(int paramInt)
  {
    double d = calculateTimeForScrolling(paramInt);
    Double.isNaN(d);
    return (int)Math.ceil(d / 0.3356D);
  }
  
  protected int calculateTimeForScrolling(int paramInt)
  {
    return (int)Math.ceil(Math.abs(paramInt) * this.MILLISECONDS_PER_PX);
  }
  
  public abstract PointF computeScrollVectorForPosition(int paramInt);
  
  protected int getHorizontalSnapPreference()
  {
    PointF localPointF = this.mTargetVector;
    if ((localPointF != null) && (localPointF.x != 0.0F))
    {
      if (this.mTargetVector.x > 0.0F) {
        return 1;
      }
      return -1;
    }
    return 0;
  }
  
  protected int getVerticalSnapPreference()
  {
    PointF localPointF = this.mTargetVector;
    if ((localPointF != null) && (localPointF.y != 0.0F))
    {
      if (this.mTargetVector.y > 0.0F) {
        return 1;
      }
      return -1;
    }
    return 0;
  }
  
  protected void onSeekTargetStep(int paramInt1, int paramInt2, RecyclerViewBase.State paramState, RecyclerViewBase.SmoothScroller.Action paramAction)
  {
    if (getChildCount() == 0)
    {
      stop();
      return;
    }
    this.mInterimTargetDx = clampApplyScroll(this.mInterimTargetDx, paramInt1);
    this.mInterimTargetDy = clampApplyScroll(this.mInterimTargetDy, paramInt2);
    if ((this.mInterimTargetDx == 0) && (this.mInterimTargetDy == 0)) {
      updateActionForInterimTarget(paramAction);
    }
  }
  
  protected void onStart() {}
  
  protected void onStop()
  {
    this.mInterimTargetDy = 0;
    this.mInterimTargetDx = 0;
    this.mTargetVector = null;
  }
  
  protected void onTargetFound(View paramView, RecyclerViewBase.State paramState, RecyclerViewBase.SmoothScroller.Action paramAction)
  {
    int i = calculateDxToMakeVisible(paramView, getHorizontalSnapPreference());
    int j = calculateDyToMakeVisible(paramView, getVerticalSnapPreference());
    int k = calculateTimeForDeceleration((int)Math.sqrt(i * i + j * j));
    if (k > 0) {
      paramAction.update(-i, -j, k, this.mDecelerateInterpolator);
    }
  }
  
  protected void updateActionForInterimTarget(RecyclerViewBase.SmoothScroller.Action paramAction)
  {
    PointF localPointF = computeScrollVectorForPosition(getTargetPosition());
    if ((localPointF != null) && ((localPointF.x != 0.0F) || (localPointF.y != 0.0F)))
    {
      normalize(localPointF);
      this.mTargetVector = localPointF;
      this.mInterimTargetDx = ((int)(localPointF.x * 10000.0F));
      this.mInterimTargetDy = ((int)(localPointF.y * 10000.0F));
      i = calculateTimeForScrolling(10000);
      paramAction.update((int)(this.mInterimTargetDx * 1.2F), (int)(this.mInterimTargetDy * 1.2F), (int)(i * 1.2F), this.mLinearInterpolator);
      return;
    }
    int i = getTargetPosition();
    stop();
    instantScrollToPosition(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.supportui.views.recyclerview.LinearSmoothScroller
 * JD-Core Version:    0.7.0.1
 */