import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule.Request0xb81Params;
import com.tencent.qphone.base.remote.ToServiceMsg;

public class lro
  implements Runnable
{
  public lro(ReadInJoyUserInfoModule paramReadInJoyUserInfoModule, ReadInJoyUserInfoModule.Request0xb81Params paramRequest0xb81Params) {}
  
  public void run()
  {
    ToServiceMsg localToServiceMsg = ReadInJoyUserInfoModule.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyUserInfoModule, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyUserInfoModule$Request0xb81Params);
    if (localToServiceMsg != null)
    {
      localToServiceMsg.addAttribute("user_info_uin_list_key", ReadInJoyUserInfoModule.Request0xb81Params.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyUserInfoModule$Request0xb81Params));
      localToServiceMsg.addAttribute("retry_request_count_key", Integer.valueOf(0));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyUserInfoModule.a(localToServiceMsg);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lro
 * JD-Core Version:    0.7.0.1
 */