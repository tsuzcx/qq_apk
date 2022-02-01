package com.tencent.qqlive.module.videoreport;

import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ReportPolicy;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.utils.IFormatter;

public class Configuration$Builder
{
  private int mAppTimeReportHeartBeatInterval = 60;
  private int mAppTimeReportTimePinInterval = 5;
  private int mAudioTimePinInterval = 5;
  private int mAudioTimeReportHeartBeatInterval = 60;
  private long mClickReportInterval = 500L;
  private boolean mDefaultDataCollectEnable = true;
  private boolean mDefaultReportEnable = true;
  private ClickPolicy mElementClickPolicy = ClickPolicy.REPORT_ALL;
  private boolean mElementDetectEnable = true;
  private EndExposurePolicy mElementEndExposePolicy = EndExposurePolicy.REPORT_NONE;
  private ExposurePolicy mElementExposePolicy = ExposurePolicy.REPORT_FIRST;
  private double mElementExposureMinRate = 0.01D;
  private long mElementExposureMinTime = 200L;
  @Deprecated
  private ReportPolicy mElementReportPolicy = ReportPolicy.REPORT_POLICY_ALL;
  private EndExposurePolicy mElementScrollEndExposePolicy = EndExposurePolicy.REPORT_NONE;
  private ExposurePolicy mElementScrollExposePolicy = ExposurePolicy.REPORT_FIRST;
  private boolean mEnablePageLink = false;
  private boolean mEnableToast;
  private IFormatter mFormatter;
  private boolean mIndependentPageOut = false;
  private int mLazyInitType = 0;
  private ILogger mLogger = Configuration.access$2700();
  private double mPageExposureMinRate = 0.4D;
  private long mPageExposureMinTime = 200L;
  private int mVideoHeartBeatInterval = 300;
  private int mVideoPageSwitch = 0;
  private long mVisitBackgroundTime = 900000L;
  
  private Builder defaultReportEnable(boolean paramBoolean)
  {
    this.mDefaultReportEnable = paramBoolean;
    return this;
  }
  
  public Builder appTimeReportHeartBeatInterval(int paramInt)
  {
    this.mAppTimeReportHeartBeatInterval = paramInt;
    return this;
  }
  
  public Builder appTimeReportTimePinInterval(int paramInt)
  {
    this.mAppTimeReportTimePinInterval = paramInt;
    return this;
  }
  
  public Builder audioTimePinInterval(int paramInt)
  {
    this.mAudioTimePinInterval = paramInt;
    return this;
  }
  
  public Builder audioTimeReportHeartBeatInterval(int paramInt)
  {
    this.mAudioTimeReportHeartBeatInterval = paramInt;
    return this;
  }
  
