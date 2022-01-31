import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyFeedsActivity;

public class ldf
  implements Runnable
{
  public ldf(ReadInJoyFeedsActivity paramReadInJoyFeedsActivity, int paramInt) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Int <= 0)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyFeedsActivity.a.setText(2131433280);
      return;
    }
    if (this.jdField_a_of_type_Int > 99)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyFeedsActivity.a.setText(String.format("%s(%d+)", new Object[] { this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyFeedsActivity.getString(2131433280), Integer.valueOf(99) }));
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyFeedsActivity.a.setText(String.format("%s(%d)", new Object[] { this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyFeedsActivity.getString(2131433280), Integer.valueOf(this.jdField_a_of_type_Int) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ldf
 * JD-Core Version:    0.7.0.1
 */