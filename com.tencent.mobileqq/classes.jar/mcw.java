import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.config.ConfigInfo;

class mcw
  extends BroadcastReceiver
{
  mcw(mcv parammcv) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramIntent = paramIntent.getAction();
    if (paramIntent.equals("com.tencent.av.ui.ConfigInfoTips.ACTION_IS_WRITE_CONFIG_INFO_TO_FILE"))
    {
      if (!mcv.a(this.a))
      {
        mcv.a(this.a, true);
        if (mcv.b(this.a)) {
          mcv.a(this.a);
        }
      }
      int i = ConfigInfo.getSharpConfigVersionFromFile(paramContext);
      lvz.a().a("update", i);
    }
    do
    {
      do
      {
        return;
      } while ((!paramIntent.equals("com.tencent.av.ui.ConfigInfoTips.ACTION_IS_GETTED_SHARP_CONFIG_PAYLOAD")) || (mcv.b(this.a)));
      mcv.b(this.a, true);
    } while (!mcv.a(this.a));
    mcv.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mcw
 * JD-Core Version:    0.7.0.1
 */