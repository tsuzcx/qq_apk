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
    } else {
      QLog.d("MsgBackup", 1, "onConfirmTokenRepsponse called! confirm token is failed!");
    }
    super.a(paramBoolean);
  }
  
  public void a(boolean paramBoolean, MsgBackupQryStateRsp paramMsgBackupQryStateRsp)
  {
    if (paramBoolean)
    {
      MsgBackupSettingFragment.a(this.a, paramMsgBackupQryStateRsp);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onQueryStateResponse called! qrStateResponse = ");
      localStringBuilder.append(MsgBackupSettingFragment.a(this.a));
      QLog.d("MsgBackup", 1, localStringBuilder.toString());
    }
    else
    {
      QLog.d("MsgBackup", 1, "onQueryStateResponse called! query qr state is failed!");
    }
    super.a(paramBoolean, paramMsgBackupQryStateRsp);
  }
  
  public void a(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && ((paramObject instanceof MsgBackupGetQrRsp)))
    {
      MsgBackupSettingFragment.a = (MsgBackupGetQrRsp)paramObject;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGetQrResponse called! qrResponse = ");
      localStringBuilder.append(MsgBackupSettingFragment.a);
      QLog.d("MsgBackup", 1, localStringBuilder.toString());
    }
    else
    {
      QLog.d("MsgBackup", 1, "onGetQrResponse called! request qrCode is failed!");
    }
    super.a(paramBoolean, paramObject);
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean) {
      QLog.d("MsgBackup", 1, "onRejectQRResponse called! is success");
    } else {
      QLog.d("MsgBackup", 1, "onRejectQRResponse called! reject qr is failed!");
    }
    super.b(paramBoolean);
  }
  
  public void b(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean)
    {
      MsgBackupSettingFragment.a(this.a, (MsgBackupConfirmQrRsp)paramObject);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onConfirmQrResponse called! qrConfirmReponse = ");
      localStringBuilder.append(MsgBackupSettingFragment.a(this.a));
      QLog.d("MsgBackup", 1, localStringBuilder.toString());
    }
    else
    {
      QLog.d("MsgBackup", 1, "onConfirmQrResponse called! confirm qrCode is failed!");
    }
    super.b(paramBoolean, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.MsgBackupSettingFragment.7
 * JD-Core Version:    0.7.0.1
 */