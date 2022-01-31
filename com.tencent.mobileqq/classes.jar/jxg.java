import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.tencent.av.SessionMgr;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.MultiIncomingCallUICtr;
import com.tencent.av.ui.VideoInviteFloatBar;

public class jxg
  extends BroadcastReceiver
{
  public jxg(MultiIncomingCallUICtr paramMultiIncomingCallUICtr) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext.equals("tencent.av.EXIT_QZONE_LIVE_RSP_ACTION")) {
      if (this.a.b == 1) {
        this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new jxh(this), 500L);
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          paramContext = SessionMgr.a().a();
          this.a.a(paramContext);
          this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(67), Long.valueOf(this.a.jdField_a_of_type_Long), Integer.valueOf(3) });
        } while (this.a.jdField_a_of_type_ComTencentAvUiVideoInviteFloatBar == null);
        this.a.jdField_a_of_type_ComTencentAvUiVideoInviteFloatBar.a();
        return;
        if (paramContext.equals("tencent.video.invite.multiaccept"))
        {
          paramContext = SessionMgr.a().a();
          this.a.a(paramContext);
          return;
        }
        if (!paramContext.equals("tencent.video.invite.multirefuse")) {
          break;
        }
      } while (this.a.c(0));
      this.a.a(true, null);
      return;
    } while (!paramContext.equals("tencent.video.destroyService"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     jxg
 * JD-Core Version:    0.7.0.1
 */