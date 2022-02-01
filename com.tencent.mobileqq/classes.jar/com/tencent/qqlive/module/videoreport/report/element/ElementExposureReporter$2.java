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
    Object localObject2 = paramExposureElementInfo.getPage();
    Object localObject1 = UIUtils.getExposureAreaInfo(localView);
    long l = paramExposureElementInfo.getUniqueId();
    String str = paramExposureElementInfo.getIdentifier();
    if ((localObject1 != null) && (ReportHelper.isViewExposed(localView, ((AreaInfo)localObject1).exposureRate)) && (ElementExposureReporter.access$200(this.this$0, l)))
    {
      ElementExposureReporter.access$300(this.this$0).markExposed(paramExposureElementInfo);
      ElementExposureReporter.access$300(this.this$0).updateAreaInfo(l, (AreaInfo)localObject1);
      if (paramExposureElementInfo.canReport())
      {
        localObject1 = VideoReportInner.getInstance().getEventDynamicParams();
        FinalData localFinalData = paramExposureElementInfo.getFinalData();
        if (localFinalData == null) {
          return;
        }
        if (localObject1 != null) {
          ((IEventDynamicParams)localObject1).setEventDynamicParams("imp", localFinalData.getEventParams());
        }
        localFinalData.put("dt_ele_reuse_id", str);
        localObject1 = ExposurePolicyHelper.getEleExposeInfo(localObject2, localView, str);
        paramExposureElementInfo = (ExposureElementInfo)localObject1;
        if (localObject1 == null)
        {
          paramExposureElementInfo = new EleExposeInfo();
          ExposurePolicyHelper.putEleExposeInfo(localObject2, localView, str, paramExposureElementInfo);
        }
        localFinalData.put("dt_ele_is_first_imp", String.valueOf(paramExposureElementInfo.mHasReport ^ true));
        FinalDataTarget.handle(localView, localFinalData);
        paramExposureElementInfo.onReport();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.report.element.ElementExposureReporter.2
 * JD-Core Version:    0.7.0.1
 */