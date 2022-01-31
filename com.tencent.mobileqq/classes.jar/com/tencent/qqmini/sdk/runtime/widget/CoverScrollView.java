package com.tencent.qqmini.sdk.runtime.widget;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ScrollView;
import com.tencent.qqmini.sdk.core.widget.CoverView;
import com.tencent.qqmini.sdk.utils.DisplayUtil;

public class CoverScrollView
  extends CoverView
{
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ScrollView jdField_a_of_type_AndroidWidgetScrollView;
  
  public CoverScrollView(@NonNull Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidWidgetScrollView = new ScrollView(paramContext);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(paramContext);
    this.jdField_a_of_type_AndroidWidgetScrollView.addView(this.jdField_a_of_type_AndroidWidgetFrameLayout);
    paramContext = new FrameLayout.LayoutParams(-1, -1);
    addView(this.jdField_a_of_type_AndroidWidgetScrollView, paramContext);
  }
  
  public void addView(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(paramView);
  }
  
  public void removeView(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout.removeView(paramView);
  }
  
  public void setBorder(int paramInt1, int paramInt2, float paramFloat, int paramInt3)
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setColor(paramInt3);
    localGradientDrawable.setCornerRadius(DisplayUtil.getDensity(getContext()) * paramFloat);
    if (paramInt1 > 0) {
      localGradientDrawable.setStroke(paramInt1, paramInt2);
    }
    this.jdField_a_of_type_AndroidWidgetScrollView.setBackgroundDrawable(localGradientDrawable);
  }
  
  public void setContainerSize(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout != null)
    {
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(paramInt1, paramInt2);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams(localLayoutParams);
    }
  }
  
  public void setScrollTop(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetScrollView.setScrollY(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.widget.CoverScrollView
 * JD-Core Version:    0.7.0.1
 */