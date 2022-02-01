package com.tencent.qqlive.module.videoreport;

import android.app.Activity;
import android.app.Application;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ReportPolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.qqlive.module.videoreport.data.IElementDynamicParams;
import com.tencent.qqlive.module.videoreport.dtreport.api.DTConfig;
import com.tencent.qqlive.module.videoreport.dtreport.api.PageSearchMode;
import com.tencent.qqlive.module.videoreport.dtreport.audio.data.AudioDataManager;
import com.tencent.qqlive.module.videoreport.dtreport.audio.data.AudioEntity;
import com.tencent.qqlive.module.videoreport.dtreport.audio.data.IAudioDataManager;
import com.tencent.qqlive.module.videoreport.dtreport.stdevent.IEventParamsBuilder;
import com.tencent.qqlive.module.videoreport.dtreport.stdevent.StdEventCode;
import com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoBaseEntity;
import com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoEntity;
import com.tencent.qqlive.module.videoreport.inject.InjectHelper;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.page.IScrollReader;
import com.tencent.qqlive.module.videoreport.page.PageInfo;
import com.tencent.qqlive.module.videoreport.utils.IDetectionInterceptor;
import java.util.List;
import java.util.Map;

public class VideoReport
{
  public static void addReporter(IReporter paramIReporter)
  {
    VideoReportInner.getInstance().addReporter(paramIReporter);
  }
  
  public static void addToDetectionBlacklist(Activity paramActivity)
  {
    VideoReportInner.getInstance().addToDetectionBlacklist(paramActivity);
  }
  
  public static void addToDetectionWhitelist(Activity paramActivity)
  {
    VideoReportInner.getInstance().addToDetectionWhitelist(paramActivity);
  }
  
  public static void bindAudioPlayerInfo(Object paramObject, AudioEntity paramAudioEntity)
  {
    AudioDataManager.getInstance().bindAudioInfo(paramObject, paramAudioEntity);
  }
  
  public static void bindSubmitTarget(View paramView1, View paramView2)
  {
    VideoReportInner.getInstance().bindSubmitTarget(paramView1, paramView2);
  }
  
  public static void bindVideoPlayerInfo(@NonNull Object paramObject, VideoEntity paramVideoEntity)
  {
    VideoReportInner.getInstance().bindVideoPlayerInfo(paramObject, paramVideoEntity);
  }
  
  public static void clearElementExposure(View paramView, boolean paramBoolean)
  {
    VideoReportInner.getInstance().clearElementExposure(paramView, paramBoolean);
  }
  
  public static void clearPublicParams()
  {
    VideoReportInner.getInstance().clearPublicParams();
  }
  
  public static void doAppOutReport()
  {
    VideoReportInner.getInstance().doAppOutReport();
  }
  
  public static void enableScrollExposureReport(Object paramObject, boolean paramBoolean)
  {
    VideoReportInner.getInstance().enableScrollExposureReport(paramObject, paramBoolean);
  }
  
  public static PageInfo findOwnerPage(View paramView)
  {
    return VideoReportInner.getInstance().findOwnerPage(paramView);
  }
  
  public static ClickPolicy getElementClickPolicy(Object paramObject)
  {
    return VideoReportInner.getInstance().getElementClickPolicy(paramObject);
  }
  
  public static EndExposurePolicy getElementEndExposePolicy(Object paramObject)
  {
    return VideoReportInner.getInstance().getElementEndExposePolicy(paramObject);
  }
  
  public static ExposurePolicy getElementExposePolicy(Object paramObject)
  {
    return VideoReportInner.getInstance().getElementExposePolicy(paramObject);
  }
  
  @Deprecated
  public static Map<String, ?> getElementParams(Object paramObject)
  {
    return VideoReportInner.getInstance().getElementParams(paramObject);
  }
  
  @Deprecated
  public static ReportPolicy getElementReportPolicy(Object paramObject)
  {
    return VideoReportInner.getInstance().getElementReportPolicy(paramObject);
  }
  
  public static EndExposurePolicy getElementScrollEndExposePolicy(Object paramObject)
  {
    return VideoReportInner.getInstance().getElementScrollEndExposePolicy(paramObject);
  }
  
  public static ExposurePolicy getElementScrollExposePolicy(Object paramObject)
  {
    return VideoReportInner.getInstance().getElementScrollExposePolicy(paramObject);
  }
  
  public static PageInfo getPageInfo(View paramView)
  {
    return VideoReportInner.getInstance().getPageInfo(paramView);
  }
  
