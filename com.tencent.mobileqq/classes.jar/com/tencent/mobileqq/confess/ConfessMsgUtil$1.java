package com.tencent.mobileqq.confess;

import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.QLog;

final class ConfessMsgUtil$1
  implements Runnable
{
  ConfessMsgUtil$1(ConfessManager paramConfessManager, String paramString, ConfessManager.GroupChatExtra paramGroupChatExtra, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqConfessConfessManager.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqConfessConfessManager$GroupChatExtra, this.jdField_a_of_type_Long, this.jdField_a_of_type_Long, this.b);
    if (QLog.isColorLevel())
    {
      long l = MessageCache.a();
      QLog.i("ConfessMsgUtil", 2, "decodeConfessMsgElem 1 strConfessorDesc:" + this.jdField_a_of_type_ComTencentMobileqqConfessConfessManager$GroupChatExtra.f + " msgTime:" + this.jdField_a_of_type_Long + " msgSeq:" + this.b + " nowTime" + l);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.confess.ConfessMsgUtil.1
 * JD-Core Version:    0.7.0.1
 */