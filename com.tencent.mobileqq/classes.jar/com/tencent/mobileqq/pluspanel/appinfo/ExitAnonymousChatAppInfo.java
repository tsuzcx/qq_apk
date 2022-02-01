package com.tencent.mobileqq.pluspanel.appinfo;

import ahvi;
import bdla;
import behu;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo;
import com.tencent.qphone.base.util.BaseApplication;

public class ExitAnonymousChatAppInfo
  extends PlusPanelAppInfo
{
  public int defaultDrawableID()
  {
    return 2130843725;
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
    return BaseApplicationImpl.getContext().getString(2131692032);
  }
  
  public void onPlusPanelAppClick(ahvi paramahvi, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    if ((paramBaseChatPie instanceof TroopChatPie))
    {
      ((TroopChatPie)paramBaseChatPie).c(false);
      behu.a().d(false);
      bdla.a(null, "P_CliOper", "Grp_anon", "", "norm_aio", "Clk_quit", 0, 0, String.valueOf(paramSessionInfo.curFriendUin), "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.ExitAnonymousChatAppInfo
 * JD-Core Version:    0.7.0.1
 */