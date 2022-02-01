package com.tencent.mobileqq.teamwork.api.impl;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.teamwork.ReSendCmd;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.TicketManager;
import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WtTicketPromise;
import oicq.wlogin_sdk.tools.ErrMsg;

class TeamWorkHandlerImpl$2
  implements WtTicketPromise
{
  TeamWorkHandlerImpl$2(TeamWorkHandlerImpl paramTeamWorkHandlerImpl, TicketManager paramTicketManager, ReSendCmd paramReSendCmd) {}
  
  public void Done(Ticket paramTicket)
  {
    int i;
    if (paramTicket == null) {
      i = 1;
    } else if ((paramTicket != null) && (paramTicket._sig == null)) {
      i = 2;
    } else {
      i = 0;
    }
    paramTicket = new StringBuilder();
    paramTicket.append("getSkeyFromServerAndRetry get skey from server : Done,result: ");
    paramTicket.append(i);
    QLog.i("TeamWorkHandlerImpl", 1, paramTicket.toString());
    paramTicket = this.a.getSkey(TeamWorkHandlerImpl.access$000(this.c).getCurrentAccountUin());
    if ((!TextUtils.isEmpty(paramTicket)) && (paramTicket.length() > 0))
    {
      TeamWorkHandlerImpl.access$302(this.c, 0);
      QLog.i("TeamWorkHandlerImpl", 1, "getSkeyFromServerAndRetry get skey from server success!");
    }
    TeamWorkHandlerImpl.access$200(this.c, this.b);
  }
  
  public void Failed(ErrMsg paramErrMsg)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getSkeyFromServerAndRetry get skey from server : Failed, ");
    localStringBuilder.append(paramErrMsg);
    QLog.i("TeamWorkHandlerImpl", 1, localStringBuilder.toString());
    TeamWorkHandlerImpl.access$200(this.c, this.b);
  }
  
  public void Timeout(ErrMsg paramErrMsg)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getSkeyFromServerAndRetry get skey from server : Timeout, ");
    localStringBuilder.append(paramErrMsg);
    QLog.i("TeamWorkHandlerImpl", 1, localStringBuilder.toString());
    TeamWorkHandlerImpl.access$200(this.c, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.api.impl.TeamWorkHandlerImpl.2
 * JD-Core Version:    0.7.0.1
 */