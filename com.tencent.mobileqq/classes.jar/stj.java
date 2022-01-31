import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity;

public class stj
  implements DialogInterface.OnClickListener
{
  public stj(FriendProfileMoreInfoActivity paramFriendProfileMoreInfoActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    FriendProfileMoreInfoActivity.a(this.a, true);
    this.a.a("0X80081E6", 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     stj
 * JD-Core Version:    0.7.0.1
 */