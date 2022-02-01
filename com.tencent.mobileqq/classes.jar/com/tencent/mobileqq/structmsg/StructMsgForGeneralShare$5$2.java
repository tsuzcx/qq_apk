package com.tencent.mobileqq.structmsg;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.StructingMsgViewHolder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.portal.PortalManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

class StructMsgForGeneralShare$5$2
  implements Runnable
{
  StructMsgForGeneralShare$5$2(StructMsgForGeneralShare.5 param5, StructingMsgItemBuilder.StructingMsgViewHolder paramStructingMsgViewHolder, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("PortalManager", 4, "qiang hong bao lala ......struct msg getView report.........");
    }
    int i = 0;
    String str1;
    String str2;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder$StructingMsgViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder$StructingMsgViewHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder$StructingMsgViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
        i = 1;
      } else {
        i = 2;
      }
      str1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder$StructingMsgViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      str2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder$StructingMsgViewHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.senderuin;
    }
    else
    {
      str1 = "";
      str2 = str1;
    }
    Object localObject1 = (PortalManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_PORTAL);
    int j = -1;
    if (localObject1 != null) {
      j = ((PortalManager)localObject1).a();
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject2).append(j);
    localObject2 = ((StringBuilder)localObject2).toString();
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("");
    ((StringBuilder)localObject3).append(i);
    localObject3 = ((StringBuilder)localObject3).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(str1);
    ReportController.b((AppRuntime)localObject1, "CliOper", "", "", "0X8004FFA", "0X8004FFA", 0, 0, (String)localObject2, (String)localObject3, localStringBuilder.toString(), str2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgForGeneralShare.5.2
 * JD-Core Version:    0.7.0.1
 */