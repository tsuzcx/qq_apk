package com.tencent.mobileqq.guild.main.item;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.guild.main.QQGuildChannelAdapterNew;
import com.tencent.mobileqq.guild.main.data.QQGuildChannelApp;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.appchannel.ITextChannelPreInfo;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.HashMap;
import java.util.Map;

class QQGuildAppChannelBuilder$2
  implements View.OnClickListener
{
  QQGuildAppChannelBuilder$2(QQGuildAppChannelBuilder paramQQGuildAppChannelBuilder, ITextChannelPreInfo paramITextChannelPreInfo, QQGuildChannelApp paramQQGuildChannelApp) {}
  
  public void onClick(View paramView)
  {
    if (!QQGuildUIUtil.a())
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("troop click: jumpUrl=");
        ((StringBuilder)localObject).append(this.a.a());
        QLog.i("QQGuildAppChannelBuilder", 1, ((StringBuilder)localObject).toString());
      }
      if (StringUtil.isEmpty(this.a.a()))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("troop jumpUrl is empty, channelId=");
        ((StringBuilder)localObject).append(this.b.a().getChannelUin());
        QLog.e("QQGuildAppChannelBuilder", 1, ((StringBuilder)localObject).toString());
      }
      else
      {
        ((QQGuildChannelAdapterNew)this.c.a).a(this.a.a(), this.b);
        QQGuildUtil.a(paramView, "em_sgrp_create_node", ClickPolicy.REPORT_NONE, ExposurePolicy.REPORT_NONE);
        localObject = new HashMap();
        ((HashMap)localObject).put("sgrp_in_name", this.a.b());
        VideoReport.reportEvent("clck", paramView, (Map)localObject);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.main.item.QQGuildAppChannelBuilder.2
 * JD-Core Version:    0.7.0.1
 */