import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.FavEmosmManageActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emosm.favroaming.FavroamingDBManager;

public class sms
  extends BroadcastReceiver
{
  public sms(FavEmosmManageActivity paramFavEmosmManageActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("com.tencent.mobileqq.action.update.emotiom".equals(paramIntent.getAction())) {
      ((FavroamingDBManager)this.a.app.getManager(148)).a(new smt(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sms
 * JD-Core Version:    0.7.0.1
 */