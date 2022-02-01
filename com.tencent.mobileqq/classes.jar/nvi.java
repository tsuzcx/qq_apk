import com.tencent.biz.pubaccount.AccountDetailActivity;
import mqq.util.WeakReference;

public class nvi
  extends anyu
{
  WeakReference<AccountDetailActivity> a;
  
  public nvi(AccountDetailActivity paramAccountDetailActivity)
  {
    this.a = new WeakReference(paramAccountDetailActivity);
  }
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    AccountDetailActivity localAccountDetailActivity = (AccountDetailActivity)this.a.get();
    if (localAccountDetailActivity == null) {}
    while ((localAccountDetailActivity.h) || (!paramBoolean) || (!paramString.equals(localAccountDetailActivity.e))) {
      return;
    }
    localAccountDetailActivity.S();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nvi
 * JD-Core Version:    0.7.0.1
 */