import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;

public class llu
  implements Runnable
{
  public llu(KandianMergeManager paramKandianMergeManager, QQMessageFacade paramQQMessageFacade, String paramString1, String paramString2, int paramInt, boolean paramBoolean) {}
  
  public void run()
  {
    MessageRecord localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.b(AppConstants.as, 7220);
    if (localMessageRecord != null) {}
    for (localMessageRecord = KandianMergeManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager, localMessageRecord, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean);; localMessageRecord = KandianMergeManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_Int))
    {
      if (localMessageRecord != null)
      {
        ReadInJoyUtils.a(localMessageRecord);
        this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(localMessageRecord, KandianMergeManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager).c());
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     llu
 * JD-Core Version:    0.7.0.1
 */