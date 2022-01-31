import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;

public class rie
  implements DialogInterface.OnClickListener
{
  public rie(AddFriendLogicActivity paramAddFriendLogicActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (AddFriendLogicActivity.d(this.a) == 1)
    {
      this.a.finish();
      return;
    }
    AddFriendLogicActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rie
 * JD-Core Version:    0.7.0.1
 */