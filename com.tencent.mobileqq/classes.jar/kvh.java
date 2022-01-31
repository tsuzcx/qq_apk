import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.activity.FriendProfileImageModel.InfoUpdateListener;
import com.tencent.mobileqq.activity.FriendProfileImageModel.ProfileImageInfo;
import java.lang.ref.WeakReference;

public class kvh
  implements FriendProfileImageModel.InfoUpdateListener
{
  WeakReference a;
  
  public kvh(AccountDetailActivity paramAccountDetailActivity)
  {
    this.a = new WeakReference(paramAccountDetailActivity);
  }
  
  public void a(FriendProfileImageModel.ProfileImageInfo paramProfileImageInfo)
  {
    if ((this.a == null) || (this.a.get() == null)) {
      return;
    }
    ((AccountDetailActivity)this.a.get()).a(paramProfileImageInfo);
    ((AccountDetailActivity)this.a.get()).O();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kvh
 * JD-Core Version:    0.7.0.1
 */