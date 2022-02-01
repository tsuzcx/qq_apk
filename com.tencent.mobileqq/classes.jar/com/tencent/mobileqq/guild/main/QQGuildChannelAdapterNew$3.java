package com.tencent.mobileqq.guild.main;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.mainframe.GuildMainViewContext;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QQGuildChannelAdapterNew$3
  implements View.OnClickListener
{
  QQGuildChannelAdapterNew$3(QQGuildChannelAdapterNew paramQQGuildChannelAdapterNew, String paramString, long paramLong) {}
  
  public void onClick(View paramView)
  {
    if (!QQGuildUIUtil.a())
    {
      ((IQQGuildRouterApi)QRoute.api(IQQGuildRouterApi.class)).openCreateGuildChannel(QQGuildChannelAdapterNew.d(this.c).b(), this.c.b(), QQGuildChannelAdapterNew.c(this.c).getGuildID(), "main_setting", this.a, this.b);
      VideoReport.reportEvent("clck", paramView, null);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.main.QQGuildChannelAdapterNew.3
 * JD-Core Version:    0.7.0.1
 */