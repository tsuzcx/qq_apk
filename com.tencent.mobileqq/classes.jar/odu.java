import com.tencent.biz.pubaccount.AccountDetailActivity;
import java.lang.ref.WeakReference;

public class odu
  implements aebc
{
  WeakReference<AccountDetailActivity> a;
  
  public odu(AccountDetailActivity paramAccountDetailActivity)
  {
    this.a = new WeakReference(paramAccountDetailActivity);
  }
  
  public void a(aebd paramaebd)
  {
    if ((this.a == null) || (this.a.get() == null)) {
      return;
    }
    ((AccountDetailActivity)this.a.get()).a(paramaebd);
    ((AccountDetailActivity)this.a.get()).S();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     odu
 * JD-Core Version:    0.7.0.1
 */