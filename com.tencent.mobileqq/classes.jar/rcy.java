import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class rcy
  implements Runnable
{
  public rcy(AccountManageActivity paramAccountManageActivity) {}
  
  public void run()
  {
    try
    {
      if (this.a.app != null)
      {
        FriendsManager localFriendsManager = (FriendsManager)this.a.app.getManager(50);
        if (localFriendsManager != null) {
          AccountManageActivity.a(this.a, localFriendsManager.a(this.a.app.getCurrentAccountUin()));
        }
      }
      return;
    }
    catch (Exception localException)
    {
      do
      {
        localException.printStackTrace();
      } while (!QLog.isColorLevel());
      QLog.w("AccountManageActivity", 2, "showLogoutDialog getCard Exception! ");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rcy
 * JD-Core Version:    0.7.0.1
 */