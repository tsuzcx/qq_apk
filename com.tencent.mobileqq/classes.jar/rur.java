import com.tencent.mobileqq.activity.ChatActivityFacade.SendMsgParams;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;

public final class rur
  implements Runnable
{
  public rur(ChatActivityFacade.SendMsgParams paramSendMsgParams, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityFacade$SendMsgParams.a) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().f(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rur
 * JD-Core Version:    0.7.0.1
 */