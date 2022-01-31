import com.tencent.biz.pubaccount.readinjoy.engine.WeishiManager;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;

public class lna
  implements Runnable
{
  public lna(WeishiManager paramWeishiManager) {}
  
  public void run()
  {
    if (WeishiManager.a(this.a) == null) {
      return;
    }
    SessionInfo localSessionInfo = new SessionInfo();
    localSessionInfo.jdField_a_of_type_JavaLangString = AppConstants.aH;
    localSessionInfo.jdField_a_of_type_Int = 1008;
    ChatActivityFacade.a(WeishiManager.a(this.a), localSessionInfo);
    WeishiManager.a(this.a).a().c(AppConstants.aH, 1008);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lna
 * JD-Core Version:    0.7.0.1
 */