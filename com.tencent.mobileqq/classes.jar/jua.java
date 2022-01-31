import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.config.ConfigInfo;
import com.tencent.av.report.TraeConfigUpdate;
import com.tencent.av.ui.ConfigInfoTips;

public class jua
  extends BroadcastReceiver
{
  public jua(ConfigInfoTips paramConfigInfoTips) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext.equals("com.tencent.av.ui.ConfigInfoTips.ACTION_IS_WRITE_CONFIG_INFO_TO_FILE"))
    {
      if (!ConfigInfoTips.a(this.a))
      {
        ConfigInfoTips.a(this.a, true);
        if (ConfigInfoTips.b(this.a)) {
          ConfigInfoTips.a(this.a);
        }
      }
      paramContext = ConfigInfo.instance();
      if (paramContext != null)
      {
        int i = paramContext.getSharpConfigVersionFromFile();
        TraeConfigUpdate.a().a("update", i);
      }
    }
    do
    {
      do
      {
        return;
      } while ((!paramContext.equals("com.tencent.av.ui.ConfigInfoTips.ACTION_IS_GETTED_SHARP_CONFIG_PAYLOAD")) || (ConfigInfoTips.b(this.a)));
      ConfigInfoTips.b(this.a, true);
      ConfigInfoTips.a(this.a, paramIntent.getIntExtra("version", 0));
    } while (!ConfigInfoTips.a(this.a));
    ConfigInfoTips.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     jua
 * JD-Core Version:    0.7.0.1
 */