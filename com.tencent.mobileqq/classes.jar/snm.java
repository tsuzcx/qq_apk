import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.VipUtils;

public class snm
  implements DialogInterface.OnClickListener
{
  public snm(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a.f == 1) {
      VipUtils.a(this.a, 1, ProfileCardUtil.a(3));
    }
    for (;;)
    {
      this.a.L();
      return;
      if (this.a.f == 2) {
        VipUtils.b(this.a, 1, ProfileCardUtil.a(6));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     snm
 * JD-Core Version:    0.7.0.1
 */