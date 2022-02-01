package com.tencent.mobileqq.flutter.channel.expand.chat;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.matchchat.RecentMatchChatListItem;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class ExpandChatRepository$2$1
  implements Runnable
{
  ExpandChatRepository$2$1(ExpandChatRepository.2 param2, String paramString) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("expand.chat.ExpandChatRepository", 2, "onUpdateFriendInfo uin =" + this.jdField_a_of_type_JavaLangString);
    }
    RecentMatchChatListItem localRecentMatchChatListItem = (RecentMatchChatListItem)ExpandChatRepository.a(this.jdField_a_of_type_ComTencentMobileqqFlutterChannelExpandChatExpandChatRepository$2.a).get(this.jdField_a_of_type_JavaLangString);
    if (localRecentMatchChatListItem != null)
    {
      localRecentMatchChatListItem.mTitleName = ContactUtils.c(ExpandChatRepository.a(this.jdField_a_of_type_ComTencentMobileqqFlutterChannelExpandChatExpandChatRepository$2.a), localRecentMatchChatListItem.messageRecord.senderuin, true);
      ExpandChatRepository.a(this.jdField_a_of_type_ComTencentMobileqqFlutterChannelExpandChatExpandChatRepository$2.a, this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.channel.expand.chat.ExpandChatRepository.2.1
 * JD-Core Version:    0.7.0.1
 */