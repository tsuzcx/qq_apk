import com.tencent.biz.pubaccount.AccountDetailActivity;
import java.lang.ref.WeakReference;

public class nif
  implements abgl
{
  WeakReference<AccountDetailActivity> a;
  
  public nif(AccountDetailActivity paramAccountDetailActivity)
  {
    this.a = new WeakReference(paramAccountDetailActivity);
  }
  
  public void a(abgm paramabgm)
  {
    if ((this.a == null) || (this.a.get() == null)) {
      return;
    }
    ((AccountDetailActivity)this.a.get()).a(paramabgm);
    ((AccountDetailActivity)this.a.get()).P();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nif
 * JD-Core Version:    0.7.0.1
 */