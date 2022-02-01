package com.tencent.mobileqq.guild.api;

import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import java.util.Map;

@QAPI(process={"all"})
public abstract interface IGuildDTReportApi
  extends QRouteApi
{
  public abstract void doReportEvent(String paramString, Map<String, Object> paramMap);
  
  public abstract void setChannelPageParams(View paramView, @NonNull IGProChannelInfo paramIGProChannelInfo, Map<String, Object> paramMap);
  
  public abstract void setElementClickDynamicParams(View paramView, String paramString, IDynamicParams paramIDynamicParams);
  
  public abstract void setElementClickParams(View paramView, String paramString, Map<String, Object> paramMap);
  
  public abstract void setElementExposureAndClickDynamicParams(View paramView, String paramString, IDynamicParams paramIDynamicParams);
  
  public abstract void setElementExposureAndClickParams(View paramView, String paramString, Map<String, Object> paramMap);
  
  public abstract void setElementParams(View paramView, Map<String, Object> paramMap);
  
  public abstract void setElementReport(View paramView, String paramString, ClickPolicy paramClickPolicy, ExposurePolicy paramExposurePolicy);
  
  public abstract void setGuildBasePageParams(String paramString, Map<String, String> paramMap);
  
  public abstract void setGuildPageParams(View paramView, String paramString, Map<String, Object> paramMap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.api.IGuildDTReportApi
 * JD-Core Version:    0.7.0.1
 */