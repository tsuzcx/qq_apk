package com.tencent.mobileqq.troop.navigatebar;

import android.content.Context;
import android.content.res.Resources;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.utils.ContactUtils;

public class TroopAioMsgNavigateFocusWord
  extends BaseTroopFocusAioMsgNavigateBar
{
  public TroopAioMsgNavigateFocusWord(QQAppInterface paramQQAppInterface, Context paramContext, BaseSessionInfo paramBaseSessionInfo)
  {
    super(paramQQAppInterface, paramContext, paramBaseSessionInfo);
    this.c = 100;
  }
  
  public int a(int paramInt)
  {
    return 2130849362;
  }
  
  public void a(int paramInt, TextView paramTextView1, TextView paramTextView2, ImageView paramImageView, String paramString)
  {
    paramTextView1.setText(paramString);
    paramTextView2.setText(2131897523);
    paramTextView2.setVisibility(0);
    paramTextView1.setVisibility(0);
  }
  
  public void a(int paramInt1, AioAgent.Message paramMessage, String paramString, int paramInt2, TextView paramTextView1, TextView paramTextView2, long paramLong)
  {
    super.a(paramInt1, paramMessage, paramString, paramInt2, paramTextView1, paramTextView2, paramLong);
    if (paramLong != TroopAioMsgNavigateBar.b) {
      paramString = this.d.getMessageFacade().d(this.f.b, this.f.a, paramLong);
    } else {
      paramString = null;
    }
    if (paramString != null) {
      paramTextView1.setText(ContactUtils.b(this.d, this.f.b, paramString.senderuin));
    }
    if (((paramString instanceof MessageForQQWalletMsg)) && (MessageForQQWalletMsg.isRedPacketMsg(paramString)))
    {
      paramString = (MessageForQQWalletMsg)paramString;
      if ((paramString.messageType != 7) && (paramString.messageType != 8))
      {
        paramTextView2.setText(this.e.getString(2131916248));
        paramMessage.g = true;
        return;
      }
      paramTextView2.setText(this.e.getString(2131916264));
      paramMessage.h = true;
      return;
    }
    if (paramInt2 > 0)
    {
      paramMessage.g = false;
      paramString = this.e.getResources();
      if (paramInt2 > 99) {
        paramMessage = "99+";
      } else {
        paramMessage = Integer.valueOf(paramInt2);
      }
      paramTextView1.setText(paramString.getString(2131897526, new Object[] { paramMessage }));
    }
  }
  
  public void a(int paramInt, Object paramObject, String paramString) {}
  
  public void b(int paramInt, Object paramObject, String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.navigatebar.TroopAioMsgNavigateFocusWord
 * JD-Core Version:    0.7.0.1
 */