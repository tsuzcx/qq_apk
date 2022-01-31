import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profile.ProfileCardInfo;

public class suf
  implements Runnable
{
  public suf(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public void run()
  {
    ((FriendsManager)this.a.app.getManager(50)).a(this.a.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     suf
 * JD-Core Version:    0.7.0.1
 */