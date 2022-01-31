import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class lgp
  extends BroadcastReceiver
{
  lgp(lgo paramlgo) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramIntent = paramIntent.getAction();
    if (paramIntent.equals("com.tencent.av.ui.ConfigInfoTips.ACTION_IS_WRITE_CONFIG_INFO_TO_FILE")) {
      this.a.d(paramContext);
    }
    while (!paramIntent.equals("com.tencent.av.ui.ConfigInfoTips.ACTION_IS_GETTED_SHARP_CONFIG_PAYLOAD")) {
      return;
    }
    this.a.d(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lgp
 * JD-Core Version:    0.7.0.1
 */