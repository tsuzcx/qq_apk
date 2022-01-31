import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.ChatBackground;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import java.io.File;
import mqq.os.MqqHandler;

public class rqg
  implements Runnable
{
  public rqg(BaseChatPie paramBaseChatPie) {}
  
  public void run()
  {
    if (ChatBackground.a(this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true, 3, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground)) {
      this.a.jdField_a_of_type_MqqOsMqqHandler.sendMessage(this.a.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(60, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.a));
    }
    if (ChatBackgroundManager.b(new File(ChatBackground.a(this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))) {
      ThreadManager.postImmediately(new rqh(this), null, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rqg
 * JD-Core Version:    0.7.0.1
 */