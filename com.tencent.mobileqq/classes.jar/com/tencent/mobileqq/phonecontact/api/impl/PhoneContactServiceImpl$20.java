package com.tencent.mobileqq.phonecontact.api.impl;

import com.tencent.mobileqq.phonecontact.permission.PermissionChecker;

class PhoneContactServiceImpl$20
  implements Runnable
{
  PhoneContactServiceImpl$20(PhoneContactServiceImpl paramPhoneContactServiceImpl, boolean paramBoolean) {}
  
  public void run()
  {
    if (PermissionChecker.a().e())
    {
      this.this$0.uploadOrUpdateContact();
      PhoneContactServiceImpl localPhoneContactServiceImpl = this.this$0;
      boolean bool;
      if (this.a) {
        bool = true;
      } else {
        bool = localPhoneContactServiceImpl.needUploadResultTip;
      }
      localPhoneContactServiceImpl.needUploadResultTip = bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.phonecontact.api.impl.PhoneContactServiceImpl.20
 * JD-Core Version:    0.7.0.1
 */