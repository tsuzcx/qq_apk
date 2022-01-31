import com.tencent.mobileqq.activity.JoinDiscussionActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.qphone.base.util.QLog;

public class tal
  extends FriendListObserver
{
  public tal(JoinDiscussionActivity paramJoinDiscussionActivity) {}
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramString = ((FriendsManager)this.a.app.getManager(50)).c(this.a.a + "");
      if (paramString != null)
      {
        this.a.e = paramString.name;
        JoinDiscussionActivity.a(this.a);
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("IphoneTitleBarActivity", 2, "get owner name failed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tal
 * JD-Core Version:    0.7.0.1
 */