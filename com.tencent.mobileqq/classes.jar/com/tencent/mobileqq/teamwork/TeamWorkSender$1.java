package com.tencent.mobileqq.teamwork;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import com.tencent.qphone.base.util.QLog;

class TeamWorkSender$1
  extends TeamWorkFileImportObserver
{
  TeamWorkSender$1(TeamWorkSender paramTeamWorkSender) {}
  
  public void a(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    super.a(paramTeamWorkFileImportInfo);
    if (paramTeamWorkFileImportInfo.L != TeamWorkSender.a(this.a).uniseq) {
      return;
    }
    TeamWorkSender.d(this.a).saveExtInfoToExtStr("errorString", TeamWorkSender.a(this.a, paramTeamWorkFileImportInfo.w));
    TeamWorkSender.d(this.a).saveExtInfoToExtStr("retCode", String.valueOf(paramTeamWorkFileImportInfo.w));
    TeamWorkSender.c(this.a).getMsgCache().b(TeamWorkSender.d(this.a).frienduin, TeamWorkSender.d(this.a).istroop, TeamWorkSender.d(this.a).uniseq);
    TeamWorkSender.c(this.a).removeObserver(TeamWorkSender.b(this.a));
    TeamWorkSender.c(this.a).getMessageFacade().a(TeamWorkSender.d(this.a).frienduin, TeamWorkSender.d(this.a).istroop, TeamWorkSender.d(this.a).uniseq, "extStr", TeamWorkSender.d(this.a).extStr);
    TeamWorkSender.c(this.a).getMessageFacade().a(TeamWorkSender.d(this.a).frienduin, TeamWorkSender.d(this.a).istroop, TeamWorkSender.d(this.a).uniseq, 32768, -1);
    paramTeamWorkFileImportInfo = new StringBuilder();
    paramTeamWorkFileImportInfo.append(TeamWorkSender.a(this.a).uniseq);
    paramTeamWorkFileImportInfo.append(" import file faild");
    QLog.i("TeamWorkSender", 1, paramTeamWorkFileImportInfo.toString());
    TeamWorkSender.c(this.a).getFileManagerNotifyCenter().a(true, 3, null);
  }
  
  public void a(String paramString, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if (paramTeamWorkFileImportInfo.L != TeamWorkSender.a(this.a).uniseq) {
      return;
    }
    TeamWorkSender.c(this.a).removeObserver(TeamWorkSender.b(this.a));
    TeamWorkSender.a(this.a).mMsgUrl = paramString;
    TeamWorkSender.d(this.a).structingMsg.mMsgUrl = paramString;
    TeamWorkSender.d(this.a).msgData = TeamWorkSender.a(this.a).getBytes();
    TeamWorkSender.a(this.a).removeFlag(1);
    TeamWorkSender.a(this.a).removeFlag(2);
    TeamWorkSender.c(this.a).getMessageFacade().b(TeamWorkSender.d(this.a), null, false);
    QLog.i("TeamWorkSender", 1, "start import file success");
    if (QLog.isColorLevel())
    {
      paramTeamWorkFileImportInfo = new StringBuilder();
      paramTeamWorkFileImportInfo.append("msg uniseq : ");
      paramTeamWorkFileImportInfo.append(TeamWorkSender.a(this.a).uniseq);
      paramTeamWorkFileImportInfo.append(" import success, url:");
      paramTeamWorkFileImportInfo.append(paramString);
      QLog.i("TeamWorkSender", 1, paramTeamWorkFileImportInfo.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkSender.1
 * JD-Core Version:    0.7.0.1
 */