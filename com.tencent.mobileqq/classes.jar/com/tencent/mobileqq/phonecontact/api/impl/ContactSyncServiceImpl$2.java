package com.tencent.mobileqq.phonecontact.api.impl;

import com.tencent.qphone.base.util.QLog;

class ContactSyncServiceImpl$2
  implements Runnable
{
  ContactSyncServiceImpl$2(ContactSyncServiceImpl paramContactSyncServiceImpl, int paramInt) {}
  
  public void run()
  {
    try
    {
      this.this$0.syncAllContacts(this.a);
      return;
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ContactSync.Manager", 2, "onQQContactRefreshed | syncAllContacts exception", localThrowable);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.phonecontact.api.impl.ContactSyncServiceImpl.2
 * JD-Core Version:    0.7.0.1
 */