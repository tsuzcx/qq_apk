package com.tencent.mobileqq.flutter.channel.expand.chat;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.limitchat.LimitChatUtil;
import com.tencent.qphone.base.util.QLog;

class ExpandChatRepository$1$1
  implements Runnable
{
  ExpandChatRepository$1$1(ExpandChatRepository.1 param1, Object paramObject) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_JavaLangObject instanceof MessageRecord))
    {
      localMessageRecord = (MessageRecord)this.jdField_a_of_type_JavaLangObject;
      if (LimitChatUtil.a(localMessageRecord)) {}
    }
    while ((!(this.jdField_a_of_type_JavaLangObject instanceof RecentUser)) || (!ExpandChatRepository.a(this.jdField_a_of_type_ComTencentMobileqqFlutterChannelExpandChatExpandChatRepository$1.a)))
    {
      MessageRecord localMessageRecord;
      return;
      if (QLog.isColorLevel()) {
        QLog.d("expand.chat.ExpandChatRepository", 2, "MessageRecord uin =" + localMessageRecord.senderuin);
      }
      if ((!TextUtils.isEmpty(localMessageRecord.senderuin)) && (!localMessageRecord.senderuin.equals(ExpandChatRepository.a(this.jdField_a_of_type_ComTencentMobileqqFlutterChannelExpandChatExpandChatRepository$1.a).getCurrentAccountUin()))) {
        ExpandChatRepository.a(this.jdField_a_of_type_ComTencentMobileqqFlutterChannelExpandChatExpandChatRepository$1.a, true);
      }
      ExpandChatRepository.a(this.jdField_a_of_type_ComTencentMobileqqFlutterChannelExpandChatExpandChatRepository$1.a);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("expand.chat.ExpandChatRepository", 2, "RecentUser uin =" + ((RecentUser)this.jdField_a_of_type_JavaLangObject).uin);
    }
    ExpandChatRepository.a(this.jdField_a_of_type_ComTencentMobileqqFlutterChannelExpandChatExpandChatRepository$1.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.channel.expand.chat.ExpandChatRepository.1.1
 * JD-Core Version:    0.7.0.1
 */