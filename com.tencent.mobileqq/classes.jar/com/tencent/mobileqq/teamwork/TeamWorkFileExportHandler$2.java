package com.tencent.mobileqq.teamwork;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WtTicketPromise;
import oicq.wlogin_sdk.tools.ErrMsg;

class TeamWorkFileExportHandler$2
  implements WtTicketPromise
{
  TeamWorkFileExportHandler$2(TeamWorkFileExportHandler paramTeamWorkFileExportHandler, Runnable paramRunnable) {}
  
  public void Done(Ticket paramTicket)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TeamWorkFileExportHandler", 2, "--- pskey invalid retry ---  ");
    }
    ThreadManager.executeOnNetWorkThread(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void Failed(ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.e("TeamWorkFileExportHandler", 2, "--- get pskey failed ---  " + paramErrMsg.getMessage());
    }
  }
  
  public void Timeout(ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.e("TeamWorkFileExportHandler", 2, "--- get pskey timeout ---  " + paramErrMsg.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkFileExportHandler.2
 * JD-Core Version:    0.7.0.1
 */