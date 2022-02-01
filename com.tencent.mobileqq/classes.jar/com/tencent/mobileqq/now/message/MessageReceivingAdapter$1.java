package com.tencent.mobileqq.now.message;

import android.view.View;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.now.roport.NowQQLiveDataReport;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;

class MessageReceivingAdapter$1
  extends OnArkViewTouchListener
{
  MessageReceivingAdapter$1(MessageReceivingAdapter paramMessageReceivingAdapter, int paramInt, MessageForStructing paramMessageForStructing, StructMsgForGeneralShare paramStructMsgForGeneralShare) {}
  
  public boolean onClick(View paramView)
  {
    NowQQLiveDataReport.b(this.jdField_a_of_type_Int + 1, ChatMessageHelper.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing), "2");
    if (MessageReceivingAdapter.a(this.jdField_a_of_type_ComTencentMobileqqNowMessageMessageReceivingAdapter, paramView, this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing, this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare)) {
      return true;
    }
    return super.onClick(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.now.message.MessageReceivingAdapter.1
 * JD-Core Version:    0.7.0.1
 */