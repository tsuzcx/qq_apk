package com.tencent.mobileqq.pluspanel.appinfo;

import ahpt;
import ahvi;
import aoep;
import bdla;
import behu;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import nty;

public class AnonymousChatAppInfo
  extends PlusPanelAppInfo
{
  public int defaultDrawableID()
  {
    return 2130843725;
  }
  
  public int getAppID()
  {
    if (isTroop()) {
      return 1101487426;
    }
    return 0;
  }
  
  public String getTitle()
  {
    return BaseApplicationImpl.getContext().getString(2131690042);
  }
  
  public void onPlusPanelAppClick(ahvi paramahvi, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    QQAppInterface localQQAppInterface = paramBaseChatPie.app;
    if (!nty.a().a(paramSessionInfo.curFriendUin))
    {
      behu.a().d(true);
      paramahvi.a("chat_tool_anonymous", localQQAppInterface.getCurrentAccountUin());
      if ((paramBaseChatPie instanceof TroopChatPie))
      {
        ((TroopChatPie)paramBaseChatPie).a(2, "");
        ((aoep)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).a(1, localQQAppInterface.getCurrentAccountUin(), paramSessionInfo.curFriendUin);
        bdla.a(null, "P_CliOper", "Grp_anon", "", "norm_aio", "Clk_anon", 0, 0, String.valueOf(paramSessionInfo.curFriendUin), "", "", "");
        ahpt.a(localQQAppInterface, "0X8005CB4", paramSessionInfo.curType);
      }
    }
    while (!(paramBaseChatPie instanceof TroopChatPie)) {
      return;
    }
    ((TroopChatPie)paramBaseChatPie).c(false);
    behu.a().d(false);
    bdla.a(null, "P_CliOper", "Grp_anon", "", "norm_aio", "Clk_quit", 0, 0, String.valueOf(paramSessionInfo.curFriendUin), "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.AnonymousChatAppInfo
 * JD-Core Version:    0.7.0.1
 */