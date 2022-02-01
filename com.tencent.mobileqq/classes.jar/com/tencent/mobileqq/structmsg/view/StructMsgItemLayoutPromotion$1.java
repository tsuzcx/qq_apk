package com.tencent.mobileqq.structmsg.view;

import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

class StructMsgItemLayoutPromotion$1
  implements Runnable
{
  StructMsgItemLayoutPromotion$1(StructMsgItemLayoutPromotion paramStructMsgItemLayoutPromotion, LinearLayout paramLinearLayout, TextView paramTextView1, float paramFloat, int paramInt, TextView paramTextView2, LinearLayout.LayoutParams paramLayoutParams) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getWidth() - this.jdField_a_of_type_AndroidWidgetTextView.getWidth() > this.jdField_a_of_type_Float + this.jdField_a_of_type_Int)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.b, this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams);
      StructMsgItemLayoutPromotion.a(this.this$0, 1);
      return;
    }
    StructMsgItemLayoutPromotion.a(this.this$0, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemLayoutPromotion.1
 * JD-Core Version:    0.7.0.1
 */