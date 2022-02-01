package com.tencent.mobileqq.kandian.glue.report;

import android.content.Context;
import com.tencent.mobileqq.kandian.biz.feeds.api.IRIJChannelStayTimeMonitor;
import com.tencent.mobileqq.kandian.biz.feeds.controller.ReadInJoyBaseViewController;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.Map;

class RIJFrameworkReportManager$2
  implements Runnable
{
  RIJFrameworkReportManager$2(RIJFrameworkReportManager paramRIJFrameworkReportManager, boolean paramBoolean1, Map paramMap1, boolean paramBoolean2, Map paramMap2, String paramString, Context paramContext, int paramInt1, int paramInt2, ReadInJoyBaseViewController paramReadInJoyBaseViewController, boolean paramBoolean3, long paramLong) {}
  
  public void run()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.this$0.a(this.jdField_a_of_type_JavaUtilMap, this.jdField_b_of_type_Boolean, this.jdField_b_of_type_JavaUtilMap, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyBaseViewController, this.c, this.jdField_a_of_type_Long);
      return;
    }
    if (((IRIJChannelStayTimeMonitor)QRoute.api(IRIJChannelStayTimeMonitor.class)).isChannelShow(this.jdField_a_of_type_Int)) {
      this.this$0.a(this.jdField_a_of_type_JavaUtilMap, this.jdField_b_of_type_Boolean, this.jdField_b_of_type_JavaUtilMap, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyBaseViewController, this.c, this.jdField_a_of_type_Long);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.report.RIJFrameworkReportManager.2
 * JD-Core Version:    0.7.0.1
 */