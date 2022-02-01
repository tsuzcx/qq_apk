package com.tencent.mobileqq.pluspanel.appinfo;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelViewModel;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ListenTogetherTheme.AIOMusicSkin;
import com.tencent.qphone.base.util.BaseApplication;

public class ExitAnonymousChatAppInfo
  extends PlusPanelAppInfo
{
  public int defaultDrawableID()
  {
    return 2130843896;
  }
  
  public int getAppID()
  {
    if (isC2C()) {
      return 0;
    }
    return 1200000004;
  }
  
  public String getTitle()
  {
    return BaseApplicationImpl.getContext().getString(2131692162);
  }
  
  public void onPlusPanelAppClick(PlusPanelViewModel paramPlusPanelViewModel, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    if ((paramBaseChatPie instanceof TroopChatPie))
    {
      ((TroopChatPie)paramBaseChatPie).v(false);
      AIOMusicSkin.a().d(false);
      ReportController.a(null, "P_CliOper", "Grp_anon", "", "norm_aio", "Clk_quit", 0, 0, String.valueOf(paramSessionInfo.a), "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.ExitAnonymousChatAppInfo
 * JD-Core Version:    0.7.0.1
 */