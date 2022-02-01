package com.tencent.mobileqq.utils;

import QQWalletPay.RespCheckChangePwdAuth;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QWalletAuthObserver;
import com.tencent.qphone.base.util.QLog;

class JumpActionLegacy$QWalletAuthMsgHandler
  extends Handler
{
  private JumpActionLegacy$QWalletAuthMsgHandler(JumpActionLegacy paramJumpActionLegacy) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1) {
      return;
    }
    if (JumpActionLegacy.i(this.a) != null)
    {
      JumpActionLegacy.i(this.a).a();
      this.a.H.removeObserver(JumpActionLegacy.i(this.a));
    }
    if (paramMessage.arg1 != 1)
    {
      if (QLog.isColorLevel()) {
        QLog.i("JumpAction", 2, "msf return error ");
      }
      JumpActionLegacy.a(this.a, 1);
      return;
    }
    if ((paramMessage.obj instanceof RespCheckChangePwdAuth))
    {
      paramMessage = (RespCheckChangePwdAuth)paramMessage.obj;
      if (paramMessage.retCode == 0)
      {
        JumpActionLegacy.j(this.a);
        return;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("server return error, errorCode: ");
        localStringBuilder.append(paramMessage.retCode);
        localStringBuilder.append(" errorMsg: ");
        localStringBuilder.append(paramMessage.retMsg);
        QLog.i("JumpAction", 2, localStringBuilder.toString());
      }
    }
    JumpActionLegacy.a(this.a, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.JumpActionLegacy.QWalletAuthMsgHandler
 * JD-Core Version:    0.7.0.1
 */