import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.ui.PSTNC2CActivity;

public class jyu
  extends BroadcastReceiver
{
  jyu(PSTNC2CActivity paramPSTNC2CActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("android.intent.action.CLOSE_SYSTEM_DIALOGS"))
    {
      paramContext = paramIntent.getStringExtra("reason");
      if ((paramContext != null) && (paramContext.equals("homekey")))
      {
        PSTNC2CActivity.b(this.a);
        this.a.finish();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jyu
 * JD-Core Version:    0.7.0.1
 */