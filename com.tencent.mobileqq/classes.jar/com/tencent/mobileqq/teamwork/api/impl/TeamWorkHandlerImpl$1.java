package com.tencent.mobileqq.teamwork.api.impl;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.teamwork.ReSendCmd;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import mqq.manager.TicketManager;
import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WtTicketPromise;
import oicq.wlogin_sdk.tools.ErrMsg;

class TeamWorkHandlerImpl$1
  implements WtTicketPromise
{
  TeamWorkHandlerImpl$1(TeamWorkHandlerImpl paramTeamWorkHandlerImpl, TicketManager paramTicketManager, ReSendCmd paramReSendCmd) {}
  
  public void Done(Ticket paramTicket)
  {
    int i;
    if (paramTicket == null) {
      i = 1;
    } else if ((paramTicket != null) && (paramTicket._pskey_map == null)) {
      i = 2;
    } else if ((paramTicket != null) && (paramTicket._pskey_map != null) && (paramTicket._pskey_map.get("docs.qq.com") == null)) {
      i = 3;
    } else {
      i = 0;
    }
    paramTicket = new StringBuilder();
    paramTicket.append("getPskeyFromServerAndRetry get pskey from server : Done, result: ");
    paramTicket.append(i);
    QLog.i("TeamWorkHandlerImpl", 1, paramTicket.toString());
    paramTicket = this.jdField_a_of_type_MqqManagerTicketManager.getPskey(TeamWorkHandlerImpl.access$000(this.jdField_a_of_type_ComTencentMobileqqTeamworkApiImplTeamWorkHandlerImpl).getCurrentAccountUin(), "docs.qq.com");
    if ((!TextUtils.isEmpty(paramTicket)) && (paramTicket.length() > 0))
    {
      TeamWorkHandlerImpl.access$102(this.jdField_a_of_type_ComTencentMobileqqTeamworkApiImplTeamWorkHandlerImpl, 0);
      QLog.i("TeamWorkHandlerImpl", 1, "getPskeyFromServerAndRetry get pskey from server success!");
    }
    TeamWorkHandlerImpl.access$200(this.jdField_a_of_type_ComTencentMobileqqTeamworkApiImplTeamWorkHandlerImpl, this.jdField_a_of_type_ComTencentMobileqqTeamworkReSendCmd);
  }
  
  public void Failed(ErrMsg paramErrMsg)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getPskeyFromServerAndRetry get pskey from server : Failed, ");
    localStringBuilder.append(paramErrMsg);
    QLog.i("TeamWorkHandlerImpl", 1, localStringBuilder.toString());
    TeamWorkHandlerImpl.access$200(this.jdField_a_of_type_ComTencentMobileqqTeamworkApiImplTeamWorkHandlerImpl, this.jdField_a_of_type_ComTencentMobileqqTeamworkReSendCmd);
  }
  
  public void Timeout(ErrMsg paramErrMsg)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getPskeyFromServerAndRetry get pskey from server : Timeout, ");
    localStringBuilder.append(paramErrMsg);
    QLog.i("TeamWorkHandlerImpl", 1, localStringBuilder.toString());
    TeamWorkHandlerImpl.access$200(this.jdField_a_of_type_ComTencentMobileqqTeamworkApiImplTeamWorkHandlerImpl, this.jdField_a_of_type_ComTencentMobileqqTeamworkReSendCmd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.api.impl.TeamWorkHandlerImpl.1
 * JD-Core Version:    0.7.0.1
 */