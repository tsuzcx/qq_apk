import com.tencent.mobileqq.activity.AddFriendVerifyActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ContactUtils;

public class rnd
  implements Runnable
{
  public rnd(AddFriendVerifyActivity paramAddFriendVerifyActivity) {}
  
  public void run()
  {
    this.a.d(ContactUtils.f(this.a.app, this.a.app.getCurrentAccountUin()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rnd
 * JD-Core Version:    0.7.0.1
 */