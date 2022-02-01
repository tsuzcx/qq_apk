package com.tencent.timi.game.component.chat.message;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.timi.game.tim.api.impl.message.MessageUtils;
import com.tencent.timi.game.tim.api.impl.message.MessageUtils.Companion;
import com.tencent.timi.game.tim.api.message.IMsg;
import com.tencent.timi.game.ui.utils.TimeUtils;

class MessageViewOperator$2$1
  implements DialogInterface.OnClickListener
{
  MessageViewOperator$2$1(MessageViewOperator.2 param2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (TimeUtils.a() - this.a.c.e() < 120000L)
    {
      MessageUtils.d(this.a.c);
      return;
    }
    MessageUtils.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.message.MessageViewOperator.2.1
 * JD-Core Version:    0.7.0.1
 */