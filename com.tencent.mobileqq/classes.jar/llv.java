import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.concurrent.atomic.AtomicInteger;

public class llv
  implements Runnable
{
  public llv(KandianMergeManager paramKandianMergeManager, MessageRecord paramMessageRecord) {}
  
  public void run()
  {
    KandianMergeManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager).a().a(AppConstants.as, 7220, false, false);
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.extInt == 2)
    {
      KandianMergeManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager).a().b(AppConstants.as, 7220, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq);
      if (KandianMergeManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager).get() > 0) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.c(2);
      }
    }
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.extInt == 1)
      {
        SessionInfo localSessionInfo = new SessionInfo();
        localSessionInfo.jdField_a_of_type_JavaLangString = AppConstants.ar;
        localSessionInfo.jdField_a_of_type_Int = 1008;
        ChatActivityFacade.a(KandianMergeManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager), localSessionInfo);
        return;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.extInt != 5);
    KandianMergeManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager).a().b(AppConstants.as, 7220, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     llv
 * JD-Core Version:    0.7.0.1
 */