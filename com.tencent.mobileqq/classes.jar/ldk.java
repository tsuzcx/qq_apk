import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;

public class ldk
  implements Runnable
{
  public ldk(ReadInJoyNewFeedsActivity paramReadInJoyNewFeedsActivity, int paramInt) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Int <= 0)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyNewFeedsActivity.a.setText(2131433297);
      return;
    }
    if (this.jdField_a_of_type_Int > 99)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyNewFeedsActivity.a.setText(String.format("%s(%d+)", new Object[] { this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyNewFeedsActivity.getString(2131433297), Integer.valueOf(99) }));
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyNewFeedsActivity.a.setText(String.format("%s(%d)", new Object[] { this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyNewFeedsActivity.getString(2131433297), Integer.valueOf(this.jdField_a_of_type_Int) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ldk
 * JD-Core Version:    0.7.0.1
 */