import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.NotificationActivity;

public class tcp
  implements DialogInterface.OnClickListener
{
  public tcp(NotificationActivity paramNotificationActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    NotificationActivity.a(this.a, NotificationActivity.b(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tcp
 * JD-Core Version:    0.7.0.1
 */