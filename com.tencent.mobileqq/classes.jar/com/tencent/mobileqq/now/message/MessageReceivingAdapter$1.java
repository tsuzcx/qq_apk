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
    NowQQLiveDataReport.b(this.a + 1, ChatMessageHelper.b(this.b), "2");
    if (MessageReceivingAdapter.a(this.d, paramView, this.b, this.c)) {
      return true;
    }
    return super.onClick(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.now.message.MessageReceivingAdapter.1
 * JD-Core Version:    0.7.0.1
 */