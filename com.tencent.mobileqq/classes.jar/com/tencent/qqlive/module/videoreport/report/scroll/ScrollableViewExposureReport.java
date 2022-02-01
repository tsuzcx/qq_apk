package com.tencent.qqlive.module.videoreport.report.scroll;

import android.view.View;
import com.tencent.qqlive.module.videoreport.IEventDynamicParams;
import com.tencent.qqlive.module.videoreport.data.DataEntity;
import com.tencent.qqlive.module.videoreport.data.DataEntityOperator;
import com.tencent.qqlive.module.videoreport.data.DataRWProxy;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.page.PageInfo;
import com.tencent.qqlive.module.videoreport.page.PageManager;
import com.tencent.qqlive.module.videoreport.report.FinalDataTarget;
import com.tencent.qqlive.module.videoreport.report.element.EleExposeInfo;
import com.tencent.qqlive.module.videoreport.report.element.ExposurePolicyHelper;
import com.tencent.qqlive.module.videoreport.report.element.ReportHelper;
import com.tencent.qqlive.module.videoreport.report.element.ReversedDataCollector;
import com.tencent.qqlive.module.videoreport.reportdata.DataBuilderFactory;
import com.tencent.qqlive.module.videoreport.reportdata.FinalData;
import com.tencent.qqlive.module.videoreport.reportdata.IDataBuilder;
import com.tencent.qqlive.module.videoreport.reportdata.PathData;
import com.tencent.qqlive.module.videoreport.trace.SimpleTracer;
import com.tencent.qqlive.module.videoreport.utils.DelayedIdleHandler;
import java.util.ArrayList;
import java.util.Iterator;

public class ScrollableViewExposureReport
{
  private static final long DETECTION_DELAY = 20L;
  private static final int SCROLL_STATE_IDLE = 0;
  private static final String TAG = "ScrollableViewExposureHelper";
  private DelayedIdleHandler mDelayedIdleHandler = new DelayedIdleHandler();
  private ScrollableViewExposureReport.DetectionTask mDetectionTask = new ScrollableViewExposureReport.DetectionTask(this, null);
  private ArrayList<DataEntity> mExposureAttachedList = new ArrayList();
  private ArrayList<DataEntity> mExposureEndReportList = new ArrayList();
  private ArrayList<DataEntity> mExposureReportList = new ArrayList();
  private int mScrollState = 0;
  
  public static ScrollableViewExposureReport getInstance()
  {
    return ScrollableViewExposureReport.InstanceHolder.access$100();
  }
  
  public static boolean isScrollExposureEnable(View paramView)
  {
    paramView = DataRWProxy.getExtendParam(paramView, "element_scroll_exposure");
    if ((paramView instanceof Boolean)) {
      return ((Boolean)paramView).booleanValue();
    }
    return false;
  }
  
  private void scrollEventReport(View paramView)
  {
    SimpleTracer.begin("scrollEventReport");
    if (this.mScrollState != 0) {
      return;
    }
    paramView = ReversedDataCollector.collect(paramView);
    int i = this.mExposureReportList.size();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("scrollEventReport start ");
    ((StringBuilder)localObject).append(i);
    SimpleTracer.begin(((StringBuilder)localObject).toString());
    localObject = this.mExposureReportList.iterator();
    DataEntity localDataEntity;
    PathData localPathData;
    while (((Iterator)localObject).hasNext())
    {
      localDataEntity = (DataEntity)((Iterator)localObject).next();
      localPathData = paramView.copy();
      localPathData.addFirst(localDataEntity);
      triggleDataEntityReport("imp", localDataEntity, localPathData);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("scrollEventReport start ");
    ((StringBuilder)localObject).append(i);
    SimpleTracer.end(((StringBuilder)localObject).toString());
    i = this.mExposureEndReportList.size();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("scrollEventReport end ");
    ((StringBuilder)localObject).append(i);
    SimpleTracer.begin(((StringBuilder)localObject).toString());
    localObject = this.mExposureEndReportList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      localDataEntity = (DataEntity)((Iterator)localObject).next();
      localPathData = paramView.copy();
      localPathData.addFirst(localDataEntity);
      triggleDataEntityReport("imp_end", localDataEntity, localPathData);
    }
    paramView = new StringBuilder();
    paramView.append("scrollEventReport end ");
    paramView.append(i);
    SimpleTracer.end(paramView.toString());
    this.mExposureAttachedList.clear();
    this.mExposureReportList.clear();
    this.mExposureEndReportList.clear();
    SimpleTracer.end("scrollEventReport");
  }
  
  private void triggleDataEntityReport(String paramString, DataEntity paramDataEntity, PathData paramPathData)
  {
    paramPathData = DataBuilderFactory.obtain().build(paramString, paramPathData);
    if (paramPathData == null) {
      return;
    }
    paramPathData.setEventKey(paramString);
    IEventDynamicParams localIEventDynamicParams = VideoReportInner.getInstance().getEventDynamicParams();
    if (localIEventDynamicParams != null) {
      localIEventDynamicParams.setEventDynamicParams(paramString, paramPathData.getEventParams());
    }
    paramPathData.put("dt_ele_scroll_flag", "1");
    if (paramString.equals("imp"))
    {
      paramPathData.put("dt_ele_is_first_scroll_imp", DataRWProxy.getExtendParam(paramDataEntity, "element_is_first_scroll_exposure"));
      paramPathData.put("dt_ele_is_first_imp", "0");
      paramPathData.put("dt_ele_reuse_id", DataRWProxy.getExtendParam(paramDataEntity, "element_exposure_reuseid"));
    }
    else if (paramString.equals("imp_end"))
    {
      paramPathData.put("element_lvtm", DataRWProxy.getExtendParam(paramDataEntity, "element_exposure_interval_time"));
      paramPathData.put("dt_element_area", "");
      paramPathData.put("dt_ele_imp_rate", "");
      paramPathData.put("dt_ele_imp_area", "");
    }
    FinalDataTarget.handle(null, paramPathData);
  }
  
