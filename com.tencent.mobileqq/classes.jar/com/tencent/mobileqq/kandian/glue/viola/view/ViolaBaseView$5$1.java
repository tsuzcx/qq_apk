package com.tencent.mobileqq.kandian.glue.viola.view;

import com.tencent.mobileqq.kandian.glue.viola.ViolaAccessHelper.SDKInitCallback;
import com.tencent.mobileqq.kandian.glue.viola.adapter.ViolaReportDelegate;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.core.ViolaEnvironment;

class ViolaBaseView$5$1
  implements ViolaAccessHelper.SDKInitCallback
{
  ViolaBaseView$5$1(ViolaBaseView.5 param5, long paramLong) {}
  
  public void a()
  {
    if (ViolaBaseView.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView$5.this$0) != null) {
      ViolaBaseView.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView$5.this$0).b();
    }
    ViolaBaseView.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView$5.this$0, 1);
    QLog.e(ViolaBaseView.b(), 2, "ThreadManager 执行 onViolaSDKError");
  }
  
  public void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d(ViolaBaseView.b(), 2, "ThreadManager 执行 onViolaSDKSucc");
    }
    if (ViolaBaseView.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView$5.this$0) != null) {
      ViolaBaseView.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView$5.this$0).a();
    }
    if (paramLong != 0L)
    {
      ViolaBaseView.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView$5.this$0).addReportData(ViolaEnvironment.TIME_SDK_MAIN, Long.toString(paramLong));
      ViolaBaseView.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView$5.this$0).addReportData(ViolaEnvironment.TIME_SDK_INIT, Long.toString(System.currentTimeMillis() - this.jdField_a_of_type_Long));
    }
    ViolaBaseView.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView$5.this$0, true);
    if (ViolaBaseView.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView$5.this$0) == null) {
      ViolaBaseView.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView$5.this$0, null);
    }
    ViolaBaseView.d(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView$5.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.view.ViolaBaseView.5.1
 * JD-Core Version:    0.7.0.1
 */