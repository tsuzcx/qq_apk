package com.tencent.qqlive.module.videoreport.inner;

import android.app.Activity;
import android.app.Application;
import android.support.annotation.Nullable;
import android.view.View;
import com.tencent.qqlive.module.videoreport.Configuration;
import com.tencent.qqlive.module.videoreport.DetectionMode;
import com.tencent.qqlive.module.videoreport.IAdditionalReportListener;
import com.tencent.qqlive.module.videoreport.IEventDynamicParams;
import com.tencent.qqlive.module.videoreport.IInnerReporter;
import com.tencent.qqlive.module.videoreport.IReporter;
import com.tencent.qqlive.module.videoreport.ISessionChangeListener;
import com.tencent.qqlive.module.videoreport.IVideoReportComponent;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.SessionChangeReason;
import com.tencent.qqlive.module.videoreport.constants.ReportPolicy;
import com.tencent.qqlive.module.videoreport.dtreport.stdevent.IEventParamsBuilder;
import com.tencent.qqlive.module.videoreport.dtreport.stdevent.StdEventCode;
import com.tencent.qqlive.module.videoreport.page.IScrollReader;
import com.tencent.qqlive.module.videoreport.page.PageInfo;
import com.tencent.qqlive.module.videoreport.utils.IDetectionInterceptor;
import java.util.List;
import java.util.Map;

public abstract interface IVideoReport
{
  public abstract void addInnerReporter(IInnerReporter paramIInnerReporter);
  
  public abstract void addReporter(IReporter paramIReporter);
  
  public abstract void addToDetectionBlacklist(Activity paramActivity);
  
  public abstract void addToDetectionWhitelist(Activity paramActivity);
  
  public abstract void clearElementExposure(View paramView, boolean paramBoolean);
  
  public abstract void clearPublicParams();
  
  public abstract void doAppOutReport();
  
  public abstract PageInfo findOwnerPage(View paramView);
  
  public abstract ReportPolicy getElementReportPolicy(Object paramObject);
  
  public abstract void ignorePageInOutEvent(Object paramObject, boolean paramBoolean);
  
  public abstract boolean isDebugMode();
  
  public abstract void markAsPageBodyView(View paramView);
  
  public abstract void markAsPageBodyView(View paramView, IScrollReader paramIScrollReader);
  
  public abstract void notifyViewDetach(View paramView1, View paramView2);
  
  @Nullable
  public abstract Map<String, Object> pageInfoForView(View paramView);
  
  public abstract void pageLogicDestroy(Object paramObject);
  
  @Nullable
  public abstract Map<String, Object> paramsForView(View paramView);
  
  public abstract void registerEventDynamicParams(IEventDynamicParams paramIEventDynamicParams);
  
  public abstract void registerSessionChangeListener(ISessionChangeListener paramISessionChangeListener);
  
  @Deprecated
  public abstract void removeAllElementParams(Object paramObject);
  
  public abstract void removeAllPageParams(Object paramObject);
  
  public abstract void removeElementParam(Object paramObject, String paramString);
  
  public abstract void removePageParam(Object paramObject, String paramString);
  
  public abstract void removePublicParam(String paramString);
  
  public abstract void reportEvent(String paramString, Object paramObject, Map<String, ?> paramMap);
  
  public abstract void reportEvent(String paramString, Map<String, ?> paramMap);
  
  public abstract void reportEventWithoutFormat(String paramString1, Map<String, Object> paramMap, String paramString2);
  
  public abstract void reportStdEvent(StdEventCode paramStdEventCode, IEventParamsBuilder paramIEventParamsBuilder);
  
  public abstract void resetElementParams(Object paramObject);
  
  public abstract void resetPageParams(Object paramObject);
  
  public abstract void resetPageStats();
  
  public abstract void setClickReportInterval(View paramView, long paramLong);
  
  public abstract void setDataCollectEnable(boolean paramBoolean);
  
  public abstract void setDebugMode(boolean paramBoolean);
  
  public abstract void setDetectionInterceptor(IDetectionInterceptor paramIDetectionInterceptor);
  
  public abstract void setDetectionMode(@DetectionMode int paramInt);
  
  public abstract void setElementExposureDetectionEnabled(Object paramObject, boolean paramBoolean);
  
  public abstract void setElementExposureMinRate(Object paramObject, double paramDouble);
  
  public abstract void setElementExposureMinTime(Object paramObject, long paramLong);
  
  public abstract void setElementId(Object paramObject, String paramString);
  
  public abstract void setElementParam(Object paramObject1, String paramString, Object paramObject2);
  
  public abstract void setElementParams(Object paramObject, Map<String, ?> paramMap);
  
  public abstract void setElementReportPolicy(Object paramObject, ReportPolicy paramReportPolicy);
  
  public abstract void setElementReuseIdentifier(Object paramObject, String paramString);
  
  public abstract void setEventAdditionalReport(IAdditionalReportListener paramIAdditionalReportListener);
  
  public abstract void setLogicParent(View paramView1, View paramView2);
  
  public abstract void setPageBodyContentRange(View paramView, int paramInt1, int paramInt2);
  
  public abstract void setPageContentId(Object paramObject, String paramString);
  
  public abstract void setPageId(Object paramObject, String paramString);
  
  public abstract void setPageParams(Object paramObject, PageParams paramPageParams);
  
  public abstract void setPageParams(Object paramObject1, String paramString, Object paramObject2);
  
  public abstract void setPublicParam(String paramString, Object paramObject);
  
  public abstract void setTestMode(boolean paramBoolean);
  
  public abstract void startNewSession(SessionChangeReason paramSessionChangeReason);
  
  public abstract void startWithComponent(Application paramApplication, IVideoReportComponent paramIVideoReportComponent);
  
  public abstract void startWithConfiguration(Application paramApplication, Configuration paramConfiguration);
  
  public abstract void traverseExposure();
  
  public abstract void traversePage(View paramView);
  
  public abstract void triggerClickInCurrentPage(Map<String, Object> paramMap);
  
  public abstract void triggerEventInCurrentPage(String paramString, Map<String, Object> paramMap);
  
  public abstract void triggerExposureInCurrentPage(List<Map<String, Object>> paramList);
  
  @Nullable
  public abstract Map<String, Object> viewTreeParamsForView(View paramView);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.inner.IVideoReport
 * JD-Core Version:    0.7.0.1
 */