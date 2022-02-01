package com.tencent.mobileqq.pluspanel.appinfo;

import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.activity.aio.panel.AIOPanelUtiles;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelViewModel;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ListenTogetherTheme.AIOMusicSkin;
import com.tencent.mobileqq.troop.troopanonymous.api.ITroopAnonymousHandler;
import com.tencent.qphone.base.util.BaseApplication;

public class AnonymousChatAppInfo
  extends PlusPanelAppInfo
{
  public int defaultDrawableID()
  {
    return 2130844770;
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
    return BaseApplicationImpl.getContext().getString(2131886656);
  }
  
  public void onPlusPanelAppClick(PlusPanelViewModel paramPlusPanelViewModel, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    QQAppInterface localQQAppInterface = paramBaseChatPie.d;
    if (!AnonymousChatHelper.a().a(paramSessionInfo.b))
    {
      AIOMusicSkin.a().d(true);
      paramPlusPanelViewModel.a("chat_tool_anonymous", localQQAppInterface.getCurrentAccountUin());
      if ((paramBaseChatPie instanceof TroopChatPie))
      {
        ((TroopChatPie)paramBaseChatPie).a(2, "");
        ((ITroopAnonymousHandler)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_ANONYMOUS_HANDLER)).a(1, localQQAppInterface.getCurrentAccountUin(), paramSessionInfo.b);
        ReportController.a(null, "P_CliOper", "Grp_anon", "", "norm_aio", "Clk_anon", 0, 0, String.valueOf(paramSessionInfo.b), "", "", "");
        AIOPanelUtiles.a(localQQAppInterface, "0X8005CB4", paramSessionInfo.a);
        return;
      }
      return;
    }
    if ((paramBaseChatPie instanceof TroopChatPie))
    {
      ((TroopChatPie)paramBaseChatPie).s(false);
      AIOMusicSkin.a().d(false);
      ReportController.a(null, "P_CliOper", "Grp_anon", "", "norm_aio", "Clk_quit", 0, 0, String.valueOf(paramSessionInfo.b), "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.AnonymousChatAppInfo
 * JD-Core Version:    0.7.0.1
 */