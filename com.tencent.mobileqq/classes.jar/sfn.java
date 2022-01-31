import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.recent.DrawerFrame;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.subaccount.SubAccountControll;

public class sfn
  implements Runnable
{
  public sfn(Conversation paramConversation) {}
  
  public void run()
  {
    if ((Conversation.c(this.a)) && (this.a.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.a != null) && (!this.a.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.a.b()) && (SubAccountControll.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "sub.uin.all"))) {
      this.a.a(new sfo(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sfn
 * JD-Core Version:    0.7.0.1
 */