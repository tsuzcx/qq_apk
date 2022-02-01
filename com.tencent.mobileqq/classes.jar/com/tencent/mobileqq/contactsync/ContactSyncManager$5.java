package com.tencent.mobileqq.contactsync;

import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import com.tencent.qphone.base.util.QLog;

class ContactSyncManager$5
  implements AccountManagerCallback<Boolean>
{
  ContactSyncManager$5(ContactSyncManager paramContactSyncManager) {}
  
  public void run(AccountManagerFuture<Boolean> paramAccountManagerFuture)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactSync.Manager", 2, "removeSyncAccount | is done = " + paramAccountManagerFuture.isDone());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.contactsync.ContactSyncManager.5
 * JD-Core Version:    0.7.0.1
 */