package com.tencent.mobileqq.guild.api.impl;

import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.data.QQGuildDTConstant;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class GuildDTReportApiImpl
  implements IGuildDTReportApi
{
  private static final String TAG = "GuildDTReportApiImpl";
  
  public String convertToReportValue(int paramInt, String paramString)
  {
    if ("sgrp_user_type".equals(paramString)) {
      return String.valueOf(QQGuildDTConstant.a(paramInt));
    }
    if ("sgrp_sub_channel_type".equals(paramString)) {
      return String.valueOf(paramInt);
    }
    if ("sgrp_sub_channel_limit".equals(paramString)) {
      return String.valueOf(paramInt);
    }
    return String.valueOf(paramInt);
  }
  
  public void doReportEvent(String paramString, Map<String, Object> paramMap)
  {
    VideoReport.reportEvent(paramString, paramMap);
  }
  
  public void setChannelPageParams(View paramView, @NonNull IGProChannelInfo paramIGProChannelInfo, Map<String, Object> paramMap)
  {
    IGProGuildInfo localIGProGuildInfo = ((IGPSService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IGPSService.class, "")).getGuildInfo(paramIGProChannelInfo.getGuildId());
    if (localIGProGuildInfo == null)
    {
      QLog.e("GuildDTReportApiImpl", 1, new Object[] { "setChannelPageParams error null guildInfo key:", paramIGProChannelInfo.getGuildId() });
      return;
    }
    Object localObject = paramMap;
    if (paramMap == null) {
      localObject = new HashMap();
    }
    ((Map)localObject).put("dt_appkey", "0S200MNJT807V3GE");
    ((Map)localObject).put("sgrp_channel_id", localIGProGuildInfo.getGuildID());
    ((Map)localObject).put("sgrp_user_type", Integer.valueOf(QQGuildDTConstant.a(localIGProGuildInfo.getUserType())));
    ((Map)localObject).put("sgrp_sub_channel_id", paramIGProChannelInfo.getChannelUin());
    VideoReport.setPageParams(paramView, new PageParams((Map)localObject));
  }
  
  public void setElementClickDynamicParams(View paramView, String paramString, IDynamicParams paramIDynamicParams)
  {
    VideoReport.setElementId(paramView, paramString);
    if (paramIDynamicParams != null) {
      VideoReport.setEventDynamicParams(paramView, paramIDynamicParams);
    }
    VideoReport.setElementExposePolicy(paramView, ExposurePolicy.REPORT_NONE);
    VideoReport.setElementClickPolicy(paramView, ClickPolicy.REPORT_ALL);
  }
  
  public void setElementClickParams(View paramView, String paramString, Map<String, Object> paramMap)
  {
    VideoReport.setElementId(paramView, paramString);
    if (paramMap != null) {
      VideoReport.setElementParams(paramView, paramMap);
    }
    VideoReport.setElementExposePolicy(paramView, ExposurePolicy.REPORT_NONE);
    VideoReport.setElementClickPolicy(paramView, ClickPolicy.REPORT_ALL);
  }
  
  public void setElementExposureAndClickDynamicParams(View paramView, String paramString, IDynamicParams paramIDynamicParams)
  {
    VideoReport.setElementId(paramView, paramString);
    if (paramIDynamicParams != null) {
      VideoReport.setEventDynamicParams(paramView, paramIDynamicParams);
    }
    VideoReport.setElementExposePolicy(paramView, ExposurePolicy.REPORT_ALL);
    VideoReport.setElementClickPolicy(paramView, ClickPolicy.REPORT_ALL);
  }
  
  public void setElementExposureAndClickParams(View paramView, String paramString, Map<String, Object> paramMap)
  {
    VideoReport.setElementId(paramView, paramString);
    if (paramMap != null) {
      VideoReport.setElementParams(paramView, paramMap);
    }
    VideoReport.setElementExposePolicy(paramView, ExposurePolicy.REPORT_ALL);
    VideoReport.setElementClickPolicy(paramView, ClickPolicy.REPORT_ALL);
  }
  
  public void setElementParams(View paramView, Map<String, Object> paramMap)
  {
    if (paramMap != null) {
      VideoReport.setElementParams(paramView, paramMap);
    }
  }
  
  public void setElementReport(View paramView, String paramString, ClickPolicy paramClickPolicy, ExposurePolicy paramExposurePolicy)
  {
    VideoReport.setElementId(paramView, paramString);
    VideoReport.setElementClickPolicy(paramView, paramClickPolicy);
    VideoReport.setElementExposePolicy(paramView, paramExposurePolicy);
  }
  
  public void setGuildBasePageParams(String paramString, Map<String, String> paramMap)
  {
    Object localObject = (IGPSService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IGPSService.class, "");
    paramString = ((IGPSService)localObject).getChannelInfo(paramString);
    if (paramString == null) {
      return;
    }
    localObject = ((IGPSService)localObject).getGuildInfo(paramString.getGuildId());
    if (localObject == null) {
      return;
    }
    paramMap.put("dt_appkey", "0S200MNJT807V3GE");
    paramMap.put("sgrp_channel_id", ((IGProGuildInfo)localObject).getGuildID());
    paramMap.put("sgrp_user_type", convertToReportValue(((IGProGuildInfo)localObject).getUserType(), "sgrp_user_type"));
    paramMap.put("sgrp_sub_channel_id", paramString.getChannelUin());
    paramMap.put("sgrp_sub_channel_type", convertToReportValue(paramString.getType(), "sgrp_sub_channel_type"));
    paramMap.put("sgrp_sub_channel_limit", convertToReportValue(paramString.getTalkPermission(), "sgrp_sub_channel_limit"));
  }
  
  public void setGuildPageParams(View paramView, String paramString, Map<String, Object> paramMap)
  {
    IGProGuildInfo localIGProGuildInfo = ((IGPSService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IGPSService.class, "")).getGuildInfo(paramString);
    Object localObject = paramMap;
    if (paramMap == null) {
      localObject = new HashMap();
    }
    if (localIGProGuildInfo == null)
    {
      QLog.e("GuildDTReportApiImpl", 1, new Object[] { "setGuildPageParams error null guildInfo key:", paramString });
      return;
    }
    ((Map)localObject).put("dt_appkey", "0S200MNJT807V3GE");
    ((Map)localObject).put("sgrp_channel_id", localIGProGuildInfo.getGuildID());
    ((Map)localObject).put("sgrp_user_type", Integer.valueOf(QQGuildDTConstant.a(localIGProGuildInfo.getUserType())));
    VideoReport.setPageParams(paramView, new PageParams((Map)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.api.impl.GuildDTReportApiImpl
 * JD-Core Version:    0.7.0.1
 */