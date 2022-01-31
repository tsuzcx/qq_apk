import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.ui.CallbackWaitingActivityExt;

public class jro
  extends BroadcastReceiver
{
  jro(CallbackWaitingActivityExt paramCallbackWaitingActivityExt) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("android.intent.action.CLOSE_SYSTEM_DIALOGS"))
    {
      paramContext = paramIntent.getStringExtra("reason");
      if ((paramContext != null) && (paramContext.equals("homekey"))) {
        CallbackWaitingActivityExt.a(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jro
 * JD-Core Version:    0.7.0.1
 */