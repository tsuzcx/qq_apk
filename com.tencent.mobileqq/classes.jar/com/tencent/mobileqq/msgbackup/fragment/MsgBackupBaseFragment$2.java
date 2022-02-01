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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onConfirmTokenResponse:  isSuccess: ");
      localStringBuilder.append(paramBoolean);
      QLog.d("MsgBackup.MsgBackupBaseFragment", 2, localStringBuilder.toString());
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
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onGetQrResponse: ");
      ((StringBuilder)localObject).append(paramObject);
      ((StringBuilder)localObject).append(", isSuccess: ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("MsgBackup.MsgBackupBaseFragment", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramBoolean) && ((paramObject instanceof MsgBackupGetQrRsp)))
    {
      localObject = (MsgBackupGetQrRsp)paramObject;
      this.a.a((MsgBackupGetQrRsp)localObject);
    }
    else if ((paramObject instanceof Integer))
    {
      localObject = (Integer)paramObject;
      this.a.a((Integer)localObject);
    }
    super.a(paramBoolean, paramObject);
  }
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onRejectQRResponse:  isSuccess: ");
      localStringBuilder.append(paramBoolean);
      QLog.d("MsgBackup.MsgBackupBaseFragment", 2, localStringBuilder.toString());
    }
    super.b(paramBoolean);
  }
  
  public void b(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onConfirmQrResponse: ");
      localStringBuilder.append(paramObject);
      localStringBuilder.append(", isSuccess: ");
      localStringBuilder.append(paramBoolean);
      QLog.d("MsgBackup.MsgBackupBaseFragment", 2, localStringBuilder.toString());
    }
    this.a.a(paramBoolean, paramObject);
    super.b(paramBoolean, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupBaseFragment.2
 * JD-Core Version:    0.7.0.1
 */