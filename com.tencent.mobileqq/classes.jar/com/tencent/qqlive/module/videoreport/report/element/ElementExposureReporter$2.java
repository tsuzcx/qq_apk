package com.tencent.qqlive.module.videoreport.report.element;

import android.view.View;
import com.tencent.qqlive.module.videoreport.IEventDynamicParams;
import com.tencent.qqlive.module.videoreport.exposure.AreaInfo;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.report.FinalDataTarget;
import com.tencent.qqlive.module.videoreport.reportdata.FinalData;
import com.tencent.qqlive.module.videoreport.utils.UIUtils;

class ElementExposureReporter$2
  implements PendingQueue.OnQueueListener
{
  ElementExposureReporter$2(ElementExposureReporter paramElementExposureReporter) {}
  
  public void onDequeue(ExposureElementInfo paramExposureElementInfo)
  {
    View localView = paramExposureElementInfo.getView();
    Object localObject = UIUtils.getExposureAreaInfo(localView);
    long l = paramExposureElementInfo.getUniqueId();
    if ((localObject != null) && (ReportHelper.isViewExposed(localView, ((AreaInfo)localObject).exposureRate)) && (ElementExposureReporter.access$100(this.this$0, l)))
    {
      ElementExposureReporter.access$200(this.this$0).markExposed(paramExposureElementInfo);
      ElementExposureReporter.access$200(this.this$0).updateAreaInfo(l, (AreaInfo)localObject);
      localObject = VideoReportInner.getInstance().getEventDynamicParams();
      if ((localObject != null) && (paramExposureElementInfo.getFinalData() != null)) {
        ((IEventDynamicParams)localObject).setEventDynamicParams("imp", paramExposureElementInfo.getFinalData().getEventParams());
      }
      FinalDataTarget.handle(localView, paramExposureElementInfo.getFinalData());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.report.element.ElementExposureReporter.2
 * JD-Core Version:    0.7.0.1
 */