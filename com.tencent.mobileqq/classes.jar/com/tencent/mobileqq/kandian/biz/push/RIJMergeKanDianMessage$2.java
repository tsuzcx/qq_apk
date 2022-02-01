package com.tencent.mobileqq.kandian.biz.push;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

final class RIJMergeKanDianMessage$2
  implements Runnable
{
  RIJMergeKanDianMessage$2(String paramString, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    Object localObject = new SessionInfo();
    ((SessionInfo)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    ((SessionInfo)localObject).jdField_a_of_type_Int = 1008;
    ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (BaseSessionInfo)localObject);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.jdField_a_of_type_JavaLangString, 1008);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("puin<");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject).append("> msg setRead !");
    QLog.d("RIJMergeKanDianMessage", 2, ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.push.RIJMergeKanDianMessage.2
 * JD-Core Version:    0.7.0.1
 */