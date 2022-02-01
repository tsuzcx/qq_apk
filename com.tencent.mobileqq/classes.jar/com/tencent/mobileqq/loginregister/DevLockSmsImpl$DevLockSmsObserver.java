package com.tencent.mobileqq.loginregister;

import android.text.TextUtils;
import com.tencent.mobileqq.app.GatewayLoginNewDevHelper;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.phonecontact.util.ContactSyncUtils;
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
        paramErrMsg = new StringBuilder();
        paramErrMsg.append("onRecvVerifyCode uin:");
        paramErrMsg.append(paramString);
        paramErrMsg.append(" seq=");
        paramErrMsg.append(paramInt1);
        QLog.d("DevLockSmsImpl", 2, paramErrMsg.toString());
        if (paramDevlockInfo != null)
        {
          paramString = new StringBuilder();
          paramString.append("onRecvVerifyCode info.TimeLimit:");
          paramString.append(paramDevlockInfo.TimeLimit);
          QLog.d("DevLockSmsImpl", 2, paramString.toString());
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
      paramString = new StringBuilder();
      paramString.append("onRecvVerifyCode ret = ");
      paramString.append(paramInt2);
      paramString.append(" seq=");
      paramString.append(paramInt1);
      QLog.d("DevLockSmsImpl", 2, paramString.toString());
      if (paramErrMsg != null)
      {
        paramString = new StringBuilder();
        paramString.append("onRecvVerifyCode  errMsg:");
        paramString.append(paramErrMsg.getMessage());
        paramString.append(" seq=");
        paramString.append(paramInt1);
        QLog.d("DevLockSmsImpl", 2, paramString.toString());
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
    QQToast.a(localQBaseActivity, 1, localQBaseActivity.getString(2131716609), 0).a();
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
      if (QLog.isColorLevel())
      {
        paramErrMsg = new StringBuilder();
        paramErrMsg.append("onRecvCheckSMSResult uin:");
        paramErrMsg.append(paramString);
        paramErrMsg.append(" seq=");
        paramErrMsg.append(paramInt1);
        QLog.d("DevLockSmsImpl", 2, paramErrMsg.toString());
      }
      setSeq(paramInt1);
      return;
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("onRecvCheckSMSResult ret = ");
      paramString.append(paramInt2);
      paramString.append(" seq=");
      paramString.append(paramInt1);
      QLog.d("DevLockSmsImpl", 2, paramString.toString());
      if (paramErrMsg != null)
      {
        paramString = new StringBuilder();
        paramString.append("onRecvCheckSMSResult  errMsg:");
        paramString.append(paramErrMsg.getMessage());
        paramString.append(" seq=");
        paramString.append(paramInt1);
        QLog.d("DevLockSmsImpl", 2, paramString.toString());
      }
    }
    if ((paramInt2 == 9) || (paramInt2 == 155))
    {
      paramDevlockInfo.setResult(-1);
      paramDevlockInfo.finish();
    }
    if (a(paramDevlockInfo, localICommonSmsView))
    {
      QLog.e("DevLockSmsImpl", 1, "onRecvCheckSMSResult failed, but context is invalid, do nothing");
      return;
    }
    localICommonSmsView.clearWrongCode();
    if ((paramErrMsg != null) && (!TextUtils.isEmpty(paramErrMsg.getMessage())))
    {
      QQToast.a(paramDevlockInfo, 1, paramErrMsg.getMessage(), 0).a();
      return;
    }
    QQToast.a(paramDevlockInfo, 1, paramDevlockInfo.getString(2131716609), 0).a();
  }
  
  public boolean a(QBaseActivity paramQBaseActivity, ICommonSmsView paramICommonSmsView)
  {
    if ((paramQBaseActivity != null) && (paramICommonSmsView != null)) {
      return paramQBaseActivity.isFinishing();
    }
    return true;
  }
  
  public void onRecvNotice(int paramInt1, int paramInt2, String paramString, int paramInt3, ErrMsg paramErrMsg, DevlockInfo paramDevlockInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onRecvNotice uin:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" seq=");
    localStringBuilder.append(paramInt2);
    QLog.d("DevLockSmsImpl", 1, localStringBuilder.toString());
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onVerifyClose ret = ");
    ((StringBuilder)localObject).append(paramInt2);
    QLog.i("DevLockSmsImpl", 1, ((StringBuilder)localObject).toString());
    if (paramErrMsg != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onVerifyClose  errMsg:");
      ((StringBuilder)localObject).append(paramErrMsg.getMessage());
      QLog.d("DevLockSmsImpl", 1, ((StringBuilder)localObject).toString());
    }
    paramErrMsg = (QBaseActivity)this.a.get();
    localObject = (ICommonSmsView)this.b.get();
    if (a(paramErrMsg, (ICommonSmsView)localObject))
    {
      QLog.e("DevLockSmsImpl", 1, "onVerifyClose, context is invalid");
      return;
    }
    ((ICommonSmsView)localObject).dismissDialog();
    ((ICommonSmsView)localObject).loginSuccessCallBack();
    paramErrMsg.setResult(-1);
    paramErrMsg.finish();
    EquipmentLockImpl.a().a(paramErrMsg.getAppRuntime(), paramErrMsg, paramString, true);
  }
  
  public void onVerifySuccess(String paramString, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    boolean bool = GatewayLoginNewDevHelper.a();
    paramToServiceMsg = new StringBuilder();
    paramToServiceMsg.append("gateway_login_new_dev onVerifySuccess isGateWayFlow=");
    paramToServiceMsg.append(bool);
    paramToServiceMsg.append(",uin=");
    paramToServiceMsg.append(ContactSyncUtils.a(paramString));
    QLog.i("DevLockSmsImpl", 1, paramToServiceMsg.toString());
    if (bool)
    {
      GatewayLoginNewDevHelper.a(2);
      if (!TextUtils.isEmpty(paramString))
      {
        MsfSdkUtils.addLoginSimpleAccount(paramString, true);
        paramToServiceMsg = MobileQQ.sMobileQQ;
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append(Constants.PropertiesKey.uinDisplayName.toString());
        paramFromServiceMsg.append(paramString);
        paramToServiceMsg.setProperty(paramFromServiceMsg.toString(), paramString);
        MobileQQ.sMobileQQ.setSortAccountList(MsfSdkUtils.getLoginedAccountList());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.loginregister.DevLockSmsImpl.DevLockSmsObserver
 * JD-Core Version:    0.7.0.1
 */