package com.tencent.mobileqq.forward;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ForwardStructingMsgOption$3
  implements View.OnClickListener
{
  ForwardStructingMsgOption$3(ForwardStructingMsgOption paramForwardStructingMsgOption, boolean paramBoolean, String paramString, long paramLong) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqForwardForwardStructingMsgOption.a != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqForwardForwardStructingMsgOption.a.hideSoftInputFromWindow();
      ForwardStructingMsgOption.a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardStructingMsgOption, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long);
      this.jdField_a_of_type_ComTencentMobileqqForwardForwardStructingMsgOption.G();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardStructingMsgOption.3
 * JD-Core Version:    0.7.0.1
 */