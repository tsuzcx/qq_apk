import com.tencent.mobileqq.activity.FriendProfileImageActivity;
import com.tencent.mobileqq.activity.FriendProfileImageModel;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ExtensionInfo;
import mqq.os.MqqHandler;

public class sry
  implements Runnable
{
  public sry(FriendProfileImageActivity paramFriendProfileImageActivity) {}
  
  public void run()
  {
    ExtensionInfo localExtensionInfo = ((FriendsManager)this.a.app.getManager(50)).a(this.a.a.b);
    if (localExtensionInfo != null) {
      ThreadManager.getUIHandler().post(new srz(this, localExtensionInfo));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sry
 * JD-Core Version:    0.7.0.1
 */