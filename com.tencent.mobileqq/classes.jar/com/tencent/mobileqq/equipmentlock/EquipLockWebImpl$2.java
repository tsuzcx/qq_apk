package com.tencent.mobileqq.equipmentlock;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.tools.ErrMsg;

class EquipLockWebImpl$2
  extends WtloginObserver
{
  EquipLockWebImpl$2(EquipLockWebImpl paramEquipLockWebImpl) {}
  
  public void onCheckDevLockSms(WUserSigInfo paramWUserSigInfo, int paramInt, ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel())
    {
      paramWUserSigInfo = new StringBuilder();
      paramWUserSigInfo.append("OnCheckDevLockSms ret=");
      paramWUserSigInfo.append(paramInt);
      QLog.d("EquipLockWebImpl", 2, paramWUserSigInfo.toString());
    }
    if (paramInt == 0)
    {
      EquipLockWebImpl.c(this.a, true);
      if (EquipLockWebImpl.a(this.a) != null)
      {
        paramWUserSigInfo = (QQAppInterface)EquipLockWebImpl.a(this.a).get();
        if ((paramWUserSigInfo != null) && (EquipmentLockImpl.a().a(paramWUserSigInfo))) {}
      }
      else
      {
        EquipLockWebImpl.a(this.a, false);
        EquipLockWebImpl.b(this.a, false);
      }
    }
    else
    {
      EquipLockWebImpl.a(this.a, false);
      EquipLockWebImpl.c(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.equipmentlock.EquipLockWebImpl.2
 * JD-Core Version:    0.7.0.1
 */