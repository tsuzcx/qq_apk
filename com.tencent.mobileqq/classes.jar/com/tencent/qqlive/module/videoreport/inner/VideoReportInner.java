package com.tencent.qqlive.module.videoreport.inner;

import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.qqlive.module.videoreport.Configuration;
import com.tencent.qqlive.module.videoreport.Configuration.Builder;
import com.tencent.qqlive.module.videoreport.DetectionMode;
import com.tencent.qqlive.module.videoreport.IAdditionalReportListener;
import com.tencent.qqlive.module.videoreport.IEventDynamicParams;
import com.tencent.qqlive.module.videoreport.IInnerReporter;
import com.tencent.qqlive.module.videoreport.IReporter;
import com.tencent.qqlive.module.videoreport.ISessionChangeListener;
import com.tencent.qqlive.module.videoreport.IVideoReportComponent;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.SessionChangeReason;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ReportPolicy;
import com.tencent.qqlive.module.videoreport.data.DataRWProxy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.qqlive.module.videoreport.data.IElementDynamicParams;
import com.tencent.qqlive.module.videoreport.detection.DetectionInterceptors;
import com.tencent.qqlive.module.videoreport.detection.DetectionPolicy;
import com.tencent.qqlive.module.videoreport.dtreport.api.DTConfig;
import com.tencent.qqlive.module.videoreport.dtreport.audio.AudioEventReporter;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConfigConstants;
import com.tencent.qqlive.module.videoreport.dtreport.stdevent.IEventParamsBuilder;
import com.tencent.qqlive.module.videoreport.dtreport.stdevent.StdEventCode;
import com.tencent.qqlive.module.videoreport.dtreport.stdevent.StdEventParamChecker;
import com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoBaseEntity;
import com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoEntity;
import com.tencent.qqlive.module.videoreport.dtreport.video.logic.VideoPageReporter;
import com.tencent.qqlive.module.videoreport.dtreport.video.logic.VideoReportManager;
import com.tencent.qqlive.module.videoreport.lazy.LazyInitObserver;
import com.tencent.qqlive.module.videoreport.page.IScrollReader;
import com.tencent.qqlive.module.videoreport.page.PageBodyStatistician;
import com.tencent.qqlive.module.videoreport.page.PageFinder;
import com.tencent.qqlive.module.videoreport.page.PageInfo;
import com.tencent.qqlive.module.videoreport.page.PageInfoCacheController;
import com.tencent.qqlive.module.videoreport.page.PageManager;
import com.tencent.qqlive.module.videoreport.page.PageSwitchObserver;
import com.tencent.qqlive.module.videoreport.page.PageUtils;
import com.tencent.qqlive.module.videoreport.page.ViewContainerBinder;
import com.tencent.qqlive.module.videoreport.report.AppEventReporter;
import com.tencent.qqlive.module.videoreport.report.FinalDataTarget;
import com.tencent.qqlive.module.videoreport.report.PageReporter;
import com.tencent.qqlive.module.videoreport.report.element.ElementClickReporter;
import com.tencent.qqlive.module.videoreport.report.element.ElementExposureEndReporter;
import com.tencent.qqlive.module.videoreport.report.element.ElementExposureReporter;
import com.tencent.qqlive.module.videoreport.report.element.ExposureElementInfo;
import com.tencent.qqlive.module.videoreport.report.element.ExposurePolicyHelper;
import com.tencent.qqlive.module.videoreport.report.element.IExposureRecorder;
import com.tencent.qqlive.module.videoreport.report.element.IExposureRecorder.Factory;
import com.tencent.qqlive.module.videoreport.report.element.ReportPolicyOperator;
import com.tencent.qqlive.module.videoreport.report.element.ReversedDataCollector;
import com.tencent.qqlive.module.videoreport.report.scroll.ScrollableViewObserver;
import com.tencent.qqlive.module.videoreport.reportdata.DataBuilderFactory;
import com.tencent.qqlive.module.videoreport.reportdata.FinalData;
import com.tencent.qqlive.module.videoreport.reportdata.IDataBuilder;
import com.tencent.qqlive.module.videoreport.reportdata.PathData;
import com.tencent.qqlive.module.videoreport.staging.CustomEventStagingManager;
import com.tencent.qqlive.module.videoreport.task.ThreadUtils;
import com.tencent.qqlive.module.videoreport.trace.SimpleTracer;
import com.tencent.qqlive.module.videoreport.traversal.ViewGroupDrawingCompat;
import com.tencent.qqlive.module.videoreport.utils.IDetectionInterceptor;
import com.tencent.qqlive.module.videoreport.utils.ListenerMgr;
import com.tencent.qqlive.module.videoreport.utils.ReportUtils;
import com.tencent.qqlive.module.videoreport.utils.ReusablePool;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class VideoReportInner
  implements IVideoReport
{
  private static final String TAG = "VideoReportInner";
  private volatile boolean isInit;
  private Configuration mConfiguration;
  private boolean mDebugMode;
  private IEventDynamicParams mEventDynamicParams;
  private Set<IInnerReporter> mInnerReporters = new HashSet();
  private PageInfoCacheController mPageInfoCacheCtrl = new PageInfoCacheController();
  private Map<String, Object> mPublicParam;
  private Set<IReporter> mReporters = new HashSet();
  private boolean mTestMode;
  private Collection<IReporter> mUnmodifiableReporters = Collections.unmodifiableCollection(this.mReporters);
  
  private boolean checkPageObjectArgument(Object paramObject)
  {
    return (checkElementObjectArgument(paramObject)) || ((paramObject instanceof Activity));
  }
  
  private boolean checkTrackObjectArgument(Object paramObject)
  {
    return (checkElementObjectArgument(paramObject)) || ((paramObject instanceof Activity));
  }
  
  private void clearElementExposureInner(View paramView, boolean paramBoolean)
  {
    if (paramView == null) {
      return;
    }
    long l = ReportUtils.calcElementUniqueId(paramView);
    IExposureRecorder.Factory.getInstance().markUnexposed(l);
    if ((paramBoolean) && ((paramView instanceof ViewGroup)))
    {
      paramView = (ViewGroup)paramView;
      int i = paramView.getChildCount() - 1;
      while (i >= 0)
      {
        clearElementExposureInner(paramView.getChildAt(i), true);
        i -= 1;
      }
    }
  }
  
  private boolean elementReport(String paramString, View paramView, Map<String, ?> paramMap)
  {
    PathData localPathData = ReversedDataCollector.collect(paramView);
    if (localPathData == null) {
      return false;
    }
    FinalData localFinalData = DataBuilderFactory.obtain().build(paramString, localPathData);
    if (localFinalData == null) {
      return false;
    }
    localFinalData.setEventKey(paramString);
    if (paramMap != null) {
      localFinalData.putAll(paramMap);
    }
    if ("imp".equals(paramString)) {
      IExposureRecorder.Factory.getInstance().markExposed(new ExposureElementInfo(paramView, localPathData.getPage(), localFinalData, localPathData));
    }
    FinalDataTarget.handle(paramView, localFinalData);
    return true;
  }
  
  public static VideoReportInner getInstance()
  {
    return VideoReportInner.InstanceHolder.INSTANCE;
  }
  
  private Map<String, Object> getTotalPageParams(PageParams paramPageParams)
  {
    if (paramPageParams == null) {
      return null;
    }
    HashMap localHashMap = new HashMap(1);
    if (paramPageParams.getBasicParams() != null) {
      localHashMap.putAll(paramPageParams.getBasicParams());
    }
    if (paramPageParams.getRefElementParams() != null) {
      localHashMap.put("ref_elmt", paramPageParams.getRefElementParams());
    }
    if (paramPageParams.getRootRefElementParams() != null) {
      localHashMap.put("root_ref_elmt", paramPageParams.getRootRefElementParams());
    }
    return localHashMap;
  }
  
  private void initiateComponent()
  {
    ViewGroupDrawingCompat.preload();
    AppEventReporter.getInstance();
    ElementClickReporter.getInstance();
    ViewContainerBinder.getInstance();
    PageSwitchObserver.getInstance();
    PageManager.getInstance();
    PageReporter.getInstance();
    ElementExposureReporter.getInstance();
    ScrollableViewObserver.getInstance();
    ElementExposureEndReporter.getInstance();
    AudioEventReporter.getInstance();
    VideoPageReporter.getInstance();
  }
  
  public void addInnerReporter(IInnerReporter paramIInnerReporter)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("addInnerReporter: reporter=");
    localStringBuilder.append(paramIInnerReporter);
    Log.i("VideoReportInner", localStringBuilder.toString());
    if (paramIInnerReporter != null) {
      this.mInnerReporters.add(paramIInnerReporter);
    }
  }
  
  public void addReporter(IReporter paramIReporter)
  {
    if (isDebugMode())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("addReporter: reporter=");
      localStringBuilder.append(paramIReporter);
      Log.i("VideoReportInner", localStringBuilder.toString());
    }
    if (paramIReporter != null) {
      this.mReporters.add(paramIReporter);
    }
  }
  
  public void addToDetectionBlacklist(Activity paramActivity)
  {
    DetectionPolicy.addBlacklist(paramActivity);
  }
  
  public void addToDetectionWhitelist(Activity paramActivity)
  {
    DetectionPolicy.addWhitelist(paramActivity);
  }
  
  public void bindVideoPlayerInfo(@NonNull Object paramObject, VideoEntity paramVideoEntity)
  {
    VideoReportManager.getInstance().bindVideoInfo(paramObject, paramVideoEntity);
  }
  
  public boolean checkElementObjectArgument(Object paramObject)
  {
    return ((paramObject instanceof Dialog)) || ((paramObject instanceof View));
  }
  
  public void clearElementExposure(View paramView, boolean paramBoolean)
  {
    if (isDebugMode())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("clearElementExposure: view=");
      localStringBuilder.append(paramView);
      localStringBuilder.append(", clearChildren=");
      localStringBuilder.append(paramBoolean);
      Log.i("VideoReportInner", localStringBuilder.toString());
    }
    clearElementExposureInner(paramView, paramBoolean);
  }
  
  public void clearPublicParams()
  {
    if (isDebugMode()) {
      Log.i("VideoReportInner", "clearPublicParams: ");
    }
    Map localMap = this.mPublicParam;
    if (localMap != null) {
      localMap.clear();
    }
  }
  
  public void doAppOutReport()
  {
    AppEventReporter.getInstance().appOutDataSender();
  }
  
  public PageInfo findOwnerPage(View paramView)
  {
    if (paramView == null) {
      return null;
    }
    return PageFinder.findOwnerPage(paramView);
  }
  
  public Configuration getConfiguration()
  {
    Configuration localConfiguration2 = this.mConfiguration;
    Configuration localConfiguration1 = localConfiguration2;
    if (localConfiguration2 == null) {
      localConfiguration1 = Configuration.getDefault();
    }
    return localConfiguration1;
  }
  
  public ClickPolicy getElementClickPolicy(Object paramObject)
  {
    return (ClickPolicy)ReportPolicyOperator.getReportPolicy(paramObject, "element_click_policy", ClickPolicy.class);
  }
  
  public EndExposurePolicy getElementEndExposePolicy(Object paramObject)
  {
    return (EndExposurePolicy)ReportPolicyOperator.getReportPolicy(paramObject, "element_end_expose_policy", EndExposurePolicy.class);
  }
  
  public ExposurePolicy getElementExposePolicy(Object paramObject)
  {
    return (ExposurePolicy)ReportPolicyOperator.getReportPolicy(paramObject, "element_expose_policy", ExposurePolicy.class);
  }
  
  public Map<String, ?> getElementParams(Object paramObject)
  {
    return DataRWProxy.getElementParams(paramObject);
  }
  
  @Deprecated
  public ReportPolicy getElementReportPolicy(Object paramObject)
  {
    if (isDebugMode()) {
      Log.d("VideoReportInner", "getElementReportPolicy: ");
    }
    if (checkElementObjectArgument(paramObject))
    {
      paramObject = DataRWProxy.getInnerParam(paramObject, "element_report_policy");
      if ((paramObject instanceof ReportPolicy)) {
        return (ReportPolicy)paramObject;
      }
    }
    return null;
  }
  
  public IEventDynamicParams getEventDynamicParams()
  {
    return this.mEventDynamicParams;
  }
  
  @NonNull
  public Set<IInnerReporter> getInnerReporters()
  {
    return this.mInnerReporters;
  }
  
  @NonNull
  public Set<View> getPageCache(@NonNull Context paramContext)
  {
    return this.mPageInfoCacheCtrl.getPageStore(paramContext);
  }
  
  public PageInfo getPageInfo(View paramView)
  {
    if (paramView == null) {
      return PageManager.getInstance().getCurrentPageInfo();
    }
    return findOwnerPage(paramView);
  }
  
  public Integer getPageSearchMode(Object paramObject)
  {
    paramObject = DataRWProxy.getInnerParam(paramObject, "page_launch_mode");
    if ((paramObject instanceof Integer)) {
      return Integer.valueOf(((Integer)paramObject).intValue());
    }
    return null;
  }
  
  @Nullable
  public Map<String, Object> getPublicParam()
  {
    return this.mPublicParam;
  }
  
  @NonNull
  public Collection<IReporter> getReporter()
  {
    return this.mUnmodifiableReporters;
  }
  
  public void ignorePageInOutEvent(Object paramObject, boolean paramBoolean)
  {
    if (isDebugMode())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ignorePageInOutEvent: object=");
      localStringBuilder.append(paramObject);
      localStringBuilder.append(", ignore=");
      localStringBuilder.append(paramBoolean);
      Log.d("VideoReportInner", localStringBuilder.toString());
    }
    if (checkPageObjectArgument(paramObject)) {
      DataRWProxy.setInnerParam(paramObject, "page_report_ignore", Boolean.valueOf(paramBoolean));
    }
  }
  
  public boolean isDataCollectEnable()
  {
    return getConfiguration().isDefaultDataCollectEnable();
  }
  
  public boolean isDebugMode()
  {
    return this.mDebugMode;
  }
  
  public boolean isInit()
  {
    try
    {
      boolean bool = this.isInit;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean isReportEnable()
  {
    return true;
  }
  
  public boolean isTestMode()
  {
    return this.mTestMode;
  }
  
  public void markAsPageBodyView(View paramView)
  {
    if (isDebugMode())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("markAsPageBodyView: view=");
      localStringBuilder.append(paramView);
      Log.d("VideoReportInner", localStringBuilder.toString());
    }
    PageBodyStatistician.getInstance().markAsPageBodyView(paramView, null);
  }
  
  public void markAsPageBodyView(View paramView, IScrollReader paramIScrollReader)
  {
    if (isDebugMode())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("markAsPageBodyView: view=");
      localStringBuilder.append(paramView);
      Log.d("VideoReportInner", localStringBuilder.toString());
    }
    PageBodyStatistician.getInstance().markAsPageBodyView(paramView, paramIScrollReader);
  }
  
  public void notifyViewDetach(View paramView1, View paramView2)
  {
    if (isDebugMode())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("notifyViewDetach: parentView=");
      localStringBuilder.append(paramView1);
      localStringBuilder.append(",view=");
      localStringBuilder.append(paramView2);
      Log.i("VideoReportInner", localStringBuilder.toString());
    }
    if (paramView2 == null) {
      return;
    }
    if (PageFinder.isPage(paramView2))
    {
      PageSwitchObserver.getInstance().onPageViewInvisible(paramView2);
      PageSwitchObserver.getInstance().onPageViewVisible(paramView1);
    }
  }
  
  @Nullable
  public Map<String, Object> pageInfoForView(String paramString, View paramView)
  {
    PageInfo localPageInfo = findOwnerPage(paramView);
    if (localPageInfo == null) {
      paramView = null;
    } else {
      paramView = localPageInfo.getPage();
    }
    if (paramView == null) {
      return null;
    }
    return PageUtils.getPageInfo(paramString, paramView, localPageInfo.getPageHashCode());
  }
  
  public void pageLogicDestroy(Object paramObject)
  {
    if (isDebugMode())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("clearPageCreRefPageParams: object = ");
      ((StringBuilder)localObject).append(paramObject);
      Log.i("VideoReportInner", ((StringBuilder)localObject).toString());
    }
    if (!PageFinder.isPage(paramObject)) {
      return;
    }
    Object localObject = PageFinder.getPageView(paramObject);
    PageSwitchObserver.getInstance().onPageViewInvisible((View)localObject);
    PageManager.getInstance().clearPageContext(paramObject);
    setPageId(paramObject, null);
    setPageContentId(paramObject, null, true);
    resetPageParams(paramObject);
    ExposurePolicyHelper.clearEleExposureMap(paramObject);
  }
  
  @Nullable
  public Map<String, Object> paramsForView(String paramString, View paramView)
  {
    paramView = ReversedDataCollector.collect(paramView);
    if (paramView == null) {
      return null;
    }
    paramString = DataBuilderFactory.obtain().build(paramString, paramView);
    if (paramString == null) {
      return null;
    }
    paramView = new HashMap(paramString.getEventParams());
    paramString.reset();
    ReusablePool.recycle(paramString, 6);
    return paramView;
  }
  
  public void registerEventDynamicParams(IEventDynamicParams paramIEventDynamicParams)
  {
    if (getInstance().isDebugMode())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("registerEventDynamicParams: dynamicParams=");
      localStringBuilder.append(paramIEventDynamicParams);
      Log.d("VideoReportInner", localStringBuilder.toString());
    }
    this.mEventDynamicParams = paramIEventDynamicParams;
  }
  
  public void registerSessionChangeListener(ISessionChangeListener paramISessionChangeListener)
  {
    AppEventReporter.getInstance().registerSessionChangeListener(paramISessionChangeListener);
  }
  
  public void removeAllElementParams(Object paramObject)
  {
    if (isDebugMode())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("removeAllElementParams: object=");
      localStringBuilder.append(paramObject);
      Log.i("VideoReportInner", localStringBuilder.toString());
    }
    if (checkElementObjectArgument(paramObject)) {
      DataRWProxy.removeAllElementParams(paramObject);
    }
  }
  
  public void removeAllPageParams(Object paramObject)
  {
    if (isDebugMode())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("removeAllPageParams: object=");
      localStringBuilder.append(paramObject);
      Log.i("VideoReportInner", localStringBuilder.toString());
    }
    if (checkPageObjectArgument(paramObject)) {
      DataRWProxy.removeAllPageParams(paramObject);
    }
  }
  
  public void removeElementParam(Object paramObject, String paramString)
  {
    if (isDebugMode())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("removeElementParam: object=");
      localStringBuilder.append(paramObject);
      localStringBuilder.append(", key=");
      localStringBuilder.append(paramString);
      Log.i("VideoReportInner", localStringBuilder.toString());
    }
    if (checkElementObjectArgument(paramObject)) {
      DataRWProxy.removeElementParam(paramObject, paramString);
    }
  }
  
  public void removePageParam(Object paramObject, String paramString)
  {
    if (isDebugMode())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("removePageParam: object=");
      localStringBuilder.append(paramObject);
      localStringBuilder.append(", key=");
      localStringBuilder.append(paramString);
      Log.i("VideoReportInner", localStringBuilder.toString());
    }
    if (checkPageObjectArgument(paramObject)) {
      DataRWProxy.removePageParam(paramObject, paramString);
    }
  }
  
  public void removePublicParam(String paramString)
  {
    Object localObject;
    if (isDebugMode())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("removePublicParam: key=");
      ((StringBuilder)localObject).append(paramString);
      Log.i("VideoReportInner", ((StringBuilder)localObject).toString());
    }
    if (!TextUtils.isEmpty(paramString))
    {
      localObject = this.mPublicParam;
      if (localObject != null) {
        ((Map)localObject).remove(paramString);
      }
    }
  }
  
  public void reportCustomEvent(String paramString, Object paramObject, Map<String, ?> paramMap)
  {
    if (isInit())
    {
      reportEvent(paramString, paramObject, paramMap);
      return;
    }
    try
    {
      if (isInit()) {
        reportEvent(paramString, paramObject, paramMap);
      } else {
        CustomEventStagingManager.getInstance().save(paramString, paramObject, paramMap);
      }
      return;
    }
    finally {}
  }
  
  public boolean reportEvent(String paramString, Object paramObject, Map<String, ?> paramMap)
  {
    if (isDebugMode())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reportEvent: eventId=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", object=");
      localStringBuilder.append(paramObject);
      localStringBuilder.append(", map=");
      localStringBuilder.append(paramMap);
      Log.i("VideoReportInner", localStringBuilder.toString());
    }
    if (TextUtils.isEmpty(paramString))
    {
      if (!isDebugMode()) {
        return false;
      }
      throw new IllegalArgumentException("reportEvent, eventId is empty");
    }
    if (paramObject == null)
    {
      paramObject = (FinalData)ReusablePool.obtain(6);
      paramObject.setEventKey(paramString);
      if (paramMap != null) {
        paramObject.putAll(paramMap);
      }
      FinalDataTarget.handle(null, paramObject);
      return true;
    }
    if (!checkTrackObjectArgument(paramObject)) {
      return false;
    }
    if (PageFinder.isPage(paramObject))
    {
      paramString = PageUtils.createTrackData(paramString, paramObject);
      if ((paramString != null) && (paramMap != null)) {
        paramString.putAll(paramMap);
      }
      FinalDataTarget.handle(paramObject, paramString);
      return true;
    }
    if (!TextUtils.isEmpty(DataRWProxy.getElementId(paramObject))) {
      if ((paramObject instanceof Dialog))
      {
        paramObject = (Dialog)paramObject;
        if (paramObject.getWindow() != null) {
          return elementReport(paramString, paramObject.getWindow().getDecorView(), paramMap);
        }
      }
      else if ((paramObject instanceof View))
      {
        return elementReport(paramString, (View)paramObject, paramMap);
      }
    }
    return false;
  }
  
  public boolean reportEvent(String paramString, Map<String, ?> paramMap)
  {
    if (isDebugMode())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reportEvent: eventId=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", map=");
      localStringBuilder.append(paramMap);
      Log.i("VideoReportInner", localStringBuilder.toString());
    }
    return reportEvent(paramString, null, paramMap);
  }
  
  public boolean reportEventWithoutFormat(String paramString1, Map<String, Object> paramMap, String paramString2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("reportEvent: eventId=");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(", appKey=");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append(", map=");
    ((StringBuilder)localObject).append(paramMap);
    Log.i("VideoReportInner", ((StringBuilder)localObject).toString());
    if (TextUtils.isEmpty(paramString1))
    {
      if (!isDebugMode()) {
        return false;
      }
      throw new IllegalArgumentException("reportEvent, eventId is empty");
    }
    localObject = (FinalData)ReusablePool.obtain(6);
    ((FinalData)localObject).setEventKey(paramString1);
    if (paramMap != null) {
      ((FinalData)localObject).putAll(paramMap);
    }
    FinalDataTarget.handleWithoutFormat(null, (FinalData)localObject, paramString2);
    return true;
  }
  
  public void reportStdEvent(StdEventCode paramStdEventCode, IEventParamsBuilder paramIEventParamsBuilder)
  {
    if (isDebugMode())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reportStdEvent: eventCode = ");
      localStringBuilder.append(paramStdEventCode);
      localStringBuilder.append(", builder = ");
      localStringBuilder.append(paramIEventParamsBuilder);
      Log.d("VideoReportInner", localStringBuilder.toString());
    }
    if (!StdEventParamChecker.checkParamBuilder(paramStdEventCode, paramIEventParamsBuilder)) {
      return;
    }
    paramIEventParamsBuilder = paramIEventParamsBuilder.build();
    reportEvent(paramStdEventCode.codeName, paramIEventParamsBuilder);
  }
  
  public void resetElementParams(Object paramObject)
  {
    if (isDebugMode())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("resetElementParams: object=");
      localStringBuilder.append(paramObject);
      Log.i("VideoReportInner", localStringBuilder.toString());
    }
    if (checkElementObjectArgument(paramObject)) {
      DataRWProxy.removeAllElementParams(paramObject);
    }
  }
  
  public void resetPageParams(Object paramObject)
  {
    if (isDebugMode())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("resetPageParams: object=");
      localStringBuilder.append(paramObject);
      Log.i("VideoReportInner", localStringBuilder.toString());
    }
    if (checkPageObjectArgument(paramObject)) {
      DataRWProxy.removeAllPageParams(paramObject);
    }
  }
  
  public void resetPageStats()
  {
    PageManager.getInstance().resetPagePath();
  }
  
  public void setClickReportInterval(View paramView, long paramLong)
  {
    if (isDebugMode())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setClickReportInterval: view = ");
      localStringBuilder.append(paramView);
      localStringBuilder.append(", interval = ");
      localStringBuilder.append(paramLong);
      Log.i("VideoReportInner", localStringBuilder.toString());
    }
    if (paramView == null) {
      return;
    }
    DataRWProxy.setInnerParam(paramView, "click_interval", Long.valueOf(paramLong));
  }
  
  public void setDataCollectEnable(boolean paramBoolean)
  {
    if (isDebugMode())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setDataCollectEnable: enable=");
      ((StringBuilder)localObject).append(paramBoolean);
      Log.i("VideoReportInner", ((StringBuilder)localObject).toString());
    }
    Object localObject = this.mConfiguration;
    if (localObject == null)
    {
      this.mConfiguration = Configuration.builder().defaultDataCollectEnable(paramBoolean).build();
      return;
    }
    ((Configuration)localObject).setDefaultDataCollectEnable(paramBoolean);
  }
  
  public void setDebugMode(boolean paramBoolean)
  {
    this.mDebugMode = paramBoolean;
    ListenerMgr.setDebug(paramBoolean);
    if (isDebugMode())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setDebugMode: debugMode=");
      localStringBuilder.append(paramBoolean);
      Log.i("VideoReportInner", localStringBuilder.toString());
    }
  }
  
  public void setDetectionInterceptor(IDetectionInterceptor paramIDetectionInterceptor)
  {
    DetectionInterceptors.setDetectionInterceptor(paramIDetectionInterceptor);
  }
  
  public void setDetectionMode(@DetectionMode int paramInt)
  {
    DetectionPolicy.setDetectionMode(paramInt);
  }
  
  public void setElementClickPolicy(Object paramObject, ClickPolicy paramClickPolicy)
  {
    ReportPolicyOperator.setReportPolicy(paramObject, paramClickPolicy, "element_click_policy");
  }
  
  public void setElementDynamicParams(Object paramObject, IElementDynamicParams paramIElementDynamicParams)
  {
    if (isDebugMode())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setElementDynamicParams: object=");
      localStringBuilder.append(paramObject);
      localStringBuilder.append(", provider=");
      localStringBuilder.append(paramIElementDynamicParams);
      Log.i("VideoReportInner", localStringBuilder.toString());
    }
    if (checkElementObjectArgument(paramObject)) {
      DataRWProxy.setElementDynamicParam(paramObject, paramIElementDynamicParams);
    }
  }
  
  public void setElementEndExposePolicy(Object paramObject, EndExposurePolicy paramEndExposurePolicy)
  {
    ReportPolicyOperator.setReportPolicy(paramObject, paramEndExposurePolicy, "element_end_expose_policy");
  }
  
  public void setElementExposePolicy(Object paramObject, ExposurePolicy paramExposurePolicy)
  {
    ReportPolicyOperator.setReportPolicy(paramObject, paramExposurePolicy, "element_expose_policy");
  }
  
  public void setElementExposureDetectionEnabled(Object paramObject, boolean paramBoolean)
  {
    if (isDebugMode())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setElementExposureDetectionEnabled: element = ");
      localStringBuilder.append(paramObject);
      localStringBuilder.append(", enabled = ");
      localStringBuilder.append(paramBoolean);
      Log.i("VideoReportInner", localStringBuilder.toString());
    }
    if (checkElementObjectArgument(paramObject)) {
      DataRWProxy.setInnerParam(paramObject, "element_detection_enable", Boolean.valueOf(paramBoolean));
    }
  }
  
  public void setElementExposureMinRate(Object paramObject, double paramDouble)
  {
    if (isDebugMode())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setElementExposureMinRate: object=");
      localStringBuilder.append(paramObject);
      localStringBuilder.append(", rate=");
      localStringBuilder.append(paramDouble);
      Log.i("VideoReportInner", localStringBuilder.toString());
    }
    if (checkElementObjectArgument(paramObject)) {
      DataRWProxy.setInnerParam(paramObject, "element_exposure_min_rate", Double.valueOf(paramDouble));
    }
  }
  
  public void setElementExposureMinTime(Object paramObject, long paramLong)
  {
    if (isDebugMode())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setElementExposureMinTime: object=");
      localStringBuilder.append(paramObject);
      localStringBuilder.append(", timeMills=");
      localStringBuilder.append(paramLong);
      Log.i("VideoReportInner", localStringBuilder.toString());
    }
    if (checkElementObjectArgument(paramObject)) {
      DataRWProxy.setInnerParam(paramObject, "element_exposure_min_time", Long.valueOf(paramLong));
    }
  }
  
  public void setElementId(Object paramObject, String paramString)
  {
    if (isDebugMode())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setElementId: object=");
      localStringBuilder.append(paramObject);
      localStringBuilder.append(", elementId=");
      localStringBuilder.append(paramString);
      Log.i("VideoReportInner", localStringBuilder.toString());
    }
    if (checkElementObjectArgument(paramObject)) {
      DataRWProxy.setElementId(paramObject, paramString);
    }
  }
  
  public void setElementParam(Object paramObject1, String paramString, Object paramObject2)
  {
    if (isDebugMode())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setElementParam: object=");
      localStringBuilder.append(paramObject1);
      localStringBuilder.append(", key=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", value=");
      localStringBuilder.append(paramObject2);
      Log.i("VideoReportInner", localStringBuilder.toString());
    }
    if (checkElementObjectArgument(paramObject1)) {
      DataRWProxy.setElementParam(paramObject1, paramString, paramObject2);
    }
  }
  
  public void setElementParams(Object paramObject, Map<String, ?> paramMap)
  {
    if (isDebugMode())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setElementParams: object=");
      localStringBuilder.append(paramObject);
      localStringBuilder.append(", map=");
      localStringBuilder.append(paramMap);
      Log.i("VideoReportInner", localStringBuilder.toString());
    }
    if (checkElementObjectArgument(paramObject)) {
      DataRWProxy.setElementParams(paramObject, paramMap);
    }
  }
  
  @Deprecated
  public void setElementReportPolicy(Object paramObject, ReportPolicy paramReportPolicy)
  {
    Object localObject;
    if (isDebugMode())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setElementReportPolicy: object=");
      ((StringBuilder)localObject).append(paramObject);
      ((StringBuilder)localObject).append(", policy=");
      ((StringBuilder)localObject).append(paramReportPolicy.name());
      Log.i("VideoReportInner", ((StringBuilder)localObject).toString());
    }
    if (checkElementObjectArgument(paramObject))
    {
      if (paramReportPolicy.reportClick) {
        localObject = ClickPolicy.REPORT_ALL;
      } else {
        localObject = ClickPolicy.REPORT_NONE;
      }
      setElementClickPolicy(paramObject, (ClickPolicy)localObject);
      if (paramReportPolicy.reportExposure) {
        localObject = ExposurePolicy.REPORT_ALL;
      } else {
        localObject = ExposurePolicy.REPORT_NONE;
      }
      setElementExposePolicy(paramObject, (ExposurePolicy)localObject);
      if (paramReportPolicy.reportExposure) {
        localObject = EndExposurePolicy.REPORT_ALL;
      } else {
        localObject = EndExposurePolicy.REPORT_NONE;
      }
      setElementEndExposePolicy(paramObject, (EndExposurePolicy)localObject);
      DataRWProxy.setInnerParam(paramObject, "element_report_policy", paramReportPolicy);
    }
  }
  
  public void setElementReuseIdentifier(Object paramObject, String paramString)
  {
    if (VideoReport.isDebugMode())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setElementReuseIdentifier: element = ");
      localStringBuilder.append(paramObject);
      localStringBuilder.append(", identifier = ");
      localStringBuilder.append(paramString);
      Log.i("VideoReportInner", localStringBuilder.toString());
    }
    if (paramObject == null) {
      return;
    }
    DataRWProxy.setInnerParam(paramObject, "element_identifier", paramString);
  }
  
  public void setElementVirtualParentParams(Object paramObject, int paramInt, String paramString, Map<String, Object> paramMap)
  {
    if (isDebugMode())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setElementParentParams: ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(paramMap);
      Log.d("VideoReportInner", localStringBuilder.toString());
    }
    if (checkElementObjectArgument(paramObject)) {
      DataRWProxy.setElementVirtualParentParams(paramObject, paramInt, paramString, paramMap);
    }
  }
  
  public void setEventAdditionalReport(IAdditionalReportListener paramIAdditionalReportListener)
  {
    AppEventReporter.getInstance().setEventAdditionalReport(paramIAdditionalReportListener);
  }
  
  public void setEventDynamicParams(Object paramObject, @Nullable IDynamicParams paramIDynamicParams)
  {
    if (isDebugMode())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setElementDynamicParams: object=");
      localStringBuilder.append(paramObject);
      localStringBuilder.append(", provider=");
      localStringBuilder.append(paramIDynamicParams);
      Log.i("VideoReportInner", localStringBuilder.toString());
    }
    if ((checkElementObjectArgument(paramObject)) || (checkPageObjectArgument(paramObject))) {
      DataRWProxy.setEventDynamicParam(paramObject, paramIDynamicParams);
    }
  }
  
  public void setLogicParent(View paramView1, View paramView2)
  {
    if (isDebugMode())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setLogicParent: child = ");
      localStringBuilder.append(paramView1);
      localStringBuilder.append(", logicParent = ");
      localStringBuilder.append(paramView2);
      Log.i("VideoReportInner", localStringBuilder.toString());
    }
    if (paramView1 == null) {
      return;
    }
    if (paramView2 == null)
    {
      DataRWProxy.removeInnerParam(paramView1, "logic_parent");
      return;
    }
    DataRWProxy.setInnerParam(paramView1, "logic_parent", new WeakReference(paramView2));
  }
  
  public void setPageBodyContentRange(View paramView, int paramInt1, int paramInt2)
  {
    if (isDebugMode())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setPageBodyContentRange: view=");
      localStringBuilder.append(paramView);
      localStringBuilder.append(", rangeStart=");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", rangeEnd=");
      localStringBuilder.append(paramInt2);
      Log.d("VideoReportInner", localStringBuilder.toString());
    }
    PageBodyStatistician.getInstance().setPageBodyContentRange(paramView, paramInt1, paramInt2);
  }
  
  public void setPageContentId(Object paramObject, String paramString)
  {
    setPageContentId(paramObject, paramString, false);
  }
  
  public void setPageContentId(Object paramObject, String paramString, boolean paramBoolean)
  {
    if (isDebugMode())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setPageId: object=");
      localStringBuilder.append(paramObject);
      localStringBuilder.append(", pageContentId=");
      localStringBuilder.append(paramString);
      Log.i("VideoReportInner", localStringBuilder.toString());
    }
    if (checkPageObjectArgument(paramObject))
    {
      DataRWProxy.setPageContentId(paramObject, paramString);
      if (paramBoolean) {
        DataRWProxy.setInnerParam(paramObject, "page_last_content_id", null);
      }
    }
  }
  
  public void setPageId(Object paramObject, String paramString)
  {
    if (isDebugMode())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setPageId: object=");
      localStringBuilder.append(paramObject);
      localStringBuilder.append(", pageId=");
      localStringBuilder.append(paramString);
      Log.i("VideoReportInner", localStringBuilder.toString());
    }
    if (checkPageObjectArgument(paramObject))
    {
      DataRWProxy.setPageId(paramObject, paramString);
      PageSwitchObserver.getInstance().onPageReport(paramObject);
      if (!TextUtils.isEmpty(paramString)) {
        this.mPageInfoCacheCtrl.appendPageStore(paramObject);
      }
    }
  }
  
  public void setPageParams(Object paramObject, PageParams paramPageParams)
  {
    if (isDebugMode())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setPageParams: object=");
      localStringBuilder.append(paramObject);
      localStringBuilder.append(", pageParams=");
      localStringBuilder.append(paramPageParams);
      Log.i("VideoReportInner", localStringBuilder.toString());
    }
    if (checkPageObjectArgument(paramObject))
    {
      if (paramPageParams == null) {
        paramPageParams = null;
      } else {
        paramPageParams = getTotalPageParams(paramPageParams);
      }
      DataRWProxy.setPageParams(paramObject, paramPageParams);
    }
  }
  
  public void setPageParams(Object paramObject1, String paramString, Object paramObject2)
  {
    if (isDebugMode())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setPageParams: object=");
      localStringBuilder.append(paramObject1);
      localStringBuilder.append(", key=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", value=");
      localStringBuilder.append(paramObject2);
      Log.i("VideoReportInner", localStringBuilder.toString());
    }
    if (checkPageObjectArgument(paramObject1)) {
      DataRWProxy.setPageParams(paramObject1, paramString, paramObject2);
    }
  }
  
  public void setPageSearchMode(Object paramObject, int paramInt)
  {
    DataRWProxy.setInnerParam(paramObject, "page_launch_mode", Integer.valueOf(paramInt));
  }
  
  public void setPublicParam(String paramString, Object paramObject)
  {
    if (isDebugMode())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setPublicParam: key=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", value=");
      localStringBuilder.append(paramObject);
      Log.i("VideoReportInner", localStringBuilder.toString());
    }
    if (!TextUtils.isEmpty(paramString))
    {
      if (this.mPublicParam == null) {
        this.mPublicParam = new HashMap(1);
      }
      this.mPublicParam.put(paramString, paramObject);
    }
  }
  
  public void setTestMode(boolean paramBoolean)
  {
    if (isDebugMode())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setTestMode: testMode=");
      localStringBuilder.append(paramBoolean);
      Log.i("VideoReportInner", localStringBuilder.toString());
    }
    this.mTestMode = paramBoolean;
  }
  
  public void setVideoReportConfig(@NonNull DTConfig paramDTConfig)
  {
    supportPlayerReport(paramDTConfig.videoReportSupport());
  }
  
  public void startNewSession(SessionChangeReason paramSessionChangeReason)
  {
    AppEventReporter.getInstance().startNewSession(paramSessionChangeReason);
  }
  
  public void startWithComponent(Application paramApplication, IVideoReportComponent paramIVideoReportComponent)
  {
    SimpleTracer.begin("VideoReportInner.startWithComponent");
    if (paramIVideoReportComponent != null) {
      startWithConfiguration(paramApplication, paramIVideoReportComponent.getConfiguration());
    }
    SimpleTracer.end("VideoReportInner.startWithComponent");
  }
  
  public void startWithConfiguration(Application paramApplication, Configuration paramConfiguration)
  {
    try
    {
      if (isInit())
      {
        Log.w("VideoReportInner", "startWithConfiguration already initialized");
        return;
      }
      if (!ThreadUtils.isMainThread()) {
        Log.e("VideoReportInner", "We recommend initializing the 大同 SDK in the main thread");
      }
      this.mConfiguration = paramConfiguration;
      if (isDebugMode())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("startWithConfiguration: application =");
        localStringBuilder.append(paramApplication);
        localStringBuilder.append(", configuration =");
        localStringBuilder.append(paramConfiguration);
        Log.i("VideoReportInner", localStringBuilder.toString());
      }
      if (paramApplication != null)
      {
        paramApplication.registerActivityLifecycleCallbacks(EventCollector.getInstance());
        ReportUtils.setContext(paramApplication);
        ThreadUtils.injectTaskInterceptor(LazyInitObserver.getInstance());
        ReportUtils.initCrashReport(paramApplication);
        initiateComponent();
        LazyInitObserver.getInstance().onInitialized();
      }
      else
      {
        if (isDebugMode()) {
          break label150;
        }
      }
      CustomEventStagingManager.getInstance().supplementReportsEvent();
      this.isInit = true;
      return;
      label150:
      throw new NullPointerException("Application = null");
    }
    finally {}
  }
  
  public void supportPlayerReport(boolean paramBoolean)
  {
    DTConfigConstants.config.videoReportSupport(paramBoolean);
  }
  
  public void supportWebViewReport(boolean paramBoolean)
  {
    DTConfigConstants.config.webViewReportSupport(paramBoolean);
  }
  
  public void traverseExposure()
  {
    if (isDebugMode()) {
      Log.i("VideoReportInner", "traverseExposure: ");
    }
    ElementExposureReporter.getInstance().traverseExposure();
  }
  
  public void traversePage(View paramView)
  {
    if (isDebugMode())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("traversePage: view = ");
      localStringBuilder.append(paramView);
      Log.i("VideoReportInner", localStringBuilder.toString());
    }
    if (paramView == null) {
      return;
    }
    PageSwitchObserver.getInstance().onPageViewVisible(paramView);
  }
  
  public void triggerClickInCurrentPage(Map<String, Object> paramMap)
  {
    if (isDebugMode()) {
      Log.i("VideoReportInner", "triggerClickInCurrentPage");
    }
    triggerEventInCurrentPage("clck", paramMap);
  }
  
  public void triggerEventInCurrentPage(String paramString, Map<String, Object> paramMap)
  {
    if (isDebugMode())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("triggerEventInCurrentPage: eventKey = ");
      ((StringBuilder)localObject).append(paramString);
      Log.i("VideoReportInner", ((StringBuilder)localObject).toString());
    }
    if (TextUtils.isEmpty(paramString))
    {
      if (!isDebugMode()) {
        return;
      }
      throw new IllegalArgumentException("triggerEventInCurrentPage, eventKey is empty");
    }
    Object localObject = (FinalData)ReusablePool.obtain(6);
    ((FinalData)localObject).setEventKey(paramString);
    ((FinalData)localObject).put("cur_pg", PageReporter.getInstance().getCurPageReportInfo(paramString));
    ((FinalData)localObject).putAll(paramMap);
    FinalDataTarget.handle(null, (FinalData)localObject);
  }
  
  public void triggerExposureInCurrentPage(List<Map<String, Object>> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        triggerEventInCurrentPage("imp", (Map)paramList.next());
      }
      return;
    }
    if (isDebugMode()) {
      Log.i("VideoReportInner", "triggerExposureInCurrentPage: paramsList is empty.");
    }
  }
  
  public void unbindVideoPlayerInfo(@NonNull Object paramObject)
  {
    VideoReportManager.getInstance().unbindVideoInfo(paramObject);
  }
  
  public void updateConfiguration(Configuration paramConfiguration)
  {
    try
    {
      if ((this.mConfiguration != null) && (paramConfiguration != null))
      {
        this.mConfiguration.update(paramConfiguration);
        return;
      }
      this.mConfiguration = paramConfiguration;
      return;
    }
    finally {}
  }
  
  public void updateVideoPlayerInfo(@NonNull Object paramObject, @NonNull VideoBaseEntity paramVideoBaseEntity)
  {
    VideoReportManager.getInstance().updateVideoInfo(paramObject, paramVideoBaseEntity);
  }
  
  @Nullable
  public Map<String, Object> viewTreeParamsForView(String paramString, View paramView)
  {
    paramString = paramsForView(paramString, paramView);
    if (paramString != null) {
      paramString.remove("cur_pg");
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.inner.VideoReportInner
 * JD-Core Version:    0.7.0.1
 */