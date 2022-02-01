package com.tencent.mobileqq.fragment;

import com.tencent.mobileqq.msgbackup.authentication.MsgBackupObserver;
import com.tencent.mobileqq.msgbackup.data.MsgBackupConfirmQrRsp;
import com.tencent.mobileqq.msgbackup.data.MsgBackupGetQrRsp;
import com.tencent.mobileqq.msgbackup.data.MsgBackupQryStateRsp;
import com.tencent.qphone.base.util.QLog;

class MsgBackupSettingFragment$7
  extends MsgBackupObserver
{
  MsgBackupSettingFragment$7(MsgBackupSettingFragment paramMsgBackupSettingFragment) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      QLog.d("MsgBackup", 1, "onConfirmTokenRepsponse called! is success");
    }
    for (;;)
    {
      super.a(paramBoolean);
      return;
      QLog.d("MsgBackup", 1, "onConfirmTokenRepsponse called! confirm token is failed!");
    }
  }
  
  public void a(boolean paramBoolean, MsgBackupQryStateRsp paramMsgBackupQryStateRsp)
  {
    if (paramBoolean)
    {
      MsgBackupSettingFragment.a(this.a, paramMsgBackupQryStateRsp);
      QLog.d("MsgBackup", 1, "onQueryStateResponse called! qrStateResponse = " + MsgBackupSettingFragment.a(this.a));
    }
    for (;;)
    {
      super.a(paramBoolean, paramMsgBackupQryStateRsp);
      return;
      QLog.d("MsgBackup", 1, "onQueryStateResponse called! query qr state is failed!");
    }
  }
  
  public void a(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && ((paramObject instanceof MsgBackupGetQrRsp)))
    {
      MsgBackupSettingFragment.a = (MsgBackupGetQrRsp)paramObject;
      QLog.d("MsgBackup", 1, "onGetQrResponse called! qrResponse = " + MsgBackupSettingFragment.a);
    }
    for (;;)
    {
      super.a(paramBoolean, paramObject);
      return;
      QLog.d("MsgBackup", 1, "onGetQrResponse called! request qrCode is failed!");
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean) {
      QLog.d("MsgBackup", 1, "onRejectQRResponse called! is success");
    }
    for (;;)
    {
      super.b(paramBoolean);
      return;
      QLog.d("MsgBackup", 1, "onRejectQRResponse called! reject qr is failed!");
    }
  }
  
  public void b(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean)
    {
      MsgBackupSettingFragment.a(this.a, (MsgBackupConfirmQrRsp)paramObject);
      QLog.d("MsgBackup", 1, "onConfirmQrResponse called! qrConfirmReponse = " + MsgBackupSettingFragment.a(this.a));
    }
    for (;;)
    {
      super.b(paramBoolean, paramObject);
      return;
      QLog.d("MsgBackup", 1, "onConfirmQrResponse called! confirm qrCode is failed!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.MsgBackupSettingFragment.7
 * JD-Core Version:    0.7.0.1
 */