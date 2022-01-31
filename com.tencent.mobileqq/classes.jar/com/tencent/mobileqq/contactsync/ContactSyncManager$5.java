package com.tencent.mobileqq.contactsync;

import android.accounts.Account;
import android.accounts.AccountManager;
import apac;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.locks.Lock;

public class ContactSyncManager$5
  implements Runnable
{
  public ContactSyncManager$5(apac paramapac, Account[] paramArrayOfAccount) {}
  
  public void run()
  {
    apac.a(this.this$0).lock();
    int i = 1;
    try
    {
      while (i < this.a.length)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ContactSync.Manager", 2, "initSyncAccount | delAccount = " + this.a[i]);
        }
        apac.a(this.this$0).removeAccount(this.a[i], null, null);
        i += 1;
      }
      return;
    }
    catch (Throwable localThrowable) {}finally
    {
      apac.a(this.this$0).unlock();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.contactsync.ContactSyncManager.5
 * JD-Core Version:    0.7.0.1
 */