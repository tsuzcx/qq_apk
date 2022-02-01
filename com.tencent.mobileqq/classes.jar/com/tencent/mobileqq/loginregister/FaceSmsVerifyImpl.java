package com.tencent.mobileqq.loginregister;

import android.content.Intent;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.servlet.LoginVerifyServlet;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class FaceSmsVerifyImpl
  implements IAuthDevVerifyApi
{
  private String a;
  private FaceSmsVerifyImpl.FaceSmsVerifyObserver b;
  
  private void d(QBaseActivity paramQBaseActivity, ICommonSmsView paramICommonSmsView)
  {
    if (this.b == null) {
      this.b = new FaceSmsVerifyImpl.FaceSmsVerifyObserver(paramQBaseActivity, paramICommonSmsView);
    }
  }
  
  public void a()
  {
    if ("f_SetFaceData".equals(this.a)) {
      ReportController.b(null, "dc00898", "", "", "0X800A856", "0X800A856", 0, 0, "", "", "", "");
    }
  }
  
  public void a(QBaseActivity paramQBaseActivity, int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 21)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onActivity requestCode == AuthDevActivity.REQ_LEGACY, resultCode is : ");
      localStringBuilder.append(paramInt2);
      QLog.d("FaceSmsVerifyImpl", 1, localStringBuilder.toString());
      paramQBaseActivity.setResult(paramInt2, paramIntent);
      paramQBaseActivity.finish();
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
    this.a = localIntent.getStringExtra("keyFrom");
    d(paramQBaseActivity, paramICommonSmsView);
  }
  
  public boolean a(QBaseActivity paramQBaseActivity, ICommonSmsView paramICommonSmsView, String paramString)
  {
    if (!"f_SetFaceData".equals(this.a)) {
      return false;
    }
    QLog.d("FaceSmsVerifyImpl", 2, new Object[] { "checkSms, smsCode : ", paramString });
    LoginVerifyServlet.b(paramQBaseActivity.getAppRuntime(), paramString, this.b);
    ReportController.b(null, "dc00898", "", "", "0X800A31C", "0X800A31C", 0, 0, "", "", "", "");
    return true;
  }
  
  public void b() {}
  
  public boolean b(QBaseActivity paramQBaseActivity, ICommonSmsView paramICommonSmsView)
  {
    if (!"f_SetFaceData".equals(this.a)) {
      return false;
    }
    paramICommonSmsView.startTimer(60);
    return true;
  }
  
  public boolean c(QBaseActivity paramQBaseActivity, ICommonSmsView paramICommonSmsView)
  {
    if (!"f_SetFaceData".equals(this.a)) {
      return false;
    }
    d(paramQBaseActivity, paramICommonSmsView);
    QLog.d("FaceSmsVerifyImpl", 1, "Set Face Data startGetVerifyCode.begin");
    LoginVerifyServlet.a(paramQBaseActivity.getAppRuntime(), this.b);
    ReportController.b(null, "dc00898", "", "", "0X800A857", "0X800A857", 0, 0, "", "", "", "");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.loginregister.FaceSmsVerifyImpl
 * JD-Core Version:    0.7.0.1
 */