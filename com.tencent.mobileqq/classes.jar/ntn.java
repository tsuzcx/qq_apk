import com.tencent.biz.pubaccount.AccountDetailActivity;
import mqq.util.WeakReference;

public class ntn
  extends anmu
{
  WeakReference<AccountDetailActivity> a;
  
  public ntn(AccountDetailActivity paramAccountDetailActivity)
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
    localAccountDetailActivity.R();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ntn
 * JD-Core Version:    0.7.0.1
 */