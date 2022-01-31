import com.tencent.biz.pubaccount.readinjoy.engine.WeishiManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;

public class lnb
  implements Runnable
{
  public lnb(WeishiManager paramWeishiManager, QQMessageFacade paramQQMessageFacade, String paramString, long paramLong) {}
  
  public void run()
  {
    MessageRecord localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.b(AppConstants.aH, 1008);
    if (localMessageRecord != null) {}
    for (localMessageRecord = WeishiManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineWeishiManager, localMessageRecord, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long);; localMessageRecord = WeishiManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineWeishiManager, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long))
    {
      if (localMessageRecord != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(localMessageRecord, WeishiManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineWeishiManager).c());
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lnb
 * JD-Core Version:    0.7.0.1
 */