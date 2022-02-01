package com.tencent.mobileqq.utils.dialogutils;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QQCustomMenuNoIconLayout$1
  implements View.OnClickListener
{
  QQCustomMenuNoIconLayout$1(QQCustomMenuNoIconLayout paramQQCustomMenuNoIconLayout, boolean paramBoolean) {}
  
  public void onClick(View paramView)
  {
    QQCustomMenuNoIconLayout localQQCustomMenuNoIconLayout = this.jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenuNoIconLayout;
    int i;
    if (this.jdField_a_of_type_Boolean) {
      i = QQCustomMenuNoIconLayout.a(localQQCustomMenuNoIconLayout);
    } else {
      i = QQCustomMenuNoIconLayout.b(localQQCustomMenuNoIconLayout);
    }
    QQCustomMenuNoIconLayout.a(localQQCustomMenuNoIconLayout, localQQCustomMenuNoIconLayout.a(i), true);
    if (QQCustomMenuNoIconLayout.a(this.jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenuNoIconLayout) != null) {
      QQCustomMenuNoIconLayout.a(this.jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenuNoIconLayout).b(this.jdField_a_of_type_Boolean);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.dialogutils.QQCustomMenuNoIconLayout.1
 * JD-Core Version:    0.7.0.1
 */