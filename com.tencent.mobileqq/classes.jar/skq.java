import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.widgets.InputDialog;
import com.tencent.mobileqq.activity.ForwardFriendListActivity;

public class skq
  implements DialogInterface.OnClickListener
{
  public skq(ForwardFriendListActivity paramForwardFriendListActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ForwardFriendListActivity.a(this.a).dismiss();
    ForwardFriendListActivity.a(this.a, ForwardFriendListActivity.a(this.a).getEditText());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     skq
 * JD-Core Version:    0.7.0.1
 */