package dov.com.qq.im.aeeditor.module.filter;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"dov/com/qq/im/aeeditor/module/filter/AdapterUtil$scrollToPositionAndLayoutCenter$scroller$1", "Landroid/support/v7/widget/LinearSmoothScroller;", "calculateDtToFit", "", "viewStart", "viewEnd", "boxStart", "boxEnd", "snapPreference", "calculateSpeedPerPixel", "", "displayMetrics", "Landroid/util/DisplayMetrics;", "calculateTimeForScrolling", "dx", "computeScrollVectorForPosition", "Landroid/graphics/PointF;", "targetPos", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class AdapterUtil$scrollToPositionAndLayoutCenter$scroller$1
  extends LinearSmoothScroller
{
  AdapterUtil$scrollToPositionAndLayoutCenter$scroller$1(LinearLayoutManager paramLinearLayoutManager, boolean paramBoolean, RecyclerView paramRecyclerView, Context paramContext)
  {
    super(paramContext);
  }
  
  public int calculateDtToFit(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    return (paramInt4 + paramInt3) / 2 - (paramInt2 + paramInt1) / 2;
  }
  
  public float calculateSpeedPerPixel(@NotNull DisplayMetrics paramDisplayMetrics)
  {
    Intrinsics.checkParameterIsNotNull(paramDisplayMetrics, "displayMetrics");
    return 50.0F / paramDisplayMetrics.densityDpi;
  }
  
  public int calculateTimeForScrolling(int paramInt)
  {
    if (this.jdField_a_of_type_Boolean) {
      return 100;
    }
    return RangesKt.coerceAtMost(200, super.calculateTimeForScrolling(paramInt));
  }
  
  @Nullable
  public PointF computeScrollVectorForPosition(int paramInt)
  {
    int i = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findFirstVisibleItemPosition();
    int j = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findLastVisibleItemPosition();
    float f;
    if (paramInt < i) {
      f = -1.0F;
    }
    for (;;)
    {
      return new PointF(f, 0.0F);
      if (paramInt > j)
      {
        f = 1.0F;
      }
      else
      {
        View localView = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findViewByPosition(paramInt);
        if (localView != null)
        {
          f = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.getWidth() / 2.0F;
          paramInt = localView.getLeft();
          f -= (localView.getRight() + paramInt) / 2.0F;
        }
        else
        {
          f = 0.0F;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.filter.AdapterUtil.scrollToPositionAndLayoutCenter.scroller.1
 * JD-Core Version:    0.7.0.1
 */