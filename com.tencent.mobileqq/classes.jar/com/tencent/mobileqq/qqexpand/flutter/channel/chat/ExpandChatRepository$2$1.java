package com.tencent.mobileqq.qqexpand.flutter.channel.chat;

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
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onUpdateFriendInfo uin =");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      QLog.d("expand.chat.ExpandChatRepository", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (RecentMatchChatListItem)ExpandChatRepository.a(this.jdField_a_of_type_ComTencentMobileqqQqexpandFlutterChannelChatExpandChatRepository$2.a).get(this.jdField_a_of_type_JavaLangString);
    if (localObject != null)
    {
      ((RecentMatchChatListItem)localObject).mTitleName = ContactUtils.a(ExpandChatRepository.a(this.jdField_a_of_type_ComTencentMobileqqQqexpandFlutterChannelChatExpandChatRepository$2.a), ((RecentMatchChatListItem)localObject).messageRecord.senderuin, true);
      ExpandChatRepository.a(this.jdField_a_of_type_ComTencentMobileqqQqexpandFlutterChannelChatExpandChatRepository$2.a, this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.flutter.channel.chat.ExpandChatRepository.2.1
 * JD-Core Version:    0.7.0.1
 */