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
  private boolean a;
  private String b;
  private WtloginObserver c;
  
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
    this.a = localIntent.getBooleanExtra("from_login", false);
    this.b = localIntent.getStringExtra("keyFrom");
    this.c = new DefaultSmsImpl.OpenDevLockObserver(paramQBaseActivity, paramICommonSmsView);
  }
  
  public boolean a(QBaseActivity paramQBaseActivity, ICommonSmsView paramICommonSmsView, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("checkSms smsCode=");
    localStringBuilder.append(paramString);
    QLog.d("DefaultSmsImpl", 1, localStringBuilder.toString());
    if (!"f_SetFaceData".equals(this.b))
    {
      if (this.a) {
        return false;
      }
      int i = EquipmentLockImpl.a().a(paramQBaseActivity.getAppRuntime(), paramQBaseActivity.getCurrentAccountUinFromRuntime(), paramString, null, this.c);
      if (i == 0)
      {
        paramICommonSmsView.showLoadingDialog();
        return true;
      }
      paramICommonSmsView = new StringBuilder();
      paramICommonSmsView.append("checkSms failed ret=");
      paramICommonSmsView.append(i);
      QLog.d("DefaultSmsImpl", 1, paramICommonSmsView.toString());
      QQToast.makeText(paramQBaseActivity, 1, 2131914114, 0).show();
      return true;
    }
    return false;
  }
  
  public void b() {}
  
  public boolean b(QBaseActivity paramQBaseActivity, ICommonSmsView paramICommonSmsView)
  {
    if ((!"f_SetFaceData".equals(this.b)) && (!this.a))
    {
      QLog.d("DefaultSmsImpl", 1, "sendSms : AskDevLockSms");
      int i = EquipmentLockImpl.a().c(paramQBaseActivity.getAppRuntime(), paramQBaseActivity.getCurrentAccountUinFromRuntime(), this.c);
      if (i == 0)
      {
        paramICommonSmsView.showLoadingDialog();
        return true;
      }
      paramQBaseActivity = new StringBuilder();
      paramQBaseActivity.append("sendSms failed ret=");
      paramQBaseActivity.append(i);
      QLog.d("DefaultSmsImpl", 1, paramQBaseActivity.toString());
      return true;
    }
    return false;
  }
  
  public boolean c(QBaseActivity paramQBaseActivity, ICommonSmsView paramICommonSmsView)
  {
    return b(paramQBaseActivity, paramICommonSmsView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.loginregister.DefaultSmsImpl
 * JD-Core Version:    0.7.0.1
 */