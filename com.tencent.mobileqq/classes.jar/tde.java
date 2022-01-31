import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.NotificationActivity;

public class tde
  implements DialogInterface.OnClickListener
{
  public tde(NotificationActivity paramNotificationActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent("qqplayer_exit_action");
    this.a.sendBroadcast(paramDialogInterface);
    paramDialogInterface = new Bundle();
    paramDialogInterface.putString("password", null);
    this.a.startActivity(new Intent(this.a, LoginActivity.class).putExtras(paramDialogInterface).addFlags(67108864));
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tde
 * JD-Core Version:    0.7.0.1
 */