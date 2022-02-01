package com.tencent.qqlive.module.videoreport;

import android.support.annotation.NonNull;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ReportPolicy;
import com.tencent.qqlive.module.videoreport.dtreport.formatter.DTParamsNewsFlattenFormatter;
import com.tencent.qqlive.module.videoreport.inner.DefaultLogger;
import com.tencent.qqlive.module.videoreport.utils.IFormatter;

public class Configuration
{
  private static final Configuration.Builder DEFAULT_BUILDER = new Configuration.Builder();
  private static final DefaultLogger DEFAULT_LOGGER = new DefaultLogger();
  private static final String TAG = "Configuration";
  private static volatile Configuration sDefaultInstance;
  private int mAppTimeReportHeartBeatInterval;
  private int mAppTimeReportTimePinInterval;
  private int mAudioReportHeartBeatInterval;
  private int mAudioTimePinInterval;
  private long mClickReportInterval;
  private Configuration.Builder mConfigBuilder;
  private Configuration.Builder mCurrentBuilder = DEFAULT_BUILDER;
  private boolean mDefaultDataCollectEnable;
  private boolean mDefaultReportEnable;
  private ClickPolicy mElementClickPolicy;
  private EndExposurePolicy mElementEndExposePolicy;
  private ExposurePolicy mElementExposePolicy;
  private double mElementExposureMinRate;
  private long mElementExposureMinTime;
  @Deprecated
  private ReportPolicy mElementReportPolicy;
  private boolean mEnablePageLink;
  private boolean mEnableToast;
  private IFormatter mFormatter;
  private boolean mIndependentPageOut;
  private ILogger mLogger;
  private double mPageExposureMinRate;
  private long mPageExposureMinTime;
  private int mVideoHeartBeatInterval;
  private int mVideoPageSwitch = 0;
  private long mVisitBackgroundTime;
  
  private Configuration()
  {
    this(DEFAULT_BUILDER);
  }
  
  private Configuration(Configuration.Builder paramBuilder)
  {
    setConfig(paramBuilder);
  }
  
  public static Configuration.Builder builder()
  {
    return new Configuration.Builder();
  }
  
  public static Configuration getDefault()
  {
    if (sDefaultInstance == null) {
      try
      {
        if (sDefaultInstance == null) {
          sDefaultInstance = new Configuration();
        }
      }
      finally {}
    }
    return sDefaultInstance;
  }
  
  private boolean isDefaultReportEnable()
  {
    return this.mDefaultReportEnable;
  }
  
  private void setConfig(Configuration.Builder paramBuilder)
  {
    this.mConfigBuilder = paramBuilder;
    this.mDefaultReportEnable = Configuration.Builder.access$000(paramBuilder);
    this.mDefaultDataCollectEnable = Configuration.Builder.access$100(paramBuilder);
    this.mVisitBackgroundTime = Configuration.Builder.access$200(paramBuilder);
    this.mPageExposureMinTime = Configuration.Builder.access$300(paramBuilder);
    this.mPageExposureMinRate = Configuration.Builder.access$400(paramBuilder);
    this.mElementExposureMinTime = Configuration.Builder.access$500(paramBuilder);
    this.mElementExposureMinRate = Configuration.Builder.access$600(paramBuilder);
    this.mClickReportInterval = Configuration.Builder.access$700(paramBuilder);
    this.mElementReportPolicy = Configuration.Builder.access$800(paramBuilder);
    this.mElementClickPolicy = Configuration.Builder.access$900(paramBuilder);
    this.mElementExposePolicy = Configuration.Builder.access$1000(paramBuilder);
    this.mElementEndExposePolicy = Configuration.Builder.access$1100(paramBuilder);
    this.mLogger = Configuration.Builder.access$1200(paramBuilder);
    Object localObject;
    if (Configuration.Builder.access$1300(paramBuilder) != null) {
      localObject = Configuration.Builder.access$1300(paramBuilder);
    } else {
      localObject = new DTParamsNewsFlattenFormatter();
    }
    this.mFormatter = ((IFormatter)localObject);
    this.mIndependentPageOut = Configuration.Builder.access$1400(paramBuilder);
    this.mAppTimeReportHeartBeatInterval = Configuration.Builder.access$1500(paramBuilder);
    this.mAppTimeReportTimePinInterval = Configuration.Builder.access$1600(paramBuilder);
    this.mAudioReportHeartBeatInterval = Configuration.Builder.access$1700(paramBuilder);
    this.mAudioTimePinInterval = Configuration.Builder.access$1800(paramBuilder);
    this.mVideoHeartBeatInterval = Configuration.Builder.access$1900(paramBuilder);
    this.mEnablePageLink = Configuration.Builder.access$2000(paramBuilder);
    this.mVideoPageSwitch = Configuration.Builder.access$2100(paramBuilder);
    this.mEnableToast = Configuration.Builder.access$2200(paramBuilder);
    this.mCurrentBuilder = paramBuilder;
  }
  
