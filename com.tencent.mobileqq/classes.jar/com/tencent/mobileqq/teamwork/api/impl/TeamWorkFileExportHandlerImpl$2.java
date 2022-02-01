package com.tencent.mobileqq.teamwork.api.impl;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WtTicketPromise;
import oicq.wlogin_sdk.tools.ErrMsg;

class TeamWorkFileExportHandlerImpl$2
  implements WtTicketPromise
{
  TeamWorkFileExportHandlerImpl$2(TeamWorkFileExportHandlerImpl paramTeamWorkFileExportHandlerImpl, Runnable paramRunnable) {}
  
  public void Done(Ticket paramTicket)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TeamWorkFileExportHandlerImpl", 2, "--- pskey invalid retry ---  ");
    }
    ThreadManager.executeOnNetWorkThread(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void Failed(ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("--- get pskey failed ---  ");
      localStringBuilder.append(paramErrMsg.getMessage());
      QLog.e("TeamWorkFileExportHandlerImpl", 2, localStringBuilder.toString());
    }
  }
  
  public void Timeout(ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("--- get pskey timeout ---  ");
      localStringBuilder.append(paramErrMsg.getMessage());
      QLog.e("TeamWorkFileExportHandlerImpl", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.api.impl.TeamWorkFileExportHandlerImpl.2
 * JD-Core Version:    0.7.0.1
 */