  public static void ignorePageInOutEvent(Object paramObject, boolean paramBoolean)
  {
    VideoReportInner.getInstance().ignorePageInOutEvent(paramObject, paramBoolean);
  }
  
  public static boolean isDebugMode()
  {
    return VideoReportInner.getInstance().isDebugMode();
  }
  
  public static boolean isInit()
  {
    return VideoReportInner.getInstance().isInit();
  }
  
  public static boolean isInjectSuccess()
  {
    return InjectHelper.isInjectSuccess();
  }
  
  public static void markAsPageBodyView(View paramView)
  {
    VideoReportInner.getInstance().markAsPageBodyView(paramView);
  }
  
  public static void markAsPageBodyView(View paramView, IScrollReader paramIScrollReader)
  {
    VideoReportInner.getInstance().markAsPageBodyView(paramView, paramIScrollReader);
  }
  
  public static void notifyViewDetach(View paramView1, View paramView2)
  {
    VideoReportInner.getInstance().notifyViewDetach(paramView1, paramView2);
  }
  
  @Nullable
  public static Map<String, Object> pageInfoForView(View paramView)
  {
    return VideoReportInner.getInstance().pageInfoForView("", paramView);
  }
  
  @Nullable
  public static Map<String, Object> pageInfoForView(String paramString, View paramView)
  {
    return VideoReportInner.getInstance().pageInfoForView(paramString, paramView);
  }
  
  public static void pageLogicDestroy(Object paramObject)
  {
    VideoReportInner.getInstance().pageLogicDestroy(paramObject);
  }
  
  @Deprecated
  @Nullable
  public static Map<String, Object> paramsForView(View paramView)
  {
    return VideoReportInner.getInstance().paramsForView("", paramView);
  }
  
  @Nullable
  public static Map<String, Object> paramsForView(String paramString, View paramView)
  {
    return VideoReportInner.getInstance().paramsForView(paramString, paramView);
  }
  
  public static void registerEventDynamicParams(IEventDynamicParams paramIEventDynamicParams)
  {
    VideoReportInner.getInstance().registerEventDynamicParams(paramIEventDynamicParams);
  }
  
  public static void registerSessionChangeListener(ISessionChangeListener paramISessionChangeListener)
  {
    VideoReportInner.getInstance().registerSessionChangeListener(paramISessionChangeListener);
  }
  
  @Deprecated
  public static void removeAllElementParams(Object paramObject)
  {
    VideoReportInner.getInstance().removeAllElementParams(paramObject);
  }
  
  @Deprecated
  public static void removeAllPageParams(Object paramObject)
  {
    VideoReportInner.getInstance().removeAllPageParams(paramObject);
  }
  
  public static void removeElementParam(Object paramObject, String paramString)
  {
    VideoReportInner.getInstance().removeElementParam(paramObject, paramString);
  }
  
  public static void removePageParam(Object paramObject, String paramString)
  {
    VideoReportInner.getInstance().removePageParam(paramObject, paramString);
  }
  
  public static void removePublicParam(String paramString)
  {
    VideoReportInner.getInstance().removePublicParam(paramString);
  }
  
  public static void reportEvent(String paramString, Object paramObject, Map<String, ?> paramMap)
  {
    VideoReportInner.getInstance().reportCustomEvent(paramString, paramObject, paramMap);
  }
  
  public static void reportEvent(String paramString, Map<String, ?> paramMap)
  {
    VideoReportInner.getInstance().reportCustomEvent(paramString, null, paramMap);
  }
  
  public static void reportStdEvent(StdEventCode paramStdEventCode, IEventParamsBuilder paramIEventParamsBuilder)
  {
    VideoReportInner.getInstance().reportStdEvent(paramStdEventCode, paramIEventParamsBuilder);
  }
  
  public static void resetElementParams(Object paramObject)
  {
    VideoReportInner.getInstance().resetElementParams(paramObject);
  }
  
  public static void resetPageParams(Object paramObject)
  {
    VideoReportInner.getInstance().resetPageParams(paramObject);
  }
  
  public static void resetPageStats()
  {
    VideoReportInner.getInstance().resetPageStats();
  }
  
  public static void setClickReportInterval(View paramView, long paramLong)
  {
    VideoReportInner.getInstance().setClickReportInterval(paramView, paramLong);
  }
  
  public static void setCollectProcessName(boolean paramBoolean)
  {
    VideoReportInner.getInstance().setCollectProcessName(paramBoolean);
  }
  
  public static void setDataCollectEnable(boolean paramBoolean)
  {
    VideoReportInner.getInstance().setDataCollectEnable(paramBoolean);
  }
  
