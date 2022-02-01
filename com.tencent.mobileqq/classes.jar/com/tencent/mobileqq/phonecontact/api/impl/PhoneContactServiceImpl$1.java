package com.tencent.mobileqq.phonecontact.api.impl;

import android.content.SharedPreferences;
import com.tencent.mobileqq.phonecontact.permission.PermissionChecker;

class PhoneContactServiceImpl$1
  implements Runnable
{
  PhoneContactServiceImpl$1(PhoneContactServiceImpl paramPhoneContactServiceImpl) {}
  
  public void run()
  {
    PhoneContactServiceImpl localPhoneContactServiceImpl = this.this$0;
    PhoneContactServiceImpl.access$002(localPhoneContactServiceImpl, localPhoneContactServiceImpl.getUNIQUE_NO());
    PhoneContactServiceImpl.access$100(this.this$0);
    localPhoneContactServiceImpl = this.this$0;
    localPhoneContactServiceImpl.mUIBits = PhoneContactServiceImpl.access$200(localPhoneContactServiceImpl).getLong("key_contacts_switches", 0L);
    if (PhoneContactServiceImpl.access$300(this.this$0) != null) {
      ContactSyncServiceImpl.getService(PhoneContactServiceImpl.access$300(this.this$0));
    }
    PermissionChecker.a().e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.phonecontact.api.impl.PhoneContactServiceImpl.1
 * JD-Core Version:    0.7.0.1
 */