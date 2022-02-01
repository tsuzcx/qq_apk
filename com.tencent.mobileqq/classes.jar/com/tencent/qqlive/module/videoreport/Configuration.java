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
  private final long mClickReportInterval;
  private Configuration.Builder mConfigBuilder;
  private boolean mDefaultDataCollectEnable;
  private boolean mDefaultReportEnable;
  private final ClickPolicy mElementClickPolicy;
  private final EndExposurePolicy mElementEndExposePolicy;
  private final ExposurePolicy mElementExposePolicy;
  private final double mElementExposureMinRate;
  private final long mElementExposureMinTime;
  @Deprecated
  private final ReportPolicy mElementReportPolicy;
  private boolean mEnablePageLink;
  private final IFormatter mFormatter;
  private boolean mIndependentPageOut;
  private final ILogger mLogger;
  private final double mPageExposureMinRate;
  private final long mPageExposureMinTime;
  private final long mVisitBackgroundTime;
  
  private Configuration()
  {
    this(DEFAULT_BUILDER);
  }
  
  private Configuration(Configuration.Builder paramBuilder)
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
    if (Configuration.Builder.access$1300(paramBuilder) != null) {}
    for (Object localObject = Configuration.Builder.access$1300(paramBuilder);; localObject = new DTParamsNewsFlattenFormatter())
    {
      this.mFormatter = ((IFormatter)localObject);
      this.mIndependentPageOut = Configuration.Builder.access$1400(paramBuilder);
      this.mAppTimeReportHeartBeatInterval = Configuration.Builder.access$1500(paramBuilder);
      this.mAppTimeReportTimePinInterval = Configuration.Builder.access$1600(paramBuilder);
      this.mAudioReportHeartBeatInterval = Configuration.Builder.access$1700(paramBuilder);
      this.mAudioTimePinInterval = Configuration.Builder.access$1800(paramBuilder);
      this.mEnablePageLink = Configuration.Builder.access$1900(paramBuilder);
      return;
    }
  }
  
  public static Configuration.Builder builder()
  {
    return new Configuration.Builder();
  }
  
  public static Configuration getDefault()
  {
    if (sDefaultInstance == null) {}
    try
    {
      if (sDefaultInstance == null) {
        sDefaultInstance = new Configuration();
      }
      return sDefaultInstance;
    }
    finally {}
  }
  
  private boolean isDefaultReportEnable()
  {
    return this.mDefaultReportEnable;
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
    return Configuration.Builder.access$2000(this.mConfigBuilder);
  }
  
  public ILogger getLogger()
  {
    if (this.mLogger == null) {
      return DEFAULT_LOGGER;
    }
    return this.mLogger;
  }
  
  public double getPageExposureMinRate()
  {
    return this.mPageExposureMinRate;
  }
  
  public long getPageExposureMinTime()
  {
    return this.mPageExposureMinTime;
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
    StringBuilder localStringBuilder = new StringBuilder().append("Configuration{mDefaultReportEnable=").append(this.mDefaultReportEnable).append(", mDefaultDataCollectEnable=").append(this.mDefaultDataCollectEnable).append(", mVisitBackgroundTime=").append(this.mVisitBackgroundTime).append(", mPageExposureMinTime=").append(this.mPageExposureMinTime).append(", mPageExposureMinRate=").append(this.mPageExposureMinRate).append(", mElementExposureMinTime=").append(this.mElementExposureMinTime).append(", mElementExposureMinRate=").append(this.mElementExposureMinRate).append(", mElementReportPolicy=").append(this.mElementReportPolicy.name()).append(", mElementClickPolicy=").append(this.mElementClickPolicy).append(", mElementExposePolicy=").append(this.mElementExposePolicy).append(", mElementEndExposePolicy=").append(this.mElementEndExposePolicy).append(", mLogger=");
    if (this.mLogger != null) {}
    for (String str = this.mLogger.getClass().getName();; str = "null") {
      return str + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.Configuration
 * JD-Core Version:    0.7.0.1
 */