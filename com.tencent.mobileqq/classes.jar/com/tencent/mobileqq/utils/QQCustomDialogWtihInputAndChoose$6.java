package com.tencent.mobileqq.utils;

import android.view.WindowManager;
import com.tencent.mobileqq.qwallet.widget.MyLinearLayout;

class QQCustomDialogWtihInputAndChoose$6
  implements Runnable
{
  QQCustomDialogWtihInputAndChoose$6(QQCustomDialogWtihInputAndChoose paramQQCustomDialogWtihInputAndChoose) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_AndroidViewWindowManager$LayoutParams == null) {
      return;
    }
    this.this$0.jdField_a_of_type_AndroidViewWindowManager.addView(this.this$0.jdField_a_of_type_ComTencentMobileqqQwalletWidgetMyLinearLayout, this.this$0.jdField_a_of_type_AndroidViewWindowManager$LayoutParams);
    QQCustomDialogWtihInputAndChoose localQQCustomDialogWtihInputAndChoose = this.this$0;
    localQQCustomDialogWtihInputAndChoose.b = true;
    localQQCustomDialogWtihInputAndChoose.jdField_a_of_type_ComTencentMobileqqQwalletWidgetMyLinearLayout.post(new QQCustomDialogWtihInputAndChoose.6.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomDialogWtihInputAndChoose.6
 * JD-Core Version:    0.7.0.1
 */