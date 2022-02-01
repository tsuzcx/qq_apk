package com.tencent.mobileqq.structmsg.view;

import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import bdrf;
import bdrg;
import com.tencent.widget.SingleLineTextView;

public class StructMsgItemLayout20$1
  implements Runnable
{
  public StructMsgItemLayout20$1(bdrf parambdrf, int paramInt, bdrg parambdrg) {}
  
  public void run()
  {
    int i = this.jdField_a_of_type_Int;
    int j = this.jdField_a_of_type_Bdrg.jdField_a_of_type_AndroidWidgetTextView.getWidth();
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_Bdrg.jdField_a_of_type_ComTencentWidgetSingleLineTextView.getLayoutParams();
    localLayoutParams.rightMargin = (j + i);
    this.jdField_a_of_type_Bdrg.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setLayoutParams(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemLayout20.1
 * JD-Core Version:    0.7.0.1
 */