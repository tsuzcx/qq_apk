import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.ChatBackground;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class rqh
  implements Runnable
{
  rqh(rqg paramrqg) {}
  
  public void run()
  {
    try
    {
      Thread.sleep(2000L);
      this.a.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.jdField_a_of_type_Boolean = false;
      if (ChatBackground.a(this.a.a.jdField_a_of_type_AndroidContentContext, this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.a.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true, 7, this.a.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground)) {
        this.a.a.jdField_a_of_type_MqqOsMqqHandler.sendMessage(this.a.a.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(60, this.a.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable));
      }
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        QLog.e("Q.aio.BaseChatPie", 1, "", localInterruptedException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rqh
 * JD-Core Version:    0.7.0.1
 */