import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.MultiIncomingCallsActivity;
import com.tencent.mobileqq.utils.AudioHelper;

public class mfd
  extends BroadcastReceiver
{
  public mfd(MultiIncomingCallsActivity paramMultiIncomingCallsActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("tencent.av.EXIT_QZONE_LIVE_RSP_ACTION"))
    {
      long l = AudioHelper.b();
      paramContext = lcb.a().a();
      this.a.a(l, "BroadcastReceiver_qzone", this.a.getIntent(), paramContext);
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(67), Long.valueOf(this.a.jdField_a_of_type_Long), Integer.valueOf(3) });
      this.a.b("BroadcastReceiver_qzone");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mfd
 * JD-Core Version:    0.7.0.1
 */