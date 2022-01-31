import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.multimsg.LongTextMsgManager;
import com.tencent.qphone.base.util.QLog;

public final class ruq
  implements Runnable
{
  public ruq(boolean paramBoolean, QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage) {}
  
  public void run()
  {
    try
    {
      if (this.jdField_a_of_type_Boolean)
      {
        ((LongTextMsgManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(165)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, false);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, null);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ChatActivityFacade", 1, "life circle2:", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ruq
 * JD-Core Version:    0.7.0.1
 */