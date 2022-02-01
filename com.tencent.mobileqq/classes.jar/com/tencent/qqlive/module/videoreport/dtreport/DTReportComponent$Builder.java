package com.tencent.qqlive.module.videoreport.dtreport;

import com.tencent.qqlive.module.videoreport.Configuration.Builder;
import com.tencent.qqlive.module.videoreport.ILogger;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.dtreport.api.IDTParamProvider;
import com.tencent.qqlive.module.videoreport.dtreport.api.IDTReport;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConfigConstants.ElementFormatMode;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.utils.IDetectionInterceptor;

public class DTReportComponent$Builder
{
  private Configuration.Builder mConfigurationBuilder;
  private IDTReport mDTReport;
  private int mElementFormatMode = 1;
  private boolean mEnableDebug;
  private boolean mEnablePageLink = false;
  private IDTParamProvider mParamProvider;
  
  DTReportComponent$Builder(IDTParamProvider paramIDTParamProvider)
  {
    if (paramIDTParamProvider != null)
    {
      this.mParamProvider = paramIDTParamProvider;
      this.mConfigurationBuilder = new Configuration.Builder();
      return;
    }
    throw new IllegalArgumentException("dtParamProvider不可为空");
  }
  
  public Builder appTimeReportHeartBeatInterval(int paramInt)
  {
    this.mConfigurationBuilder.appTimeReportHeartBeatInterval(paramInt);
    return this;
  }
  
  public Builder appTimeReportTimePinInterval(int paramInt)
  {
    this.mConfigurationBuilder.appTimeReportTimePinInterval(paramInt);
    return this;
  }
  
  public Builder audioTimePinInterval(int paramInt)
  {
    this.mConfigurationBuilder.audioTimePinInterval(paramInt);
    return this;
  }
  
  public Builder audioTimeReportHeartBeatInterval(int paramInt)
  {
    this.mConfigurationBuilder.audioTimeReportHeartBeatInterval(paramInt);
    return this;
  }
  
  public DTReportComponent build()
  {
    return new DTReportComponent(this, null);
  }
  
  public Builder dtReport(IDTReport paramIDTReport)
  {
    this.mDTReport = paramIDTReport;
    return this;
  }
  
  public Builder elementClickPolicy(ClickPolicy paramClickPolicy)
  {
    this.mConfigurationBuilder.elementClickPolicy(paramClickPolicy);
    return this;
  }
  
  public Builder elementEndExposePolicy(EndExposurePolicy paramEndExposurePolicy)
  {
    this.mConfigurationBuilder.elementEndExposePolicy(paramEndExposurePolicy);
    return this;
  }
  
  public Builder elementExposePolicy(ExposurePolicy paramExposurePolicy)
  {
    this.mConfigurationBuilder.elementExposePolicy(paramExposurePolicy);
    return this;
  }
  
  public Builder elementFormatMode(@DTConfigConstants.ElementFormatMode int paramInt)
  {
    this.mElementFormatMode = paramInt;
    return this;
  }
  
  public Builder enableDebug(boolean paramBoolean)
  {
    this.mEnableDebug = paramBoolean;
    return this;
  }
  
  public Builder enablePageLink(boolean paramBoolean)
  {
    this.mEnablePageLink = paramBoolean;
    return this;
  }
  
  public Builder enableToast(boolean paramBoolean)
  {
    this.mConfigurationBuilder.enableToast(paramBoolean);
    return this;
  }
  
  public Builder independentPageOut(boolean paramBoolean)
  {
    this.mConfigurationBuilder.independentPageOut(paramBoolean);
    return this;
  }
  
  public Builder lazyInitType(int paramInt)
  {
    this.mConfigurationBuilder.lazyInitType(paramInt);
    return this;
  }
  
  public Builder setDetectionInterceptor(IDetectionInterceptor paramIDetectionInterceptor)
  {
    VideoReportInner.getInstance().setDetectionInterceptor(paramIDetectionInterceptor);
    return this;
  }
  
  public Builder setLogger(ILogger paramILogger)
  {
    this.mConfigurationBuilder.logger(paramILogger);
    return this;
  }
  
  public Builder setVideoPageSwitch(int paramInt)
  {
    this.mConfigurationBuilder.setVideoPageSwitch(paramInt);
    return this;
  }
  
  public Builder videoHeartBeatInterval(int paramInt)
  {
    this.mConfigurationBuilder.videoHeartBeatInterval(paramInt);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.DTReportComponent.Builder
 * JD-Core Version:    0.7.0.1
 */