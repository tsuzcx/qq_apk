package com.tencent.mobileqq.ocr.view;

import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.utils.BubbleContextMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.BubblePopupWindow.OnDismissListener;

public class CommonMenuPopupView
{
  public static int a;
  public static int b = 2;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  QQCustomMenu jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenu;
  private BubblePopupWindow.OnDismissListener jdField_a_of_type_ComTencentWidgetBubblePopupWindow$OnDismissListener;
  private BubblePopupWindow jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
  
  static
  {
    jdField_a_of_type_Int = 1;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null) && (this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b())) {
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a();
    }
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenu == null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenu = new QQCustomMenu();
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenu.a(paramInt1, paramString, paramInt2);
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    a(paramView, paramInt1, paramInt2, b, true);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null) && (this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b()))
    {
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a();
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = null;
    }
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = new BubblePopupWindow(-2, -2);
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(BubbleContextMenu.a(this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow, paramView.getContext(), this.jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenu, this.jdField_a_of_type_AndroidViewView$OnClickListener));
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(new ColorDrawable(0));
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.c(paramBoolean);
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(true);
    }
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(false);
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.c(true);
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.c(1);
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b(2);
    BubblePopupWindow localBubblePopupWindow = this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
    if (paramInt3 == jdField_a_of_type_Int) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      localBubblePopupWindow.d(paramBoolean);
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow$OnDismissListener);
      paramView.post(new CommonMenuPopupView.1(this, paramView, paramInt1, paramInt2));
      return;
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null) && (this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.view.CommonMenuPopupView
 * JD-Core Version:    0.7.0.1
 */