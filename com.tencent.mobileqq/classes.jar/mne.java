import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class mne
  extends BroadcastReceiver
{
  mne(mnd parammnd) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    long l;
    if (paramIntent != null)
    {
      paramContext = paramIntent.getAction();
      l = mwd.a(paramIntent);
      if (!paramContext.equals("tencent.video.invite.accept")) {
        break label32;
      }
      this.a.a(l);
    }
    label32:
    do
    {
      return;
      if (paramContext.equals("tencent.video.invite.refuse"))
      {
        this.a.b(l);
        return;
      }
      if (paramContext.equals("tencent.video.invite.gaaccept"))
      {
        this.a.d(l);
        return;
      }
      if (paramContext.equals("tencent.video.invite.gaignore"))
      {
        this.a.c(l);
        return;
      }
    } while (!paramContext.equals("tencent.video.q2v.sdk.onRequestVideo"));
    QLog.d("VideoInviteFloatBarUICtr", 1, "onReceive action = " + paramContext);
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mne
 * JD-Core Version:    0.7.0.1
 */