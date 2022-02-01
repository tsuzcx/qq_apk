package com.tencent.mobileqq.structmsg.view;

import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.widget.SingleLineTextView;

class StructMsgItemLayout20$1
  implements Runnable
{
  StructMsgItemLayout20$1(StructMsgItemLayout20 paramStructMsgItemLayout20, int paramInt, StructMsgItemLayout20.Holder paramHolder) {}
  
  public void run()
  {
    int i = this.jdField_a_of_type_Int;
    int j = this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemLayout20$Holder.jdField_a_of_type_AndroidWidgetTextView.getWidth();
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemLayout20$Holder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.getLayoutParams();
    localLayoutParams.rightMargin = (i + j);
    this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemLayout20$Holder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setLayoutParams(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemLayout20.1
 * JD-Core Version:    0.7.0.1
 */