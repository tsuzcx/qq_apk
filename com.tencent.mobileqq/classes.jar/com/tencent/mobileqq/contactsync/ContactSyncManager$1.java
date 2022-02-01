package com.tencent.mobileqq.contactsync;

import SecurityAccountServer.RespondQueryQQBindingStat;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.qphone.base.util.QLog;

class ContactSyncManager$1
  extends ContactBindObserver
{
  ContactSyncManager$1(ContactSyncManager paramContactSyncManager) {}
  
  public void onQueryBindState(boolean paramBoolean1, boolean paramBoolean2)
  {
    PhoneContactManager localPhoneContactManager = (PhoneContactManager)this.a.a.getManager(QQManagerFactory.CONTACT_MANAGER);
    int i = localPhoneContactManager.d();
    String str1 = this.a.a.getCurrentAccountUin();
    String str2 = this.a.a();
    if (QLog.isColorLevel()) {
      QLog.d("ContactSync.Manager", 2, "onQueryBindState | state = " + i + " | syncUin = " + ContactSyncManager.b(str2) + " | currentUin = " + ContactSyncManager.b(str1));
    }
    if (localPhoneContactManager.d()) {
      if (TextUtils.isEmpty(str2)) {
        ContactSyncManager.a(this.a).removeCallbacksAndMessages(null);
      }
    }
    do
    {
      do
      {
        ContactSyncManager.a(this.a).sendEmptyMessage(1);
        do
        {
          return;
        } while (str1.equals(str2));
        ContactSyncManager.a(this.a).removeCallbacksAndMessages(null);
        ContactSyncManager.a(this.a).sendEmptyMessage(2);
        ContactSyncManager.a(this.a).sendEmptyMessage(1);
        return;
      } while ((i != 5) && (i != 1) && ((i != 6) || (localPhoneContactManager.a() == null) || (localPhoneContactManager.a().lastUsedFlag != 3L)) && ((i != 7) || (localPhoneContactManager.a() == null) || (!localPhoneContactManager.a().isStopFindMatch)));
      if ((i == 5) || (i == 1)) {
        ThreadManager.excute(new ContactSyncManager.1.1(this), 16, null, false);
      }
    } while ((TextUtils.isEmpty(str2)) || (!str2.equals(this.a.a.getCurrentAccountUin())));
    ContactSyncManager.a(this.a).removeCallbacksAndMessages(null);
    ContactSyncManager.a(this.a).sendEmptyMessage(2);
  }
  
  public void onQueryContactList(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactSync.Manager", 2, "onQueryContactList | isSuccess = " + paramBoolean + " | updateFlag = " + paramInt);
    }
    this.a.b(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.contactsync.ContactSyncManager.1
 * JD-Core Version:    0.7.0.1
 */