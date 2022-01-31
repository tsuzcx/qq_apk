import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.mobileqq.utils.DBUtils;
import com.tencent.qphone.base.util.QLog;

public class reg
  implements Runnable
{
  public reg(AccountManageActivity paramAccountManageActivity) {}
  
  public void run()
  {
    int i;
    if (this.a.app.a().a().b(AppConstants.w, 7000) != null)
    {
      i = DBUtils.a().a(this.a.app.getCurrentAccountUin());
      if (i >= 3) {
        if (QLog.isColorLevel()) {
          QLog.d("AccountManageActivity", 2, "refreshSubAccount() set stick2top fail." + this.a.app.getCurrentAccountUin() + " count=" + i + " >=max_stick2top_count , return.");
        }
      }
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("AccountManageActivity", 2, "refreshSubAccount() RecentList has default subAccount RU. go 2 stick2Top, current count=" + i);
      }
      SubAccountControll.a(this.a.app, AppConstants.w, true);
      DBUtils.a().a(this.a.app.getCurrentAccountUin(), i);
      return;
      DBUtils.a().a(this.a.app.getCurrentAccountUin(), 3);
    } while (!QLog.isColorLevel());
    QLog.d("SUB_ACCOUNT", 2, "recent list does not exist ruDefault.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     reg
 * JD-Core Version:    0.7.0.1
 */