package com.tencent.mobileqq.phonecontact.api.impl;

import SecurityAccountServer.RespondQueryQQBindingStat;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.phonecontact.observer.ContactBindObserver;
import com.tencent.mobileqq.phonecontact.util.ContactSyncUtils;
import com.tencent.qphone.base.util.QLog;

class ContactSyncServiceImpl$1
  extends ContactBindObserver
{
  ContactSyncServiceImpl$1(ContactSyncServiceImpl paramContactSyncServiceImpl) {}
  
  protected void onQueryBindState(boolean paramBoolean1, boolean paramBoolean2)
  {
    PhoneContactServiceImpl localPhoneContactServiceImpl = PhoneContactServiceImpl.getService(ContactSyncServiceImpl.access$000(this.a));
    int i = localPhoneContactServiceImpl.getSelfBindState();
    String str1 = ContactSyncServiceImpl.access$000(this.a).getCurrentAccountUin();
    String str2 = this.a.getSyncAccountUin();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onQueryBindState | state = ");
      localStringBuilder.append(i);
      localStringBuilder.append(" | syncUin = ");
      localStringBuilder.append(ContactSyncUtils.a(str2));
      localStringBuilder.append(" | currentUin = ");
      localStringBuilder.append(ContactSyncUtils.a(str1));
      QLog.d("ContactSync.Manager", 2, localStringBuilder.toString());
    }
    if (localPhoneContactServiceImpl.isBindContactOk())
    {
      if (TextUtils.isEmpty(str2))
      {
        ContactSyncServiceImpl.access$100(this.a).removeCallbacksAndMessages(null);
        ContactSyncServiceImpl.access$100(this.a).sendEmptyMessage(1);
        return;
      }
      if (!str1.equals(str2))
      {
        ContactSyncServiceImpl.access$100(this.a).removeCallbacksAndMessages(null);
        ContactSyncServiceImpl.access$100(this.a).sendEmptyMessage(2);
        ContactSyncServiceImpl.access$100(this.a).sendEmptyMessage(1);
      }
    }
    else if ((i == 5) || (i == 1) || ((i == 6) && (localPhoneContactServiceImpl.getSelfBindInfo() != null) && (localPhoneContactServiceImpl.getSelfBindInfo().lastUsedFlag == 3L)) || ((i == 7) && (localPhoneContactServiceImpl.getSelfBindInfo() != null) && (localPhoneContactServiceImpl.getSelfBindInfo().isStopFindMatch)))
    {
      if ((i == 5) || (i == 1)) {
        ThreadManager.excute(new ContactSyncServiceImpl.1.1(this), 16, null, false);
      }
      if ((!TextUtils.isEmpty(str2)) && (str2.equals(ContactSyncServiceImpl.access$000(this.a).getCurrentAccountUin())))
      {
        ContactSyncServiceImpl.access$100(this.a).removeCallbacksAndMessages(null);
        ContactSyncServiceImpl.access$100(this.a).sendEmptyMessage(2);
      }
    }
  }
  
  protected void onQueryContactList(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onQueryContactList | isSuccess = ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" | updateFlag = ");
      localStringBuilder.append(paramInt);
      QLog.d("ContactSync.Manager", 2, localStringBuilder.toString());
    }
    this.a.onQQContactRefreshed(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.phonecontact.api.impl.ContactSyncServiceImpl.1
 * JD-Core Version:    0.7.0.1
 */