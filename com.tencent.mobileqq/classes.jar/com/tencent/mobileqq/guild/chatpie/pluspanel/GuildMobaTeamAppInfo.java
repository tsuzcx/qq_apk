package com.tencent.mobileqq.guild.chatpie.pluspanel;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelViewModel;
import com.tencent.mobileqq.guild.api.IQQGuildClientAuthApi;
import com.tencent.mobileqq.guild.chatpie.GuildChatContext;
import com.tencent.mobileqq.guild.client.GuildClientParams;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.widget.XPanelContainer;

public class GuildMobaTeamAppInfo
  extends PlusPanelAppInfo
{
  private void a(BaseChatPie paramBaseChatPie)
  {
    paramBaseChatPie = paramBaseChatPie.bm().getCurrentPanelView();
    VideoReport.setElementId(paramBaseChatPie, "em_sgrp_aio_plus_wzteam");
    VideoReport.setElementClickPolicy(paramBaseChatPie, ClickPolicy.REPORT_NONE);
    VideoReport.setElementExposePolicy(paramBaseChatPie, ExposurePolicy.REPORT_NONE);
    VideoReport.reportEvent("clck", paramBaseChatPie, null);
  }
  
  public int defaultDrawableID()
  {
    return 2130840659;
  }
  
  public int getAppID()
  {
    return 2000000001;
  }
  
  public String getTitle()
  {
    return BaseApplicationImpl.getContext().getString(2131890357);
  }
  
  protected void onPlusPanelAppClick(PlusPanelViewModel paramPlusPanelViewModel, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    paramPlusPanelViewModel = ((GuildChatContext)paramBaseChatPie.bv()).S();
    paramSessionInfo = ((GuildChatContext)paramBaseChatPie.bv()).T();
    paramPlusPanelViewModel = new GuildClientParams().d(paramPlusPanelViewModel).g("100001").e(paramSessionInfo).a(5).e();
    ((IQQGuildClientAuthApi)QRoute.api(IQQGuildClientAuthApi.class)).clientAuthorizationForAIOPlus(paramBaseChatPie.aX(), paramPlusPanelViewModel);
    paramBaseChatPie.aw();
    a(paramBaseChatPie);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.pluspanel.GuildMobaTeamAppInfo
 * JD-Core Version:    0.7.0.1
 */