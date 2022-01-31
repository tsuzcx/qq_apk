import com.tencent.biz.pubaccount.AccountDetailActivity;
import mqq.util.WeakReference;

public class nhz
  extends ajxj
{
  WeakReference<AccountDetailActivity> a;
  
  public nhz(AccountDetailActivity paramAccountDetailActivity)
  {
    this.a = new WeakReference(paramAccountDetailActivity);
  }
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    AccountDetailActivity localAccountDetailActivity = (AccountDetailActivity)this.a.get();
    if (localAccountDetailActivity == null) {}
    while ((localAccountDetailActivity.h) || (!paramBoolean) || (!paramString.equals(localAccountDetailActivity.d))) {
      return;
    }
    localAccountDetailActivity.P();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nhz
 * JD-Core Version:    0.7.0.1
 */