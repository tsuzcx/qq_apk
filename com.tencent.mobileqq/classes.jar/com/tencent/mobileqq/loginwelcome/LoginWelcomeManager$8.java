package com.tencent.mobileqq.loginwelcome;

import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;

class LoginWelcomeManager$8
  implements URLDrawable.URLDrawableListener
{
  LoginWelcomeManager$8(LoginWelcomeManager paramLoginWelcomeManager, LoginWelcomeManager.ContactsGuideRecenUserObj paramContactsGuideRecenUserObj, RecentUser paramRecentUser) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, "tryShowCGRU drawable onLoadSuccessed");
    }
    this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginWelcomeManager$ContactsGuideRecenUserObj.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginWelcomeManager$ContactsGuideRecenUserObj.jdField_a_of_type_ComTencentImageURLDrawable = paramURLDrawable;
    this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginWelcomeManager$ContactsGuideRecenUserObj.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(null);
    LoginWelcomeManager.a(this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginWelcomeManager, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.loginwelcome.LoginWelcomeManager.8
 * JD-Core Version:    0.7.0.1
 */