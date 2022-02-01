package com.tencent.qqlive.module.videoreport.report.element;

import android.support.v4.util.ArrayMap;
import com.tencent.qqlive.module.videoreport.exposure.AreaInfo;
import com.tencent.qqlive.module.videoreport.report.FinalDataTarget;
import com.tencent.qqlive.module.videoreport.reportdata.FinalData;
import com.tencent.qqlive.module.videoreport.utils.ReusablePool;
import java.util.Locale;
import java.util.Map;

public class ElementExposureEndReporter
  implements IExposureRecorder.OnExposureStatusListener
{
  public static ElementExposureEndReporter getInstance()
  {
    return ElementExposureEndReporter.InstanceHolder.INSTANCE;
  }
  
  public void onViewUnexposed(IExposureRecorder.ExposureInfoWrapper paramExposureInfoWrapper, long paramLong)
  {
    double d = 0.0D;
    long l = 0L;
    if (!paramExposureInfoWrapper.canReportExposureEnd) {
      return;
    }
    FinalData localFinalData = (FinalData)ReusablePool.obtain(6);
    localFinalData.eventKey = "imp_end";
    localFinalData.eventParams = new ArrayMap();
    if (paramExposureInfoWrapper.exposureParams != null) {
      localFinalData.eventParams.putAll(paramExposureInfoWrapper.exposureParams);
    }
    localFinalData.eventParams.put("element_lvtm", String.valueOf(paramLong));
    AreaInfo localAreaInfo = paramExposureInfoWrapper.areaInfo;
    if (localAreaInfo != null)
    {
      l = localAreaInfo.viewArea;
      paramLong = localAreaInfo.exposureArea;
      if (l != 0L) {}
    }
    for (;;)
    {
      localFinalData.eventParams.put("element_area", String.valueOf(l));
      localFinalData.eventParams.put("ele_imp_area", String.valueOf(paramLong));
      localFinalData.eventParams.put("ele_imp_rate", String.format(Locale.getDefault(), "%.2f", new Object[] { Double.valueOf(d) }));
      FinalDataTarget.handle(paramExposureInfoWrapper.exposureView, localFinalData);
      return;
      d = paramLong / l;
      continue;
      paramLong = 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.report.element.ElementExposureEndReporter
 * JD-Core Version:    0.7.0.1
 */