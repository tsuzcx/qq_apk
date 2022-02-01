package com.tencent.mobileqq.contactsync;

import com.tencent.qphone.base.util.QLog;

class ContactSyncManager$2
  implements Runnable
{
  ContactSyncManager$2(ContactSyncManager paramContactSyncManager, int paramInt) {}
  
  public void run()
  {
    try
    {
      this.this$0.a(this.a);
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ContactSync.Manager", 2, "onQQContactRefreshed | syncAllContacts exception", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.contactsync.ContactSyncManager.2
 * JD-Core Version:    0.7.0.1
 */