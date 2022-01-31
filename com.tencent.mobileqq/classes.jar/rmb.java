import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.os.MqqHandler;

public class rmb
  implements Runnable
{
  public rmb(BaseChatPie paramBaseChatPie) {}
  
  public void run()
  {
    ((FriendsManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).b();
    this.a.jdField_a_of_type_MqqOsMqqHandler.sendMessage(this.a.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(64));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rmb
 * JD-Core Version:    0.7.0.1
 */