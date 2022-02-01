package com.tencent.mobileqq.kandian.biz.video.discovery;

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
  private BubblePopupWindow.SharpView jdField_a_of_type_ComTencentMobileqqKandianBizVideoDiscoveryBubblePopupWindow$SharpView;
  private int b;
  private int c = 80;
  private int d = 49;
  
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
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDiscoveryBubblePopupWindow$SharpView = localSharpView;
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
    BubblePopupWindow.SharpView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDiscoveryBubblePopupWindow$SharpView).setColor(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDiscoveryBubblePopupWindow$SharpView, this.jdField_a_of_type_AndroidWidgetFrameLayout$LayoutParams);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    int i = this.c;
    localLayoutParams.gravity = i;
    if (i != 3)
    {
      if (i != 5)
      {
        if (i != 48)
        {
          if (i == 80)
          {
            localLayoutParams.topMargin = BubblePopupWindow.SharpView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDiscoveryBubblePopupWindow$SharpView);
            this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDiscoveryBubblePopupWindow$SharpView.setRotation(0.0F);
          }
        }
        else
        {
          localLayoutParams.bottomMargin = BubblePopupWindow.SharpView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDiscoveryBubblePopupWindow$SharpView);
          this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDiscoveryBubblePopupWindow$SharpView.setRotation(180.0F);
        }
      }
      else
      {
        localLayoutParams.leftMargin = BubblePopupWindow.SharpView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDiscoveryBubblePopupWindow$SharpView);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDiscoveryBubblePopupWindow$SharpView.setRotation(270.0F);
      }
    }
    else
    {
      localLayoutParams.rightMargin = BubblePopupWindow.SharpView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDiscoveryBubblePopupWindow$SharpView);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDiscoveryBubblePopupWindow$SharpView.setRotation(90.0F);
    }
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setColor(this.jdField_a_of_type_Int);
    localGradientDrawable.setCornerRadius(this.b);
    this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(localGradientDrawable);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_AndroidViewView, localLayoutParams);
    super.setContentView(this.jdField_a_of_type_AndroidWidgetFrameLayout);
  }
  
  public int a()
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView == null) {
      return 0;
    }
    localView.measure(0, 0);
    return this.jdField_a_of_type_AndroidViewView.getMeasuredHeight();
  }
  
  public void a(int paramInt)
  {
    BubblePopupWindow.SharpView.c(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDiscoveryBubblePopupWindow$SharpView, paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    BubblePopupWindow.SharpView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDiscoveryBubblePopupWindow$SharpView, paramInt1);
    BubblePopupWindow.SharpView.b(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDiscoveryBubblePopupWindow$SharpView, paramInt2);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    FrameLayout.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidWidgetFrameLayout$LayoutParams;
    localLayoutParams.leftMargin = paramInt1;
    localLayoutParams.rightMargin = paramInt2;
    localLayoutParams.topMargin = paramInt3;
    localLayoutParams.bottomMargin = paramInt4;
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!isShowing())
    {
      int i = 49;
      if (paramInt1 != 3)
      {
        if (paramInt1 != 5)
        {
          if (paramInt1 == 48) {
            i = 81;
          }
        }
        else {
          i = 19;
        }
      }
      else {
        i = 21;
      }
      this.c = paramInt1;
      d(i);
      showAtLocation(paramView, 0, paramInt2, paramInt3);
      return;
    }
    dismiss();
  }
  
  public int b()
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView == null) {
      return 0;
    }
    localView.measure(0, 0);
    return this.jdField_a_of_type_AndroidViewView.getMeasuredWidth();
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int c()
  {
    return BubblePopupWindow.SharpView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDiscoveryBubblePopupWindow$SharpView);
  }
  
  public void c(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void d(int paramInt)
  {
    this.d = paramInt;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.discovery.BubblePopupWindow
 * JD-Core Version:    0.7.0.1
 */