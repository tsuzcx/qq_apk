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
import com.tencent.qqlive.module.videoreport.constants.ReportPolicy;
import com.tencent.qqlive.module.videoreport.data.DataRWProxy;
import com.tencent.qqlive.module.videoreport.detection.DetectionPolicy;
import com.tencent.qqlive.module.videoreport.dtreport.audio.AudioEventReporter;
import com.tencent.qqlive.module.videoreport.dtreport.stdevent.IEventParamsBuilder;
import com.tencent.qqlive.module.videoreport.dtreport.stdevent.StdEventCode;
import com.tencent.qqlive.module.videoreport.dtreport.stdevent.StdEventParamChecker;
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
import com.tencent.qqlive.module.videoreport.report.element.IExposureRecorder;
import com.tencent.qqlive.module.videoreport.report.element.IExposureRecorder.Factory;
import com.tencent.qqlive.module.videoreport.report.element.ReversedDataCollector;
import com.tencent.qqlive.module.videoreport.report.scroll.ScrollableViewObserver;
import com.tencent.qqlive.module.videoreport.reportdata.DataBuilderFactory;
import com.tencent.qqlive.module.videoreport.reportdata.FinalData;
import com.tencent.qqlive.module.videoreport.reportdata.IDataBuilder;
import com.tencent.qqlive.module.videoreport.reportdata.PathData;
import com.tencent.qqlive.module.videoreport.trace.SimpleTracer;
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
  private Configuration mConfiguration;
  private boolean mDebugMode;
  private IEventDynamicParams mEventDynamicParams;
  private Set<IInnerReporter> mInnerReporters = new HashSet();
  private PageInfoCacheController mPageInfoCacheCtrl = new PageInfoCacheController();
  private Map<String, Object> mPublicParam;
  private Set<IReporter> mReporters = new HashSet();
  private boolean mTestMode;
  private Collection<IReporter> mUnmodifiableReporters = Collections.unmodifiableCollection(this.mReporters);
  
  private boolean checkElementObjectArgument(Object paramObject)
  {
    return ((paramObject instanceof Dialog)) || ((paramObject instanceof View));
  }
  
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
    if (paramView == null) {}
    for (;;)
    {
      return;
      long l = ReportUtils.calcElementUniqueId(paramView);
      IExposureRecorder.Factory.getInstance().markUnexposed(l);
      if ((paramBoolean) && ((paramView instanceof ViewGroup)))
      {
        int i = ((ViewGroup)paramView).getChildCount() - 1;
        while (i >= 0)
        {
          clearElementExposureInner(((ViewGroup)paramView).getChildAt(i), true);
          i -= 1;
        }
      }
    }
  }
  
  private void elementReport(String paramString, View paramView, Map<String, ?> paramMap)
  {
    PathData localPathData = ReversedDataCollector.collect(paramView);
    if (localPathData == null) {}
    FinalData localFinalData;
    do
    {
      return;
      localFinalData = DataBuilderFactory.obtain().build(localPathData);
    } while (localFinalData == null);
    localFinalData.setEventKey(paramString);
    if (paramMap != null) {
      localFinalData.putAll(paramMap);
    }
    if ("imp".equals(paramString)) {
      IExposureRecorder.Factory.getInstance().markExposed(new ExposureElementInfo(paramView, localPathData.getPage(), localFinalData));
    }
    FinalDataTarget.handle(paramView, localFinalData);
  }
  
  public static VideoReportInner getInstance()
  {
    return VideoReportInner.InstanceHolder.INSTANCE;
  }
  
  private Map<String, Object> getTotalPageParams(PageParams paramPageParams)
  {
    Object localObject;
    if (paramPageParams == null) {
      localObject = null;
    }
    HashMap localHashMap;
    do
    {
      return localObject;
      localHashMap = new HashMap(1);
      if (paramPageParams.getBasicParams() != null) {
        localHashMap.putAll(paramPageParams.getBasicParams());
      }
      if (paramPageParams.getRefElementParams() != null) {
        localHashMap.put("ref_elmt", paramPageParams.getRefElementParams());
      }
      localObject = localHashMap;
    } while (paramPageParams.getRootRefElementParams() == null);
    localHashMap.put("root_ref_elmt", paramPageParams.getRootRefElementParams());
    return localHashMap;
  }
  
  private void initiateComponent()
  {
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
  }
  
  public void addInnerReporter(IInnerReporter paramIInnerReporter)
  {
    Log.i("VideoReportInner", "addInnerReporter: reporter=" + paramIInnerReporter);
    if (paramIInnerReporter != null) {
      this.mInnerReporters.add(paramIInnerReporter);
    }
  }
  
  public void addReporter(IReporter paramIReporter)
  {
    if (isDebugMode()) {
      Log.i("VideoReportInner", "addReporter: reporter=" + paramIReporter);
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
  
  public void clearElementExposure(View paramView, boolean paramBoolean)
  {
    if (isDebugMode()) {
      Log.i("VideoReportInner", "clearElementExposure: view=" + paramView + ", clearChildren=" + paramBoolean);
    }
    clearElementExposureInner(paramView, paramBoolean);
  }
  
  public void clearPublicParams()
  {
    if (isDebugMode()) {
      Log.i("VideoReportInner", "clearPublicParams: ");
    }
    if (this.mPublicParam != null) {
      this.mPublicParam.clear();
    }
  }
  
  public void doAppOutReport()
  {
    AppEventReporter.getInstance().appOutDataSender(true);
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
    if (this.mConfiguration == null) {
      return Configuration.getDefault();
    }
    return this.mConfiguration;
  }
  
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
    if (isDebugMode()) {
      Log.d("VideoReportInner", "ignorePageInOutEvent: object=" + paramObject + ", ignore=" + paramBoolean);
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
    if (isDebugMode()) {
      Log.d("VideoReportInner", "markAsPageBodyView: view=" + paramView);
    }
    PageBodyStatistician.getInstance().markAsPageBodyView(paramView, null);
  }
  
  public void markAsPageBodyView(View paramView, IScrollReader paramIScrollReader)
  {
    if (isDebugMode()) {
      Log.d("VideoReportInner", "markAsPageBodyView: view=" + paramView);
    }
    PageBodyStatistician.getInstance().markAsPageBodyView(paramView, paramIScrollReader);
  }
  
  public void notifyViewDetach(View paramView1, View paramView2)
  {
    if (isDebugMode()) {
      Log.i("VideoReportInner", "notifyViewDetach: parentView=" + paramView1 + ",view=" + paramView2);
    }
    if (paramView2 == null) {}
    while (!PageFinder.isPage(paramView2)) {
      return;
    }
    PageSwitchObserver.getInstance().onPageViewInvisible(paramView2);
    PageSwitchObserver.getInstance().onPageViewVisible(paramView1);
  }
  
  @Nullable
  public Map<String, Object> pageInfoForView(View paramView)
  {
    paramView = findOwnerPage(paramView);
    if (paramView == null) {}
    for (paramView = null; paramView == null; paramView = paramView.getPage()) {
      return null;
    }
    return PageUtils.getPageInfo(paramView);
  }
  
  @Nullable
  public Map<String, Object> paramsForView(View paramView)
  {
    paramView = ReversedDataCollector.collect(paramView);
    if (paramView == null) {}
    do
    {
      return null;
      paramView = DataBuilderFactory.obtain().build(paramView);
    } while (paramView == null);
    HashMap localHashMap = new HashMap(paramView.eventParams);
    paramView.reset();
    ReusablePool.recycle(paramView, 6);
    return localHashMap;
  }
  
  public void registerEventDynamicParams(IEventDynamicParams paramIEventDynamicParams)
  {
    if (getInstance().isDebugMode()) {
      Log.d("VideoReportInner", "registerEventDynamicParams: dynamicParams=" + paramIEventDynamicParams);
    }
    this.mEventDynamicParams = paramIEventDynamicParams;
  }
  
  public void registerSessionChangeListener(ISessionChangeListener paramISessionChangeListener)
  {
    AppEventReporter.getInstance().registerSessionChangeListener(paramISessionChangeListener);
  }
  
  public void removeAllElementParams(Object paramObject)
  {
    if (isDebugMode()) {
      Log.i("VideoReportInner", "removeAllElementParams: object=" + paramObject);
    }
    if (checkElementObjectArgument(paramObject)) {
      DataRWProxy.removeAllElementParams(paramObject);
    }
  }
  
  public void removeAllPageParams(Object paramObject)
  {
    if (isDebugMode()) {
      Log.i("VideoReportInner", "removeAllPageParams: object=" + paramObject);
    }
    if (checkPageObjectArgument(paramObject)) {
      DataRWProxy.removeAllPageParams(paramObject);
    }
  }
  
  public void removeElementParam(Object paramObject, String paramString)
  {
    if (isDebugMode()) {
      Log.i("VideoReportInner", "removeElementParam: object=" + paramObject + ", key=" + paramString);
    }
    if (checkElementObjectArgument(paramObject)) {
      DataRWProxy.removeElementParam(paramObject, paramString);
    }
  }
  
  public void removePageParam(Object paramObject, String paramString)
  {
    if (isDebugMode()) {
      Log.i("VideoReportInner", "removePageParam: object=" + paramObject + ", key=" + paramString);
    }
    if (checkPageObjectArgument(paramObject)) {
      DataRWProxy.removePageParam(paramObject, paramString);
    }
  }
  
  public void removePublicParam(String paramString)
  {
    if (isDebugMode()) {
      Log.i("VideoReportInner", "removePublicParam: key=" + paramString);
    }
    if ((!TextUtils.isEmpty(paramString)) && (this.mPublicParam != null)) {
      this.mPublicParam.remove(paramString);
    }
  }
  
  public void reportEvent(String paramString, Object paramObject, Map<String, ?> paramMap)
  {
    if (isDebugMode()) {
      Log.i("VideoReportInner", "reportEvent: eventId=" + paramString + ", object=" + paramObject + ", map=" + paramMap);
    }
    if (TextUtils.isEmpty(paramString))
    {
      if (isDebugMode()) {
        throw new IllegalArgumentException("reportEvent, eventId is empty");
      }
    }
    else
    {
      if (paramObject != null) {
        break label110;
      }
      paramObject = (FinalData)ReusablePool.obtain(6);
      paramObject.setEventKey(paramString);
      if (paramMap != null) {
        paramObject.putAll(paramMap);
      }
      FinalDataTarget.handle(null, paramObject);
    }
    label109:
    label110:
    do
    {
      do
      {
        do
        {
          break label109;
          do
          {
            return;
          } while (!checkTrackObjectArgument(paramObject));
          if (PageFinder.isPage(paramObject))
          {
            paramString = PageUtils.createTrackData(paramString, paramObject);
            if ((paramString != null) && (paramMap != null)) {
              paramString.putAll(paramMap);
            }
            FinalDataTarget.handle(paramObject, paramString);
            return;
          }
        } while (TextUtils.isEmpty(DataRWProxy.getElementId(paramObject)));
        if (!(paramObject instanceof Dialog)) {
          break;
        }
        paramObject = (Dialog)paramObject;
      } while (paramObject.getWindow() == null);
      elementReport(paramString, paramObject.getWindow().getDecorView(), paramMap);
      return;
    } while (!(paramObject instanceof View));
    elementReport(paramString, (View)paramObject, paramMap);
  }
  
  public void reportEvent(String paramString, Map<String, ?> paramMap)
  {
    if (isDebugMode()) {
      Log.i("VideoReportInner", "reportEvent: eventId=" + paramString + ", map=" + paramMap);
    }
    reportEvent(paramString, null, paramMap);
  }
  
  public void reportEventWithoutFormat(String paramString1, Map<String, Object> paramMap, String paramString2)
  {
    Log.i("VideoReportInner", "reportEvent: eventId=" + paramString1 + ", appKey=" + paramString2 + ", map=" + paramMap);
    if (TextUtils.isEmpty(paramString1))
    {
      if (isDebugMode()) {
        throw new IllegalArgumentException("reportEvent, eventId is empty");
      }
    }
    else
    {
      FinalData localFinalData = (FinalData)ReusablePool.obtain(6);
      localFinalData.setEventKey(paramString1);
      if (paramMap != null) {
        localFinalData.putAll(paramMap);
      }
      FinalDataTarget.handleWithoutFormat(null, localFinalData, paramString2);
    }
  }
  
  public void reportStdEvent(StdEventCode paramStdEventCode, IEventParamsBuilder paramIEventParamsBuilder)
  {
    if (isDebugMode()) {
      Log.d("VideoReportInner", "reportStdEvent: eventCode = " + paramStdEventCode + ", builder = " + paramIEventParamsBuilder);
    }
    if (!StdEventParamChecker.checkParamBuilder(paramStdEventCode, paramIEventParamsBuilder)) {
      return;
    }
    paramIEventParamsBuilder = paramIEventParamsBuilder.build();
    reportEvent(paramStdEventCode.codeName, paramIEventParamsBuilder);
  }
  
  public void resetElementParams(Object paramObject)
  {
    if (isDebugMode()) {
      Log.i("VideoReportInner", "resetElementParams: object=" + paramObject);
    }
    if (checkElementObjectArgument(paramObject)) {
      DataRWProxy.removeAllElementParams(paramObject);
    }
  }
  
  public void resetPageParams(Object paramObject)
  {
    if (isDebugMode()) {
      Log.i("VideoReportInner", "resetPageParams: object=" + paramObject);
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
    if (isDebugMode()) {
      Log.i("VideoReportInner", "setClickReportInterval: view = " + paramView + ", interval = " + paramLong);
    }
    if (paramView == null) {
      return;
    }
    DataRWProxy.setInnerParam(paramView, "click_interval", Long.valueOf(paramLong));
  }
  
  public void setDataCollectEnable(boolean paramBoolean)
  {
    if (isDebugMode()) {
      Log.i("VideoReportInner", "setDataCollectEnable: enable=" + paramBoolean);
    }
    if (this.mConfiguration == null)
    {
      this.mConfiguration = Configuration.builder().defaultDataCollectEnable(paramBoolean).build();
      return;
    }
    this.mConfiguration.setDefaultDataCollectEnable(paramBoolean);
  }
  
  public void setDebugMode(boolean paramBoolean)
  {
    this.mDebugMode = paramBoolean;
    ListenerMgr.setDebug(paramBoolean);
    if (isDebugMode()) {
      Log.i("VideoReportInner", "setDebugMode: debugMode=" + paramBoolean);
    }
  }
  
  public void setDetectionMode(int paramInt)
  {
    DetectionPolicy.setDetectionMode(paramInt);
  }
  
  public void setElementExposureDetectionEnabled(Object paramObject, boolean paramBoolean)
  {
    if (isDebugMode()) {
      Log.i("VideoReportInner", "setElementExposureDetectionEnabled: element = " + paramObject + ", enabled = " + paramBoolean);
    }
    if (checkElementObjectArgument(paramObject)) {
      DataRWProxy.setInnerParam(paramObject, "element_detection_enable", Boolean.valueOf(paramBoolean));
    }
  }
  
  public void setElementExposureMinRate(Object paramObject, double paramDouble)
  {
    if (isDebugMode()) {
      Log.i("VideoReportInner", "setElementExposureMinRate: object=" + paramObject + ", rate=" + paramDouble);
    }
    if (checkElementObjectArgument(paramObject)) {
      DataRWProxy.setInnerParam(paramObject, "element_exposure_min_rate", Double.valueOf(paramDouble));
    }
  }
  
  public void setElementExposureMinTime(Object paramObject, long paramLong)
  {
    if (isDebugMode()) {
      Log.i("VideoReportInner", "setElementExposureMinTime: object=" + paramObject + ", timeMills=" + paramLong);
    }
    if (checkElementObjectArgument(paramObject)) {
      DataRWProxy.setInnerParam(paramObject, "element_exposure_min_time", Long.valueOf(paramLong));
    }
  }
  
  public void setElementId(Object paramObject, String paramString)
  {
    if (isDebugMode()) {
      Log.i("VideoReportInner", "setElementId: object=" + paramObject + ", elementId=" + paramString);
    }
    if (checkElementObjectArgument(paramObject)) {
      DataRWProxy.setElementId(paramObject, paramString);
    }
  }
  
  public void setElementParam(Object paramObject1, String paramString, Object paramObject2)
  {
    if (isDebugMode()) {
      Log.i("VideoReportInner", "setElementParam: object=" + paramObject1 + ", key=" + paramString + ", value=" + paramObject2);
    }
    if (checkElementObjectArgument(paramObject1)) {
      DataRWProxy.setElementParam(paramObject1, paramString, paramObject2);
    }
  }
  
  public void setElementParams(Object paramObject, Map<String, ?> paramMap)
  {
    if (isDebugMode()) {
      Log.i("VideoReportInner", "setElementParams: object=" + paramObject + ", map=" + paramMap);
    }
    if (checkElementObjectArgument(paramObject)) {
      DataRWProxy.setElementParams(paramObject, paramMap);
    }
  }
  
  public void setElementReportPolicy(Object paramObject, ReportPolicy paramReportPolicy)
  {
    if (isDebugMode()) {
      Log.i("VideoReportInner", "setElementReportPolicy: object=" + paramObject + ", policy=" + paramReportPolicy.name());
    }
    if (checkElementObjectArgument(paramObject)) {
      DataRWProxy.setInnerParam(paramObject, "element_report_policy", paramReportPolicy);
    }
  }
  
  public void setElementReuseIdentifier(Object paramObject, String paramString)
  {
    if (VideoReport.isDebugMode()) {
      Log.i("VideoReportInner", "setElementReuseIdentifier: element = " + paramObject + ", identifier = " + paramString);
    }
    if (paramObject == null) {
      return;
    }
    DataRWProxy.setInnerParam(paramObject, "element_identifier", paramString);
  }
  
  public void setEventAdditionalReport(IAdditionalReportListener paramIAdditionalReportListener)
  {
    AppEventReporter.getInstance().setEventAdditionalReport(paramIAdditionalReportListener);
  }
  
  public void setLogicParent(View paramView1, View paramView2)
  {
    if (isDebugMode()) {
      Log.i("VideoReportInner", "setLogicParent: child = " + paramView1 + ", logicParent = " + paramView2);
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
    if (isDebugMode()) {
      Log.d("VideoReportInner", "setPageBodyContentRange: view=" + paramView + ", rangeStart=" + paramInt1 + ", rangeEnd=" + paramInt2);
    }
    PageBodyStatistician.getInstance().setPageBodyContentRange(paramView, paramInt1, paramInt2);
  }
  
  public void setPageContentId(Object paramObject, String paramString)
  {
    if (isDebugMode()) {
      Log.i("VideoReportInner", "setPageId: object=" + paramObject + ", pageContentId=" + paramString);
    }
    if (checkPageObjectArgument(paramObject)) {
      DataRWProxy.setPageContentId(paramObject, paramString);
    }
  }
  
  public void setPageId(Object paramObject, String paramString)
  {
    if (isDebugMode()) {
      Log.i("VideoReportInner", "setPageId: object=" + paramObject + ", pageId=" + paramString);
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
    if (isDebugMode()) {
      Log.i("VideoReportInner", "setPageParams: object=" + paramObject + ", pageParams=" + paramPageParams);
    }
    if (checkPageObjectArgument(paramObject)) {
      if (paramPageParams != null) {
        break label62;
      }
    }
    label62:
    for (paramPageParams = null;; paramPageParams = getTotalPageParams(paramPageParams))
    {
      DataRWProxy.setPageParams(paramObject, paramPageParams);
      return;
    }
  }
  
  public void setPageParams(Object paramObject1, String paramString, Object paramObject2)
  {
    if (isDebugMode()) {
      Log.i("VideoReportInner", "setPageParams: object=" + paramObject1 + ", key=" + paramString + ", value=" + paramObject2);
    }
    if (checkPageObjectArgument(paramObject1)) {
      DataRWProxy.setPageParams(paramObject1, paramString, paramObject2);
    }
  }
  
  public void setPublicParam(String paramString, Object paramObject)
  {
    if (isDebugMode()) {
      Log.i("VideoReportInner", "setPublicParam: key=" + paramString + ", value=" + paramObject);
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
    if (isDebugMode()) {
      Log.i("VideoReportInner", "setTestMode: testMode=" + paramBoolean);
    }
    this.mTestMode = paramBoolean;
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
    this.mConfiguration = paramConfiguration;
    if (isDebugMode()) {
      Log.i("VideoReportInner", "startWithConfiguration: application =" + paramApplication + ", configuration =" + paramConfiguration);
    }
    if (paramApplication != null)
    {
      paramApplication.registerActivityLifecycleCallbacks(EventCollector.getInstance());
      ReportUtils.setContext(paramApplication);
      initiateComponent();
    }
    while (!isDebugMode()) {
      return;
    }
    throw new NullPointerException("Application = null");
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
    if (isDebugMode()) {
      Log.i("VideoReportInner", "traversePage: view = " + paramView);
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
    if (isDebugMode()) {
      Log.i("VideoReportInner", "triggerEventInCurrentPage: eventKey = " + paramString);
    }
    if (TextUtils.isEmpty(paramString))
    {
      if (isDebugMode()) {
        throw new IllegalArgumentException("triggerEventInCurrentPage, eventKey is empty");
      }
    }
    else
    {
      FinalData localFinalData = (FinalData)ReusablePool.obtain(6);
      localFinalData.setEventKey(paramString);
      localFinalData.put("cur_pg", PageReporter.getInstance().getCurPageReportInfo());
      localFinalData.putAll(paramMap);
      FinalDataTarget.handle(null, localFinalData);
    }
  }
  
  public void triggerExposureInCurrentPage(List<Map<String, Object>> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      if (isDebugMode()) {
        Log.i("VideoReportInner", "triggerExposureInCurrentPage: paramsList is empty.");
      }
    }
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        triggerEventInCurrentPage("imp", (Map)paramList.next());
      }
    }
  }
  
  @Nullable
  public Map<String, Object> viewTreeParamsForView(View paramView)
  {
    paramView = paramsForView(paramView);
    if (paramView != null) {
      paramView.remove("cur_pg");
    }
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.inner.VideoReportInner
 * JD-Core Version:    0.7.0.1
 */