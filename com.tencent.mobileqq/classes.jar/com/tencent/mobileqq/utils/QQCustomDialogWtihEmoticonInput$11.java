package com.tencent.mobileqq.utils;

import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QQCustomDialogWtihEmoticonInput$11
  implements View.OnClickListener
{
  QQCustomDialogWtihEmoticonInput$11(QQCustomDialogWtihEmoticonInput paramQQCustomDialogWtihEmoticonInput, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialogWtihEmoticonInput.hideSoftInputFromWindow();
    if (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null)
    {
      this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialogWtihEmoticonInput, 1);
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialogWtihEmoticonInput.c)
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialogWtihEmoticonInput.jdField_a_of_type_Boolean) {
          break label100;
        }
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialogWtihEmoticonInput.jdField_a_of_type_AndroidViewWindowManager.removeView(this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialogWtihEmoticonInput.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialogWtihEmoticonInput.c = false;
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialogWtihEmoticonInput.isShowing()) {
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialogWtihEmoticonInput.dismiss();
        }
        label92:
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        label100:
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialogWtihEmoticonInput.jdField_a_of_type_AndroidViewWindowManager.removeView(this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialogWtihEmoticonInput.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel);
      }
      catch (Exception localException)
      {
        break label92;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomDialogWtihEmoticonInput.11
 * JD-Core Version:    0.7.0.1
 */