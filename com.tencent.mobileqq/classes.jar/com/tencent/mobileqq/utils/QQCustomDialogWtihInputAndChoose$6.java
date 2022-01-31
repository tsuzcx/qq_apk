package com.tencent.mobileqq.utils;

import android.view.WindowManager;
import bdll;
import com.tencent.mobileqq.activity.qwallet.widget.MyLinearLayout;

public class QQCustomDialogWtihInputAndChoose$6
  implements Runnable
{
  public QQCustomDialogWtihInputAndChoose$6(bdll parambdll) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_AndroidViewWindowManager$LayoutParams == null) {
      return;
    }
    this.this$0.jdField_a_of_type_AndroidViewWindowManager.addView(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetMyLinearLayout, this.this$0.jdField_a_of_type_AndroidViewWindowManager$LayoutParams);
    this.this$0.b = true;
    this.this$0.jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetMyLinearLayout.post(new QQCustomDialogWtihInputAndChoose.6.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomDialogWtihInputAndChoose.6
 * JD-Core Version:    0.7.0.1
 */