  public Configuration build()
  {
    Configuration localConfiguration = new Configuration(this, null);
    if (VideoReportInner.getInstance().isDebugMode())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("build: ");
      localStringBuilder.append(localConfiguration);
      Log.i("Configuration", localStringBuilder.toString());
    }
    return localConfiguration;
  }
  
  public Builder clickReportInterval(long paramLong)
  {
    this.mClickReportInterval = paramLong;
    return this;
  }
  
  public Builder defaultDataCollectEnable(boolean paramBoolean)
  {
    this.mDefaultDataCollectEnable = paramBoolean;
    return this;
  }
  
  public Builder elementClickPolicy(ClickPolicy paramClickPolicy)
  {
    this.mElementClickPolicy = paramClickPolicy;
    return this;
  }
  
  public Builder elementDetectEnable(boolean paramBoolean)
  {
    this.mElementDetectEnable = paramBoolean;
    return this;
  }
  
  public Builder elementEndExposePolicy(EndExposurePolicy paramEndExposurePolicy)
  {
    this.mElementEndExposePolicy = paramEndExposurePolicy;
    return this;
  }
  
  public Builder elementExposePolicy(ExposurePolicy paramExposurePolicy)
  {
    this.mElementExposePolicy = paramExposurePolicy;
    return this;
  }
  
  public Builder elementExposureMinRate(double paramDouble)
  {
    if (paramDouble > 1.0D)
    {
      this.mElementExposureMinRate = 1.0D;
      return this;
    }
    if (paramDouble < 0.0D)
    {
      this.mElementExposureMinRate = 0.0D;
      return this;
    }
    this.mElementExposureMinRate = paramDouble;
    return this;
  }
  
  public Builder elementExposureMinTime(long paramLong)
  {
    if (paramLong < 0L)
    {
      this.mElementExposureMinTime = 0L;
      return this;
    }
    this.mElementExposureMinTime = paramLong;
    return this;
  }
  
  @Deprecated
  public Builder elementReportPolicy(ReportPolicy paramReportPolicy)
  {
    Object localObject;
    if (paramReportPolicy.reportClick) {
      localObject = ClickPolicy.REPORT_ALL;
    } else {
      localObject = ClickPolicy.REPORT_NONE;
    }
    elementClickPolicy((ClickPolicy)localObject);
    if (paramReportPolicy.reportExposure) {
      localObject = ExposurePolicy.REPORT_ALL;
    } else {
      localObject = ExposurePolicy.REPORT_NONE;
    }
    elementExposePolicy((ExposurePolicy)localObject);
    if (paramReportPolicy.reportExposure) {
      localObject = EndExposurePolicy.REPORT_ALL;
    } else {
      localObject = EndExposurePolicy.REPORT_NONE;
    }
    elementEndExposePolicy((EndExposurePolicy)localObject);
    this.mElementReportPolicy = paramReportPolicy;
    return this;
  }
  
  public Builder elementScrollEndExposePolicy(EndExposurePolicy paramEndExposurePolicy)
  {
    this.mElementScrollEndExposePolicy = paramEndExposurePolicy;
    return this;
  }
  
  public Builder elementScrollExposePolicy(ExposurePolicy paramExposurePolicy)
  {
    this.mElementScrollExposePolicy = paramExposurePolicy;
    return this;
  }
  
  public Builder enablePageLink(boolean paramBoolean)
  {
    this.mEnablePageLink = paramBoolean;
    return this;
  }
  
  public Builder enableToast(boolean paramBoolean)
  {
    this.mEnableToast = paramBoolean;
    return this;
  }
  
  public Builder formatter(IFormatter paramIFormatter)
  {
    this.mFormatter = paramIFormatter;
    return this;
  }
  
  public Builder independentPageOut(boolean paramBoolean)
  {
    this.mIndependentPageOut = paramBoolean;
    return this;
  }
  
  public Builder lazyInitType(int paramInt)
  {
    this.mLazyInitType = paramInt;
    return this;
  }
  
  public Builder logger(ILogger paramILogger)
  {
    this.mLogger = paramILogger;
    return this;
  }
  
  public Builder pageExposureMinRate(double paramDouble)
  {
    if (paramDouble > 1.0D)
    {
      this.mPageExposureMinRate = 1.0D;
      return this;
    }
    if (paramDouble < 0.0D)
    {
      this.mPageExposureMinRate = 0.0D;
      return this;
    }
    this.mPageExposureMinRate = paramDouble;
    return this;
  }
  
  public Builder pageExposureMinTime(long paramLong)
  {
    if (paramLong < 0L)
    {
      this.mPageExposureMinTime = 0L;
      return this;
    }
    this.mPageExposureMinTime = paramLong;
    return this;
  }
  
  public Builder setVideoPageSwitch(int paramInt)
  {
    this.mVideoPageSwitch = paramInt;
    return this;
  }
  
  public Builder videoHeartBeatInterval(int paramInt)
  {
    this.mVideoHeartBeatInterval = paramInt;
    return this;
  }
  
  public Builder visitBackgroundTime(long paramLong)
  {
    if (paramLong < 0L)
    {
      this.mVisitBackgroundTime = 0L;
      return this;
    }
    this.mVisitBackgroundTime = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.Configuration.Builder
 * JD-Core Version:    0.7.0.1
 */