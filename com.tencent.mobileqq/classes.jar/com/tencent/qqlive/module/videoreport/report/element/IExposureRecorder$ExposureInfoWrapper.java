package com.tencent.qqlive.module.videoreport.report.element;

import android.support.v4.util.ArrayMap;
import android.view.View;
import com.tencent.qqlive.module.videoreport.exposure.AreaInfo;
import com.tencent.qqlive.module.videoreport.reportdata.FinalData;
import java.lang.ref.WeakReference;
import java.util.Map;

public class IExposureRecorder$ExposureInfoWrapper
{
  AreaInfo areaInfo;
  final WeakReference<Object> attachedPage;
  final Map<String, Object> exposureParams;
  final long exposureTime;
  final WeakReference<View> exposureView;
  
  public IExposureRecorder$ExposureInfoWrapper(ExposureElementInfo paramExposureElementInfo, long paramLong)
  {
    this.exposureTime = paramLong;
    this.exposureView = new WeakReference(paramExposureElementInfo.getView());
    this.attachedPage = new WeakReference(paramExposureElementInfo.getPage());
    this.exposureParams = new ArrayMap();
    paramExposureElementInfo = paramExposureElementInfo.getFinalData();
    if ((paramExposureElementInfo != null) && (paramExposureElementInfo.eventParams != null)) {
      this.exposureParams.putAll(paramExposureElementInfo.eventParams);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.report.element.IExposureRecorder.ExposureInfoWrapper
 * JD-Core Version:    0.7.0.1
 */