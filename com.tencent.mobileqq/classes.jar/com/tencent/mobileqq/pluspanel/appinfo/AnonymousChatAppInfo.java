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
    return 2130843816;
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
    return BaseApplicationImpl.getContext().getString(2131690007);
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
        ((ITroopAnonymousHandler)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_ANONYMOUS_HANDLER)).a(1, localQQAppInterface.getCurrentAccountUin(), paramSessionInfo.jdField_a_of_type_JavaLangString);
        ReportController.a(null, "P_CliOper", "Grp_anon", "", "norm_aio", "Clk_anon", 0, 0, String.valueOf(paramSessionInfo.jdField_a_of_type_JavaLangString), "", "", "");
        AIOPanelUtiles.a(localQQAppInterface, "0X8005CB4", paramSessionInfo.jdField_a_of_type_Int);
        return;
      }
      return;
    }
    if ((paramBaseChatPie instanceof TroopChatPie))
    {
      ((TroopChatPie)paramBaseChatPie).o(false);
      AIOMusicSkin.a().d(false);
      ReportController.a(null, "P_CliOper", "Grp_anon", "", "norm_aio", "Clk_quit", 0, 0, String.valueOf(paramSessionInfo.jdField_a_of_type_JavaLangString), "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.AnonymousChatAppInfo
 * JD-Core Version:    0.7.0.1
 */