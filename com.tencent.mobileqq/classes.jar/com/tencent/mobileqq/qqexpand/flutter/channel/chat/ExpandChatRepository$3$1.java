package com.tencent.mobileqq.qqexpand.flutter.channel.chat;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.qqexpand.chat.ILimitChatUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

class ExpandChatRepository$3$1
  implements Runnable
{
  ExpandChatRepository$3$1(ExpandChatRepository.3 param3, Object paramObject) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_JavaLangObject;
    if ((localObject instanceof MessageRecord))
    {
      localObject = (MessageRecord)localObject;
      if (!((ILimitChatUtils)QRoute.api(ILimitChatUtils.class)).isExtendMatchChatMsg((MessageRecord)localObject)) {
        return;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("MessageRecord uin =");
        localStringBuilder.append(((MessageRecord)localObject).senderuin);
        QLog.d("expand.chat.ExpandChatRepository", 2, localStringBuilder.toString());
      }
      if ((!TextUtils.isEmpty(((MessageRecord)localObject).senderuin)) && (!((MessageRecord)localObject).senderuin.equals(ExpandChatRepository.a(this.jdField_a_of_type_ComTencentMobileqqQqexpandFlutterChannelChatExpandChatRepository$3.a).getCurrentAccountUin()))) {
        ExpandChatRepository.a(this.jdField_a_of_type_ComTencentMobileqqQqexpandFlutterChannelChatExpandChatRepository$3.a, true);
      }
      ExpandChatRepository.a(this.jdField_a_of_type_ComTencentMobileqqQqexpandFlutterChannelChatExpandChatRepository$3.a);
      return;
    }
    if (((localObject instanceof RecentUser)) && (ExpandChatRepository.a(this.jdField_a_of_type_ComTencentMobileqqQqexpandFlutterChannelChatExpandChatRepository$3.a)))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("RecentUser uin =");
        ((StringBuilder)localObject).append(((RecentUser)this.jdField_a_of_type_JavaLangObject).uin);
        QLog.d("expand.chat.ExpandChatRepository", 2, ((StringBuilder)localObject).toString());
      }
      ExpandChatRepository.a(this.jdField_a_of_type_ComTencentMobileqqQqexpandFlutterChannelChatExpandChatRepository$3.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.flutter.channel.chat.ExpandChatRepository.3.1
 * JD-Core Version:    0.7.0.1
 */