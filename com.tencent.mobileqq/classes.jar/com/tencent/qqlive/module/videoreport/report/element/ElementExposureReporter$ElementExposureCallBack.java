package com.tencent.qqlive.module.videoreport.report.element;

import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import com.tencent.qqlive.module.videoreport.data.DataBinder;
import com.tencent.qqlive.module.videoreport.data.DataEntity;
import com.tencent.qqlive.module.videoreport.data.DataEntityOperator;
import com.tencent.qqlive.module.videoreport.data.DataRWProxy;
import com.tencent.qqlive.module.videoreport.exposure.AreaInfo;
import com.tencent.qqlive.module.videoreport.exposure.IExposureDetectCallback;
import com.tencent.qqlive.module.videoreport.page.PageFinder;
import com.tencent.qqlive.module.videoreport.page.PageInfo;
import com.tencent.qqlive.module.videoreport.reportdata.DataBuilderFactory;
import com.tencent.qqlive.module.videoreport.reportdata.FinalData;
import com.tencent.qqlive.module.videoreport.reportdata.IDataBuilder;
import com.tencent.qqlive.module.videoreport.reportdata.PathData;
import com.tencent.qqlive.module.videoreport.reportdata.PathDataUtils;
import com.tencent.qqlive.module.videoreport.utils.ReportUtils;
import java.util.List;
import java.util.Map;

class ElementExposureReporter$ElementExposureCallBack
  implements IExposureDetectCallback<ElementExposureReporter.ReportDetectionData>
{
  private View mEntryView;
  private Rect mFrontPageArea;
  
  ElementExposureReporter$ElementExposureCallBack(ElementExposureReporter paramElementExposureReporter, View paramView, Rect paramRect)
  {
    this.mEntryView = paramView;
    this.mFrontPageArea = paramRect;
  }
  
  private PathData getPathData(ElementExposureReporter.ReportDetectionData paramReportDetectionData, View paramView, DataEntity paramDataEntity)
  {
    PathData localPathData = null;
    if (paramReportDetectionData.pathDatas.containsKey(paramView)) {
      return (PathData)paramReportDetectionData.pathDatas.get(paramView);
    }
    Object localObject = PageFinder.findRelatedPage(paramView);
    if (localObject != null)
    {
      localPathData = new PathData();
      localPathData.setPage(((PageInfo)localObject).getPage());
      if (PathDataUtils.canCollect(paramDataEntity)) {
        localPathData.addFirst(paramDataEntity);
      }
      paramReportDetectionData.pathDatas.put(paramView, localPathData);
      return localPathData;
    }
    localObject = ReportHelper.findPathParent(paramView, paramDataEntity);
    if (localObject == null)
    {
      paramReportDetectionData.pathDatas.put(paramView, null);
      return null;
    }
    localObject = getPathData(paramReportDetectionData, (View)localObject, DataBinder.getDataEntity(localObject));
    if (localObject != null)
    {
      localPathData = ((PathData)localObject).copy();
      localPathData.addFirst(paramDataEntity);
    }
    paramReportDetectionData.pathDatas.put(paramView, localPathData);
    return localPathData;
  }
  
  private void updateEleExpose(View paramView, String paramString, PathData paramPathData)
  {
    Object localObject = paramPathData.getPage();
    EleExposeInfo localEleExposeInfo = ExposurePolicyHelper.getEleExposeInfo(localObject, paramView, paramString);
    paramPathData = localEleExposeInfo;
    if (localEleExposeInfo == null)
    {
      paramPathData = new EleExposeInfo();
      ExposurePolicyHelper.putEleExposeInfo(localObject, paramView, paramString, paramPathData);
    }
    if (paramPathData.reportOverTime()) {
      paramPathData.resetReport();
    }
    paramPathData.onExpose();
  }
  
  public ElementExposureReporter.ReportDetectionData createDetectionData()
  {
    return new ElementExposureReporter.ReportDetectionData();
  }
  
  public boolean onEnter(View paramView, ElementExposureReporter.ReportDetectionData paramReportDetectionData)
  {
    if ((PageFinder.findRelatedPage(paramView) != null) && (paramView != this.mEntryView))
    {
      ElementExposureReporter.access$800(this.this$0, paramView, this.mFrontPageArea);
      return false;
    }
    paramView = (Boolean)DataRWProxy.getInnerParam(paramView, "element_detection_enable");
    if (paramView != null) {
      return paramView.booleanValue();
    }
    return true;
  }
  
  public void onExposed(View paramView, ElementExposureReporter.ReportDetectionData paramReportDetectionData, @NonNull AreaInfo paramAreaInfo)
  {
    Object localObject2 = DataBinder.getDataEntity(paramView);
    if ((localObject2 == null) || (TextUtils.isEmpty(DataEntityOperator.getElementId((DataEntity)localObject2)))) {
      return;
    }
    Object localObject1 = DataRWProxy.getInnerParam(paramView, "element_identifier");
    if ((localObject1 instanceof String)) {}
    for (localObject1 = (String)localObject1;; localObject1 = null)
    {
      long l = ReportUtils.calcElementUniqueId(paramView);
      paramReportDetectionData = getPathData(paramReportDetectionData, paramView, (DataEntity)localObject2);
      if (paramReportDetectionData == null) {
        break;
      }
      if (ElementExposureReporter.access$200(this.this$0, l))
      {
        localObject2 = new ExposureElementInfo();
        ((ExposureElementInfo)localObject2).setView(paramView);
        ((ExposureElementInfo)localObject2).setPage(paramReportDetectionData.getPage());
        ((ExposureElementInfo)localObject2).setIdentifier((String)localObject1);
        ((ExposureElementInfo)localObject2).setUniqueId(l);
        ((ExposureElementInfo)localObject2).setCanReport(ReportHelper.reportExposure(((ExposureElementInfo)localObject2).getPage(), (String)localObject1, paramView));
        FinalData localFinalData = DataBuilderFactory.obtain().build(paramReportDetectionData);
        if (localFinalData != null) {
          localFinalData.setEventKey("imp");
        }
        ((ExposureElementInfo)localObject2).setFinalData(localFinalData);
        ElementExposureReporter.access$600(this.this$0).add(localObject2);
      }
      ElementExposureReporter.access$300(this.this$0).updateAreaInfo(l, paramAreaInfo);
      updateEleExpose(paramView, (String)localObject1, paramReportDetectionData);
      ElementExposureReporter.access$700(this.this$0).put(Long.valueOf(l), localObject1);
      return;
    }
  }
  
  public void onLeave(View paramView, ElementExposureReporter.ReportDetectionData paramReportDetectionData) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.report.element.ElementExposureReporter.ElementExposureCallBack
 * JD-Core Version:    0.7.0.1
 */