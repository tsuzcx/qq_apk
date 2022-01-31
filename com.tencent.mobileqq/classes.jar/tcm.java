import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;

public class tcm
  implements DialogInterface.OnClickListener
{
  public tcm(NotificationActivity paramNotificationActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = "http://aq.qq.com/007?from=andapp&account=" + NotificationActivity.b(this.a);
    Intent localIntent = new Intent(this.a.getActivity(), QQBrowserActivity.class);
    this.a.startActivity(localIntent.putExtra("url", paramDialogInterface));
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tcm
 * JD-Core Version:    0.7.0.1
 */