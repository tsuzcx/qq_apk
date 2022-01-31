package com.tencent.mobileqq.loginwelcome;

import android.app.Activity;
import atvm;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class LoginUserGuideHelper$GuideRunnable
  implements Runnable
{
  private final atvm jdField_a_of_type_Atvm;
  private final WeakReference<Activity> jdField_a_of_type_JavaLangRefWeakReference;
  private final boolean jdField_a_of_type_Boolean;
  private final WeakReference<QQAppInterface> b;
  
  public LoginUserGuideHelper$GuideRunnable(Activity paramActivity, QQAppInterface paramQQAppInterface, boolean paramBoolean, atvm paramatvm)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    this.b = new WeakReference(paramQQAppInterface);
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Atvm = paramatvm;
  }
  
  public void run()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.b.get();
    Activity localActivity = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((localQQAppInterface == null) || (localActivity == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("LoginUserGuideHelper", 2, "GuideRunnable : " + this.jdField_a_of_type_Boolean);
    }
    if (this.jdField_a_of_type_Boolean) {
      ThreadManager.excute(new LoginUserGuideHelper.GuideRunnable.1(this, localQQAppInterface), 16, null, false);
    }
    LoginUserGuideHelper.a(localActivity, localQQAppInterface, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Atvm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.loginwelcome.LoginUserGuideHelper.GuideRunnable
 * JD-Core Version:    0.7.0.1
 */