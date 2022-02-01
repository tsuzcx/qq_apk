package com.tencent.mobileqq.structmsg.view;

import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import bdsf;

public class StructMsgItemLayoutPromotion$1
  implements Runnable
{
  public StructMsgItemLayoutPromotion$1(bdsf parambdsf, LinearLayout paramLinearLayout, TextView paramTextView1, float paramFloat, int paramInt, TextView paramTextView2, LinearLayout.LayoutParams paramLayoutParams) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getWidth() - this.jdField_a_of_type_AndroidWidgetTextView.getWidth() > this.jdField_a_of_type_Float + this.jdField_a_of_type_Int)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.b, this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams);
      bdsf.a(this.this$0, 1);
      return;
    }
    bdsf.a(this.this$0, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemLayoutPromotion.1
 * JD-Core Version:    0.7.0.1
 */