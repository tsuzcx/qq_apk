package com.tencent.mobileqq.phonecontact.api.impl;

import com.tencent.qphone.base.util.QLog;

class PhoneContactServiceImpl$5
  implements Runnable
{
  PhoneContactServiceImpl$5(PhoneContactServiceImpl paramPhoneContactServiceImpl, boolean paramBoolean1, boolean paramBoolean2, int paramInt) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("IMCore.PhoneContact.PhoneContactServiceImpl", 2, String.format("checkUpdateBindStateAndListIgnoreBindState [forced:%s, isQueryAll:%s, from:%s]", new Object[] { Boolean.valueOf(this.a), Boolean.valueOf(this.b), Integer.valueOf(this.c) }));
    }
    PhoneContactServiceImpl.access$2300(this.this$0, this.a, this.b, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.phonecontact.api.impl.PhoneContactServiceImpl.5
 * JD-Core Version:    0.7.0.1
 */