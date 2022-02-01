package com.tencent.mobileqq.loginwelcome;

import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.qphone.base.util.QLog;

class LoginWelcomeManager$9
  implements URLDrawable.URLDrawableListener
{
  LoginWelcomeManager$9(LoginWelcomeManager paramLoginWelcomeManager) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, "tryToShowCGLayer drawable onLoadSuccessed");
    }
    if (this.a.a != null) {
      this.a.a.a(paramURLDrawable);
    }
    this.a.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.loginwelcome.LoginWelcomeManager.9
 * JD-Core Version:    0.7.0.1
 */