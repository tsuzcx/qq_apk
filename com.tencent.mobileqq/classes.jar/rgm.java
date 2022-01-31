import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountManager;

public class rgm
  implements Runnable
{
  public rgm(AccountManageActivity paramAccountManageActivity) {}
  
  public void run()
  {
    long l = this.a.app.a();
    SubAccountManager localSubAccountManager = (SubAccountManager)this.a.app.getManager(60);
    this.a.runOnUiThread(new rgn(this, l));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rgm
 * JD-Core Version:    0.7.0.1
 */