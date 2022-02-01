package com.tencent.timi.game.component.chat.message;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.timi.game.tim.api.impl.message.MessageUtils;
import com.tencent.timi.game.tim.api.impl.message.MessageUtils.Companion;
import com.tencent.timi.game.tim.api.message.IMsg;
import com.tencent.timi.game.ui.utils.TimeUtils;
import com.tencent.timi.game.ui.widget.CommonDialog;
import com.tencent.timi.game.ui.widget.CommonDialog.Builder;

class MessageViewOperator$2
  implements DialogInterface.OnClickListener
{
  MessageViewOperator$2(MessageViewOperator paramMessageViewOperator, LongClickOperOption[] paramArrayOfLongClickOperOption, Context paramContext, IMsg paramIMsg) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    LongClickOperOption localLongClickOperOption = this.a[paramInt];
    paramInt = MessageViewOperator.4.a[localLongClickOperOption.ordinal()];
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt == 4) {
            if (TimeUtils.a() - this.c.e() < 120000L) {
              new CommonDialog.Builder(this.b).c("是否撤回该条消息?").a(new MessageViewOperator.2.1(this)).a().show();
            } else {
              MessageUtils.a.a();
            }
          }
        }
        else {
          MessageUtils.c(this.c);
        }
      }
      else {
        MessageUtils.a(this.c);
      }
    }
    else {
      MessageUtils.a(this.b, this.c);
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.message.MessageViewOperator.2
 * JD-Core Version:    0.7.0.1
 */