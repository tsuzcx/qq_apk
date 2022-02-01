import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.config.ConfigInfo;

class mcs
  extends BroadcastReceiver
{
  mcs(mcr parammcr) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramIntent = paramIntent.getAction();
    if (paramIntent.equals("com.tencent.av.ui.ConfigInfoTips.ACTION_IS_WRITE_CONFIG_INFO_TO_FILE"))
    {
      if (!mcr.a(this.a))
      {
        mcr.a(this.a, true);
        if (mcr.b(this.a)) {
          mcr.a(this.a);
        }
      }
      int i = ConfigInfo.getSharpConfigVersionFromFile(paramContext);
      lwd.a().a("update", i);
    }
    do
    {
      do
      {
        return;
      } while ((!paramIntent.equals("com.tencent.av.ui.ConfigInfoTips.ACTION_IS_GETTED_SHARP_CONFIG_PAYLOAD")) || (mcr.b(this.a)));
      mcr.b(this.a, true);
    } while (!mcr.a(this.a));
    mcr.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mcs
 * JD-Core Version:    0.7.0.1
 */