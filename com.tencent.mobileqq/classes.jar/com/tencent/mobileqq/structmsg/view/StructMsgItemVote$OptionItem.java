package com.tencent.mobileqq.structmsg.view;

import android.text.TextUtils;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgNode;

public class StructMsgItemVote$OptionItem
{
  String a;
  String b;
  
  public StructMsgItemVote$OptionItem(StructMsgItemVote paramStructMsgItemVote, StructMsgNode paramStructMsgNode)
  {
    if (paramStructMsgNode == null) {
      return;
    }
    this.a = paramStructMsgNode.a("c");
    if (TextUtils.isEmpty(this.a)) {
      this.a = paramStructMsgNode.a("r");
    }
    this.b = MessageUtils.a(StructMsgFactory.a(paramStructMsgNode), false);
  }
  
  public StructMsgItemVote$OptionItem(StructMsgItemVote paramStructMsgItemVote, String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemVote.OptionItem
 * JD-Core Version:    0.7.0.1
 */