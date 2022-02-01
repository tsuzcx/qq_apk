package com.tencent.mobileqq.guild.live.fragment.audience.module.videobar;

import androidx.lifecycle.Observer;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.live.QQGuildLiveRoomStartParams;
import com.tencent.mobileqq.guild.live.QQGuildLiveStartParamsCache;
import com.tencent.mobileqq.guild.util.GuildLiveDtUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.HashMap;

class QQGuildVideoBarLiveFragment$5
  implements Observer<Boolean>
{
  QQGuildVideoBarLiveFragment$5(QQGuildVideoBarLiveFragment paramQQGuildVideoBarLiveFragment) {}
  
  public void a(Boolean paramBoolean)
  {
    if (paramBoolean == Boolean.TRUE)
    {
      paramBoolean = QQGuildLiveStartParamsCache.a().getChannelInfo();
      HashMap localHashMap = new GuildLiveDtUtil(paramBoolean, QQGuildLiveStartParamsCache.a().getGuildInfo()).a();
      VideoReport.setPageId(QQGuildVideoBarLiveFragment.a(this.a), "pg_sgrp_stream_aio");
      ((IGuildDTReportApi)QRoute.api(IGuildDTReportApi.class)).setChannelPageParams(QQGuildVideoBarLiveFragment.a(this.a), paramBoolean, localHashMap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.fragment.audience.module.videobar.QQGuildVideoBarLiveFragment.5
 * JD-Core Version:    0.7.0.1
 */