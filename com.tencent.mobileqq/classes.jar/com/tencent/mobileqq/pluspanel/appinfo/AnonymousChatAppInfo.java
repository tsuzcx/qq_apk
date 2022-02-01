package com.tencent.mobileqq.pluspanel.appinfo;

import agwt;
import anca;
import ayfu;
import bcef;
import bdav;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import nmy;

public class AnonymousChatAppInfo
  extends PlusPanelAppInfo
{
  public int defaultDrawableID()
  {
    return 2130843687;
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
    return BaseApplicationImpl.getContext().getString(2131690013);
  }
  
  public void onPlusPanelAppClick(ayfu paramayfu, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    QQAppInterface localQQAppInterface = paramBaseChatPie.app;
    if (!nmy.a().a(paramSessionInfo.curFriendUin))
    {
      bdav.a().b(true);
      paramayfu.a("chat_tool_anonymous", localQQAppInterface.getCurrentAccountUin());
      if ((paramBaseChatPie instanceof TroopChatPie))
      {
        ((TroopChatPie)paramBaseChatPie).a(2, "");
        ((anca)localQQAppInterface.getBusinessHandler(20)).a(1, localQQAppInterface.getCurrentAccountUin(), paramSessionInfo.curFriendUin);
        bcef.a(null, "P_CliOper", "Grp_anon", "", "norm_aio", "Clk_anon", 0, 0, String.valueOf(paramSessionInfo.curFriendUin), "", "", "");
        agwt.a(localQQAppInterface, "0X8005CB4", paramSessionInfo.curType);
      }
    }
    while (!(paramBaseChatPie instanceof TroopChatPie)) {
      return;
    }
    ((TroopChatPie)paramBaseChatPie).b(false);
    bdav.a().b(false);
    bcef.a(null, "P_CliOper", "Grp_anon", "", "norm_aio", "Clk_quit", 0, 0, String.valueOf(paramSessionInfo.curFriendUin), "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.AnonymousChatAppInfo
 * JD-Core Version:    0.7.0.1
 */