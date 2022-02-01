package com.tencent.mobileqq.loginregister;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.VerifyPhoneNumActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.qphone.base.util.QLog;

class ContactImpl$2
  extends ContactBindObserver
{
  ContactImpl$2(ContactImpl paramContactImpl, IRegisterView paramIRegisterView) {}
  
  public void onGetBindUinWithPhone(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactImpl", 2, "RegisterQQNumberActivity onGetBindUinWithPhone isSuccess = " + paramBoolean1 + "; isBindOk = " + paramBoolean2 + ";hadbind = " + paramBoolean3 + ";uin =" + paramString);
    }
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        ContactImpl.a(this.jdField_a_of_type_ComTencentMobileqqLoginregisterContactImpl, true);
        this.jdField_a_of_type_ComTencentMobileqqLoginregisterIRegisterView.h();
      }
      do
      {
        return;
        if ((!paramBoolean3) || (TextUtils.isEmpty(paramString))) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqLoginregisterIRegisterView.i();
      } while (ContactImpl.a(this.jdField_a_of_type_ComTencentMobileqqLoginregisterContactImpl) == null);
      Intent localIntent = new Intent(ContactImpl.a(this.jdField_a_of_type_ComTencentMobileqqLoginregisterContactImpl), VerifyPhoneNumActivity.class);
      localIntent.putExtra("phonenum", ContactImpl.a(this.jdField_a_of_type_ComTencentMobileqqLoginregisterContactImpl));
      localIntent.putExtra("key", ContactImpl.b(this.jdField_a_of_type_ComTencentMobileqqLoginregisterContactImpl));
      localIntent.putExtra("uin", ContactImpl.c(this.jdField_a_of_type_ComTencentMobileqqLoginregisterContactImpl));
      localIntent.putExtra("key_register_sign", ContactImpl.a(this.jdField_a_of_type_ComTencentMobileqqLoginregisterContactImpl));
      localIntent.putExtra("key_register_binduin", paramString);
      ContactImpl.a(this.jdField_a_of_type_ComTencentMobileqqLoginregisterContactImpl).startActivity(localIntent);
      ContactImpl.a(this.jdField_a_of_type_ComTencentMobileqqLoginregisterContactImpl).finish();
      return;
      this.jdField_a_of_type_ComTencentMobileqqLoginregisterIRegisterView.h();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqLoginregisterIRegisterView.h();
  }
  
  public void onUploadContact(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactImpl", 2, "onUploadContact  isSuccess = " + paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.loginregister.ContactImpl.2
 * JD-Core Version:    0.7.0.1
 */