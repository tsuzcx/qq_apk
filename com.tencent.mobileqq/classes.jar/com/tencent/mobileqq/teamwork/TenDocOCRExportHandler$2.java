package com.tencent.mobileqq.teamwork;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WtTicketPromise;
import oicq.wlogin_sdk.tools.ErrMsg;

class TenDocOCRExportHandler$2
  implements WtTicketPromise
{
  TenDocOCRExportHandler$2(TenDocOCRExportHandler paramTenDocOCRExportHandler, Runnable paramRunnable) {}
  
  public void Done(Ticket paramTicket)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TenDocOCRExportHandler", 2, "--- pskey invalid retry ---  ");
    }
    ThreadManager.executeOnNetWorkThread(this.a);
  }
  
  public void Failed(ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("--- get pskey failed ---  ");
      localStringBuilder.append(paramErrMsg.getMessage());
      QLog.e("TenDocOCRExportHandler", 2, localStringBuilder.toString());
    }
  }
  
  public void Timeout(ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("--- get pskey timeout ---  ");
      localStringBuilder.append(paramErrMsg.getMessage());
      QLog.e("TenDocOCRExportHandler", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TenDocOCRExportHandler.2
 * JD-Core Version:    0.7.0.1
 */