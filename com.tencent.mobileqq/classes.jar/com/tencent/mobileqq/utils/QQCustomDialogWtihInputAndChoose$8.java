package com.tencent.mobileqq.utils;

import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class QQCustomDialogWtihInputAndChoose$8
  implements View.OnClickListener
{
  QQCustomDialogWtihInputAndChoose$8(QQCustomDialogWtihInputAndChoose paramQQCustomDialogWtihInputAndChoose, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialogWtihInputAndChoose.getInputValue();
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialogWtihInputAndChoose.a != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialogWtihInputAndChoose.a.size() > 0))
    {
      int i = 0;
      while ((i < this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialogWtihInputAndChoose.a.size()) && (!((String)localObject).equals(this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialogWtihInputAndChoose.a.get(i)))) {
        i += 1;
      }
    }
    localObject = this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener;
    if (localObject != null)
    {
      ((DialogInterface.OnClickListener)localObject).onClick(this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialogWtihInputAndChoose, 1);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialogWtihInputAndChoose.a();
    }
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialogWtihInputAndChoose.isShowing()) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialogWtihInputAndChoose.dismiss();
      }
      label129:
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (Exception localException)
    {
      break label129;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomDialogWtihInputAndChoose.8
 * JD-Core Version:    0.7.0.1
 */