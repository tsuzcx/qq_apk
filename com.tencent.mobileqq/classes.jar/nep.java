import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.avgame.ui.AVGameActivity;
import com.tencent.qphone.base.util.QLog;

public class nep
  extends BroadcastReceiver
{
  public nep(AVGameActivity paramAVGameActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    try
    {
      QLog.d("AVGameActivity", 1, "mShareResultReceiver onReceive");
      if (paramIntent == null) {
        return;
      }
      paramContext = paramIntent.getAction();
      if (paramContext == null) {
        return;
      }
      if (!"com.tencent.mobileqq.app.avgameshare.avgameshareutil".equals(paramContext)) {
        return;
      }
      if (paramIntent.getBooleanExtra("avgame_share_result_success", false))
      {
        QLog.i("AVGameActivity", 1, "mShareResultReceiver onReceive success");
        this.a.e();
        return;
      }
    }
    catch (Exception paramContext)
    {
      QLog.e("AVGameActivity", 1, "onReceive error: " + paramContext.getMessage());
      return;
    }
    QLog.i("AVGameActivity", 1, "mShareResultReceiver onReceive fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     nep
 * JD-Core Version:    0.7.0.1
 */