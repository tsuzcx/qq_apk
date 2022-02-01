package com.tencent.timi.game.component.chat.message;

import android.content.Context;
import com.tencent.timi.game.tim.api.message.IMsg;
import com.tencent.timi.game.tim.api.message.MsgStatus;
import com.tencent.timi.game.ui.widget.MenuDialog;
import com.tencent.timi.game.ui.widget.MenuDialog.Builder;

public class MessageViewOperator
{
  public void a() {}
  
  public void a(Context paramContext, IMsg paramIMsg, int paramInt1, int paramInt2)
  {
    paramContext = new MenuDialog.Builder(paramContext);
    paramIMsg = new MessageViewOperator.1(this, paramIMsg);
    paramContext.a(new String[] { "重发", "删除" }, paramIMsg).a().a(paramInt1, paramInt2);
  }
  
  public void a(Context paramContext, IMsg paramIMsg, LongClickOperOption[] paramArrayOfLongClickOperOption, int paramInt1, int paramInt2)
  {
    if (paramIMsg != null)
    {
      Object localObject = paramIMsg.f();
      MsgStatus localMsgStatus = MsgStatus.SUCCESS;
      int j = 0;
      if (localObject == localMsgStatus)
      {
        int i;
        if ((paramIMsg.j()) && (System.currentTimeMillis() - paramIMsg.e() < 120000L)) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0) {
          localObject = new LongClickOperOption[paramArrayOfLongClickOperOption.length + 1];
        } else {
          localObject = paramArrayOfLongClickOperOption;
        }
        if (i != 0)
        {
          System.arraycopy(paramArrayOfLongClickOperOption, 0, localObject, 0, paramArrayOfLongClickOperOption.length);
          localObject[(localObject.length - 1)] = LongClickOperOption.REVOCATION;
        }
        if ((localObject != null) && (localObject.length > 0))
        {
          paramArrayOfLongClickOperOption = new String[localObject.length];
          i = j;
          while (i < localObject.length)
          {
            j = MessageViewOperator.4.a[localObject[i].ordinal()];
            if (j != 1)
            {
              if (j != 2)
              {
                if (j != 3)
                {
                  if (j == 4) {
                    paramArrayOfLongClickOperOption[i] = "撤回";
                  }
                }
                else {
                  paramArrayOfLongClickOperOption[i] = "举报";
                }
              }
              else {
                paramArrayOfLongClickOperOption[i] = "删除";
              }
            }
            else {
              paramArrayOfLongClickOperOption[i] = "复制";
            }
            i += 1;
          }
          new MenuDialog.Builder(paramContext).a(paramArrayOfLongClickOperOption, new MessageViewOperator.2(this, (LongClickOperOption[])localObject, paramContext, paramIMsg)).a().a(paramInt1, paramInt2);
        }
      }
      else
      {
        if (paramIMsg.f() == MsgStatus.SENDING)
        {
          paramContext = new MenuDialog.Builder(paramContext);
          paramIMsg = new MessageViewOperator.3(this, paramIMsg);
          paramContext.a(new String[] { "删除" }, paramIMsg).a().a(paramInt1, paramInt2);
          return;
        }
        if (paramIMsg.f() == MsgStatus.FAILED) {
          a(paramContext, paramIMsg, paramInt1, paramInt2);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.message.MessageViewOperator
 * JD-Core Version:    0.7.0.1
 */