package com.tencent.mobileqq.msgbackup.fragment;

import com.tencent.mobileqq.msgbackup.authentication.MsgBackupObserver;
import com.tencent.mobileqq.msgbackup.data.MsgBackupGetQrRsp;
import com.tencent.mobileqq.msgbackup.data.MsgBackupQryStateRsp;
import com.tencent.qphone.base.util.QLog;

class MsgBackupBaseFragment$2
  extends MsgBackupObserver
{
  MsgBackupBaseFragment$2(MsgBackupBaseFragment paramMsgBackupBaseFragment) {}
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.MsgBackupBaseFragment", 2, "onConfirmTokenResponse:  isSuccess: " + paramBoolean);
    }
    super.a(paramBoolean);
  }
  
  public void a(boolean paramBoolean, MsgBackupQryStateRsp paramMsgBackupQryStateRsp)
  {
    if (paramBoolean) {
      this.a.a(paramMsgBackupQryStateRsp);
    }
    super.a(paramBoolean, paramMsgBackupQryStateRsp);
  }
  
  public void a(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.MsgBackupBaseFragment", 2, "onGetQrResponse: " + paramObject + ", isSuccess: " + paramBoolean);
    }
    Object localObject;
    if ((paramBoolean) && ((paramObject instanceof MsgBackupGetQrRsp)))
    {
      localObject = (MsgBackupGetQrRsp)paramObject;
      this.a.a((MsgBackupGetQrRsp)localObject);
    }
    for (;;)
    {
      super.a(paramBoolean, paramObject);
      return;
      if ((paramObject instanceof Integer))
      {
        localObject = (Integer)paramObject;
        this.a.a((Integer)localObject);
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.MsgBackupBaseFragment", 2, "onRejectQRResponse:  isSuccess: " + paramBoolean);
    }
    super.b(paramBoolean);
  }
  
  public void b(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.MsgBackupBaseFragment", 2, "onConfirmQrResponse: " + paramObject + ", isSuccess: " + paramBoolean);
    }
    this.a.a(paramBoolean, paramObject);
    super.b(paramBoolean, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupBaseFragment.2
 * JD-Core Version:    0.7.0.1
 */