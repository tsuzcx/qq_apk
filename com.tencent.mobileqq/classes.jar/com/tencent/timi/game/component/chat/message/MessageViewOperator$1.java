package com.tencent.timi.game.component.chat.message;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.timi.game.tim.api.impl.message.MessageUtils;
import com.tencent.timi.game.tim.api.message.IMsg;

class MessageViewOperator$1
  implements DialogInterface.OnClickListener
{
  MessageViewOperator$1(MessageViewOperator paramMessageViewOperator, IMsg paramIMsg) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt == 1) {
        MessageUtils.a(this.a);
      }
    }
    else {
      MessageUtils.b(this.a);
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.message.MessageViewOperator.1
 * JD-Core Version:    0.7.0.1
 */