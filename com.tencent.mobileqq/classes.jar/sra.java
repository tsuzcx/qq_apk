import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView.2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.core.ViolaEnvironment;

public class sra
  implements smq
{
  public sra(ViolaBaseView.2 param2, long paramLong) {}
  
  public void a()
  {
    if (ViolaBaseView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView$2.this$0) != null) {
      ViolaBaseView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView$2.this$0).b();
    }
    ViolaBaseView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView$2.this$0, 1);
    QLog.e(ViolaBaseView.a(), 2, "ThreadManager 执行 onViolaSDKError");
  }
  
  public void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d(ViolaBaseView.a(), 2, "ThreadManager 执行 onViolaSDKSucc");
    }
    if (ViolaBaseView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView$2.this$0) != null) {
      ViolaBaseView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView$2.this$0).a();
    }
    if (paramLong != 0L)
    {
      ViolaBaseView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView$2.this$0).addReportData(ViolaEnvironment.TIME_SDK_MAIN, Long.toString(paramLong));
      ViolaBaseView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView$2.this$0).addReportData(ViolaEnvironment.TIME_SDK_INIT, Long.toString(System.currentTimeMillis() - this.jdField_a_of_type_Long));
    }
    ViolaBaseView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView$2.this$0, true);
    ViolaBaseView.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView$2.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     sra
 * JD-Core Version:    0.7.0.1
 */