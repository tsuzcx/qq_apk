package com.tencent.qqlive.module.videoreport.dtreport;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.qqlive.module.videoreport.Configuration;
import com.tencent.qqlive.module.videoreport.Configuration.Builder;
import com.tencent.qqlive.module.videoreport.IVideoReportComponent;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.api.IDTParamProvider;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConfigConstants.ElementFormatMode;
import com.tencent.qqlive.module.videoreport.dtreport.formatter.DTParamsFlattenFormatter;
import com.tencent.qqlive.module.videoreport.dtreport.formatter.DTParamsNewsFlattenFormatter;
import com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler.DTHandleEventFormatFactory;
import com.tencent.qqlive.module.videoreport.dtreport.reportchannel.DTAdditionalReportHandler;
import com.tencent.qqlive.module.videoreport.dtreport.reportchannel.DTDebugChannel;
import com.tencent.qqlive.module.videoreport.dtreport.reportchannel.DTEventDynamicParams;
import com.tencent.qqlive.module.videoreport.dtreport.reportchannel.DTReportChannel;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.utils.IFormatter;

public class DTReportComponent
  implements IVideoReportComponent
{
  private static final String TAG = "DTReportComponent";
  private static final long VISIT_BACKGROUND_TIME = 900000L;
  private Configuration mConfiguration;
  
  private DTReportComponent(DTReportComponent.Builder paramBuilder)
  {
    DTHandleEventFormatFactory.setElementFormatMode(DTReportComponent.Builder.access$000(paramBuilder));
    DTReportChannel.getInstance().setReport(DTReportComponent.Builder.access$100(paramBuilder));
    DTEventDynamicParams.getInstance().setDTCommonParams(DTReportComponent.Builder.access$200(paramBuilder));
    this.mConfiguration = createDefaultConfiguration(paramBuilder);
    initVideoReport(paramBuilder);
    if (VideoReportInner.getInstance().isDebugMode())
    {
      paramBuilder = checkInputs();
      if (!TextUtils.isEmpty(paramBuilder)) {
        throw new RuntimeException(paramBuilder);
      }
    }
  }
  
  public static DTReportComponent.Builder builder(@NonNull IDTParamProvider paramIDTParamProvider)
  {
    return new DTReportComponent.Builder(paramIDTParamProvider);
  }
  
  private Configuration createDefaultConfiguration(DTReportComponent.Builder paramBuilder)
  {
    return DTReportComponent.Builder.access$400(paramBuilder).visitBackgroundTime(900000L).formatter(getFormatter(DTReportComponent.Builder.access$000(paramBuilder))).enablePageLink(DTReportComponent.Builder.access$300(paramBuilder)).build();
  }
  
  private IFormatter getFormatter(@DTConfigConstants.ElementFormatMode int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return new DTParamsFlattenFormatter();
    }
    return new DTParamsNewsFlattenFormatter();
  }
  
  private void initVideoReport(DTReportComponent.Builder paramBuilder)
  {
    VideoReport.setDebugMode(DTReportComponent.Builder.access$500(paramBuilder));
    VideoReport.addReporter(DTReportChannel.getInstance());
    VideoReportInner.getInstance().addInnerReporter(DTReportChannel.getInstance());
    if (DTReportComponent.Builder.access$500(paramBuilder)) {
      VideoReportInner.getInstance().addReporter(new DTDebugChannel());
    }
    VideoReport.registerEventDynamicParams(DTEventDynamicParams.getInstance());
    VideoReport.setEventAdditionalReport(DTAdditionalReportHandler.getInstance());
  }
  
  String checkInputs()
  {
    if (this.mConfiguration == null) {
      return "config is null";
    }
    if (this.mConfiguration.getAudioTimePinInterval() < 5) {
      return "AudioTimePinInterval value below 5s, may cause performance issues";
    }
    if (this.mConfiguration.getAudioReportHearBeatInterval() < this.mConfiguration.getAudioTimePinInterval()) {
      return "AudioReportHeartBeatInterval can not be less than audioTimePinInterval";
    }
    if (this.mConfiguration.getAppTimeReportTimePinInterval() < 5) {
      return "AppTimeReportTimePinInterval value below 5s, may cause performance issues";
    }
    if (this.mConfiguration.getAppTimeReportHeartBeatInterval() < this.mConfiguration.getAppTimeReportTimePinInterval()) {
      return "AppReportHeartBeatInterval can not be less than appTimePinInterval";
    }
    return "";
  }
  
  public Configuration getConfiguration()
  {
    return this.mConfiguration;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.DTReportComponent
 * JD-Core Version:    0.7.0.1
 */