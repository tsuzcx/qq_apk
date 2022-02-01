package com.tencent.mobileqq.kandian.glue.video.player;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.video.player.data.ReadInJoyVideoReportData;
import com.tencent.mobileqq.kandian.biz.playfeeds.QualityReporter;
import com.tencent.mobileqq.kandian.glue.report.RIJStatisticCollectorReport;

class ReadinjoyPlayerReporter$1
  implements Runnable
{
  ReadinjoyPlayerReporter$1(ReadinjoyPlayerReporter paramReadinjoyPlayerReporter, ReadInJoyVideoReportData paramReadInJoyVideoReportData) {}
  
  public void run()
  {
    RIJStatisticCollectorReport.a(BaseApplicationImpl.getContext(), RIJQQAppInterfaceUtil.a(), true, this.a.a());
    QualityReporter.a(this.a);
    RIJStatisticCollectorReport.a(this.a.a, this.a.jdField_d_of_type_Boolean, this.a.i, this.a.jdField_b_of_type_Int, this.a.jdField_d_of_type_Long, 409409, this.a.jdField_d_of_type_JavaLangString, this.a.jdField_b_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.video.player.ReadinjoyPlayerReporter.1
 * JD-Core Version:    0.7.0.1
 */