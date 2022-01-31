import android.text.TextUtils;
import com.tencent.mobileqq.activity.AutoRemarkActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;

public class rlr
  implements Runnable
{
  public rlr(AutoRemarkActivity paramAutoRemarkActivity) {}
  
  public void run()
  {
    if (TextUtils.isEmpty(this.a.a)) {}
    while (((FriendsManager)this.a.app.getManager(50)).a(this.a.a) != null) {
      return;
    }
    ((FriendListHandler)this.a.app.a(1)).b(this.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rlr
 * JD-Core Version:    0.7.0.1
 */