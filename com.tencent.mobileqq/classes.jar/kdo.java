import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.ui.VideoInviteFloatBarUICtr;

public class kdo
  extends BroadcastReceiver
{
  public kdo(VideoInviteFloatBarUICtr paramVideoInviteFloatBarUICtr) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      paramContext = paramIntent.getAction();
      if (!paramContext.equals("tencent.video.invite.accept")) {
        break label26;
      }
      this.a.f();
    }
    label26:
    do
    {
      return;
      if (paramContext.equals("tencent.video.invite.refuse"))
      {
        this.a.g();
        return;
      }
      if (paramContext.equals("tencent.video.invite.gaaccept"))
      {
        this.a.i();
        return;
      }
    } while (!paramContext.equals("tencent.video.invite.gaignore"));
    this.a.h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     kdo
 * JD-Core Version:    0.7.0.1
 */