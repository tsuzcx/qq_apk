package com.tencent.qqlive.module.videoreport.report.element;

import android.support.annotation.NonNull;
import android.view.View;
import com.tencent.qqlive.module.videoreport.exposure.AreaInfo;
import com.tencent.qqlive.module.videoreport.reportdata.DataBuilderFactory;
import com.tencent.qqlive.module.videoreport.reportdata.FinalData;
import com.tencent.qqlive.module.videoreport.reportdata.IDataBuilder;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class IExposureRecorder$ExposureInfoWrapper
{
  AreaInfo areaInfo;
  final WeakReference<Object> attachedPage;
  final boolean canReportExposureEnd;
  final long exposureTime;
  final WeakReference<View> exposureView;
  final FinalData finalData;
  
  public IExposureRecorder$ExposureInfoWrapper(ExposureElementInfo paramExposureElementInfo, long paramLong)
  {
    this.exposureTime = paramLong;
    this.exposureView = new WeakReference(paramExposureElementInfo.getView());
    this.attachedPage = new WeakReference(paramExposureElementInfo.getPage());
    this.canReportExposureEnd = ReportHelper.reportEndExposure(paramExposureElementInfo.getView(), false);
    this.finalData = DataBuilderFactory.obtain().build("imp_end", paramExposureElementInfo.getPathData());
  }
  
  @NonNull
  private Map<String, Object> deepCopy(Map<String, Object> paramMap, String paramString)
  {
    HashMap localHashMap = new HashMap();
    if (paramMap == null) {
      return localHashMap;
    }
    paramMap = paramMap.get(paramString);
    if ((paramMap instanceof Map)) {
      localHashMap.putAll((Map)paramMap);
    }
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.report.element.IExposureRecorder.ExposureInfoWrapper
 * JD-Core Version:    0.7.0.1
 */