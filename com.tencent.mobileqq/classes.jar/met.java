import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.config.ConfigInfo;

class met
  extends BroadcastReceiver
{
  met(mes parammes) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramIntent = paramIntent.getAction();
    if (paramIntent.equals("com.tencent.av.ui.ConfigInfoTips.ACTION_IS_WRITE_CONFIG_INFO_TO_FILE"))
    {
      if (!mes.a(this.a))
      {
        mes.a(this.a, true);
        if (mes.b(this.a)) {
          mes.a(this.a);
        }
      }
      int i = ConfigInfo.getSharpConfigVersionFromFile(paramContext);
      lyf.a().a("update", i);
    }
    do
    {
      do
      {
        return;
      } while ((!paramIntent.equals("com.tencent.av.ui.ConfigInfoTips.ACTION_IS_GETTED_SHARP_CONFIG_PAYLOAD")) || (mes.b(this.a)));
      mes.b(this.a, true);
    } while (!mes.a(this.a));
    mes.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     met
 * JD-Core Version:    0.7.0.1
 */