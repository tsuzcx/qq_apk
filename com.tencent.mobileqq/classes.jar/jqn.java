import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.smallscreen.SmallScreenActivityPlugin;
import com.tencent.av.ui.AVActivity;
import com.tencent.mobileqq.statistics.ReportController;

public class jqn
  extends BroadcastReceiver
{
  jqn(AVActivity paramAVActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("android.intent.action.CLOSE_SYSTEM_DIALOGS"))
    {
      paramContext = paramIntent.getStringExtra("reason");
      if ((paramContext != null) && (this.a.a != null) && (paramContext.equals("homekey")))
      {
        if (this.a.a.a().d == 4)
        {
          if (this.a.d != 3000) {
            break label237;
          }
          if (!this.a.a.a().f) {
            break label210;
          }
          ReportController.b(null, "CliOper", "", "", "0X80041BB", "0X80041BB", 0, 0, "", "", "", "");
        }
        if (this.a.g)
        {
          if (!this.a.a.a().f) {
            break label424;
          }
          ReportController.b(null, "CliOper", "", "", "0X8005216", "0X8005216", 0, 0, "", "", "", "");
        }
      }
    }
    for (;;)
    {
      if (AVActivity.a(this.a) != null) {
        AVActivity.a(this.a).b(this.a.isResume());
      }
      this.a.a.a("backgroundReason", "1");
      com.tencent.av.VideoConstants.ProcessInfo.a = "1";
      return;
      label210:
      ReportController.b(null, "CliOper", "", "", "0X80041BE", "0X80041BE", 0, 0, "", "", "", "");
      break;
      label237:
      if (this.a.d != 1) {
        break;
      }
      if (this.a.a.a().f)
      {
        if (this.a.a.a().D == 10)
        {
          ReportController.b(null, "CliOper", "", "", "0X800593E", "0X800593E", 0, 0, "", "", "", "");
          break;
        }
        ReportController.b(null, "CliOper", "", "", "0X80046E8", "0X80046E8", 0, 0, "", "", "", "");
        break;
      }
      if (!this.a.a.a().g) {
        break;
      }
      if (this.a.a.a().D == 10)
      {
        ReportController.b(null, "CliOper", "", "", "0X8005941", "0X8005941", 0, 0, "", "", "", "");
        break;
      }
      ReportController.b(null, "CliOper", "", "", "0X80046EB", "0X80046EB", 0, 0, "", "", "", "");
      break;
      label424:
      ReportController.b(null, "CliOper", "", "", "0X8005219", "0X8005219", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jqn
 * JD-Core Version:    0.7.0.1
 */