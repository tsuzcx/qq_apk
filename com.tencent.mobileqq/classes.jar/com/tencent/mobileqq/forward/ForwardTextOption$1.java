package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ForwardTextOption$1
  implements View.OnClickListener
{
  ForwardTextOption$1(ForwardTextOption paramForwardTextOption) {}
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.hideSoftInputFromWindow();
      ForwardPreviewTextController localForwardPreviewTextController = new ForwardPreviewTextController(this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog);
      localForwardPreviewTextController.a(this.a.jdField_a_of_type_AndroidAppActivity.getString(2131692691), this.a.jdField_a_of_type_JavaLangString);
      this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.addPreviewView(localForwardPreviewTextController.b());
      this.a.F();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardTextOption.1
 * JD-Core Version:    0.7.0.1
 */