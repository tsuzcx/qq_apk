package com.tencent.mobileqq.data;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.handler.TroopMemberInfoHandler;
import java.lang.ref.WeakReference;

class MessageForQQWalletTips$1$1
  implements Runnable
{
  MessageForQQWalletTips$1$1(MessageForQQWalletTips.1 param1, String paramString) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletTips$1.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localQQAppInterface == null) {
      return;
    }
    ((TroopMemberInfoHandler)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_MEMBER_INFO_HANDLER)).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletTips$1.jdField_a_of_type_JavaLangString), Long.parseLong(this.jdField_a_of_type_JavaLangString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForQQWalletTips.1.1
 * JD-Core Version:    0.7.0.1
 */