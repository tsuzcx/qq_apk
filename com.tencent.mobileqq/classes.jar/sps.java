import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity;

public class sps
  implements DialogInterface.OnDismissListener
{
  public sps(FriendProfileMoreInfoActivity paramFriendProfileMoreInfoActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.a(FriendProfileMoreInfoActivity.a(this.a), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sps
 * JD-Core Version:    0.7.0.1
 */