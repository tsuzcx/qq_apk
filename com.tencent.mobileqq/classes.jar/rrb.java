import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;

public class rrb
  implements Runnable
{
  public rrb(BaseChatPie paramBaseChatPie, long paramLong1, int paramInt1, long paramLong2, int paramInt2, Runnable paramRunnable) {}
  
  public void run()
  {
    MessageRecord localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_Long);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().runOnUiThread(new rrc(this, localMessageRecord));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rrb
 * JD-Core Version:    0.7.0.1
 */