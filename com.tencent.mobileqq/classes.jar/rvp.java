import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.ark.ArkRecommendController;
import com.tencent.mobileqq.data.ChatMessage;

public class rvp
  implements Runnable
{
  public rvp(BaseChatPie paramBaseChatPie, ChatMessage paramChatMessage, SessionInfo paramSessionInfo) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a != null) && (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rvp
 * JD-Core Version:    0.7.0.1
 */