import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.avgame.ui.AvGameLoadingActivity;
import com.tencent.qphone.base.util.QLog;

public class nfl
  extends BroadcastReceiver
{
  public nfl(AvGameLoadingActivity paramAvGameLoadingActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    QLog.d("AvGameManagerAvGameLoadingActivity", 2, "receive broadcast");
    if ("com.tencent.avgame.ui.AvGameLoadingActivity.ACTION_LOADING_FINISH".equals(paramContext))
    {
      nfu.a().a("param_StepLoading", 0);
      AvGameLoadingActivity.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     nfl
 * JD-Core Version:    0.7.0.1
 */