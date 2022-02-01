package com.tencent.mobileqq.loginregister;

import android.content.Intent;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.servlet.LoginVerifyServlet;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class FaceSmsVerifyImpl
  implements IAuthDevVerifyApi
{
  private FaceSmsVerifyImpl.FaceSmsVerifyObserver jdField_a_of_type_ComTencentMobileqqLoginregisterFaceSmsVerifyImpl$FaceSmsVerifyObserver;
  private String jdField_a_of_type_JavaLangString;
  
  private void b(QBaseActivity paramQBaseActivity, ICommonSmsView paramICommonSmsView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqLoginregisterFaceSmsVerifyImpl$FaceSmsVerifyObserver == null) {
      this.jdField_a_of_type_ComTencentMobileqqLoginregisterFaceSmsVerifyImpl$FaceSmsVerifyObserver = new FaceSmsVerifyImpl.FaceSmsVerifyObserver(paramQBaseActivity, paramICommonSmsView);
    }
  }
  
  public void a()
  {
    if ("f_SetFaceData".equals(this.jdField_a_of_type_JavaLangString)) {
      ReportController.b(null, "dc00898", "", "", "0X800A856", "0X800A856", 0, 0, "", "", "", "");
    }
  }
  
  public void a(QBaseActivity paramQBaseActivity, int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 21)
    {
      QLog.d("FaceSmsVerifyImpl", 1, "onActivity requestCode == AuthDevActivity.REQ_LEGACY, resultCode is : " + paramInt2);
      if (paramInt2 == -1)
      {
        paramQBaseActivity.setResult(paramInt2, paramIntent);
        paramQBaseActivity.finish();
      }
    }
  }
  
  public void a(QBaseActivity paramQBaseActivity, ICommonSmsView paramICommonSmsView)
  {
    Intent localIntent = paramQBaseActivity.getIntent();
    if (localIntent == null)
    {
      QLog.d("FaceSmsVerifyImpl", 1, "sendSms, intent is null");
      return;
    }
    this.jdField_a_of_type_JavaLangString = localIntent.getStringExtra("keyFrom");
    b(paramQBaseActivity, paramICommonSmsView);
  }
  
  public boolean a(QBaseActivity paramQBaseActivity, ICommonSmsView paramICommonSmsView)
  {
    if (!"f_SetFaceData".equals(this.jdField_a_of_type_JavaLangString)) {
      return false;
    }
    paramICommonSmsView.startTimer(60);
    return true;
  }
  
  public boolean a(QBaseActivity paramQBaseActivity, ICommonSmsView paramICommonSmsView, String paramString)
  {
    if (!"f_SetFaceData".equals(this.jdField_a_of_type_JavaLangString)) {
      return false;
    }
    QLog.d("FaceSmsVerifyImpl", 2, new Object[] { "checkSms, smsCode : ", paramString });
    LoginVerifyServlet.a(paramQBaseActivity.getAppRuntime(), paramString, this.jdField_a_of_type_ComTencentMobileqqLoginregisterFaceSmsVerifyImpl$FaceSmsVerifyObserver);
    ReportController.b(null, "dc00898", "", "", "0X800A31C", "0X800A31C", 0, 0, "", "", "", "");
    return true;
  }
  
  public void b() {}
  
  public boolean b(QBaseActivity paramQBaseActivity, ICommonSmsView paramICommonSmsView)
  {
    if (!"f_SetFaceData".equals(this.jdField_a_of_type_JavaLangString)) {
      return false;
    }
    paramICommonSmsView.setTipsVisibility(4);
    b(paramQBaseActivity, paramICommonSmsView);
    QLog.d("FaceSmsVerifyImpl", 1, "Set Face Data startGetVerifyCode.begin");
    LoginVerifyServlet.a(paramQBaseActivity.getAppRuntime(), this.jdField_a_of_type_ComTencentMobileqqLoginregisterFaceSmsVerifyImpl$FaceSmsVerifyObserver);
    ReportController.b(null, "dc00898", "", "", "0X800A857", "0X800A857", 0, 0, "", "", "", "");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.loginregister.FaceSmsVerifyImpl
 * JD-Core Version:    0.7.0.1
 */