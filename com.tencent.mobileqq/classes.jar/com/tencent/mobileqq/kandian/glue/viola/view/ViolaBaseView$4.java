package com.tencent.mobileqq.kandian.glue.viola.view;

import com.tencent.mobileqq.kandian.biz.fastweb.LoadLibCallback;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyWebRenderEngine;
import com.tencent.mobileqq.kandian.glue.viola.adapter.ViolaReportDelegate;
import com.tencent.mobileqq.kandian.glue.viola.so.ViolaSoLoaderManager;
import com.tencent.mobileqq.kandian.glue.viola.so.ViolaSoLoaderManager.Companion;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.core.ViolaEnvironment;

class ViolaBaseView$4
  implements LoadLibCallback
{
  ViolaBaseView$4(ViolaBaseView paramViolaBaseView, int paramInt) {}
  
  public void onError(int paramInt)
  {
    if ((this.jdField_a_of_type_Int == ViolaBaseView.c()) && (ViolaSoLoaderManager.a.a().b()))
    {
      ViolaBaseView.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView, System.currentTimeMillis());
      ViolaBaseView.c(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView);
    }
    else
    {
      ViolaBaseView.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView, 100);
    }
    String str = ViolaBaseView.b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("loadSoIfNeed error,code=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(",isActivityDestroy:");
    localStringBuilder.append(ViolaBaseView.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView));
    QLog.e(str, 2, localStringBuilder.toString());
  }
  
  public void onFinish(int paramInt)
  {
    if (paramInt == ReadInJoyWebRenderEngine.g)
    {
      ViolaBaseView.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView).addReportData(ViolaEnvironment.KEY_SO, ViolaEnvironment.SO_END_EXIT);
    }
    else if (this.jdField_a_of_type_Int == ViolaBaseView.c())
    {
      ViolaBaseView.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView).addReportData(ViolaEnvironment.KEY_SO, ViolaEnvironment.SO_END_NET);
      ViolaBaseView.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView).addReportData(ViolaEnvironment.TIME_SO, Long.toString(System.currentTimeMillis() - ViolaBaseView.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView)));
    }
    else
    {
      ViolaBaseView.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView).addReportData(ViolaEnvironment.KEY_SO, ViolaEnvironment.SO_END_OFFLINE);
      ViolaBaseView.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView).addReportData(ViolaEnvironment.TIME_SO, Long.toString(System.currentTimeMillis() - ViolaBaseView.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView)));
    }
    ViolaBaseView.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView);
    ViolaBaseView.b(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.view.ViolaBaseView.4
 * JD-Core Version:    0.7.0.1
 */