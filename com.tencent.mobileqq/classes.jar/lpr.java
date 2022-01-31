import android.app.Activity;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyChannelActivity;
import com.tencent.biz.pubaccount.readinjoy.engine.WeishiManager;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;

public class lpr
  implements Runnable
{
  public lpr(WeishiManager paramWeishiManager, Activity paramActivity) {}
  
  public void run()
  {
    if (WeishiManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineWeishiManager) == null) {}
    do
    {
      return;
      SessionInfo localSessionInfo = new SessionInfo();
      localSessionInfo.jdField_a_of_type_JavaLangString = AppConstants.aI;
      localSessionInfo.jdField_a_of_type_Int = 1008;
      ChatActivityFacade.a(WeishiManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineWeishiManager), localSessionInfo);
      WeishiManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineWeishiManager).a().c(AppConstants.aI, 1008);
    } while (!(this.jdField_a_of_type_AndroidAppActivity instanceof ReadInJoyChannelActivity));
    ((ReadInJoyChannelActivity)this.jdField_a_of_type_AndroidAppActivity).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lpr
 * JD-Core Version:    0.7.0.1
 */