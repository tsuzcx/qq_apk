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
      ((StringBuilder)localObject).append(this.a);
      QLog.d("expand.chat.ExpandChatRepository", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (RecentMatchChatListItem)ExpandChatRepository.c(this.b.a).get(this.a);
    if (localObject != null)
    {
      ((RecentMatchChatListItem)localObject).mTitleName = ContactUtils.a(ExpandChatRepository.d(this.b.a), ((RecentMatchChatListItem)localObject).messageRecord.senderuin, true);
      ExpandChatRepository.a(this.b.a, this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.flutter.channel.chat.ExpandChatRepository.2.1
 * JD-Core Version:    0.7.0.1
 */