package com.tencent.qqlive.module.videoreport.report.element;

import android.support.annotation.NonNull;
import android.view.View;
import com.tencent.qqlive.module.videoreport.exposure.AreaInfo;
import com.tencent.qqlive.module.videoreport.reportdata.FinalData;
import java.lang.ref.WeakReference;
import java.util.HashMap;
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
    this.exposureParams = new HashMap();
    paramExposureElementInfo = paramExposureElementInfo.getFinalData();
    if ((paramExposureElementInfo != null) && (paramExposureElementInfo.eventParams != null))
    {
      paramExposureElementInfo = paramExposureElementInfo.eventParams;
      Map localMap1 = deepCopy(paramExposureElementInfo, "cur_pg");
      Map localMap2 = deepCopy(localMap1, "ref_pg");
      this.exposureParams.putAll(paramExposureElementInfo);
      this.exposureParams.put("cur_pg", localMap1);
      localMap1.put("ref_pg", localMap2);
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.report.element.IExposureRecorder.ExposureInfoWrapper
 * JD-Core Version:    0.7.0.1
 */