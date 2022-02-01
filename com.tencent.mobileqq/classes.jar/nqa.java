import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import com.tencent.biz.lebasearch.LebaSearchPluginManagerActivity;
import com.tencent.biz.pubaccount.AccountDetailBounceScrollView;

class nqa
  extends Handler
{
  nqa(npz paramnpz) {}
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if (this.a.jdField_a_of_type_Int == this.a.jdField_a_of_type_ComTencentBizLebasearchLebaSearchPluginManagerActivity.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBounceScrollView.getScrollY())
    {
      if ((this.a.jdField_a_of_type_Int > 0) && (!this.a.jdField_a_of_type_ComTencentBizLebasearchLebaSearchPluginManagerActivity.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBounceScrollView.a()))
      {
        int i = this.a.jdField_a_of_type_Int;
        i = (int)(this.a.jdField_a_of_type_ComTencentBizLebasearchLebaSearchPluginManagerActivity.jdField_b_of_type_Int * (1.0D - LebaSearchPluginManagerActivity.jdField_a_of_type_Double) + this.a.jdField_a_of_type_Int);
        int j = (int)(this.a.jdField_a_of_type_Int - (this.a.jdField_a_of_type_ComTencentBizLebasearchLebaSearchPluginManagerActivity.jdField_b_of_type_AndroidWidgetTextView.getHeight() + this.a.jdField_a_of_type_ComTencentBizLebasearchLebaSearchPluginManagerActivity.jdField_a_of_type_Float * 56.0F - this.a.jdField_a_of_type_ComTencentBizLebasearchLebaSearchPluginManagerActivity.jdField_b_of_type_Int * (1.0D - LebaSearchPluginManagerActivity.jdField_a_of_type_Double)));
        if ((i > this.a.jdField_a_of_type_ComTencentBizLebasearchLebaSearchPluginManagerActivity.jdField_b_of_type_AndroidWidgetTextView.getHeight() + this.a.jdField_a_of_type_ComTencentBizLebasearchLebaSearchPluginManagerActivity.jdField_a_of_type_Float * 56.0F) || (i > this.a.jdField_a_of_type_ComTencentBizLebasearchLebaSearchPluginManagerActivity.jdField_b_of_type_AndroidWidgetTextView.getHeight())) {
          this.a.jdField_a_of_type_ComTencentBizLebasearchLebaSearchPluginManagerActivity.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBounceScrollView.scrollBy(0, -j);
        }
      }
      return;
    }
    this.a.jdField_a_of_type_Int = this.a.jdField_a_of_type_ComTencentBizLebasearchLebaSearchPluginManagerActivity.jdField_a_of_type_ComTencentBizPubaccountAccountDetailBounceScrollView.getScrollY();
    this.a.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(), 5L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nqa
 * JD-Core Version:    0.7.0.1
 */