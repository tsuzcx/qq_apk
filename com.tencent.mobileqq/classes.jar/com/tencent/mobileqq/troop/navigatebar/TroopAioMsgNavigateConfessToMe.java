package com.tencent.mobileqq.troop.navigatebar;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.troop.data.TroopAioAgent.Message;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class TroopAioMsgNavigateConfessToMe
  extends BaseTroopAioMsgMultiNavigateBarDelegate
{
  public TroopAioMsgNavigateConfessToMe(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramContext, paramSessionInfo);
    this.jdField_a_of_type_Int = 11;
  }
  
  @Nullable
  public BaseTroopAioMsgNavigateBarDelegate.Entity a(int paramInt1, List<Long> paramList, long paramLong1, Object paramObject, long paramLong2, long paramLong3, int paramInt2)
  {
    paramObject = TroopAioAgent.Message.a(paramInt1, paramLong1, paramInt2);
    String str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131698644);
    paramList = "";
    boolean bool2 = false;
    MessageRecord localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramLong1);
    if (localMessageRecord != null) {
      paramList = localMessageRecord.senderuin;
    }
    boolean bool1 = bool2;
    if (paramLong2 != TroopAioMsgNavigateBar.a)
    {
      bool1 = bool2;
      if (paramLong1 < paramLong2) {
        bool1 = true;
      }
    }
    String str2;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      str2 = this.jdField_a_of_type_JavaLangString + ".troop.special_msg.confess_to_me";
      localStringBuilder = new StringBuilder().append("需要定位的第一条消息是否已经拉到本地：");
      if (localMessageRecord == null) {
        break label188;
      }
    }
    label188:
    for (bool2 = true;; bool2 = false)
    {
      QLog.d(str2, 2, bool2 + ", isShow = " + bool1);
      if (!bool1) {
        break;
      }
      return new BaseTroopAioMsgNavigateBarDelegate.Entity(true, str1, paramObject, paramList);
    }
    return null;
  }
  
  public void a(int paramInt, TextView paramTextView1, TextView paramTextView2, ImageView paramImageView, String paramString)
  {
    paramTextView1.setText(HardCodeUtil.a(2131715019));
    paramTextView2.setText(HardCodeUtil.a(2131715030));
    paramTextView1.setTextSize(1, 13.0F);
    paramTextView2.setTextSize(1, 13.0F);
  }
  
  public void a(int paramInt1, TroopAioAgent.Message paramMessage, String paramString, int paramInt2, TextView paramTextView1, TextView paramTextView2, long paramLong)
  {
    super.a(paramInt1, paramMessage, paramString, paramInt2, paramTextView1, paramTextView2, paramLong);
    paramString = null;
    if (paramLong != TroopAioMsgNavigateBar.a) {
      paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramLong);
    }
    if (paramString != null) {
      paramTextView1.setText(HardCodeUtil.a(2131715024));
    }
    if (((paramString instanceof MessageForQQWalletMsg)) && (MessageForQQWalletMsg.isRedPacketMsg(paramString)))
    {
      paramString = (MessageForQQWalletMsg)paramString;
      if ((paramString.messageType == 7) || (paramString.messageType == 8))
      {
        paramTextView2.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131719042));
        paramMessage.b = true;
      }
    }
    while (paramInt2 <= 0)
    {
      return;
      paramTextView2.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131719026));
      paramMessage.a = true;
      return;
    }
    paramMessage.a = false;
    paramTextView2.setText(HardCodeUtil.a(2131715022));
  }
  
  public void a(int paramInt, Object paramObject, String paramString) {}
  
  public void b(int paramInt, Object paramObject, String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.navigatebar.TroopAioMsgNavigateConfessToMe
 * JD-Core Version:    0.7.0.1
 */