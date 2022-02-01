package com.tencent.mobileqq.phonecontact.api.impl;

import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import com.tencent.qphone.base.util.QLog;

class ContactSyncServiceImpl$5
  implements AccountManagerCallback<Boolean>
{
  ContactSyncServiceImpl$5(ContactSyncServiceImpl paramContactSyncServiceImpl) {}
  
  public void run(AccountManagerFuture<Boolean> paramAccountManagerFuture)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("removeSyncAccount | is done = ");
      localStringBuilder.append(paramAccountManagerFuture.isDone());
      QLog.d("ContactSync.Manager", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.phonecontact.api.impl.ContactSyncServiceImpl.5
 * JD-Core Version:    0.7.0.1
 */