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
    if ((paramQBaseActivity == null) || (paramICommonSmsView == null)) {
      return true;
    }
    return paramQBaseActivity.isFinishing();
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
      if (QLog.isColorLevel()) {
        QLog.d("DefaultSmsImpl", 2, "OnAskDevLockSms DevlockInfo.TimeLimit:" + paramDevlockInfo.TimeLimit + " AvailableMsgCount:" + paramDevlockInfo.AvailableMsgCount);
      }
      if (paramDevlockInfo.TimeLimit <= 0) {
        paramDevlockInfo.TimeLimit = 60;
      }
      localICommonSmsView.startTimer(paramDevlockInfo.TimeLimit);
      return;
    }
    QLog.d("DefaultSmsImpl", 1, "OnAskDevLockSms ret = " + paramInt);
    if (paramErrMsg != null) {
      QLog.d("DefaultSmsImpl", 1, "OnAskDevLockSms  errMsg:" + paramErrMsg.getMessage());
    }
    if ((paramErrMsg != null) && (!TextUtils.isEmpty(paramErrMsg.getMessage())))
    {
      QQToast.a(paramWUserSigInfo, 1, paramErrMsg.getMessage(), 0).a();
      return;
    }
    QQToast.a(paramWUserSigInfo, 1, paramWUserSigInfo.getString(2131716956), 0).a();
  }
  
  public void onCheckDevLockSms(WUserSigInfo paramWUserSigInfo, int paramInt, ErrMsg paramErrMsg)
  {
    QLog.d("DefaultSmsImpl", 1, "OnCheckDevLockSms ret = " + paramInt);
    if (paramErrMsg != null) {
      QLog.d("DefaultSmsImpl", 1, "OnCheckDevLockSms  errMsg:" + paramErrMsg.getMessage());
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
    QQToast.a(paramWUserSigInfo, 1, paramWUserSigInfo.getString(2131716956), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.loginregister.DefaultSmsImpl.OpenDevLockObserver
 * JD-Core Version:    0.7.0.1
 */