  public static void setDebugMode(boolean paramBoolean)
  {
    VideoReportInner.getInstance().setDebugMode(paramBoolean);
  }
  
  public static void setDetectionInterceptor(IDetectionInterceptor paramIDetectionInterceptor)
  {
    VideoReportInner.getInstance().setDetectionInterceptor(paramIDetectionInterceptor);
  }
  
  public static void setDetectionMode(@DetectionMode int paramInt)
  {
    VideoReportInner.getInstance().setDetectionMode(paramInt);
  }
  
  public static void setElementClickPolicy(Object paramObject, ClickPolicy paramClickPolicy)
  {
    VideoReportInner.getInstance().setElementClickPolicy(paramObject, paramClickPolicy);
  }
  
  @Deprecated
  public static void setElementDynamicParams(Object paramObject, IElementDynamicParams paramIElementDynamicParams)
  {
    VideoReportInner.getInstance().setElementDynamicParams(paramObject, paramIElementDynamicParams);
  }
  
  public static void setElementEndExposePolicy(Object paramObject, EndExposurePolicy paramEndExposurePolicy)
  {
    VideoReportInner.getInstance().setElementEndExposePolicy(paramObject, paramEndExposurePolicy);
  }
  
  public static void setElementExposePolicy(Object paramObject, ExposurePolicy paramExposurePolicy)
  {
    VideoReportInner.getInstance().setElementExposePolicy(paramObject, paramExposurePolicy);
  }
  
  public static void setElementExposureDetectionEnabled(View paramView, boolean paramBoolean)
  {
    VideoReportInner.getInstance().setElementExposureDetectionEnabled(paramView, paramBoolean);
  }
  
  public static void setElementExposureMinRate(Object paramObject, double paramDouble)
  {
    VideoReportInner.getInstance().setElementExposureMinRate(paramObject, paramDouble);
  }
  
  public static void setElementExposureMinTime(Object paramObject, long paramLong)
  {
    VideoReportInner.getInstance().setElementExposureMinTime(paramObject, paramLong);
  }
  
  public static void setElementId(Object paramObject, String paramString)
  {
    VideoReportInner.getInstance().setElementId(paramObject, paramString);
  }
  
  public static void setElementParam(Object paramObject1, String paramString, Object paramObject2)
  {
    VideoReportInner.getInstance().setElementParam(paramObject1, paramString, paramObject2);
  }
  
  public static void setElementParams(Object paramObject, Map<String, ?> paramMap)
  {
    VideoReportInner.getInstance().setElementParams(paramObject, paramMap);
  }
  
  @Deprecated
  public static void setElementReportPolicy(Object paramObject, ReportPolicy paramReportPolicy)
  {
    VideoReportInner.getInstance().setElementReportPolicy(paramObject, paramReportPolicy);
  }
  
  public static void setElementReuseIdentifier(Object paramObject, String paramString)
  {
    VideoReportInner.getInstance().setElementReuseIdentifier(paramObject, paramString);
  }
  
  public static void setElementScrollEndExposePolicy(Object paramObject, EndExposurePolicy paramEndExposurePolicy)
  {
    VideoReportInner.getInstance().setElementScrollEndExposePolicy(paramObject, paramEndExposurePolicy);
  }
  
  public static void setElementScrollExposePolicy(Object paramObject, ExposurePolicy paramExposurePolicy)
  {
    VideoReportInner.getInstance().setElementScrollExposePolicy(paramObject, paramExposurePolicy);
  }
  
  public static void setElementVirtualParentParams(Object paramObject, int paramInt, String paramString, Map<String, Object> paramMap)
  {
    VideoReportInner.getInstance().setElementVirtualParentParams(paramObject, paramInt, paramString, paramMap);
  }
  
  public static void setEventAdditionalReport(IAdditionalReportListener paramIAdditionalReportListener)
  {
    VideoReportInner.getInstance().setEventAdditionalReport(paramIAdditionalReportListener);
  }
  
  public static void setEventDynamicParams(Object paramObject, @Nullable IDynamicParams paramIDynamicParams)
  {
    VideoReportInner.getInstance().setEventDynamicParams(paramObject, paramIDynamicParams);
  }
  
  public static void setLogicParent(View paramView1, View paramView2)
  {
    VideoReportInner.getInstance().setLogicParent(paramView1, paramView2);
  }
  
  public static void setPageBodyContentRange(View paramView, int paramInt1, int paramInt2)
  {
    VideoReportInner.getInstance().setPageBodyContentRange(paramView, paramInt1, paramInt2);
  }
  
  public static void setPageContentId(Object paramObject, String paramString)
  {
    VideoReportInner.getInstance().setPageContentId(paramObject, paramString);
  }
  
