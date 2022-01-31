import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.ui.EffectSettingUi;

public class juc
  extends BroadcastReceiver
{
  public juc(EffectSettingUi paramEffectSettingUi) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("com.tencent.redpoint.broadcast.push.av")) {
      EffectSettingUi.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     juc
 * JD-Core Version:    0.7.0.1
 */