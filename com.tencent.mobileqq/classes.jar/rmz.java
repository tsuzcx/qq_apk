import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.core.ViolaEnvironment;

public class rmz
  implements ohk
{
  public rmz(ViolaBaseView paramViolaBaseView, int paramInt) {}
  
  public void onError(int paramInt)
  {
    if (this.jdField_a_of_type_Int == ViolaBaseView.b())
    {
      ViolaBaseView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView, System.currentTimeMillis());
      ViolaBaseView.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView);
    }
    for (;;)
    {
      QLog.e(ViolaBaseView.a(), 2, "loadSoIfNeed error,code=" + paramInt);
      return;
      ViolaBaseView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView, 100);
    }
  }
  
  public void onFinish(int paramInt)
  {
    if (paramInt == ohi.g) {
      ViolaBaseView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView).addReportData(ViolaEnvironment.KEY_SO, ViolaEnvironment.SO_END_EXIT);
    }
    for (;;)
    {
      ViolaBaseView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView);
      ViolaBaseView.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView);
      return;
      if (this.jdField_a_of_type_Int == ViolaBaseView.b())
      {
        ViolaBaseView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView).addReportData(ViolaEnvironment.KEY_SO, ViolaEnvironment.SO_END_NET);
        ViolaBaseView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView).addReportData(ViolaEnvironment.TIME_SO, Long.toString(System.currentTimeMillis() - ViolaBaseView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView)));
      }
      else
      {
        ViolaBaseView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView).addReportData(ViolaEnvironment.KEY_SO, ViolaEnvironment.SO_END_OFFLINE);
        ViolaBaseView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView).addReportData(ViolaEnvironment.TIME_SO, Long.toString(System.currentTimeMillis() - ViolaBaseView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView)));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rmz
 * JD-Core Version:    0.7.0.1
 */