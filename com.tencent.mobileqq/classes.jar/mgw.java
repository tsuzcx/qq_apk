import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.MultiIncomingCallUICtr.1.1;

public class mgw
  extends BroadcastReceiver
{
  mgw(mgv parammgv) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    long l = mwd.a(paramIntent);
    if (paramContext.equals("tencent.av.EXIT_QZONE_LIVE_RSP_ACTION")) {
      if (this.a.b == 1) {
        this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new MultiIncomingCallUICtr.1.1(this), 500L);
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          paramContext = lfb.a().a();
          this.a.a(l, paramContext);
          this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(67), Long.valueOf(this.a.jdField_a_of_type_Long), Integer.valueOf(3) });
        } while (this.a.jdField_a_of_type_Mnc == null);
        this.a.jdField_a_of_type_Mnc.a();
        return;
        if (paramContext.equals("tencent.video.invite.multiaccept"))
        {
          paramContext = lfb.a().a();
          this.a.a(l, paramContext);
          return;
        }
        if (!paramContext.equals("tencent.video.invite.multirefuse")) {
          break;
        }
      } while (this.a.b(0));
      this.a.a(l, true, null);
      return;
    } while (!paramContext.equals("tencent.video.destroyService"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mgw
 * JD-Core Version:    0.7.0.1
 */