  private EleExposeInfo updateScrollExposureInfo(Object paramObject, View paramView, String paramString)
  {
    paramObject = getOrNewEleExposeInfo(paramObject, paramView, paramString);
    if (paramObject.reportOverTime()) {
      paramObject.resetReport();
    }
    paramObject.onExpose();
    return paramObject;
  }
  
  public EleExposeInfo getOrNewEleExposeInfo(Object paramObject, View paramView, String paramString)
  {
    EleExposeInfo localEleExposeInfo2 = ExposurePolicyHelper.getEleExposeInfo(paramObject, paramView, paramString, true);
    EleExposeInfo localEleExposeInfo1 = localEleExposeInfo2;
    if (localEleExposeInfo2 == null)
    {
      localEleExposeInfo1 = new EleExposeInfo();
      ExposurePolicyHelper.putEleExposeInfo(paramObject, paramView, paramString, localEleExposeInfo1, true);
    }
    return localEleExposeInfo1;
  }
  
  public void onChildViewAttached(View paramView)
  {
    SimpleTracer.begin("onChildViewAttached");
    if (this.mScrollState == 0) {
      return;
    }
    DataEntity localDataEntity = DataRWProxy.getDataEntity(paramView, false);
    if (localDataEntity != null)
    {
      DataRWProxy.putExtendParam(localDataEntity, "element_exposure_time", Long.valueOf(System.currentTimeMillis()));
      Object localObject1 = DataEntityOperator.getInnerParam(localDataEntity, "element_identifier");
      boolean bool = localObject1 instanceof String;
      Object localObject3 = null;
      if (bool) {
        localObject1 = (String)localObject1;
      } else {
        localObject1 = null;
      }
      PageInfo localPageInfo = PageManager.getInstance().getCurrentPageInfo();
      Object localObject2;
      if (localPageInfo != null) {
        localObject2 = localPageInfo.getPage();
      } else {
        localObject2 = null;
      }
      if (ReportHelper.reportExposure(localObject2, (String)localObject1, paramView, true))
      {
        this.mExposureAttachedList.add(localDataEntity);
        localObject2 = localObject3;
        if (localPageInfo != null) {
          localObject2 = localPageInfo.getPage();
        }
        DataRWProxy.putExtendParam(localDataEntity, "element_is_first_scroll_exposure", String.valueOf(updateScrollExposureInfo(localObject2, paramView, (String)localObject1).hasReport() ^ true));
        DataRWProxy.putExtendParam(localDataEntity, "element_exposure_reuseid", localObject1);
      }
    }
    SimpleTracer.end("onChildViewAttached");
  }
  
  public void onChildViewDetached(View paramView)
  {
    SimpleTracer.begin("onChildViewDetached");
    if (this.mScrollState == 0) {
      return;
    }
    DataEntity localDataEntity = DataRWProxy.getDataEntity(paramView, false);
    if (this.mExposureAttachedList.contains(localDataEntity))
    {
      Object localObject1 = DataEntityOperator.getInnerParam(localDataEntity, "element_identifier");
      boolean bool = localObject1 instanceof String;
      Object localObject2 = null;
      if (bool) {
        localObject1 = (String)localObject1;
      } else {
        localObject1 = null;
      }
      PageInfo localPageInfo = PageManager.getInstance().getCurrentPageInfo();
      if (localPageInfo != null) {
        localObject2 = localPageInfo.getPage();
      }
      getOrNewEleExposeInfo(localObject2, paramView, (String)localObject1).onReport();
      this.mExposureAttachedList.remove(localDataEntity);
      localObject1 = DataEntityOperator.copy(localDataEntity);
      this.mExposureReportList.add(localObject1);
      DataRWProxy.putExtendParam((DataEntity)localObject1, "element_exposure_interval_time", String.valueOf(System.currentTimeMillis() - ((Long)DataRWProxy.getExtendParam((DataEntity)localObject1, "element_exposure_time")).longValue()));
      if (ReportHelper.reportEndExposure(paramView, true)) {
        this.mExposureEndReportList.add(localObject1);
      }
    }
    SimpleTracer.end("onChildViewDetached");
  }
  
  public void onScrollStateChanged(View paramView, int paramInt)
  {
    this.mScrollState = paramInt;
    if (this.mScrollState != 0) {
      return;
    }
    ScrollableViewExposureReport.DetectionTask localDetectionTask = this.mDetectionTask;
    localDetectionTask.mScrollView = paramView;
    this.mDelayedIdleHandler.remove(localDetectionTask);
    this.mDelayedIdleHandler.post(this.mDetectionTask, 20L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.report.scroll.ScrollableViewExposureReport
 * JD-Core Version:    0.7.0.1
 */