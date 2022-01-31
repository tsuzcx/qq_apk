import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class syi
  implements Runnable
{
  public syi(MainFragment paramMainFragment) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SpecialCare", 2, "getSpecialRecommendStat=" + FriendListHandler.a);
    }
    if ((FriendListHandler.a == 0) || (FriendListHandler.a == 2) || (FriendListHandler.a == 3)) {}
    do
    {
      do
      {
        return;
        if (!MainFragment.a(this.a)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("SpecialCare", 2, "hasSpecialCareFriend=" + MainFragment.a(this.a));
      return;
    } while (MainFragment.a(this.a) == null);
    List localList = ((FriendsManager)MainFragment.a(this.a).getManager(50)).b();
    if ((localList != null) && (localList.size() > 0))
    {
      MainFragment.b(this.a, true);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SpecialCare", 2, "hasSpecialCareFriend=" + MainFragment.a(this.a));
    }
    ((FriendListHandler)MainFragment.a(this.a).a(1)).a(0, 10, null, true, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     syi
 * JD-Core Version:    0.7.0.1
 */