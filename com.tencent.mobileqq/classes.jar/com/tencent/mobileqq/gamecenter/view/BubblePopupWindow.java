package com.tencent.mobileqq.gamecenter.view;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.PopupWindow;

public class BubblePopupWindow
  extends PopupWindow
{
  public static float a;
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private FrameLayout.LayoutParams jdField_a_of_type_AndroidWidgetFrameLayout$LayoutParams;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private BubblePopupWindow.SharpView jdField_a_of_type_ComTencentMobileqqGamecenterViewBubblePopupWindow$SharpView;
  private int b;
  private int c = 80;
  private int d = 49;
  
  static
  {
    jdField_a_of_type_Float = 0.0F;
  }
  
  public BubblePopupWindow(Context paramContext)
  {
    super(-2, -2);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a();
  }
  
  private void a()
  {
    FrameLayout localFrameLayout = new FrameLayout(this.jdField_a_of_type_AndroidContentContext);
    BubblePopupWindow.SharpView localSharpView = new BubblePopupWindow.SharpView(this, this.jdField_a_of_type_AndroidContentContext);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewBubblePopupWindow$SharpView = localSharpView;
    this.jdField_a_of_type_AndroidWidgetFrameLayout = localFrameLayout;
    this.jdField_a_of_type_AndroidWidgetFrameLayout$LayoutParams = localLayoutParams;
    setBackgroundDrawable(new ColorDrawable(0));
    setTouchable(true);
    setFocusable(false);
    setSoftInputMode(1);
    setInputMethodMode(2);
    a(24, 12);
    a(12);
    c(6);
    b(-1);
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
    this.jdField_a_of_type_AndroidWidgetFrameLayout$LayoutParams.gravity = this.d;
    BubblePopupWindow.SharpView.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterViewBubblePopupWindow$SharpView).setColor(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentMobileqqGamecenterViewBubblePopupWindow$SharpView, this.jdField_a_of_type_AndroidWidgetFrameLayout$LayoutParams);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = this.c;
    switch (this.c)
    {
    }
    for (;;)
    {
      GradientDrawable localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setColor(this.jdField_a_of_type_Int);
      localGradientDrawable.setCornerRadius(this.b);
      this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(localGradientDrawable);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_AndroidViewView, localLayoutParams);
      super.setContentView(this.jdField_a_of_type_AndroidWidgetFrameLayout);
      return;
      localLayoutParams.rightMargin = BubblePopupWindow.SharpView.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterViewBubblePopupWindow$SharpView);
      this.jdField_a_of_type_ComTencentMobileqqGamecenterViewBubblePopupWindow$SharpView.setRotation(90.0F);
      continue;
      localLayoutParams.bottomMargin = BubblePopupWindow.SharpView.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterViewBubblePopupWindow$SharpView);
      this.jdField_a_of_type_ComTencentMobileqqGamecenterViewBubblePopupWindow$SharpView.setRotation(180.0F);
      continue;
      localLayoutParams.leftMargin = BubblePopupWindow.SharpView.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterViewBubblePopupWindow$SharpView);
      this.jdField_a_of_type_ComTencentMobileqqGamecenterViewBubblePopupWindow$SharpView.setRotation(270.0F);
      continue;
      localLayoutParams.topMargin = BubblePopupWindow.SharpView.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterViewBubblePopupWindow$SharpView);
      this.jdField_a_of_type_ComTencentMobileqqGamecenterViewBubblePopupWindow$SharpView.setRotation(0.0F);
    }
  }
  
  public void a(int paramInt)
  {
    BubblePopupWindow.SharpView.c(this.jdField_a_of_type_ComTencentMobileqqGamecenterViewBubblePopupWindow$SharpView, paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    BubblePopupWindow.SharpView.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterViewBubblePopupWindow$SharpView, paramInt1);
    BubblePopupWindow.SharpView.b(this.jdField_a_of_type_ComTencentMobileqqGamecenterViewBubblePopupWindow$SharpView, paramInt2);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout$LayoutParams.leftMargin = paramInt1;
    this.jdField_a_of_type_AndroidWidgetFrameLayout$LayoutParams.rightMargin = paramInt2;
    this.jdField_a_of_type_AndroidWidgetFrameLayout$LayoutParams.topMargin = paramInt3;
    this.jdField_a_of_type_AndroidWidgetFrameLayout$LayoutParams.bottomMargin = paramInt4;
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void c(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void setContentView(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public void showAsDropDown(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.c = paramInt3;
    if (this.jdField_a_of_type_AndroidViewView != null) {
      b();
    }
    super.showAsDropDown(paramView, paramInt1, paramInt2, paramInt3);
  }
  
  public void showAtLocation(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.c = paramInt1;
    if (this.jdField_a_of_type_AndroidViewView != null) {
      b();
    }
    super.showAtLocation(paramView, paramInt1, paramInt2, paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.view.BubblePopupWindow
 * JD-Core Version:    0.7.0.1
 */