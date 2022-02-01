package com.tencent.mobileqq.loginregister;

import android.content.Intent;
import android.util.Base64;
import com.tencent.mobileqq.activity.QQIdentiferLegacyActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.observer.LoginVerifyObserver;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.servlet.LoginVerifyServlet;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;
import tencent.im.oidb.oidb_0x87a.RspBody;
import tencent.im.oidb.oidb_0x87c.RspBody;

class FaceSmsVerifyImpl$FaceSmsVerifyObserver
  extends LoginVerifyObserver
{
  private final WeakReference<QBaseActivity> a;
  private final WeakReference<ICommonSmsView> b;
  
  public FaceSmsVerifyImpl$FaceSmsVerifyObserver(QBaseActivity paramQBaseActivity, ICommonSmsView paramICommonSmsView)
  {
    this.a = new WeakReference(paramQBaseActivity);
    this.b = new WeakReference(paramICommonSmsView);
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    QLog.e("FaceSmsVerifyImpl", 1, new Object[] { "set face data onFailedResponse error, code : ", Integer.valueOf(paramInt), " message : ", paramString2, " cmd : ", paramString1 });
    paramString1 = (QBaseActivity)this.a.get();
    if (a(paramString1, (ICommonSmsView)this.b.get()))
    {
      QLog.e("FaceSmsVerifyImpl", 1, "onFailedResponse, but context is invalid");
      return;
    }
    if (paramInt != -1) {}
    for (;;)
    {
      QQToast.a(paramString1, 1, paramString2, 0).a();
      return;
      paramString2 = paramString1.getString(2131716956);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    QLog.d("FaceSmsVerifyImpl", 1, "getTmpKeySuccess");
    QBaseActivity localQBaseActivity = (QBaseActivity)this.a.get();
    ICommonSmsView localICommonSmsView = (ICommonSmsView)this.b.get();
    if (a(localQBaseActivity, localICommonSmsView))
    {
      QLog.e("FaceSmsVerifyImpl", 1, "getTmpKeySuccess, but context is invalid");
      return;
    }
    Intent localIntent = new Intent(localQBaseActivity, QQIdentiferLegacyActivity.class);
    localIntent.putExtra("platformAppId", 101810106);
    localIntent.putExtra("srcAppId", 101810106);
    localIntent.putExtra("srcOpenId", paramString1);
    localIntent.putExtra("key", paramString2);
    localIntent.putExtra("method", "setFaceData");
    localIntent.putExtra("serviceType", 2);
    localQBaseActivity.startActivityForResult(localIntent, 21);
    localICommonSmsView.setConfirmBtnEnable(false);
  }
  
  public void a(oidb_0x87a.RspBody paramRspBody)
  {
    QLog.d("FaceSmsVerifyImpl", 1, "sendSmsCodeSuccess");
    QBaseActivity localQBaseActivity = (QBaseActivity)this.a.get();
    ICommonSmsView localICommonSmsView = (ICommonSmsView)this.b.get();
    if (a(localQBaseActivity, localICommonSmsView))
    {
      QLog.e("FaceSmsVerifyImpl", 1, "sendSmsCodeSuccess, but context is invalid");
      return;
    }
    if (localQBaseActivity.isFinishing())
    {
      QLog.d("FaceSmsVerifyImpl", 1, "sendSmsCodeSuccess, activity is finish");
      return;
    }
    localICommonSmsView.dismissDialog();
    if (QLog.isColorLevel()) {
      QLog.d("FaceSmsVerifyImpl", 2, "Set face data onRecvVerifyCode");
    }
    localICommonSmsView.setTipsVisibility(0);
    int i = 60;
    if (paramRspBody.uint32_resend_interval.get() > 0) {
      i = paramRspBody.uint32_resend_interval.get();
    }
    localICommonSmsView.startTimer(i);
  }
  
  public void a(oidb_0x87c.RspBody paramRspBody)
  {
    QLog.d("FaceSmsVerifyImpl", 1, "verifySmsCodeSuccess");
    QBaseActivity localQBaseActivity = (QBaseActivity)this.a.get();
    ICommonSmsView localICommonSmsView = (ICommonSmsView)this.b.get();
    if (a(localQBaseActivity, localICommonSmsView))
    {
      QLog.e("FaceSmsVerifyImpl", 1, "verifySmsCodeSuccess, but context is invalid");
      return;
    }
    localICommonSmsView.dismissDialog();
    paramRspBody = Base64.encodeToString(paramRspBody.toByteArray(), 11);
    LoginVerifyServlet.a(101810106, localQBaseActivity.getAppRuntime().getAccount(), "sms", paramRspBody, this);
  }
  
  public boolean a(QBaseActivity paramQBaseActivity, ICommonSmsView paramICommonSmsView)
  {
    if ((paramQBaseActivity == null) || (paramICommonSmsView == null)) {
      return true;
    }
    return paramQBaseActivity.isFinishing();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.loginregister.FaceSmsVerifyImpl.FaceSmsVerifyObserver
 * JD-Core Version:    0.7.0.1
 */