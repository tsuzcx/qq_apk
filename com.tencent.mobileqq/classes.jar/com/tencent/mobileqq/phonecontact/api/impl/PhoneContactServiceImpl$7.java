package com.tencent.mobileqq.phonecontact.api.impl;

import com.tencent.mobileqq.phonecontact.util.ContactBindUtils;
import java.util.List;

class PhoneContactServiceImpl$7
  implements Runnable
{
  PhoneContactServiceImpl$7(PhoneContactServiceImpl paramPhoneContactServiceImpl, List paramList) {}
  
  public void run()
  {
    List localList = this.a;
    if ((localList != null) && (!localList.isEmpty()))
    {
      this.this$0.contactBindedDataCache = ContactBindUtils.a(this.a, null, true);
      return;
    }
    this.this$0.contactBindedDataCache = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.phonecontact.api.impl.PhoneContactServiceImpl.7
 * JD-Core Version:    0.7.0.1
 */