import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.config.ConfigInfo;

class mce
  extends BroadcastReceiver
{
  mce(mcd parammcd) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramIntent = paramIntent.getAction();
    if (paramIntent.equals("com.tencent.av.ui.ConfigInfoTips.ACTION_IS_WRITE_CONFIG_INFO_TO_FILE"))
    {
      if (!mcd.a(this.a))
      {
        mcd.a(this.a, true);
        if (mcd.b(this.a)) {
          mcd.a(this.a);
        }
      }
      int i = ConfigInfo.getSharpConfigVersionFromFile(paramContext);
      lvy.a().a("update", i);
    }
    do
    {
      do
      {
        return;
      } while ((!paramIntent.equals("com.tencent.av.ui.ConfigInfoTips.ACTION_IS_GETTED_SHARP_CONFIG_PAYLOAD")) || (mcd.b(this.a)));
      mcd.b(this.a, true);
    } while (!mcd.a(this.a));
    mcd.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mce
 * JD-Core Version:    0.7.0.1
 */