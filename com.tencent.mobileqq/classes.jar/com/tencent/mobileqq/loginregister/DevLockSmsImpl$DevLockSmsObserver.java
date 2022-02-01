package com.tencent.mobileqq.loginregister;

import android.text.TextUtils;
import com.tencent.mobileqq.app.GatewayLoginNewDevHelper;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.contactsync.ContactSyncManager;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Constants.PropertiesKey;
import mqq.app.MobileQQ;
import mqq.manager.VerifyDevLockManager.VerifyDevLockObserver;
import mqq.util.WeakReference;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.tools.ErrMsg;

class DevLockSmsImpl$DevLockSmsObserver
  extends VerifyDevLockManager.VerifyDevLockObserver
{
  private final WeakReference<QBaseActivity> a;
  private final WeakReference<ICommonSmsView> b;
  
  public DevLockSmsImpl$DevLockSmsObserver(QBaseActivity paramQBaseActivity, ICommonSmsView paramICommonSmsView)
  {
    this.a = new WeakReference(paramQBaseActivity);
    this.b = new WeakReference(paramICommonSmsView);
  }
  
  private void a(int paramInt1, String paramString, int paramInt2, ErrMsg paramErrMsg, DevlockInfo paramDevlockInfo)
  {
    QBaseActivity localQBaseActivity = (QBaseActivity)this.a.get();
    ICommonSmsView localICommonSmsView = (ICommonSmsView)this.b.get();
    if (a(localQBaseActivity, localICommonSmsView))
    {
      QLog.e("DevLockSmsImpl", 1, "onRecvVerifyCode, context is invalid");
      return;
    }
    localICommonSmsView.dismissDialog();
    if (paramInt2 == 0)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("DevLockSmsImpl", 2, "onRecvVerifyCode uin:" + paramString + " seq=" + paramInt1);
        if (paramDevlockInfo != null) {
          QLog.d("DevLockSmsImpl", 2, "onRecvVerifyCode info.TimeLimit:" + paramDevlockInfo.TimeLimit);
        }
      }
      setSeq(paramInt1);
      paramInt2 = 60;
      paramInt1 = paramInt2;
      if (paramDevlockInfo != null)
      {
        paramInt1 = paramInt2;
        if (paramDevlockInfo.TimeLimit > 0) {
          paramInt1 = paramDevlockInfo.TimeLimit;
        }
      }
      localICommonSmsView.startTimer(paramInt1);
      return;
    }
    if (QLog.isColorLevel())
    {
      QLog.d("DevLockSmsImpl", 2, "onRecvVerifyCode ret = " + paramInt2 + " seq=" + paramInt1);
      if (paramErrMsg != null) {
        QLog.d("DevLockSmsImpl", 2, "onRecvVerifyCode  errMsg:" + paramErrMsg.getMessage() + " seq=" + paramInt1);
      }
    }
    if ((paramInt2 == 9) || (paramInt2 == 155))
    {
      localQBaseActivity.setResult(-1);
      localQBaseActivity.finish();
    }
    if ((paramErrMsg != null) && (!TextUtils.isEmpty(paramErrMsg.getMessage())))
    {
      QQToast.a(localQBaseActivity, 1, paramErrMsg.getMessage(), 0).a();
      return;
    }
    QQToast.a(localQBaseActivity, 1, localQBaseActivity.getString(2131716956), 0).a();
  }
  
  private void b(int paramInt1, String paramString, int paramInt2, ErrMsg paramErrMsg, DevlockInfo paramDevlockInfo)
  {
    paramDevlockInfo = (QBaseActivity)this.a.get();
    ICommonSmsView localICommonSmsView = (ICommonSmsView)this.b.get();
    if (a(paramDevlockInfo, localICommonSmsView))
    {
      QLog.e("DevLockSmsImpl", 1, "onRecvCheckSMSResult, context is invalid");
      return;
    }
    localICommonSmsView.dismissDialog();
    if (paramInt2 == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DevLockSmsImpl", 2, "onRecvCheckSMSResult uin:" + paramString + " seq=" + paramInt1);
      }
      setSeq(paramInt1);
      return;
    }
    if (QLog.isColorLevel())
    {
      QLog.d("DevLockSmsImpl", 2, "onRecvCheckSMSResult ret = " + paramInt2 + " seq=" + paramInt1);
      if (paramErrMsg != null) {
        QLog.d("DevLockSmsImpl", 2, "onRecvCheckSMSResult  errMsg:" + paramErrMsg.getMessage() + " seq=" + paramInt1);
      }
    }
    if ((paramInt2 == 9) || (paramInt2 == 155))
    {
      paramDevlockInfo.setResult(-1);
      paramDevlockInfo.finish();
    }
    if ((paramErrMsg != null) && (!TextUtils.isEmpty(paramErrMsg.getMessage())))
    {
      QQToast.a(paramDevlockInfo, 1, paramErrMsg.getMessage(), 0).a();
      return;
    }
    QQToast.a(paramDevlockInfo, 1, paramDevlockInfo.getString(2131716956), 0).a();
  }
  
  public boolean a(QBaseActivity paramQBaseActivity, ICommonSmsView paramICommonSmsView)
  {
    if ((paramQBaseActivity == null) || (paramICommonSmsView == null)) {
      return true;
    }
    return paramQBaseActivity.isFinishing();
  }
  
  public void onRecvNotice(int paramInt1, int paramInt2, String paramString, int paramInt3, ErrMsg paramErrMsg, DevlockInfo paramDevlockInfo)
  {
    QLog.d("DevLockSmsImpl", 1, "onRecvNotice uin:" + paramString + " seq=" + paramInt2);
    if (a((QBaseActivity)this.a.get(), (ICommonSmsView)this.b.get()))
    {
      QLog.e("DevLockSmsImpl", 1, "onRecvNotice, context is invalid");
      return;
    }
    if (paramInt1 == 1002)
    {
      a(paramInt2, paramString, paramInt3, paramErrMsg, paramDevlockInfo);
      return;
    }
    b(paramInt2, paramString, paramInt3, paramErrMsg, paramDevlockInfo);
  }
  
  public void onVerifyClose(int paramInt1, String paramString, int paramInt2, ErrMsg paramErrMsg)
  {
    QLog.i("DevLockSmsImpl", 1, "onVerifyClose ret = " + paramInt2);
    if (paramErrMsg != null) {
      QLog.d("DevLockSmsImpl", 1, "onVerifyClose  errMsg:" + paramErrMsg.getMessage());
    }
    paramErrMsg = (QBaseActivity)this.a.get();
    ICommonSmsView localICommonSmsView = (ICommonSmsView)this.b.get();
    if (a(paramErrMsg, localICommonSmsView))
    {
      QLog.e("DevLockSmsImpl", 1, "onVerifyClose, context is invalid");
      return;
    }
    localICommonSmsView.dismissDialog();
    paramErrMsg.setResult(-1);
    paramErrMsg.finish();
    EquipmentLockImpl.a().a(paramErrMsg.getAppRuntime(), paramErrMsg, paramString, true);
  }
  
  public void onVerifySuccess(String paramString, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    boolean bool = GatewayLoginNewDevHelper.a();
    QLog.i("DevLockSmsImpl", 1, "gateway_login_new_dev onVerifySuccess isGateWayFlow=" + bool + ",uin=" + ContactSyncManager.b(paramString));
    if (bool)
    {
      GatewayLoginNewDevHelper.a(2);
      if (!TextUtils.isEmpty(paramString))
      {
        MsfSdkUtils.addLoginSimpleAccount(paramString, true);
        MobileQQ.sMobileQQ.setProperty(Constants.PropertiesKey.uinDisplayName.toString() + paramString, paramString);
        MobileQQ.sMobileQQ.setSortAccountList(MsfSdkUtils.getLoginedAccountList());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.loginregister.DevLockSmsImpl.DevLockSmsObserver
 * JD-Core Version:    0.7.0.1
 */