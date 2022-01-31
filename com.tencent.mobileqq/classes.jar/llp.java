import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;

public class llp
  implements Runnable
{
  public llp(KandianMergeManager paramKandianMergeManager, String paramString, int paramInt) {}
  
  public void run()
  {
    SessionInfo localSessionInfo = new SessionInfo();
    localSessionInfo.jdField_a_of_type_JavaLangString = AppConstants.ar;
    localSessionInfo.jdField_a_of_type_Int = 1008;
    ChatActivityFacade.a(KandianMergeManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager), localSessionInfo);
    KandianMergeManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager).a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, false, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     llp
 * JD-Core Version:    0.7.0.1
 */