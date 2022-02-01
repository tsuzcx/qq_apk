package com.tencent.mobileqq.qcircle.api.constant;

import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qroute.QRoute;

final class QCirclePeriodCollect$1
  implements Runnable
{
  QCirclePeriodCollect$1(String paramString) {}
  
  public void run()
  {
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).reportLaunchPeriodEvent(new QCircleAlphaUserReportDataBuilder().setType(this.val$type).setState(QCirclePeriodCollect.access$400(this.val$type)).setAttachInfo(QCirclePeriodCollect.getPeriodStr(this.val$type)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.constant.QCirclePeriodCollect.1
 * JD-Core Version:    0.7.0.1
 */