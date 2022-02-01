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
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ListenTogetherTheme.AIOMusicSkin;
import com.tencent.qphone.base.util.BaseApplication;

public class AnonymousChatAppInfo
  extends PlusPanelAppInfo
{
  public int defaultDrawableID()
  {
    return 2130843896;
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
    return BaseApplicationImpl.getContext().getString(2131690091);
  }
  
  public void onPlusPanelAppClick(PlusPanelViewModel paramPlusPanelViewModel, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    QQAppInterface localQQAppInterface = paramBaseChatPie.a;
    if (!AnonymousChatHelper.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString))
    {
      AIOMusicSkin.a().d(true);
      paramPlusPanelViewModel.a("chat_tool_anonymous", localQQAppInterface.getCurrentAccountUin());
      if ((paramBaseChatPie instanceof TroopChatPie))
      {
        ((TroopChatPie)paramBaseChatPie).a(2, "");
        ((TroopHandler)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).a(1, localQQAppInterface.getCurrentAccountUin(), paramSessionInfo.jdField_a_of_type_JavaLangString);
        ReportController.a(null, "P_CliOper", "Grp_anon", "", "norm_aio", "Clk_anon", 0, 0, String.valueOf(paramSessionInfo.jdField_a_of_type_JavaLangString), "", "", "");
        AIOPanelUtiles.a(localQQAppInterface, "0X8005CB4", paramSessionInfo.jdField_a_of_type_Int);
      }
    }
    while (!(paramBaseChatPie instanceof TroopChatPie)) {
      return;
    }
    ((TroopChatPie)paramBaseChatPie).v(false);
    AIOMusicSkin.a().d(false);
    ReportController.a(null, "P_CliOper", "Grp_anon", "", "norm_aio", "Clk_quit", 0, 0, String.valueOf(paramSessionInfo.jdField_a_of_type_JavaLangString), "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.AnonymousChatAppInfo
 * JD-Core Version:    0.7.0.1
 */