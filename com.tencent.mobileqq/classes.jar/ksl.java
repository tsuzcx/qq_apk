import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.qphone.base.util.QLog;

public class ksl
  implements Runnable
{
  public ksl(AccountDetailActivity paramAccountDetailActivity) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "initData loadDatabase");
    }
    AccountDetailActivity localAccountDetailActivity = this.a;
    if (!this.a.e()) {}
    for (boolean bool = true;; bool = false)
    {
      localAccountDetailActivity.e = bool;
      AccountDetailActivity.b(this.a, new ksm(this));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ksl
 * JD-Core Version:    0.7.0.1
 */