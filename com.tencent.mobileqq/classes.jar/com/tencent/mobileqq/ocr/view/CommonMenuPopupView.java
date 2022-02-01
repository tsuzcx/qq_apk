package com.tencent.mobileqq.ocr.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItemPriorityHelper;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuNoIconLayout;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.BubblePopupWindow.OnDismissListener;

public class CommonMenuPopupView
{
  public static int a = 1;
  public static int b = 2;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  QQCustomMenu jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenu;
  private BubblePopupWindow.OnDismissListener jdField_a_of_type_ComTencentWidgetBubblePopupWindow$OnDismissListener;
  private BubblePopupWindow jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
  
  public static QQCustomMenuNoIconLayout a(BubblePopupWindow paramBubblePopupWindow, Context paramContext, QQCustomMenu paramQQCustomMenu, View.OnClickListener paramOnClickListener)
  {
    QQCustomMenuItemPriorityHelper.a(paramQQCustomMenu);
    paramContext = new QQCustomMenuNoIconLayout(paramContext);
    paramContext.setGravity(17);
    paramContext.setPadding(0, 0, 0, 0);
    paramContext.setPopupWindow(paramBubblePopupWindow, null);
    paramContext.setMenu(paramQQCustomMenu);
    paramContext.setMenuIconClickListener(paramOnClickListener);
    paramContext.a();
    return paramContext;
  }
  
  public void a()
  {
    BubblePopupWindow localBubblePopupWindow = this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
    if ((localBubblePopupWindow != null) && (localBubblePopupWindow.isShowing())) {
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.dismiss();
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
    BubblePopupWindow localBubblePopupWindow = this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
    if ((localBubblePopupWindow != null) && (localBubblePopupWindow.isShowing()))
    {
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.dismiss();
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = null;
    }
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = new BubblePopupWindow(-2, -2);
    localBubblePopupWindow = this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
    localBubblePopupWindow.setContentView(a(localBubblePopupWindow, paramView.getContext(), this.jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenu, this.jdField_a_of_type_AndroidViewView$OnClickListener));
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.setBackgroundDrawable(new ColorDrawable(0));
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.setOutsideTouchable(paramBoolean);
    boolean bool = true;
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.setFocusable(true);
    }
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.setFocusable(false);
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.setOutsideTouchable(true);
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.setSoftInputMode(1);
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.setInputMethodMode(2);
    localBubblePopupWindow = this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
    if (paramInt3 == jdField_a_of_type_Int) {
      paramBoolean = bool;
    } else {
      paramBoolean = false;
    }
    localBubblePopupWindow.setKeepAbove(paramBoolean);
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.setOnDismissListener(this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow$OnDismissListener);
    paramView.post(new CommonMenuPopupView.1(this, paramView, paramInt1, paramInt2));
  }
  
  public boolean a()
  {
    BubblePopupWindow localBubblePopupWindow = this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
    return (localBubblePopupWindow != null) && (localBubblePopupWindow.isShowing());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.view.CommonMenuPopupView
 * JD-Core Version:    0.7.0.1
 */