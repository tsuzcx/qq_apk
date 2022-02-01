package com.tencent.mobileqq.phonecontact.api.impl;

import com.tencent.mobileqq.phonecontact.observer.ContactBindObserver2;
import com.tencent.qphone.base.util.QLog;

class PhoneContactServiceImpl$21
  extends ContactBindObserver2
{
  PhoneContactServiceImpl$21(PhoneContactServiceImpl paramPhoneContactServiceImpl) {}
  
  protected void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IMCore.PhoneContact.PhoneContactServiceImpl", 2, String.format("onQueryShowBindPhonePage result=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    if (paramBoolean)
    {
      PhoneContactServiceImpl localPhoneContactServiceImpl = this.a;
      paramBoolean = PhoneContactServiceImpl.access$4000(localPhoneContactServiceImpl, PhoneContactServiceImpl.access$3900(localPhoneContactServiceImpl));
      PhoneContactServiceImpl.access$4100(this.a, paramBoolean);
    }
  }
  
  protected void c(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IMCore.PhoneContact.PhoneContactServiceImpl", 2, String.format("onSetShowBindPhonePageResult result=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.phonecontact.api.impl.PhoneContactServiceImpl.21
 * JD-Core Version:    0.7.0.1
 */