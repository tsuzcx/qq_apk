package com.tencent.qqlive.module.videoreport.report.element;

import com.tencent.qqlive.module.videoreport.exposure.AreaInfo;
import com.tencent.qqlive.module.videoreport.report.FinalDataTarget;
import com.tencent.qqlive.module.videoreport.reportdata.FinalData;
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
    if (!paramExposureInfoWrapper.canReportExposureEnd) {
      return;
    }
    FinalData localFinalData = paramExposureInfoWrapper.finalData;
    if (localFinalData == null) {
      return;
    }
    localFinalData.setEventKey("imp_end");
    localFinalData.eventParams.put("element_lvtm", String.valueOf(paramLong));
    AreaInfo localAreaInfo = paramExposureInfoWrapper.areaInfo;
    double d1 = 0.0D;
    paramLong = 0L;
    long l;
    if (localAreaInfo != null)
    {
      paramLong = localAreaInfo.viewArea;
      l = localAreaInfo.exposureArea;
      if (paramLong != 0L)
      {
        d1 = l;
        double d2 = paramLong;
        Double.isNaN(d1);
        Double.isNaN(d2);
        d1 /= d2;
      }
    }
    else
    {
      l = 0L;
    }
    localFinalData.eventParams.put("element_area", String.valueOf(paramLong));
    localFinalData.eventParams.put("ele_imp_area", String.valueOf(l));
    localFinalData.eventParams.put("ele_imp_rate", String.format(Locale.getDefault(), "%.2f", new Object[] { Double.valueOf(d1) }));
    FinalDataTarget.handle(paramExposureInfoWrapper.exposureView, localFinalData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.report.element.ElementExposureEndReporter
 * JD-Core Version:    0.7.0.1
 */