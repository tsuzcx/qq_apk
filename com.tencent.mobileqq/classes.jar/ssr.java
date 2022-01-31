import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity;

public class ssr
  implements DialogInterface.OnDismissListener
{
  public ssr(FriendProfileMoreInfoActivity paramFriendProfileMoreInfoActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.a(FriendProfileMoreInfoActivity.a(this.a), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ssr
 * JD-Core Version:    0.7.0.1
 */