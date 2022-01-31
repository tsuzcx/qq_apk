import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyBaseDeliverActivity;
import com.tencent.mobileqq.widget.QQToast;

public class lby
  implements Runnable
{
  public lby(ReadInJoyBaseDeliverActivity paramReadInJoyBaseDeliverActivity, int paramInt) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyBaseDeliverActivity.e) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyBaseDeliverActivity.h();
    QQToast.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyBaseDeliverActivity, 1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyBaseDeliverActivity.getString(this.jdField_a_of_type_Int), 0).b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyBaseDeliverActivity.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lby
 * JD-Core Version:    0.7.0.1
 */