  public static void setPageContentId(Object paramObject, String paramString, boolean paramBoolean)
  {
    VideoReportInner.getInstance().setPageContentId(paramObject, paramString, paramBoolean);
  }
  
  public static void setPageId(Object paramObject, String paramString)
  {
    VideoReportInner.getInstance().setPageId(paramObject, paramString);
  }
  
  public static void setPageParams(Object paramObject, PageParams paramPageParams)
  {
    VideoReportInner.getInstance().setPageParams(paramObject, paramPageParams);
  }
  
  public static void setPageParams(Object paramObject1, String paramString, Object paramObject2)
  {
    VideoReportInner.getInstance().setPageParams(paramObject1, paramString, paramObject2);
  }
  
  public static void setPageSearchMode(Object paramObject, @PageSearchMode int paramInt)
  {
    VideoReportInner.getInstance().setPageSearchMode(paramObject, paramInt);
  }
  
  public static void setPublicParam(String paramString, Object paramObject)
  {
    VideoReportInner.getInstance().setPublicParam(paramString, paramObject);
  }
  
  @Deprecated
  public static void setVideoReportConfig(@NonNull DTConfig paramDTConfig)
  {
    VideoReportInner.getInstance().setVideoReportConfig(paramDTConfig);
  }
  
  public static void startNewSession(SessionChangeReason paramSessionChangeReason)
  {
    VideoReportInner.getInstance().startNewSession(paramSessionChangeReason);
  }
  
  public static void startWithComponent(Application paramApplication, IVideoReportComponent paramIVideoReportComponent)
  {
    VideoReportInner.getInstance().startWithComponent(paramApplication, paramIVideoReportComponent);
  }
  
  public static void startWithConfiguration(Application paramApplication, Configuration paramConfiguration)
  {
    VideoReportInner.getInstance().startWithConfiguration(paramApplication, paramConfiguration);
  }
  
  public static void supportNewPlayType(boolean paramBoolean)
  {
    VideoReportInner.getInstance().supportNewPlayType(paramBoolean);
  }
  
  public static void supportPlayerReport(boolean paramBoolean)
  {
    VideoReportInner.getInstance().supportPlayerReport(paramBoolean);
  }
  
  public static void supportSeekReport(boolean paramBoolean)
  {
    VideoReportInner.getInstance().supportSeekReport(paramBoolean);
  }
  
  public static void supportSpeedRatioReport(boolean paramBoolean)
  {
    VideoReportInner.getInstance().supportSpeedRatioReport(paramBoolean);
  }
  
  public static void supportWebViewReport(boolean paramBoolean)
  {
    VideoReportInner.getInstance().supportWebViewReport(paramBoolean);
  }
  
  public static void traverseExposure()
  {
    VideoReportInner.getInstance().traverseExposure();
  }
  
  public static void traversePage(View paramView)
  {
    VideoReportInner.getInstance().traversePage(paramView);
  }
  
  public static void triggerClickInCurrentPage(Map<String, Object> paramMap)
  {
    VideoReportInner.getInstance().triggerClickInCurrentPage(paramMap);
  }
  
  public static void triggerEventInCurrentPage(String paramString, Map<String, Object> paramMap)
  {
    VideoReportInner.getInstance().triggerEventInCurrentPage(paramString, paramMap);
  }
  
  public static void triggerExposureInCurrentPage(List<Map<String, Object>> paramList)
  {
    VideoReportInner.getInstance().triggerExposureInCurrentPage(paramList);
  }
  
  public static void unbindVideoPlayerInfo(@NonNull Object paramObject)
  {
    VideoReportInner.getInstance().unbindVideoPlayerInfo(paramObject);
  }
  
  public static void updateConfiguration(Configuration paramConfiguration)
  {
    VideoReportInner.getInstance().updateConfiguration(paramConfiguration);
  }
  
  public static void updateVideoPlayerInfo(@NonNull Object paramObject, @NonNull VideoBaseEntity paramVideoBaseEntity)
  {
    VideoReportInner.getInstance().updateVideoPlayerInfo(paramObject, paramVideoBaseEntity);
  }
  
  @Deprecated
  @Nullable
  public static Map<String, Object> viewTreeParamsForView(View paramView)
  {
    return VideoReportInner.getInstance().viewTreeParamsForView("", paramView);
  }
  
  @Nullable
  public static Map<String, Object> viewTreeParamsForView(String paramString, View paramView)
  {
    return VideoReportInner.getInstance().viewTreeParamsForView(paramString, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.VideoReport
 * JD-Core Version:    0.7.0.1
 */