package com.tencent.mobileqq.loginregister;

import android.content.Intent;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.WtloginObserver;

public class DefaultSmsImpl
  implements IAuthDevVerifyApi
{
  private String jdField_a_of_type_JavaLangString;
  private WtloginObserver jdField_a_of_type_MqqObserverWtloginObserver;
  private boolean jdField_a_of_type_Boolean;
  
  public void a() {}
  
  public void a(QBaseActivity paramQBaseActivity, int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(QBaseActivity paramQBaseActivity, ICommonSmsView paramICommonSmsView)
  {
    Intent localIntent = paramQBaseActivity.getIntent();
    if (localIntent == null)
    {
      QLog.d("DefaultSmsImpl", 1, "sendSms, intent is null");
      return;
    }
    this.jdField_a_of_type_Boolean = localIntent.getBooleanExtra("from_login", false);
    this.jdField_a_of_type_JavaLangString = localIntent.getStringExtra("keyFrom");
    this.jdField_a_of_type_MqqObserverWtloginObserver = new DefaultSmsImpl.OpenDevLockObserver(paramQBaseActivity, paramICommonSmsView);
  }
  
  public boolean a(QBaseActivity paramQBaseActivity, ICommonSmsView paramICommonSmsView)
  {
    if (("f_SetFaceData".equals(this.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_Boolean)) {
      return false;
    }
    QLog.d("DefaultSmsImpl", 1, "sendSms : AskDevLockSms");
    int i = EquipmentLockImpl.a().a(paramQBaseActivity.getAppRuntime(), paramQBaseActivity.getCurrentAccountUinFromRuntime(), this.jdField_a_of_type_MqqObserverWtloginObserver);
    if (i == 0)
    {
      paramICommonSmsView.showLoadingDialog();
      return true;
    }
    QLog.d("DefaultSmsImpl", 1, "sendSms failed ret=" + i);
    return true;
  }
  
  public boolean a(QBaseActivity paramQBaseActivity, ICommonSmsView paramICommonSmsView, String paramString)
  {
    QLog.d("DefaultSmsImpl", 1, "checkSms smsCode=" + paramString);
    if (("f_SetFaceData".equals(this.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_Boolean)) {
      return false;
    }
    int i = EquipmentLockImpl.a().a(paramQBaseActivity.getAppRuntime(), paramQBaseActivity.getCurrentAccountUinFromRuntime(), paramString, null, this.jdField_a_of_type_MqqObserverWtloginObserver);
    if (i == 0) {
      paramICommonSmsView.showLoadingDialog();
    }
    for (;;)
    {
      return true;
      QLog.d("DefaultSmsImpl", 1, "checkSms failed ret=" + i);
      QQToast.a(paramQBaseActivity, 1, 2131716998, 0).a();
    }
  }
  
  public void b() {}
  
  public boolean b(QBaseActivity paramQBaseActivity, ICommonSmsView paramICommonSmsView)
  {
    return a(paramQBaseActivity, paramICommonSmsView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.loginregister.DefaultSmsImpl
 * JD-Core Version:    0.7.0.1
 */