import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.MultiIncomingCallUICtr.1.1;

public class lts
  extends BroadcastReceiver
{
  lts(ltr paramltr) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    long l = min.a(paramIntent);
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
          paramContext = ksn.a().a();
          this.a.a(l, paramContext);
          this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(67), Long.valueOf(this.a.jdField_a_of_type_Long), Integer.valueOf(3) });
        } while (this.a.jdField_a_of_type_Lzu == null);
        this.a.jdField_a_of_type_Lzu.a();
        return;
        if (paramContext.equals("tencent.video.invite.multiaccept"))
        {
          paramContext = ksn.a().a();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lts
 * JD-Core Version:    0.7.0.1
 */