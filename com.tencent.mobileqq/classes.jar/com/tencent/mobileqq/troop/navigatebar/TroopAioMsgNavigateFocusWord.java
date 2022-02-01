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
import com.tencent.mobileqq.troop.data.TroopAioAgent.Message;
import com.tencent.mobileqq.utils.ContactUtils;

public class TroopAioMsgNavigateFocusWord
  extends BaseTroopFocusAioMsgNavigateBar
{
  public TroopAioMsgNavigateFocusWord(QQAppInterface paramQQAppInterface, Context paramContext, BaseSessionInfo paramBaseSessionInfo)
  {
    super(paramQQAppInterface, paramContext, paramBaseSessionInfo);
    this.jdField_a_of_type_Int = 100;
  }
  
  public int a(int paramInt)
  {
    return 2130847702;
  }
  
  public void a(int paramInt, TextView paramTextView1, TextView paramTextView2, ImageView paramImageView, String paramString)
  {
    paramTextView1.setText(paramString);
    paramTextView2.setText(2131699492);
    paramTextView2.setVisibility(0);
    paramTextView1.setVisibility(0);
  }
  
  public void a(int paramInt1, TroopAioAgent.Message paramMessage, String paramString, int paramInt2, TextView paramTextView1, TextView paramTextView2, long paramLong)
  {
    super.a(paramInt1, paramMessage, paramString, paramInt2, paramTextView1, paramTextView2, paramLong);
    if (paramLong != TroopAioMsgNavigateBar.a) {
      paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().d(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int, paramLong);
    } else {
      paramString = null;
    }
    if (paramString != null) {
      paramTextView1.setText(ContactUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString, paramString.senderuin));
    }
    if (((paramString instanceof MessageForQQWalletMsg)) && (MessageForQQWalletMsg.isRedPacketMsg(paramString)))
    {
      paramString = (MessageForQQWalletMsg)paramString;
      if ((paramString.messageType != 7) && (paramString.messageType != 8))
      {
        paramTextView2.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131718742));
        paramMessage.a = true;
        return;
      }
      paramTextView2.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131718758));
      paramMessage.b = true;
      return;
    }
    if (paramInt2 > 0)
    {
      paramMessage.a = false;
      paramString = this.jdField_a_of_type_AndroidContentContext.getResources();
      if (paramInt2 > 99) {
        paramMessage = "99+";
      } else {
        paramMessage = Integer.valueOf(paramInt2);
      }
      paramTextView1.setText(paramString.getString(2131699495, new Object[] { paramMessage }));
    }
  }
  
  public void a(int paramInt, Object paramObject, String paramString) {}
  
  public void b(int paramInt, Object paramObject, String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.navigatebar.TroopAioMsgNavigateFocusWord
 * JD-Core Version:    0.7.0.1
 */