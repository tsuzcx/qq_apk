import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.phonelogin.PhoneNumLoginImpl;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountManager;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.MobileQQ;

public class tdl
  implements DialogInterface.OnClickListener
{
  public tdl(NotificationActivity paramNotificationActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.finish();
    Bundle localBundle = new Bundle();
    localBundle.putString("password", null);
    if (!PhoneNumLoginImpl.a().a(this.a.app, this.a.app.getCurrentAccountUin()))
    {
      this.a.app.updateSubAccountLogin(this.a.app.getCurrentAccountUin(), false);
      this.a.app.getApplication().refreAccountList();
    }
    paramDialogInterface = (SubAccountManager)this.a.app.getManager(60);
    if (paramDialogInterface != null) {}
    for (paramDialogInterface = paramDialogInterface.a();; paramDialogInterface = null)
    {
      if ((paramDialogInterface != null) && (paramDialogInterface.size() > 0))
      {
        paramDialogInterface = paramDialogInterface.iterator();
        while (paramDialogInterface.hasNext())
        {
          String str = (String)paramDialogInterface.next();
          if (!PhoneNumLoginImpl.a().a(this.a.app, str))
          {
            this.a.app.updateSubAccountLogin(str, false);
            this.a.app.getApplication().refreAccountList();
          }
        }
      }
      this.a.startActivity(new Intent(this.a, LoginActivity.class).putExtras(localBundle).addFlags(67108864));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tdl
 * JD-Core Version:    0.7.0.1
 */