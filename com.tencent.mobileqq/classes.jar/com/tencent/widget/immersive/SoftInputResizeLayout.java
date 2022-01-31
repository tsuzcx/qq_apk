package com.tencent.widget.immersive;

import amen;
import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

public class SoftInputResizeLayout
{
  private int jdField_a_of_type_Int;
  Activity jdField_a_of_type_AndroidAppActivity;
  private View jdField_a_of_type_AndroidViewView;
  private FrameLayout.LayoutParams jdField_a_of_type_AndroidWidgetFrameLayout$LayoutParams;
  
  private SoftInputResizeLayout(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidViewView = ((FrameLayout)paramActivity.findViewById(16908290)).getChildAt(0);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidViewView.getViewTreeObserver().addOnGlobalLayoutListener(new amen(this));
    this.jdField_a_of_type_AndroidWidgetFrameLayout$LayoutParams = ((FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams());
  }
  
  private int a()
  {
    Rect localRect = new Rect();
    this.jdField_a_of_type_AndroidViewView.getWindowVisibleDisplayFrame(localRect);
    return localRect.bottom - localRect.top;
  }
  
  private void a()
  {
    int i = a();
    int j;
    int k;
    if (i != this.jdField_a_of_type_Int)
    {
      j = this.jdField_a_of_type_AndroidViewView.getRootView().getHeight();
      k = j - i;
      if (k <= j / 4) {
        break label66;
      }
    }
    label66:
    for (this.jdField_a_of_type_AndroidWidgetFrameLayout$LayoutParams.height = (j - k + ImmersiveUtils.a(this.jdField_a_of_type_AndroidAppActivity));; this.jdField_a_of_type_AndroidWidgetFrameLayout$LayoutParams.height = j)
    {
      this.jdField_a_of_type_AndroidViewView.requestLayout();
      this.jdField_a_of_type_Int = i;
      return;
    }
  }
  
  public static void a(Activity paramActivity)
  {
    new SoftInputResizeLayout(paramActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.widget.immersive.SoftInputResizeLayout
 * JD-Core Version:    0.7.0.1
 */