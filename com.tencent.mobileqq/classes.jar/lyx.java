import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.smallscreen.SmallScreenDialogActivity;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

public class lyx
  extends BroadcastReceiver
{
  public lyx(SmallScreenDialogActivity paramSmallScreenDialogActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("tencent.video.v2q.SmallScreenState"))
    {
      int i = paramIntent.getIntExtra("SmallScreenState", -1);
      long l = mtj.a(paramIntent);
      boolean bool = lze.c(this.a.a.getApp());
      if ((AudioHelper.e()) || (bool)) {
        QLog.w(SmallScreenDialogActivity.a(this.a), 1, "Receiver ACTION_SMALL_SCREEN_STATE, isFloatWindowOpAllowed[" + bool + "], state[" + i + "], seq[" + l + "]");
      }
      if (bool) {
        this.a.finish();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lyx
 * JD-Core Version:    0.7.0.1
 */