package com.tencent.mobileqq.loginregister;

import android.content.Intent;
import android.util.Base64;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.identification.FaceConf;
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
  
  public boolean a(QBaseActivity paramQBaseActivity, ICommonSmsView paramICommonSmsView)
  {
    return (paramQBaseActivity == null) || (paramICommonSmsView == null) || (paramQBaseActivity.isFinishing());
  }
  
  public void getTmpKeySuccess(String paramString1, String paramString2)
  {
    QLog.d("FaceSmsVerifyImpl", 1, "getTmpKeySuccess");
    QBaseActivity localQBaseActivity = (QBaseActivity)this.a.get();
    if (a(localQBaseActivity, (ICommonSmsView)this.b.get()))
    {
      QLog.e("FaceSmsVerifyImpl", 1, "getTmpKeySuccess, but context is invalid");
      return;
    }
    Intent localIntent = new Intent();
    FaceConf localFaceConf = new FaceConf();
    localFaceConf.setPlatformAppId(101810106);
    localFaceConf.setAppId(101810106);
    localFaceConf.setOpenId(paramString1);
    localFaceConf.setKey(paramString2);
    localFaceConf.setMethod("setFaceData");
    localFaceConf.setServiceType(2);
    localIntent.putExtra("faceConf", localFaceConf);
    RouteUtils.a(localQBaseActivity, localIntent, "/base/connectface/legacy", 21);
  }
  
  public void onFailedResponse(String paramString1, int paramInt, String paramString2)
  {
    QLog.e("FaceSmsVerifyImpl", 1, new Object[] { "set face data onFailedResponse error, code : ", Integer.valueOf(paramInt), " message : ", paramString2, " cmd : ", paramString1 });
    paramString1 = (QBaseActivity)this.a.get();
    ICommonSmsView localICommonSmsView = (ICommonSmsView)this.b.get();
    if (a(paramString1, localICommonSmsView))
    {
      QLog.e("FaceSmsVerifyImpl", 1, "onFailedResponse, but context is invalid");
      return;
    }
    localICommonSmsView.clearWrongCode();
    if (paramInt == -1) {
      paramString2 = paramString1.getString(2131914072);
    }
    QQToast.makeText(paramString1, 1, paramString2, 0).show();
  }
  
  public void sendSmsCodeSuccess(oidb_0x87a.RspBody paramRspBody)
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
    int i = 60;
    if (paramRspBody.uint32_resend_interval.get() > 0) {
      i = paramRspBody.uint32_resend_interval.get();
    }
    localICommonSmsView.startTimer(i);
  }
  
  public void verifySmsCodeSuccess(oidb_0x87c.RspBody paramRspBody)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.loginregister.FaceSmsVerifyImpl.FaceSmsVerifyObserver
 * JD-Core Version:    0.7.0.1
 */