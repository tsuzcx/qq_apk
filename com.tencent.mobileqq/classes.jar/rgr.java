import com.tencent.mobileqq.activity.AddFriendVerifyActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class rgr
  implements Runnable
{
  public rgr(AddFriendVerifyActivity paramAddFriendVerifyActivity, String paramString) {}
  
  public void run()
  {
    String str = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.app.getManager(50)).a(AddFriendVerifyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity));
    ThreadManager.getUIHandler().post(new rgs(this, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rgr
 * JD-Core Version:    0.7.0.1
 */