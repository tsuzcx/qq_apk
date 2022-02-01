package com.tencent.mobileqq.confess;

import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.QLog;

final class ConfessMsgUtil$1
  implements Runnable
{
  ConfessMsgUtil$1(ConfessManager paramConfessManager, String paramString, ConfessManager.GroupChatExtra paramGroupChatExtra, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqConfessConfessManager;
    String str = this.jdField_a_of_type_JavaLangString;
    ConfessManager.GroupChatExtra localGroupChatExtra = this.jdField_a_of_type_ComTencentMobileqqConfessConfessManager$GroupChatExtra;
    long l = this.jdField_a_of_type_Long;
    ((ConfessManager)localObject).a(str, localGroupChatExtra, l, l, this.b);
    if (QLog.isColorLevel())
    {
      l = MessageCache.a();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("decodeConfessMsgElem 1 strConfessorDesc:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqConfessConfessManager$GroupChatExtra.f);
      ((StringBuilder)localObject).append(" msgTime:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Long);
      ((StringBuilder)localObject).append(" msgSeq:");
      ((StringBuilder)localObject).append(this.b);
      ((StringBuilder)localObject).append(" nowTime");
      ((StringBuilder)localObject).append(l);
      QLog.i("ConfessMsgUtil", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.confess.ConfessMsgUtil.1
 * JD-Core Version:    0.7.0.1
 */