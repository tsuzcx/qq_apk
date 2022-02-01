package com.tencent.qqlive.module.videoreport.report.element;

import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.view.View;
import com.tencent.qqlive.module.videoreport.data.DataBinder;
import com.tencent.qqlive.module.videoreport.data.DataEntity;
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
  
  public ElementExposureReporter.ReportDetectionData createDetectionData()
  {
    return new ElementExposureReporter.ReportDetectionData();
  }
  
  public boolean onEnter(View paramView, ElementExposureReporter.ReportDetectionData paramReportDetectionData)
  {
    if ((PageFinder.findRelatedPage(paramView) != null) && (paramView != this.mEntryView))
    {
      ElementExposureReporter.access$700(this.this$0, paramView, this.mFrontPageArea);
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
    DataEntity localDataEntity = DataBinder.getDataEntity(paramView);
    if (!ReportHelper.reportExposure(localDataEntity)) {}
    Object localObject;
    long l;
    do
    {
      return;
      localObject = DataRWProxy.getInnerParam(paramView, "element_identifier");
      if (!(localObject instanceof String)) {
        break label162;
      }
      localObject = (String)localObject;
      l = ReportUtils.calcElementUniqueId(paramView);
      if (!ElementExposureReporter.access$100(this.this$0, l)) {
        break label168;
      }
      paramAreaInfo = getPathData(paramReportDetectionData, paramView, localDataEntity);
      if (paramAreaInfo == null) {
        break;
      }
      paramReportDetectionData = new ExposureElementInfo();
      paramReportDetectionData.setView(paramView);
      paramReportDetectionData.setPage(paramAreaInfo.getPage());
      paramReportDetectionData.setIdentifier((String)localObject);
      paramReportDetectionData.setUniqueId(l);
      paramView = DataBuilderFactory.obtain().build(paramAreaInfo);
    } while (paramView == null);
    paramView.setEventKey("imp");
    paramReportDetectionData.setFinalData(paramView);
    ElementExposureReporter.access$500(this.this$0).add(paramReportDetectionData);
    for (;;)
    {
      ElementExposureReporter.access$600(this.this$0).put(Long.valueOf(l), localObject);
      return;
      label162:
      localObject = null;
      break;
      label168:
      ElementExposureReporter.access$200(this.this$0).updateAreaInfo(l, paramAreaInfo);
    }
  }
  
  public void onLeave(View paramView, ElementExposureReporter.ReportDetectionData paramReportDetectionData) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.report.element.ElementExposureReporter.ElementExposureCallBack
 * JD-Core Version:    0.7.0.1
 */