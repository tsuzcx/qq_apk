package com.tencent.mobileqq.limitchat;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.extendfriend.network.ExtendFriendHandler;

final class LimitChatUtil$3
  implements Runnable
{
  LimitChatUtil$3(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord) {}
  
  public void run()
  {
    ExtendFriendHandler localExtendFriendHandler = (ExtendFriendHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER);
    if (localExtendFriendHandler != null) {
      localExtendFriendHandler.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.limitchat.LimitChatUtil.3
 * JD-Core Version:    0.7.0.1
 */