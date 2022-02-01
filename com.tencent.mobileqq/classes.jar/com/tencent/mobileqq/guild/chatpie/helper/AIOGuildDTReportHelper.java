package com.tencent.mobileqq.guild.chatpie.helper;

import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.AIODtReportHelper;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.chatpie.GuildChatContext;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.HashMap;
import java.util.Map;

public class AIOGuildDTReportHelper
  extends AIODtReportHelper
{
  public AIOGuildDTReportHelper(@NonNull BaseChatPie paramBaseChatPie)
  {
    super(paramBaseChatPie);
  }
  
  protected void a(View paramView, String paramString)
  {
    VideoReport.setElementId(paramView, paramString);
    VideoReport.setElementExposePolicy(paramView, ExposurePolicy.REPORT_ALL);
    VideoReport.setElementClickPolicy(paramView, ClickPolicy.REPORT_ALL);
  }
  
  protected void b(View paramView)
  {
    VideoReport.addToDetectionWhitelist(this.a.aX());
    VideoReport.resetPageParams(paramView);
    Object localObject = new HashMap();
    if (this.b != null) {
      ((IGuildDTReportApi)QRoute.api(IGuildDTReportApi.class)).setGuildBasePageParams(this.b.b, (Map)localObject);
    }
    VideoReport.setPageParams(paramView, new PageParams((Map)localObject));
    localObject = this.d;
    if (((GuildChatContext)this.a.bv()).W()) {
      paramView = "pg_sgrp_post";
    } else {
      paramView = "pg_sgrp_aio";
    }
    VideoReport.setPageId(localObject, paramView);
    VideoReport.setPageContentId(this.d, String.valueOf(SystemClock.elapsedRealtime()), true);
  }
  
  protected void c(View paramView)
  {
    a(paramView, "em_aio_channel_setting");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.helper.AIOGuildDTReportHelper
 * JD-Core Version:    0.7.0.1
 */