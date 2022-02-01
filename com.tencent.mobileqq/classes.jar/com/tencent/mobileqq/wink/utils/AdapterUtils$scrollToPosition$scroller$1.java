package com.tencent.mobileqq.wink.utils;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/wink/utils/AdapterUtils$scrollToPosition$scroller$1", "Landroid/support/v7/widget/LinearSmoothScroller;", "calculateDtToFit", "", "viewStart", "viewEnd", "boxStart", "boxEnd", "snapPreference", "calculateSpeedPerPixel", "", "displayMetrics", "Landroid/util/DisplayMetrics;", "calculateTimeForScrolling", "dx", "computeScrollVectorForPosition", "Landroid/graphics/PointF;", "targetPos", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class AdapterUtils$scrollToPosition$scroller$1
  extends LinearSmoothScroller
{
  AdapterUtils$scrollToPosition$scroller$1(LinearLayoutManager paramLinearLayoutManager, int paramInt, boolean paramBoolean, RecyclerView paramRecyclerView, Context paramContext)
  {
    super(paramContext);
  }
  
  public int calculateDtToFit(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    paramInt5 = this.b;
    if (paramInt5 != -1)
    {
      if (paramInt5 != 1)
      {
        if (paramInt5 != 2) {
          return super.calculateDtToFit(paramInt1, paramInt2, paramInt3, paramInt4, 0);
        }
        return paramInt3 + (paramInt4 - paramInt3) / 2 - (paramInt1 + (paramInt2 - paramInt1) / 2);
      }
      return super.calculateDtToFit(paramInt1, paramInt2, paramInt3, paramInt4, 1);
    }
    return super.calculateDtToFit(paramInt1, paramInt2, paramInt3, paramInt4, -1);
  }
  
  protected float calculateSpeedPerPixel(@NotNull DisplayMetrics paramDisplayMetrics)
  {
    Intrinsics.checkParameterIsNotNull(paramDisplayMetrics, "displayMetrics");
    return 50.0F / paramDisplayMetrics.densityDpi;
  }
  
  protected int calculateTimeForScrolling(int paramInt)
  {
    if (this.c) {
      return 100;
    }
    return RangesKt.coerceAtMost(200, super.calculateTimeForScrolling(paramInt));
  }
  
  @Nullable
  public PointF computeScrollVectorForPosition(int paramInt)
  {
    int i = this.a.findFirstVisibleItemPosition();
    int j = this.a.findLastVisibleItemPosition();
    float f;
    if (paramInt < i) {
      f = -1.0F;
    } else if (paramInt > j) {
      f = 1.0F;
    } else {
      f = 0.0F;
    }
    if (this.a.getOrientation() == 0) {
      return new PointF(f, 0.0F);
    }
    return new PointF(0.0F, f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.utils.AdapterUtils.scrollToPosition.scroller.1
 * JD-Core Version:    0.7.0.1
 */