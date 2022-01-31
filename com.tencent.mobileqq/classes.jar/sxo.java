import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity;

public class sxo
  implements DialogInterface.OnClickListener
{
  public sxo(FriendProfileMoreInfoActivity paramFriendProfileMoreInfoActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.a.n = this.a.l;
    FriendProfileMoreInfoActivity.a(this.a, this.a.l);
    if (this.a.l)
    {
      this.a.a("0X80081E7", 4);
      return;
    }
    this.a.a("0X80081E4", 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sxo
 * JD-Core Version:    0.7.0.1
 */