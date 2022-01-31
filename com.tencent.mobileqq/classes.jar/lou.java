import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyRequestParams.Request0x68bParams;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.HashMap;

public class lou
  implements Runnable
{
  public lou(ArticleInfoModule paramArticleInfoModule, ReadInJoyRequestParams.Request0x68bParams paramRequest0x68bParams) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyRequestParams$Request0x68bParams.jdField_a_of_type_Int = 5;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyRequestParams$Request0x68bParams.jdField_a_of_type_Boolean = true;
    ToServiceMsg localToServiceMsg = ArticleInfoModule.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyRequestParams$Request0x68bParams);
    if (localToServiceMsg != null)
    {
      localToServiceMsg.getAttributes().put("channelID", new Integer(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyRequestParams$Request0x68bParams.b));
      localToServiceMsg.getAttributes().put("isSingleHighLight", Boolean.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyRequestParams$Request0x68bParams.g));
      localToServiceMsg.getAttributes().put("clientSwithes", Integer.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyRequestParams$Request0x68bParams.f));
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyRequestParams$Request0x68bParams.b == 0) && (ReadInJoyUtils.a())) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a(-1L, 1, 0);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a(localToServiceMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lou
 * JD-Core Version:    0.7.0.1
 */