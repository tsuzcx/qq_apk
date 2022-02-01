package com.tencent.mobileqq.reminder.api.impl;

import Wallet.AcsMsg;
import com.tencent.mobileqq.reminder.OnDeleteReminderFailListener;
import com.tencent.mobileqq.reminder.biz.entity.ReminderEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

class QQReminderDataServiceImpl$6
  implements Runnable
{
  QQReminderDataServiceImpl$6(QQReminderDataServiceImpl paramQQReminderDataServiceImpl, String paramString, OnDeleteReminderFailListener paramOnDeleteReminderFailListener) {}
  
  public void run()
  {
    if (!QQReminderDataServiceImpl.access$900(this.this$0).containsKey(this.jdField_a_of_type_JavaLangString)) {
      return;
    }
    Object localObject = ((ReminderEntity)QQReminderDataServiceImpl.access$900(this.this$0).get(this.jdField_a_of_type_JavaLangString)).getAcsMsg();
    if (QQReminderDataServiceImpl.access$1000(this.this$0, this.jdField_a_of_type_JavaLangString, (AcsMsg)localObject))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReminderDataManagerNew", 1, new Object[] { "deleteReminderByMsgId MsgId: ", this.jdField_a_of_type_JavaLangString, " success, remove reminder..." });
      }
      QQReminderDataServiceImpl.access$1100(this.this$0, (AcsMsg)localObject);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReminderDataManagerNew", 1, new Object[] { "deleteReminderByMsgId MsgId: ", this.jdField_a_of_type_JavaLangString, " failed!!" });
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqReminderOnDeleteReminderFailListener;
    if (localObject != null) {
      ((OnDeleteReminderFailListener)localObject).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.reminder.api.impl.QQReminderDataServiceImpl.6
 * JD-Core Version:    0.7.0.1
 */