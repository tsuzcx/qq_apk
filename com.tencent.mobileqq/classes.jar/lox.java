import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyRequestParams.Request0x68bParams;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.HashMap;
import java.util.List;

public class lox
  implements Runnable
{
  public lox(ArticleInfoModule paramArticleInfoModule, ReadInJoyRequestParams.Request0x68bParams paramRequest0x68bParams) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyRequestParams$Request0x68bParams.jdField_a_of_type_Int = 5;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyRequestParams$Request0x68bParams.jdField_a_of_type_Boolean = true;
    ToServiceMsg localToServiceMsg = ArticleInfoModule.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyRequestParams$Request0x68bParams);
    HashMap localHashMap;
    if (localToServiceMsg != null)
    {
      localToServiceMsg.getAttributes().put("channelID", new Integer(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyRequestParams$Request0x68bParams.jdField_b_of_type_Int));
      localToServiceMsg.getAttributes().put("isSingleHighLight", Boolean.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyRequestParams$Request0x68bParams.g));
      localToServiceMsg.getAttributes().put("clientSwithes", Integer.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyRequestParams$Request0x68bParams.f));
      localHashMap = localToServiceMsg.getAttributes();
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyRequestParams$Request0x68bParams.jdField_b_of_type_JavaUtilList == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyRequestParams$Request0x68bParams.jdField_b_of_type_JavaUtilList.isEmpty())) {
        break label176;
      }
    }
    label176:
    for (boolean bool = true;; bool = false)
    {
      localHashMap.put("isRedRefreshReq", Boolean.valueOf(bool));
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProtocolReadInJoyRequestParams$Request0x68bParams.jdField_b_of_type_Int == 0) && (ReadInJoyUtils.a())) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a(-1L, 1, 0);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a(localToServiceMsg);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lox
 * JD-Core Version:    0.7.0.1
 */