import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.SessionMgr;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.MultiIncomingCallsActivity;

public class jvj
  extends BroadcastReceiver
{
  public jvj(MultiIncomingCallsActivity paramMultiIncomingCallsActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("tencent.av.EXIT_QZONE_LIVE_RSP_ACTION"))
    {
      paramContext = SessionMgr.a().a();
      this.a.a("BroadcastReceiver_qzone", this.a.getIntent(), paramContext);
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(67), Long.valueOf(this.a.jdField_a_of_type_Long), Integer.valueOf(3) });
      this.a.b("BroadcastReceiver_qzone");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jvj
 * JD-Core Version:    0.7.0.1
 */