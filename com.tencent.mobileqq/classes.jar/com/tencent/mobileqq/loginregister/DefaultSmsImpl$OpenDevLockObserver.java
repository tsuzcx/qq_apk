package com.tencent.mobileqq.loginregister;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.manager.AccountManager;
import mqq.observer.WtloginObserver;
import mqq.util.WeakReference;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.tools.ErrMsg;

class DefaultSmsImpl$OpenDevLockObserver
  extends WtloginObserver
{
  private final WeakReference<QBaseActivity> a;
  private final WeakReference<ICommonSmsView> b;
  
  public DefaultSmsImpl$OpenDevLockObserver(QBaseActivity paramQBaseActivity, ICommonSmsView paramICommonSmsView)
  {
    this.a = new WeakReference(paramQBaseActivity);
    this.b = new WeakReference(paramICommonSmsView);
  }
  
  public boolean a(QBaseActivity paramQBaseActivity, ICommonSmsView paramICommonSmsView)
  {
    if ((paramQBaseActivity != null) && (paramICommonSmsView != null)) {
      return paramQBaseActivity.isFinishing();
    }
    return true;
  }
  
  public void onAskDevLockSms(WUserSigInfo paramWUserSigInfo, DevlockInfo paramDevlockInfo, int paramInt, ErrMsg paramErrMsg)
  {
    paramWUserSigInfo = (QBaseActivity)this.a.get();
    ICommonSmsView localICommonSmsView = (ICommonSmsView)this.b.get();
    if (a(paramWUserSigInfo, localICommonSmsView))
    {
      QLog.e("DefaultSmsImpl", 1, "onAskDevLockSms, context is invalid");
      return;
    }
    localICommonSmsView.dismissDialog();
    if ((paramInt == 0) && (paramDevlockInfo != null))
    {
      if (QLog.isColorLevel())
      {
        paramWUserSigInfo = new StringBuilder();
        paramWUserSigInfo.append("OnAskDevLockSms DevlockInfo.TimeLimit:");
        paramWUserSigInfo.append(paramDevlockInfo.TimeLimit);
        paramWUserSigInfo.append(" AvailableMsgCount:");
        paramWUserSigInfo.append(paramDevlockInfo.AvailableMsgCount);
        QLog.d("DefaultSmsImpl", 2, paramWUserSigInfo.toString());
      }
      if (paramDevlockInfo.TimeLimit <= 0) {
        paramDevlockInfo.TimeLimit = 60;
      }
      localICommonSmsView.startTimer(paramDevlockInfo.TimeLimit);
      return;
    }
    paramDevlockInfo = new StringBuilder();
    paramDevlockInfo.append("OnAskDevLockSms ret = ");
    paramDevlockInfo.append(paramInt);
    QLog.d("DefaultSmsImpl", 1, paramDevlockInfo.toString());
    if (paramErrMsg != null)
    {
      paramDevlockInfo = new StringBuilder();
      paramDevlockInfo.append("OnAskDevLockSms  errMsg:");
      paramDevlockInfo.append(paramErrMsg.getMessage());
      QLog.d("DefaultSmsImpl", 1, paramDevlockInfo.toString());
    }
    if ((paramErrMsg != null) && (!TextUtils.isEmpty(paramErrMsg.getMessage())))
    {
      QQToast.a(paramWUserSigInfo, 1, paramErrMsg.getMessage(), 0).a();
      return;
    }
    QQToast.a(paramWUserSigInfo, 1, paramWUserSigInfo.getString(2131716609), 0).a();
  }
  
  public void onCheckDevLockSms(WUserSigInfo paramWUserSigInfo, int paramInt, ErrMsg paramErrMsg)
  {
    paramWUserSigInfo = new StringBuilder();
    paramWUserSigInfo.append("OnCheckDevLockSms ret = ");
    paramWUserSigInfo.append(paramInt);
    QLog.d("DefaultSmsImpl", 1, paramWUserSigInfo.toString());
    if (paramErrMsg != null)
    {
      paramWUserSigInfo = new StringBuilder();
      paramWUserSigInfo.append("OnCheckDevLockSms  errMsg:");
      paramWUserSigInfo.append(paramErrMsg.getMessage());
      QLog.d("DefaultSmsImpl", 1, paramWUserSigInfo.toString());
    }
    paramWUserSigInfo = (QBaseActivity)this.a.get();
    Object localObject = (ICommonSmsView)this.b.get();
    if (a(paramWUserSigInfo, (ICommonSmsView)localObject))
    {
      QLog.e("DefaultSmsImpl", 1, "onCheckDevLockSms, context is invalid");
      return;
    }
    ((ICommonSmsView)localObject).dismissDialog();
    if (paramInt == 0)
    {
      paramErrMsg = (AccountManager)paramWUserSigInfo.getAppRuntime().getManager(0);
      localObject = paramWUserSigInfo.getCurrentAccountUinFromRuntime();
      if (paramErrMsg != null) {
        paramErrMsg.refreshDA2((String)localObject, null);
      }
      EquipmentLockImpl.a().a(null, (String)localObject, 9);
      paramWUserSigInfo.setResult(-1);
      paramWUserSigInfo.finish();
      EquipmentLockImpl.a().a(paramWUserSigInfo.getAppRuntime(), paramWUserSigInfo, (String)localObject, true);
      return;
    }
    if ((paramErrMsg != null) && (!TextUtils.isEmpty(paramErrMsg.getMessage())))
    {
      QQToast.a(paramWUserSigInfo, 1, paramErrMsg.getMessage(), 0).a();
      return;
    }
    QQToast.a(paramWUserSigInfo, 1, paramWUserSigInfo.getString(2131716609), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.loginregister.DefaultSmsImpl.OpenDevLockObserver
 * JD-Core Version:    0.7.0.1
 */