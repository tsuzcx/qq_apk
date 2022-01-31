import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profile.ProfileCardInfo;

public class sph
  implements View.OnClickListener
{
  public sph(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.N();
    this.a.finish();
    if ((this.a.a.a != null) && (this.a.a.a.a) && (this.a.app != null) && (!"0".equals(this.a.app.getCurrentAccountUin()))) {
      this.a.app.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sph
 * JD-Core Version:    0.7.0.1
 */