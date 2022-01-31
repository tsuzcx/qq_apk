package com.tencent.mobileqq.structmsg;

import agcx;
import azqs;
import azvk;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.portal.PortalManager;
import com.tencent.qphone.base.util.QLog;

public class StructMsgForGeneralShare$5$2
  implements Runnable
{
  public StructMsgForGeneralShare$5$2(azvk paramazvk, agcx paramagcx, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    int i = 1;
    if (QLog.isDevelopLevel()) {
      QLog.d("PortalManager", 4, "qiang hong bao lala ......struct msg getView report.........");
    }
    String str2 = "";
    String str1;
    if ((this.jdField_a_of_type_Agcx.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_Agcx.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null)) {
      if (this.jdField_a_of_type_Agcx.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
      {
        str1 = this.jdField_a_of_type_Agcx.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
        str2 = this.jdField_a_of_type_Agcx.jdField_a_of_type_ComTencentMobileqqDataChatMessage.senderuin;
      }
    }
    for (;;)
    {
      PortalManager localPortalManager = (PortalManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(79);
      if (localPortalManager != null) {}
      for (int j = localPortalManager.a();; j = -1)
      {
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004FFA", "0X8004FFA", 0, 0, "" + j, "" + i, "" + str1, str2);
        return;
        i = 2;
        break;
      }
      str1 = "";
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgForGeneralShare.5.2
 * JD-Core Version:    0.7.0.1
 */