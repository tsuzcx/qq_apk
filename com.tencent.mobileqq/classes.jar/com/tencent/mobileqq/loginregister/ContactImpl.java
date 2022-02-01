package com.tencent.mobileqq.loginregister;

import android.content.Intent;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.phonecontact.handler.ContactBindServlet;
import com.tencent.mobileqq.phonecontact.observer.ContactBindObserver;
import com.tencent.mobileqq.util.BusinessUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.app.AppRuntime;
import mqq.observer.BusinessObserver;

public class ContactImpl
  implements IContactInterface
{
  private QBaseActivity jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
  private ContactBindObserver jdField_a_of_type_ComTencentMobileqqPhonecontactObserverContactBindObserver;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private String b;
  private String c;
  
  private ContactBindObserver a(IRegisterView paramIRegisterView)
  {
    return new ContactImpl.2(this, paramIRegisterView);
  }
  
  public BusinessObserver a(IRegisterView paramIRegisterView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPhonecontactObserverContactBindObserver == null) {
      this.jdField_a_of_type_ComTencentMobileqqPhonecontactObserverContactBindObserver = a(paramIRegisterView);
    }
    return this.jdField_a_of_type_ComTencentMobileqqPhonecontactObserverContactBindObserver;
  }
  
  public void a(QBaseActivity paramQBaseActivity, Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity = paramQBaseActivity;
    this.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("phonenum");
    this.b = paramIntent.getStringExtra("key");
    this.jdField_a_of_type_ArrayOfByte = paramIntent.getByteArrayExtra("key_register_sign");
    this.c = paramIntent.getStringExtra("uin");
  }
  
  public void a(AppRuntime paramAppRuntime)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      ThreadManager.executeOnNetWorkThread(new ContactImpl.1(this, paramAppRuntime));
      QQToast.a(BaseApplication.getContext(), HardCodeUtil.a(2131701059), 0).a();
    }
  }
  
  public void a(AppRuntime paramAppRuntime, String paramString)
  {
    BusinessUtils.a(paramAppRuntime, paramString);
  }
  
  public void a(AppRuntime paramAppRuntime, byte[] paramArrayOfByte, String paramString)
  {
    ContactBindServlet.a(paramAppRuntime, this.jdField_a_of_type_ArrayOfByte, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.loginregister.ContactImpl
 * JD-Core Version:    0.7.0.1
 */