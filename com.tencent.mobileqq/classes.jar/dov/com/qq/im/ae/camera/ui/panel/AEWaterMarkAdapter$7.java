package dov.com.qq.im.ae.camera.ui.panel;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSmoothScroller;
import android.util.DisplayMetrics;
import android.view.View;

final class AEWaterMarkAdapter$7
  extends LinearSmoothScroller
{
  AEWaterMarkAdapter$7(Context paramContext, LinearLayoutManager paramLinearLayoutManager, boolean paramBoolean)
  {
    super(paramContext);
  }
  
  public int calculateDtToFit(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    return (paramInt4 + paramInt3) / 2 - (paramInt2 + paramInt1) / 2;
  }
  
  public float calculateSpeedPerPixel(DisplayMetrics paramDisplayMetrics)
  {
    return 50.0F / paramDisplayMetrics.densityDpi;
  }
  
  public int calculateTimeForScrolling(int paramInt)
  {
    if (this.jdField_a_of_type_Boolean) {
      return 100;
    }
    return Math.min(200, super.calculateTimeForScrolling(paramInt));
  }
  
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
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.panel.AEWaterMarkAdapter.7
 * JD-Core Version:    0.7.0.1
 */