package com.tencent.mobileqq.utils.dialogutils;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.BubblePopupWindow;

class QQCustomMenuNoIconLayout$2
  implements View.OnClickListener
{
  QQCustomMenuNoIconLayout$2(QQCustomMenuNoIconLayout paramQQCustomMenuNoIconLayout, QQCustomMenuItem paramQQCustomMenuItem) {}
  
  public void onClick(View paramView)
  {
    if (QQCustomMenuNoIconLayout.a(this.jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenuNoIconLayout) != null) {
      QQCustomMenuNoIconLayout.a(this.jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenuNoIconLayout).onClick(paramView);
    }
    QQCustomMenuNoIconLayout.a(this.jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenuNoIconLayout).dismiss();
    if (QQCustomMenuNoIconLayout.a(this.jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenuNoIconLayout) != null) {
      QQCustomMenuNoIconLayout.a(this.jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenuNoIconLayout).a(this.jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenuItem);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.dialogutils.QQCustomMenuNoIconLayout.2
 * JD-Core Version:    0.7.0.1
 */