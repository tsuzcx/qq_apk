import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity;

public class spu
  implements DialogInterface.OnClickListener
{
  public spu(FriendProfileMoreInfoActivity paramFriendProfileMoreInfoActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.a.o = this.a.m;
    FriendProfileMoreInfoActivity.a(this.a, this.a.m);
    if (this.a.m)
    {
      this.a.a("0X80081E7", 4);
      return;
    }
    this.a.a("0X80081E4", 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     spu
 * JD-Core Version:    0.7.0.1
 */