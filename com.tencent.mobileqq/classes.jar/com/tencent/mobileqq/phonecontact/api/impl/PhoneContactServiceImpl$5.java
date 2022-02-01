package com.tencent.mobileqq.phonecontact.api.impl;

import com.tencent.qphone.base.util.QLog;

class PhoneContactServiceImpl$5
  implements Runnable
{
  PhoneContactServiceImpl$5(PhoneContactServiceImpl paramPhoneContactServiceImpl, boolean paramBoolean1, boolean paramBoolean2, int paramInt) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("IMCore.PhoneContact.PhoneContactServiceImpl", 2, String.format("checkUpdateBindStateAndListIgnoreBindState [forced:%s, isQueryAll:%s, from:%s]", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean), Boolean.valueOf(this.b), Integer.valueOf(this.jdField_a_of_type_Int) }));
    }
    PhoneContactServiceImpl.access$2300(this.this$0, this.jdField_a_of_type_Boolean, this.b, this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.phonecontact.api.impl.PhoneContactServiceImpl.5
 * JD-Core Version:    0.7.0.1
 */