import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.activity.FriendProfileImageModel.InfoUpdateListener;
import com.tencent.mobileqq.activity.FriendProfileImageModel.ProfileImageInfo;
import java.lang.ref.WeakReference;

public class ktp
  implements FriendProfileImageModel.InfoUpdateListener
{
  WeakReference a;
  
  public ktp(AccountDetailActivity paramAccountDetailActivity)
  {
    this.a = new WeakReference(paramAccountDetailActivity);
  }
  
  public void a(FriendProfileImageModel.ProfileImageInfo paramProfileImageInfo)
  {
    if ((this.a == null) || (this.a.get() == null)) {
      return;
    }
    ((AccountDetailActivity)this.a.get()).a(paramProfileImageInfo);
    ((AccountDetailActivity)this.a.get()).N();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ktp
 * JD-Core Version:    0.7.0.1
 */