package com.tencent.mobileqq.troop.navigatebar;

import android.content.Context;
import android.content.res.Resources;
import android.widget.TextView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopAioAgent.Message;
import com.tencent.mobileqq.utils.ContactUtils;

public class TroopAioMsgNavigateSpecial
  extends BaseTroopFocusAioMsgNavigateBar
{
  public TroopAioMsgNavigateSpecial(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramContext, paramSessionInfo);
    this.jdField_a_of_type_Int = 17;
  }
  
  public void a(int paramInt1, TroopAioAgent.Message paramMessage, String paramString, int paramInt2, TextView paramTextView1, TextView paramTextView2, long paramLong)
  {
    super.a(paramInt1, paramMessage, paramString, paramInt2, paramTextView1, paramTextView2, paramLong);
    paramString = null;
    if (paramLong != TroopAioMsgNavigateBar.a) {
      paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramLong);
    }
    if (paramString != null) {
      paramTextView1.setText(ContactUtils.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramString.senderuin));
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
    paramString = this.jdField_a_of_type_AndroidContentContext.getResources();
    if (paramInt2 > 99) {}
    for (paramMessage = "99+";; paramMessage = Integer.valueOf(paramInt2))
    {
      paramTextView2.setText(paramString.getString(2131694393, new Object[] { paramMessage }));
      return;
    }
  }
  
  public void a(int paramInt, Object paramObject, String paramString)
  {
    if (((paramObject instanceof TroopAioAgent.Message)) && (((TroopAioAgent.Message)paramObject).a)) {}
    for (paramInt = 1; paramInt != 0; paramInt = 0)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Appear_topmsgcue_hongbao", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "notice_center_new", "exp_hongbao", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
      return;
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Appear_topmsgcue_sf", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "notice_center_new", "exp_special_focus", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
  }
  
  public void b(int paramInt, Object paramObject, String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.navigatebar.TroopAioMsgNavigateSpecial
 * JD-Core Version:    0.7.0.1
 */