import com.tencent.mobileqq.activity.FriendProfileImageActivity;
import com.tencent.mobileqq.activity.FriendProfileImageModel;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ExtensionInfo;
import mqq.os.MqqHandler;

public class soz
  implements Runnable
{
  public soz(FriendProfileImageActivity paramFriendProfileImageActivity) {}
  
  public void run()
  {
    ExtensionInfo localExtensionInfo = ((FriendsManager)this.a.app.getManager(50)).a(this.a.a.b);
    if (localExtensionInfo != null) {
      ThreadManager.getUIHandler().post(new spa(this, localExtensionInfo));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     soz
 * JD-Core Version:    0.7.0.1
 */