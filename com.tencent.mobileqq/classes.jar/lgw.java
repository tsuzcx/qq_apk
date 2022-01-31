import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoySettingActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class lgw
  implements Runnable
{
  public lgw(ReadInJoySettingActivity paramReadInJoySettingActivity, int paramInt) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoySettingActivity.jdField_a_of_type_Int > 0) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoySettingActivity.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoySettingActivity.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(this.jdField_a_of_type_Int);
      if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoySettingActivity.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoySettingActivity.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lgw
 * JD-Core Version:    0.7.0.1
 */