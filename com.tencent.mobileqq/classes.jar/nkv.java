import com.tencent.biz.pubaccount.AccountDetailActivity;
import mqq.util.WeakReference;

public class nkv
  extends altm
{
  WeakReference<AccountDetailActivity> a;
  
  public nkv(AccountDetailActivity paramAccountDetailActivity)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nkv
 * JD-Core Version:    0.7.0.1
 */