  private void setDefaultReportEnable(boolean paramBoolean)
  {
    this.mDefaultReportEnable = paramBoolean;
  }
  
  public int getAppTimeReportHeartBeatInterval()
  {
    return this.mAppTimeReportHeartBeatInterval;
  }
  
  public int getAppTimeReportTimePinInterval()
  {
    return this.mAppTimeReportTimePinInterval;
  }
  
  public int getAudioReportHearBeatInterval()
  {
    return this.mAudioReportHeartBeatInterval;
  }
  
  public int getAudioTimePinInterval()
  {
    return this.mAudioTimePinInterval;
  }
  
  public long getClickReportInterval()
  {
    return this.mClickReportInterval;
  }
  
  public Configuration.Builder getCurrentBuilder()
  {
    return this.mCurrentBuilder;
  }
  
  public ClickPolicy getElementClickPolicy()
  {
    return this.mElementClickPolicy;
  }
  
  public EndExposurePolicy getElementEndExposePolicy()
  {
    return this.mElementEndExposePolicy;
  }
  
  public ExposurePolicy getElementExposePolicy()
  {
    return this.mElementExposePolicy;
  }
  
  public double getElementExposureMinRate()
  {
    return this.mElementExposureMinRate;
  }
  
  public long getElementExposureMinTime()
  {
    return this.mElementExposureMinTime;
  }
  
  @Deprecated
  public ReportPolicy getElementReportPolicy()
  {
    return this.mElementReportPolicy;
  }
  
  @NonNull
  public IFormatter getFormatter()
  {
    return this.mFormatter;
  }
  
  public int getLazyInitType()
  {
    return Configuration.Builder.access$2300(this.mConfigBuilder);
  }
  
  public ILogger getLogger()
  {
    ILogger localILogger = this.mLogger;
    Object localObject = localILogger;
    if (localILogger == null) {
      localObject = DEFAULT_LOGGER;
    }
    return localObject;
  }
  
  public double getPageExposureMinRate()
  {
    return this.mPageExposureMinRate;
  }
  
  public long getPageExposureMinTime()
  {
    return this.mPageExposureMinTime;
  }
  
  public int getVideoHeartBeatInterval()
  {
    return this.mVideoHeartBeatInterval;
  }
  
  public int getVideoPageSwitch()
  {
    return this.mVideoPageSwitch;
  }
  
  public long getVisitBackgroundTime()
  {
    return this.mVisitBackgroundTime;
  }
  
  public boolean isDefaultDataCollectEnable()
  {
    return this.mDefaultDataCollectEnable;
  }
  
  public boolean isEnablePageLink()
  {
    return this.mEnablePageLink;
  }
  
  public boolean isEnableToast()
  {
    return this.mEnableToast;
  }
  
  public boolean isIndependentPageOut()
  {
    return this.mIndependentPageOut;
  }
  
  public void setDefaultDataCollectEnable(boolean paramBoolean)
  {
    this.mDefaultDataCollectEnable = paramBoolean;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Configuration{mDefaultReportEnable=");
    localStringBuilder.append(this.mDefaultReportEnable);
    localStringBuilder.append(", mDefaultDataCollectEnable=");
    localStringBuilder.append(this.mDefaultDataCollectEnable);
    localStringBuilder.append(", mVisitBackgroundTime=");
    localStringBuilder.append(this.mVisitBackgroundTime);
    localStringBuilder.append(", mPageExposureMinTime=");
    localStringBuilder.append(this.mPageExposureMinTime);
    localStringBuilder.append(", mPageExposureMinRate=");
    localStringBuilder.append(this.mPageExposureMinRate);
    localStringBuilder.append(", mElementExposureMinTime=");
    localStringBuilder.append(this.mElementExposureMinTime);
    localStringBuilder.append(", mElementExposureMinRate=");
    localStringBuilder.append(this.mElementExposureMinRate);
    localStringBuilder.append(", mElementReportPolicy=");
    localStringBuilder.append(this.mElementReportPolicy.name());
    localStringBuilder.append(", mElementClickPolicy=");
    localStringBuilder.append(this.mElementClickPolicy);
    localStringBuilder.append(", mElementExposePolicy=");
    localStringBuilder.append(this.mElementExposePolicy);
    localStringBuilder.append(", mElementEndExposePolicy=");
    localStringBuilder.append(this.mElementEndExposePolicy);
    localStringBuilder.append(", mLogger=");
    Object localObject = this.mLogger;
    if (localObject != null) {
      localObject = localObject.getClass().getName();
    } else {
      localObject = "null";
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void update(@NonNull Configuration paramConfiguration)
  {
    setConfig(paramConfiguration.getCurrentBuilder());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.Configuration
 * JD-Core Version:    0.7.0.1
 */